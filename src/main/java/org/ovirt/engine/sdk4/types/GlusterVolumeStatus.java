/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GlusterVolumeStatus {
    /**
     * Volume needs to be started, for clients to be able to mount and use it.
     */
    DOWN("down"),
    /**
     * When the status cannot be determined due to host being non-responsive.
     */
    UNKNOWN("unknown"),
    /**
     * Volume is started, and can be mounted and used by clients.
     */
    UP("up"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(GlusterVolumeStatus.class);
    
    private String image;
    
    GlusterVolumeStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static GlusterVolumeStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'GlusterVolumeStatus' enumerated type. " +
            "Valid values are 'down', 'unknown' and 'up'.",
            exception
            );
            return null;
        }
    }
    
}

