/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing a storage domain type.
 */
public enum StorageType {
    /**
     * Cinder storage domain.
     * For more details on Cinder please go to https://wiki.openstack.org/wiki/Cinder[Cinder].
     */
    CINDER("cinder"),
    /**
     * Fibre-Channel storage domain.
     */
    FCP("fcp"),
    /**
     * Glance storage domain.
     * For more details on Glance please go to https://wiki.openstack.org/wiki/Glance[Glance].
     */
    GLANCE("glance"),
    /**
     * Gluster-FS storage domain.
     * For more details on Gluster please go to https://www.gluster.org/[Gluster].
     */
    GLUSTERFS("glusterfs"),
    /**
     * iSCSI storage domain.
     */
    ISCSI("iscsi"),
    /**
     * Storage domain on Local storage.
     */
    LOCALFS("localfs"),
    /**
     * Managed block storage domain.
     * A storage domain managed using cinderlib.
     * For supported storage drivers, see https://docs.openstack.org/cinder/rocky/drivers.html[Available Drivers].
     */
    MANAGED_BLOCK_STORAGE("managed_block_storage"),
    /**
     * NFS storage domain.
     */
    NFS("nfs"),
    /**
     * POSIX-FS storage domain.
     */
    POSIXFS("posixfs"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(StorageType.class);
    
    private String image;
    
    StorageType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static StorageType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'StorageType' enumerated type. " +
            "Valid values are 'cinder', 'fcp', 'glance', 'glusterfs', 'iscsi', 'localfs', 'managed_block_storage', 'nfs' and 'posixfs'.",
            exception
            );
            return null;
        }
    }
    
}

