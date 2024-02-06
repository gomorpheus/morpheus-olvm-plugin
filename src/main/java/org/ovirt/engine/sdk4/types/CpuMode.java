/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CpuMode {
    CUSTOM("custom"),
    HOST_MODEL("host_model"),
    HOST_PASSTHROUGH("host_passthrough"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(CpuMode.class);
    
    private String image;
    
    CpuMode(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static CpuMode fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'CpuMode' enumerated type. " +
            "Valid values are 'custom', 'host_model' and 'host_passthrough'.",
            exception
            );
            return null;
        }
    }
    
}

