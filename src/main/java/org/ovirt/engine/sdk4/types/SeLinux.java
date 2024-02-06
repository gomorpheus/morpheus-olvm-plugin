/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Represents SELinux in the system.
 */
public interface SeLinux {
    SeLinuxMode mode();
    
    boolean modePresent();
    
}
