package com.morpheus.olvm.util

import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.ComputeServerInterface
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.builders.CpuBuilder
import org.ovirt.engine.sdk4.builders.NicBuilder
import org.ovirt.engine.sdk4.services.SystemService
import org.ovirt.engine.sdk4.types.DiskFormat
import org.ovirt.engine.sdk4.types.DiskInterface
import org.ovirt.engine.sdk4.types.DiskStatus
import org.ovirt.engine.sdk4.types.IpVersion
import org.ovirt.engine.sdk4.types.Nic
import org.ovirt.engine.sdk4.types.VmStatus

import static org.ovirt.engine.sdk4.ConnectionBuilder.connection
import static org.ovirt.engine.sdk4.builders.Builders.cluster
import static org.ovirt.engine.sdk4.builders.Builders.core
import static org.ovirt.engine.sdk4.builders.Builders.cpu
import static org.ovirt.engine.sdk4.builders.Builders.cpuTopology
import static org.ovirt.engine.sdk4.builders.Builders.disk
import static org.ovirt.engine.sdk4.builders.Builders.diskAttachment
import static org.ovirt.engine.sdk4.builders.Builders.initialization
import static org.ovirt.engine.sdk4.builders.Builders.nic
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain
import static org.ovirt.engine.sdk4.builders.Builders.template
import static org.ovirt.engine.sdk4.builders.Builders.vm
import static org.ovirt.engine.sdk4.builders.Builders.vnicProfile

@Slf4j
class OlvmComputeUtility {
    public static final Long DEFAULT_WAIT_TIMEOUT = 30l * 60l // 30 minute default

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
                    memory:vm.memory(),
                    cores:vm.cpu().topology().cores() * vm.cpu().topology().sockets(),
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
                )
                    .send()

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

            for (ComputeServerInterface networkInterface in opts.nics) {
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

    static waitForServerExists(opts) {
        Connection connection = opts.connection
        def closeConnection = false
        if (!connection) {
            connection = getConnection(opts.cloud)
            closeConnection = true
        }
        try {
            def vmsService = connection.systemService().vmsService()
            waitForSomeStuffToHappen([label: "Create vm ${opts.name}"]) {
                // we need to wait till our vm status is equal to DOWN so we know it has finished creating
                log.debug("checking status on new vm ${opts.name} (${opts.server.externalId})")
                return vmsService.vmService(opts.server.externalId).get().send().vm().status() == VmStatus.DOWN
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

    static getConnection(Cloud cloud) {
        if (!cloud.accountCredentialLoaded) {
            // TOOD: load credential data
        }

        return getConnection([
            endpointUrl:cloud.serviceUrl,
            serviceUsername:cloud.accountCredentialData?.username ?: cloud.serviceUsername,
            servicePassword:cloud.accountCredentialData?.password ?: cloud.servicePassword
        ])
    }

    static Connection getConnection(Map details) {
        return connection()
            .url(details.endpointUrl)
            .user(details.serviceUsername)
            .password(details.servicePassword)
            .insecure(true)
            .build()
    }

    static getDeviceName(Integer index) {
        return "/dev/vd${BLOCK_DEVICE_LIST[index]}".toString()
    }

    public static final List BLOCK_DEVICE_LIST = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l']
}
