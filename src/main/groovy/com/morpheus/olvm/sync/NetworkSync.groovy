package com.morpheus.olvm.sync

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.util.NetworkUtility
import com.morpheusdata.core.util.SyncList
import com.morpheusdata.core.util.SyncTask
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.CloudPool
import com.morpheusdata.model.Network as NetworkModel
import com.morpheusdata.model.projection.NetworkIdentityProjection
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.DataCenterContainer
import org.ovirt.engine.sdk4.internal.containers.NetworkContainer
import org.ovirt.engine.sdk4.types.NetworkStatus

@Slf4j
class NetworkSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Connection connection

    public NetworkSync(OlvmCloudPlugin plugin, Cloud cloud, Connection connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM network sync for cloud ${cloud.name})")
        try {
            if (!connection)
                connection = OlvmComputeUtility.getConnection(cloud)

            for (DataCenterContainer dc in OlvmComputeUtility.listDatacenters([connection:connection]).data.datacenters) {
                def cloudPool =
                    morpheusContext.async.cloud.pool.search(new DataQuery().withFilters(new DataFilter('externalId', dc.id()))).blockingGet().items?.getAt(0)

                Observable<NetworkIdentityProjection> domainRecords = morpheusContext.async.network.listIdentityProjections(cloud.id, cloudPool.id)
                SyncTask<NetworkIdentityProjection,NetworkContainer,NetworkModel> syncTask = new SyncTask<>(domainRecords, dc.networks())
                syncTask.addMatchFunction { domainObject, cloudObject ->
                    return domainObject.externalId == cloudObject.id()
                }.onDelete { removeItems ->
                    removeNetworks(removeItems)
                }.onUpdate { updateItems ->
                    updateMatchedNetworks(updateItems, cloudPool)
                }.onAdd { addItems ->
                    addMissingNetworks(addItems, cloudPool)
                }.withLoadObjectDetailsFromFinder { updateItems ->
                    return morpheusContext.async.network.listById(updateItems.collect { return it.existingItem.id } as List<Long>)
                }.observe()
            }
            log.info("Finished OLVM network sync for cloud ${cloud.name}")
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM networks: ${t.message}", t)
        }
    }

    protected removeNetworks(List<NetworkIdentityProjection> removeItems) {
        morpheusContext.async.network.bulkRemove(removeItems).blockingGet()
    }

    protected addMissingNetworks(List<NetworkContainer> addItems, CloudPool datacenter) {
        def adds = []
        for (cloudItem in addItems) {
            def networkType = plugin.cloudProvider.networkTypes?.find { it.code == 'olvm-logical-network' }
            def cidr = cloudItem.ip() ? NetworkUtility.networkToCidr(cloudItem.ip().address(), cloudItem.ip().netmask()) : null
            def networkConfig = [
                owner: cloud.owner,
                category:"olvm.plugin.netork.${cloud.id}",
                name:cloudItem.name(),
                displayName:cidr ?: cloudItem.name(),
                code:"olvm.plugin.network.${cloud.id}.${cloudItem.id()}",
                uniqueId:cloudItem.id(),
                externalId:cloudItem.id(),
                externalType: 'subnet',
                type: networkType,
                refType:'ComputeZone',
                refId:cloud.id,
                cloudPool:datacenter,
                description:cidr ?: "An OLVM logical network",
                active:cloudItem.statusPresent() ? cloudItem.status() == NetworkStatus.OPERATIONAL : true,
                cidr:cidr,
                dhcpServer:true,
                cloud:cloud
            ]
            def add = new NetworkModel(networkConfig)
            adds << add
        }
        if (adds) {
            morpheusContext.async.network.bulkCreate(adds).blockingGet()
        }
    }

    protected updateMatchedNetworks(List<SyncList.UpdateItem<NetworkModel,NetworkContainer>> updateItems, CloudPool cloudPool) {
        def updates = []
        for (updateItem in updateItems) {
            def masterItem = updateItem.masterItem
            def existingItem = updateItem.existingItem
            def save = false
            def cidr = masterItem.ipPresent() ? NetworkUtility.networkToCidr(masterItem.ip().address(), masterItem.ip().netmask()) : null
            def description = cidr ?: "An OLVM logical network"
            def active = masterItem.statusPresent() ? masterItem.status() == NetworkStatus.OPERATIONAL : true

            if (existingItem.name != masterItem.name()) {
                existingItem.name = masterItem.name()
                existingItem.displayName = cidr ?: masterItem.name()
                save = true
            }
            if (existingItem.cidr != cidr) {
                existingItem.cidr = cidr
                save = true
            }
            if (existingItem.active != active) {
                existingItem.active = active
                save = true
            }
            if (existingItem.description != description) {
                existingItem.description = description
                save = true
            }
            if (save)
                updates << existingItem
        }
        if (updates)
            morpheusContext.async.network.bulkSave(updates).blockingGet()
    }
}
