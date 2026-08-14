package com.morpheus.olvm.sync

import com.morpheusdata.core.network.MorpheusNetworkService
import com.morpheusdata.core.MorpheusAsyncServices
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.util.SyncList
import com.morpheusdata.model.Network as NetworkModel
import io.reactivex.rxjava3.core.Single
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Covers the CIDR/DHCP resolution helper used by NetworkSync when
 * building/updating networks from OLVM host network_attachment data.
 * MORPH-15725: networks previously stopped getting real cidr/dhcp values
 * refreshed after creation because updateMatchedNetworks() never looked
 * at the host ip assignment data and cidr was hardcoded to a placeholder.
 */
class NetworkSyncSpec extends Specification {

	NetworkSync networkSync = new NetworkSync(null, null, null, [:])

	@Unroll
	def "networkIpAssignmentToCidr computes cidr from ip and netmask"() {
		given:
		def ipAssignment = [ip: [address: address, netmask: netmask]]

		expect:
		networkSync.networkIpAssignmentToCidr(ipAssignment) == expectedCidr

		where:
		address        | netmask         | expectedCidr
		'10.32.148.1'  | '255.255.252.0' | '10.32.148.1/22'
		'192.168.1.10' | '255.255.255.0' | '192.168.1.10/24'
	}

	def "networkIpAssignmentToCidr returns null when ip assignment is missing"() {
		expect:
		networkSync.networkIpAssignmentToCidr(null) == null
	}

	def "networkIpAssignmentToCidr returns null when address or netmask are missing"() {
		expect:
		networkSync.networkIpAssignmentToCidr([ip: [address: '10.32.148.1']]) == null
		networkSync.networkIpAssignmentToCidr([ip: [netmask: '255.255.252.0']]) == null
	}

	def "updateMatchedNetworks refreshes a placeholder cidr and dhcp flag from host ip assignment data"() {
		given:
		def existingItem = new NetworkModel(cidr: '0.0.0.0/1', dhcpServer: false)
		def masterItem = [
			name: 'VLAN2063',
			description: 'VLAN2063',
			ipAssignment: [assignment_method: 'dhcp', ip: [address: '10.32.148.1', netmask: '255.255.252.0']]
		]
		def updateItem = new SyncList.UpdateItem<NetworkModel, Map>(existingItem, masterItem, false)
		def morpheusContext = Mock(MorpheusContext)
		def asyncContext = Mock(MorpheusAsyncServices)
		def networkContext = Mock(MorpheusNetworkService)
		morpheusContext.async >> asyncContext
		asyncContext.network >> networkContext
		networkContext.save(_) >> Single.just(true)
		networkSync.@morpheusContext = morpheusContext

		when:
		networkSync.updateMatchedNetworks([updateItem])

		then:
		existingItem.cidr == '10.32.148.1/22'
		existingItem.dhcpServer == true
	}

	def "updateMatchedNetworks does not clobber a real cidr the network already has"() {
		given:
		def existingItem = new NetworkModel(cidr: '10.10.10.0/24', dhcpServer: true)
		def masterItem = [
			name: 'VLAN2063',
			description: 'VLAN2063',
			ipAssignment: [assignment_method: 'dhcp', ip: [address: '10.32.148.1', netmask: '255.255.252.0']]
		]
		def updateItem = new SyncList.UpdateItem<NetworkModel, Map>(existingItem, masterItem, false)
		def morpheusContext = Mock(MorpheusContext)
		def asyncContext = Mock(MorpheusAsyncServices)
		def networkContext = Mock(MorpheusNetworkService)
		morpheusContext.async >> asyncContext
		asyncContext.network >> networkContext
		networkContext.save(_) >> Single.just(true)
		networkSync.@morpheusContext = morpheusContext

		when:
		networkSync.updateMatchedNetworks([updateItem])

		then:
		existingItem.cidr == '10.10.10.0/24'
	}

	def "updateMatchedNetworks does not clobber a known dhcpServer=true when no host attachment data is found"() {
		// MORPH-15890: VM-only networks (e.g. VLAN2063) are consumed via vnic profiles and are
		// rarely attached directly to a host NIC, so masterItem.ipAssignment is null on most
		// syncs even though the network really is DHCP-based. Missing attachment data must not
		// be treated as proof the network is static.
		given:
		def existingItem = new NetworkModel(cidr: '10.32.148.0/22', dhcpServer: true)
		def masterItem = [
			name: 'VLAN2063',
			description: 'VLAN2063',
			ipAssignment: null
		]
		def updateItem = new SyncList.UpdateItem<NetworkModel, Map>(existingItem, masterItem, false)
		def morpheusContext = Mock(MorpheusContext)
		def asyncContext = Mock(MorpheusAsyncServices)
		def networkContext = Mock(MorpheusNetworkService)
		morpheusContext.async >> asyncContext
		asyncContext.network >> networkContext
		networkContext.save(_) >> Single.just(true)
		networkSync.@morpheusContext = morpheusContext

		when:
		networkSync.updateMatchedNetworks([updateItem])

		then:
		existingItem.dhcpServer == true
	}

	def "updateMatchedNetworks does not clobber a known dhcpServer=true when host attachment reports assignment_method 'none'"() {
		// MORPH-15890 (live repro): every OLVM host reports assignment_method 'none' for VM-only
		// bridged networks like VLAN2063, because the host itself has no IP on that interface.
		// This is real, present ipAssignment data - not absence of data - but it says nothing
		// about whether guest VMs on the network are addressed via DHCP, and must not clobber
		// an already-known true value.
		given:
		def existingItem = new NetworkModel(cidr: '10.32.148.0/22', dhcpServer: true)
		def masterItem = [
			name: 'VLAN2063',
			description: 'VLAN2063',
			ipAssignment: [assignment_method: 'none', ip: [version: 'v4']]
		]
		def updateItem = new SyncList.UpdateItem<NetworkModel, Map>(existingItem, masterItem, false)
		def morpheusContext = Mock(MorpheusContext)
		def asyncContext = Mock(MorpheusAsyncServices)
		def networkContext = Mock(MorpheusNetworkService)
		morpheusContext.async >> asyncContext
		asyncContext.network >> networkContext
		networkContext.save(_) >> Single.just(true)
		networkSync.@morpheusContext = morpheusContext

		when:
		networkSync.updateMatchedNetworks([updateItem])

		then:
		existingItem.dhcpServer == true
	}

	def "updateMatchedNetworks updates dhcpServer when host attachment data is found"() {
		given:
		def existingItem = new NetworkModel(cidr: '10.32.148.0/22', dhcpServer: false)
		def masterItem = [
			name: 'VLAN2063',
			description: 'VLAN2063',
			ipAssignment: [assignment_method: 'dhcp', ip: [address: '10.32.148.1', netmask: '255.255.252.0']]
		]
		def updateItem = new SyncList.UpdateItem<NetworkModel, Map>(existingItem, masterItem, false)
		def morpheusContext = Mock(MorpheusContext)
		def asyncContext = Mock(MorpheusAsyncServices)
		def networkContext = Mock(MorpheusNetworkService)
		morpheusContext.async >> asyncContext
		asyncContext.network >> networkContext
		networkContext.save(_) >> Single.just(true)
		networkSync.@morpheusContext = morpheusContext

		when:
		networkSync.updateMatchedNetworks([updateItem])

		then:
		existingItem.dhcpServer == true
	}
}
