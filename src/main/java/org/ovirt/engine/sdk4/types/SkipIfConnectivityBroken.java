/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface SkipIfConnectivityBroken {
    boolean enabled();
    
    boolean enabledPresent();
    
    BigInteger threshold();
    Byte thresholdAsByte();
    Short thresholdAsShort();
    Integer thresholdAsInteger();
    Long thresholdAsLong();
    
    boolean thresholdPresent();
    
}
