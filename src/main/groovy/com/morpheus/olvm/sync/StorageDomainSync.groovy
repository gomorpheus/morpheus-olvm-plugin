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
import com.morpheusdata.model.Datastore
import com.morpheusdata.model.projection.DatastoreIdentity
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable

@Slf4j
class StorageDomainSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Map connection

    public StorageDomainSync(OlvmCloudPlugin plugin, MorpheusContext ctx, Cloud cloud, Map connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@morpheusContext = ctx
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM storage domain sync for cloud ${cloud.name})")
        try {
            if (!this.@connection)
                this.@connection = OlvmComputeUtility.getToken(cloud)

            // NOTE: for now just syncing all storage domains
            def olvmStorageDomains = OlvmComputeUtility.listStorageDomains([connection:connection]).data.storageDomains
            /*Observable<DatastoreIdentity> domainRecords = morpheusContext.async.cloud.datastore.listIdentityProjections(
                new DataQuery().withFilters(new DataFilter<String>('cloud.id', cloud.id))
            )*/
            Observable<DatastoreIdentity> domainRecords = morpheusContext.async.cloud.datastore.listSyncProjections(cloud.id)
            SyncTask<DatastoreIdentity,Map,Datastore> syncTask = new SyncTask<>(domainRecords, olvmStorageDomains)
            syncTask.addMatchFunction { DatastoreIdentity domainObject, Map cloudItem ->
                return domainObject.externalId == cloudItem.id
            }.onDelete { removeItems ->
                removeStorageDomains(removeItems)
            }.onUpdate { updateItems ->
                updateMatchedStorageDomains(updateItems)
            }.onAdd { addItems ->
                addMissingStorageDomains(addItems)
            }.withLoadObjectDetailsFromFinder { updateItems ->
                return morpheusContext.async.cloud.datastore.listById(updateItems.collect { it.existingItem.id } as List<Long>)
            }.start()

            log.info("Finished OLVM storage domain sync for cloud ${cloud.name}")
            return ServiceResponse.success()
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM storage domains: ${t.message}", t)
        }
    }

    protected removeStorageDomains(List<DatastoreIdentity> removeItems) {
        morpheusContext.async.cloud.datastore.bulkRemove(removeItems).blockingGet()
    }

    protected addMissingStorageDomains(List<Map> addItems) {
        def adds = []
        for (cloudItem in addItems) {
            // Check to see if network belongs to a data center
            def datacenter
            if (cloudItem['data_centers']?['data_center']) {
                def cloudDatacenter = cloudItem['data_centers']['data_center'].first()
                def datacenters =
                    morpheusContext.async.cloud.pool.search(new DataQuery().withFilter(new DataFilter<String>('externalId', cloudDatacenter.id))).blockingGet()
                datacenter = datacenters.items?.first()
            }
            def type = cloudItem.type ?: 'generic'
            def availableSpace = cloudItem.available?.toLong()
            def committedSpace = cloudItem.committed?.toLong()
            def datastoreConfig = [
                owner       : new Account(id:cloud.defaultDatastoreSyncAccount ?: cloud.owner.id),
                name        : cloudItem.name,
                externalId  : cloudItem.id,
                cloud       : cloud,
                storageSize : availableSpace && committedSpace ? availableSpace + committedSpace : 0l,
                freeSpace   : availableSpace ?: 0l,
                zonePool    : datacenter,
                type        : type,
                category    : "olvm.plugin.datastore.${cloud.id}",
                drsEnabled  : false,
                online      : cloudItem['external_status'] == 'ok',
                refType     : 'ComputeZone',
                refId       : cloud.id,
                active      : cloud.defaultDatastoreSyncActive
            ]
            Datastore add = new Datastore(datastoreConfig)
            add.assignedZonePools = [datacenter]
            adds << add

        }
        if (adds)
            morpheusContext.async.cloud.datastore.bulkCreate(adds).blockingGet()
    }

    protected updateMatchedStorageDomains(List<SyncList.UpdateItem<Datastore,Map>> updateList) {
        // NOTE: do we care about datacenters changing on storage domains? is this possible?
        def updates = []
        for (updateItem in updateList) {
            def masterItem = updateItem.masterItem
            def existingItem = updateItem.existingItem
            def save = false

            if (existingItem.name != masterItem.name) {
                existingItem.name = masterItem.name
                save = true
            }
            if (masterItem.available) {
                def availableSpace = masterItem.available.toLong()
                def committedSpace = masterItem.committed?.toLong() ?: 0l
                if (existingItem.freeSpace != availableSpace) {
                    existingItem.freeSpace = availableSpace
                    save = true
                }
                if (existingItem.storageSize != availableSpace + committedSpace) {
                    existingItem.storageSize = availableSpace + committedSpace
                    save = true
                }
            }
            if (existingItem.online != (masterItem['external_status'] == 'ok')) {
                existingItem.online = !existingItem.online
                save = true
            }
            if (save)
                updates << existingItem
        }

        if (updates) {
            morpheusContext.async.cloud.datastore.bulkSave(updates).blockingGet()
        }
    }
}

