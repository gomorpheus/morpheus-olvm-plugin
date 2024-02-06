/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PayloadEncoding {
    BASE64("base64"),
    PLAINTEXT("plaintext"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(PayloadEncoding.class);
    
    private String image;
    
    PayloadEncoding(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static PayloadEncoding fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'PayloadEncoding' enumerated type. " +
            "Valid values are 'base64' and 'plaintext'.",
            exception
            );
            return null;
        }
    }
    
}

