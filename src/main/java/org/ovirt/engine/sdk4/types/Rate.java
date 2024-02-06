/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * Determines maximum speed of consumption of bytes from random number generator device.
 */
public interface Rate {
    BigInteger bytes();
    Byte bytesAsByte();
    Short bytesAsShort();
    Integer bytesAsInteger();
    Long bytesAsLong();
    
    boolean bytesPresent();
    
    BigInteger period();
    Byte periodAsByte();
    Short periodAsShort();
    Integer periodAsInteger();
    Long periodAsLong();
    
    boolean periodPresent();
    
}
