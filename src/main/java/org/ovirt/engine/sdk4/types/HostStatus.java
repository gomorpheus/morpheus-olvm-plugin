/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing a host status.
 */
public enum HostStatus {
    /**
     * The engine cannot communicate with the host for a specific threshold
     * so it is now trying to connect before going through fencing.
     */
    CONNECTING("connecting"),
    /**
     * The host is down.
     */
    DOWN("down"),
    /**
     * The host is in error status.
     * This will happen if we will try
     * to run a virtual machine several times and it
     * will fail.
     */
    ERROR("error"),
    /**
     * The host is initializing.
     * This is an intermediate step before
     * moving the host to 'up' status.
     */
    INITIALIZING("initializing"),
    /**
     * The host installation failed.
     * In such cases look at the event log to understand
     * what failed the installation, and issue a re-install.
     */
    INSTALL_FAILED("install_failed"),
    /**
     * The host is being installed.
     */
    INSTALLING("installing"),
    /**
     * The host operating system is now installing.
     * This status is relevant when using a Satellite/Foreman
     * provider, and issuing a bare-metal provisioning (discovered host provisioning).
     */
    INSTALLING_OS("installing_os"),
    /**
     * The host kernel has crashed and it is now going through memory dumping.
     */
    KDUMPING("kdumping"),
    /**
     * The host is in maintenance status.
     * When a host is in maintenance it cannot run virtual machines.
     */
    MAINTENANCE("maintenance"),
    /**
     * The host is non operational.
     * This can happen due to various reasons, such as not having
     * a connection with the storage, not supporting a mandatory network,
     * not supporting the cluster level, and more.
     */
    NON_OPERATIONAL("non_operational"),
    /**
     * The host is not responsive.
     * This means that the engine is not able to communicate with the host.
     */
    NON_RESPONSIVE("non_responsive"),
    /**
     * The host is pending administrator approval.
     * This is relevant only for vintage ovirt-node / RHV-H.
     * This property is no longer relevant since Vintage Node is no longer supported, and has been deprecated.
     */
    PENDING_APPROVAL("pending_approval"),
    /**
     * The host is preparing for maintenance.
     * During this time the engine makes sure to live migrate
     * all the virtual machines from this host to other hosts.
     * Once all migrations have been completed the host will move
     * to 'maintenance' status.
     */
    PREPARING_FOR_MAINTENANCE("preparing_for_maintenance"),
    /**
     * The host is being rebooted.
     */
    REBOOT("reboot"),
    /**
     * The host is in activation process.
     */
    UNASSIGNED("unassigned"),
    /**
     * The host is up.
     */
    UP("up"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(HostStatus.class);
    
    private String image;
    
    HostStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static HostStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'HostStatus' enumerated type. " +
            "Valid values are 'connecting', 'down', 'error', 'initializing', 'install_failed', 'installing', 'installing_os', 'kdumping', 'maintenance', 'non_operational', 'non_responsive', 'pending_approval', 'preparing_for_maintenance', 'reboot', 'unassigned' and 'up'.",
            exception
            );
            return null;
        }
    }
    
}

