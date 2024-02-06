/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Architecture;
import org.ovirt.engine.sdk4.types.Core;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.CpuMode;
import org.ovirt.engine.sdk4.types.CpuTopology;
import org.ovirt.engine.sdk4.types.CpuTune;

public class CpuContainer extends Container implements Cpu {
    private Architecture architecture;
    private List<Core> cores;
    private CpuTune cpuTune;
    private BigInteger level;
    private CpuMode mode;
    private String name;
    private BigDecimal speed;
    private CpuTopology topology;
    private String type;
    
    public Architecture architecture() {
        return architecture;
    }
    
    public void architecture(Architecture newArchitecture) {
        architecture = newArchitecture;
    }
    
    public boolean architecturePresent() {
        return architecture != null;
    }
    
    public List<Core> cores() {
        return makeUnmodifiableList(cores);
    }
    
    public void cores(List<Core> newCores) {
        cores = makeArrayList(newCores);
    }
    
    public boolean coresPresent() {
        return cores != null && !cores.isEmpty();
    }
    
    public CpuTune cpuTune() {
        return cpuTune;
    }
    
    public void cpuTune(CpuTune newCpuTune) {
        cpuTune = newCpuTune;
    }
    
    public boolean cpuTunePresent() {
        return cpuTune != null;
    }
    
    public BigInteger level() {
        return level;
    }
    
    public Byte levelAsByte() {
        return asByte("Cpu", "level", level);
    }
    
    public Short levelAsShort() {
        return asShort("Cpu", "level", level);
    }
    
    public Integer levelAsInteger() {
        return asInteger("Cpu", "level", level);
    }
    
    public Long levelAsLong() {
        return asLong("Cpu", "level", level);
    }
    
    public void level(BigInteger newLevel) {
        level = newLevel;
    }
    
    public boolean levelPresent() {
        return level != null;
    }
    
    public CpuMode mode() {
        return mode;
    }
    
    public void mode(CpuMode newMode) {
        mode = newMode;
    }
    
    public boolean modePresent() {
        return mode != null;
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
    
    public BigDecimal speed() {
        return speed;
    }
    
    public void speed(BigDecimal newSpeed) {
        speed = newSpeed;
    }
    
    public boolean speedPresent() {
        return speed != null;
    }
    
    public CpuTopology topology() {
        return topology;
    }
    
    public void topology(CpuTopology newTopology) {
        topology = newTopology;
    }
    
    public boolean topologyPresent() {
        return topology != null;
    }
    
    public String type() {
        return type;
    }
    
    public void type(String newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
}
