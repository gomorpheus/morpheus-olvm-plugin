/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The QCOW version specifies to the qemu which qemu version the volume supports.
 * 
 * This field can be updated using the update API and will be reported only for QCOW volumes,
 * it is determined by the storage domain's version which the disk is created on.
 * Storage domains with version lower than V4 support QCOW2 version 2 volumes,
 * while V4 storage domains also support QCOW2 version 3.
 * For more information about features of the different QCOW versions, see http://wiki.qemu.org/Features/Qcow3[here].
 */
public enum QcowVersion {
    /**
     * The _Copy On Write_ default compatibility version
     * It means that every QEMU can use it.
     */
    QCOW2_V2("qcow2_v2"),
    /**
     * The _Copy On Write_ compatibility version which was introduced in QEMU 1.1
     * It means that the new format is in use.
     */
    QCOW2_V3("qcow2_v3"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(QcowVersion.class);
    
    private String image;
    
    QcowVersion(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static QcowVersion fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'QcowVersion' enumerated type. " +
            "Valid values are 'qcow2_v2' and 'qcow2_v3'.",
            exception
            );
            return null;
        }
    }
    
}

