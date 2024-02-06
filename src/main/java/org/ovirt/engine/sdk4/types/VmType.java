/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing what the virtual machine is optimized for.
 */
public enum VmType {
    /**
     * The virtual machine is intended to be used as a desktop.
     * 
     * Currently, its implication is that a sound device will automatically be added to the virtual machine.
     */
    DESKTOP("desktop"),
    /**
     * The virtual machine is intended to be used as a high performance virtual machine.
     * 
     * Currently, its implication is that the virtual machine configuration will automatically be set for running
     * with the highest possible performance, and with performance metrics as close to bare metal as possible.
     * 
     * Some of the recommended configuration settings for the highest possible performance
     * cannot be set automatically; manually setting them before running the virtual machine is recommended.
     * 
     * The following configuration changes are set automatically:
     * 
     * - Enable headless mode.
     * - Enable serial console.
     * - Enable pass-through host CPU.
     * - Enable I/O threads.
     * - Enable I/O threads pinning and set the pinning topology.
     * - Enable the paravirtualized random number generator PCI (virtio-rng) device.
     * - Disable all USB devices.
     * - Disable the soundcard device.
     * - Disable the smartcard device.
     * - Disable the memory balloon device.
     * - Disable the watchdog device.
     * - Disable migration.
     * - Disable high availability.
     * 
     * The following recommended configuration changes have to be set manually by the user:
     * 
     * - Enable CPU pinning topology.
     * - Enable non-uniform memory access (NUMA) pinning topology.
     * - Enable and set huge pages configuration.
     * - Disable kernel same-page merging (KSM).
     */
    HIGH_PERFORMANCE("high_performance"),
    /**
     * The virtual machine is intended to be used as a server.
     * 
     * Currently, its implication is that a sound device will not automatically be added to the virtual machine.
     */
    SERVER("server"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(VmType.class);
    
    private String image;
    
    VmType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static VmType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'VmType' enumerated type. " +
            "Valid values are 'desktop', 'high_performance' and 'server'.",
            exception
            );
            return null;
        }
    }
    
}

