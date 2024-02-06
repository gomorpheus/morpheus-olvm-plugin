/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.TicketContainer;
import org.ovirt.engine.sdk4.types.Ticket;

public class TicketBuilder {
    private BigInteger expiry;
    private String value;
    
    public TicketBuilder expiry(int newExpiry) {
        expiry = BigInteger.valueOf((long) newExpiry);
        return this;
    }
    
    public TicketBuilder expiry(Integer newExpiry) {
        if (newExpiry == null) {
            expiry = null;
        }
        else {
            expiry = BigInteger.valueOf(newExpiry.longValue());
        }
        return this;
    }
    
    public TicketBuilder expiry(long newExpiry) {
        expiry = BigInteger.valueOf(newExpiry);
        return this;
    }
    
    public TicketBuilder expiry(Long newExpiry) {
        if (newExpiry == null) {
            expiry = null;
        }
        else {
            expiry = BigInteger.valueOf(newExpiry.longValue());
        }
        return this;
    }
    
    public TicketBuilder expiry(BigInteger newExpiry) {
        expiry = newExpiry;
        return this;
    }
    
    
    public TicketBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public Ticket build() {
        TicketContainer container = new TicketContainer();
        container.expiry(expiry);
        container.value(value);
        return container;
    }
}
