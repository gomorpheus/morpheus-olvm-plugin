/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.QuotaClusterLimit;

public class QuotaClusterLimitContainer extends IdentifiedContainer implements QuotaClusterLimit {
    private BigDecimal memoryLimit;
    private BigDecimal memoryUsage;
    private BigInteger vcpuLimit;
    private BigInteger vcpuUsage;
    private Cluster cluster;
    private Quota quota;
    
    public BigDecimal memoryLimit() {
        return memoryLimit;
    }
    
    public void memoryLimit(BigDecimal newMemoryLimit) {
        memoryLimit = newMemoryLimit;
    }
    
    public boolean memoryLimitPresent() {
        return memoryLimit != null;
    }
    
    public BigDecimal memoryUsage() {
        return memoryUsage;
    }
    
    public void memoryUsage(BigDecimal newMemoryUsage) {
        memoryUsage = newMemoryUsage;
    }
    
    public boolean memoryUsagePresent() {
        return memoryUsage != null;
    }
    
    public BigInteger vcpuLimit() {
        return vcpuLimit;
    }
    
    public Byte vcpuLimitAsByte() {
        return asByte("QuotaClusterLimit", "vcpuLimit", vcpuLimit);
    }
    
    public Short vcpuLimitAsShort() {
        return asShort("QuotaClusterLimit", "vcpuLimit", vcpuLimit);
    }
    
    public Integer vcpuLimitAsInteger() {
        return asInteger("QuotaClusterLimit", "vcpuLimit", vcpuLimit);
    }
    
    public Long vcpuLimitAsLong() {
        return asLong("QuotaClusterLimit", "vcpuLimit", vcpuLimit);
    }
    
    public void vcpuLimit(BigInteger newVcpuLimit) {
        vcpuLimit = newVcpuLimit;
    }
    
    public boolean vcpuLimitPresent() {
        return vcpuLimit != null;
    }
    
    public BigInteger vcpuUsage() {
        return vcpuUsage;
    }
    
    public Byte vcpuUsageAsByte() {
        return asByte("QuotaClusterLimit", "vcpuUsage", vcpuUsage);
    }
    
    public Short vcpuUsageAsShort() {
        return asShort("QuotaClusterLimit", "vcpuUsage", vcpuUsage);
    }
    
    public Integer vcpuUsageAsInteger() {
        return asInteger("QuotaClusterLimit", "vcpuUsage", vcpuUsage);
    }
    
    public Long vcpuUsageAsLong() {
        return asLong("QuotaClusterLimit", "vcpuUsage", vcpuUsage);
    }
    
    public void vcpuUsage(BigInteger newVcpuUsage) {
        vcpuUsage = newVcpuUsage;
    }
    
    public boolean vcpuUsagePresent() {
        return vcpuUsage != null;
    }
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
    }
    
    public Quota quota() {
        return quota;
    }
    
    public void quota(Quota newQuota) {
        quota = newQuota;
    }
    
    public boolean quotaPresent() {
        return quota != null;
    }
    
}
