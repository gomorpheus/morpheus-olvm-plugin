/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Represents an external host provider,
 * such as Foreman or Satellite.
 * 
 * See https://www.theforeman.org/ for more details on Foreman.
 * See https://access.redhat.com/products/red-hat-satellite
 * for more details on Red Hat Satellite.
 */
public interface ExternalHostProvider extends ExternalProvider {
    List<Certificate> certificates();
    
    boolean certificatesPresent();
    
    List<ExternalComputeResource> computeResources();
    
    boolean computeResourcesPresent();
    
    List<ExternalDiscoveredHost> discoveredHosts();
    
    boolean discoveredHostsPresent();
    
    List<ExternalHostGroup> hostGroups();
    
    boolean hostGroupsPresent();
    
    List<Host> hosts();
    
    boolean hostsPresent();
    
}
