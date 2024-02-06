/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.PermitContainer;
import org.ovirt.engine.sdk4.types.Permit;
import org.ovirt.engine.sdk4.types.Role;

public class PermitBuilder {
    private Boolean administrative;
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private Role role;
    
    public PermitBuilder administrative(boolean newAdministrative) {
        administrative = Boolean.valueOf(newAdministrative);
        return this;
    }
    
    public PermitBuilder administrative(Boolean newAdministrative) {
        administrative = newAdministrative;
        return this;
    }
    
    
    public PermitBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public PermitBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public PermitBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public PermitBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public PermitBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public PermitBuilder role(Role newRole) {
        role = newRole;
        return this;
    }
    
    public PermitBuilder role(RoleBuilder newRole) {
        if (newRole == null) {
            role = null;
        }
        else {
            role = newRole.build();
        }
        return this;
    }
    
    
    public Permit build() {
        PermitContainer container = new PermitContainer();
        container.administrative(administrative);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.role(role);
        return container;
    }
}
