/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface QuotaStorageLimit extends Identified {
    BigInteger limit();
    Byte limitAsByte();
    Short limitAsShort();
    Integer limitAsInteger();
    Long limitAsLong();
    
    boolean limitPresent();
    
    BigDecimal usage();
    
    boolean usagePresent();
    
    Quota quota();
    
    boolean quotaPresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
}
