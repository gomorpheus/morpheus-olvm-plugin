/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Describes the parameters for the virtual machine import operation from an external system.
 */
public interface ExternalVmImport {
    String name();
    
    boolean namePresent();
    
    String password();
    
    boolean passwordPresent();
    
    ExternalVmProviderType provider();
    
    boolean providerPresent();
    
    boolean sparse();
    
    boolean sparsePresent();
    
    String url();
    
    boolean urlPresent();
    
    String username();
    
    boolean usernamePresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    CpuProfile cpuProfile();
    
    boolean cpuProfilePresent();
    
    File driversIso();
    
    boolean driversIsoPresent();
    
    Host host();
    
    boolean hostPresent();
    
    Quota quota();
    
    boolean quotaPresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
