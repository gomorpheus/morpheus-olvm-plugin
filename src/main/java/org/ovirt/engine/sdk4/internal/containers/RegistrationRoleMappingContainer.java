/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.RegistrationRoleMapping;
import org.ovirt.engine.sdk4.types.Role;

public class RegistrationRoleMappingContainer extends Container implements RegistrationRoleMapping {
    private Role from;
    private Role to;
    
    public Role from() {
        return from;
    }
    
    public void from(Role newFrom) {
        from = newFrom;
    }
    
    public boolean fromPresent() {
        return from != null;
    }
    
    public Role to() {
        return to;
    }
    
    public void to(Role newTo) {
        to = newTo;
    }
    
    public boolean toPresent() {
        return to != null;
    }
    
}
