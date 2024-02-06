/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Representing the random generator backend types.
 */
public enum RngSource {
    /**
     * Obtains random data from the `/dev/hwrng` (usually specialized HW generator) device.
     */
    HWRNG("hwrng"),
    /**
     * Obtains random data from the `/dev/random` device.
     */
    RANDOM("random"),
    /**
     * Obtains random data from the `/dev/urandom` device.
     * 
     * This RNG source is meant to replace `random` RNG source for non-cluster-aware entities (i.e. Blank template and
     * instance types) and entities associated with clusters with compatibility version 4.1 or higher.
     */
    URANDOM("urandom"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(RngSource.class);
    
    private String image;
    
    RngSource(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static RngSource fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'RngSource' enumerated type. " +
            "Valid values are 'hwrng', 'random' and 'urandom'.",
            exception
            );
            return null;
        }
    }
    
}

