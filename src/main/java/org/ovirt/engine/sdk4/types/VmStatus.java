/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type represeting a status of a virtual machine.
 */
public enum VmStatus {
    /**
     * This status indicates that the virtual machine process is not running.
     */
    DOWN("down"),
    /**
     * This status indicates that the virtual machine process is not running and there is some operation on the disks of
     * the virtual machine that prevents it from being started.
     */
    IMAGE_LOCKED("image_locked"),
    /**
     * This status indicates that the virtual machine process is running and the virtual machine is being migrated from
     * one host to another.
     */
    MIGRATING("migrating"),
    /**
     * This status indicates that the hypervisor detected that the virtual machine is not responding.
     */
    NOT_RESPONDING("not_responding"),
    /**
     * This status indicates that the virtual machine process is running and the virtual machine is paused.
     * This may happen in two cases: when running a virtual machine is paused mode and when the virtual machine is being
     * automatically paused due to an error.
     */
    PAUSED("paused"),
    /**
     * This status indicates that the virtual machine process is running and it is about to stop running.
     */
    POWERING_DOWN("powering_down"),
    /**
     * This status indicates that the virtual machine process is running and the guest operating system is being loaded.
     * Note that if no guest-agent is installed, this status is set for a predefined period of time, that is by
     * default 60 seconds, when running a virtual machine.
     */
    POWERING_UP("powering_up"),
    /**
     * This status indicates that the virtual machine process is running and the guest operating system is being
     * rebooted.
     */
    REBOOT_IN_PROGRESS("reboot_in_progress"),
    /**
     * This status indicates that the virtual machine process is about to run and the virtual machine is going to awake
     * from hibernation.
     * In this status, the running state of the virtual machine is being restored.
     */
    RESTORING_STATE("restoring_state"),
    /**
     * This status indicates that the virtual machine process is running and the virtual machine is being hibernated.
     * In this status, the running state of the virtual machine is being saved.
     * Note that this status does not mean that the guest operating system is being hibernated.
     */
    SAVING_STATE("saving_state"),
    /**
     * This status indicates that the virtual machine process is not running and a running state of the virtual machine
     * was saved.
     * This status is similar to Down, but when the VM is started in this status its saved running state is restored
     * instead of being booted using the normal procedue.
     */
    SUSPENDED("suspended"),
    /**
     * This status is set when an invalid status is received.
     */
    UNASSIGNED("unassigned"),
    /**
     * This status indicates that the system failed to determine the status of the virtual machine.
     * The virtual machine process may be running or not running in this status.
     * For instance, when host becomes non-responsive the virtual machines that ran on it are set with this status.
     */
    UNKNOWN("unknown"),
    /**
     * This status indicates that the virtual machine process is running and the guest operating system is loaded.
     * Note that if no guest-agent is installed, this status is set after a predefined period of time, that is by
     * default 60 seconds, when running a virtual machine.
     */
    UP("up"),
    /**
     * This status indicates that the virtual machine process is about to run.
     * This status is set when a request to run a virtual machine arrives to the host.
     * It is possible that the virtual machine process will fail to run.
     */
    WAIT_FOR_LAUNCH("wait_for_launch"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(VmStatus.class);
    
    private String image;
    
    VmStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static VmStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'VmStatus' enumerated type. " +
            "Valid values are 'down', 'image_locked', 'migrating', 'not_responding', 'paused', 'powering_down', 'powering_up', 'reboot_in_progress', 'restoring_state', 'saving_state', 'suspended', 'unassigned', 'unknown', 'up' and 'wait_for_launch'.",
            exception
            );
            return null;
        }
    }
    
}

