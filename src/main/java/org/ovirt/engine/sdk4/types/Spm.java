/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface Spm {
    BigInteger priority();
    Byte priorityAsByte();
    Short priorityAsShort();
    Integer priorityAsInteger();
    Long priorityAsLong();
    
    boolean priorityPresent();
    
    SpmStatus status();
    
    boolean statusPresent();
    
}
