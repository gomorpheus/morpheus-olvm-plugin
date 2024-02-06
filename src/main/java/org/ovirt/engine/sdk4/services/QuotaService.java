/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.QuotaBuilder;
import org.ovirt.engine.sdk4.types.Quota;

public interface QuotaService extends Service {
    /**
     * Retrieves a quota.
     * 
     * An example of retrieving a quota:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters/123/quotas/456
     * ----
     * 
     * [source,xml]
     * ----
     * <quota id="456">
     *   <name>myquota</name>
     *   <description>My new quota for virtual machines</description>
     *   <cluster_hard_limit_pct>20</cluster_hard_limit_pct>
     *   <cluster_soft_limit_pct>80</cluster_soft_limit_pct>
     *   <storage_hard_limit_pct>20</storage_hard_limit_pct>
     *   <storage_soft_limit_pct>80</storage_soft_limit_pct>
     * </quota>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves a quota.
     * 
     * An example of retrieving a quota:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters/123/quotas/456
     * ----
     * 
     * [source,xml]
     * ----
     * <quota id="456">
     *   <name>myquota</name>
     *   <description>My new quota for virtual machines</description>
     *   <cluster_hard_limit_pct>20</cluster_hard_limit_pct>
     *   <cluster_soft_limit_pct>80</cluster_soft_limit_pct>
     *   <storage_hard_limit_pct>20</storage_hard_limit_pct>
     *   <storage_soft_limit_pct>80</storage_soft_limit_pct>
     * </quota>
     * ----
     */
    public interface GetResponse extends Response {
        Quota quota();
    }
    
    /**
     * Retrieves a quota.
     * 
     * An example of retrieving a quota:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters/123/quotas/456
     * ----
     * 
     * [source,xml]
     * ----
     * <quota id="456">
     *   <name>myquota</name>
     *   <description>My new quota for virtual machines</description>
     *   <cluster_hard_limit_pct>20</cluster_hard_limit_pct>
     *   <cluster_soft_limit_pct>80</cluster_soft_limit_pct>
     *   <storage_hard_limit_pct>20</storage_hard_limit_pct>
     *   <storage_soft_limit_pct>80</storage_soft_limit_pct>
     * </quota>
     * ----
     */
    GetRequest get();
    
    /**
     * Delete a quota.
     * 
     * An example of deleting a quota:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123-456/quotas/654-321
     * -0472718ab224 HTTP/1.1
     * Accept: application/xml
     * Content-type: application/xml
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Delete a quota.
     * 
     * An example of deleting a quota:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123-456/quotas/654-321
     * -0472718ab224 HTTP/1.1
     * Accept: application/xml
     * Content-type: application/xml
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Delete a quota.
     * 
     * An example of deleting a quota:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123-456/quotas/654-321
     * -0472718ab224 HTTP/1.1
     * Accept: application/xml
     * Content-type: application/xml
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Updates a quota.
     * 
     * An example of updating a quota:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/quotas/456
     * ----
     * 
     * [source,xml]
     * ----
     * <quota>
     *   <cluster_hard_limit_pct>30</cluster_hard_limit_pct>
     *   <cluster_soft_limit_pct>70</cluster_soft_limit_pct>
     *   <storage_hard_limit_pct>20</storage_hard_limit_pct>
     *   <storage_soft_limit_pct>80</storage_soft_limit_pct>
     * </quota>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest quota(Quota quota);
        UpdateRequest quota(QuotaBuilder quota);
    }
    
    /**
     * Updates a quota.
     * 
     * An example of updating a quota:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/quotas/456
     * ----
     * 
     * [source,xml]
     * ----
     * <quota>
     *   <cluster_hard_limit_pct>30</cluster_hard_limit_pct>
     *   <cluster_soft_limit_pct>70</cluster_soft_limit_pct>
     *   <storage_hard_limit_pct>20</storage_hard_limit_pct>
     *   <storage_soft_limit_pct>80</storage_soft_limit_pct>
     * </quota>
     * ----
     */
    public interface UpdateResponse extends Response {
        Quota quota();
    }
    
    /**
     * Updates a quota.
     * 
     * An example of updating a quota:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/quotas/456
     * ----
     * 
     * [source,xml]
     * ----
     * <quota>
     *   <cluster_hard_limit_pct>30</cluster_hard_limit_pct>
     *   <cluster_soft_limit_pct>70</cluster_soft_limit_pct>
     *   <storage_hard_limit_pct>20</storage_hard_limit_pct>
     *   <storage_soft_limit_pct>80</storage_soft_limit_pct>
     * </quota>
     * ----
     */
    UpdateRequest update();
    
    AssignedPermissionsService permissionsService();
    QuotaClusterLimitsService quotaClusterLimitsService();
    QuotaStorageLimitsService quotaStorageLimitsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

