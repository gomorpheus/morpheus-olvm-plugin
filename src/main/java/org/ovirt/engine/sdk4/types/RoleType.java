/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing whether a role is administrative or not.
 * A user which was granted at least one administrative role is considered
 * an administrator.
 */
public enum RoleType {
    /**
     * Administrative role.
     */
    ADMIN("admin"),
    /**
     * User role.
     */
    USER("user"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(RoleType.class);
    
    private String image;
    
    RoleType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static RoleType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'RoleType' enumerated type. " +
            "Valid values are 'admin' and 'user'.",
            exception
            );
            return null;
        }
    }
    
}

