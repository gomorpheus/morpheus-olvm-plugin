/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * Represents a host NIC.
 * 
 * For example, the XML representation of a host NIC looks like this:
 * 
 * [source,xml]
 * ----
 * <host_nic href="/ovirt-engine/api/hosts/123/nics/456" id="456">
 *   <name>eth0</name>
 *   <boot_protocol>static</boot_protocol>
 *   <bridged>true</bridged>
 *   <custom_configuration>true</custom_configuration>
 *   <ip>
 *     <address>192.168.122.39</address>
 *     <gateway>192.168.122.1</gateway>
 *     <netmask>255.255.255.0</netmask>
 *     <version>v4</version>
 *   </ip>
 *   <ipv6>
 *     <gateway>::</gateway>
 *     <version>v6</version>
 *   </ipv6>
 *   <ipv6_boot_protocol>none</ipv6_boot_protocol>
 *   <mac>
 *     <address>52:54:00:0c:79:1d</address>
 *   </mac>
 *   <mtu>1500</mtu>
 *   <status>up</status>
 * </host_nic>
 * ----
 * 
 * A bonded interface is represented as a <<types/host_nic, HostNic>> object
 * containing the `bonding` and `slaves` attributes.
 * 
 * For example, the XML representation of a bonded host NIC looks like this:
 * 
 * [source,xml]
 * ----
 * <host_nic href="/ovirt-engine/api/hosts/123/nics/456" id="456">
 *   <name>bond0</name>
 *   <mac address="00:00:00:00:00:00"/>
 *   <ip>
 *     <address>192.168.122.39</address>
 *     <gateway>192.168.122.1</gateway>
 *     <netmask>255.255.255.0</netmask>
 *     <version>v4</version>
 *   </ip>
 *   <boot_protocol>dhcp</boot_protocol>
 *   <bonding>
 *     <options>
 *       <option>
 *         <name>mode</name>
 *         <value>4</value>
 *         <type>Dynamic link aggregation (802.3ad)</type>
 *       </option>
 *       <option>
 *         <name>miimon</name>
 *         <value>100</value>
 *       </option>
 *     </options>
 *     <slaves>
 *       <host_nic id="123"/>
 *       <host_nic id="456"/>
 *     </slaves>
 *   </bonding>
 *   <mtu>1500</mtu>
 *   <bridged>true</bridged>
 *   <custom_configuration>false</custom_configuration>
 * </host_nic>
 * ----
 */
public interface HostNic extends Identified {
    BigInteger adAggregatorId();
    Byte adAggregatorIdAsByte();
    Short adAggregatorIdAsShort();
    Integer adAggregatorIdAsInteger();
    Long adAggregatorIdAsLong();
    
    boolean adAggregatorIdPresent();
    
    String baseInterface();
    
    boolean baseInterfacePresent();
    
    Bonding bonding();
    
    boolean bondingPresent();
    
    BootProtocol bootProtocol();
    
    boolean bootProtocolPresent();
    
    boolean bridged();
    
    boolean bridgedPresent();
    
    boolean checkConnectivity();
    
    boolean checkConnectivityPresent();
    
    boolean customConfiguration();
    
    boolean customConfigurationPresent();
    
    Ip ip();
    
    boolean ipPresent();
    
    Ip ipv6();
    
    boolean ipv6Present();
    
    BootProtocol ipv6BootProtocol();
    
    boolean ipv6BootProtocolPresent();
    
    Mac mac();
    
    boolean macPresent();
    
    BigInteger mtu();
    Byte mtuAsByte();
    Short mtuAsShort();
    Integer mtuAsInteger();
    Long mtuAsLong();
    
    boolean mtuPresent();
    
    boolean overrideConfiguration();
    
    boolean overrideConfigurationPresent();
    
    List<Property> properties();
    
    boolean propertiesPresent();
    
    BigInteger speed();
    Byte speedAsByte();
    Short speedAsShort();
    Integer speedAsInteger();
    Long speedAsLong();
    
    boolean speedPresent();
    
    NicStatus status();
    
    boolean statusPresent();
    
    HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration();
    
    boolean virtualFunctionsConfigurationPresent();
    
    Vlan vlan();
    
    boolean vlanPresent();
    
    Host host();
    
    boolean hostPresent();
    
    Network network();
    
    boolean networkPresent();
    
    List<NetworkLabel> networkLabels();
    
    boolean networkLabelsPresent();
    
    HostNic physicalFunction();
    
    boolean physicalFunctionPresent();
    
    Qos qos();
    
    boolean qosPresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
}
