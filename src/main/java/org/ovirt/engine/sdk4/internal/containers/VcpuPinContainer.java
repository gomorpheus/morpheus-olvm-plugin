/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.VcpuPin;

public class VcpuPinContainer extends Container implements VcpuPin {
    private String cpuSet;
    private BigInteger vcpu;
    
    public String cpuSet() {
        return cpuSet;
    }
    
    public void cpuSet(String newCpuSet) {
        cpuSet = newCpuSet;
    }
    
    public boolean cpuSetPresent() {
        return cpuSet != null;
    }
    
    public BigInteger vcpu() {
        return vcpu;
    }
    
    public Byte vcpuAsByte() {
        return asByte("VcpuPin", "vcpu", vcpu);
    }
    
    public Short vcpuAsShort() {
        return asShort("VcpuPin", "vcpu", vcpu);
    }
    
    public Integer vcpuAsInteger() {
        return asInteger("VcpuPin", "vcpu", vcpu);
    }
    
    public Long vcpuAsLong() {
        return asLong("VcpuPin", "vcpu", vcpu);
    }
    
    public void vcpu(BigInteger newVcpu) {
        vcpu = newVcpu;
    }
    
    public boolean vcpuPresent() {
        return vcpu != null;
    }
    
}
