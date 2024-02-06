/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The actual content residing on the disk.
 */
public enum DiskContentType {
    /**
     * The disk contains protected VM backup data.
     */
    BACKUP_SCRATCH("backup_scratch"),
    /**
     * The disk contains data.
     */
    DATA("data"),
    /**
     * The disk contains the Hosted Engine VM disk.
     */
    HOSTED_ENGINE("hosted_engine"),
    /**
     * The disk contains the Hosted Engine configuration disk.
     */
    HOSTED_ENGINE_CONFIGURATION("hosted_engine_configuration"),
    /**
     * The disk contains the Hosted Engine metadata disk.
     */
    HOSTED_ENGINE_METADATA("hosted_engine_metadata"),
    /**
     * The disk contains the Hosted Engine Sanlock disk.
     */
    HOSTED_ENGINE_SANLOCK("hosted_engine_sanlock"),
    /**
     * The disk contains an ISO image to be used a CDROM device.
     */
    ISO("iso"),
    /**
     * The disk contains a memory dump from a live snapshot.
     */
    MEMORY_DUMP_VOLUME("memory_dump_volume"),
    /**
     * The disk contains memory metadata from a live snapshot.
     */
    MEMORY_METADATA_VOLUME("memory_metadata_volume"),
    /**
     * The disk is an OVF store.
     */
    OVF_STORE("ovf_store"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DiskContentType.class);
    
    private String image;
    
    DiskContentType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DiskContentType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DiskContentType' enumerated type. " +
            "Valid values are 'backup_scratch', 'data', 'hosted_engine', 'hosted_engine_configuration', 'hosted_engine_metadata', 'hosted_engine_sanlock', 'iso', 'memory_dump_volume', 'memory_metadata_volume' and 'ovf_store'.",
            exception
            );
            return null;
        }
    }
    
}

