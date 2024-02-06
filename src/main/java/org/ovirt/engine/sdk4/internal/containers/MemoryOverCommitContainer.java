/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.MemoryOverCommit;

public class MemoryOverCommitContainer extends Container implements MemoryOverCommit {
    private BigInteger percent;
    
    public BigInteger percent() {
        return percent;
    }
    
    public Byte percentAsByte() {
        return asByte("MemoryOverCommit", "percent", percent);
    }
    
    public Short percentAsShort() {
        return asShort("MemoryOverCommit", "percent", percent);
    }
    
    public Integer percentAsInteger() {
        return asInteger("MemoryOverCommit", "percent", percent);
    }
    
    public Long percentAsLong() {
        return asLong("MemoryOverCommit", "percent", percent);
    }
    
    public void percent(BigInteger newPercent) {
        percent = newPercent;
    }
    
    public boolean percentPresent() {
        return percent != null;
    }
    
}
