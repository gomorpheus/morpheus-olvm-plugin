package com.morpheus.olvm.sync

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.util.SyncTask
import com.morpheusdata.core.util.SyncUtils
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.CloudPool
import com.morpheusdata.model.ComputeServer
import com.morpheusdata.model.ComputeServerType
import com.morpheusdata.model.OsType
import com.morpheusdata.model.ServicePlan
import com.morpheusdata.model.projection.ComputeServerIdentityProjection
import com.morpheusdata.model.projection.ServicePlanIdentityProjection
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.VmContainer
import org.ovirt.engine.sdk4.types.VmStatus

@Slf4j
class VirtualMachineSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Connection connection
    private Map<String, ComputeServerType> computeServerTypes
    private List<ServicePlan> servicePlans

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
            if (cloud.configMap.importExisting == 'on') {
                if (!connection)
                    connection = OlvmComputeUtility.getConnection(cloud)

                def olvmVms = connection.systemService().vmsService().list().send().vms()
                Observable<ComputeServerIdentityProjection> domainRecords = morpheusContext.async.computeServer.listIdentityProjections(cloud.id, null)

                SyncTask<ComputeServerIdentityProjection, VmContainer, ComputeServer> syncTask = new SyncTask<>(domainRecords, olvmVms)
                syncTask.addMatchFunction { ComputeServerIdentityProjection existingItem, VmContainer cloudItem ->
                    return existingItem.externalId == cloudItem.id()
                }.onDelete { removeItems ->
                    removeVirtualMachines(removeItems)
                }.onUpdate { List<SyncTask.UpdateItem<ComputeServer, VmContainer>> updateItems ->
                    updateMatchedVirtualMachines(updateItems)
                }.onAdd { itemsToAdd ->
                    addMissingVirtualMachines(itemsToAdd)
                }.withLoadObjectDetailsFromFinder { List<SyncTask.UpdateItemDto<ComputeServerIdentityProjection, ComputeServer>> updateItems ->
                    morpheusContext.async.computeServer.listById(updateItems.collect { it.existingItem.id } as List<Long>)
                }.start()
            }
            else {
                log.info("Inventory existing VMs is turned off")
            }
            log.info("Completed OLVM virtual machine sync for cloud ${cloud.name}")
            return ServiceResponse.success()
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM clusters: ${t.message}", t)
        }
    }

    def addMissingVirtualMachines(List<VmContainer> vms) {
        ServicePlan fallbackPlan = allServicePlans.find {it.code == 'olvm.plugin.custom'}
        List<ComputeServer> adds = []
        for (vm in vms) {
            def vmDetails = OlvmComputeUtility.getServerDetail([connection:connection, serverId:vm.id()]).data
            def servicePlan = SyncUtils.findServicePlanBySizing(allServicePlans, vmDetails.memory.toLong(), vmDetails.cores.toLong(), vmDetails.sockets.toLong(), fallbackPlan)
            def zonePool = morpheusContext.async.cloud.pool.find(new DataQuery().withFilter('externalId', vmDetails.clusterId)).blockingGet()
            def osType = vm.os().type()
            def primaryIp = vmDetails.ipV4 ? vmDetails.ipV4.first() : ''
            ComputeServer add = new ComputeServer(
                account: cloud.account,
                externalId: vm.id(),
                resourcePool: zonePool ? new CloudPool(id: zonePool.id) : null,
                name: vm.name(),
                externalIp: primaryIp,
                internalIp: primaryIp,
                sshHost: primaryIp,
                serverType: 'vm',
                sshUsername: 'root',
                apiKey: java.util.UUID.randomUUID(),
                provision: false,
                singleTenant: true,
                cloud: cloud,
                discovered: true,
                managed: false,
                status: 'provisioned',
                powerState: vm.status() == VmStatus.UP ? ComputeServer.PowerState.on : ComputeServer.PowerState.off,
                osType: osType,
                serverOs: morpheusContext.async.osType.find(new DataQuery().withFilters(new DataFilter<String>('code', OlvmComputeUtility.getOsTypeCode(osType)))).blockingGet(),
                computeServerType: allComputeServerTypes[osType == 'windows' ? 'olvmWindowsVm' : 'olvmUnmanaged'],
                maxMemory: servicePlan?.maxMemory
            )
            if (servicePlan) {
                applyServicePlan(add, servicePlan)
            }
            adds << add
        }

        if (adds) {
            morpheusContext.async.computeServer.bulkCreate(adds).blockingGet()
        }
    }

    def updateMatchedVirtualMachines(updateItems) {
        def saves = []
        for(update in updateItems) {
            ComputeServer currentServer = update.existingItem
            VmContainer cloudItem = update.masterItem

            if (currentServer.status != 'provisioning') {
                try {
                    def vmDetails = OlvmComputeUtility.getServerDetail([connection:connection, serverId:cloudItem.id()]).data
                    def save = false
                    def powerState = cloudItem.status() == VmStatus.UP ? ComputeServer.PowerState.on : ComputeServer.PowerState.off
                    def zonePool = morpheusContext.async.cloud.pool.find(new DataQuery().withFilter('externalId', vmDetails.clusterId)).blockingGet()

                    if (cloudItem.name() != currentServer.name) {
                        currentServer.name = cloudItem.name()
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
                    def primaryIp = vmDetails.ipV4 ? vmDetails.ipV4.first() : ''
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

    def removeVirtualMachines(List<ComputeServerIdentityProjection> removeList) {
        log.debug "removeMissingVirtualMachines: ${cloud} ${removeList.size()}"
        morpheusContext.async.computeServer.remove(removeList).blockingGet()
    }

    private applyServicePlan(ComputeServer server, ServicePlan servicePlan) {
        server.plan = servicePlan
        server.maxCores = servicePlan.maxCores
        server.maxCpu = servicePlan.maxCpu
        server.maxMemory = servicePlan.maxMemory
        if(server.computeCapacityInfo) {
            server.computeCapacityInfo.maxCores = server.maxCores
            server.computeCapacityInfo.maxCpu = server.maxCpu
            server.computeCapacityInfo.maxMemory = server.maxMemory
        }
    }

    private ComputeServer saveAndGet(ComputeServer server) {
        def saveSuccessful = morpheusContext.async.computeServer.save([server]).blockingGet()
        if(!saveSuccessful) {
            log.warn("Error saving server: ${server?.id}" )
        }
        return morpheusContext.async.computeServer.get(server.id).blockingGet()
    }

    private Map<String, ComputeServerType> getAllComputeServerTypes() {
        this.@computeServerTypes ?: (this.@computeServerTypes = morpheusContext.async.cloud.getComputeServerTypes(cloud.id).blockingGet().collectEntries {[it.code, it]})
    }

    private List<ServicePlan> getAllServicePlans() {
        if (!this.@servicePlans) {
            this.@servicePlans = []
            morpheusContext.async.servicePlan.list(new DataQuery().withFilter(new DataFilter<String>('provisionType.code', this.@plugin.getCloudProvider().getDefaultProvisionTypeCode()))).blockingSubscribe {
                this.@servicePlans << it
            }
        }
        return this.@servicePlans
    }
}
