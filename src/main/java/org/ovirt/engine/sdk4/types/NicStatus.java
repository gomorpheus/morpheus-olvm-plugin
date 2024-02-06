/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Network interface card status.
 */
public enum NicStatus {
    /**
     * The NIC is down and cannot be accessed.
     */
    DOWN("down"),
    /**
     * The NIC is up and can be accessed.
     */
    UP("up"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(NicStatus.class);
    
    private String image;
    
    NicStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static NicStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'NicStatus' enumerated type. " +
            "Valid values are 'down' and 'up'.",
            exception
            );
            return null;
        }
    }
    
}

