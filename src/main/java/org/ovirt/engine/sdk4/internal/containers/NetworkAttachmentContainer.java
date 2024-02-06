/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.List;
import org.ovirt.engine.sdk4.types.DnsResolverConfiguration;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.IpAddressAssignment;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkAttachment;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.ReportedConfiguration;

public class NetworkAttachmentContainer extends IdentifiedContainer implements NetworkAttachment {
    private DnsResolverConfiguration dnsResolverConfiguration;
    private Boolean inSync;
    private List<IpAddressAssignment> ipAddressAssignments;
    private List<Property> properties;
    private List<ReportedConfiguration> reportedConfigurations;
    private Host host;
    private HostNic hostNic;
    private Network network;
    private Qos qos;
    
    public DnsResolverConfiguration dnsResolverConfiguration() {
        return dnsResolverConfiguration;
    }
    
    public void dnsResolverConfiguration(DnsResolverConfiguration newDnsResolverConfiguration) {
        dnsResolverConfiguration = newDnsResolverConfiguration;
    }
    
    public boolean dnsResolverConfigurationPresent() {
        return dnsResolverConfiguration != null;
    }
    
    public boolean inSync() {
        return inSync;
    }
    
    public void inSync(boolean newInSync) {
        inSync = Boolean.valueOf(newInSync);
    }
    
    public void inSync(Boolean newInSync) {
        inSync = newInSync;
    }
    
    public boolean inSyncPresent() {
        return inSync != null;
    }
    
    public List<IpAddressAssignment> ipAddressAssignments() {
        return makeUnmodifiableList(ipAddressAssignments);
    }
    
    public void ipAddressAssignments(List<IpAddressAssignment> newIpAddressAssignments) {
        ipAddressAssignments = makeArrayList(newIpAddressAssignments);
    }
    
    public boolean ipAddressAssignmentsPresent() {
        return ipAddressAssignments != null && !ipAddressAssignments.isEmpty();
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
    
    public List<ReportedConfiguration> reportedConfigurations() {
        return makeUnmodifiableList(reportedConfigurations);
    }
    
    public void reportedConfigurations(List<ReportedConfiguration> newReportedConfigurations) {
        reportedConfigurations = makeArrayList(newReportedConfigurations);
    }
    
    public boolean reportedConfigurationsPresent() {
        return reportedConfigurations != null && !reportedConfigurations.isEmpty();
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
    
    public HostNic hostNic() {
        return hostNic;
    }
    
    public void hostNic(HostNic newHostNic) {
        hostNic = newHostNic;
    }
    
    public boolean hostNicPresent() {
        return hostNic != null;
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
    
    public Qos qos() {
        return qos;
    }
    
    public void qos(Qos newQos) {
        qos = newQos;
    }
    
    public boolean qosPresent() {
        return qos != null;
    }
    
}
