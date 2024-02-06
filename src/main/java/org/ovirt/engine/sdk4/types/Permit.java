/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Type represents a permit.
 */
public interface Permit extends Identified {
    boolean administrative();
    
    boolean administrativePresent();
    
    Role role();
    
    boolean rolePresent();
    
}
