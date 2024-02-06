/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.StorageDomainLeaseContainer;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageDomainLease;

public class StorageDomainLeaseBuilder {
    private StorageDomain storageDomain;
    
    public StorageDomainLeaseBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public StorageDomainLeaseBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public StorageDomainLease build() {
        StorageDomainLeaseContainer container = new StorageDomainLeaseContainer();
        container.storageDomain(storageDomain);
        return container;
    }
}
