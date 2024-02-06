/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum VmDeviceType {
    CDROM("cdrom"),
    FLOPPY("floppy"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(VmDeviceType.class);
    
    private String image;
    
    VmDeviceType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static VmDeviceType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'VmDeviceType' enumerated type. " +
            "Valid values are 'cdrom' and 'floppy'.",
            exception
            );
            return null;
        }
    }
    
}

