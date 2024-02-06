/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * When a direct LUN disk is using SCSI passthrough the privileged I/O policy is determined by this enum.
 */
public enum ScsiGenericIO {
    /**
     * Disable SCSI passthrough.
     */
    DISABLED("disabled"),
    /**
     * Disallow privileged SCSI I/O.
     */
    FILTERED("filtered"),
    /**
     * Allow privileged SCSI I/O.
     */
    UNFILTERED("unfiltered"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ScsiGenericIO.class);
    
    private String image;
    
    ScsiGenericIO(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ScsiGenericIO fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ScsiGenericIO' enumerated type. " +
            "Valid values are 'disabled', 'filtered' and 'unfiltered'.",
            exception
            );
            return null;
        }
    }
    
}

