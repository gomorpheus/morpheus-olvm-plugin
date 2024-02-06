/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum MigrateOnError {
    DO_NOT_MIGRATE("do_not_migrate"),
    MIGRATE("migrate"),
    MIGRATE_HIGHLY_AVAILABLE("migrate_highly_available"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(MigrateOnError.class);
    
    private String image;
    
    MigrateOnError(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static MigrateOnError fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'MigrateOnError' enumerated type. " +
            "Valid values are 'do_not_migrate', 'migrate' and 'migrate_highly_available'.",
            exception
            );
            return null;
        }
    }
    
}

