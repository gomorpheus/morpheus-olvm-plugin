/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * This type represents a watchdog configuration.
 */
public interface Watchdog extends Device {
    WatchdogAction action();
    
    boolean actionPresent();
    
    WatchdogModel model();
    
    boolean modelPresent();
    
}
