/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.ApiSummaryItem;

public class ApiSummaryItemContainer extends Container implements ApiSummaryItem {
    private BigInteger active;
    private BigInteger total;
    
    public BigInteger active() {
        return active;
    }
    
    public Byte activeAsByte() {
        return asByte("ApiSummaryItem", "active", active);
    }
    
    public Short activeAsShort() {
        return asShort("ApiSummaryItem", "active", active);
    }
    
    public Integer activeAsInteger() {
        return asInteger("ApiSummaryItem", "active", active);
    }
    
    public Long activeAsLong() {
        return asLong("ApiSummaryItem", "active", active);
    }
    
    public void active(BigInteger newActive) {
        active = newActive;
    }
    
    public boolean activePresent() {
        return active != null;
    }
    
    public BigInteger total() {
        return total;
    }
    
    public Byte totalAsByte() {
        return asByte("ApiSummaryItem", "total", total);
    }
    
    public Short totalAsShort() {
        return asShort("ApiSummaryItem", "total", total);
    }
    
    public Integer totalAsInteger() {
        return asInteger("ApiSummaryItem", "total", total);
    }
    
    public Long totalAsLong() {
        return asLong("ApiSummaryItem", "total", total);
    }
    
    public void total(BigInteger newTotal) {
        total = newTotal;
    }
    
    public boolean totalPresent() {
        return total != null;
    }
    
}
