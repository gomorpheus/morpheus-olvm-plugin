/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Describes all maximum memory threshold types supported by the system.
 */
public enum LogMaxMemoryUsedThresholdType {
    /**
     * Absolute value threshold type.
     * 
     * When an absolute value is specified, an audit log event is logged if the free memory in MB falls below the value
     * specified in `LogMaxMemoryUsedThreshold`.
     */
    ABSOLUTE_VALUE_IN_MB("absolute_value_in_mb"),
    /**
     * Percentage threshold type.
     * 
     * When a percentage is specified, an audit log event is logged if the memory used is above the value specified
     * in `LogMaxMemoryUsedThreshold`.
     */
    PERCENTAGE("percentage"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(LogMaxMemoryUsedThresholdType.class);
    
    private String image;
    
    LogMaxMemoryUsedThresholdType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static LogMaxMemoryUsedThresholdType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'LogMaxMemoryUsedThresholdType' enumerated type. " +
            "Valid values are 'absolute_value_in_mb' and 'percentage'.",
            exception
            );
            return null;
        }
    }
    
}

