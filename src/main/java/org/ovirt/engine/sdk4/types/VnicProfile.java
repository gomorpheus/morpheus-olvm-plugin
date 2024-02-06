/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * A vNIC profile is a collection of settings that can be applied to individual <<types/nic,NIC>>.
 */
public interface VnicProfile extends Identified {
    List<CustomProperty> customProperties();
    
    boolean customPropertiesPresent();
    
    boolean migratable();
    
    boolean migratablePresent();
    
    VnicPassThrough passThrough();
    
    boolean passThroughPresent();
    
    boolean portMirroring();
    
    boolean portMirroringPresent();
    
    VnicProfile failover();
    
    boolean failoverPresent();
    
    Network network();
    
    boolean networkPresent();
    
    NetworkFilter networkFilter();
    
    boolean networkFilterPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    Qos qos();
    
    boolean qosPresent();
    
}
