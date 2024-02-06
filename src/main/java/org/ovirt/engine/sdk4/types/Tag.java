/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Represents a tag in the system.
 */
public interface Tag extends Identified {
    Group group();
    
    boolean groupPresent();
    
    Host host();
    
    boolean hostPresent();
    
    Tag parent();
    
    boolean parentPresent();
    
    Template template();
    
    boolean templatePresent();
    
    User user();
    
    boolean userPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
