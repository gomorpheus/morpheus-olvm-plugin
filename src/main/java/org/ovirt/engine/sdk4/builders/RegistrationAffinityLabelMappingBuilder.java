/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.RegistrationAffinityLabelMappingContainer;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.RegistrationAffinityLabelMapping;

public class RegistrationAffinityLabelMappingBuilder {
    private AffinityLabel from;
    private AffinityLabel to;
    
    public RegistrationAffinityLabelMappingBuilder from(AffinityLabel newFrom) {
        from = newFrom;
        return this;
    }
    
    public RegistrationAffinityLabelMappingBuilder from(AffinityLabelBuilder newFrom) {
        if (newFrom == null) {
            from = null;
        }
        else {
            from = newFrom.build();
        }
        return this;
    }
    
    
    public RegistrationAffinityLabelMappingBuilder to(AffinityLabel newTo) {
        to = newTo;
        return this;
    }
    
    public RegistrationAffinityLabelMappingBuilder to(AffinityLabelBuilder newTo) {
        if (newTo == null) {
            to = null;
        }
        else {
            to = newTo.build();
        }
        return this;
    }
    
    
    public RegistrationAffinityLabelMapping build() {
        RegistrationAffinityLabelMappingContainer container = new RegistrationAffinityLabelMappingContainer();
        container.from(from);
        container.to(to);
        return container;
    }
}
