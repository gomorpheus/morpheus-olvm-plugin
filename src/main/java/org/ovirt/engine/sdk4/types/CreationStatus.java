/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CreationStatus {
    COMPLETE("complete"),
    FAILED("failed"),
    IN_PROGRESS("in_progress"),
    PENDING("pending"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(CreationStatus.class);
    
    private String image;
    
    CreationStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static CreationStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'CreationStatus' enumerated type. " +
            "Valid values are 'complete', 'failed', 'in_progress' and 'pending'.",
            exception
            );
            return null;
        }
    }
    
}

