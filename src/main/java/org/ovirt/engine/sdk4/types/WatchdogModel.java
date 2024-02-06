/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This type represents the watchdog model.
 */
public enum WatchdogModel {
    /**
     * The watchdog model for S390X machines.
     * 
     * S390X has an integrated watchdog facility that
     * is controlled via the DIAG288 instruction.
     * Use this model for S390X virtual machines.
     */
    DIAG288("diag288"),
    /**
     * PCI based watchdog model.
     * 
     * Use the I6300ESB watchdog for x86_64 and PPC64 virtual
     * machines.
     */
    I6300ESB("i6300esb"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(WatchdogModel.class);
    
    private String image;
    
    WatchdogModel(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static WatchdogModel fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'WatchdogModel' enumerated type. " +
            "Valid values are 'diag288' and 'i6300esb'.",
            exception
            );
            return null;
        }
    }
    
}

