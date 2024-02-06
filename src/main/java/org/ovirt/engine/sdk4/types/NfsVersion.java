/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum NfsVersion {
    AUTO("auto"),
    V3("v3"),
    V4("v4"),
    /**
     * NFS 4.0.
     */
    V4_0("v4_0"),
    V4_1("v4_1"),
    /**
     * NFS 4.2.
     */
    V4_2("v4_2"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(NfsVersion.class);
    
    private String image;
    
    NfsVersion(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static NfsVersion fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'NfsVersion' enumerated type. " +
            "Valid values are 'auto', 'v3', 'v4', 'v4_0', 'v4_1' and 'v4_2'.",
            exception
            );
            return null;
        }
    }
    
}

