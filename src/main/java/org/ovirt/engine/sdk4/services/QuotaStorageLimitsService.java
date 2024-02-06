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
import org.ovirt.engine.sdk4.builders.QuotaStorageLimitBuilder;
import org.ovirt.engine.sdk4.types.QuotaStorageLimit;

/**
 * Manages the set of storage limits configured for a quota.
 */
public interface QuotaStorageLimitsService extends Service {
    /**
     * Adds a storage limit to a specified quota.
     * 
     * To create a 100GiB storage limit for all storage domains in a data center, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/quotas/456/quotastoragelimits
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <quota_storage_limit>
     *   <limit>100</limit>
     * </quota_storage_limit>
     * ----
     * 
     * To create a 50GiB storage limit for a storage domain with the ID `000`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/quotas/456/quotastoragelimits
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <quota_storage_limit>
     *   <limit>50</limit>
     *   <storage_domain id="000"/>
     * </quota_storage_limit>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest limit(QuotaStorageLimit limit);
        AddRequest limit(QuotaStorageLimitBuilder limit);
    }
    
    /**
     * Adds a storage limit to a specified quota.
     * 
     * To create a 100GiB storage limit for all storage domains in a data center, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/quotas/456/quotastoragelimits
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <quota_storage_limit>
     *   <limit>100</limit>
     * </quota_storage_limit>
     * ----
     * 
     * To create a 50GiB storage limit for a storage domain with the ID `000`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/quotas/456/quotastoragelimits
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <quota_storage_limit>
     *   <limit>50</limit>
     *   <storage_domain id="000"/>
     * </quota_storage_limit>
     * ----
     */
    public interface AddResponse extends Response {
        QuotaStorageLimit limit();
    }
    
    /**
     * Adds a storage limit to a specified quota.
     * 
     * To create a 100GiB storage limit for all storage domains in a data center, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/quotas/456/quotastoragelimits
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <quota_storage_limit>
     *   <limit>100</limit>
     * </quota_storage_limit>
     * ----
     * 
     * To create a 50GiB storage limit for a storage domain with the ID `000`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/quotas/456/quotastoragelimits
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <quota_storage_limit>
     *   <limit>50</limit>
     *   <storage_domain id="000"/>
     * </quota_storage_limit>
     * ----
     */
    AddRequest add();
    
    /**
     * Returns the list of storage limits configured for the quota.
     * 
     * The order of the returned list of storage limits is not guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of limits to return. If not specified, all the limits are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of limits to return. If not specified, all the limits are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of limits to return. If not specified, all the limits are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of storage limits configured for the quota.
     * 
     * The order of the returned list of storage limits is not guaranteed.
     */
    public interface ListResponse extends Response {
        List<QuotaStorageLimit> limits();
    }
    
    /**
     * Returns the list of storage limits configured for the quota.
     * 
     * The order of the returned list of storage limits is not guaranteed.
     */
    ListRequest list();
    
    QuotaStorageLimitService limitService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

