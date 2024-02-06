/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface MemoryOverCommit {
    BigInteger percent();
    Byte percentAsByte();
    Short percentAsShort();
    Integer percentAsInteger();
    Long percentAsLong();
    
    boolean percentPresent();
    
}
