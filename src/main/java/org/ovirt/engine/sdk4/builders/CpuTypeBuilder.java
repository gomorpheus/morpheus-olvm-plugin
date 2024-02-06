/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.CpuTypeContainer;
import org.ovirt.engine.sdk4.types.Architecture;
import org.ovirt.engine.sdk4.types.CpuType;

public class CpuTypeBuilder {
    private Architecture architecture;
    private BigInteger level;
    private String name;
    
    public CpuTypeBuilder architecture(Architecture newArchitecture) {
        architecture = newArchitecture;
        return this;
    }
    
    
    public CpuTypeBuilder level(int newLevel) {
        level = BigInteger.valueOf((long) newLevel);
        return this;
    }
    
    public CpuTypeBuilder level(Integer newLevel) {
        if (newLevel == null) {
            level = null;
        }
        else {
            level = BigInteger.valueOf(newLevel.longValue());
        }
        return this;
    }
    
    public CpuTypeBuilder level(long newLevel) {
        level = BigInteger.valueOf(newLevel);
        return this;
    }
    
    public CpuTypeBuilder level(Long newLevel) {
        if (newLevel == null) {
            level = null;
        }
        else {
            level = BigInteger.valueOf(newLevel.longValue());
        }
        return this;
    }
    
    public CpuTypeBuilder level(BigInteger newLevel) {
        level = newLevel;
        return this;
    }
    
    
    public CpuTypeBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public CpuType build() {
        CpuTypeContainer container = new CpuTypeContainer();
        container.architecture(architecture);
        container.level(level);
        container.name(name);
        return container;
    }
}
