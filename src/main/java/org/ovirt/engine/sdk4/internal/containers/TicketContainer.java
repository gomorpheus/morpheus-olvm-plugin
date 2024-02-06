/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Ticket;

public class TicketContainer extends Container implements Ticket {
    private BigInteger expiry;
    private String value;
    
    public BigInteger expiry() {
        return expiry;
    }
    
    public Byte expiryAsByte() {
        return asByte("Ticket", "expiry", expiry);
    }
    
    public Short expiryAsShort() {
        return asShort("Ticket", "expiry", expiry);
    }
    
    public Integer expiryAsInteger() {
        return asInteger("Ticket", "expiry", expiry);
    }
    
    public Long expiryAsLong() {
        return asLong("Ticket", "expiry", expiry);
    }
    
    public void expiry(BigInteger newExpiry) {
        expiry = newExpiry;
    }
    
    public boolean expiryPresent() {
        return expiry != null;
    }
    
    public String value() {
        return value;
    }
    
    public void value(String newValue) {
        value = newValue;
    }
    
    public boolean valuePresent() {
        return value != null;
    }
    
}
