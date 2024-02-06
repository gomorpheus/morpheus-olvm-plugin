/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the current status of the snapshot.
 */
public enum SnapshotStatus {
    /**
     * The snapshot is being previewed.
     */
    IN_PREVIEW("in_preview"),
    /**
     * The snapshot is locked.
     * 
     * The snapshot is locked when it is in process of being created, deleted, restored or previewed.
     */
    LOCKED("locked"),
    /**
     * The snapshot is OK.
     */
    OK("ok"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(SnapshotStatus.class);
    
    private String image;
    
    SnapshotStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static SnapshotStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'SnapshotStatus' enumerated type. " +
            "Valid values are 'in_preview', 'locked' and 'ok'.",
            exception
            );
            return null;
        }
    }
    
}

