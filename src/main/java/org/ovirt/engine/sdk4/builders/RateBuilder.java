/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.RateContainer;
import org.ovirt.engine.sdk4.types.Rate;

public class RateBuilder {
    private BigInteger bytes;
    private BigInteger period;
    
    public RateBuilder bytes(int newBytes) {
        bytes = BigInteger.valueOf((long) newBytes);
        return this;
    }
    
    public RateBuilder bytes(Integer newBytes) {
        if (newBytes == null) {
            bytes = null;
        }
        else {
            bytes = BigInteger.valueOf(newBytes.longValue());
        }
        return this;
    }
    
    public RateBuilder bytes(long newBytes) {
        bytes = BigInteger.valueOf(newBytes);
        return this;
    }
    
    public RateBuilder bytes(Long newBytes) {
        if (newBytes == null) {
            bytes = null;
        }
        else {
            bytes = BigInteger.valueOf(newBytes.longValue());
        }
        return this;
    }
    
    public RateBuilder bytes(BigInteger newBytes) {
        bytes = newBytes;
        return this;
    }
    
    
    public RateBuilder period(int newPeriod) {
        period = BigInteger.valueOf((long) newPeriod);
        return this;
    }
    
    public RateBuilder period(Integer newPeriod) {
        if (newPeriod == null) {
            period = null;
        }
        else {
            period = BigInteger.valueOf(newPeriod.longValue());
        }
        return this;
    }
    
    public RateBuilder period(long newPeriod) {
        period = BigInteger.valueOf(newPeriod);
        return this;
    }
    
    public RateBuilder period(Long newPeriod) {
        if (newPeriod == null) {
            period = null;
        }
        else {
            period = BigInteger.valueOf(newPeriod.longValue());
        }
        return this;
    }
    
    public RateBuilder period(BigInteger newPeriod) {
        period = newPeriod;
        return this;
    }
    
    
    public Rate build() {
        RateContainer container = new RateContainer();
        container.bytes(bytes);
        container.period(period);
        return container;
    }
}
