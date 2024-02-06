/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum StorageDomainStatus {
    ACTIVATING("activating"),
    ACTIVE("active"),
    DETACHING("detaching"),
    INACTIVE("inactive"),
    LOCKED("locked"),
    MAINTENANCE("maintenance"),
    MIXED("mixed"),
    PREPARING_FOR_MAINTENANCE("preparing_for_maintenance"),
    UNATTACHED("unattached"),
    UNKNOWN("unknown"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(StorageDomainStatus.class);
    
    private String image;
    
    StorageDomainStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static StorageDomainStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'StorageDomainStatus' enumerated type. " +
            "Valid values are 'activating', 'active', 'detaching', 'inactive', 'locked', 'maintenance', 'mixed', 'preparing_for_maintenance', 'unattached' and 'unknown'.",
            exception
            );
            return null;
        }
    }
    
}

