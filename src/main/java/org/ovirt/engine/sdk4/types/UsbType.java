/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type of USB device redirection.
 */
public enum UsbType {
    /**
     * Legacy USB redirection.
     * 
     * This USB type has been deprecated since version 3.6 of the engine, and has been completely removed in version
     * 4.1. It is preserved only to avoid syntax errors in existing scripts. If it is used it will be automatically
     * replaced by `native`.
     */
    LEGACY("legacy"),
    /**
     * Native USB redirection.
     * 
     * Native USB redirection allows KVM/SPICE USB redirection for Linux and Windows virtual machines. Virtual (guest)
     * machines require no guest-installed agents or drivers for native USB. On Linux clients, all packages required
     * for USB redirection are provided by the `virt-viewer` package. On Windows clients, you must also install the
     * `usbdk` package.
     */
    NATIVE("native"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(UsbType.class);
    
    private String image;
    
    UsbType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static UsbType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'UsbType' enumerated type. " +
            "Valid values are 'legacy' and 'native'.",
            exception
            );
            return null;
        }
    }
    
}

