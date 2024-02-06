/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Represents a guest operating system.
 */
public interface OperatingSystemInfo extends Identified {
    Architecture architecture();
    
    boolean architecturePresent();
    
    Icon largeIcon();
    
    boolean largeIconPresent();
    
    Icon smallIcon();
    
    boolean smallIconPresent();
    
}
