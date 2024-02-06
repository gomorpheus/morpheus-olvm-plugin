/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Describes whether the vNIC is to be implemented as a pass-through device or a virtual one.
 */
public enum VnicPassThroughMode {
    /**
     * To be implemented as a virtual device.
     */
    DISABLED("disabled"),
    /**
     * To be implemented as a pass-through device.
     */
    ENABLED("enabled"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(VnicPassThroughMode.class);
    
    private String image;
    
    VnicPassThroughMode(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static VnicPassThroughMode fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'VnicPassThroughMode' enumerated type. " +
            "Valid values are 'disabled' and 'enabled'.",
            exception
            );
            return null;
        }
    }
    
}

