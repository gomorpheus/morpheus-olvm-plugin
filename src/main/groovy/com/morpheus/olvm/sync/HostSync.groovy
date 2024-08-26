package com.morpheus.olvm.sync

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.util.SyncTask
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.CloudPool
import com.morpheusdata.model.ComputeServer
import com.morpheusdata.model.ComputeServerType
import com.morpheusdata.model.projection.ComputeServerIdentityProjection
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable

@Slf4j
class HostSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Map connection
    private Map<String, ComputeServerType> computeServerTypes

    public HostSync(OlvmCloudPlugin plugin, MorpheusContext ctx, Cloud cloud, Map connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@morpheusContext = ctx
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM Host sync for cloud ${cloud.name})")
        try {
            if (!this.@connection)
                this.@connection = OlvmComputeUtility.getToken(cloud)

            def olvmHosts = OlvmComputeUtility.listHosts([connection:connection]).data.hosts
            Observable<ComputeServerIdentityProjection> domainRecords = morpheusContext.async.computeServer.listIdentityProjections(
                new DataQuery().withFilters(
                    new DataFilter('zone.id', cloud.id),
                    new DataFilter('computeServerType.code', 'olvm-hypervisor')
                )
            )
            SyncTask<ComputeServerIdentityProjection,Map, ComputeServer> syncTask = new SyncTask<>(domainRecords, olvmHosts)
            syncTask.addMatchFunction { domainObject, cloudObject ->
                return domainObject.externalId == cloudObject.id
            }.onDelete { removeItems ->
                removeHosts(removeItems)
            }.onUpdate { updateItems ->
                updateMatchedHosts(updateItems)
            }.onAdd { addItems ->
                addMissingHosts(addItems)
            }.withLoadObjectDetailsFromFinder { updateItems ->
                return morpheusContext.async.computeServer.listById(updateItems.collect { return it.existingItem.id } as List<Long>)
            }.start()

            log.info("Finished OLVM Host sync for cloud ${cloud.name}")
            return ServiceResponse.success()
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM Hosts: ${t.message}", t)
        }
    }

    def addMissingHosts(List<Map> hosts) {
        List<ComputeServer> adds = []
        for (host in hosts) {
            def zonePool = morpheusContext.async.cloud.pool.find(
                new DataQuery().withFilters(
                    new DataFilter('externalId', host.cluster.id),
                    new DataFilter('zone.id', cloud.id)
                )
            ).blockingGet()
            def osType = host.os?.type.toLowerCase()
            ComputeServer add = new ComputeServer(
                account: cloud.account,
                externalId: host.id,
                resourcePool: zonePool ? new CloudPool(id: zonePool.id) : null,
                category:"olvm.kvm.host.${cloud.id}",
                name:host.name,
                hostname:host.address,
                externalIp:host.address,
                internalIp:host.address,
                sshHost:host.address,
                serverType:'hypervisor',
                sshUsername:'root',
                apiKey: java.util.UUID.randomUUID(),
                provision: false,
                singleTenant:false,
                cloud: cloud,
                managed: false,
                status: 'provisioned',
                powerState: host.status == 'up' ? ComputeServer.PowerState.on : ComputeServer.PowerState.off,
                osType:osType,
                serverOs:morpheusContext.async.osType.find(new DataQuery().withFilters(new DataFilter<String>('code', OlvmComputeUtility.getOsTypeCode(osType)))).blockingGet(),
                computeServerType: allComputeServerTypes['olvm-hypervisor'],
                maxMemory:host.memory.toLong(),
                platform:'vdsm',
                platformVersion:host.version['full_version']
            )
            adds << add
        }

        if (adds) {
            morpheusContext.async.computeServer.bulkCreate(adds).blockingGet()
        }
    }

    def updateMatchedHosts(updateItems) {
        def saves = []
        for(update in updateItems) {
            ComputeServer currentServer = update.existingItem
            Map cloudItem = update.masterItem

            if (currentServer.status != 'provisioning') {
                try {
                    def save = false
                    def powerState = cloudItem.status == 'up' ? ComputeServer.PowerState.on : ComputeServer.PowerState.off
                    def zonePool = morpheusContext.async.cloud.pool.find(
                        new DataQuery().withFilters(
                            new DataFilter('externalId', cloudItem.cluster.id),
                            new DataFilter('zone.id', cloud.id)
                        )
                    ).blockingGet()

                    if (cloudItem.name != currentServer.name) {
                        currentServer.name = cloudItem.name
                        save = true
                    }
                    if (currentServer.resourcePool?.id != zonePool?.id) {
                        currentServer.resourcePool = zonePool?.id ? new CloudPool(id: zonePool.id) : null
                        save = true
                    }
                    if (powerState != currentServer.powerState) {
                        currentServer.powerState = powerState
                        save = true
                    }
                    def primaryIp = cloudItem.address
                    if (currentServer.externalIp != primaryIp) {
                        if (currentServer.externalIp == currentServer.sshHost) {
                            currentServer.sshHost = primaryIp
                        }
                        currentServer.externalIp = primaryIp
                        save = true
                    }
                    if (currentServer.internalIp != primaryIp) {
                        currentServer.internalIp = primaryIp
                        save = true
                    }

                    if (save) {
                        saves << currentServer
                    }
                }
                catch (Throwable t) {
                    log.warn("Error Updating Virtual Machine ${currentServer?.name} - ${currentServer.externalId} - ${t.message}", t)
                }
            }
        }

        if(saves) {
            morpheusContext.async.computeServer.bulkSave(saves).blockingGet()
        }
    }

    def removeHosts(List<ComputeServerIdentityProjection> removeList) {
        log.debug "removeHosts: ${cloud} ${removeList.size()}"
        morpheusContext.async.computeServer.remove(removeList).blockingGet()
    }

    private Map<String, ComputeServerType> getAllComputeServerTypes() {
        this.@computeServerTypes ?: (this.@computeServerTypes = morpheusContext.async.cloud.getComputeServerTypes(cloud.id).blockingGet().collectEntries {[it.code, it]})
    }
}
