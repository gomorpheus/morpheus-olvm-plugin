/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

public interface Version extends Identified {
    BigInteger build();
    Byte buildAsByte();
    Short buildAsShort();
    Integer buildAsInteger();
    Long buildAsLong();
    
    boolean buildPresent();
    
    String fullVersion();
    
    boolean fullVersionPresent();
    
    BigInteger major();
    Byte majorAsByte();
    Short majorAsShort();
    Integer majorAsInteger();
    Long majorAsLong();
    
    boolean majorPresent();
    
    BigInteger minor();
    Byte minorAsByte();
    Short minorAsShort();
    Integer minorAsInteger();
    Long minorAsLong();
    
    boolean minorPresent();
    
    BigInteger revision();
    Byte revisionAsByte();
    Short revisionAsShort();
    Integer revisionAsInteger();
    Long revisionAsLong();
    
    boolean revisionPresent();
    
}
