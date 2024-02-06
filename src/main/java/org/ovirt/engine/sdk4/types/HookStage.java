/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type represents a stage of volume event at which hook executes.
 */
public enum HookStage {
    /**
     * Stage after start of volume.
     */
    POST("post"),
    /**
     * Stage before start of volume.
     */
    PRE("pre"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(HookStage.class);
    
    private String image;
    
    HookStage(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static HookStage fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'HookStage' enumerated type. " +
            "Valid values are 'post' and 'pre'.",
            exception
            );
            return null;
        }
    }
    
}

