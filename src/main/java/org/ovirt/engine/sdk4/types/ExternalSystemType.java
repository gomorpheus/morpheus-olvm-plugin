/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the type of the external system that is associated with the `step`.
 */
public enum ExternalSystemType {
    /**
     * Represents `Gluster` as the external system which is associated with the `step`.
     */
    GLUSTER("gluster"),
    /**
     * Represents `VDSM` as the external system which is associated with the `step`.
     */
    VDSM("vdsm"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ExternalSystemType.class);
    
    private String image;
    
    ExternalSystemType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ExternalSystemType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ExternalSystemType' enumerated type. " +
            "Valid values are 'gluster' and 'vdsm'.",
            exception
            );
            return null;
        }
    }
    
}

