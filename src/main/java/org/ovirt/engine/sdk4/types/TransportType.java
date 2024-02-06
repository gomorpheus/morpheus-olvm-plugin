/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Protocol used to access a Gluster volume.
 */
public enum TransportType {
    /**
     * Remote direct memory access.
     */
    RDMA("rdma"),
    /**
     * TCP.
     */
    TCP("tcp"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(TransportType.class);
    
    private String image;
    
    TransportType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static TransportType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'TransportType' enumerated type. " +
            "Valid values are 'rdma' and 'tcp'.",
            exception
            );
            return null;
        }
    }
    
}

