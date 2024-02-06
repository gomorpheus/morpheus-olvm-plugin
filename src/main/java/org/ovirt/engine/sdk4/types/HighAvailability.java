/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * Type representing high availability of a virtual machine.
 */
public interface HighAvailability {
    boolean enabled();
    
    boolean enabledPresent();
    
    BigInteger priority();
    Byte priorityAsByte();
    Short priorityAsShort();
    Integer priorityAsInteger();
    Long priorityAsLong();
    
    boolean priorityPresent();
    
}
