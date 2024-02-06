/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SpmStatus {
    CONTENDING("contending"),
    NONE("none"),
    SPM("spm"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(SpmStatus.class);
    
    private String image;
    
    SpmStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static SpmStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'SpmStatus' enumerated type. " +
            "Valid values are 'contending', 'none' and 'spm'.",
            exception
            );
            return null;
        }
    }
    
}

