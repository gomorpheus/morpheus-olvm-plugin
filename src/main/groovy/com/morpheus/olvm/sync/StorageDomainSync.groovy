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
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.StorageDomainContainer
import org.ovirt.engine.sdk4.types.ExternalStatus

@Slf4j
class StorageDomainSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Connection connection

    public StorageDomainSync(OlvmCloudPlugin plugin, MorpheusContext ctx, Cloud cloud, Connection connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@morpheusContext = ctx
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM storage domain sync for cloud ${cloud.name})")
        try {
            if (!connection)
                connection = OlvmComputeUtility.getConnection(cloud)

            // NOTE: for now just syncing all storage domains
            def olvmStorageDomains = OlvmComputeUtility.listStorageDomains([connection:connection]).data.storageDomains
            /*Observable<DatastoreIdentity> domainRecords = morpheusContext.async.cloud.datastore.listIdentityProjections(
                new DataQuery().withFilters(new DataFilter<String>('cloud.id', cloud.id))
            )*/
            Observable<DatastoreIdentity> domainRecords = morpheusContext.async.cloud.datastore.listSyncProjections(cloud.id)
            SyncTask<DatastoreIdentity,StorageDomainContainer,Datastore> syncTask = new SyncTask<>(domainRecords, olvmStorageDomains)
            syncTask.addMatchFunction { DatastoreIdentity domainObject, StorageDomainContainer cloudItem ->
                return domainObject.externalId == cloudItem.id()
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

    protected addMissingStorageDomains(List<StorageDomainContainer> addItems) {
        def adds = []
        for (cloudItem in addItems) {
            // Check to see if network belongs to a data center
            def datacenter
            if (cloudItem.dataCenterPresent()) {
                def datacenters =
                    morpheusContext.async.cloud.pool.search(new DataQuery().withFilter(new DataFilter<String>('externalId', cloudItem.dataCenter().id()))).blockingGet()
                datacenter = datacenters.items?.first()
            }
            def type = cloudItem.type().value() ?: 'generic'
            def availableSpace = cloudItem.available()
            def committedSpace = cloudItem.committed()
            def datastoreConfig = [
                owner       : new Account(id:cloud.defaultDatastoreSyncAccount ?: cloud.owner.id),
                name        : cloudItem.name(),
                externalId  : cloudItem.id(),
                cloud       : cloud,
                storageSize : availableSpace && committedSpace ? availableSpace + committedSpace : 0l,
                freeSpace   : availableSpace ?: 0l,
                zonePool    : datacenter,
                type        : type,
                category    : "olvm.plugin.datastore.${cloud.id}",
                drsEnabled  : false,
                online      : cloudItem.externalStatus() == ExternalStatus.OK,
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

    protected updateMatchedStorageDomains(List<SyncList.UpdateItem<Datastore,StorageDomainContainer>> updateList) {
        // NOTE: do we care about datacenters changing on storage domains? is this possible?
        def updates = []
        for (updateItem in updateList) {
            def masterItem = updateItem.masterItem
            def existingItem = updateItem.existingItem
            def save = false

            if (existingItem.name != masterItem.name()) {
                existingItem.name = masterItem.name()
                save = true
            }
            if (masterItem.available()) {
                if (existingItem.freeSpace != masterItem.available()) {
                    existingItem.freeSpace = masterItem.available()
                    save = true
                }
                if (existingItem.storageSize != masterItem.available() + masterItem.committed()) {
                    existingItem.storageSize = masterItem.available() + masterItem.committed()
                    save = true
                }
            }
            if (existingItem.online != (ExternalStatus.OK == masterItem.externalStatus())) {
                existingItem.online = masterItem.externalStatus() == ExternalStatus.OK
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

