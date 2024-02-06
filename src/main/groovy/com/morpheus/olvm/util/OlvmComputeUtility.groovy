package com.morpheus.olvm.util

import com.morpheusdata.model.Cloud
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.services.SystemService

import static org.ovirt.engine.sdk4.ConnectionBuilder.connection

@Slf4j
class OlvmComputeUtility {
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

    static testConnection(Cloud cloud) {
        def rtn = ServiceResponse.prepare()
        rtn.data = [invalidLogin:false]

        Connection connection = getConnection(cloud)
        SystemService systemService = connection.systemService()
        def dataCenters = systemService.dataCentersService().list().send().dataCenters()
        if (dataCenters.size() > 0) {
            rtn.success = true
            rtn.data.connection = connection
        }
        return rtn
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
}
