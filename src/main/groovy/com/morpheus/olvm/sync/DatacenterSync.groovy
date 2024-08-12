package com.morpheus.olvm.sync

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.util.SyncList
import com.morpheusdata.core.util.SyncTask
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.CloudPool
import com.morpheusdata.model.projection.CloudPoolIdentity
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable

@Slf4j
class DatacenterSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Map connection

    public DatacenterSync(OlvmCloudPlugin plugin, MorpheusContext ctx, Cloud cloud, Map connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@morpheusContext = ctx
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM datacenter sync for cloud ${cloud.name})")
        try {
            if (!this.@connection)
                this.@connection = OlvmComputeUtility.getToken(cloud)

            Observable<CloudPoolIdentity> domainRecords = morpheusContext.async.cloud.pool.listIdentityProjections(
                new DataQuery().withFilters(
                    new DataFilter<String>('type', 'datacenter'),
                    new DataFilter<String>('refType', 'ComputeZone'),
                    new DataFilter<String>('refId', cloud.id)
                )
            )
            def olvmDatacenters = OlvmComputeUtility.listDatacenters([connection:connection]).data.datacenters
            SyncTask<CloudPoolIdentity, Map, CloudPool> syncTask = new SyncTask<>(domainRecords, olvmDatacenters)
            def rtn = syncTask.addMatchFunction { domainObject, cloudObject ->
                return domainObject.externalId == cloudObject.id
            }.onDelete { removeItems ->
                removeDatacenters(removeItems)
            }.onUpdate { updateItems ->
                updateMatchedDatacenters(updateItems)
            }.onAdd { addItems ->
                addMissingDatacenters(addItems)
            }.withLoadObjectDetailsFromFinder { updateItems ->
                return morpheusContext.async.cloud.pool.listById(updateItems.collect { it.existingItem.id } as List<Long>)
            }.start()
            log.info("Completed OLVM datacenter sync for cloud ${cloud.name}")
            return rtn
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM datacenters: ${t.message}", t)
        }
    }

    protected removeDatacenters(List<CloudPoolIdentity> removeItems) {
        morpheusContext.async.cloud.pool.bulkRemove(removeItems).blockingGet()
    }

    protected addMissingDatacenters(List<Map> datacenters) {
        def adds = []
        for (cloudItem in datacenters) {
            adds << new CloudPool(
                owner:[id:cloud.owner.id],
                type:'datacenter',
                name:cloudItem.name,
                displayName:cloudItem.name,
                description:"${cloudItem.description} - version: ${cloudItem.version?.major}.${cloudItem.version?.minor}",
                externalId:cloudItem.id,
                status:translateStatus(cloudItem.status?.toLowerCase()),
                refType:'ComputeZone',
                refId:cloud.id,
                cloud:[id:cloud.id],
                category:"olvm.plugin.datacenter.${cloud.id}",
                code:"olvm.plugin.datacenter.${cloud.id}.${cloudItem.id}"
            )
        }
        if (adds) {
            morpheusContext.async.cloud.pool.bulkCreate(adds).blockingGet()
        }
    }

    protected updateMatchedDatacenters(List<SyncList.UpdateItem<CloudPool,Map>> updateList) {
        def updates = []
        for (updateItem in updateList) {
            def masterItem = updateItem.masterItem
            def existingItem = updateItem.existingItem
            def save = false

            if (existingItem.name != masterItem.name) {
                existingItem.name = masterItem.name
                save = true
            }
            if (existingItem.status != translateStatus(masterItem.status?.toLowerCase())) {
                existingItem.status = translateStatus(masterItem.status?.toLowerCase())
                save = true
            }
            if (save)
                updates << existingItem
        }
        if (updates) {
            morpheusContext.async.cloud.pool.bulkSave(updates).blockingGet()
        }
    }

    protected CloudPool.Status translateStatus(String olvmStatus) {
        def datacenterStatus
        switch (olvmStatus) {
            case 'up':
                datacenterStatus = CloudPool.Status.available
                break
            default:
                datacenterStatus = CloudPool.Status.failed
                break
        }
        return datacenterStatus
    }
}
