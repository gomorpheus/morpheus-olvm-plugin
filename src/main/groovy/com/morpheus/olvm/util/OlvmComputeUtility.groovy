package com.morpheus.olvm.util

import com.bertramlabs.plugins.karman.CloudFile
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.util.HttpApiClient
import com.morpheusdata.core.util.image.Qcow2InputStream
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.ComputeServerInterface
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import org.apache.tools.ant.taskdefs.condition.Http
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.SnapshotContainer
import org.ovirt.engine.sdk4.types.SnapshotStatus
import org.ovirt.engine.sdk4.types.VmStatus

import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import java.security.cert.X509Certificate

import static org.ovirt.engine.sdk4.ConnectionBuilder.connection
import static org.ovirt.engine.sdk4.builders.Builders.cluster
import static org.ovirt.engine.sdk4.builders.Builders.nic
import static org.ovirt.engine.sdk4.builders.Builders.snapshot
import static org.ovirt.engine.sdk4.builders.Builders.template
import static org.ovirt.engine.sdk4.builders.Builders.vm
import static org.ovirt.engine.sdk4.builders.Builders.vnicProfile

@Slf4j
class OlvmComputeUtility {
    public static final Long DEFAULT_WAIT_TIMEOUT = 30l * 60l // 30 minute default

    static listDatacenters(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        HttpApiClient client = null
        try {
            Map connection = opts.connection
            if (!connection) {
                connection = getToken(opts.cloud)
            }
            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def resp = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api/datacenters',
                reqOptions,
                'GET'
            )
            if (resp.success) {
                rtn.data = [
                    connection:connection,
                    datacenters:resp.data['data_center']
                ]
                rtn.success = true
            }
            else {
                log.error("Unable to get datacenters: ${extractErrorMessage(resp.data)}")
                rtn.error = "Unable to get datacenters: ${extractErrorMessage(resp.data)}"
            }
        }
        catch (Throwable t) {
            log.error("Unable to get datacenters: ${t.message}", t)
            rtn.error = "Unable to get datacenters: ${t.message}"
        }
        finally {
            client.shutdownClient()
        }
        return rtn
    }

    static listClusters(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        HttpApiClient client = null
        try {
            def connection = opts.connection
            if (!connection) {
                connection = getToken(opts.cloud)
            }

            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api/clusters',
                reqOptions,
                'GET'
            )

            if (response.success) {
                rtn.data = [
                    connection:connection,
                    clusters:response.data.cluster
                ]
                rtn.success = true
            }
            else {
                log.error("Unable to get clusters: ${extractErrorMessage(response.data)}")
                rtn.error = "Unable to get clusters: ${extractErrorMessage(response.data)}"
            }
        }
        catch (Throwable t) {
            log.error("Unable to get clusters: ${t.message}", t)
            rtn.error = "Unable to get clusters: ${t.message}"
        }
        finally {
            client.shutdownClient()
        }
        return rtn
    }

    static listTemplates(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        HttpApiClient client = null
        try {
            Map connection = opts.connection
            if (!connection) {
                connection = getToken(opts.cloud)
            }

            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api/templates',
                reqOptions,
                'GET'
            )

            if (response.success) {
                rtn.data = [
                    connection: connection,
                    templates : response.data['template']
                ]
                rtn.success = true
            }
            else {
                log.error("Unable to get templates: ${extractErrorMessage(response.data)}")
                rtn.error = "Unable to get templates: ${extractErrorMessage(response.data)}"
            }
        }
        catch (Throwable t) {
            log.error("Unable to get templates: ${t.message}", t)
            rtn.error = "Unable to get templates: ${t.message}"
        }
        finally {
            if (client)
                client.shutdownClient()
        }
        return rtn
    }

    static listVirtualMachines(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        HttpApiClient client = null
        try {
            Map connection = opts.connection
            if (!connection) {
                connection = getToken(opts.cloud)
            }

            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api/vms',
                reqOptions,
                'GET'
            )

            if (response.success) {
                rtn.data = [
                    connection: connection,
                    vms: response.data['vm'] ?: []
                ]
                rtn.success = true
            }
            else {
                log.error("Unable to get virtual machines: ${extractErrorMessage(response.data)}")
                rtn.error = "Unable to get virtual machines: ${extractErrorMessage(response.data)}"
            }
        }
        catch (Throwable t) {
            log.error("Unable to get virtual machines: ${t.message}", t)
            rtn.error = "Unable to get virtual machines: ${t.message}"
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static listNetworks(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        HttpApiClient client = null
        try {
            Map connection = opts.connection
            if (!connection) {
                connection = getToken(opts.cloud)
            }
            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)
            def queryParams = [follow:'vnicprofiles']
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, queryParams:queryParams, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api/networks',
                reqOptions,
                'GET'
            )

            if (response.success) {
                def networks = []
                for (network in response.data.network) {
                    def profiles = network['vnic_profiles']?.getAt('vnic_profile')
                    if (profiles) {
                        for (profile in profiles) {
                            networks << [
                                id:profile.id,
                                name:profile.name,
                                provisionable:true,
                                vlanId:network.vlan?.id,
                                datacenterId:network['data_center']?.id,
                                description:profile.description ?: network.description,
                                type:'profile'
                            ]
                        }
                    }
                    else {
                        networks << [
                            id:network.id,
                            name:network.name,
                            provisionable:false,
                            vlanId:network.vlan?.id,
                            datacenterId:network['data_center']?.id,
                            description:network.description,
                            type:'network'
                        ]

                    }
                }
                rtn.data = [
                    connection: connection,
                    networks:networks
                ]
                rtn.success = true
            }
            else {
                log.error("Unable to get networks: ${extractErrorMessage(response.data)}")
                rtn.error = "Unable to get networks: ${extractErrorMessage(response.data)}"
            }
        }
        catch (Throwable t) {
            log.error("Unable to get networks: ${t.message}", t)
            rtn.error = "Unable to get networks: ${t.message}"
        }
        finally {
            client.shutdownClient()
        }
        return rtn
    }

    static listStorageDomains(opts) {
        ServiceResponse rtn = ServiceResponse.prepare()
        HttpApiClient client = null
        try {
            def connection = opts.connection
            if (!connection) {
                connection = getToken(opts.cloud)
            }

            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api/storagedomains',
                reqOptions,
                'GET'
            )
            if (response.success) {
                rtn.data = [
                    connection:connection,
                    storageDomains:response.data['storage_domain']
                ]
                rtn.success = true
            }
            else {
                log.error("Unable to get clusters: ${extractErrorMessage(response.data)}")
                rtn.error = "Unable to get clusters: ${extractErrorMessage(response.data)}"
            }
        }
        catch (Throwable t) {
            log.error("Unable to get storage domains: ${t.message}", t)
            rtn.error = "Unable to get storage domains: ${t.message}"
        }
        finally {
            client.shutdownClient()
        }
        return rtn
    }

    static validateServerConfig(MorpheusContext morpheusContext, Map opts =[:]) {
        def rtn = [success:false, errors: []]
        try {
            def cloudId = opts.cloud?.id.toLong() ?: opts.zoneId?.toLong()
            def cloud = morpheusContext.async.cloud.getCloudById(opts.zoneId?.toLong()).blockingGet()
            def configMap = cloud.configMap
            // Validate enough Elastic IPs left
            if(configMap.datacenter == 'all' && !opts.config?.datacenterId) {
                rtn.errors += [field: 'datacenterId', msg: 'You must choose a datacenter']
            }
            if(!opts.config.clusterId) {
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
        Map connection = opts.connection
        HttpApiClient client

        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }
            client = getApiClient(connection)
            def headers = getAuthenticatedBaseHeaders(connection)

            if (opts.imageName) {
                // if using just an image name, we must leverage the search service
                def imageName = opts.imageName.replaceAll(' ', '_')
                def queryParams = [search:"name=${imageName}".toString()]
                def reqOptions = new HttpApiClient.RequestOptions(headers:headers, queryParams:queryParams, ignoreSSL:true)
                def response = client.callJsonApi(
                    connection.apiUrl,
                    '/ovirt-engine/api/templates',
                    reqOptions,
                    'GET'
                )

                if (response.success) {
                    def templates = response.data.template
                    rtn.data = [template: (templates?.size() > 0 ? templates.first() : null)]
                    rtn.success = true
                }
                else {
                    rtn.error = "Failed to retrieve image ${opts.imageName}:${extractErrorMessage(response.data)}"
                    rtn.success = false
                }
            }
            else if (opts.imageId) {
                def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
                def response = client.callJsonApi(
                    connection.apiUrl,
                    "/ovirt-engine/api/templates/${opts.imageId}".toString(),
                    reqOptions,
                    'GET'
                )
                if (response.success) {
                    rtn.data = [template: response.data]
                    rtn.success = true
                }
                else {
                    rtn.error = "Failed to retrieve image ${opts.imageId}:${extractErrorMessage(response.data)}"
                    rtn.success = false
                }
            }
        }
        catch (Throwable t) {
            log.error("Unable to load image from OLVM cloud: ${t.message}")
            rtn.error = "Unable to load image from OLVM cloud: ${t.message}"
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static insertImage(opts) {
        log.debug("createServer opts: ${opts}")
        def rtn = ServiceResponse.prepare()
        Map connection = opts.connection
        HttpApiClient client
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }

            // first lets see if our image exists in olvm cloud
            def vi = opts.image.virtualImage
            def imageName = vi.name.replaceAll(' ', '_')
            def headers = getAuthenticatedBaseHeaders(connection)
            def queryParams = [search:"name=${imageName}".toString()]
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, queryParams:queryParams, ignoreSSL:true)
            client = getApiClient(connection)
            def response = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api/templates',
                reqOptions,
                'GET'
            )
            if (response.data.template?.size() > 0) {
                rtn.success = true
                rtn.data = [imageRef:response.data.template.first().id]
            }
            else {
                // grab the inputstream of our qcow file and wrap in QcowInputStream to get the size of the disk we need
                CloudFile cloudFile = opts.image.imageFile
                Qcow2InputStream qcowInputStream = new Qcow2InputStream(cloudFile.inputStream, true)
                def actualDiskSize = qcowInputStream.qcowHeader.size

                // create a blank disk
                def tmpDiskName = "morph_tmp_${opts.image.virtualImage.id}"
                def postHeaders = getAuthenticatedBaseHeaders(connection)
                def reqBody = [
                    name:tmpDiskName,
                    format:'cow',
                    'provisioned_size':actualDiskSize,
                    'storage_domains':[
                        'storage_domain':[[id:opts.storageDomainId]]
                    ]
                ]
                def postReqOptions = new HttpApiClient.RequestOptions(headers:postHeaders, body:reqBody, ignoreSSL:true)
                response = client.callJsonApi(
                    connection.apiUrl,
                    '/ovirt-engine/api/disks',
                    postReqOptions,
                    'POST'
                )
                def blank = response.data

                // Wait for disk to be ready before we start data transfer
                reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
                waitForSomeStuffToHappen([label: "Waiting for blank disk to be ready"]) {
                    response = client.callJsonApi(
                        connection.apiUrl,
                        blank.href,
                        reqOptions,
                        'GET'
                    )
                    return response.data.status == 'ok'
                }

                // create an image transfer session
                def blankDiskId = blank.id
                reqBody = [disk:[id:blankDiskId], direction:'upload', 'inactivity_timeout':15 * 60]
                postReqOptions = new HttpApiClient.RequestOptions(headers:postHeaders, body:reqBody, ignoreSSL:true)
                def transferSession = client.callJsonApi(
                    connection.apiUrl,
                    '/ovirt-engine/api/imagetransfers',
                    postReqOptions,
                    'POST'
                )

                if (!transferSession.success) {
                    throw new RuntimeException("Failed to initialize transfer session:${extractErrorMessage(transferSession.data)}")
                }

                def transferObj = transferSession.data
                def xferId = transferObj.id

                // wait for the image transfer session to hit the transferring state
                def imageXfer
                waitForSomeStuffToHappen([label: "Waiting for image transfer to go TRANSFERRING"]) {
                    response = client.callJsonApi(
                        connection.apiUrl,
                        "/ovirt-engine/api/imagetransfers/${xferId}".toString(),
                        reqOptions,
                        'GET'
                    )
                    imageXfer = response.data
                    log.debug("Image transfer phase is ${imageXfer.phase}")
                    return imageXfer.phase == 'transferring'
                }

                // Now push the file contents of our qcow file to OLVM
                def transferUrl = new URL(imageXfer['proxy_url'])

                // TODO: should we use a progress input stream here to update as we upload?
                pushDataToTarget(qcowInputStream, transferUrl, connection, cloudFile.contentLength)

                // once data has been pushed to target, finalize the transfer
                postReqOptions = new HttpApiClient.RequestOptions(headers:postHeaders, body:[:], ignoreSSL:true)
                response = client.callJsonApi(
                    connection.apiUrl,
                    "/ovirt-engine/api/imagetransfers/${xferId}/finalize".toString(),
                    postReqOptions,
                    'POST'
                )

                if (!response.success) {
                    throw new RuntimeException("Failed to finalize image transfer session: ${extractErrorMessage(response.data)}")
                }

                // after we finalize the transfer wait for the image disk to be ok
                waitForSomeStuffToHappen([label: "Wait for disk ${blank.name}"]) {
                    response = client.callJsonApi(
                        connection.apiUrl,
                        blank.href,
                        reqOptions,
                        'GET'
                    )
                    def d = response.data
                    log.debug("Disk ${d.name}(${d.id}) status is ${d.status}")
                    actualDiskSize = d['actual_size']
                    return d.status == 'ok'
                }

                // HACK: OLVM is so stupid.  There is a lag between when the api reports the disk status as OK and when
                // the disk can be used for a VM.  If done too quickly afterwards, the VM created will fail saying the
                // disk is locked, when its actually not.  So we are forcing a 3 second delay between the two operations
                sleep(3000l)

                // TODO: Next we need to create a temporary VM and attach our disk to it
                reqBody = [
                    name:"morpheus-tmp-${opts.image.virtualImage.id}".toString(),
                    cluster:[id:opts.clusterRef],
                    template:[id:'00000000-0000-0000-0000-000000000000']
                ]
                postReqOptions = new HttpApiClient.RequestOptions(headers:postHeaders, body:reqBody, ignoreSSL:true)
                response = client.callJsonApi(
                    connection.apiUrl,
                    '/ovirt-engine/api/vms',
                    postReqOptions,
                    'POST'
                )

                if (!response.success) {
                    throw new RuntimeException("Failed to create vm for template: ${extractErrorMessage(response.data)}")
                }

                def newVm = response.data

                // wait for new VM to be ready
                waitForSomeStuffToHappen([label: "Waiting for vm ${newVm.name} to be ready"]) {
                    response = client.callJsonApi(
                        connection.apiUrl,
                        "/ovirt-engine/api/vms/${newVm.id}".toString(),
                        reqOptions,
                        'GET'
                    )
                    def v = response.data
                    log.debug("Vm ${v.name}(${v.id}) status is ${v.status}")
                    return v.status == 'down'
                }

                // attach our disk to our temporary vm
                reqBody = [
                    bootable:true,
                    interface:'virtio',
                    active:true,
                    disk:[id:blankDiskId]
                ]
                postReqOptions = new HttpApiClient.RequestOptions(headers:postHeaders, body:reqBody, ignoreSSL:true)
                response = client.callJsonApi(
                    connection.apiUrl,
                    "/ovirt-engine/api/vms/${newVm.id}/diskattachments",
                    postReqOptions,
                    'POST'
                )

                if (!response.success) {
                    throw new RuntimeException("Failed to attach disk to vm: ${extractErrorMessage(response.data)}")
                }

                // wait for disk attachment to complete
                waitForSomeStuffToHappen([label: "Waiting disk ${blankDiskId} to be ready"]) {
                    response = client.callJsonApi(
                        connection.apiUrl,
                        blank.href,
                        reqOptions,
                        'GET'
                    )
                    def d = response.data
                    log.debug("Disk ${d.name}(${d.id}) status is ${d.status}")
                    return d.status == 'ok'
                }

                // create template from this vm
                reqBody = [name:imageName, vm:[id:newVm.id]]
                postReqOptions = new HttpApiClient.RequestOptions(headers:postHeaders, body:reqBody, ignoreSSL:true)
                response = client.callJsonApi(
                    connection.apiUrl,
                    '/ovirt-engine/api/templates',
                    postReqOptions,
                    'POST'
                )

                if (!response.success) {
                    throw new RuntimeException("Failed to create template from vm: ${extractErrorMessage(response.data)}")
                }
                def newTemplate = response.data

                // wait for template to be usable
                waitForSomeStuffToHappen([label: "Waiting for template ${imageName} to be ready"]) {
                    response = client.callJsonApi(
                        connection.apiUrl,
                        newTemplate.href,
                        reqOptions,
                        'GET'
                    )
                    def t = response.data
                    log.debug("Template ${t.name}(${t.id}) status is ${t.status}")
                    return t.status == 'ok'
                }

                // once our template is ready for use, remove our temporary vm
                deleteServer([connection:connection, vmId:newVm.id])

                rtn.data = [imageRef:newTemplate.id]
                rtn.success = true
            }
        }
        catch(Throwable t) {
            log.error("Failed to create image template: ${t.message}", t)
            rtn.error = "Failed to create image template: ${t.message}"
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static pushDataToTarget(Qcow2InputStream inputStream, URL url, Map con, Long contentLength = null) {
    //static pushDataToTarget(InputStream inputStream, URL url, Connection con) {
        HttpURLConnection connection
        try {
            // Install the all-trusting trust manager
            TrustManager[] trustAllCertificates = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null
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
            connection.setRequestProperty("Authorization", "Bearer ${con.token}".toString())

            if (contentLength) {
                connection.setFixedLengthStreamingMode(contentLength)
            }
            else {
                connection.setChunkedStreamingMode(2 * 1024 * 1024) // default to 2 MB chunks
            }

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
        Map connection = opts.connection
        HttpApiClient client
        try {
            if (!connection) {
                connection getToken(opts.cloud)
            }
            def imageRef = opts.imageRef
            def zoneRef = opts.zoneRef
            def networkRef = opts.subnetRef
            def count = opts.count ?: 1

            // grab http client to use for provisioning requests
            client = getApiClient(connection)

            // grab template information
            def headers = getAuthenticatedBaseHeaders(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/templates/${imageRef}/diskattachments".toString(),
                reqOptions,
                'GET'
            )

            def templateDisk = response.data['disk_attachment'].first()

            // merge network interfaces
            def interfaces = [opts.networkConfig.primaryInterface]
            interfaces.addAll(opts.networkConfig.extraInterfaces)

            // send vm create to api
            def postBody = [
                name:opts.name,
                cluster:[id:opts.clusterRef],
                template:[id:imageRef],
                memory:opts.maxMemory,
                cpu:buildCpus(opts.workloadConfig),
                nics:[nic:buildNetworkInterfaces(interfaces)],
                'disk_attachments':[
                    'disk_attachment':[
                        [disk:[id:templateDisk.id, 'provisioned_size':opts.rootVolume.maxStorage, 'storage_domains':['storage_domain':[[id:opts.rootVolume.datastore.externalId]]]]]
                    ]
                ]
            ]
            def postHeaders = getAuthenticatedBaseHeaders(connection)
            def postReqOptions = new HttpApiClient.RequestOptions(headers:postHeaders, body:postBody, ignoreSSL:true)
            response = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api/vms/',
                postReqOptions,
                'POST'
            )

            if (!response.success) {
                throw new RuntimeException("Failed to create vm ${opts.name}: ${extractErrorMessage(response.data)}")
            }
            def vm = response.data
            rtn.data = [vmId:vm.id, vm:vm]
            rtn.success = true
        }
        catch (Throwable t) {
            rtn.error = "Failed to provision vm ${opts.name}: ${t.message}"
            log.error("Failed to provision vm ${opts.name}: ${t.message}", t)
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static createServerFromSnapshot(opts) {
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

            // grab api services we will need for vm creation
            def vmsService = connection.systemService().vmsService()

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
                    .snapshots(
                        snapshot()
                        .id(opts.restoreSnapshotId)
                    )
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
        Map connection = opts.connection
        HttpApiClient client
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }
            def vmExternalId = opts.server?.externalId ?: opts.vmId
            def headers = getAuthenticatedBaseHeaders(connection)
            headers['Content-Type'] = 'application/json'
            client = getApiClient(connection)
            def reqBody = [
                'vm':[
                    'initialization':[
                        'custom_script':opts.cloudInitScript
                    ]
                ],
                'async':true, 'use_cloud_init':true
            ]
            def postReqOptions = new HttpApiClient.RequestOptions(headers:headers, body:reqBody, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/vms/${vmExternalId}/start".toString(),
                postReqOptions,
                'POST'
            )

            if (response.success) {
                def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
                rtn = waitForSomeStuffToHappen([label: "Start vm ${opts.server?.name}", timeout: (5l * 60l * 1000l)]) {
                    response = client.callJsonApi(
                        connection.apiUrl,
                        "/ovirt-engine/api/vms/${vmExternalId}".toString(),
                        reqOptions,
                        'GET'
                    )
                    return response.data.status == 'up'
                }
            }
            else {
                rtn = ServiceResponse.error("Failed to start vm: ${extractErrorMessage(response.data)}")
            }
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static startVm(opts) {
        ServiceResponse rtn
        Map connection = opts.connection
        HttpApiClient client
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }
            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def vmExternalId = opts.server?.externalId ?: opts.vmId
            def response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/vms/${vmExternalId}".toString(),
                reqOptions,
                'GET'
            )

            if (response.success) {
                def vm = response.data
                if (vm.status != 'up') {
                    // if our vm status is not up, send the start command
                    def actionBody = [async:true]
                    def postHeaders = getAuthenticatedBaseHeaders(connection)
                    postHeaders['Content-Type'] = 'application/json'
                    def postReqOptions = new HttpApiClient.RequestOptions(headers:headers, body:actionBody, ignoreSSL:true)
                    response = client.callJsonApi(
                        connection.apiUrl,
                        "/ovirt-engine/api/vms/${vmExternalId}/start".toString(),
                        postReqOptions,
                        'POST'
                    )

                    // wait for the VM to be up
                    rtn = waitForSomeStuffToHappen([label: "Start vm ${opts.server?.name}", timeout: (5l * 60l * 1000l)]) {
                        response = client.callJsonApi(
                            connection.apiUrl,
                            "/ovirt-engine/api/vms/${vmExternalId}".toString(),
                            reqOptions,
                            'GET'
                        )
                        return response.data.status == 'up'
                    }
                } else {
                    // if its already started then just ignore
                    rtn = ServiceResponse.success()
                }
            }
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static stopVm(opts) {
        ServiceResponse rtn
        Map connection = opts.connection
        HttpApiClient client
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }
            def headers = getAuthenticatedBaseHeaders(connection)
            headers['Content-Type'] = 'application/json'
            client = getApiClient(connection)
            def postBody = [async:true]
            def postReqOptions = new HttpApiClient.RequestOptions(headers:headers, body:postBody, ignoreSSL:true)
            def vmExternalId = opts.server?.externalId ?: opts.vmId
            def response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/vms/${vmExternalId}/stop".toString(),
                postReqOptions,
                'POST'
            )

            if (response.success) {
                def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
                // wait for the VM to be down
                rtn = waitForSomeStuffToHappen([label: "Start vm ${opts.server?.name}", timeout: (5l * 60l * 1000l)]) {
                    response = client.callJsonApi(
                        connection.apiUrl,
                        "/ovirt-engine/api/vms/${vmExternalId}".toString(),
                        reqOptions,
                        'GET'
                    )
                    return response.data.status == 'down'
                }
            }
            else {
                rtn = ServiceResponse.error("Failed to stop vm: ${extractErrorMessage(response.data)}")
            }
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static addNetworkInterface(opts) {
        return addNicsToVm([
            connection:opts.connection,
            vmId:opts.server?.externalId ?: opts.vmId,
            nics:[
                [name:opts.deviceName, network:[externalId:opts.networkId]]
            ]
        ])
    }

    static deleteNetworkInterface(opts) {
        def rtn = ServiceResponse.prepare()
        Map connection = opts.connection
        HttpApiClient client
        try {
            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/vms/${opts.server?.externalId ?: opts.vmId}/nics/${opts.nicId}".toString(),
                reqOptions,
                'DELETE'
            )

            if (!response.success) {
                throw new RuntimeException("Unable to remove vm network interface ${opts.nicId}: ${extractErrorMessage(response.data)}")
            }
        }
        catch (Throwable t) {
            log.error("Unable to delete network interface ${opts.nicId}: ${t.message}", t)
            rtn.error = "Unable to delete network interface ${opts.nicId}: ${t.message}"
        }
        finally {
            client?.shutdownClient()
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
                if(resp.success == true && serverDetail.status == 'up') {
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
        HttpApiClient client = null
        try {
            Map connection = opts.connection
            if (!connection) {
                connection = getToken(opts.cloud)
            }
            def externalId = opts.server?.externalId ?: opts.serverId
            if(externalId) {
                def headers = getAuthenticatedBaseHeaders(connection)
                client = getApiClient(connection)
                def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
                def response = client.callJsonApi(
                    connection.apiUrl,
                    "/ovirt-engine/api/vms/${externalId}".toString(),
                    reqOptions,
                    'GET'
                )

                if (response.success) {
                    rtn.data = [
                        connection: connection,
                    ]
                    rtn.success = true
                }
                def vm = response.data
                def vmMap = [
                    name:vm.name,
                    hostname:vm.fqdn,
                    id:vm.id,
                    clusterId:vm.cluster?.id,
                    memory:vm.memory?.toLong(),
                    cores:vm.cpu.topology.cores.toLong() * vm.cpu.topology.sockets.toLong(),
                    sockets:vm.cpu.topology.sockets.toLong(),
                    ipV4:[],
                    ipV6:[],
                    status:vm.status,
                    disks:[],
                    nics:[]
                ]

                // add ip address to vm details
                response = client.callJsonApi(
                    connection.apiUrl,
                    "/ovirt-engine/api/vms/${externalId}/reporteddevices".toString(),
                    reqOptions,
                    'GET'
                )
                def devices = response.data['reported_device']
                for (device in devices) {
                    for(ip in device.ips?.ip) {
                        if (ip.version == 'v4') {
                            vmMap.ipV4 << ip.address
                        }
                        else {
                            vmMap.ipV6 << ip.address
                        }
                    }
                }

                // add disks to vm details
                response = client.callJsonApi(
                    connection.apiUrl,
                    "/ovirt-engine/api/vms/${externalId}/diskattachments".toString(),
                    reqOptions,
                    'GET'
                )
                for (diskAttachment in response.data['disk_attachment']) {
                    def disk = client.callJsonApi(
                        connection.apiUrl,
                        diskAttachment.disk.href,
                        reqOptions,
                        'GET'
                    ).data

                    vmMap.disks << [
                        name:disk.name,
                        id:disk.id,
                        status:disk.status,
                        size:disk['provisioned_size']?.toLong(),
                        bootable:diskAttachment.bootable.toBoolean(),
                        logicalName:diskAttachment['logical_name'],
                        interface:diskAttachment.interface,
                        active:diskAttachment.active.toBoolean()
                    ]
                }

                // add nics to vm details
                def vmNics = client.callJsonApi(
                    connection.apiUrl,
                    "/ovirt-engine/api/vms/${externalId}/nics".toString(),
                    reqOptions,
                    'GET'
                ).data.nic
                for (nic in vmNics) {
                    vmMap.nics << [
                        name:nic.name,
                        id:nic.id,
                        networkId:nic['vnic_profile'].id
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
            if (client)
                client.shutdownClient()
        }
        return rtn
    }

    static updateDiskSize(opts) {
        def rtn = ServiceResponse.prepare()
        Map connection = opts.connection
        HttpApiClient client
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }

            def headers = getAuthenticatedBaseHeaders(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            client = getApiClient(connection)
            def cloudDisk = client.callJsonApi(connection.apiUrl, "/ovirt-engine/api/disks/${opts.disk.id}", reqOptions, 'GET').data

            // cannot down size a disk, so only run if its sizing up
            if (cloudDisk['provisioned_size']?.toLong() < opts.disk.size) {
                def putHeaders = getAuthenticatedBaseHeaders(connection)
                def putBody = [id:opts.disk.id, 'provisioned_size':opts.disk.size]
                def putReqOptions = new HttpApiClient.RequestOptions(headers:putHeaders, body:putBody, ignoreSSL:true)
                def updateResponse = client.callJsonApi(
                    connection.apiUrl,
                    cloudDisk.href,
                    putReqOptions,
                    'PUT'
                )

                if (!updateResponse.success) {
                    throw new RuntimeException("Unable to resize disk ${cloudDisk.name}: ${updateResponse.data?.success}")
                }

                // wait for the disk update to complete
                waitForSomeStuffToHappen([label: "Resize disk ${opts.disk.id}"]) {
                    // need to wait for disk status before we move on
                    log.debug("checking status on disk ${opts.disk.id}")
                    def d = client.callJsonApi(connection.apiUrl, cloudDisk.href, reqOptions, 'GET').data
                    return d.status == 'ok'
                }
            }
            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to resize disk: ${t.message}", t)
            rtn.error = "Unable to resize disk: ${t.message}"
        }
        finally {
            client.shutdownClient()
        }
        return rtn
    }

    static addDisksToVm(opts) {
        def rtn = ServiceResponse.prepare()
        Map connection = opts.connection
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
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
        return rtn
    }

    static addDiskToVm(opts) {
        def rtn = ServiceResponse.prepare()
        Map connection = opts.connection
        HttpApiClient client
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getConnection(opts.cloud)
            }

            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)

            // first create our disk
            def postBody = [
                name:opts.disk.name,
                description:"Device ${opts.disk.deviceName}".toString(),
                format:'cow',
                'provisioned_size':BigInteger.valueOf(opts.disk.maxStorage),
                'storage_domains':[
                    'storage_domain':[[id:opts.disk.datastore.externalId]]
                ]
            ]
            def postReqOptions = new HttpApiClient.RequestOptions(headers:headers, body:postBody, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api/disks',
                postReqOptions,
                'POST'
            )

            if (!response.success) {
                throw new RuntimeException("Failed to create disk ${opts.disk.name}: ${extractErrorMessage(response.data)}")
            }

            // wait for our disk to be created before we attach it to our vm
            def newDisk = response.data
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            waitForSomeStuffToHappen([label:"Waiting for disk(${newDisk.id}) to be ready"]) {
                def d = client.callJsonApi(connection.apiUrl, newDisk.href, reqOptions, 'GET').data
                return d.status == 'ok'
            }

            // now attach the disk to the vm
            postBody = [
                bootable:false,
                interface:'virtio',
                active:true,
                disk:[id:newDisk.id]
            ]
            postReqOptions = new HttpApiClient.RequestOptions(headers:headers, body:postBody, ignoreSSL:true)
            response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/vms/${vmId}/diskattachments".toString(),
                postReqOptions,
                'POST'
            )

            if (!response.success) {
                throw new RuntimeException("Failed to attach disk to vm: ${extractErrorMessage(response.data)}")
            }

            // wait for disk to be OK
            waitForSomeStuffToHappen([label:"Waiting for disk(${newDisk.id}) to be ready"]) {
                def d = client.callJsonApi(connection.apiUrl, newDisk.href, reqOptions, 'GET').data
                return d.status == 'ok'
            }

            // once disk has been added, set new disk id to return object
            opts.disk.externalId = newDisk.id
            rtn.success = true
            rtn.data = opts.disk
        }
        catch (Throwable t) {
            log.error("Unable to add disk to vm: ${t.message}", t)
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static detachVolume(opts) {
        def rtn = ServiceResponse.prepare()
        Map connection = opts.connection
        HttpApiClient client
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }

            def headers = getAuthenticatedBaseHeaders(connection)
            def queryParams = [follow:'diskattachments']
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            client = getApiClient(connection)

            def response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/vms/${vmId}".toString(),
                reqOptions,
                'GET'
            )

            // find our disk attachment
            def attachment = response.data['disk_attachments']['disk_attachment'].find { attachment ->
                return attachment.disk.id == opts.volumeId
            }

            // detach the disk from our vm
            queryParams = ['detach_only':'true']
            def postReqOptions = new HttpApiClient.RequestOptions(headers:headers, queryParams:queryParams, ignoreSSL:true)
            response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/vms/${vmId}/diskattachments/${attachment.id}".toString(),
                postReqOptions,
                'DELETE'
            )

            if (!response.success)
                throw new RuntimeException("Failed to detailed disk ${attachment.id}: ${extractErrorMessage(response.data)}")

            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to detach volume ${opts.volumeId}: ${t.message}")
            rtn.error = "Unable to detach volume ${opts.volumeId}: ${t.message}"
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static deleteVolume(opts) {
        def rtn = ServiceResponse.prepare()
        Map connection = opts.connection
        HttpApiClient client
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }

            def headers = getAuthenticatedBaseHeaders(connection)
            client = getApiClient(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/disks/${opts.volumeId}".toString(),
                reqOptions,
                'DELETE'
            )

            if (!response.success)
                throw new RuntimeException("Failed to remove disk ${opts.volumeId}: ${extractErrorMessage(response.data)}")

            rtn.success = true
        }
        catch (Throwable t) {
            log.error("Unable to remove volume ${opts.volumeId}")
            rtn.error = "Unable to remove volume ${opts.volumeId}"
        }
        finally {
            client?.shutdownClient()
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
        Map connection = opts.connection
        HttpApiClient client
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }
            def postHeaders = getAuthenticatedBaseHeaders(connection)
            def postBody = [:]
            client = getApiClient(connection)

            def vmService = connection.systemService().vmsService().vmService(opts.vm.id)
            def vmBuilder = vm().id(opts.vmId)

            if (opts.vm.name)
                postBody.name = opts.vm.name

            if (opts.vm.memory)
                postBody.memory = opts.vm.memory.toLong()

            if (opts.vm.maxCores)
                postBody.cpu = buildCpus(opts.vm)

            def postReqOptions = new HttpApiClient.RequestOptions(headers:postHeaders, body:postBody, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/vms/${vmId}".toString(),
                postReqOptions,
                'PUT'
            )

            if (!response.success) {
                throw new RuntimeException("Failed to update vm ${vmId}: ${extractErrorMessage(response.data)}")
            }

            def reqOptions = new HttpApiClient.RequestOptions(headers:postHeaders, ignoreSSL:true)
            def vm
            waitForSomeStuffToHappen([label:"waiting for vm (${opts.vm.id}) to save"]) {
                vm = client.callJsonApi(
                    connection.apiUrl,
                    "/ovirt-engine/api/vms/${vmId}".toString(),
                    reqOptions,
                    'GET'
                ).data
                return vm.status != 'saving_state'
            }

            rtn.success = true
            rtn.data = vm
        }
        catch (Throwable t) {
            log.error("Unable to update vm ${opts.vm.name}: ${t.message}", t)
            rtn.error = "Unable to update vm ${opts.vm.name}: ${t.message}"
        }
        finally {
            client?.shutdownClient()
        }
    }

    static addNicsToVm(opts) {
        def rtn = ServiceResponse.prepare()
        Map connection = opts.connection
        HttpApiClient client
        def vmId = opts.vm?.id ?: opts.vmId
        try {
            if (!connection) {
                connection = getToken(opts.cloud)
            }

            // add all nics in opts.nics
            client = getApiClient(connection)
            def headers = getAuthenticatedBaseHeaders(connection)

            for (networkInterface in opts.nics) {
                def postBody = [
                    name:networkInterface.name,
                    interface:'virtio',
                    'vnic_profile':[id:networkInterface.network.externalId]
                ]
                def postReqOptions = new HttpApiClient.RequestOptions(headers:headers, body:postBody, ignoreSSL:true)
                def addResponse = client.callJsonApi(
                    connection.apiUrl,
                    "/ovirt-engine/api/vms/${vmId}/nics".toString(),
                    postReqOptions,
                    'POST'
                )

                if (!addResponse.success) {
                    throw new RuntimeException("Failed to add nic ${networkInterface.name} to vm: ${extractErrorMessage(addResponse.data)}")
                }
                networkInterface.externalId = addResponse.data.id
            }

            rtn.success = true
            rtn.data = opts.nics
        }
        catch (Throwable t) {
            log.error("Unable to add network interfaces to vm: ${t.message}", t)
            rtn.error = "Unable to add network interfaces to vm: ${t.message}"
        }
        finally {
            client?.shutdownClient()
        }
        return rtn
    }

    static deleteServer(opts, MorpheusContext ctx = null) {
        def rtn = ServiceResponse.prepare()
        Map connection = opts.connection
        HttpApiClient client
        try {
            if (!connection) {
                connection = getToken(opts.cloud, ctx)
            }

            // first stop our vm
            def vmId = opts.server?.externalId ?: opts.vmId
            stopVm([connection:connection, vmId:vmId])

            // then remove vm
            client = getApiClient(connection)
            def headers = getAuthenticatedBaseHeaders(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def response = client.callJsonApi(
                connection.apiUrl,
                "/ovirt-engine/api/vms/${vmId}".toString(),
                reqOptions,
                'DELETE'
            )
            rtn.success = response.success
        }
        finally {
            client?.shutdownClient()
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

    static getSnapshot(opts, MorpheusContext ctx = null) {
        def rtn = ServiceResponse.prepare()
        Connection connection = opts.connection
        def closeConnection = false
        try {
            if (!connection) {
                connection = getConnection(opts.cloud, ctx)
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
                opts.connection = connection
                closeConnection = true
            }

            // stop the vm before restoring
            stopVm(opts)
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
        Map connection = opts.connection
        HttpApiClient client
        if (!connection) {
            connection = getToken(opts.cloud)
        }
        try {
            def headers = getAuthenticatedBaseHeaders(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            client = getApiClient(connection)

            // first wait for the vm to unlock
            waitForSomeStuffToHappen([label: "Create vm ${opts.server.name}"]) {
                // we need to wait till our vm status is equal to DOWN so we know it has finished creating
                def vm = client.callJsonApi(connection.apiUrl, "/ovirt-engine/api/vms/${opts.server.externalId}".toString(), reqOptions, 'GET').data
                log.debug("VM ${opts.server.name}(${opts.server.externalId}) status is ${vm.status}")
                return vm.status == 'down'
            }

            // then wait for each disk to be unlocked
            def diskAttachments = client.callJsonApi(connection.apiUrl, "/ovirt-engine/api/vms/${opts.server.externalId}/diskattachments".toString(), reqOptions, 'GET').data
            for (attachment in diskAttachments['disk_attachment']) {
                waitForSomeStuffToHappen([label:"Disk status for ${attachment['logical_name']}"]) {
                    def myDisk = client.callJsonApi(connection.apiUrl, attachment.disk.href, reqOptions, 'GET').data
                    log.debug("Disk ${myDisk.name} status is ${myDisk.status}")
                    return myDisk.status == 'ok'
                }
            }
        }
        finally {
            client?.shutdownClient()
        }
    }

    static testConnection(Cloud cloud) {
        def rtn = ServiceResponse.prepare()
        rtn.data = [invalidLogin:false]

        Map connection = getToken(cloud)
        HttpApiClient client = null
        try {
            client = getApiClient(connection)
            def headers = getAuthenticatedBaseHeaders(connection)
            def reqOptions = new HttpApiClient.RequestOptions(headers:headers, ignoreSSL:true)
            def resp = client.callJsonApi(
                connection.apiUrl,
                '/ovirt-engine/api',
                reqOptions,
                'GET'
            )
            if (resp.success) {
                rtn.success = true
                rtn.data.connection = connection
            } else {
                log.error("Failed testConnection(): ${extractErrorMessage(resp.data)}")
                rtn.error = extractErrorMessage(resp.data)
            }
        }
        finally {
            client.shutdownClient()
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

    static List<Map> buildNetworkInterfaces(List interfaces) {
        def nics = []
        for (iface in interfaces) {
            nics << buildNetworkInterface(iface)
        }
        return nics
    }

    static Map buildNetworkInterface(opts) {
        return [
            name:opts.name,
            'vnic_profile':[id:opts.externalId ?: opts.networkId]
        ]
    }

    static Map buildCpus(Map opts) {
        return [
            topology:[
                cores:opts.maxCores.toInteger(),
                sockets:opts.coresPerSocket?.toInteger() ?: 1
            ]
        ]
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

    static getToken(Cloud cloud, MorpheusContext ctx = null) {
        if (!cloud.accountCredentialLoaded && ctx) {
            cloud.accountCredentialData = ctx.async.cloud.loadCredentials(cloud.id).blockingGet()?.data
            cloud.accountCredentialLoaded = true
        }

        def config = [
            endpointUrl:cloud.serviceUrl,
            serviceUsername:cloud.accountCredentialData?.username ?: cloud.serviceUsername,
            servicePassword:cloud.accountCredentialData?.password ?: cloud.servicePassword
        ]

        if (cloud.apiProxy) {
            config.apiProxy = cloud.apiProxy
        }

        HttpApiClient client
        try {
            client = getApiClient(config)
            def headers = ['Content-Type': 'application/x-www-form-urlencoded', 'Accept': 'application/json']
            def body = "grant_type=password&scope=ovirt-app-api&username=${URLEncoder.encode(config.serviceUsername, 'UTF-8')}&password=${URLEncoder.encode(config.servicePassword, 'UTF-8')}".toString()
            HttpApiClient.RequestOptions reqOptions = new HttpApiClient.RequestOptions(headers: headers, body: body, ignoreSSL: true)
            def resp = client.callJsonApi(
                extractRootURL(config.endpointUrl),
                '/ovirt-engine/sso/oauth/token',
                reqOptions,
                'POST'
            )

            if (resp.success) {
                return [apiUrl: extractRootURL(config.endpointUrl), token: resp.data['access_token']]
            } else {
                throw new RuntimeException("Failed to authenticate to OLVM environment: ${extractErrorMessage(resp.data)}")
            }
        }
        finally {
            client?.shutdownClient()
        }
    }

    static getConnection(Cloud cloud, MorpheusContext ctx = null) {
        if (!cloud.accountCredentialLoaded && ctx) {
            cloud.accountCredentialData = ctx.async.cloud.loadCredentials(cloud.id).blockingGet()?.data
            cloud.accountCredentialLoaded = true
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

    static HttpApiClient getApiClient(Map config) {
        return new HttpApiClient(networkProxy:config.apiProxy)
    }

    static getAuthenticatedBaseHeaders(String token) {
        return [Authorization:"Bearer ${token}".toString(), Accept:'application/json', 'Content-Type':'application/json']
    }

    static getAuthenticatedBaseHeaders(Map connection) {
        return getAuthenticatedBaseHeaders(connection.token)
    }

    static String extractErrorMessage(resp) {
        if (resp?.fault)
            return "${resp?.fault.message} - ${resp?.faul?.detail}".toString()
        else
            return "${resp?.message} - ${resp?.detail}".toString()

    }

    private static String extractRootURL(String urlString) {
        URL url = new URL(urlString)
        return "${url.protocol}://${url.host}".toString()
    }

    public static final List BLOCK_DEVICE_LIST = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l']
}
