/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.VmSummaryContainer;
import org.ovirt.engine.sdk4.types.VmSummary;

public class VmSummaryBuilder {
    private BigInteger active;
    private BigInteger migrating;
    private BigInteger total;
    
    public VmSummaryBuilder active(int newActive) {
        active = BigInteger.valueOf((long) newActive);
        return this;
    }
    
    public VmSummaryBuilder active(Integer newActive) {
        if (newActive == null) {
            active = null;
        }
        else {
            active = BigInteger.valueOf(newActive.longValue());
        }
        return this;
    }
    
    public VmSummaryBuilder active(long newActive) {
        active = BigInteger.valueOf(newActive);
        return this;
    }
    
    public VmSummaryBuilder active(Long newActive) {
        if (newActive == null) {
            active = null;
        }
        else {
            active = BigInteger.valueOf(newActive.longValue());
        }
        return this;
    }
    
    public VmSummaryBuilder active(BigInteger newActive) {
        active = newActive;
        return this;
    }
    
    
    public VmSummaryBuilder migrating(int newMigrating) {
        migrating = BigInteger.valueOf((long) newMigrating);
        return this;
    }
    
    public VmSummaryBuilder migrating(Integer newMigrating) {
        if (newMigrating == null) {
            migrating = null;
        }
        else {
            migrating = BigInteger.valueOf(newMigrating.longValue());
        }
        return this;
    }
    
    public VmSummaryBuilder migrating(long newMigrating) {
        migrating = BigInteger.valueOf(newMigrating);
        return this;
    }
    
    public VmSummaryBuilder migrating(Long newMigrating) {
        if (newMigrating == null) {
            migrating = null;
        }
        else {
            migrating = BigInteger.valueOf(newMigrating.longValue());
        }
        return this;
    }
    
    public VmSummaryBuilder migrating(BigInteger newMigrating) {
        migrating = newMigrating;
        return this;
    }
    
    
    public VmSummaryBuilder total(int newTotal) {
        total = BigInteger.valueOf((long) newTotal);
        return this;
    }
    
    public VmSummaryBuilder total(Integer newTotal) {
        if (newTotal == null) {
            total = null;
        }
        else {
            total = BigInteger.valueOf(newTotal.longValue());
        }
        return this;
    }
    
    public VmSummaryBuilder total(long newTotal) {
        total = BigInteger.valueOf(newTotal);
        return this;
    }
    
    public VmSummaryBuilder total(Long newTotal) {
        if (newTotal == null) {
            total = null;
        }
        else {
            total = BigInteger.valueOf(newTotal.longValue());
        }
        return this;
    }
    
    public VmSummaryBuilder total(BigInteger newTotal) {
        total = newTotal;
        return this;
    }
    
    
    public VmSummary build() {
        VmSummaryContainer container = new VmSummaryContainer();
        container.active(active);
        container.migrating(migrating);
        container.total(total);
        return container;
    }
}
