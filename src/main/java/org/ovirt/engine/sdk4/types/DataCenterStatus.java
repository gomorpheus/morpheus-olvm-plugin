/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum DataCenterStatus {
    CONTEND("contend"),
    MAINTENANCE("maintenance"),
    NOT_OPERATIONAL("not_operational"),
    PROBLEMATIC("problematic"),
    UNINITIALIZED("uninitialized"),
    UP("up"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(DataCenterStatus.class);
    
    private String image;
    
    DataCenterStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static DataCenterStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'DataCenterStatus' enumerated type. " +
            "Valid values are 'contend', 'maintenance', 'not_operational', 'problematic', 'uninitialized' and 'up'.",
            exception
            );
            return null;
        }
    }
    
}

