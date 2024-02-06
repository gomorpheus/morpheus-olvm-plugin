/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The vGPU placement strategy.
 * 
 * It can either put vGPUs on the first available physical
 * cards, or spread them over multiple physical cards.
 */
public enum VgpuPlacement {
    /**
     * Use consolidated placement. Each vGPU is placed on the first physical card with available space.
     * 
     * This is the default placement, utilizing all available space on the physical cards.
     */
    CONSOLIDATED("consolidated"),
    /**
     * Use separated placement. Each vGPU is placed on a separate physical card, if possible.
     * 
     * This can be useful for improving vGPU performance.
     */
    SEPARATED("separated"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(VgpuPlacement.class);
    
    private String image;
    
    VgpuPlacement(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static VgpuPlacement fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'VgpuPlacement' enumerated type. " +
            "Valid values are 'consolidated' and 'separated'.",
            exception
            );
            return null;
        }
    }
    
}

