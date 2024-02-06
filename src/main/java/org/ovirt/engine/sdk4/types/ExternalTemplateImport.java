/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Describes the parameters for the template import operation from an external system.
 * Currently supports OVA only.
 */
public interface ExternalTemplateImport {
    boolean clone_();
    
    boolean clone_Present();
    
    String url();
    
    boolean urlPresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    CpuProfile cpuProfile();
    
    boolean cpuProfilePresent();
    
    Host host();
    
    boolean hostPresent();
    
    Quota quota();
    
    boolean quotaPresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
    Template template();
    
    boolean templatePresent();
    
}
