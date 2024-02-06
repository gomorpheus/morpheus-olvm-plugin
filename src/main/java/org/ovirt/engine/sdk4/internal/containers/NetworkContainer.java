/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
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

public class NetworkContainer extends IdentifiedContainer implements Network {
    private Boolean display;
    private DnsResolverConfiguration dnsResolverConfiguration;
    private Ip ip;
    private BigInteger mtu;
    private Boolean portIsolation;
    private Boolean profileRequired;
    private Boolean required;
    private NetworkStatus status;
    private Boolean stp;
    private List<NetworkUsage> usages;
    private String vdsmName;
    private Vlan vlan;
    private Cluster cluster;
    private DataCenter dataCenter;
    private OpenStackNetworkProvider externalProvider;
    private Network externalProviderPhysicalNetwork;
    private List<NetworkLabel> networkLabels;
    private List<Permission> permissions;
    private Qos qos;
    private List<VnicProfile> vnicProfiles;
    
    public boolean display() {
        return display;
    }
    
    public void display(boolean newDisplay) {
        display = Boolean.valueOf(newDisplay);
    }
    
    public void display(Boolean newDisplay) {
        display = newDisplay;
    }
    
    public boolean displayPresent() {
        return display != null;
    }
    
    public DnsResolverConfiguration dnsResolverConfiguration() {
        return dnsResolverConfiguration;
    }
    
    public void dnsResolverConfiguration(DnsResolverConfiguration newDnsResolverConfiguration) {
        dnsResolverConfiguration = newDnsResolverConfiguration;
    }
    
    public boolean dnsResolverConfigurationPresent() {
        return dnsResolverConfiguration != null;
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
    
    public BigInteger mtu() {
        return mtu;
    }
    
    public Byte mtuAsByte() {
        return asByte("Network", "mtu", mtu);
    }
    
    public Short mtuAsShort() {
        return asShort("Network", "mtu", mtu);
    }
    
    public Integer mtuAsInteger() {
        return asInteger("Network", "mtu", mtu);
    }
    
    public Long mtuAsLong() {
        return asLong("Network", "mtu", mtu);
    }
    
    public void mtu(BigInteger newMtu) {
        mtu = newMtu;
    }
    
    public boolean mtuPresent() {
        return mtu != null;
    }
    
    public boolean portIsolation() {
        return portIsolation;
    }
    
    public void portIsolation(boolean newPortIsolation) {
        portIsolation = Boolean.valueOf(newPortIsolation);
    }
    
    public void portIsolation(Boolean newPortIsolation) {
        portIsolation = newPortIsolation;
    }
    
    public boolean portIsolationPresent() {
        return portIsolation != null;
    }
    
    public boolean profileRequired() {
        return profileRequired;
    }
    
    public void profileRequired(boolean newProfileRequired) {
        profileRequired = Boolean.valueOf(newProfileRequired);
    }
    
    public void profileRequired(Boolean newProfileRequired) {
        profileRequired = newProfileRequired;
    }
    
    public boolean profileRequiredPresent() {
        return profileRequired != null;
    }
    
    public boolean required() {
        return required;
    }
    
    public void required(boolean newRequired) {
        required = Boolean.valueOf(newRequired);
    }
    
    public void required(Boolean newRequired) {
        required = newRequired;
    }
    
    public boolean requiredPresent() {
        return required != null;
    }
    
    public NetworkStatus status() {
        return status;
    }
    
    public void status(NetworkStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public boolean stp() {
        return stp;
    }
    
    public void stp(boolean newStp) {
        stp = Boolean.valueOf(newStp);
    }
    
    public void stp(Boolean newStp) {
        stp = newStp;
    }
    
    public boolean stpPresent() {
        return stp != null;
    }
    
    public List<NetworkUsage> usages() {
        return makeUnmodifiableList(usages);
    }
    
    public void usages(List<NetworkUsage> newUsages) {
        usages = makeArrayList(newUsages);
    }
    
    public boolean usagesPresent() {
        return usages != null && !usages.isEmpty();
    }
    
    public String vdsmName() {
        return vdsmName;
    }
    
    public void vdsmName(String newVdsmName) {
        vdsmName = newVdsmName;
    }
    
    public boolean vdsmNamePresent() {
        return vdsmName != null;
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
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
    }
    
    public DataCenter dataCenter() {
        return dataCenter;
    }
    
    public void dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
    }
    
    public boolean dataCenterPresent() {
        return dataCenter != null;
    }
    
    public OpenStackNetworkProvider externalProvider() {
        return externalProvider;
    }
    
    public void externalProvider(OpenStackNetworkProvider newExternalProvider) {
        externalProvider = newExternalProvider;
    }
    
    public boolean externalProviderPresent() {
        return externalProvider != null;
    }
    
    public Network externalProviderPhysicalNetwork() {
        return externalProviderPhysicalNetwork;
    }
    
    public void externalProviderPhysicalNetwork(Network newExternalProviderPhysicalNetwork) {
        externalProviderPhysicalNetwork = newExternalProviderPhysicalNetwork;
    }
    
    public boolean externalProviderPhysicalNetworkPresent() {
        return externalProviderPhysicalNetwork != null;
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
    
    public List<Permission> permissions() {
        return makeUnmodifiableList(permissions);
    }
    
    public void permissions(List<Permission> newPermissions) {
        permissions = makeArrayList(newPermissions);
    }
    
    public boolean permissionsPresent() {
        return permissions != null && !permissions.isEmpty();
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
    
    public List<VnicProfile> vnicProfiles() {
        return makeUnmodifiableList(vnicProfiles);
    }
    
    public void vnicProfiles(List<VnicProfile> newVnicProfiles) {
        vnicProfiles = makeArrayList(newVnicProfiles);
    }
    
    public boolean vnicProfilesPresent() {
        return vnicProfiles != null && !vnicProfiles.isEmpty();
    }
    
}
