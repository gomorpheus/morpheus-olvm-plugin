/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum DiskType {
    DATA("data"),
    SYSTEM("system"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DiskType.class);
    
    private String image;
    
    DiskType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DiskType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DiskType' enumerated type. " +
            "Valid values are 'data' and 'system'.",
            exception
            );
            return null;
        }
    }
    
}

