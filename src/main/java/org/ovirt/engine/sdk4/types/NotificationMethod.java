/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing the notification method for an event
 * subscription. Currently only SMTP is supported by the API
 * In the future support for SNMP notifications may be added.
 */
public enum NotificationMethod {
    /**
     * Notification by e-mail.
     * 
     * Event-subscriptions with SMTP notification method will
     * contain an email address in the address field.
     */
    SMTP("smtp"),
    /**
     * Notification by SNMP.
     * 
     * Event-subscriptions with SNMP notification method will
     * contain an SNMP address in the address field.
     */
    SNMP("snmp"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(NotificationMethod.class);
    
    private String image;
    
    NotificationMethod(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static NotificationMethod fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'NotificationMethod' enumerated type. " +
            "Valid values are 'smtp' and 'snmp'.",
            exception
            );
            return null;
        }
    }
    
}

