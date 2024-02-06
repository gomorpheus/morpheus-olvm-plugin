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
import org.ovirt.engine.sdk4.builders.QuotaBuilder;
import org.ovirt.engine.sdk4.types.Quota;

/**
 * Manages the set of quotas configured for a data center.
 */
public interface QuotasService extends Service {
    /**
     * Creates a new quota.
     * 
     * An example of creating a new quota:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/quotas
     * ----
     * 
     * [source,xml]
     * ----
     * <quota>
     *   <name>myquota</name>
     *   <description>My new quota for virtual machines</description>
     * </quota>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest quota(Quota quota);
        AddRequest quota(QuotaBuilder quota);
    }
    
    /**
     * Creates a new quota.
     * 
     * An example of creating a new quota:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/quotas
     * ----
     * 
     * [source,xml]
     * ----
     * <quota>
     *   <name>myquota</name>
     *   <description>My new quota for virtual machines</description>
     * </quota>
     * ----
     */
    public interface AddResponse extends Response {
        Quota quota();
    }
    
    /**
     * Creates a new quota.
     * 
     * An example of creating a new quota:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/quotas
     * ----
     * 
     * [source,xml]
     * ----
     * <quota>
     *   <name>myquota</name>
     *   <description>My new quota for virtual machines</description>
     * </quota>
     * ----
     */
    AddRequest add();
    
    /**
     * Lists quotas of a data center.
     * 
     * The order of the returned list of quotas isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of quota descriptors to return. If not specified all the descriptors are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of quota descriptors to return. If not specified all the descriptors are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of quota descriptors to return. If not specified all the descriptors are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Lists quotas of a data center.
     * 
     * The order of the returned list of quotas isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Quota> quotas();
    }
    
    /**
     * Lists quotas of a data center.
     * 
     * The order of the returned list of quotas isn't guaranteed.
     */
    ListRequest list();
    
    QuotaService quotaService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

