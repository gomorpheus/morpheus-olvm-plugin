/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Represents a label which can be added to a host network interface and to a network.
 * The label binds the network to the host network interface by the label `id`.
 */
public interface NetworkLabel extends Identified {
    HostNic hostNic();
    
    boolean hostNicPresent();
    
    Network network();
    
    boolean networkPresent();
    
}
