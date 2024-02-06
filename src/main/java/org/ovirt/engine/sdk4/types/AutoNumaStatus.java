/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AutoNumaStatus {
    DISABLE("disable"),
    ENABLE("enable"),
    UNKNOWN("unknown"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(AutoNumaStatus.class);
    
    private String image;
    
    AutoNumaStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static AutoNumaStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'AutoNumaStatus' enumerated type. " +
            "Valid values are 'disable', 'enable' and 'unknown'.",
            exception
            );
            return null;
        }
    }
    
}

