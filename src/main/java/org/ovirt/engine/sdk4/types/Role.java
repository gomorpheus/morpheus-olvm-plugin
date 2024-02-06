/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Represents a system role.
 */
public interface Role extends Identified {
    boolean administrative();
    
    boolean administrativePresent();
    
    boolean mutable();
    
    boolean mutablePresent();
    
    List<Permit> permits();
    
    boolean permitsPresent();
    
    User user();
    
    boolean userPresent();
    
}
