/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.VmSummary;

public class VmSummaryContainer extends Container implements VmSummary {
    private BigInteger active;
    private BigInteger migrating;
    private BigInteger total;
    
    public BigInteger active() {
        return active;
    }
    
    public Byte activeAsByte() {
        return asByte("VmSummary", "active", active);
    }
    
    public Short activeAsShort() {
        return asShort("VmSummary", "active", active);
    }
    
    public Integer activeAsInteger() {
        return asInteger("VmSummary", "active", active);
    }
    
    public Long activeAsLong() {
        return asLong("VmSummary", "active", active);
    }
    
    public void active(BigInteger newActive) {
        active = newActive;
    }
    
    public boolean activePresent() {
        return active != null;
    }
    
    public BigInteger migrating() {
        return migrating;
    }
    
    public Byte migratingAsByte() {
        return asByte("VmSummary", "migrating", migrating);
    }
    
    public Short migratingAsShort() {
        return asShort("VmSummary", "migrating", migrating);
    }
    
    public Integer migratingAsInteger() {
        return asInteger("VmSummary", "migrating", migrating);
    }
    
    public Long migratingAsLong() {
        return asLong("VmSummary", "migrating", migrating);
    }
    
    public void migrating(BigInteger newMigrating) {
        migrating = newMigrating;
    }
    
    public boolean migratingPresent() {
        return migrating != null;
    }
    
    public BigInteger total() {
        return total;
    }
    
    public Byte totalAsByte() {
        return asByte("VmSummary", "total", total);
    }
    
    public Short totalAsShort() {
        return asShort("VmSummary", "total", total);
    }
    
    public Integer totalAsInteger() {
        return asInteger("VmSummary", "total", total);
    }
    
    public Long totalAsLong() {
        return asLong("VmSummary", "total", total);
    }
    
    public void total(BigInteger newTotal) {
        total = newTotal;
    }
    
    public boolean totalPresent() {
        return total != null;
    }
    
}
