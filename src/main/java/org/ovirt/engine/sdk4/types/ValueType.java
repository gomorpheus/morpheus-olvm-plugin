/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ValueType {
    DECIMAL("decimal"),
    INTEGER("integer"),
    STRING("string"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ValueType.class);
    
    private String image;
    
    ValueType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ValueType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ValueType' enumerated type. " +
            "Valid values are 'decimal', 'integer' and 'string'.",
            exception
            );
            return null;
        }
    }
    
}

