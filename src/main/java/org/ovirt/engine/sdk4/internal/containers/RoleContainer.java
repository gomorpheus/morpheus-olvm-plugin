/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.List;
import org.ovirt.engine.sdk4.types.Permit;
import org.ovirt.engine.sdk4.types.Role;
import org.ovirt.engine.sdk4.types.User;

public class RoleContainer extends IdentifiedContainer implements Role {
    private Boolean administrative;
    private Boolean mutable;
    private List<Permit> permits;
    private User user;
    
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
    
    public boolean mutable() {
        return mutable;
    }
    
    public void mutable(boolean newMutable) {
        mutable = Boolean.valueOf(newMutable);
    }
    
    public void mutable(Boolean newMutable) {
        mutable = newMutable;
    }
    
    public boolean mutablePresent() {
        return mutable != null;
    }
    
    public List<Permit> permits() {
        return makeUnmodifiableList(permits);
    }
    
    public void permits(List<Permit> newPermits) {
        permits = makeArrayList(newPermits);
    }
    
    public boolean permitsPresent() {
        return permits != null && !permits.isEmpty();
    }
    
    public User user() {
        return user;
    }
    
    public void user(User newUser) {
        user = newUser;
    }
    
    public boolean userPresent() {
        return user != null;
    }
    
}
