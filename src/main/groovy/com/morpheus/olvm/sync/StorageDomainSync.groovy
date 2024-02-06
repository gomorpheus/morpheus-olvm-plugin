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
import com.morpheusdata.model.Datastore
import com.morpheusdata.model.projection.DatastoreIdentity
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.DataCenterContainer
import org.ovirt.engine.sdk4.internal.containers.StorageDomainContainer
import org.ovirt.engine.sdk4.types.StorageDomainStatus

import javax.xml.crypto.Data

@Slf4j
class StorageDomainSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Connection connection

    public StorageDomainSync(OlvmCloudPlugin plugin, Cloud cloud, Connection connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM storage domain sync for cloud ${cloud.name})")
        try {
            if (!connection)
                connection = OlvmComputeUtility.getConnection(cloud)


            // NOTE: for now just syncing all storage domains
            for (DataCenterContainer dc in OlvmComputeUtility.listDatacenters([connection:connection]).data.datacenters) {
                def cloudPool =
                    morpheusContext.async.cloud.pool.search(new DataQuery().withFilters(new DataFilter('externalId', dc.id()))).blockingGet().items?.getAt(0)
                Observable<DatastoreIdentity> domainRecords = morpheusContext.async.cloud.datastore.listIdentityProjections(
                    new DataQuery().withFilters(new DataFilter<String>('zonePool.id', cloudPool.id))
                )
                SyncTask<DatastoreIdentity,StorageDomainContainer,Datastore> syncTask = new SyncTask<>(domainRecords, dc.storageDomains())
                def rtn = syncTask.addMatchFunction { DatastoreIdentity domainObject, StorageDomainContainer cloudItem ->
                    return domainObject.externalId == cloudItem.id()
                }.onDelete { removeItems ->
                    removeStorageDomains(removeItems)
                }.onUpdate { updateItems ->
                    updateMatchedStorageDomains(updateItems, cloudPool)
                }.onAdd { addItems ->
                    addMissingStorageDomains(addItems, cloudPool)
                }.withLoadObjectDetailsFromFinder { updateItems ->
                    return morpheusContext.async.cloud.datastore.listById(updateItems.collect { it.existingItem.id } as List<Long>)
                }.observe()
            }

            log.info("Finished OLVM storage domain sync for cloud ${cloud.name}")
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM storage domains: ${t.message}", t)
        }
    }

    protected removeStorageDomains(List<DatastoreIdentity> removeItems) {
        morpheusContext.async.cloud.datastore.bulkRemove(removeItems).blockingGet()
    }

    protected addMissingStorageDomains(List<StorageDomainContainer> addItems, CloudPool cloudPool) {
        def adds = []
        for (cloudItem in addItems) {
            def type = cloudItem.type().value() ?: 'generic'
            def datastoreConfig = [
                owner       : new Account(id: cloud.owner.id),
                name        : cloudItem.name(),
                externalId  : cloudItem.id(),
                cloud       : cloud,
                storageSize : cloudItem.committed() + cloudItem.available(),
                freeSpace   : cloudItem.available(),
                zonePool    : cloudPool,
                type        : type,
                category    : "olvm.plugin.datastore.${cloud.id}",
                drsEnabled  : false,
                online      : cloudItem.status() == StorageDomainStatus.ACTIVE
            ]
            Datastore add = new Datastore(datastoreConfig)
            add.assignedZonePools = [cloudPool]
            adds << add

        }
        morpheusContext.async.cloud.datastore.bulkCreate(adds).blockingGet()
    }

    protected updateMatchedStorageDomains(List<SyncList.UpdateItem<Datastore,StorageDomainContainer>> updateList, CloudPool cloudPool) {
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
            if (existingItem.freeSpace != masterItem.available()) {
                existingItem.freeSpace = masterItem.available()
                save = true
            }
            if (existingItem.storageSize != masterItem.available() + masterItem.committed()) {
                existingItem.storageSize = masterItem.available() + masterItem.committed()
                save = true
            }
            if (existingItem.online != (StorageDomainStatus.ACTIVE == masterItem.status())) {
                existingItem.online = (StorageDomainStatus.ACTIVE == masterItem.status())
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

