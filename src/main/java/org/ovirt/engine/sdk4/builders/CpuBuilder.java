/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.CpuContainer;
import org.ovirt.engine.sdk4.types.Architecture;
import org.ovirt.engine.sdk4.types.Core;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.CpuMode;
import org.ovirt.engine.sdk4.types.CpuTopology;
import org.ovirt.engine.sdk4.types.CpuTune;

public class CpuBuilder {
    private Architecture architecture;
    private List<Core> cores;
    private CpuTune cpuTune;
    private BigInteger level;
    private CpuMode mode;
    private String name;
    private BigDecimal speed;
    private CpuTopology topology;
    private String type;
    
    public CpuBuilder architecture(Architecture newArchitecture) {
        architecture = newArchitecture;
        return this;
    }
    
    
    public CpuBuilder cores(List<Core> newCores) {
        if (newCores != null) {
            if (cores == null) {
                cores = new ArrayList<>(newCores);
            }
            else {
                cores.addAll(newCores);
            }
        }
        return this;
    }
    
    public CpuBuilder cores(Core... newCores) {
        if (newCores != null) {
            if (cores == null) {
                cores = new ArrayList<>(newCores.length);
            }
            Collections.addAll(cores, newCores);
        }
        return this;
    }
    
    public CpuBuilder cores(CoreBuilder... newCores) {
        if (newCores != null) {
            if (cores == null) {
                cores = new ArrayList<>(newCores.length);
            }
            for (CoreBuilder builder : newCores) {
                cores.add(builder.build());
            }
        }
        return this;
    }
    
    
    public CpuBuilder cpuTune(CpuTune newCpuTune) {
        cpuTune = newCpuTune;
        return this;
    }
    
    public CpuBuilder cpuTune(CpuTuneBuilder newCpuTune) {
        if (newCpuTune == null) {
            cpuTune = null;
        }
        else {
            cpuTune = newCpuTune.build();
        }
        return this;
    }
    
    
    public CpuBuilder level(int newLevel) {
        level = BigInteger.valueOf((long) newLevel);
        return this;
    }
    
    public CpuBuilder level(Integer newLevel) {
        if (newLevel == null) {
            level = null;
        }
        else {
            level = BigInteger.valueOf(newLevel.longValue());
        }
        return this;
    }
    
    public CpuBuilder level(long newLevel) {
        level = BigInteger.valueOf(newLevel);
        return this;
    }
    
    public CpuBuilder level(Long newLevel) {
        if (newLevel == null) {
            level = null;
        }
        else {
            level = BigInteger.valueOf(newLevel.longValue());
        }
        return this;
    }
    
    public CpuBuilder level(BigInteger newLevel) {
        level = newLevel;
        return this;
    }
    
    
    public CpuBuilder mode(CpuMode newMode) {
        mode = newMode;
        return this;
    }
    
    
    public CpuBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public CpuBuilder speed(float newSpeed) {
        speed = BigDecimal.valueOf((double) newSpeed);
        return this;
    }
    
    public CpuBuilder speed(Float newSpeed) {
        if (newSpeed == null) {
            speed = null;
        }
        else {
            speed = BigDecimal.valueOf(newSpeed.doubleValue());
        }
        return this;
    }
    
    public CpuBuilder speed(double newSpeed) {
        speed = BigDecimal.valueOf(newSpeed);
        return this;
    }
    
    public CpuBuilder speed(Double newSpeed) {
        if (newSpeed == null) {
            speed = null;
        }
        else {
            speed = BigDecimal.valueOf(newSpeed.doubleValue());
        }
        return this;
    }
    
    public CpuBuilder speed(BigDecimal newSpeed) {
        speed = newSpeed;
        return this;
    }
    
    
    public CpuBuilder topology(CpuTopology newTopology) {
        topology = newTopology;
        return this;
    }
    
    public CpuBuilder topology(CpuTopologyBuilder newTopology) {
        if (newTopology == null) {
            topology = null;
        }
        else {
            topology = newTopology.build();
        }
        return this;
    }
    
    
    public CpuBuilder type(String newType) {
        type = newType;
        return this;
    }
    
    
    public Cpu build() {
        CpuContainer container = new CpuContainer();
        container.architecture(architecture);
        container.cores(cores);
        container.cpuTune(cpuTune);
        container.level(level);
        container.mode(mode);
        container.name(name);
        container.speed(speed);
        container.topology(topology);
        container.type(type);
        return container;
    }
}
