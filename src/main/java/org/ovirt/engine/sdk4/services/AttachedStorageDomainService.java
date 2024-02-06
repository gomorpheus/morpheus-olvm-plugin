/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.StorageDomain;

public interface AttachedStorageDomainService extends Service {
    /**
     * This operation activates an attached storage domain.
     * Once the storage domain is activated it is ready for use with the data center.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/storagedomains/456/activate
     * ----
     * 
     * The activate action does not take any action specific parameters,
     * so the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ActivateRequest extends Request<ActivateRequest, ActivateResponse> {
        /**
         * Indicates if the activation should be performed asynchronously.
         */
        ActivateRequest async(Boolean async);
    }
    
    /**
     * This operation activates an attached storage domain.
     * Once the storage domain is activated it is ready for use with the data center.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/storagedomains/456/activate
     * ----
     * 
     * The activate action does not take any action specific parameters,
     * so the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ActivateResponse extends Response {
    }
    
    /**
     * This operation activates an attached storage domain.
     * Once the storage domain is activated it is ready for use with the data center.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/storagedomains/456/activate
     * ----
     * 
     * The activate action does not take any action specific parameters,
     * so the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    ActivateRequest activate();
    
    /**
     * This operation deactivates an attached storage domain.
     * Once the storage domain is deactivated it will not be used with the data center.
     * For example, to deactivate storage domain `456`, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/storagedomains/456/deactivate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * If the `force` parameter is `true` then the operation will succeed, even if the OVF update which takes place
     * before the deactivation of the storage domain failed. If the `force` parameter is `false` and the OVF update failed,
     * the deactivation of the storage domain will also fail.
     */
    public interface DeactivateRequest extends Request<DeactivateRequest, DeactivateResponse> {
        /**
         * Indicates if the deactivation should be performed asynchronously.
         */
        DeactivateRequest async(Boolean async);
        /**
         * Indicates if the operation should succeed and the storage domain should be moved to a deactivated state, even if
         * the OVF update for the storage domain failed.
         * For example, to deactivate storage domain `456` using force flag, send the following request:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/datacenters/123/storagedomains/456/deactivate
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <action>
         *   <force>true</force>
         * <action>
         * ----
         * 
         * This parameter is optional, and the default value is `false`.
         */
        DeactivateRequest force(Boolean force);
    }
    
    /**
     * This operation deactivates an attached storage domain.
     * Once the storage domain is deactivated it will not be used with the data center.
     * For example, to deactivate storage domain `456`, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/storagedomains/456/deactivate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * If the `force` parameter is `true` then the operation will succeed, even if the OVF update which takes place
     * before the deactivation of the storage domain failed. If the `force` parameter is `false` and the OVF update failed,
     * the deactivation of the storage domain will also fail.
     */
    public interface DeactivateResponse extends Response {
    }
    
    /**
     * This operation deactivates an attached storage domain.
     * Once the storage domain is deactivated it will not be used with the data center.
     * For example, to deactivate storage domain `456`, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/storagedomains/456/deactivate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * If the `force` parameter is `true` then the operation will succeed, even if the OVF update which takes place
     * before the deactivation of the storage domain failed. If the `force` parameter is `false` and the OVF update failed,
     * the deactivation of the storage domain will also fail.
     */
    DeactivateRequest deactivate();
    
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        StorageDomain storageDomain();
    }
    
    GetRequest get();
    
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    public interface RemoveResponse extends Response {
    }
    
    RemoveRequest remove();
    
    AttachedStorageDomainDisksService disksService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

