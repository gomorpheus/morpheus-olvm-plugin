/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum NumaTuneMode {
    INTERLEAVE("interleave"),
    PREFERRED("preferred"),
    STRICT("strict"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(NumaTuneMode.class);
    
    private String image;
    
    NumaTuneMode(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static NumaTuneMode fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'NumaTuneMode' enumerated type. " +
            "Valid values are 'interleave', 'preferred' and 'strict'.",
            exception
            );
            return null;
        }
    }
    
}

