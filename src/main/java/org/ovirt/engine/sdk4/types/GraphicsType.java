/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The graphics protocol used to connect to the graphic console.
 */
public enum GraphicsType {
    /**
     * Graphics protocol of type SPICE.
     * See https://www.spice-space.org for more details.
     */
    SPICE("spice"),
    /**
     * Graphics protocol of type VNC. VNC stands for Virtual
     * Network Computing, and it is a graphical
     * desktop sharing system that uses RFB
     * (Remote Frame Buffer) protocol to remotely
     * control another machine.
     */
    VNC("vnc"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(GraphicsType.class);
    
    private String image;
    
    GraphicsType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static GraphicsType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'GraphicsType' enumerated type. " +
            "Valid values are 'spice' and 'vnc'.",
            exception
            );
            return null;
        }
    }
    
}

