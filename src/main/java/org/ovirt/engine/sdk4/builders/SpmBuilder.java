/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.SpmContainer;
import org.ovirt.engine.sdk4.types.Spm;
import org.ovirt.engine.sdk4.types.SpmStatus;

public class SpmBuilder {
    private BigInteger priority;
    private SpmStatus status;
    
    public SpmBuilder priority(int newPriority) {
        priority = BigInteger.valueOf((long) newPriority);
        return this;
    }
    
    public SpmBuilder priority(Integer newPriority) {
        if (newPriority == null) {
            priority = null;
        }
        else {
            priority = BigInteger.valueOf(newPriority.longValue());
        }
        return this;
    }
    
    public SpmBuilder priority(long newPriority) {
        priority = BigInteger.valueOf(newPriority);
        return this;
    }
    
    public SpmBuilder priority(Long newPriority) {
        if (newPriority == null) {
            priority = null;
        }
        else {
            priority = BigInteger.valueOf(newPriority.longValue());
        }
        return this;
    }
    
    public SpmBuilder priority(BigInteger newPriority) {
        priority = newPriority;
        return this;
    }
    
    
    public SpmBuilder status(SpmStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public Spm build() {
        SpmContainer container = new SpmContainer();
        container.priority(priority);
        container.status(status);
        return container;
    }
}
