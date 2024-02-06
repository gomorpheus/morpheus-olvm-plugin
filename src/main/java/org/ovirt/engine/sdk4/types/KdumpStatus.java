/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum KdumpStatus {
    DISABLED("disabled"),
    ENABLED("enabled"),
    UNKNOWN("unknown"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(KdumpStatus.class);
    
    private String image;
    
    KdumpStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static KdumpStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'KdumpStatus' enumerated type. " +
            "Valid values are 'disabled', 'enabled' and 'unknown'.",
            exception
            );
            return null;
        }
    }
    
}

