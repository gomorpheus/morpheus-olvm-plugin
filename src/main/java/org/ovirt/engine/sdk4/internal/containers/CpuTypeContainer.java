/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Architecture;
import org.ovirt.engine.sdk4.types.CpuType;

public class CpuTypeContainer extends Container implements CpuType {
    private Architecture architecture;
    private BigInteger level;
    private String name;
    
    public Architecture architecture() {
        return architecture;
    }
    
    public void architecture(Architecture newArchitecture) {
        architecture = newArchitecture;
    }
    
    public boolean architecturePresent() {
        return architecture != null;
    }
    
    public BigInteger level() {
        return level;
    }
    
    public Byte levelAsByte() {
        return asByte("CpuType", "level", level);
    }
    
    public Short levelAsShort() {
        return asShort("CpuType", "level", level);
    }
    
    public Integer levelAsInteger() {
        return asInteger("CpuType", "level", level);
    }
    
    public Long levelAsLong() {
        return asLong("CpuType", "level", level);
    }
    
    public void level(BigInteger newLevel) {
        level = newLevel;
    }
    
    public boolean levelPresent() {
        return level != null;
    }
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
}
