/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Represents an IP address assignment for a network device.
 * 
 * For a static boot protocol assignment, subnet mask and IP address
 * (and optinally default gateway) must be provided in the IP configuration.
 */
public interface IpAddressAssignment {
    BootProtocol assignmentMethod();
    
    boolean assignmentMethodPresent();
    
    Ip ip();
    
    boolean ipPresent();
    
}
