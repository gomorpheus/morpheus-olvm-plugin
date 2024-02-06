/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the type of the snapshot.
 */
public enum SnapshotType {
    /**
     * Reference to the current configuration of the virtual machines.
     */
    ACTIVE("active"),
    /**
     * The `active` snapshot will become `preview` if some snapshot is being previewed.
     * 
     * In other words, this is the `active` snapshot before preview.
     */
    PREVIEW("preview"),
    /**
     * Snapshot created by user.
     */
    REGULAR("regular"),
    /**
     * Snapshot created internally for stateless virtual machines.
     * 
     * This snapshot is created when the virtual machine is started and it is restored when the virtual machine is shut
     * down.
     */
    STATELESS("stateless"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(SnapshotType.class);
    
    private String image;
    
    SnapshotType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static SnapshotType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'SnapshotType' enumerated type. " +
            "Valid values are 'active', 'preview', 'regular' and 'stateless'.",
            exception
            );
            return null;
        }
    }
    
}

