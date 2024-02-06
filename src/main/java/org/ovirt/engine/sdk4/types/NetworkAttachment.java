/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Describes how a host connects to a network.
 * 
 * An XML representation of a network attachment on a host:
 * 
 * [source,xml]
 * ----
 * <network_attachment href="/ovirt-engine/api/hosts/123/nics/456/networkattachments/789" id="789">
 *   <network href="/ovirt-engine/api/networks/234" id="234"/>
 *   <host_nic href="/ovirt-engine/api/hosts/123/nics/123" id="123"/>
 *   <in_sync>true</in_sync>
 *   <ip_address_assignments>
 *     <ip_address_assignment>
 *       <assignment_method>static</assignment_method>
 *       <ip>
 *         <address>192.168.122.39</address>
 *         <gateway>192.168.122.1</gateway>
 *         <netmask>255.255.255.0</netmask>
 *         <version>v4</version>
 *       </ip>
 *     </ip_address_assignment>
 *   </ip_address_assignments>
 *   <reported_configurations>
 *     <reported_configuration>
 *       <name>mtu</name>
 *       <expected_value>1500</expected_value>
 *       <actual_value>1500</actual_value>
 *       <in_sync>true</in_sync>
 *     </reported_configuration>
 *     <reported_configuration>
 *       <name>bridged</name>
 *       <expected_value>true</expected_value>
 *       <actual_value>true</actual_value>
 *       <in_sync>true</in_sync>
 *     </reported_configuration>
 *     ...
 *   </reported_configurations>
 * </network_attachment>
 * ----
 * 
 * The network element, with either a `name` or an `id`, is required in order to attach a network
 * to a network interface card (NIC).
 * 
 * For example, to attach a network to a host network interface card, send a request like this:
 * 
 * [source]
 * ----
 * POST /ovirt-engine/api/hosts/123/nics/456/networkattachments
 * ----
 * 
 * With a request body like this:
 * 
 * [source,xml]
 * ----
 * <networkattachment>
 *   <network id="234"/>
 * </networkattachment>
 * ----
 * 
 * To attach a network to a host, send a request like this:
 * 
 * [source]
 * ----
 * POST /ovirt-engine/api/hosts/123/networkattachments
 * ----
 * 
 * With a request body like this:
 * 
 * [source,xml]
 * ----
 * <network_attachment>
 *   <network id="234"/>
 *   <host_nic id="456"/>
 * </network_attachment>
 * ----
 * 
 * The `ip_address_assignments` and `properties` elements are updatable post-creation.
 * 
 * For example, to update a network attachment, send a request like this:
 * 
 * [source]
 * ----
 * PUT /ovirt-engine/api/hosts/123/nics/456/networkattachments/789
 * ----
 * 
 * With a request body like this:
 * 
 * [source,xml]
 * ----
 * <network_attachment>
 *   <ip_address_assignments>
 *     <ip_address_assignment>
 *       <assignment_method>static</assignment_method>
 *       <ip>
 *         <address>7.1.1.1</address>
 *         <gateway>7.1.1.2</gateway>
 *         <netmask>255.255.255.0</netmask>
 *         <version>v4</version>
 *       </ip>
 *     </ip_address_assignment>
 *   </ip_address_assignments>
 * </network_attachment>
 * ----
 * 
 * To detach a network from the network interface card send a request like this:
 * 
 * [source]
 * ----
 * DELETE /ovirt-engine/api/hosts/123/nics/456/networkattachments/789
 * ----
 * 
 * IMPORTANT: Changes to network attachment configuration must be explicitly committed.
 * 
 * An XML representation of a network attachment's `properties` sub-collection:
 * 
 * [source, xml]
 * ----
 * <network_attachment>
 *   <properties>
 *     <property>
 *       <name>bridge_opts</name>
 *       <value>
 *         forward_delay=1500 group_fwd_mask=0x0 multicast_snooping=1
 *       </value>
 *     </property>
 *   </properties>
 *   ...
 * </network_attachment>
 * ----
 */
public interface NetworkAttachment extends Identified {
    DnsResolverConfiguration dnsResolverConfiguration();
    
    boolean dnsResolverConfigurationPresent();
    
    boolean inSync();
    
    boolean inSyncPresent();
    
    List<IpAddressAssignment> ipAddressAssignments();
    
    boolean ipAddressAssignmentsPresent();
    
    List<Property> properties();
    
    boolean propertiesPresent();
    
    List<ReportedConfiguration> reportedConfigurations();
    
    boolean reportedConfigurationsPresent();
    
    Host host();
    
    boolean hostPresent();
    
    HostNic hostNic();
    
    boolean hostNicPresent();
    
    Network network();
    
    boolean networkPresent();
    
    Qos qos();
    
    boolean qosPresent();
    
}
