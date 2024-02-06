/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.Group;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Role;
import org.ovirt.engine.sdk4.types.Tag;

public class GroupContainer extends IdentifiedContainer implements Group {
    private String domainEntryId;
    private String namespace;
    private Domain domain;
    private List<Permission> permissions;
    private List<Role> roles;
    private List<Tag> tags;
    
    public String domainEntryId() {
        return domainEntryId;
    }
    
    public void domainEntryId(String newDomainEntryId) {
        domainEntryId = newDomainEntryId;
    }
    
    public boolean domainEntryIdPresent() {
        return domainEntryId != null;
    }
    
    public String namespace() {
        return namespace;
    }
    
    public void namespace(String newNamespace) {
        namespace = newNamespace;
    }
    
    public boolean namespacePresent() {
        return namespace != null;
    }
    
    public Domain domain() {
        return domain;
    }
    
    public void domain(Domain newDomain) {
        domain = newDomain;
    }
    
    public boolean domainPresent() {
        return domain != null;
    }
    
    public List<Permission> permissions() {
        return makeUnmodifiableList(permissions);
    }
    
    public void permissions(List<Permission> newPermissions) {
        permissions = makeArrayList(newPermissions);
    }
    
    public boolean permissionsPresent() {
        return permissions != null && !permissions.isEmpty();
    }
    
    public List<Role> roles() {
        return makeUnmodifiableList(roles);
    }
    
    public void roles(List<Role> newRoles) {
        roles = makeArrayList(newRoles);
    }
    
    public boolean rolesPresent() {
        return roles != null && !roles.isEmpty();
    }
    
    public List<Tag> tags() {
        return makeUnmodifiableList(tags);
    }
    
    public void tags(List<Tag> newTags) {
        tags = makeArrayList(newTags);
    }
    
    public boolean tagsPresent() {
        return tags != null && !tags.isEmpty();
    }
    
}
