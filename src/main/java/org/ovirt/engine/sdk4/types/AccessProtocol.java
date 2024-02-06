/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the access protocols supported by Gluster volumes.
 * `gluster` and `nfs` are enabled by default.
 */
public enum AccessProtocol {
    /**
     * CIFS access protocol.
     */
    CIFS("cifs"),
    /**
     * Gluster access protocol.
     */
    GLUSTER("gluster"),
    /**
     * NFS access protocol.
     */
    NFS("nfs"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(AccessProtocol.class);
    
    private String image;
    
    AccessProtocol(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static AccessProtocol fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'AccessProtocol' enumerated type. " +
            "Valid values are 'cifs', 'gluster' and 'nfs'.",
            exception
            );
            return null;
        }
    }
    
}

