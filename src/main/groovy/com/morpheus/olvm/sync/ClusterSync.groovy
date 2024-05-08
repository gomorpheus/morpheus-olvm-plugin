package com.morpheus.olvm.sync

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.util.SyncList
import com.morpheusdata.core.util.SyncTask
import com.morpheusdata.model.Account
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.CloudPool
import com.morpheusdata.model.projection.CloudPoolIdentity
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.ClusterContainer
import org.ovirt.engine.sdk4.types.DataCenterStatus

@Slf4j
class ClusterSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Connection connection

    public ClusterSync(OlvmCloudPlugin plugin, MorpheusContext ctx, Cloud cloud, Connection connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@morpheusContext = ctx
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM cluster sync for cloud ${cloud.name})")
        try {
            if (!connection)
                connection = OlvmComputeUtility.getConnection(cloud)

            Observable<CloudPoolIdentity> domainRecords = morpheusContext.async.cloud.pool.listIdentityProjections(
                new DataQuery().withFilters(
                    new DataFilter<String>('type', 'cluster'),
                    new DataFilter<String>('refType', 'ComputeZone'),
                    new DataFilter<String>('refId', cloud.id)
                )
            )
            def olvmClusters = OlvmComputeUtility.listClusters([connection:connection]).data.clusters
            SyncTask<CloudPoolIdentity, ClusterContainer, CloudPool> syncTask = new SyncTask<>(domainRecords, olvmClusters)
            def rtn = syncTask.addMatchFunction { domainObject, cloudObject ->
                return domainObject.externalId == cloudObject.id()
            }.onDelete { removeItems ->
                removeClusters(removeItems)
            }.onUpdate { updateItems ->
                updateMatchedClusters(updateItems)
            }.onAdd { addItems ->
                addMissingClusters(addItems)
            }.withLoadObjectDetailsFromFinder { updateItems ->
                return morpheusContext.async.cloud.pool.listById(updateItems.collect { it.existingItem.id } as List<Long>)
            }.start()
            log.info("Completed OLVM cluster sync for cloud ${cloud.name}")
            return rtn
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM clusters: ${t.message}", t)
        }
    }

    protected removeClusters(List<CloudPoolIdentity> removeItems) {
        morpheusContext.async.cloud.pool.bulkRemove(removeItems).blockingGet()
    }

    protected addMissingClusters(List<ClusterContainer> clusters) {
        def adds = []
        for (cloudItem in clusters) {
            adds << new CloudPool(
                owner:new Account(id:cloud.defaultPoolSyncAccount ?: cloud.owner.id),
                type:'cluster',
                name:cloudItem.name(),
                displayName:cloudItem.name(),
                description:cloudItem.descriptionPresent() ? cloudItem.description() : "A cluster named ${cloudItem.name()} version ${cloudItem.version().fullVersion()}",
                externalId:cloudItem.id(),
                refType:'ComputeZone',
                refId:cloud.id,
                cloud:[id:cloud.id],
                category:"olvm.plugin.cluster.${cloud.id}",
                code:"olvm.plugin.cluster.${cloud.id}.${cloudItem.id()}",
                active:cloud.defaultPoolSyncActive
            )
        }
        if (adds) {
            morpheusContext.async.cloud.pool.bulkCreate(adds).blockingGet()
        }
    }

    protected updateMatchedClusters(List<SyncList.UpdateItem<CloudPool,ClusterContainer>> updateList) {
        def updates = []
        for (updateItem in updateList) {
            def masterItem = updateItem.masterItem
            def existingItem = updateItem.existingItem
            def save = false

            if (existingItem.name != masterItem.name()) {
                existingItem.name = masterItem.name()
                save = true
            }
            if (save)
                updates << existingItem
        }
        if (updates) {
            morpheusContext.async.cloud.pool.bulkSave(updates).blockingGet()
        }
    }

    protected CloudPool.Status translateStatus(DataCenterStatus olvmStatus) {
        def datacenterStatus
        switch (olvmStatus) {
            case DataCenterStatus.UP:
                datacenterStatus = CloudPool.Status.available
                break
            default:
                datacenterStatus = CloudPool.Status.failed
                break
        }
        return datacenterStatus
    }
}
