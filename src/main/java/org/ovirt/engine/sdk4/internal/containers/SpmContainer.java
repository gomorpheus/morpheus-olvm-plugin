/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Spm;
import org.ovirt.engine.sdk4.types.SpmStatus;

public class SpmContainer extends Container implements Spm {
    private BigInteger priority;
    private SpmStatus status;
    
    public BigInteger priority() {
        return priority;
    }
    
    public Byte priorityAsByte() {
        return asByte("Spm", "priority", priority);
    }
    
    public Short priorityAsShort() {
        return asShort("Spm", "priority", priority);
    }
    
    public Integer priorityAsInteger() {
        return asInteger("Spm", "priority", priority);
    }
    
    public Long priorityAsLong() {
        return asLong("Spm", "priority", priority);
    }
    
    public void priority(BigInteger newPriority) {
        priority = newPriority;
    }
    
    public boolean priorityPresent() {
        return priority != null;
    }
    
    public SpmStatus status() {
        return status;
    }
    
    public void status(SpmStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
}
