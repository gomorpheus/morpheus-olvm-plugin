/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing a status of a virtual machine template.
 */
public enum TemplateStatus {
    /**
     * This status indicates that at least one of the disks of the template is illegal.
     */
    ILLEGAL("illegal"),
    /**
     * This status indicates that some operation that prevents other operations with the template is being executed.
     */
    LOCKED("locked"),
    /**
     * This status indicates that the template is valid and ready for use.
     */
    OK("ok"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(TemplateStatus.class);
    
    private String image;
    
    TemplateStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static TemplateStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'TemplateStatus' enumerated type. " +
            "Valid values are 'illegal', 'locked' and 'ok'.",
            exception
            );
            return null;
        }
    }
    
}

