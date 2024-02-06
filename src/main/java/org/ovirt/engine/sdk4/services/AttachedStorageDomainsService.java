/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.types.StorageDomain;

/**
 * Manages the storage domains attached to a data center.
 */
public interface AttachedStorageDomainsService extends Service {
    /**
     * Attaches an existing storage domain to the data center.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain to attach to the data center.
         */
        AddRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Attaches an existing storage domain to the data center.
     */
    public interface AddResponse extends Response {
        /**
         * The storage domain to attach to the data center.
         */
        StorageDomain storageDomain();
    }
    
    /**
     * Attaches an existing storage domain to the data center.
     */
    AddRequest add();
    
    /**
     * Returns the list of storage domains attached to the data center.
     * 
     * The order of the returned storage domains isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of storage domains to return. If not specified all the storage domains are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of storage domains to return. If not specified all the storage domains are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of storage domains to return. If not specified all the storage domains are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of storage domains attached to the data center.
     * 
     * The order of the returned storage domains isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * A list of storage domains that are attached to the data center.
         */
        List<StorageDomain> storageDomains();
    }
    
    /**
     * Returns the list of storage domains attached to the data center.
     * 
     * The order of the returned storage domains isn't guaranteed.
     */
    ListRequest list();
    
    AttachedStorageDomainService storageDomainService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

