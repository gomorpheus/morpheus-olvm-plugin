/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the values for the IP protocol version.
 */
public enum IpVersion {
    /**
     * IPv4.
     */
    V4("v4"),
    /**
     * IPv6.
     */
    V6("v6"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(IpVersion.class);
    
    private String image;
    
    IpVersion(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static IpVersion fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'IpVersion' enumerated type. " +
            "Valid values are 'v4' and 'v6'.",
            exception
            );
            return null;
        }
    }
    
}

