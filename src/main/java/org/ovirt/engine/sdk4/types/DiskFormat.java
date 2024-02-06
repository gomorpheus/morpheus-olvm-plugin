/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The underlying storage format of disks.
 */
public enum DiskFormat {
    /**
     * The _Copy On Write_ format allows snapshots, with a small performance overhead.
     */
    COW("cow"),
    /**
     * The raw format does not allow snapshots, but offers improved performance.
     */
    RAW("raw"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DiskFormat.class);
    
    private String image;
    
    DiskFormat(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DiskFormat fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DiskFormat' enumerated type. " +
            "Valid values are 'cow' and 'raw'.",
            exception
            );
            return null;
        }
    }
    
}

