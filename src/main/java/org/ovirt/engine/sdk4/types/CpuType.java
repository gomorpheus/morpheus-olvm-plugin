/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

/**
 * Describes a supported CPU type.
 */
public interface CpuType {
    Architecture architecture();
    
    boolean architecturePresent();
    
    BigInteger level();
    Byte levelAsByte();
    Short levelAsShort();
    Integer levelAsInteger();
    Long levelAsLong();
    
    boolean levelPresent();
    
    String name();
    
    boolean namePresent();
    
}
