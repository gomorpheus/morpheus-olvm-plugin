/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.GroupContainer;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.Group;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Role;
import org.ovirt.engine.sdk4.types.Tag;

public class GroupBuilder {
    private String comment;
    private String description;
    private Domain domain;
    private String domainEntryId;
    private String href;
    private String id;
    private String name;
    private String namespace;
    private List<Permission> permissions;
    private List<Role> roles;
    private List<Tag> tags;
    
    public GroupBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public GroupBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public GroupBuilder domain(Domain newDomain) {
        domain = newDomain;
        return this;
    }
    
    public GroupBuilder domain(DomainBuilder newDomain) {
        if (newDomain == null) {
            domain = null;
        }
        else {
            domain = newDomain.build();
        }
        return this;
    }
    
    
    public GroupBuilder domainEntryId(String newDomainEntryId) {
        domainEntryId = newDomainEntryId;
        return this;
    }
    
    
    public GroupBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public GroupBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public GroupBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public GroupBuilder namespace(String newNamespace) {
        namespace = newNamespace;
        return this;
    }
    
    
    public GroupBuilder permissions(List<Permission> newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions);
            }
            else {
                permissions.addAll(newPermissions);
            }
        }
        return this;
    }
    
    public GroupBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public GroupBuilder permissions(PermissionBuilder... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            for (PermissionBuilder builder : newPermissions) {
                permissions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GroupBuilder roles(List<Role> newRoles) {
        if (newRoles != null) {
            if (roles == null) {
                roles = new ArrayList<>(newRoles);
            }
            else {
                roles.addAll(newRoles);
            }
        }
        return this;
    }
    
    public GroupBuilder roles(Role... newRoles) {
        if (newRoles != null) {
            if (roles == null) {
                roles = new ArrayList<>(newRoles.length);
            }
            Collections.addAll(roles, newRoles);
        }
        return this;
    }
    
    public GroupBuilder roles(RoleBuilder... newRoles) {
        if (newRoles != null) {
            if (roles == null) {
                roles = new ArrayList<>(newRoles.length);
            }
            for (RoleBuilder builder : newRoles) {
                roles.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GroupBuilder tags(List<Tag> newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags);
            }
            else {
                tags.addAll(newTags);
            }
        }
        return this;
    }
    
    public GroupBuilder tags(Tag... newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags.length);
            }
            Collections.addAll(tags, newTags);
        }
        return this;
    }
    
    public GroupBuilder tags(TagBuilder... newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags.length);
            }
            for (TagBuilder builder : newTags) {
                tags.add(builder.build());
            }
        }
        return this;
    }
    
    
    public Group build() {
        GroupContainer container = new GroupContainer();
        container.comment(comment);
        container.description(description);
        container.domain(domain);
        container.domainEntryId(domainEntryId);
        container.href(href);
        container.id(id);
        container.name(name);
        container.namespace(namespace);
        container.permissions(permissions);
        container.roles(roles);
        container.tags(tags);
        return container;
    }
}
