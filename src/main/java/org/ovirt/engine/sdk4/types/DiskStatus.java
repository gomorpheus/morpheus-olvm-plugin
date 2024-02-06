/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Current status representation for disk.
 */
public enum DiskStatus {
    /**
     * Disk cannot be accessed by the virtual machine, and the user needs
     * to take action to resolve the issue.
     */
    ILLEGAL("illegal"),
    /**
     * The disk is being used by the system, therefore it cannot be accessed
     * by virtual machines at this point. This is usually a temporary status,
     * until the disk is freed.
     */
    LOCKED("locked"),
    /**
     * The disk status is normal and can be accessed by the virtual machine.
     */
    OK("ok"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DiskStatus.class);
    
    private String image;
    
    DiskStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DiskStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DiskStatus' enumerated type. " +
            "Valid values are 'illegal', 'locked' and 'ok'.",
            exception
            );
            return null;
        }
    }
    
}

