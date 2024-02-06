/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Enum representing a severity of an event.
 */
public enum LogSeverity {
    /**
     * Alert severity.
     * Used to specify a condition that requires
     * an immediate attention.
     */
    ALERT("alert"),
    /**
     * Error severity.
     * Used to specify that there is an error that needs
     * to be examined.
     */
    ERROR("error"),
    /**
     * Normal severity.
     * Used for information events.
     */
    NORMAL("normal"),
    /**
     * Warning severity.
     * Used to warn something might be wrong.
     */
    WARNING("warning"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(LogSeverity.class);
    
    private String image;
    
    LogSeverity(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static LogSeverity fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'LogSeverity' enumerated type. " +
            "Valid values are 'alert', 'error', 'normal' and 'warning'.",
            exception
            );
            return null;
        }
    }
    
}

