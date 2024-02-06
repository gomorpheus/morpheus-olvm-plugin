/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.RegistrationVnicProfileMappingContainer;
import org.ovirt.engine.sdk4.types.RegistrationVnicProfileMapping;
import org.ovirt.engine.sdk4.types.VnicProfile;

public class RegistrationVnicProfileMappingBuilder {
    private VnicProfile from;
    private VnicProfile to;
    
    public RegistrationVnicProfileMappingBuilder from(VnicProfile newFrom) {
        from = newFrom;
        return this;
    }
    
    public RegistrationVnicProfileMappingBuilder from(VnicProfileBuilder newFrom) {
        if (newFrom == null) {
            from = null;
        }
        else {
            from = newFrom.build();
        }
        return this;
    }
    
    
    public RegistrationVnicProfileMappingBuilder to(VnicProfile newTo) {
        to = newTo;
        return this;
    }
    
    public RegistrationVnicProfileMappingBuilder to(VnicProfileBuilder newTo) {
        if (newTo == null) {
            to = null;
        }
        else {
            to = newTo.build();
        }
        return this;
    }
    
    
    public RegistrationVnicProfileMapping build() {
        RegistrationVnicProfileMappingContainer container = new RegistrationVnicProfileMappingContainer();
        container.from(from);
        container.to(to);
        return container;
    }
}
