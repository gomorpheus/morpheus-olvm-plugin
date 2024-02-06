/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The underlying storage interface of disks communication with controller.
 */
public enum DiskInterface {
    /**
     * Legacy controller device. Works with almost all guest operating systems, so it is good for compatibility.
     * Performance is lower than with the other alternatives.
     */
    IDE("ide"),
    /**
     * SATA controller device.
     */
    SATA("sata"),
    /**
     * Para-virtualized device supported by the IBM pSeries family of machines, using the SCSI protocol.
     */
    SPAPR_VSCSI("spapr_vscsi"),
    /**
     * Virtualization interface where just the guest's device driver knows it is running in a virtual environment.
     * Enables guests to get high performance disk operations.
     */
    VIRTIO("virtio"),
    /**
     * Para-virtualized SCSI controller device. Fast interface with the guest via direct physical storage device
     * address, using the SCSI protocol.
     */
    VIRTIO_SCSI("virtio_scsi"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DiskInterface.class);
    
    private String image;
    
    DiskInterface(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DiskInterface fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DiskInterface' enumerated type. " +
            "Valid values are 'ide', 'sata', 'spapr_vscsi', 'virtio' and 'virtio_scsi'.",
            exception
            );
            return null;
        }
    }
    
}

