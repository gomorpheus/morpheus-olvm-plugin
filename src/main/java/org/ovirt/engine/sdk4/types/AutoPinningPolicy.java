/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing what the CPU and NUMA pinning policy is.
 */
public enum AutoPinningPolicy {
    /**
     * The CPU and NUMA pinning will be configured by the dedicated host.
     * 
     * Currently, its implication is that the CPU and NUMA pinning will use the dedicated host CPU topology.
     * The virtual machine configuration will automatically be set to fit the host to get the highest possible
     * performance.
     */
    ADJUST("adjust"),
    /**
     * The CPU and NUMA pinning won't be calculated.
     * 
     * Currently, its implication is that the CPU and NUMA pinning won't be calculated to the current virtual
     * machine configuration. By default the VM topology set with 1 Socket, 1 Core and 1 Thread.
     */
    DISABLED("disabled"),
    /**
     * The CPU and NUMA pinning will be configured by the virtual machine current state.
     * 
     * Currently, its implication is that the CPU and NUMA pinning will use the provided virtual machine CPU topology.
     * Without given CPU topology it will use the engine defaults (the VM topology set with 1 Socket, 1 Core and
     * 1 Thread).
     */
    EXISTING("existing"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(AutoPinningPolicy.class);
    
    private String image;
    
    AutoPinningPolicy(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static AutoPinningPolicy fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'AutoPinningPolicy' enumerated type. " +
            "Valid values are 'adjust', 'disabled' and 'existing'.",
            exception
            );
            return null;
        }
    }
    
}

