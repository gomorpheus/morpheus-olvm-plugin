/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Indicates the kind of data managed by a <<types/storage_domain, storage domain>>.
 */
public enum StorageDomainType {
    /**
     * Data domains are used to store the disks and snapshots of the virtual machines and templates in the system. In
     * addition, snapshots of the disks are also stored in data domains. Data domains cannot be shared across data
     * centers.
     */
    DATA("data"),
    /**
     * Export domains are temporary storage repositories used to copy and move virtual machines and templates between
     * data centers and {product-name} environments. Export domains can also be used to backup virtual machines. An
     * export domain can be moved between data centers but it can only be active in one data center at a time.
     */
    EXPORT("export"),
    /**
     * Image domain store images that can be imported into from an external system. For example, images from an
     * OpenStack Glance image repository.
     */
    IMAGE("image"),
    /**
     * ISO domains store ISO files (or logical CDs) used to install and boot operating systems and applications for the
     * virtual machines. ISO domains remove the data center's need for physical media. An ISO domain can be shared
     * across different data centers.
     */
    ISO("iso"),
    /**
     * Managed block storage domains are created on block storage devices. These domains are accessed and managed by cinder.
     */
    MANAGED_BLOCK_STORAGE("managed_block_storage"),
    /**
     * Volume domains store logical volumes that can be used as disks for virtual machines. For example, volumes
     * from an OpenStack Cincer block storage service.
     */
    VOLUME("volume"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(StorageDomainType.class);
    
    private String image;
    
    StorageDomainType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static StorageDomainType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'StorageDomainType' enumerated type. " +
            "Valid values are 'data', 'export', 'image', 'iso', 'managed_block_storage' and 'volume'.",
            exception
            );
            return null;
        }
    }
    
}

