/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.MemoryOverCommitContainer;
import org.ovirt.engine.sdk4.types.MemoryOverCommit;

public class MemoryOverCommitBuilder {
    private BigInteger percent;
    
    public MemoryOverCommitBuilder percent(int newPercent) {
        percent = BigInteger.valueOf((long) newPercent);
        return this;
    }
    
    public MemoryOverCommitBuilder percent(Integer newPercent) {
        if (newPercent == null) {
            percent = null;
        }
        else {
            percent = BigInteger.valueOf(newPercent.longValue());
        }
        return this;
    }
    
    public MemoryOverCommitBuilder percent(long newPercent) {
        percent = BigInteger.valueOf(newPercent);
        return this;
    }
    
    public MemoryOverCommitBuilder percent(Long newPercent) {
        if (newPercent == null) {
            percent = null;
        }
        else {
            percent = BigInteger.valueOf(newPercent.longValue());
        }
        return this;
    }
    
    public MemoryOverCommitBuilder percent(BigInteger newPercent) {
        percent = newPercent;
        return this;
    }
    
    
    public MemoryOverCommit build() {
        MemoryOverCommitContainer container = new MemoryOverCommitContainer();
        container.percent(percent);
        return container;
    }
}
