/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PowerManagementStatus {
    /**
     * Host is OFF.
     */
    OFF("off"),
    /**
     * Host is ON.
     */
    ON("on"),
    /**
     * Unknown status.
     */
    UNKNOWN("unknown"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(PowerManagementStatus.class);
    
    private String image;
    
    PowerManagementStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static PowerManagementStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'PowerManagementStatus' enumerated type. " +
            "Valid values are 'off', 'on' and 'unknown'.",
            exception
            );
            return null;
        }
    }
    
}

