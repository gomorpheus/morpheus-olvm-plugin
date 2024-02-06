/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Representation of the FIPS mode to the cluster.
 */
public enum FipsMode {
    /**
     * The FIPS mode is disabled.
     * 
     * Its implication is that the FIPS mode is disabled and the hosts within should be with FIPS mode
     * disabled, otherwise they would be non-operational.
     */
    DISABLED("disabled"),
    /**
     * The FIPS mode is enabled.
     * 
     * Its implication is that the FIPS mode is enabled and the hosts within should be with FIPS mode
     * enabled, otherwise they should be non-operational.
     */
    ENABLED("enabled"),
    /**
     * The FIPS mode is not yet evaluated.
     * 
     * Currently, its implication is that the FIPS mode is undetermined. Once a host is added, this value
     * will switch according to the host settings.
     */
    UNDEFINED("undefined"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(FipsMode.class);
    
    private String image;
    
    FipsMode(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static FipsMode fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'FipsMode' enumerated type. " +
            "Valid values are 'disabled', 'enabled' and 'undefined'.",
            exception
            );
            return null;
        }
    }
    
}

