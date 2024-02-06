/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.ApiSummaryItemContainer;
import org.ovirt.engine.sdk4.types.ApiSummaryItem;

public class ApiSummaryItemBuilder {
    private BigInteger active;
    private BigInteger total;
    
    public ApiSummaryItemBuilder active(int newActive) {
        active = BigInteger.valueOf((long) newActive);
        return this;
    }
    
    public ApiSummaryItemBuilder active(Integer newActive) {
        if (newActive == null) {
            active = null;
        }
        else {
            active = BigInteger.valueOf(newActive.longValue());
        }
        return this;
    }
    
    public ApiSummaryItemBuilder active(long newActive) {
        active = BigInteger.valueOf(newActive);
        return this;
    }
    
    public ApiSummaryItemBuilder active(Long newActive) {
        if (newActive == null) {
            active = null;
        }
        else {
            active = BigInteger.valueOf(newActive.longValue());
        }
        return this;
    }
    
    public ApiSummaryItemBuilder active(BigInteger newActive) {
        active = newActive;
        return this;
    }
    
    
    public ApiSummaryItemBuilder total(int newTotal) {
        total = BigInteger.valueOf((long) newTotal);
        return this;
    }
    
    public ApiSummaryItemBuilder total(Integer newTotal) {
        if (newTotal == null) {
            total = null;
        }
        else {
            total = BigInteger.valueOf(newTotal.longValue());
        }
        return this;
    }
    
    public ApiSummaryItemBuilder total(long newTotal) {
        total = BigInteger.valueOf(newTotal);
        return this;
    }
    
    public ApiSummaryItemBuilder total(Long newTotal) {
        if (newTotal == null) {
            total = null;
        }
        else {
            total = BigInteger.valueOf(newTotal.longValue());
        }
        return this;
    }
    
    public ApiSummaryItemBuilder total(BigInteger newTotal) {
        total = newTotal;
        return this;
    }
    
    
    public ApiSummaryItem build() {
        ApiSummaryItemContainer container = new ApiSummaryItemContainer();
        container.active(active);
        container.total(total);
        return container;
    }
}
