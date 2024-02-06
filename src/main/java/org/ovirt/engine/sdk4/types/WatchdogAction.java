/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This type describes available watchdog actions.
 */
public enum WatchdogAction {
    /**
     * Virtual machine process will get core dumped to the default path on the host.
     */
    DUMP("dump"),
    /**
     * No action will be performed when watchdog action is triggered. However log message will still be generated.
     */
    NONE("none"),
    /**
     * Virtual machine will be paused when watchdog action is triggered.
     */
    PAUSE("pause"),
    /**
     * Virtual machine will be powered off when watchdog action is triggered.
     */
    POWEROFF("poweroff"),
    /**
     * Virtual machine will be rebooted when watchdog action is triggered.
     */
    RESET("reset"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(WatchdogAction.class);
    
    private String image;
    
    WatchdogAction(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static WatchdogAction fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'WatchdogAction' enumerated type. " +
            "Valid values are 'dump', 'none', 'pause', 'poweroff' and 'reset'.",
            exception
            );
            return null;
        }
    }
    
}

