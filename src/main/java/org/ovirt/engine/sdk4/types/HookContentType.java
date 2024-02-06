/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents content type of hook script.
 */
public enum HookContentType {
    /**
     * Binary content type of the hook.
     */
    BINARY("binary"),
    /**
     * Text content type of the hook.
     */
    TEXT("text"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(HookContentType.class);
    
    private String image;
    
    HookContentType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static HookContentType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'HookContentType' enumerated type. " +
            "Valid values are 'binary' and 'text'.",
            exception
            );
            return null;
        }
    }
    
}

