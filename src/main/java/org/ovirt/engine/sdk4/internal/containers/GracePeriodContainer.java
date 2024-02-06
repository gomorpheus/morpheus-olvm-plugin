/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.GracePeriod;

public class GracePeriodContainer extends Container implements GracePeriod {
    private BigInteger expiry;
    
    public BigInteger expiry() {
        return expiry;
    }
    
    public Byte expiryAsByte() {
        return asByte("GracePeriod", "expiry", expiry);
    }
    
    public Short expiryAsShort() {
        return asShort("GracePeriod", "expiry", expiry);
    }
    
    public Integer expiryAsInteger() {
        return asInteger("GracePeriod", "expiry", expiry);
    }
    
    public Long expiryAsLong() {
        return asLong("GracePeriod", "expiry", expiry);
    }
    
    public void expiry(BigInteger newExpiry) {
        expiry = newExpiry;
    }
    
    public boolean expiryPresent() {
        return expiry != null;
    }
    
}
