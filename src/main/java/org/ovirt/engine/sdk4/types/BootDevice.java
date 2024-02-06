/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the kinds of devices that a virtual machine can boot from.
 */
public enum BootDevice {
    /**
     * Boot from CD-ROM. The CD-ROM can be chosen from the list of ISO files available in an ISO domain attached to the
     * ata center that the virtual machine belongs to.
     */
    CDROM("cdrom"),
    /**
     * Boot from the hard drive.
     */
    HD("hd"),
    /**
     * Boot from the network, using PXE. It is necessary to have
     * https://en.wikipedia.org/wiki/Preboot_Execution_Environment[PXE] configured on the network that the virtual
     * machine is connected to.
     */
    NETWORK("network"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(BootDevice.class);
    
    private String image;
    
    BootDevice(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static BootDevice fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'BootDevice' enumerated type. " +
            "Valid values are 'cdrom', 'hd' and 'network'.",
            exception
            );
            return null;
        }
    }
    
}

