/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PmProxyType {
    /**
     * The fence proxy is selected from the same cluster as the fenced host.
     */
    CLUSTER("cluster"),
    /**
     * The fence proxy is selected from the same data center as the fenced host.
     */
    DC("dc"),
    /**
     * The fence proxy is selected from a different data center than the fenced host.
     */
    OTHER_DC("other_dc"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(PmProxyType.class);
    
    private String image;
    
    PmProxyType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static PmProxyType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'PmProxyType' enumerated type. " +
            "Valid values are 'cluster', 'dc' and 'other_dc'.",
            exception
            );
            return null;
        }
    }
    
}

