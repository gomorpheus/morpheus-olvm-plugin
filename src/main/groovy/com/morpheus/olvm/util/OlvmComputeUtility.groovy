package com.morpheus.olvm.util

import com.bertramlabs.plugins.karman.CloudFile
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.util.image.Qcow2InputStream
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.ComputeServerInterface
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import org.apache.http.HttpHost
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.impl.conn.DefaultProxyRoutePlanner
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.builders.CpuBuilder
import org.ovirt.engine.sdk4.builders.NicBuilder
import org.ovirt.engine.sdk4.internal.containers.ImageTransferContainer
import org.ovirt.engine.sdk4.internal.containers.SnapshotContainer
import org.ovirt.engine.sdk4.services.SystemService
import org.ovirt.engine.sdk4.types.DiskFormat
import org.ovirt.engine.sdk4.types.DiskInterface
import org.ovirt.engine.sdk4.types.DiskStatus
import org.ovirt.engine.sdk4.types.ImageTransferDirection
import org.ovirt.engine.sdk4.types.ImageTransferPhase
import org.ovirt.engine.sdk4.types.IpVersion
import org.ovirt.engine.sdk4.types.Nic
import org.ovirt.engine.sdk4.types.SnapshotStatus
import org.ovirt.engine.sdk4.types.TemplateStatus
import org.ovirt.engine.sdk4.types.VmStatus

import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import java.security.cert.X509Certificate

import static org.ovirt.engine.sdk4.ConnectionBuilder.connection
import static org.ovirt.engine.sdk4.builders.Builders.cluster
import static org.ovirt.engine.sdk4.builders.Builders.cpu
import static org.ovirt.engine.sdk4.builders.Builders.cpuTopology
import static org.ovirt.engine.sdk4.builders.Builders.disk
import static org.ovirt.engine.sdk4.builders.Builders.diskAttachment
import static org.ovirt.engine.sdk4.builders.Builders.image
import static org.ovirt.engine.sdk4.builders.Builders.imageTransfer
import static org.ovirt.engine.sdk4.builders.Builders.initialization
import static org.ovirt.engine.sdk4.builders.Builders.nic
import static org.ovirt.engine.sdk4.builders.Builders.snapshot
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain
import static org.ovirt.engine.sdk4.builders.Builders.template
import static org.ovirt.engine.sdk4.builders.Builders.vm
import static org.ovirt.engine.sdk4.builders.Builders.vnicProfile

@Slf4j
class OlvmComputeUtility {
    public static final Long DEFAULT_WAIT_TIMEOUT = 30l * 60l // 30 minute default
    private static Boolean proxySelectorConfigured = false

    static listDatacenters(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        try {
            Connection connection = opts.connection
            if (!connection) {
                connection = getConnection(opts.cloud)
            }
            rtn.data = [
                connection : connection,
                datacenters: connection.systemService().dataCentersService().list().send().dataCenters()
            ]
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to get datacenters: ${t.message}", t)
            rtn.error = "Unable to get datacenters: ${t.message}"
        }
        return rtn
    }

    static listClusters(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        try {
            Connection connection = opts.connection
            if (!connection) {
                connection = getConnection(opts.cloud)
            }
            rtn.data = [
                connection : connection,
                clusters: connection.systemService().clustersService().list().send().clusters()
            ]
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to get clusters: ${t.message}", t)
            rtn.error = "Unable to get clusters: ${t.message}"
        }
        return rtn
    }

    static listNetworks(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        try {
            Connection connection = opts.connection
            if (!connection) {
                connection = getConnection(opts.cloud)
            }
            rtn.data = [
                connection : connection,
                profiles: connection.systemService().vnicProfilesService().list().send().profiles()
            ]
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to get networks: ${t.message}", t)
            rtn.error = "Unable to get networks: ${t.message}"
        }
        return rtn
    }

    static listStorageDomains(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        try {
            Connection connection = opts.connection
            if (!connection) {
                connection = getConnection(opts.cloud)
            }
            rtn.data = [
                connection : connection,
                storageDomains: connection.systemService().storageDomainsService().list().send().storageDomains()
            ]
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to get storage domains: ${t.message}", t)
            rtn.error = "Unable to get storage domains: ${t.message}"
        }
        return rtn
    }

    static validateServerConfig(MorpheusContext morpheusContext, Map opts =[:]) {
        def rtn = [success:false, errors: []]
        try {
            def cloud = opts.cloud ?: morpheusContext.async.cloud.getCloudById(opts.zoneId?.toLong()).blockingGet()
            def configMap = cloud.configMap
            // Validate enough Elastic IPs left
            if(!configMap.datacenterId) {
                rtn.errors += [field: 'datacenterId', msg: 'You must choose a datacenter']
            }
            if(!configMap.datacenterId) {
                rtn.errors += [field: 'clusterId', msg: 'You must choose a cluster']
            }
            rtn.success = (rtn.errors.size() == 0)
            log.debug("validateServerConfig results: ${rtn}")
        }
        catch(e)  {
            log.error "error in validateServerConfig: ${e}", e
        }
        return rtn
    }

    static loadImage(opts) {
        def rtn = ServiceResponse.prepare()
        def closeConnection = false
        def connection = opts.connection

        try {
            if (!connection) {
                connection = OlvmComputeUtility.getConnection(opts.cloud)
            }

            def templateService = connection.systemService().templatesService()
            if (opts.imageName) {
                def templates =
                    templateService.list().search("name=${opts.imageName}").caseSensitive(false).send().templates()
                rtn.data = [template:templates?.first()]
            }
            else if (opts.imageId) {
                def template =
                    templateService.templateService(opts.imageId).get().send().template()
                rtn.data = [template:template]
            }
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to load image from OLVM cloud: ${t.message}")
            rtn.error = "Unable to load image from OLVM cloud: ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static insertImage(opts) {
        log.debug("createServer opts: ${opts}")
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection getConnection(opts.cloud)
                closeConnection = true
            }

            // first lets see if our image exists in olvm cloud
            def vi = opts.image.virtualImage
            def imageName = vi.name.replaceAll(' ', '_')
            def templatesService = connection.systemService().templatesService()
            def existing = templatesService.list().search("name=${imageName}".toString()).send().templates()
            if (existing.size() > 0) {
                rtn.success = true
                rtn.data = [imageRef:existing.first().id()]
            }
            else {
                // grab domain service for the storage domain we wish to use
                def storageDomainService = connection.systemService().storageDomainsService().storageDomainService(opts.storageDomainId)

                // grab the inputstream of our qcow file and wrap in QcowInputStream to get the size of the disk we need
                CloudFile cloudFile = opts.image.imageFile
                Qcow2InputStream qcowInputStream = new Qcow2InputStream(cloudFile.inputStream, true)
                def actualDiskSize = qcowInputStream.qcowHeader.size

                // create a blank disk
                def tmpDiskName = "morph_tmp_${opts.image.virtualImage.id}"
                def blank = storageDomainService.disksService().add().disk(
                    disk()
                        .name(tmpDiskName)
                        .format(DiskFormat.COW)
                        .provisionedSize(actualDiskSize)
                        .storageDomain(
                            storageDomain()
                                .id(opts.storageDomainId)
                        )
                ).send().disk()

                // Wait for disk to be ready before we start data transfer
                waitForSomeStuffToHappen([label: "Waiting for blank disk to be ready"]) {
                    def emptyDisk = connection.followLink(blank)
                    return emptyDisk.status() == DiskStatus.OK
                }

                // create an image transfer session
                def blankDiskId = blank.id()
                def xfersService = connection.systemService().imageTransfersService()
                def transferObj = xfersService.addForDisk().imageTransfer(
                    imageTransfer()
                        .direction(ImageTransferDirection.UPLOAD)
                        .inactivityTimeout(15 * 60) // in seconds
                        .image(
                            image()
                                .id(blankDiskId)
                        )
                ).send().imageTransfer()
                def xferId = transferObj.id()
                def xferService = xfersService.imageTransferService(xferId)

                // wait for the image transfer session to hit the transferring state
                ImageTransferContainer imageXfer
                waitForSomeStuffToHappen([label: "Waiting for image transfer to go TRANSFERRING"]) {
                    imageXfer = xferService.get().send().imageTransfer()
                    log.debug("Image transfer phase is ${imageXfer.phase()}")
                    return imageXfer.phase() == ImageTransferPhase.TRANSFERRING
                }

                // Now push the file contents of our qcow file to OLVM
                def transferUrl = new URL(imageXfer.proxyUrl())


                // TODO: should we use a progress input stream here to update as we upload?
                pushDataToTarget(qcowInputStream, transferUrl, connection)

                xferService.finalize_().send()

                // after we finalize the transfer wait for the image disk to be ok
                def disksService = connection.systemService().disksService()
                def diskService = disksService.diskService(blankDiskId)
                waitForSomeStuffToHappen([label: "Wait for disk ${blank.name()}"]) {
                    def d = diskService.get().send().disk()
                    log.debug("Disk ${d.name()}(${d.id()}) status is ${d.status()}")
                    actualDiskSize = d.actualSize()
                    return d.status() == DiskStatus.OK
                }

                // Next we need to create a temporary VM and attach our disk to it
                def vmsService = connection.systemService().vmsService()
                def newVm = vmsService.add().vm(
                    vm()
                        .name("morpheus-tmp-${opts.image.virtualImage.id}")
                        .cluster(
                            cluster()
                                .id(opts.clusterRef) // Specify the cluster where you want to create the VM
                        )
                        .diskAttachments(
                            diskAttachment()
                                .disk(
                                    disk()
                                        .id(blankDiskId)
                                )
                        )
                        .template(
                            template()
                                .name('Blank')
                        )
                ).send().vm()

                // wait for new VM to be ready
                waitForSomeStuffToHappen([label: "Waiting for vm ${newVm.name()} to be ready"]) {
                    def v = vmsService.vmService(newVm.id()).get().send().vm()
                    log.debug("Vm ${v.name()}(${v.id()}) status is ${v.status()}")
                    return v.status() == VmStatus.DOWN
                }

                // attach our disk to our temporary vm
                def diskAttachmentsService = vmsService.vmService(newVm.id()).diskAttachmentsService()
                def attachment = diskAttachmentsService.add()
                    .attachment(
                        diskAttachment()
                            .disk(
                                disk()
                                    .id(blankDiskId)
                            )
                            .interface_(DiskInterface.VIRTIO)
                            .bootable(true)
                            .active(true)
                    )
                    .send().attachment()

                // wait for disk attachment to completes
                diskService = disksService.diskService(attachment.disk().id())
                waitForSomeStuffToHappen([label: "Waiting disk ${blankDiskId} to be ready"]) {
                    def d = diskService.get().send().disk()
                    log.debug("Disk ${d.name()}(${d.id()}) status is ${d.status()}")
                    return d.status() == DiskStatus.OK
                }

                // create template from this vm
                def newTemplate = templatesService.add().template(
                    template()
                        .vm(
                            vm()
                                .id(newVm.id())
                        )
                        .name(imageName)
                ).send().template()

                // wait for template to be usable
                waitForSomeStuffToHappen([label: "Waiting for template ${imageName} to be ready"]) {
                    def t = templatesService.templateService(newTemplate.id()).get().send().template()
                    log.debug("Template ${t.name()}(${t.id()}) status is ${t.status()}")
                    return t.status() == TemplateStatus.OK
                }

                // once our template is ready for use, remove our temporary vm
                deleteServer([connection: connection, vmId: newVm.id()])

                rtn.data = [imageRef: newTemplate.id()]
                rtn.success = true
            }
        }
        catch(Throwable t) {
            log.error("Failed to create image template: ${t.message}", t)
            rtn.error = "Failed to create image template: ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static pushDataToTarget(Qcow2InputStream inputStream, URL url, Connection con) {
    //static pushDataToTarget(InputStream inputStream, URL url, Connection con) {
        HttpURLConnection connection
        try {
            // Install the all-trusting trust manager
            TrustManager[] trustAllCertificates = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
            }

            // Create a SSL context with the all-trusting manager
            SSLContext sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCertificates, new java.security.SecureRandom())

            // Install the SSL context into the HTTPS URL connection
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory())

            // Open a connection to the URL
            connection = (HttpURLConnection) url.openConnection()

            // Set connection properties
            connection.setRequestMethod("PUT")
            connection.setDoOutput(true); // Indicates that this connection will send data
            connection.setRequestProperty("Content-Type", "application/octet-stream")
            connection.setRequestProperty("Authorization", "Bearer ${con.authenticate()}".toString())

            // Get the OutputStream from the connection
            OutputStream outputStream = connection.getOutputStream()

            // Define a buffer for reading from the InputStream
            byte[] buffer = new byte[2048]
            int bytesRead

            // first write all the bytes cached by the Qcow2InputStream that were read to generate the qcow header
            outputStream.write(inputStream.qcowHeader.bytes)

            // Read from the InputStream and write to the OutputStream
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead)
            }

            inputStream.close()
            outputStream.close()

            // Get the response code
            int responseCode = connection.getResponseCode()
            log.info("Response Code: ${responseCode}")
        }
        finally {
            connection?.disconnect()
        }
    }

    static createServer(opts) {
        log.debug("createServer opts: ${opts}")
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection getConnection(opts.cloud)
                closeConnection = true
            }
            def imageRef = opts.imageRef
            def zoneRef = opts.zoneRef
            def networkRef = opts.subnetRef
            def count = opts.count ?: 1

            // grab api services we will need for vm creation
            def storagesService = connection.systemService().storageDomainsService()
            def templatesService = connection.systemService().templatesService()
            def vmsService = connection.systemService().vmsService()
            def diskAttachmentService = templatesService.templateService(imageRef).diskAttachmentsService()
            def rootAttachment = diskAttachmentService.list().send().attachments().first()
            def templateDisk = connection.followLink(rootAttachment.disk())

            // merge network interfaces
            def interfaces = [opts.networkConfig.primaryInterface]
            interfaces.addAll(opts.networkConfig.extraInterfaces)

            // send vm create to api
            def response = vmsService.add()
                .vm(
                    vm()
                    .name(opts.name)
                    .cluster(
                        cluster()
                        .id(opts.clusterRef)
                    )
                    .template(
                        template()
                        .id(imageRef)
                    )
                    .cpu(
                        buildCpus(opts.workloadConfig)
                    )
                    .memory(opts.maxMemory)
                    .diskAttachments(
                        diskAttachment()
                        .disk(
                            disk()
                            .id(templateDisk.id())
                            .provisionedSize(opts.rootVolume.maxStorage)
                            .storageDomains(
                                storageDomain()
                                .id(opts.rootVolume.datastore.externalId)
                            )
                        )
                    )
                    .nics(buildNetworkInterfaces(interfaces))
                )
                .send()
            def vmId = response.vm().id()
            rtn.data = [vmId:vmId]
            rtn.success = true
        }
        catch (Throwable t) {
            rtn.error = "Failed to provision vm ${opts.name}: ${t.message}"
            log.error("Failed to provision vm ${opts.name}: ${t.message}")
        }
        finally {
            if (closeConnection)
                connection.close()
        }
        return rtn
    }

    static startVmWithCloudInit(opts) {
        def rtn
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }
            def vmService = connection.systemService().vmsService().vmService(opts.server?.externalId ?: opts.vmId)
            vmService.start()
                .useCloudInit(true)
                .vm(
                    vm()
                    .initialization(
                        initialization()
                        .customScript(opts.cloudInitScript)
                    )
                )
                .send()

            rtn = waitForSomeStuffToHappen([label:"Start vm ${opts.server?.name}", timeout:(5l * 60l * 1000l)]) {
                return vmService.get().send().vm().status() == VmStatus.UP
            }
        }
        finally {
            if (closeConnection)
                connection?.close(0)
        }
        return rtn
    }

    static startVm(opts) {
        def rtn
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }
            def vmService = connection.systemService().vmsService().vmService(opts.server?.externalId ?: opts.vmId)
            vmService.start().send()

            // wait for the VM to be up
            rtn = waitForSomeStuffToHappen([label:"Start vm ${opts.server?.name}", timeout:(5l * 60l * 1000l)]) {
                return vmService.get().send().vm().status() == VmStatus.UP
            }
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static stopVm(opts) {
        def rtn
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }
            def vmService = connection.systemService().vmsService().vmService(opts.server?.externalId ?: opts.vmId)
            vmService.stop().send()

            // wait for the VM to be up
            rtn = waitForSomeStuffToHappen([label:"Start vm ${opts.server?.name}", timeout:(5l * 60l * 1000l)]) {
                return vmService.get().send().vm().status() == VmStatus.DOWN
            }
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static addNetworkInterface(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            def vmService = connection.systemService().vmsService().vmService(opts.server?.externalId ?: opts.vmId)

            // Locate the service that manages the NICs of the virtual machine:
            def nicsService = vmService.nicsService()

            // Use the "add" method of the nics service to add the disk:
            def nic = nicsService.add()
                .nic(
                    nic()
                    .name(opts.deviceName)
                    .vnicProfile(
                        vnicProfile()
                        .id(opts.networkId)
                    )
                )
                .send().nic()

            rtn.success = true
            rtn.data = nic
        }
        catch (Throwable t) {
            log.error("Unable to add network interface: ${t.message}", t)
            rtn.error = "Unable to add network interface: ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static deleteNetworkInterface(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            def vmService = connection.systemService().vmsService().vmService(opts.server?.externalId ?: opts.vmId)
            def nicService = vmService.nicsService().nicService(opts.nicId)
            nicService.remove().send()
        }
        catch (Throwable t) {
            log.error("Unable to delete network interface ${opts.nicId}: ${t.message}", t)
            rtn.error = "Unable to delete network interface ${opts.nicId}: ${t.message}"
        }
        return rtn
    }

    static checkServerReady(opts) {
        def rtn = ServiceResponse.prepare()
        try {
            def pending = true
            def attempts = 0
            while(pending) {
                sleep(1000l * 10l)
                def resp = getServerDetail(opts)
                def serverDetail = resp.data
                if(resp.success == true && serverDetail.status == 'UP') {
                    if (serverDetail.ipV4.size() > 0) {
                        rtn.success = true
                        rtn.data = serverDetail
                        pending = false
                    }
                }
                attempts ++
                if(attempts > 15)
                    pending = false
            }
        } catch(e) {
            log.error("An Exception Has Occurred: ${e.message}",e)
        }
        return rtn
    }

    static getServerDetail(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }
            def externalId = opts.server?.externalId ?: opts.serverId
            if(externalId) {
                def vmService = connection.systemService().vmsService().vmService(externalId)
                def vm = vmService.get().send().vm()
                def vmMap = [
                    name:vm.name(),
                    hostname:vm.fqdn(),
                    id:vm.id(),
                    clusterId:vm.cluster()?.id(),
                    memory:vm.memory(),
                    cores:vm.cpu().topology().cores() * vm.cpu().topology().sockets(),
                    sockets:vm.cpu().topology().sockets(),
                    ipV4:[],
                    ipV6:[],
                    status:vm.status().toString(),
                    disks:[],
                    nics:[]
                ]

                // add ip address to vm details
                def devices = connection.followLink(vm.reportedDevices())
                for (device in devices) {
                    for(ip in device.ips()) {
                        if (ip.version() == IpVersion.V4) {
                            vmMap.ipV4 << ip.address()
                        }
                        else {
                            vmMap.ipV6 << ip.address()
                        }
                    }
                }

                // add disks to vm details
                for (diskAttachment in vmService.diskAttachmentsService().list().send().attachments()) {
                    def disk = connection.followLink(diskAttachment.disk())
                    vmMap.disks << [
                        name:disk.name(),
                        id:disk.id(),
                        status:disk.status().toString(),
                        size:disk.provisionedSize(),
                        bootable:diskAttachment.bootable()
                    ]
                }

                // add nics to vm details
                for (nic in vmService.nicsService().list().send().nics()) {
                    def cloudNic = connection.followLink(nic)
                    vmMap.nics << [
                        name:cloudNic.name(),
                        id:cloudNic.id(),
                        networkId:cloudNic.vnicProfile().id()
                    ]
                }
                rtn.data = vmMap
                rtn.success = true
            }
        }
        catch(Throwable t) {
            log.error("getServerDetail error: ${t}", t)
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static updateDiskSize(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            def diskService = connection.systemService().disksService().diskService(opts.disk.id)
            def cloudDisk = diskService.get().send().disk()

            // cannot down size a disk, so only run if its sizing up
            if (cloudDisk.provisionedSize() < opts.disk.size) {
                def updateResponse = diskService.update().disk(
                    disk()
                    .id(opts.disk.id)
                    .provisionedSize(opts.disk.size)
                ).send()

                // wait for the disk update to complete
                waitForSomeStuffToHappen([label: "Resize disk ${opts.disk.id}"]) {
                    // need to wait for disk status before we move on
                    log.debug("checking status on disk ${opts.disk.id}")
                    return diskService.get().send().disk().status() == DiskStatus.OK
                }
            }
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to resize disk: ${t.message}", t)
            rtn.error = "Unable to resize disk: ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static addDisksToVm(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            def attachedDisks = []
            for (vol in opts.disks) {
                def diskAddResults = addDiskToVm([
                    connection:connection, vmId:vmId, disk:vol
                ])

                // once ok.... going to set externalId on disk before returning
                if (diskAddResults.success) {
                    attachedDisks << [externalId:diskAddResults.data.externalId, name:vol.name, size:vol.maxStorage, device:vol.deviceName]
                }
            }
            rtn.success = true
            rtn.data = [disks:attachedDisks]
        }
        catch (Throwable t) {
            log.error("Failed to add disks to vm ${vmId}:${t.message}", t)
            rtn.error = "Failed to add disks to vm ${vmId}:${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static addDiskToVm(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            // Locate the service that manages the disk attachments of the virtual machine:
            def diskAttachmentsService = connection.systemService().vmsService().vmService(vmId).diskAttachmentsService()

            def diskAttachment = diskAttachmentsService.add()
                .attachment(
                    diskAttachment()
                        .disk(
                            disk()
                                .name(opts.disk.name)
                                .description("Device ${opts.disk.deviceName}")
                                .format(DiskFormat.COW)
                                .provisionedSize(BigInteger.valueOf(opts.disk.maxStorage))
                                .storageDomains(
                                    storageDomain()
                                        .id(opts.disk.datastore.externalId)
                                )
                        )
                        .interface_(DiskInterface.VIRTIO)
                        .bootable(false)
                        .active(true)
                )
                .send()
                .attachment()

            // wait for disk to be OK
            def diskId = diskAttachment.disk().id()
            def diskService = connection.systemService().disksService().diskService(diskId)
            waitForSomeStuffToHappen([label:"Waiting for disk(${diskId}) to be ready"]) {
                return diskService.get().send().disk().status() == DiskStatus.OK
            }

            // once disk has been added, set new disk id to return object
            opts.disk.externalId = diskId
            rtn.success = true
            rtn.data = opts.disk
        }
        catch (Throwable t) {

        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static detachVolume(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            def vmService = connection.systemService().vmsService().vmService(vmId)
            def vm = vmService.get().send().vm()

            // find our disk attachment
            def attachment = vm.diskAttachments().find { attachment ->
                return attachment.disk().id() == opts.volumeId
            }

            def diskAttachmentService = vmService.diskAttachmentsService().attachmentService(attachment.id())
            diskAttachmentService.remove().detachOnly(true).send()

            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to detach volume ${opts.volumeId}")
            rtn.error = "Unable to detach volume ${opts.volumeId}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static deleteVolume(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            def diskService = connection.systemService().disksService().diskService(opts.volumeId)
            diskService.remove().send()
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to remove volume ${opts.volumeId}")
            rtn.error = "Unable to remove volume ${opts.volumeId}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static addNicToVm(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }
            def nicsService = connection.systemService().vmsService().vmService(vmId).nicsService()
            ComputeServerInterface nic = opts.nic
            nicsService.add().nic(
                nic()
                .name(nic.name)
                .vnicProfile(
                    vnicProfile()
                    .id(nic.network.externalId)
                )
            ).send()
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to add network interface: ${t.message}", t)
            rtn.error = "Unable to add network interface: ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static updateVmProperties(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            def vmService = connection.systemService().vmsService().vmService(opts.vm.id)
            def vmBuilder = vm().id(opts.vmId)

            if (opts.vm.name)
                vmBuilder.name(opts.vm.name)

            if (opts.vm.memory)
                vmBuilder.memory(opts.vm.memory.toLong())

            if (opts.vm.maxCores)
                vmBuilder.cpu(buildCpus(opts.vm))

            vmService.update().vm(vmBuilder).send()

            waitForSomeStuffToHappen([label:"waiting for vm (${opts.vm.id}) to save"]) {
                return vmService.get().send().vm().status() != VmStatus.SAVING_STATE
            }

            rtn.success = true
            rtn.data = vmService.get().send().vm()
        }
        catch (Throwable t) {
            log.error("Unable to update vm ${opts.vm.name}: ${t.message}", t)
            rtn.error = "Unable to update vm ${opts.vm.name}: ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
    }

    static addNicsToVm(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            // add all nics in opts.nics
            def nicsService = connection.systemService().vmsService().vmService(vmId).nicsService()

            for (networkInterface in opts.nics) {
                def addResponse = nicsService.add().nic(
                    nic()
                    .name(networkInterface.name)
                    .vnicProfile(
                        vnicProfile()
                        .id(networkInterface.network.externalId)
                    )
                ).send()
                networkInterface.externalId = addResponse.nic().id()
            }

            rtn.success = true
            rtn.data = opts.nics
        }
        catch (Throwable t) {
            log.error("Unable to add network interfaces to vm: ${t.message}", t)
            rtn.error = "Unable to add network interfaces to vm: ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static deleteServer(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            // first stop our vm
            def vmId = opts.server?.externalId ?: opts.vmId
            stopVm([connection:connection, vmId:vmId])

            // then remove vm
            def vmService = connection.systemService().vmsService().vmService(vmId)
            vmService.remove().send()
            rtn.success = true
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static snapshotVm(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            def snapshotsService = connection.systemService().vmsService().vmService(opts.vmId).snapshotsService()
            SnapshotContainer snap = snapshotsService.add().snapshot(
                snapshot()
                .description(opts.description ?: 'A morpheus initiated snapshot')
            ).send().snapshot()

            def snapshotService = snapshotsService.snapshotService(snap.id())
            waitForSomeStuffToHappen([label:"Waiting for snapshot(${snap.id()}) to be ready"]) {
                return snapshotService.get().send().snapshot().snapshotStatus() == SnapshotStatus.OK
            }
            rtn.data = [id:snap.id(), status:SnapshotStatus.OK.value()]
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Error creating snapshot for vm (${opts.vmId}): ${t.message}", t)
            rtn.error = "Error creating snapshot for vm (${opts.vmId}): ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static getSnapshot(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }
            def snapshotService = connection.systemService().vmsService().vmService(opts.vmId).snapshotsService().snapshotService(opts.snapshotId)
            def snap = snapshotService.get().send().snapshot()
            rtn.data = snap
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to get snapshot info for ${opts.snapshotId}: ${t.message}", t)
            rtn.error = "Unable to get snapshot info for ${opts.snapshotId}: ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static restoreSnapshot(opts) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
                closeConnection = true
            }

            def vmService = connection.systemService().vmsService().vmService(opts.vmId)
            def snapshotService = vmService.snapshotsService().snapshotService(opts.snapshotId)
            snapshotService.restore().send()

            waitForSomeStuffToHappen([label:"Waiting for vm restore(${opts.vmId}) to be ready"]) {
                return vmService.get().send().vm().status() != VmStatus.IMAGE_LOCKED
            }
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to restore snapshot(${opts.snapshotId}): ${t.message}", t)
            rtn.error = "Unable to restore snapshot(${opts.snapshotId}): ${t.message}"
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }

    static findQcowFile(Collection fileList) {
        def rtn
        if(fileList) {
            def matchList = []
            for(CloudFile file in fileList) {
                def filePath = file.name.toLowerCase();
                def fileName = getLastPath(filePath)
				//looking for non tmp file qcow files
                if((fileName.endsWith('.qcow') == true || fileName.endsWith('.qcow2') == true ) && fileName.startsWith('.') != true)
                    matchList << file
            }
            if(matchList.size() > 0)
                rtn = matchList[0]
        }
        return rtn
    }

    static getLastPath(String path) {
        def rtn = path
        if(path) {
            def tokens = path.tokenize('/')
            if(tokens.size() > 0)
                rtn = tokens[tokens.size() - 1]
        }
        return rtn
    }

    static waitForServerExists(opts) {
        Connection connection = opts.connection
        def closeConnection = false
        if (!connection) {
            connection = getConnection(opts.cloud)
            closeConnection = true
        }
        try {
            def vmService = connection.systemService().vmsService().vmService(opts.server.externalId)

            // first wait for the vm to unlock
            waitForSomeStuffToHappen([label: "Create vm ${opts.server.name}"]) {
                // we need to wait till our vm status is equal to DOWN so we know it has finished creating
                def status = vmService.get().send().vm().status()
                log.debug("VM ${opts.server.name}(${opts.server.externalId}) status is ${status.value()}")
                return status == VmStatus.DOWN
            }

            // then wait for each disk to be unlocked
            def diskAttachments = vmService.diskAttachmentsService().list().send().attachments()
            for (attachment in diskAttachments) {
                waitForSomeStuffToHappen([label:"Disk status for ${attachment.disk()?.name()}"]) {
                    def myDisk = connection.followLink(attachment.disk())
                    log.debug("Disk ${myDisk.name()}() status is ${myDisk.status()}")
                    return myDisk.status() == DiskStatus.OK
                }
            }
        }
        finally {
            if (closeConnection)
                connection.close()
        }
    }

    static testConnection(Cloud cloud) {
        def rtn = ServiceResponse.prepare()
        rtn.data = [invalidLogin:false]

        Connection connection = getConnection(cloud)
        SystemService systemService = connection.systemService()
        def systemInfo = systemService.get().send().api()
        if (systemInfo.summaryPresent()) {
            rtn.success = true
            rtn.data.connection = connection
        }
        return rtn
    }

    /**
     * utility method used to wait on something (closure body) to happen.  The closure must a return a boolean
     * value to represent success
     * @param opts
     *        timeout: specify a timeout in SECONDS
     * @param clos
     * @return {@link ServiceResponse} with success condition
     */
    static ServiceResponse waitForSomeStuffToHappen(Map opts, Closure clos) {
        def rtn = ServiceResponse.prepare()
        def timeout = opts.timeout ?: DEFAULT_WAIT_TIMEOUT
        def expired = false
        def startTime = System.currentTimeMillis()

        while (System.currentTimeMillis() - startTime < (timeout * 1000l)) {
            if (clos.call(opts))
                break
            sleep(3000l)
        }
        if (expired) {
            rtn.error = "Operation timed out: ${opts.label ?: 'operation not labeled'}"
        }
        else {
            rtn.success = true
        }
        return rtn
    }

    static List<Nic> buildNetworkInterfaces(List interfaces) {
        def nics = []
        for (iface in interfaces) {
            nics << buildNetworkInterface(iface).build()
        }
        return nics
    }

    static NicBuilder buildNetworkInterface(opts) {
        return nic()
            .name(opts.name)
            .vnicProfile(
                vnicProfile()
                .id(opts.externalId ?: opts.networkId)
                )
    }

    static CpuBuilder buildCpus(Map opts) {
        return cpu().topology(
            cpuTopology()
                .cores(opts.maxCores.toInteger())
                .sockets(opts.coresPerSocket?.toInteger() ?: 1)
        )
    }

    static getOsTypeCode(String olvmCode) {
        def code = 'unknown'
        switch (olvmCode) {
            case 'rhel':
                code = 'redhat.64'
                break
            case 'ol':
                code = 'oracle.linux.64'
                break
            case 'windows':
                code = olvmCode
                break
            case 'centos':
                code = 'cent.64'
                break
            case 'ubuntu':
                code = 'ubuntu.64'
                break
            case 'debian':
                code = 'debian.64'
                break
            case 'fedora':
                code = 'fedora.64'
                break
            case 'sles':
                code = 'suse.64'
                break
        }
        return code
    }

    static getConnection(Cloud cloud) {
        if (!cloud.accountCredentialLoaded) {
            // TOOD: load credential data
        }

        def config = [
            endpointUrl:cloud.serviceUrl,
            serviceUsername:cloud.accountCredentialData?.username ?: cloud.serviceUsername,
            servicePassword:cloud.accountCredentialData?.password ?: cloud.servicePassword
        ]

        if (cloud.apiProxy) {
            config.apiProxy = cloud.apiProxy
        }

        return getConnection(config)
    }

    static Connection getConnection(Map details) {
        if (details.apiProxy && !proxySelectorConfigured) {
            enableProxy(details.endpointUrl, details.apiProxy.proxyHost, details.apiProxy.proxyPort)
        }
        else if (!details.apiProxy && proxySelectorConfigured) {
            disableProxy()
        }

        def connectionBuilder = connection()
            .url(details.endpointUrl)
            .user(details.serviceUsername)
            .password(details.servicePassword)
            .insecure(true)

        return connectionBuilder.build()
    }

    static getDeviceName(Integer index) {
        return "/dev/vd${BLOCK_DEVICE_LIST[index]}".toString()
    }

    private static enableProxy(String endpoint, String proxyHost, Integer proxyPort) {
        Proxy httpProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort))
        URI proxyUri = new URI(endpoint)
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            List<Proxy> select(URI uri) {
                def proxyList
                if (uri.host == proxyUri.host)
                    proxyList = Collections.singletonList(httpProxy)
                return proxyList ?: []
            }

            @Override
            void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                log.error("Unable to connect to ${uri.toString()} via proxy ${sa.toString()}")
            }
        })
        proxySelectorConfigured = true
    }

    private static disableProxy() {
        List<Proxy> empty = new ArrayList<Proxy>()
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            List<Proxy> select(URI uri) {
                return empty
            }

            @Override
            void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                log.info("Should never happen with proxy disabled")
            }
        })
        proxySelectorConfigured = false
    }

    public static final List BLOCK_DEVICE_LIST = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l']
}
