/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum NetworkStatus {
    NON_OPERATIONAL("non_operational"),
    OPERATIONAL("operational"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(NetworkStatus.class);
    
    private String image;
    
    NetworkStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static NetworkStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'NetworkStatus' enumerated type. " +
            "Valid values are 'non_operational' and 'operational'.",
            exception
            );
            return null;
        }
    }
    
}

