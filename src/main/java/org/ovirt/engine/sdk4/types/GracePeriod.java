/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface GracePeriod {
    BigInteger expiry();
    Byte expiryAsByte();
    Short expiryAsShort();
    Integer expiryAsInteger();
    Long expiryAsLong();
    
    boolean expiryPresent();
    
}
