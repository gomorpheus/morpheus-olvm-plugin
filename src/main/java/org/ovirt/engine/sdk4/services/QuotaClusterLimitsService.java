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
import org.ovirt.engine.sdk4.builders.QuotaClusterLimitBuilder;
import org.ovirt.engine.sdk4.types.QuotaClusterLimit;

/**
 * Manages the set of quota limits configured for a cluster.
 */
public interface QuotaClusterLimitsService extends Service {
    /**
     * Add a cluster limit to a specified Quota.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest limit(QuotaClusterLimit limit);
        AddRequest limit(QuotaClusterLimitBuilder limit);
    }
    
    /**
     * Add a cluster limit to a specified Quota.
     */
    public interface AddResponse extends Response {
        QuotaClusterLimit limit();
    }
    
    /**
     * Add a cluster limit to a specified Quota.
     */
    AddRequest add();
    
    /**
     * Returns the set of quota limits configured for the cluster.
     * 
     * The returned list of quota limits isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of limits to return. If not specified all the limits are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of limits to return. If not specified all the limits are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of limits to return. If not specified all the limits are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the set of quota limits configured for the cluster.
     * 
     * The returned list of quota limits isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<QuotaClusterLimit> limits();
    }
    
    /**
     * Returns the set of quota limits configured for the cluster.
     * 
     * The returned list of quota limits isn't guaranteed.
     */
    ListRequest list();
    
    QuotaClusterLimitService limitService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

