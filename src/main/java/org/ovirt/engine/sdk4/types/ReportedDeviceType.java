/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ReportedDeviceType {
    NETWORK("network"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ReportedDeviceType.class);
    
    private String image;
    
    ReportedDeviceType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ReportedDeviceType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ReportedDeviceType' enumerated type. " +
            "Valid value is 'network'.",
            exception
            );
            return null;
        }
    }
    
}

