/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * This type represents a directory service domain.
 */
public interface Domain extends Identified {
    User user();
    
    boolean userPresent();
    
    List<Group> groups();
    
    boolean groupsPresent();
    
    List<User> users();
    
    boolean usersPresent();
    
}
