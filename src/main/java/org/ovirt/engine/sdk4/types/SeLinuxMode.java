/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an SELinux enforcement mode.
 */
public enum SeLinuxMode {
    /**
     * SELinux is disabled in the kernel.
     */
    DISABLED("disabled"),
    /**
     * SELinux is running and enforcing permissions.
     */
    ENFORCING("enforcing"),
    /**
     * SELinux is running and logging but not enforcing permissions.
     */
    PERMISSIVE("permissive"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(SeLinuxMode.class);
    
    private String image;
    
    SeLinuxMode(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static SeLinuxMode fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'SeLinuxMode' enumerated type. " +
            "Valid values are 'disabled', 'enforcing' and 'permissive'.",
            exception
            );
            return null;
        }
    }
    
}

