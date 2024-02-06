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
import org.ovirt.engine.sdk4.internal.containers.NetworkContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.DnsResolverConfiguration;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkLabel;
import org.ovirt.engine.sdk4.types.NetworkStatus;
import org.ovirt.engine.sdk4.types.NetworkUsage;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProvider;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.Vlan;
import org.ovirt.engine.sdk4.types.VnicProfile;

public class NetworkBuilder {
    private Cluster cluster;
    private String comment;
    private DataCenter dataCenter;
    private String description;
    private Boolean display;
    private DnsResolverConfiguration dnsResolverConfiguration;
    private OpenStackNetworkProvider externalProvider;
    private Network externalProviderPhysicalNetwork;
    private String href;
    private String id;
    private Ip ip;
    private BigInteger mtu;
    private String name;
    private List<NetworkLabel> networkLabels;
    private List<Permission> permissions;
    private Boolean portIsolation;
    private Boolean profileRequired;
    private Qos qos;
    private Boolean required;
    private NetworkStatus status;
    private Boolean stp;
    private List<NetworkUsage> usages;
    private String vdsmName;
    private Vlan vlan;
    private List<VnicProfile> vnicProfiles;
    
    public NetworkBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public NetworkBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public NetworkBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public NetworkBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public NetworkBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public NetworkBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public NetworkBuilder display(boolean newDisplay) {
        display = Boolean.valueOf(newDisplay);
        return this;
    }
    
    public NetworkBuilder display(Boolean newDisplay) {
        display = newDisplay;
        return this;
    }
    
    
    public NetworkBuilder dnsResolverConfiguration(DnsResolverConfiguration newDnsResolverConfiguration) {
        dnsResolverConfiguration = newDnsResolverConfiguration;
        return this;
    }
    
    public NetworkBuilder dnsResolverConfiguration(DnsResolverConfigurationBuilder newDnsResolverConfiguration) {
        if (newDnsResolverConfiguration == null) {
            dnsResolverConfiguration = null;
        }
        else {
            dnsResolverConfiguration = newDnsResolverConfiguration.build();
        }
        return this;
    }
    
    
    public NetworkBuilder externalProvider(OpenStackNetworkProvider newExternalProvider) {
        externalProvider = newExternalProvider;
        return this;
    }
    
    public NetworkBuilder externalProvider(OpenStackNetworkProviderBuilder newExternalProvider) {
        if (newExternalProvider == null) {
            externalProvider = null;
        }
        else {
            externalProvider = newExternalProvider.build();
        }
        return this;
    }
    
    
    public NetworkBuilder externalProviderPhysicalNetwork(Network newExternalProviderPhysicalNetwork) {
        externalProviderPhysicalNetwork = newExternalProviderPhysicalNetwork;
        return this;
    }
    
    public NetworkBuilder externalProviderPhysicalNetwork(NetworkBuilder newExternalProviderPhysicalNetwork) {
        if (newExternalProviderPhysicalNetwork == null) {
            externalProviderPhysicalNetwork = null;
        }
        else {
            externalProviderPhysicalNetwork = newExternalProviderPhysicalNetwork.build();
        }
        return this;
    }
    
    
    public NetworkBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public NetworkBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public NetworkBuilder ip(Ip newIp) {
        ip = newIp;
        return this;
    }
    
    public NetworkBuilder ip(IpBuilder newIp) {
        if (newIp == null) {
            ip = null;
        }
        else {
            ip = newIp.build();
        }
        return this;
    }
    
    
    public NetworkBuilder mtu(int newMtu) {
        mtu = BigInteger.valueOf((long) newMtu);
        return this;
    }
    
    public NetworkBuilder mtu(Integer newMtu) {
        if (newMtu == null) {
            mtu = null;
        }
        else {
            mtu = BigInteger.valueOf(newMtu.longValue());
        }
        return this;
    }
    
    public NetworkBuilder mtu(long newMtu) {
        mtu = BigInteger.valueOf(newMtu);
        return this;
    }
    
    public NetworkBuilder mtu(Long newMtu) {
        if (newMtu == null) {
            mtu = null;
        }
        else {
            mtu = BigInteger.valueOf(newMtu.longValue());
        }
        return this;
    }
    
    public NetworkBuilder mtu(BigInteger newMtu) {
        mtu = newMtu;
        return this;
    }
    
    
    public NetworkBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public NetworkBuilder networkLabels(List<NetworkLabel> newNetworkLabels) {
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
    
    public NetworkBuilder networkLabels(NetworkLabel... newNetworkLabels) {
        if (newNetworkLabels != null) {
            if (networkLabels == null) {
                networkLabels = new ArrayList<>(newNetworkLabels.length);
            }
            Collections.addAll(networkLabels, newNetworkLabels);
        }
        return this;
    }
    
    public NetworkBuilder networkLabels(NetworkLabelBuilder... newNetworkLabels) {
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
    
    
    public NetworkBuilder permissions(List<Permission> newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions);
            }
            else {
                permissions.addAll(newPermissions);
            }
        }
        return this;
    }
    
    public NetworkBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public NetworkBuilder permissions(PermissionBuilder... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            for (PermissionBuilder builder : newPermissions) {
                permissions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NetworkBuilder portIsolation(boolean newPortIsolation) {
        portIsolation = Boolean.valueOf(newPortIsolation);
        return this;
    }
    
    public NetworkBuilder portIsolation(Boolean newPortIsolation) {
        portIsolation = newPortIsolation;
        return this;
    }
    
    
    public NetworkBuilder profileRequired(boolean newProfileRequired) {
        profileRequired = Boolean.valueOf(newProfileRequired);
        return this;
    }
    
    public NetworkBuilder profileRequired(Boolean newProfileRequired) {
        profileRequired = newProfileRequired;
        return this;
    }
    
    
    public NetworkBuilder qos(Qos newQos) {
        qos = newQos;
        return this;
    }
    
    public NetworkBuilder qos(QosBuilder newQos) {
        if (newQos == null) {
            qos = null;
        }
        else {
            qos = newQos.build();
        }
        return this;
    }
    
    
    public NetworkBuilder required(boolean newRequired) {
        required = Boolean.valueOf(newRequired);
        return this;
    }
    
    public NetworkBuilder required(Boolean newRequired) {
        required = newRequired;
        return this;
    }
    
    
    public NetworkBuilder status(NetworkStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public NetworkBuilder stp(boolean newStp) {
        stp = Boolean.valueOf(newStp);
        return this;
    }
    
    public NetworkBuilder stp(Boolean newStp) {
        stp = newStp;
        return this;
    }
    
    
    public NetworkBuilder usages(List<NetworkUsage> newUsages) {
        if (newUsages != null) {
            if (usages == null) {
                usages = new ArrayList<>(newUsages);
            }
            else {
                usages.addAll(newUsages);
            }
        }
        return this;
    }
    
    public NetworkBuilder usages(NetworkUsage... newUsages) {
        if (newUsages != null) {
            if (usages == null) {
                usages = new ArrayList<>(newUsages.length);
            }
            Collections.addAll(usages, newUsages);
        }
        return this;
    }
    
    
    public NetworkBuilder vdsmName(String newVdsmName) {
        vdsmName = newVdsmName;
        return this;
    }
    
    
    public NetworkBuilder vlan(Vlan newVlan) {
        vlan = newVlan;
        return this;
    }
    
    public NetworkBuilder vlan(VlanBuilder newVlan) {
        if (newVlan == null) {
            vlan = null;
        }
        else {
            vlan = newVlan.build();
        }
        return this;
    }
    
    
    public NetworkBuilder vnicProfiles(List<VnicProfile> newVnicProfiles) {
        if (newVnicProfiles != null) {
            if (vnicProfiles == null) {
                vnicProfiles = new ArrayList<>(newVnicProfiles);
            }
            else {
                vnicProfiles.addAll(newVnicProfiles);
            }
        }
        return this;
    }
    
    public NetworkBuilder vnicProfiles(VnicProfile... newVnicProfiles) {
        if (newVnicProfiles != null) {
            if (vnicProfiles == null) {
                vnicProfiles = new ArrayList<>(newVnicProfiles.length);
            }
            Collections.addAll(vnicProfiles, newVnicProfiles);
        }
        return this;
    }
    
    public NetworkBuilder vnicProfiles(VnicProfileBuilder... newVnicProfiles) {
        if (newVnicProfiles != null) {
            if (vnicProfiles == null) {
                vnicProfiles = new ArrayList<>(newVnicProfiles.length);
            }
            for (VnicProfileBuilder builder : newVnicProfiles) {
                vnicProfiles.add(builder.build());
            }
        }
        return this;
    }
    
    
    public Network build() {
        NetworkContainer container = new NetworkContainer();
        container.cluster(cluster);
        container.comment(comment);
        container.dataCenter(dataCenter);
        container.description(description);
        container.display(display);
        container.dnsResolverConfiguration(dnsResolverConfiguration);
        container.externalProvider(externalProvider);
        container.externalProviderPhysicalNetwork(externalProviderPhysicalNetwork);
        container.href(href);
        container.id(id);
        container.ip(ip);
        container.mtu(mtu);
        container.name(name);
        container.networkLabels(networkLabels);
        container.permissions(permissions);
        container.portIsolation(portIsolation);
        container.profileRequired(profileRequired);
        container.qos(qos);
        container.required(required);
        container.status(status);
        container.stp(stp);
        container.usages(usages);
        container.vdsmName(vdsmName);
        container.vlan(vlan);
        container.vnicProfiles(vnicProfiles);
        return container;
    }
}
