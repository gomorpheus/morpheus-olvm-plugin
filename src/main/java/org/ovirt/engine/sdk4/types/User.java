/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

/**
 * Represents a user in the system.
 */
public interface User extends Identified {
    String department();
    
    boolean departmentPresent();
    
    String domainEntryId();
    
    boolean domainEntryIdPresent();
    
    String email();
    
    boolean emailPresent();
    
    String lastName();
    
    boolean lastNamePresent();
    
    boolean loggedIn();
    
    boolean loggedInPresent();
    
    String namespace();
    
    boolean namespacePresent();
    
    String password();
    
    boolean passwordPresent();
    
    String principal();
    
    boolean principalPresent();
    
    String userName();
    
    boolean userNamePresent();
    
    List<Property> userOptions();
    
    boolean userOptionsPresent();
    
    Domain domain();
    
    boolean domainPresent();
    
    List<Group> groups();
    
    boolean groupsPresent();
    
    List<UserOption> options();
    
    boolean optionsPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    List<Role> roles();
    
    boolean rolesPresent();
    
    List<SshPublicKey> sshPublicKeys();
    
    boolean sshPublicKeysPresent();
    
    List<Tag> tags();
    
    boolean tagsPresent();
    
}
