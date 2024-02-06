/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SshAuthenticationMethod {
    PASSWORD("password"),
    PUBLICKEY("publickey"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(SshAuthenticationMethod.class);
    
    private String image;
    
    SshAuthenticationMethod(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static SshAuthenticationMethod fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'SshAuthenticationMethod' enumerated type. " +
            "Valid values are 'password' and 'publickey'.",
            exception
            );
            return null;
        }
    }
    
}

