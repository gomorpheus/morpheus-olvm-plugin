/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an enumeration of the protocol used
 * to connect to the graphic console of the virtual
 * machine.
 */
public enum DisplayType {
    /**
     * Display of type SPICE.
     * See https://www.spice-space.org for more details.
     */
    SPICE("spice"),
    /**
     * Display of type VNC. VNC stands for Virtual
     * Network Computing, and it is a graphical
     * desktop sharing system that uses RFB
     * (Remote Frame Buffer) protocol to remotely
     * control another machine.
     */
    VNC("vnc"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DisplayType.class);
    
    private String image;
    
    DisplayType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DisplayType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DisplayType' enumerated type. " +
            "Valid values are 'spice' and 'vnc'.",
            exception
            );
            return null;
        }
    }
    
}

