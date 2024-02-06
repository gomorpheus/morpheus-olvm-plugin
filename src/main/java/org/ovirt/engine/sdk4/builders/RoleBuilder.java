/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.RoleContainer;
import org.ovirt.engine.sdk4.types.Permit;
import org.ovirt.engine.sdk4.types.Role;
import org.ovirt.engine.sdk4.types.User;

public class RoleBuilder {
    private Boolean administrative;
    private String comment;
    private String description;
    private String href;
    private String id;
    private Boolean mutable;
    private String name;
    private List<Permit> permits;
    private User user;
    
    public RoleBuilder administrative(boolean newAdministrative) {
        administrative = Boolean.valueOf(newAdministrative);
        return this;
    }
    
    public RoleBuilder administrative(Boolean newAdministrative) {
        administrative = newAdministrative;
        return this;
    }
    
    
    public RoleBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public RoleBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public RoleBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public RoleBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public RoleBuilder mutable(boolean newMutable) {
        mutable = Boolean.valueOf(newMutable);
        return this;
    }
    
    public RoleBuilder mutable(Boolean newMutable) {
        mutable = newMutable;
        return this;
    }
    
    
    public RoleBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public RoleBuilder permits(List<Permit> newPermits) {
        if (newPermits != null) {
            if (permits == null) {
                permits = new ArrayList<>(newPermits);
            }
            else {
                permits.addAll(newPermits);
            }
        }
        return this;
    }
    
    public RoleBuilder permits(Permit... newPermits) {
        if (newPermits != null) {
            if (permits == null) {
                permits = new ArrayList<>(newPermits.length);
            }
            Collections.addAll(permits, newPermits);
        }
        return this;
    }
    
    public RoleBuilder permits(PermitBuilder... newPermits) {
        if (newPermits != null) {
            if (permits == null) {
                permits = new ArrayList<>(newPermits.length);
            }
            for (PermitBuilder builder : newPermits) {
                permits.add(builder.build());
            }
        }
        return this;
    }
    
    
    public RoleBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public RoleBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public Role build() {
        RoleContainer container = new RoleContainer();
        container.administrative(administrative);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.mutable(mutable);
        container.name(name);
        container.permits(permits);
        container.user(user);
        return container;
    }
}
