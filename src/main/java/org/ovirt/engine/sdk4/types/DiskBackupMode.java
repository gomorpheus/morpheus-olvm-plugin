/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an enumeration of backup modes
 */
public enum DiskBackupMode {
    /**
     * This disk supports full backup.
     * You can query zero extents and download all disk data.
     */
    FULL("full"),
    /**
     * This disk supports incremental backup.
     * You can query dirty extents and download changed blocks.
     */
    INCREMENTAL("incremental"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DiskBackupMode.class);
    
    private String image;
    
    DiskBackupMode(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DiskBackupMode fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DiskBackupMode' enumerated type. " +
            "Valid values are 'full' and 'incremental'.",
            exception
            );
            return null;
        }
    }
    
}

