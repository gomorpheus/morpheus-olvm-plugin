/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Bonding;
import org.ovirt.engine.sdk4.types.BootProtocol;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.HostNicVirtualFunctionsConfiguration;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.Mac;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkLabel;
import org.ovirt.engine.sdk4.types.NicStatus;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.Vlan;

public class HostNicContainer extends IdentifiedContainer implements HostNic {
    private BigInteger adAggregatorId;
    private String baseInterface;
    private Bonding bonding;
    private BootProtocol bootProtocol;
    private Boolean bridged;
    private Boolean checkConnectivity;
    private Boolean customConfiguration;
    private Ip ip;
    private Ip ipv6;
    private BootProtocol ipv6BootProtocol;
    private Mac mac;
    private BigInteger mtu;
    private Boolean overrideConfiguration;
    private List<Property> properties;
    private BigInteger speed;
    private NicStatus status;
    private HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration;
    private Vlan vlan;
    private Host host;
    private Network network;
    private List<NetworkLabel> networkLabels;
    private HostNic physicalFunction;
    private Qos qos;
    private List<Statistic> statistics;
    
    public BigInteger adAggregatorId() {
        return adAggregatorId;
    }
    
    public Byte adAggregatorIdAsByte() {
        return asByte("HostNic", "adAggregatorId", adAggregatorId);
    }
    
    public Short adAggregatorIdAsShort() {
        return asShort("HostNic", "adAggregatorId", adAggregatorId);
    }
    
    public Integer adAggregatorIdAsInteger() {
        return asInteger("HostNic", "adAggregatorId", adAggregatorId);
    }
    
    public Long adAggregatorIdAsLong() {
        return asLong("HostNic", "adAggregatorId", adAggregatorId);
    }
    
    public void adAggregatorId(BigInteger newAdAggregatorId) {
        adAggregatorId = newAdAggregatorId;
    }
    
    public boolean adAggregatorIdPresent() {
        return adAggregatorId != null;
    }
    
    public String baseInterface() {
        return baseInterface;
    }
    
    public void baseInterface(String newBaseInterface) {
        baseInterface = newBaseInterface;
    }
    
    public boolean baseInterfacePresent() {
        return baseInterface != null;
    }
    
    public Bonding bonding() {
        return bonding;
    }
    
    public void bonding(Bonding newBonding) {
        bonding = newBonding;
    }
    
    public boolean bondingPresent() {
        return bonding != null;
    }
    
    public BootProtocol bootProtocol() {
        return bootProtocol;
    }
    
    public void bootProtocol(BootProtocol newBootProtocol) {
        bootProtocol = newBootProtocol;
    }
    
    public boolean bootProtocolPresent() {
        return bootProtocol != null;
    }
    
    public boolean bridged() {
        return bridged;
    }
    
    public void bridged(boolean newBridged) {
        bridged = Boolean.valueOf(newBridged);
    }
    
    public void bridged(Boolean newBridged) {
        bridged = newBridged;
    }
    
    public boolean bridgedPresent() {
        return bridged != null;
    }
    
    public boolean checkConnectivity() {
        return checkConnectivity;
    }
    
    public void checkConnectivity(boolean newCheckConnectivity) {
        checkConnectivity = Boolean.valueOf(newCheckConnectivity);
    }
    
    public void checkConnectivity(Boolean newCheckConnectivity) {
        checkConnectivity = newCheckConnectivity;
    }
    
    public boolean checkConnectivityPresent() {
        return checkConnectivity != null;
    }
    
    public boolean customConfiguration() {
        return customConfiguration;
    }
    
    public void customConfiguration(boolean newCustomConfiguration) {
        customConfiguration = Boolean.valueOf(newCustomConfiguration);
    }
    
    public void customConfiguration(Boolean newCustomConfiguration) {
        customConfiguration = newCustomConfiguration;
    }
    
    public boolean customConfigurationPresent() {
        return customConfiguration != null;
    }
    
    public Ip ip() {
        return ip;
    }
    
    public void ip(Ip newIp) {
        ip = newIp;
    }
    
    public boolean ipPresent() {
        return ip != null;
    }
    
    public Ip ipv6() {
        return ipv6;
    }
    
    public void ipv6(Ip newIpv6) {
        ipv6 = newIpv6;
    }
    
    public boolean ipv6Present() {
        return ipv6 != null;
    }
    
    public BootProtocol ipv6BootProtocol() {
        return ipv6BootProtocol;
    }
    
    public void ipv6BootProtocol(BootProtocol newIpv6BootProtocol) {
        ipv6BootProtocol = newIpv6BootProtocol;
    }
    
    public boolean ipv6BootProtocolPresent() {
        return ipv6BootProtocol != null;
    }
    
    public Mac mac() {
        return mac;
    }
    
    public void mac(Mac newMac) {
        mac = newMac;
    }
    
    public boolean macPresent() {
        return mac != null;
    }
    
    public BigInteger mtu() {
        return mtu;
    }
    
    public Byte mtuAsByte() {
        return asByte("HostNic", "mtu", mtu);
    }
    
    public Short mtuAsShort() {
        return asShort("HostNic", "mtu", mtu);
    }
    
    public Integer mtuAsInteger() {
        return asInteger("HostNic", "mtu", mtu);
    }
    
    public Long mtuAsLong() {
        return asLong("HostNic", "mtu", mtu);
    }
    
    public void mtu(BigInteger newMtu) {
        mtu = newMtu;
    }
    
    public boolean mtuPresent() {
        return mtu != null;
    }
    
    public boolean overrideConfiguration() {
        return overrideConfiguration;
    }
    
    public void overrideConfiguration(boolean newOverrideConfiguration) {
        overrideConfiguration = Boolean.valueOf(newOverrideConfiguration);
    }
    
    public void overrideConfiguration(Boolean newOverrideConfiguration) {
        overrideConfiguration = newOverrideConfiguration;
    }
    
    public boolean overrideConfigurationPresent() {
        return overrideConfiguration != null;
    }
    
    public List<Property> properties() {
        return makeUnmodifiableList(properties);
    }
    
    public void properties(List<Property> newProperties) {
        properties = makeArrayList(newProperties);
    }
    
    public boolean propertiesPresent() {
        return properties != null && !properties.isEmpty();
    }
    
    public BigInteger speed() {
        return speed;
    }
    
    public Byte speedAsByte() {
        return asByte("HostNic", "speed", speed);
    }
    
    public Short speedAsShort() {
        return asShort("HostNic", "speed", speed);
    }
    
    public Integer speedAsInteger() {
        return asInteger("HostNic", "speed", speed);
    }
    
    public Long speedAsLong() {
        return asLong("HostNic", "speed", speed);
    }
    
    public void speed(BigInteger newSpeed) {
        speed = newSpeed;
    }
    
    public boolean speedPresent() {
        return speed != null;
    }
    
    public NicStatus status() {
        return status;
    }
    
    public void status(NicStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration() {
        return virtualFunctionsConfiguration;
    }
    
    public void virtualFunctionsConfiguration(HostNicVirtualFunctionsConfiguration newVirtualFunctionsConfiguration) {
        virtualFunctionsConfiguration = newVirtualFunctionsConfiguration;
    }
    
    public boolean virtualFunctionsConfigurationPresent() {
        return virtualFunctionsConfiguration != null;
    }
    
    public Vlan vlan() {
        return vlan;
    }
    
    public void vlan(Vlan newVlan) {
        vlan = newVlan;
    }
    
    public boolean vlanPresent() {
        return vlan != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public Network network() {
        return network;
    }
    
    public void network(Network newNetwork) {
        network = newNetwork;
    }
    
    public boolean networkPresent() {
        return network != null;
    }
    
    public List<NetworkLabel> networkLabels() {
        return makeUnmodifiableList(networkLabels);
    }
    
    public void networkLabels(List<NetworkLabel> newNetworkLabels) {
        networkLabels = makeArrayList(newNetworkLabels);
    }
    
    public boolean networkLabelsPresent() {
        return networkLabels != null && !networkLabels.isEmpty();
    }
    
    public HostNic physicalFunction() {
        return physicalFunction;
    }
    
    public void physicalFunction(HostNic newPhysicalFunction) {
        physicalFunction = newPhysicalFunction;
    }
    
    public boolean physicalFunctionPresent() {
        return physicalFunction != null;
    }
    
    public Qos qos() {
        return qos;
    }
    
    public void qos(Qos newQos) {
        qos = newQos;
    }
    
    public boolean qosPresent() {
        return qos != null;
    }
    
    public List<Statistic> statistics() {
        return makeUnmodifiableList(statistics);
    }
    
    public void statistics(List<Statistic> newStatistics) {
        statistics = makeArrayList(newStatistics);
    }
    
    public boolean statisticsPresent() {
        return statistics != null && !statistics.isEmpty();
    }
    
}
