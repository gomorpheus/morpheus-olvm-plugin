/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

/**
 * Type representing a ticket that allows virtual machine access.
 */
public interface Ticket {
    BigInteger expiry();
    Byte expiryAsByte();
    Short expiryAsShort();
    Integer expiryAsInteger();
    Long expiryAsLong();
    
    boolean expiryPresent();
    
    String value();
    
    boolean valuePresent();
    
}
