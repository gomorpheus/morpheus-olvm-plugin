/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum VmAffinity {
    MIGRATABLE("migratable"),
    PINNED("pinned"),
    USER_MIGRATABLE("user_migratable"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(VmAffinity.class);
    
    private String image;
    
    VmAffinity(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static VmAffinity fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'VmAffinity' enumerated type. " +
            "Valid values are 'migratable', 'pinned' and 'user_migratable'.",
            exception
            );
            return null;
        }
    }
    
}

