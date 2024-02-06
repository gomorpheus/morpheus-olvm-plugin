/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * If the storage, on which this virtual machine has some disks gets
 * unresponsive, the virtual machine gets paused.
 * 
 * This are the possible options, what should happen with the virtual machine
 * in the moment the storage gets available again.
 */
public enum VmStorageErrorResumeBehaviour {
    /**
     * The virtual machine gets resumed automatically in the moment the storage is available
     * again.
     * 
     * This is the only behavior available before 4.2.
     */
    AUTO_RESUME("auto_resume"),
    /**
     * The virtual machine will be killed after a timeout (configurable on the hypervisor).
     * 
     * This is the only option supported for highly available virtual machines
     * with leases. The reason is that the highly available virtual machine is
     * restarted using the infrastructure and any kind of resume risks
     * split brains.
     */
    KILL("kill"),
    /**
     * Do nothing with the virtual machine.
     * 
     * Useful if there is a custom failover implemented and the user does not
     * want the virtual machine to get resumed.
     */
    LEAVE_PAUSED("leave_paused"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(VmStorageErrorResumeBehaviour.class);
    
    private String image;
    
    VmStorageErrorResumeBehaviour(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static VmStorageErrorResumeBehaviour fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'VmStorageErrorResumeBehaviour' enumerated type. " +
            "Valid values are 'auto_resume', 'kill' and 'leave_paused'.",
            exception
            );
            return null;
        }
    }
    
}

