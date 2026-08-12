package com.morpheus.olvm.sync

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.util.NetworkUtility
import com.morpheusdata.core.util.SyncList
import com.morpheusdata.core.util.SyncTask
import com.morpheusdata.model.Account
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.Network as NetworkModel
import com.morpheusdata.model.projection.NetworkIdentityProjection
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable

@Slf4j
class NetworkSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Map connection

    public NetworkSync(OlvmCloudPlugin plugin, MorpheusContext ctx, Cloud cloud, Map connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@morpheusContext = ctx
        this.@connection = connection
    }

    def execute() {
        log.debug("Starting OLVM network sync for cloud {}", cloud.name)
        try {
            if (!this.@connection)
                this.@connection = OlvmComputeUtility.getToken(cloud)

            def olvmNetworks = OlvmComputeUtility.listNetworks([connection:connection]).data.networks
			// for network IP assignment, we have to pull from the hosts since the network attachment info is not included in the network listing
			def hosts = OlvmComputeUtility.listHosts([connection:connection, includeNetworkAttachments: true]).data.hosts
			def networkIpAssignments = extractNetworkIpAddressAssignments(hosts)
			olvmNetworks.each { network ->
				network.ipAssignment = networkIpAssignments[network.type == 'profile' ? network.profileNetworkId : network.id]
			}
			// filter by datacenter
			if(cloud.configMap.datacenter && cloud.configMap.datacenter?.toString() != 'all') {
				def datacenterId = cloud.configMap.datacenter.toString()
				olvmNetworks = olvmNetworks.findAll { it.datacenterId == datacenterId }
			}
            Observable<NetworkIdentityProjection> domainRecords = morpheusContext.async.network.listIdentityProjections(
                new DataQuery().withFilters(
                    new DataFilter<String>('refType', 'ComputeZone'),
                    new DataFilter<String>('refId', cloud.id)
                )
            )
            SyncTask<NetworkIdentityProjection,Map,NetworkModel> syncTask = new SyncTask<>(domainRecords, olvmNetworks)
            syncTask.addMatchFunction { domainObject, cloudObject ->
                return domainObject.externalId == cloudObject.id
            }.onDelete { removeItems ->
                removeNetworks(removeItems)
            }.onUpdate { updateItems ->
                updateMatchedNetworks(updateItems)
            }.onAdd { addItems ->
                addMissingNetworks(addItems)
            }.withLoadObjectDetailsFromFinder { updateItems ->
                return morpheusContext.async.network.listById(updateItems.collect { return it.existingItem.id } as List<Long>)
            }.start()

            log.debug("Finished OLVM network sync for cloud {}", cloud.name)
            return ServiceResponse.success()
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM networks: ${t.message}", t)
        }
    }

    protected removeNetworks(List<NetworkIdentityProjection> removeItems) {
        morpheusContext.async.network.bulkRemove(removeItems).blockingGet()
    }

    protected addMissingNetworks(List<Map> addItems) {
        def adds = []
        for (cloudItem in addItems) {
            def networkTypeCode = cloudItem.type == 'network' ? 'olvm-logical-network' : 'olvm-vnic-profile'
            def networkType =
                morpheusContext.async.network.type.search(new DataQuery().withFilter(new DataFilter<String>('code', networkTypeCode))).blockingGet().items?.first()

            // Check to see if network belongs to a data center
            def datacenter
            if (cloudItem.datacenterId) {
                def datacenters =
                    morpheusContext.async.cloud.pool.search(new DataQuery().withFilter(new DataFilter<String>('externalId', cloudItem.datacenterId))).blockingGet()
                datacenter = datacenters.items?.first()
            }

            def networkConfig = [
                owner: new Account(id:cloud.defaultNetworkSyncAccount ?: cloud.owner.id),
                category:"olvm.plugin.netork.${cloud.id}",
                name:cloudItem.name,
                displayName:cloudItem.name,
                code:"olvm.plugin.network.${cloud.id}.${cloudItem.id}",
                uniqueId:cloudItem.id,
                externalId:cloudItem.id,
                externalType:cloudItem.type,
                type:networkType,
                refType:'ComputeZone',
                refId:cloud.id,
                cloudPool:datacenter,
                description:cloudItem.description,
                active:cloud.defaultNetworkSyncActive ? (cloudItem.provisionable) : false,
                //active:network.statusPresent() ? network.status() == NetworkStatus.OPERATIONAL : true,
                cidr: networkIpAssignmentToCidr(cloudItem.ipAssignment) ?: '0.0.0.0/1',
                dhcpServer: cloudItem.ipAssignment?.assignment_method == 'dhcp',
                allowStaticOverride:true,
                cloud:cloud
            ]
            def add = new NetworkModel(networkConfig)
            adds << add
        }
        if (adds) {
            morpheusContext.async.network.create(adds).blockingGet()
        }
    }

    protected updateMatchedNetworks(List<SyncList.UpdateItem<NetworkModel,Map>> updateItems) {
        def updates = []
        for (updateItem in updateItems) {
            def masterItem = updateItem.masterItem
            def existingItem = updateItem.existingItem
            def save = false
            def description = masterItem.description
            def cidr = networkIpAssignmentToCidr(masterItem.ipAssignment)
            def dhcpServer = masterItem.ipAssignment?.assignment_method == 'dhcp'

            if (existingItem.name != masterItem.name) {
                existingItem.name = masterItem.name
                existingItem.displayName = masterItem.name
                save = true
            }
            if (existingItem.displayName != masterItem.name) {
                existingItem.displayName = masterItem.name
                save = true
            }
            if (existingItem.description != description) {
                existingItem.description = description
                save = true
            }
            // only overwrite the placeholder cidr once we learn the real one from the host network attachment;
            // never clobber a real cidr the network already has (e.g. one previously discovered or set by a user)
            if (cidr && cidr != existingItem.cidr && (!existingItem.cidr || existingItem.cidr == '0.0.0.0/1')) {
                existingItem.cidr = cidr
                save = true
            }
            if (existingItem.dhcpServer != dhcpServer) {
                existingItem.dhcpServer = dhcpServer
                save = true
            }
            if (save)
                updates << existingItem
        }
        if (updates)
            morpheusContext.async.network.save(updates).blockingGet()
    }

    // computes a CIDR string from an oVirt ip_address_assignment (host network_attachment), if available
    protected String networkIpAssignmentToCidr(ipAssignment) {
        def address = ipAssignment?.ip?.address
        def netmask = ipAssignment?.ip?.netmask
        if (!address || !netmask) {
            return null
        }
        return NetworkUtility.networkToCidr(address, netmask)
    }

	def extractNetworkIpAddressAssignments(hosts) {
		def assignmentsByNetwork = [:]
		try {
			hosts.each { host ->
				def attachments = host.network_attachments?.network_attachment
				attachments?.each { attachment ->
					def networkId = attachment.network?.id
					if(networkId) {
						def ipAssignment = attachment.ip_address_assignments?.ip_address_assignment?.find { it.ip?.version == 'v4' }
						if (ipAssignment) {
							assignmentsByNetwork[networkId] = ipAssignment
						}
					}
				}
			}
		} catch (e) {
			log.error("Error extracting network IP address assignments: ${e}", e)
		}
		return assignmentsByNetwork
	}
}