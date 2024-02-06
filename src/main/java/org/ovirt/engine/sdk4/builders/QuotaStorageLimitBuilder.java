/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.QuotaStorageLimitContainer;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.QuotaStorageLimit;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class QuotaStorageLimitBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private BigInteger limit;
    private String name;
    private Quota quota;
    private StorageDomain storageDomain;
    private BigDecimal usage;
    
    public QuotaStorageLimitBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public QuotaStorageLimitBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public QuotaStorageLimitBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public QuotaStorageLimitBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public QuotaStorageLimitBuilder limit(int newLimit) {
        limit = BigInteger.valueOf((long) newLimit);
        return this;
    }
    
    public QuotaStorageLimitBuilder limit(Integer newLimit) {
        if (newLimit == null) {
            limit = null;
        }
        else {
            limit = BigInteger.valueOf(newLimit.longValue());
        }
        return this;
    }
    
    public QuotaStorageLimitBuilder limit(long newLimit) {
        limit = BigInteger.valueOf(newLimit);
        return this;
    }
    
    public QuotaStorageLimitBuilder limit(Long newLimit) {
        if (newLimit == null) {
            limit = null;
        }
        else {
            limit = BigInteger.valueOf(newLimit.longValue());
        }
        return this;
    }
    
    public QuotaStorageLimitBuilder limit(BigInteger newLimit) {
        limit = newLimit;
        return this;
    }
    
    
    public QuotaStorageLimitBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public QuotaStorageLimitBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public QuotaStorageLimitBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public QuotaStorageLimitBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public QuotaStorageLimitBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public QuotaStorageLimitBuilder usage(float newUsage) {
        usage = BigDecimal.valueOf((double) newUsage);
        return this;
    }
    
    public QuotaStorageLimitBuilder usage(Float newUsage) {
        if (newUsage == null) {
            usage = null;
        }
        else {
            usage = BigDecimal.valueOf(newUsage.doubleValue());
        }
        return this;
    }
    
    public QuotaStorageLimitBuilder usage(double newUsage) {
        usage = BigDecimal.valueOf(newUsage);
        return this;
    }
    
    public QuotaStorageLimitBuilder usage(Double newUsage) {
        if (newUsage == null) {
            usage = null;
        }
        else {
            usage = BigDecimal.valueOf(newUsage.doubleValue());
        }
        return this;
    }
    
    public QuotaStorageLimitBuilder usage(BigDecimal newUsage) {
        usage = newUsage;
        return this;
    }
    
    
    public QuotaStorageLimit build() {
        QuotaStorageLimitContainer container = new QuotaStorageLimitContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.limit(limit);
        container.name(name);
        container.quota(quota);
        container.storageDomain(storageDomain);
        container.usage(usage);
        return container;
    }
}
