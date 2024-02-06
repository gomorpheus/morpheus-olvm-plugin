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
import org.ovirt.engine.sdk4.internal.containers.UserContainer;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.Group;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.Role;
import org.ovirt.engine.sdk4.types.SshPublicKey;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.UserOption;

public class UserBuilder {
    private String comment;
    private String department;
    private String description;
    private Domain domain;
    private String domainEntryId;
    private String email;
    private List<Group> groups;
    private String href;
    private String id;
    private String lastName;
    private Boolean loggedIn;
    private String name;
    private String namespace;
    private List<UserOption> options;
    private String password;
    private List<Permission> permissions;
    private String principal;
    private List<Role> roles;
    private List<SshPublicKey> sshPublicKeys;
    private List<Tag> tags;
    private String userName;
    private List<Property> userOptions;
    
    public UserBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public UserBuilder department(String newDepartment) {
        department = newDepartment;
        return this;
    }
    
    
    public UserBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public UserBuilder domain(Domain newDomain) {
        domain = newDomain;
        return this;
    }
    
    public UserBuilder domain(DomainBuilder newDomain) {
        if (newDomain == null) {
            domain = null;
        }
        else {
            domain = newDomain.build();
        }
        return this;
    }
    
    
    public UserBuilder domainEntryId(String newDomainEntryId) {
        domainEntryId = newDomainEntryId;
        return this;
    }
    
    
    public UserBuilder email(String newEmail) {
        email = newEmail;
        return this;
    }
    
    
    public UserBuilder groups(List<Group> newGroups) {
        if (newGroups != null) {
            if (groups == null) {
                groups = new ArrayList<>(newGroups);
            }
            else {
                groups.addAll(newGroups);
            }
        }
        return this;
    }
    
    public UserBuilder groups(Group... newGroups) {
        if (newGroups != null) {
            if (groups == null) {
                groups = new ArrayList<>(newGroups.length);
            }
            Collections.addAll(groups, newGroups);
        }
        return this;
    }
    
    public UserBuilder groups(GroupBuilder... newGroups) {
        if (newGroups != null) {
            if (groups == null) {
                groups = new ArrayList<>(newGroups.length);
            }
            for (GroupBuilder builder : newGroups) {
                groups.add(builder.build());
            }
        }
        return this;
    }
    
    
    public UserBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public UserBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public UserBuilder lastName(String newLastName) {
        lastName = newLastName;
        return this;
    }
    
    
    public UserBuilder loggedIn(boolean newLoggedIn) {
        loggedIn = Boolean.valueOf(newLoggedIn);
        return this;
    }
    
    public UserBuilder loggedIn(Boolean newLoggedIn) {
        loggedIn = newLoggedIn;
        return this;
    }
    
    
    public UserBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public UserBuilder namespace(String newNamespace) {
        namespace = newNamespace;
        return this;
    }
    
    
    public UserBuilder options(List<UserOption> newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions);
            }
            else {
                options.addAll(newOptions);
            }
        }
        return this;
    }
    
    public UserBuilder options(UserOption... newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions.length);
            }
            Collections.addAll(options, newOptions);
        }
        return this;
    }
    
    public UserBuilder options(UserOptionBuilder... newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions.length);
            }
            for (UserOptionBuilder builder : newOptions) {
                options.add(builder.build());
            }
        }
        return this;
    }
    
    
    public UserBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public UserBuilder permissions(List<Permission> newPermissions) {
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
    
    public UserBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public UserBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public UserBuilder principal(String newPrincipal) {
        principal = newPrincipal;
        return this;
    }
    
    
    public UserBuilder roles(List<Role> newRoles) {
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
    
    public UserBuilder roles(Role... newRoles) {
        if (newRoles != null) {
            if (roles == null) {
                roles = new ArrayList<>(newRoles.length);
            }
            Collections.addAll(roles, newRoles);
        }
        return this;
    }
    
    public UserBuilder roles(RoleBuilder... newRoles) {
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
    
    
    public UserBuilder sshPublicKeys(List<SshPublicKey> newSshPublicKeys) {
        if (newSshPublicKeys != null) {
            if (sshPublicKeys == null) {
                sshPublicKeys = new ArrayList<>(newSshPublicKeys);
            }
            else {
                sshPublicKeys.addAll(newSshPublicKeys);
            }
        }
        return this;
    }
    
    public UserBuilder sshPublicKeys(SshPublicKey... newSshPublicKeys) {
        if (newSshPublicKeys != null) {
            if (sshPublicKeys == null) {
                sshPublicKeys = new ArrayList<>(newSshPublicKeys.length);
            }
            Collections.addAll(sshPublicKeys, newSshPublicKeys);
        }
        return this;
    }
    
    public UserBuilder sshPublicKeys(SshPublicKeyBuilder... newSshPublicKeys) {
        if (newSshPublicKeys != null) {
            if (sshPublicKeys == null) {
                sshPublicKeys = new ArrayList<>(newSshPublicKeys.length);
            }
            for (SshPublicKeyBuilder builder : newSshPublicKeys) {
                sshPublicKeys.add(builder.build());
            }
        }
        return this;
    }
    
    
    public UserBuilder tags(List<Tag> newTags) {
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
    
    public UserBuilder tags(Tag... newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags.length);
            }
            Collections.addAll(tags, newTags);
        }
        return this;
    }
    
    public UserBuilder tags(TagBuilder... newTags) {
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
    
    
    public UserBuilder userName(String newUserName) {
        userName = newUserName;
        return this;
    }
    
    
    public UserBuilder userOptions(List<Property> newUserOptions) {
        if (newUserOptions != null) {
            if (userOptions == null) {
                userOptions = new ArrayList<>(newUserOptions);
            }
            else {
                userOptions.addAll(newUserOptions);
            }
        }
        return this;
    }
    
    public UserBuilder userOptions(Property... newUserOptions) {
        if (newUserOptions != null) {
            if (userOptions == null) {
                userOptions = new ArrayList<>(newUserOptions.length);
            }
            Collections.addAll(userOptions, newUserOptions);
        }
        return this;
    }
    
    public UserBuilder userOptions(PropertyBuilder... newUserOptions) {
        if (newUserOptions != null) {
            if (userOptions == null) {
                userOptions = new ArrayList<>(newUserOptions.length);
            }
            for (PropertyBuilder builder : newUserOptions) {
                userOptions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public User build() {
        UserContainer container = new UserContainer();
        container.comment(comment);
        container.department(department);
        container.description(description);
        container.domain(domain);
        container.domainEntryId(domainEntryId);
        container.email(email);
        container.groups(groups);
        container.href(href);
        container.id(id);
        container.lastName(lastName);
        container.loggedIn(loggedIn);
        container.name(name);
        container.namespace(namespace);
        container.options(options);
        container.password(password);
        container.permissions(permissions);
        container.principal(principal);
        container.roles(roles);
        container.sshPublicKeys(sshPublicKeys);
        container.tags(tags);
        container.userName(userName);
        container.userOptions(userOptions);
        return container;
    }
}
