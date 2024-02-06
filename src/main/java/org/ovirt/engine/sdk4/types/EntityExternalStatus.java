/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing an external entity status.
 */
public enum EntityExternalStatus {
    /**
     * The external entity status is erroneous. This might require a moderate attention.
     */
    ERROR("error"),
    /**
     * The external entity has an issue that causes failures. This might require immediate attention.
     */
    FAILURE("failure"),
    /**
     * There external entity status is okay but with some information that
     * might be relevant.
     */
    INFO("info"),
    /**
     * The external entity status is okay.
     */
    OK("ok"),
    /**
     * The external entity status is okay but with an issue that might require attention.
     */
    WARNING("warning"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(EntityExternalStatus.class);
    
    private String image;
    
    EntityExternalStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static EntityExternalStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'EntityExternalStatus' enumerated type. " +
            "Valid values are 'error', 'failure', 'info', 'ok' and 'warning'.",
            exception
            );
            return null;
        }
    }
    
}

