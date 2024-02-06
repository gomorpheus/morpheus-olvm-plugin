/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * Represents the pinning of a virtual NUMA node to a physical NUMA node.
 */
public interface NumaNodePin {
    NumaNode hostNumaNode();
    
    boolean hostNumaNodePresent();
    
    BigInteger index();
    Byte indexAsByte();
    Short indexAsShort();
    Integer indexAsInteger();
    Long indexAsLong();
    
    boolean indexPresent();
    
    boolean pinned();
    
    boolean pinnedPresent();
    
}
