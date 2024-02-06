/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Represents a lease residing on a storage domain.
 * 
 * A lease is a http://www.ovirt.org/develop/developer-guide/vdsm/sanlock[Sanlock] resource residing on a special
 * volume on the storage domain, this Sanlock resource is used to provide storage base locking.
 */
public interface StorageDomainLease {
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
}
