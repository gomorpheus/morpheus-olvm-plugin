/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.types.Permit;
import org.ovirt.engine.sdk4.types.Role;

public class PermitContainer extends IdentifiedContainer implements Permit {
    private Boolean administrative;
    private Role role;
    
    public boolean administrative() {
        return administrative;
    }
    
    public void administrative(boolean newAdministrative) {
        administrative = Boolean.valueOf(newAdministrative);
    }
    
    public void administrative(Boolean newAdministrative) {
        administrative = newAdministrative;
    }
    
    public boolean administrativePresent() {
        return administrative != null;
    }
    
    public Role role() {
        return role;
    }
    
    public void role(Role newRole) {
        role = newRole;
    }
    
    public boolean rolePresent() {
        return role != null;
    }
    
}
