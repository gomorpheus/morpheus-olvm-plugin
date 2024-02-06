/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an enumeration of the backup mechanism
 * that is enabled on the disk.
 */
public enum DiskBackup {
    /**
     * Incremental backup support.
     */
    INCREMENTAL("incremental"),
    /**
     * No backup support.
     */
    NONE("none"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DiskBackup.class);
    
    private String image;
    
    DiskBackup(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DiskBackup fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DiskBackup' enumerated type. " +
            "Valid values are 'incremental' and 'none'.",
            exception
            );
            return null;
        }
    }
    
}

