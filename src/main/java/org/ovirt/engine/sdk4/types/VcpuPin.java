/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

public interface VcpuPin {
    String cpuSet();
    
    boolean cpuSetPresent();
    
    BigInteger vcpu();
    Byte vcpuAsByte();
    Short vcpuAsShort();
    Integer vcpuAsInteger();
    Long vcpuAsLong();
    
    boolean vcpuPresent();
    
}
