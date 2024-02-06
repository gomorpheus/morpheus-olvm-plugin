/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.ExternalComputeResource;
import org.ovirt.engine.sdk4.types.ExternalDiscoveredHost;
import org.ovirt.engine.sdk4.types.ExternalHostGroup;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;
import org.ovirt.engine.sdk4.types.Host;

public class ExternalHostProviderContainer extends ExternalProviderContainer implements ExternalHostProvider {
    private List<Certificate> certificates;
    private List<ExternalComputeResource> computeResources;
    private List<ExternalDiscoveredHost> discoveredHosts;
    private List<ExternalHostGroup> hostGroups;
    private List<Host> hosts;
    
    public List<Certificate> certificates() {
        return makeUnmodifiableList(certificates);
    }
    
    public void certificates(List<Certificate> newCertificates) {
        certificates = makeArrayList(newCertificates);
    }
    
    public boolean certificatesPresent() {
        return certificates != null && !certificates.isEmpty();
    }
    
    public List<ExternalComputeResource> computeResources() {
        return makeUnmodifiableList(computeResources);
    }
    
    public void computeResources(List<ExternalComputeResource> newComputeResources) {
        computeResources = makeArrayList(newComputeResources);
    }
    
    public boolean computeResourcesPresent() {
        return computeResources != null && !computeResources.isEmpty();
    }
    
    public List<ExternalDiscoveredHost> discoveredHosts() {
        return makeUnmodifiableList(discoveredHosts);
    }
    
    public void discoveredHosts(List<ExternalDiscoveredHost> newDiscoveredHosts) {
        discoveredHosts = makeArrayList(newDiscoveredHosts);
    }
    
    public boolean discoveredHostsPresent() {
        return discoveredHosts != null && !discoveredHosts.isEmpty();
    }
    
    public List<ExternalHostGroup> hostGroups() {
        return makeUnmodifiableList(hostGroups);
    }
    
    public void hostGroups(List<ExternalHostGroup> newHostGroups) {
        hostGroups = makeArrayList(newHostGroups);
    }
    
    public boolean hostGroupsPresent() {
        return hostGroups != null && !hostGroups.isEmpty();
    }
    
    public List<Host> hosts() {
        return makeUnmodifiableList(hosts);
    }
    
    public void hosts(List<Host> newHosts) {
        hosts = makeArrayList(newHosts);
    }
    
    public boolean hostsPresent() {
        return hosts != null && !hosts.isEmpty();
    }
    
}
