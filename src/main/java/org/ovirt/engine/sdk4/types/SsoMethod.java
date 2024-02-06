/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SsoMethod {
    GUEST_AGENT("guest_agent"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(SsoMethod.class);
    
    private String image;
    
    SsoMethod(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static SsoMethod fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'SsoMethod' enumerated type. " +
            "Valid value is 'guest_agent'.",
            exception
            );
            return null;
        }
    }
    
}

