/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.VcpuPinContainer;
import org.ovirt.engine.sdk4.types.VcpuPin;

public class VcpuPinBuilder {
    private String cpuSet;
    private BigInteger vcpu;
    
    public VcpuPinBuilder cpuSet(String newCpuSet) {
        cpuSet = newCpuSet;
        return this;
    }
    
    
    public VcpuPinBuilder vcpu(int newVcpu) {
        vcpu = BigInteger.valueOf((long) newVcpu);
        return this;
    }
    
    public VcpuPinBuilder vcpu(Integer newVcpu) {
        if (newVcpu == null) {
            vcpu = null;
        }
        else {
            vcpu = BigInteger.valueOf(newVcpu.longValue());
        }
        return this;
    }
    
    public VcpuPinBuilder vcpu(long newVcpu) {
        vcpu = BigInteger.valueOf(newVcpu);
        return this;
    }
    
    public VcpuPinBuilder vcpu(Long newVcpu) {
        if (newVcpu == null) {
            vcpu = null;
        }
        else {
            vcpu = BigInteger.valueOf(newVcpu.longValue());
        }
        return this;
    }
    
    public VcpuPinBuilder vcpu(BigInteger newVcpu) {
        vcpu = newVcpu;
        return this;
    }
    
    
    public VcpuPin build() {
        VcpuPinContainer container = new VcpuPinContainer();
        container.cpuSet(cpuSet);
        container.vcpu(vcpu);
        return container;
    }
}
