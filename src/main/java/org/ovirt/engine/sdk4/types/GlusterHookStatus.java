/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GlusterHookStatus {
    /**
     * Hook is disabled in the cluster.
     */
    DISABLED("disabled"),
    /**
     * Hook is enabled in the cluster.
     */
    ENABLED("enabled"),
    /**
     * Unknown/missing hook status.
     */
    MISSING("missing"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(GlusterHookStatus.class);
    
    private String image;
    
    GlusterHookStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static GlusterHookStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'GlusterHookStatus' enumerated type. " +
            "Valid values are 'disabled', 'enabled' and 'missing'.",
            exception
            );
            return null;
        }
    }
    
}

