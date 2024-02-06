/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Openstack Volume (Cinder) integration has been replaced by Managed Block Storage.
 */
public enum OpenstackVolumeAuthenticationKeyUsageType {
    CEPH("ceph"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(OpenstackVolumeAuthenticationKeyUsageType.class);
    
    private String image;
    
    OpenstackVolumeAuthenticationKeyUsageType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static OpenstackVolumeAuthenticationKeyUsageType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'OpenstackVolumeAuthenticationKeyUsageType' enumerated type. " +
            "Valid value is 'ceph'.",
            exception
            );
            return null;
        }
    }
    
}

