/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GlusterBrickStatus {
    /**
     * Brick is in `down` state, the data cannot be stored or retrieved from it.
     */
    DOWN("down"),
    /**
     * When the status cannot be determined due to host being non-responsive.
     */
    UNKNOWN("unknown"),
    /**
     * Brick is in `up` state, the data can be stored or retrieved from it.
     */
    UP("up"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(GlusterBrickStatus.class);
    
    private String image;
    
    GlusterBrickStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static GlusterBrickStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'GlusterBrickStatus' enumerated type. " +
            "Valid values are 'down', 'unknown' and 'up'.",
            exception
            );
            return null;
        }
    }
    
}

