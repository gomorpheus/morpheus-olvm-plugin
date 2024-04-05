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
import com.morpheusdata.model.Network as NetworkModel
import com.morpheusdata.model.projection.NetworkIdentityProjection
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.VnicProfileContainer
import org.ovirt.engine.sdk4.types.NetworkStatus

@Slf4j
class NetworkSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Connection connection

    public NetworkSync(OlvmCloudPlugin plugin, MorpheusContext ctx, Cloud cloud, Connection connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@morpheusContext = ctx
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM network sync for cloud ${cloud.name})")
        try {
            if (!connection)
                connection = OlvmComputeUtility.getConnection(cloud)

            def olvmNetworks = OlvmComputeUtility.listNetworks([connection:connection]).data.profiles
            Observable<NetworkIdentityProjection> domainRecords = morpheusContext.async.network.listIdentityProjections(
                new DataQuery().withFilters(
                    new DataFilter<String>('refType', 'ComputeZone'),
                    new DataFilter<String>('refId', cloud.id)
                )
            )
            SyncTask<NetworkIdentityProjection,VnicProfileContainer,NetworkModel> syncTask = new SyncTask<>(domainRecords, olvmNetworks)
            syncTask.addMatchFunction { domainObject, cloudObject ->
                return domainObject.externalId == cloudObject.id()
            }.onDelete { removeItems ->
                removeNetworks(removeItems)
            }.onUpdate { updateItems ->
                updateMatchedNetworks(updateItems)
            }.onAdd { addItems ->
                addMissingNetworks(addItems)
            }.withLoadObjectDetailsFromFinder { updateItems ->
                return morpheusContext.async.network.listById(updateItems.collect { return it.existingItem.id } as List<Long>)
            }.start()

            log.info("Finished OLVM network sync for cloud ${cloud.name}")
            return ServiceResponse.success()
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM networks: ${t.message}", t)
        }
    }

    protected removeNetworks(List<NetworkIdentityProjection> removeItems) {
        morpheusContext.async.network.bulkRemove(removeItems).blockingGet()
    }

    protected addMissingNetworks(List<VnicProfileContainer > addItems) {
        def adds = []
        for (cloudItem in addItems) {
            def networkType =
                morpheusContext.async.network.type.search(new DataQuery().withFilter(new DataFilter<String>('code', 'olvm-logical-network'))).blockingGet().items?.first()

            def network = cloudItem.network()
            def cidr = network?.ip() ? NetworkUtility.networkToCidr(network?.ip().address(), network?.ip().netmask()) : '0.0.0.0/1'

            // Check to see if network belongs to a data center
            def datacenter
            if (network?.dataCenterPresent()) {
                def datacenters =
                    morpheusContext.async.cloud.pool.search(new DataQuery().withFilter(new DataFilter<String>('externalId', network.dataCenter().id()))).blockingGet()
                datacenter = datacenters.items?.first()
            }

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
                active:network.statusPresent() ? network.status() == NetworkStatus.OPERATIONAL : true,
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

    protected updateMatchedNetworks(List<SyncList.UpdateItem<NetworkModel,VnicProfileContainer>> updateItems) {
        def updates = []
        for (updateItem in updateItems) {
            def masterItem = updateItem.masterItem
            def existingItem = updateItem.existingItem
            def save = false
            def network = masterItem.network()
            def cidr = network.ipPresent() ? NetworkUtility.networkToCidr(network.ip().address(), network.ip().netmask()) : '0.0.0.0/1'
            def description = cidr ?: "An OLVM logical network"
            def active = network.statusPresent() ? network.status() == NetworkStatus.OPERATIONAL : true

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
