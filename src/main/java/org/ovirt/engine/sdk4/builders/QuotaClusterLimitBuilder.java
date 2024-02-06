/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.QuotaClusterLimitContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.QuotaClusterLimit;

public class QuotaClusterLimitBuilder {
    private Cluster cluster;
    private String comment;
    private String description;
    private String href;
    private String id;
    private BigDecimal memoryLimit;
    private BigDecimal memoryUsage;
    private String name;
    private Quota quota;
    private BigInteger vcpuLimit;
    private BigInteger vcpuUsage;
    
    public QuotaClusterLimitBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public QuotaClusterLimitBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public QuotaClusterLimitBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public QuotaClusterLimitBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public QuotaClusterLimitBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public QuotaClusterLimitBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public QuotaClusterLimitBuilder memoryLimit(float newMemoryLimit) {
        memoryLimit = BigDecimal.valueOf((double) newMemoryLimit);
        return this;
    }
    
    public QuotaClusterLimitBuilder memoryLimit(Float newMemoryLimit) {
        if (newMemoryLimit == null) {
            memoryLimit = null;
        }
        else {
            memoryLimit = BigDecimal.valueOf(newMemoryLimit.doubleValue());
        }
        return this;
    }
    
    public QuotaClusterLimitBuilder memoryLimit(double newMemoryLimit) {
        memoryLimit = BigDecimal.valueOf(newMemoryLimit);
        return this;
    }
    
    public QuotaClusterLimitBuilder memoryLimit(Double newMemoryLimit) {
        if (newMemoryLimit == null) {
            memoryLimit = null;
        }
        else {
            memoryLimit = BigDecimal.valueOf(newMemoryLimit.doubleValue());
        }
        return this;
    }
    
    public QuotaClusterLimitBuilder memoryLimit(BigDecimal newMemoryLimit) {
        memoryLimit = newMemoryLimit;
        return this;
    }
    
    
    public QuotaClusterLimitBuilder memoryUsage(float newMemoryUsage) {
        memoryUsage = BigDecimal.valueOf((double) newMemoryUsage);
        return this;
    }
    
    public QuotaClusterLimitBuilder memoryUsage(Float newMemoryUsage) {
        if (newMemoryUsage == null) {
            memoryUsage = null;
        }
        else {
            memoryUsage = BigDecimal.valueOf(newMemoryUsage.doubleValue());
        }
        return this;
    }
    
    public QuotaClusterLimitBuilder memoryUsage(double newMemoryUsage) {
        memoryUsage = BigDecimal.valueOf(newMemoryUsage);
        return this;
    }
    
    public QuotaClusterLimitBuilder memoryUsage(Double newMemoryUsage) {
        if (newMemoryUsage == null) {
            memoryUsage = null;
        }
        else {
            memoryUsage = BigDecimal.valueOf(newMemoryUsage.doubleValue());
        }
        return this;
    }
    
    public QuotaClusterLimitBuilder memoryUsage(BigDecimal newMemoryUsage) {
        memoryUsage = newMemoryUsage;
        return this;
    }
    
    
    public QuotaClusterLimitBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public QuotaClusterLimitBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public QuotaClusterLimitBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public QuotaClusterLimitBuilder vcpuLimit(int newVcpuLimit) {
        vcpuLimit = BigInteger.valueOf((long) newVcpuLimit);
        return this;
    }
    
    public QuotaClusterLimitBuilder vcpuLimit(Integer newVcpuLimit) {
        if (newVcpuLimit == null) {
            vcpuLimit = null;
        }
        else {
            vcpuLimit = BigInteger.valueOf(newVcpuLimit.longValue());
        }
        return this;
    }
    
    public QuotaClusterLimitBuilder vcpuLimit(long newVcpuLimit) {
        vcpuLimit = BigInteger.valueOf(newVcpuLimit);
        return this;
    }
    
    public QuotaClusterLimitBuilder vcpuLimit(Long newVcpuLimit) {
        if (newVcpuLimit == null) {
            vcpuLimit = null;
        }
        else {
            vcpuLimit = BigInteger.valueOf(newVcpuLimit.longValue());
        }
        return this;
    }
    
    public QuotaClusterLimitBuilder vcpuLimit(BigInteger newVcpuLimit) {
        vcpuLimit = newVcpuLimit;
        return this;
    }
    
    
    public QuotaClusterLimitBuilder vcpuUsage(int newVcpuUsage) {
        vcpuUsage = BigInteger.valueOf((long) newVcpuUsage);
        return this;
    }
    
    public QuotaClusterLimitBuilder vcpuUsage(Integer newVcpuUsage) {
        if (newVcpuUsage == null) {
            vcpuUsage = null;
        }
        else {
            vcpuUsage = BigInteger.valueOf(newVcpuUsage.longValue());
        }
        return this;
    }
    
    public QuotaClusterLimitBuilder vcpuUsage(long newVcpuUsage) {
        vcpuUsage = BigInteger.valueOf(newVcpuUsage);
        return this;
    }
    
    public QuotaClusterLimitBuilder vcpuUsage(Long newVcpuUsage) {
        if (newVcpuUsage == null) {
            vcpuUsage = null;
        }
        else {
            vcpuUsage = BigInteger.valueOf(newVcpuUsage.longValue());
        }
        return this;
    }
    
    public QuotaClusterLimitBuilder vcpuUsage(BigInteger newVcpuUsage) {
        vcpuUsage = newVcpuUsage;
        return this;
    }
    
    
    public QuotaClusterLimit build() {
        QuotaClusterLimitContainer container = new QuotaClusterLimitContainer();
        container.cluster(cluster);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.memoryLimit(memoryLimit);
        container.memoryUsage(memoryUsage);
        container.name(name);
        container.quota(quota);
        container.vcpuLimit(vcpuLimit);
        container.vcpuUsage(vcpuUsage);
        return container;
    }
}
