/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * This type contains an item of the API summary. Each item contains the total and active number of some kind of
 * object.
 */
public interface ApiSummaryItem {
    BigInteger active();
    Byte activeAsByte();
    Short activeAsShort();
    Integer activeAsInteger();
    Long activeAsLong();
    
    boolean activePresent();
    
    BigInteger total();
    Byte totalAsByte();
    Short totalAsShort();
    Integer totalAsInteger();
    Long totalAsLong();
    
    boolean totalPresent();
    
}
