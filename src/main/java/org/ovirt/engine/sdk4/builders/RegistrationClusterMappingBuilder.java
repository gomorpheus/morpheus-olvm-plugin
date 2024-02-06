/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.RegistrationClusterMappingContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.RegistrationClusterMapping;

public class RegistrationClusterMappingBuilder {
    private Cluster from;
    private Cluster to;
    
    public RegistrationClusterMappingBuilder from(Cluster newFrom) {
        from = newFrom;
        return this;
    }
    
    public RegistrationClusterMappingBuilder from(ClusterBuilder newFrom) {
        if (newFrom == null) {
            from = null;
        }
        else {
            from = newFrom.build();
        }
        return this;
    }
    
    
    public RegistrationClusterMappingBuilder to(Cluster newTo) {
        to = newTo;
        return this;
    }
    
    public RegistrationClusterMappingBuilder to(ClusterBuilder newTo) {
        if (newTo == null) {
            to = null;
        }
        else {
            to = newTo.build();
        }
        return this;
    }
    
    
    public RegistrationClusterMapping build() {
        RegistrationClusterMappingContainer container = new RegistrationClusterMappingContainer();
        container.from(from);
        container.to(to);
        return container;
    }
}
