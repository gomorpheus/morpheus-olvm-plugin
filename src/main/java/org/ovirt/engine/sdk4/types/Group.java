/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

/**
 * This type represents all groups in the directory service.
 */
public interface Group extends Identified {
    String domainEntryId();
    
    boolean domainEntryIdPresent();
    
    String namespace();
    
    boolean namespacePresent();
    
    Domain domain();
    
    boolean domainPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    List<Role> roles();
    
    boolean rolesPresent();
    
    List<Tag> tags();
    
    boolean tagsPresent();
    
}
