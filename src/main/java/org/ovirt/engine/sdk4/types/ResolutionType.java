/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ResolutionType {
    ADD("add"),
    COPY("copy"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ResolutionType.class);
    
    private String image;
    
    ResolutionType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ResolutionType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ResolutionType' enumerated type. " +
            "Valid values are 'add' and 'copy'.",
            exception
            );
            return null;
        }
    }
    
}

