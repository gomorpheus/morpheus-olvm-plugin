/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Enum representing the boolean value that can be either set, or inherited from a higher level.
 * The inheritance order is virtual machine -> cluster -> engine-config.
 */
public enum InheritableBoolean {
    /**
     * Set the value to false on this level.
     */
    FALSE("false"),
    /**
     * Inherit the value from higher level.
     */
    INHERIT("inherit"),
    /**
     * Set the value to true on this level.
     */
    TRUE("true"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(InheritableBoolean.class);
    
    private String image;
    
    InheritableBoolean(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static InheritableBoolean fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'InheritableBoolean' enumerated type. " +
            "Valid values are 'false', 'inherit' and 'true'.",
            exception
            );
            return null;
        }
    }
    
}

