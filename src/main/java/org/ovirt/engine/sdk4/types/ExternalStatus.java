/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an external status.
 * This status is currently used for <<types/host, hosts>>
 * and <<types/storage_domain, storage domains>>, and allows an external
 * system to update status of objects it is aware of.
 */
public enum ExternalStatus {
    /**
     * Error status. There is some kind of error
     * in the relevant object.
     */
    ERROR("error"),
    /**
     * Failure status. The relevant object is failing.
     */
    FAILURE("failure"),
    /**
     * Info status. The relevant object is in OK status,
     * but there is an information available that might be
     * relevant for the administrator.
     */
    INFO("info"),
    /**
     * OK status. The relevant object is working well.
     */
    OK("ok"),
    /**
     * Warning status. The relevant object is working well,
     * but there is some warning that might be relevant for
     * the administrator.
     */
    WARNING("warning"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ExternalStatus.class);
    
    private String image;
    
    ExternalStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ExternalStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ExternalStatus' enumerated type. " +
            "Valid values are 'error', 'failure', 'info', 'ok' and 'warning'.",
            exception
            );
            return null;
        }
    }
    
}

