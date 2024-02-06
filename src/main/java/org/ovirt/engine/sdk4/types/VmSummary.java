/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * Type containing information related to virtual machines on a particular host.
 */
public interface VmSummary {
    BigInteger active();
    Byte activeAsByte();
    Short activeAsShort();
    Integer activeAsInteger();
    Long activeAsLong();
    
    boolean activePresent();
    
    BigInteger migrating();
    Byte migratingAsByte();
    Short migratingAsShort();
    Integer migratingAsInteger();
    Long migratingAsLong();
    
    boolean migratingPresent();
    
    BigInteger total();
    Byte totalAsByte();
    Short totalAsShort();
    Integer totalAsInteger();
    Long totalAsLong();
    
    boolean totalPresent();
    
}
