/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.RegistrationLunMappingContainer;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.RegistrationLunMapping;

public class RegistrationLunMappingBuilder {
    private Disk from;
    private Disk to;
    
    public RegistrationLunMappingBuilder from(Disk newFrom) {
        from = newFrom;
        return this;
    }
    
    public RegistrationLunMappingBuilder from(DiskBuilder newFrom) {
        if (newFrom == null) {
            from = null;
        }
        else {
            from = newFrom.build();
        }
        return this;
    }
    
    
    public RegistrationLunMappingBuilder to(Disk newTo) {
        to = newTo;
        return this;
    }
    
    public RegistrationLunMappingBuilder to(DiskBuilder newTo) {
        if (newTo == null) {
            to = null;
        }
        else {
            to = newTo.build();
        }
        return this;
    }
    
    
    public RegistrationLunMapping build() {
        RegistrationLunMappingContainer container = new RegistrationLunMappingContainer();
        container.from(from);
        container.to(to);
        return container;
    }
}
