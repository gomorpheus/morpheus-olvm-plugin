/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.GracePeriodContainer;
import org.ovirt.engine.sdk4.types.GracePeriod;

public class GracePeriodBuilder {
    private BigInteger expiry;
    
    public GracePeriodBuilder expiry(int newExpiry) {
        expiry = BigInteger.valueOf((long) newExpiry);
        return this;
    }
    
    public GracePeriodBuilder expiry(Integer newExpiry) {
        if (newExpiry == null) {
            expiry = null;
        }
        else {
            expiry = BigInteger.valueOf(newExpiry.longValue());
        }
        return this;
    }
    
    public GracePeriodBuilder expiry(long newExpiry) {
        expiry = BigInteger.valueOf(newExpiry);
        return this;
    }
    
    public GracePeriodBuilder expiry(Long newExpiry) {
        if (newExpiry == null) {
            expiry = null;
        }
        else {
            expiry = BigInteger.valueOf(newExpiry.longValue());
        }
        return this;
    }
    
    public GracePeriodBuilder expiry(BigInteger newExpiry) {
        expiry = newExpiry;
        return this;
    }
    
    
    public GracePeriod build() {
        GracePeriodContainer container = new GracePeriodContainer();
        container.expiry(expiry);
        return container;
    }
}
