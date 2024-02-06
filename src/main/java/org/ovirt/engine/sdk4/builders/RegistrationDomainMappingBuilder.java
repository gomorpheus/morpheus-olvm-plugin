/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.RegistrationDomainMappingContainer;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.RegistrationDomainMapping;

public class RegistrationDomainMappingBuilder {
    private Domain from;
    private Domain to;
    
    public RegistrationDomainMappingBuilder from(Domain newFrom) {
        from = newFrom;
        return this;
    }
    
    public RegistrationDomainMappingBuilder from(DomainBuilder newFrom) {
        if (newFrom == null) {
            from = null;
        }
        else {
            from = newFrom.build();
        }
        return this;
    }
    
    
    public RegistrationDomainMappingBuilder to(Domain newTo) {
        to = newTo;
        return this;
    }
    
    public RegistrationDomainMappingBuilder to(DomainBuilder newTo) {
        if (newTo == null) {
            to = null;
        }
        else {
            to = newTo.build();
        }
        return this;
    }
    
    
    public RegistrationDomainMapping build() {
        RegistrationDomainMappingContainer container = new RegistrationDomainMappingContainer();
        container.from(from);
        container.to(to);
        return container;
    }
}
