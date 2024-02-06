/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GlusterState {
    DOWN("down"),
    UNKNOWN("unknown"),
    UP("up"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(GlusterState.class);
    
    private String image;
    
    GlusterState(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static GlusterState fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'GlusterState' enumerated type. " +
            "Valid values are 'down', 'unknown' and 'up'.",
            exception
            );
            return null;
        }
    }
    
}

