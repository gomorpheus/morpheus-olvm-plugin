/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface QuotaClusterLimit extends Identified {
    BigDecimal memoryLimit();
    
    boolean memoryLimitPresent();
    
    BigDecimal memoryUsage();
    
    boolean memoryUsagePresent();
    
    BigInteger vcpuLimit();
    Byte vcpuLimitAsByte();
    Short vcpuLimitAsShort();
    Integer vcpuLimitAsInteger();
    Long vcpuLimitAsLong();
    
    boolean vcpuLimitPresent();
    
    BigInteger vcpuUsage();
    Byte vcpuUsageAsByte();
    Short vcpuUsageAsShort();
    Integer vcpuUsageAsInteger();
    Long vcpuUsageAsLong();
    
    boolean vcpuUsagePresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    Quota quota();
    
    boolean quotaPresent();
    
}
