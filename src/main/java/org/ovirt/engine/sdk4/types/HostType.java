/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This enumerated type is used to determine which type of operating system is used by the host.
 */
public enum HostType {
    /**
     * The host contains Red Hat Virtualization Host (RHVH): a new implementation of
     * Red Hat Enterprise Virtualization Hypervisor (RHEV-H) which uses the same installer as Red Hat Enterprise Linux,
     * CentOS, or Fedora. The main difference between RHVH and legacy RHEV-H is that RHVH has a writeable file system
     * and will handle its own installation instead of having RPMs pushed to it by the Manager like in legacy RHEV-H.
     */
    OVIRT_NODE("ovirt_node"),
    /**
     * The host contains a full Red Hat Enterprise Linux, CentOS, or Fedora installation.
     */
    RHEL("rhel"),
    /**
     * The host contains Red Hat Enterprise Virtualization Hypervisor (RHEV-H), a small-scaled version of Red Hat
     * Enterprise Linux, CentOS, or Fedora, used solely to host virtual machines.
     * 
     * This property is no longer relevant since Vintage Node is no longer supported, and has been deprecated.
     */
    RHEV_H("rhev_h"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(HostType.class);
    
    private String image;
    
    HostType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static HostType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'HostType' enumerated type. " +
            "Valid values are 'ovirt_node', 'rhel' and 'rhev_h'.",
            exception
            );
            return null;
        }
    }
    
}

