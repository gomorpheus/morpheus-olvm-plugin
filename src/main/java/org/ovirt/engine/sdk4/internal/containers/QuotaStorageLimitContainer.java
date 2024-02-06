/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.QuotaStorageLimit;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class QuotaStorageLimitContainer extends IdentifiedContainer implements QuotaStorageLimit {
    private BigInteger limit;
    private BigDecimal usage;
    private Quota quota;
    private StorageDomain storageDomain;
    
    public BigInteger limit() {
        return limit;
    }
    
    public Byte limitAsByte() {
        return asByte("QuotaStorageLimit", "limit", limit);
    }
    
    public Short limitAsShort() {
        return asShort("QuotaStorageLimit", "limit", limit);
    }
    
    public Integer limitAsInteger() {
        return asInteger("QuotaStorageLimit", "limit", limit);
    }
    
    public Long limitAsLong() {
        return asLong("QuotaStorageLimit", "limit", limit);
    }
    
    public void limit(BigInteger newLimit) {
        limit = newLimit;
    }
    
    public boolean limitPresent() {
        return limit != null;
    }
    
    public BigDecimal usage() {
        return usage;
    }
    
    public void usage(BigDecimal newUsage) {
        usage = newUsage;
    }
    
    public boolean usagePresent() {
        return usage != null;
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
    
    public StorageDomain storageDomain() {
        return storageDomain;
    }
    
    public void storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
    }
    
    public boolean storageDomainPresent() {
        return storageDomain != null;
    }
    
}
