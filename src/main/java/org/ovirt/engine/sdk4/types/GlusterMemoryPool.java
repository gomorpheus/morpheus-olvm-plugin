/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

public interface GlusterMemoryPool extends Identified {
    BigInteger allocCount();
    Byte allocCountAsByte();
    Short allocCountAsShort();
    Integer allocCountAsInteger();
    Long allocCountAsLong();
    
    boolean allocCountPresent();
    
    BigInteger coldCount();
    Byte coldCountAsByte();
    Short coldCountAsShort();
    Integer coldCountAsInteger();
    Long coldCountAsLong();
    
    boolean coldCountPresent();
    
    BigInteger hotCount();
    Byte hotCountAsByte();
    Short hotCountAsShort();
    Integer hotCountAsInteger();
    Long hotCountAsLong();
    
    boolean hotCountPresent();
    
    BigInteger maxAlloc();
    Byte maxAllocAsByte();
    Short maxAllocAsShort();
    Integer maxAllocAsInteger();
    Long maxAllocAsLong();
    
    boolean maxAllocPresent();
    
    BigInteger maxStdalloc();
    Byte maxStdallocAsByte();
    Short maxStdallocAsShort();
    Integer maxStdallocAsInteger();
    Long maxStdallocAsLong();
    
    boolean maxStdallocPresent();
    
    BigInteger paddedSize();
    Byte paddedSizeAsByte();
    Short paddedSizeAsShort();
    Integer paddedSizeAsInteger();
    Long paddedSizeAsLong();
    
    boolean paddedSizePresent();
    
    BigInteger poolMisses();
    Byte poolMissesAsByte();
    Short poolMissesAsShort();
    Integer poolMissesAsInteger();
    Long poolMissesAsLong();
    
    boolean poolMissesPresent();
    
    String type();
    
    boolean typePresent();
    
}
