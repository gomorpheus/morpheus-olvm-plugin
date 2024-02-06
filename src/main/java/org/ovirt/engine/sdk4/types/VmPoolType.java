/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type represeting the deallocation policy of virtual machines in a virtual machines pool.
 */
public enum VmPoolType {
    /**
     * This policy indicates that virtual machines in the pool are automcatically deallocated by the system.
     * 
     * With this policy, when a virtual machine that is part of the pool and is assigned to a user is shut-down, it is
     * detached from the user, its state is restored to the pool's default state, and the virtual machine returns to
     * pool (i.e., the virtual machine can then be assigned to another user).
     */
    AUTOMATIC("automatic"),
    /**
     * This policy indicates that virtual machines in the pool are deallocated manually by the administrator.
     * 
     * With this policy, a virtual machine that is part of the pool remains assigned to its user and preserves its state
     * on shut-down. In order to return the virtual machine back to the pool, the administrator needs to deallocate it
     * explicitly by removing the user's permissions on that virtual machine.
     */
    MANUAL("manual"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(VmPoolType.class);
    
    private String image;
    
    VmPoolType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static VmPoolType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'VmPoolType' enumerated type. " +
            "Valid values are 'automatic' and 'manual'.",
            exception
            );
            return null;
        }
    }
    
}

