/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines how the migration bandwidth is assigned.
 */
public enum MigrationBandwidthAssignmentMethod {
    /**
     * Takes the bandwidth from the Quality of Service if the Quality of Service is defined.
     * If the Quality of Service is not defined the bandwidth is taken from the detected link speed being used.
     * If nothing is detected, bandwidth falls back to the hypervisor_default value.
     */
    AUTO("auto"),
    /**
     * Custom defined bandwidth in Mbit/s.
     */
    CUSTOM("custom"),
    /**
     * Takes the value as configured on the hypervisor.
     */
    HYPERVISOR_DEFAULT("hypervisor_default"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(MigrationBandwidthAssignmentMethod.class);
    
    private String image;
    
    MigrationBandwidthAssignmentMethod(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static MigrationBandwidthAssignmentMethod fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'MigrationBandwidthAssignmentMethod' enumerated type. " +
            "Valid values are 'auto', 'custom' and 'hypervisor_default'.",
            exception
            );
            return null;
        }
    }
    
}

