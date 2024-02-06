/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.RegistrationAffinityGroupMappingContainer;
import org.ovirt.engine.sdk4.types.AffinityGroup;
import org.ovirt.engine.sdk4.types.RegistrationAffinityGroupMapping;

public class RegistrationAffinityGroupMappingBuilder {
    private AffinityGroup from;
    private AffinityGroup to;
    
    public RegistrationAffinityGroupMappingBuilder from(AffinityGroup newFrom) {
        from = newFrom;
        return this;
    }
    
    public RegistrationAffinityGroupMappingBuilder from(AffinityGroupBuilder newFrom) {
        if (newFrom == null) {
            from = null;
        }
        else {
            from = newFrom.build();
        }
        return this;
    }
    
    
    public RegistrationAffinityGroupMappingBuilder to(AffinityGroup newTo) {
        to = newTo;
        return this;
    }
    
    public RegistrationAffinityGroupMappingBuilder to(AffinityGroupBuilder newTo) {
        if (newTo == null) {
            to = null;
        }
        else {
            to = newTo.build();
        }
        return this;
    }
    
    
    public RegistrationAffinityGroupMapping build() {
        RegistrationAffinityGroupMappingContainer container = new RegistrationAffinityGroupMappingContainer();
        container.from(from);
        container.to(to);
        return container;
    }
}
