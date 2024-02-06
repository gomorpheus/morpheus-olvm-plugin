/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Rate;

public class RateContainer extends Container implements Rate {
    private BigInteger bytes;
    private BigInteger period;
    
    public BigInteger bytes() {
        return bytes;
    }
    
    public Byte bytesAsByte() {
        return asByte("Rate", "bytes", bytes);
    }
    
    public Short bytesAsShort() {
        return asShort("Rate", "bytes", bytes);
    }
    
    public Integer bytesAsInteger() {
        return asInteger("Rate", "bytes", bytes);
    }
    
    public Long bytesAsLong() {
        return asLong("Rate", "bytes", bytes);
    }
    
    public void bytes(BigInteger newBytes) {
        bytes = newBytes;
    }
    
    public boolean bytesPresent() {
        return bytes != null;
    }
    
    public BigInteger period() {
        return period;
    }
    
    public Byte periodAsByte() {
        return asByte("Rate", "period", period);
    }
    
    public Short periodAsShort() {
        return asShort("Rate", "period", period);
    }
    
    public Integer periodAsInteger() {
        return asInteger("Rate", "period", period);
    }
    
    public Long periodAsLong() {
        return asLong("Rate", "period", period);
    }
    
    public void period(BigInteger newPeriod) {
        period = newPeriod;
    }
    
    public boolean periodPresent() {
        return period != null;
    }
    
}
