/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing the policy of a Serial Number.
 */
public enum SerialNumberPolicy {
    /**
     * This policy allows the user to provide an arbitrary string as the Serial Number.
     */
    CUSTOM("custom"),
    /**
     * This policy is the legacy policy. It will use the Host ID as the Serial Number.
     */
    HOST("host"),
    /**
     * This policy is used to remove the Serial Number Policy, moving it to default: null.
     */
    NONE("none"),
    /**
     * This policy will use the Virtual Machine ID as the Serial Number.
     */
    VM("vm"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(SerialNumberPolicy.class);
    
    private String image;
    
    SerialNumberPolicy(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static SerialNumberPolicy fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'SerialNumberPolicy' enumerated type. " +
            "Valid values are 'custom', 'host', 'none' and 'vm'.",
            exception
            );
            return null;
        }
    }
    
}

