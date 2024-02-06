/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.Group;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.Role;
import org.ovirt.engine.sdk4.types.SshPublicKey;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.UserOption;

public class UserContainer extends IdentifiedContainer implements User {
    private String department;
    private String domainEntryId;
    private String email;
    private String lastName;
    private Boolean loggedIn;
    private String namespace;
    private String password;
    private String principal;
    private String userName;
    private List<Property> userOptions;
    private Domain domain;
    private List<Group> groups;
    private List<UserOption> options;
    private List<Permission> permissions;
    private List<Role> roles;
    private List<SshPublicKey> sshPublicKeys;
    private List<Tag> tags;
    
    public String department() {
        return department;
    }
    
    public void department(String newDepartment) {
        department = newDepartment;
    }
    
    public boolean departmentPresent() {
        return department != null;
    }
    
    public String domainEntryId() {
        return domainEntryId;
    }
    
    public void domainEntryId(String newDomainEntryId) {
        domainEntryId = newDomainEntryId;
    }
    
    public boolean domainEntryIdPresent() {
        return domainEntryId != null;
    }
    
    public String email() {
        return email;
    }
    
    public void email(String newEmail) {
        email = newEmail;
    }
    
    public boolean emailPresent() {
        return email != null;
    }
    
    public String lastName() {
        return lastName;
    }
    
    public void lastName(String newLastName) {
        lastName = newLastName;
    }
    
    public boolean lastNamePresent() {
        return lastName != null;
    }
    
    public boolean loggedIn() {
        return loggedIn;
    }
    
    public void loggedIn(boolean newLoggedIn) {
        loggedIn = Boolean.valueOf(newLoggedIn);
    }
    
    public void loggedIn(Boolean newLoggedIn) {
        loggedIn = newLoggedIn;
    }
    
    public boolean loggedInPresent() {
        return loggedIn != null;
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
    
    public String password() {
        return password;
    }
    
    public void password(String newPassword) {
        password = newPassword;
    }
    
    public boolean passwordPresent() {
        return password != null;
    }
    
    public String principal() {
        return principal;
    }
    
    public void principal(String newPrincipal) {
        principal = newPrincipal;
    }
    
    public boolean principalPresent() {
        return principal != null;
    }
    
    public String userName() {
        return userName;
    }
    
    public void userName(String newUserName) {
        userName = newUserName;
    }
    
    public boolean userNamePresent() {
        return userName != null;
    }
    
    public List<Property> userOptions() {
        return makeUnmodifiableList(userOptions);
    }
    
    public void userOptions(List<Property> newUserOptions) {
        userOptions = makeArrayList(newUserOptions);
    }
    
    public boolean userOptionsPresent() {
        return userOptions != null && !userOptions.isEmpty();
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
    
    public List<Group> groups() {
        return makeUnmodifiableList(groups);
    }
    
    public void groups(List<Group> newGroups) {
        groups = makeArrayList(newGroups);
    }
    
    public boolean groupsPresent() {
        return groups != null && !groups.isEmpty();
    }
    
    public List<UserOption> options() {
        return makeUnmodifiableList(options);
    }
    
    public void options(List<UserOption> newOptions) {
        options = makeArrayList(newOptions);
    }
    
    public boolean optionsPresent() {
        return options != null && !options.isEmpty();
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
    
    public List<SshPublicKey> sshPublicKeys() {
        return makeUnmodifiableList(sshPublicKeys);
    }
    
    public void sshPublicKeys(List<SshPublicKey> newSshPublicKeys) {
        sshPublicKeys = makeArrayList(newSshPublicKeys);
    }
    
    public boolean sshPublicKeysPresent() {
        return sshPublicKeys != null && !sshPublicKeys.isEmpty();
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
