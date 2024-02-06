/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface Cpu {
    Architecture architecture();
    
    boolean architecturePresent();
    
    List<Core> cores();
    
    boolean coresPresent();
    
    CpuTune cpuTune();
    
    boolean cpuTunePresent();
    
    BigInteger level();
    Byte levelAsByte();
    Short levelAsShort();
    Integer levelAsInteger();
    Long levelAsLong();
    
    boolean levelPresent();
    
    CpuMode mode();
    
    boolean modePresent();
    
    String name();
    
    boolean namePresent();
    
    BigDecimal speed();
    
    boolean speedPresent();
    
    CpuTopology topology();
    
    boolean topologyPresent();
    
    String type();
    
    boolean typePresent();
    
}
