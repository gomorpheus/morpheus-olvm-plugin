/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Describes all switch types supported by the Manager.
 */
public enum SwitchType {
    /**
     * The native switch type.
     */
    LEGACY("legacy"),
    /**
     * The Open vSwitch type.
     */
    OVS("ovs"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(SwitchType.class);
    
    private String image;
    
    SwitchType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static SwitchType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'SwitchType' enumerated type. " +
            "Valid values are 'legacy' and 'ovs'.",
            exception
            );
            return null;
        }
    }
    
}

