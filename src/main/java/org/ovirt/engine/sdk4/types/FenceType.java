/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing the type of the fence operation.
 */
public enum FenceType {
    /**
     * Manual host fencing via power management.
     */
    MANUAL("manual"),
    /**
     * Restart the host via power management.
     */
    RESTART("restart"),
    /**
     * Start the host via power management.
     */
    START("start"),
    /**
     * Check the host power status via power management.
     */
    STATUS("status"),
    /**
     * Stop the host via power management.
     */
    STOP("stop"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(FenceType.class);
    
    private String image;
    
    FenceType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static FenceType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'FenceType' enumerated type. " +
            "Valid values are 'manual', 'restart', 'start', 'status' and 'stop'.",
            exception
            );
            return null;
        }
    }
    
}

