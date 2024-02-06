/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holds the types of all internal policy unit types.
 */
public enum PolicyUnitType {
    FILTER("filter"),
    LOAD_BALANCING("load_balancing"),
    WEIGHT("weight"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(PolicyUnitType.class);
    
    private String image;
    
    PolicyUnitType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static PolicyUnitType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'PolicyUnitType' enumerated type. " +
            "Valid values are 'filter', 'load_balancing' and 'weight'.",
            exception
            );
            return null;
        }
    }
    
}

