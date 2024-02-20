package com.morpheus.olvm.sync

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.util.SyncTask
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.CloudPool
import com.morpheusdata.model.projection.CloudPoolIdentity
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.ClusterContainer

@Slf4j
class VirtualMachineSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Connection connection

    public VirtualMachineSync(OlvmCloudPlugin plugin, MorpheusContext ctx, Cloud cloud, Connection connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@morpheusContext = ctx
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM virtual machine sync for cloud ${cloud.name})")
        try {
            if (!connection)
                connection = OlvmComputeUtility.getConnection(cloud)

            log.info("Completed OLVM virtual machine sync for cloud ${cloud.name}")
            return ServiceResponse.success()
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM clusters: ${t.message}", t)
        }
    }
}
