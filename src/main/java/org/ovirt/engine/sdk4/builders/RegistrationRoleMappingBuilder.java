/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.RegistrationRoleMappingContainer;
import org.ovirt.engine.sdk4.types.RegistrationRoleMapping;
import org.ovirt.engine.sdk4.types.Role;

public class RegistrationRoleMappingBuilder {
    private Role from;
    private Role to;
    
    public RegistrationRoleMappingBuilder from(Role newFrom) {
        from = newFrom;
        return this;
    }
    
    public RegistrationRoleMappingBuilder from(RoleBuilder newFrom) {
        if (newFrom == null) {
            from = null;
        }
        else {
            from = newFrom.build();
        }
        return this;
    }
    
    
    public RegistrationRoleMappingBuilder to(Role newTo) {
        to = newTo;
        return this;
    }
    
    public RegistrationRoleMappingBuilder to(RoleBuilder newTo) {
        if (newTo == null) {
            to = null;
        }
        else {
            to = newTo.build();
        }
        return this;
    }
    
    
    public RegistrationRoleMapping build() {
        RegistrationRoleMappingContainer container = new RegistrationRoleMappingContainer();
        container.from(from);
        container.to(to);
        return container;
    }
}
