/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type which represents a format of <<types/storage_domain, storage domain>>.
 */
public enum StorageFormat {
    /**
     * Version 1 of the storage domain format is applicable to NFS, iSCSI and FC storage domains.
     * 
     * Each storage domain contains metadata describing its own structure, and all of the names of physical volumes that
     * are used to back virtual machine disk images. Master domains additionally contain metadata for all the domains
     * and physical volume names in the storage pool. The total size of this metadata is limited to 2 KiB, limiting the
     * number of storage domains that can be in a pool. Template and virtual machine base images are read only.
     */
    V1("v1"),
    /**
     * Version 2 of the storage domain format is applicable to iSCSI and FC storage domains.
     * 
     * All storage domain and pool metadata is stored as logical volume tags rather than written to a logical volume.
     * Metadata about virtual machine disk volumes is still stored in a logical volume on the domains. Physical volume
     * names are no longer included in the metadata. Template and virtual machine base images are read only.
     */
    V2("v2"),
    /**
     * Version 3 of the storage domain format is applicable to NFS, POSIX, iSCSI and FC storage domains.
     * 
     * All storage domain and pool metadata is stored as logical volume tags rather than written to a logical volume.
     * Metadata about virtual machine disk volumes is still stored in a logical volume on the domains. Virtual machine
     * and template base images are no longer read only. This change enables live snapshots, live storage migration,
     * and clone from snapshot. Support for Unicode metadata is added, for non-English volume names.
     */
    V3("v3"),
    /**
     * Version 4 of the storage domain format.
     */
    V4("v4"),
    /**
     * Version 5 of the storage domain format is applicable to NFS, POSIX, and Gluster storage domains.
     * 
     * Added support for 4096 bytes block sizes and variable sanlock alignments.
     */
    V5("v5"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(StorageFormat.class);
    
    private String image;
    
    StorageFormat(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static StorageFormat fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'StorageFormat' enumerated type. " +
            "Valid values are 'v1', 'v2', 'v3', 'v4' and 'v5'.",
            exception
            );
            return null;
        }
    }
    
}

