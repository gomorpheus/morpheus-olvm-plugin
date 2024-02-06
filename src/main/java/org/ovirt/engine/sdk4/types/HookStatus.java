/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type represents the status of a hook.
 */
public enum HookStatus {
    /**
     * Hook is disabled.
     */
    DISABLED("disabled"),
    /**
     * Hook is enabled.
     */
    ENABLED("enabled"),
    /**
     * Hook is missing.
     */
    MISSING("missing"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(HookStatus.class);
    
    private String image;
    
    HookStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static HookStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'HookStatus' enumerated type. " +
            "Valid values are 'disabled', 'enabled' and 'missing'.",
            exception
            );
            return null;
        }
    }
    
}

