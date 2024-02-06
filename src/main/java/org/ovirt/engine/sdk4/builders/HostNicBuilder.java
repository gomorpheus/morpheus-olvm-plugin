/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.HostNicContainer;
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

public class HostNicBuilder {
    private BigInteger adAggregatorId;
    private String baseInterface;
    private Bonding bonding;
    private BootProtocol bootProtocol;
    private Boolean bridged;
    private Boolean checkConnectivity;
    private String comment;
    private Boolean customConfiguration;
    private String description;
    private Host host;
    private String href;
    private String id;
    private Ip ip;
    private Ip ipv6;
    private BootProtocol ipv6BootProtocol;
    private Mac mac;
    private BigInteger mtu;
    private String name;
    private Network network;
    private List<NetworkLabel> networkLabels;
    private Boolean overrideConfiguration;
    private HostNic physicalFunction;
    private List<Property> properties;
    private Qos qos;
    private BigInteger speed;
    private List<Statistic> statistics;
    private NicStatus status;
    private HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration;
    private Vlan vlan;
    
    public HostNicBuilder adAggregatorId(int newAdAggregatorId) {
        adAggregatorId = BigInteger.valueOf((long) newAdAggregatorId);
        return this;
    }
    
    public HostNicBuilder adAggregatorId(Integer newAdAggregatorId) {
        if (newAdAggregatorId == null) {
            adAggregatorId = null;
        }
        else {
            adAggregatorId = BigInteger.valueOf(newAdAggregatorId.longValue());
        }
        return this;
    }
    
    public HostNicBuilder adAggregatorId(long newAdAggregatorId) {
        adAggregatorId = BigInteger.valueOf(newAdAggregatorId);
        return this;
    }
    
    public HostNicBuilder adAggregatorId(Long newAdAggregatorId) {
        if (newAdAggregatorId == null) {
            adAggregatorId = null;
        }
        else {
            adAggregatorId = BigInteger.valueOf(newAdAggregatorId.longValue());
        }
        return this;
    }
    
    public HostNicBuilder adAggregatorId(BigInteger newAdAggregatorId) {
        adAggregatorId = newAdAggregatorId;
        return this;
    }
    
    
    public HostNicBuilder baseInterface(String newBaseInterface) {
        baseInterface = newBaseInterface;
        return this;
    }
    
    
    public HostNicBuilder bonding(Bonding newBonding) {
        bonding = newBonding;
        return this;
    }
    
    public HostNicBuilder bonding(BondingBuilder newBonding) {
        if (newBonding == null) {
            bonding = null;
        }
        else {
            bonding = newBonding.build();
        }
        return this;
    }
    
    
    public HostNicBuilder bootProtocol(BootProtocol newBootProtocol) {
        bootProtocol = newBootProtocol;
        return this;
    }
    
    
    public HostNicBuilder bridged(boolean newBridged) {
        bridged = Boolean.valueOf(newBridged);
        return this;
    }
    
    public HostNicBuilder bridged(Boolean newBridged) {
        bridged = newBridged;
        return this;
    }
    
    
    public HostNicBuilder checkConnectivity(boolean newCheckConnectivity) {
        checkConnectivity = Boolean.valueOf(newCheckConnectivity);
        return this;
    }
    
    public HostNicBuilder checkConnectivity(Boolean newCheckConnectivity) {
        checkConnectivity = newCheckConnectivity;
        return this;
    }
    
    
    public HostNicBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public HostNicBuilder customConfiguration(boolean newCustomConfiguration) {
        customConfiguration = Boolean.valueOf(newCustomConfiguration);
        return this;
    }
    
    public HostNicBuilder customConfiguration(Boolean newCustomConfiguration) {
        customConfiguration = newCustomConfiguration;
        return this;
    }
    
    
    public HostNicBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public HostNicBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public HostNicBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public HostNicBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public HostNicBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public HostNicBuilder ip(Ip newIp) {
        ip = newIp;
        return this;
    }
    
    public HostNicBuilder ip(IpBuilder newIp) {
        if (newIp == null) {
            ip = null;
        }
        else {
            ip = newIp.build();
        }
        return this;
    }
    
    
    public HostNicBuilder ipv6(Ip newIpv6) {
        ipv6 = newIpv6;
        return this;
    }
    
    public HostNicBuilder ipv6(IpBuilder newIpv6) {
        if (newIpv6 == null) {
            ipv6 = null;
        }
        else {
            ipv6 = newIpv6.build();
        }
        return this;
    }
    
    
    public HostNicBuilder ipv6BootProtocol(BootProtocol newIpv6BootProtocol) {
        ipv6BootProtocol = newIpv6BootProtocol;
        return this;
    }
    
    
    public HostNicBuilder mac(Mac newMac) {
        mac = newMac;
        return this;
    }
    
    public HostNicBuilder mac(MacBuilder newMac) {
        if (newMac == null) {
            mac = null;
        }
        else {
            mac = newMac.build();
        }
        return this;
    }
    
    
    public HostNicBuilder mtu(int newMtu) {
        mtu = BigInteger.valueOf((long) newMtu);
        return this;
    }
    
    public HostNicBuilder mtu(Integer newMtu) {
        if (newMtu == null) {
            mtu = null;
        }
        else {
            mtu = BigInteger.valueOf(newMtu.longValue());
        }
        return this;
    }
    
    public HostNicBuilder mtu(long newMtu) {
        mtu = BigInteger.valueOf(newMtu);
        return this;
    }
    
    public HostNicBuilder mtu(Long newMtu) {
        if (newMtu == null) {
            mtu = null;
        }
        else {
            mtu = BigInteger.valueOf(newMtu.longValue());
        }
        return this;
    }
    
    public HostNicBuilder mtu(BigInteger newMtu) {
        mtu = newMtu;
        return this;
    }
    
    
    public HostNicBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public HostNicBuilder network(Network newNetwork) {
        network = newNetwork;
        return this;
    }
    
    public HostNicBuilder network(NetworkBuilder newNetwork) {
        if (newNetwork == null) {
            network = null;
        }
        else {
            network = newNetwork.build();
        }
        return this;
    }
    
    
    public HostNicBuilder networkLabels(List<NetworkLabel> newNetworkLabels) {
        if (newNetworkLabels != null) {
            if (networkLabels == null) {
                networkLabels = new ArrayList<>(newNetworkLabels);
            }
            else {
                networkLabels.addAll(newNetworkLabels);
            }
        }
        return this;
    }
    
    public HostNicBuilder networkLabels(NetworkLabel... newNetworkLabels) {
        if (newNetworkLabels != null) {
            if (networkLabels == null) {
                networkLabels = new ArrayList<>(newNetworkLabels.length);
            }
            Collections.addAll(networkLabels, newNetworkLabels);
        }
        return this;
    }
    
    public HostNicBuilder networkLabels(NetworkLabelBuilder... newNetworkLabels) {
        if (newNetworkLabels != null) {
            if (networkLabels == null) {
                networkLabels = new ArrayList<>(newNetworkLabels.length);
            }
            for (NetworkLabelBuilder builder : newNetworkLabels) {
                networkLabels.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostNicBuilder overrideConfiguration(boolean newOverrideConfiguration) {
        overrideConfiguration = Boolean.valueOf(newOverrideConfiguration);
        return this;
    }
    
    public HostNicBuilder overrideConfiguration(Boolean newOverrideConfiguration) {
        overrideConfiguration = newOverrideConfiguration;
        return this;
    }
    
    
    public HostNicBuilder physicalFunction(HostNic newPhysicalFunction) {
        physicalFunction = newPhysicalFunction;
        return this;
    }
    
    public HostNicBuilder physicalFunction(HostNicBuilder newPhysicalFunction) {
        if (newPhysicalFunction == null) {
            physicalFunction = null;
        }
        else {
            physicalFunction = newPhysicalFunction.build();
        }
        return this;
    }
    
    
    public HostNicBuilder properties(List<Property> newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties);
            }
            else {
                properties.addAll(newProperties);
            }
        }
        return this;
    }
    
    public HostNicBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public HostNicBuilder properties(PropertyBuilder... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            for (PropertyBuilder builder : newProperties) {
                properties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostNicBuilder qos(Qos newQos) {
        qos = newQos;
        return this;
    }
    
    public HostNicBuilder qos(QosBuilder newQos) {
        if (newQos == null) {
            qos = null;
        }
        else {
            qos = newQos.build();
        }
        return this;
    }
    
    
    public HostNicBuilder speed(int newSpeed) {
        speed = BigInteger.valueOf((long) newSpeed);
        return this;
    }
    
    public HostNicBuilder speed(Integer newSpeed) {
        if (newSpeed == null) {
            speed = null;
        }
        else {
            speed = BigInteger.valueOf(newSpeed.longValue());
        }
        return this;
    }
    
    public HostNicBuilder speed(long newSpeed) {
        speed = BigInteger.valueOf(newSpeed);
        return this;
    }
    
    public HostNicBuilder speed(Long newSpeed) {
        if (newSpeed == null) {
            speed = null;
        }
        else {
            speed = BigInteger.valueOf(newSpeed.longValue());
        }
        return this;
    }
    
    public HostNicBuilder speed(BigInteger newSpeed) {
        speed = newSpeed;
        return this;
    }
    
    
    public HostNicBuilder statistics(List<Statistic> newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics);
            }
            else {
                statistics.addAll(newStatistics);
            }
        }
        return this;
    }
    
    public HostNicBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public HostNicBuilder statistics(StatisticBuilder... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            for (StatisticBuilder builder : newStatistics) {
                statistics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostNicBuilder status(NicStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public HostNicBuilder virtualFunctionsConfiguration(HostNicVirtualFunctionsConfiguration newVirtualFunctionsConfiguration) {
        virtualFunctionsConfiguration = newVirtualFunctionsConfiguration;
        return this;
    }
    
    public HostNicBuilder virtualFunctionsConfiguration(HostNicVirtualFunctionsConfigurationBuilder newVirtualFunctionsConfiguration) {
        if (newVirtualFunctionsConfiguration == null) {
            virtualFunctionsConfiguration = null;
        }
        else {
            virtualFunctionsConfiguration = newVirtualFunctionsConfiguration.build();
        }
        return this;
    }
    
    
    public HostNicBuilder vlan(Vlan newVlan) {
        vlan = newVlan;
        return this;
    }
    
    public HostNicBuilder vlan(VlanBuilder newVlan) {
        if (newVlan == null) {
            vlan = null;
        }
        else {
            vlan = newVlan.build();
        }
        return this;
    }
    
    
    public HostNic build() {
        HostNicContainer container = new HostNicContainer();
        container.adAggregatorId(adAggregatorId);
        container.baseInterface(baseInterface);
        container.bonding(bonding);
        container.bootProtocol(bootProtocol);
        container.bridged(bridged);
        container.checkConnectivity(checkConnectivity);
        container.comment(comment);
        container.customConfiguration(customConfiguration);
        container.description(description);
        container.host(host);
        container.href(href);
        container.id(id);
        container.ip(ip);
        container.ipv6(ipv6);
        container.ipv6BootProtocol(ipv6BootProtocol);
        container.mac(mac);
        container.mtu(mtu);
        container.name(name);
        container.network(network);
        container.networkLabels(networkLabels);
        container.overrideConfiguration(overrideConfiguration);
        container.physicalFunction(physicalFunction);
        container.properties(properties);
        container.qos(qos);
        container.speed(speed);
        container.statistics(statistics);
        container.status(status);
        container.virtualFunctionsConfiguration(virtualFunctionsConfiguration);
        container.vlan(vlan);
        return container;
    }
}
