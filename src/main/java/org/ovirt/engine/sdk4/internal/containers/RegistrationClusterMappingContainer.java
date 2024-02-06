/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.RegistrationClusterMapping;

public class RegistrationClusterMappingContainer extends Container implements RegistrationClusterMapping {
    private Cluster from;
    private Cluster to;
    
    public Cluster from() {
        return from;
    }
    
    public void from(Cluster newFrom) {
        from = newFrom;
    }
    
    public boolean fromPresent() {
        return from != null;
    }
    
    public Cluster to() {
        return to;
    }
    
    public void to(Cluster newTo) {
        to = newTo;
    }
    
    public boolean toPresent() {
        return to != null;
    }
    
}
