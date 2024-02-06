/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum DiskStorageType {
    CINDER("cinder"),
    IMAGE("image"),
    LUN("lun"),
    /**
     * A storage type, used for a storage domain that was created
     * using a cinderlib driver.
     */
    MANAGED_BLOCK_STORAGE("managed_block_storage"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DiskStorageType.class);
    
    private String image;
    
    DiskStorageType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DiskStorageType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DiskStorageType' enumerated type. " +
            "Valid values are 'cinder', 'image', 'lun' and 'managed_block_storage'.",
            exception
            );
            return null;
        }
    }
    
}

