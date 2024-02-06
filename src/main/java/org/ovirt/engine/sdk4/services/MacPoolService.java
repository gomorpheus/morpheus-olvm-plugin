/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.MacPoolBuilder;
import org.ovirt.engine.sdk4.types.MacPool;

public interface MacPoolService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        MacPool pool();
    }
    
    GetRequest get();
    
    /**
     * Removes a MAC address pool.
     * 
     * For example, to remove the MAC address pool having id `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/macpools/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes a MAC address pool.
     * 
     * For example, to remove the MAC address pool having id `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/macpools/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a MAC address pool.
     * 
     * For example, to remove the MAC address pool having id `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/macpools/123
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Updates a MAC address pool.
     * 
     * The `name`, `description`, `allow_duplicates`, and `ranges` attributes can be updated.
     * 
     * For example, to update the MAC address pool of id `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/macpools/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <mac_pool>
     *   <name>UpdatedMACPool</name>
     *   <description>An updated MAC address pool</description>
     *   <allow_duplicates>false</allow_duplicates>
     *   <ranges>
     *     <range>
     *       <from>00:1A:4A:16:01:51</from>
     *       <to>00:1A:4A:16:01:e6</to>
     *     </range>
     *     <range>
     *       <from>02:1A:4A:01:00:00</from>
     *       <to>02:1A:4A:FF:FF:FF</to>
     *     </range>
     *   </ranges>
     * </mac_pool>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest pool(MacPool pool);
        UpdateRequest pool(MacPoolBuilder pool);
    }
    
    /**
     * Updates a MAC address pool.
     * 
     * The `name`, `description`, `allow_duplicates`, and `ranges` attributes can be updated.
     * 
     * For example, to update the MAC address pool of id `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/macpools/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <mac_pool>
     *   <name>UpdatedMACPool</name>
     *   <description>An updated MAC address pool</description>
     *   <allow_duplicates>false</allow_duplicates>
     *   <ranges>
     *     <range>
     *       <from>00:1A:4A:16:01:51</from>
     *       <to>00:1A:4A:16:01:e6</to>
     *     </range>
     *     <range>
     *       <from>02:1A:4A:01:00:00</from>
     *       <to>02:1A:4A:FF:FF:FF</to>
     *     </range>
     *   </ranges>
     * </mac_pool>
     * ----
     */
    public interface UpdateResponse extends Response {
        MacPool pool();
    }
    
    /**
     * Updates a MAC address pool.
     * 
     * The `name`, `description`, `allow_duplicates`, and `ranges` attributes can be updated.
     * 
     * For example, to update the MAC address pool of id `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/macpools/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <mac_pool>
     *   <name>UpdatedMACPool</name>
     *   <description>An updated MAC address pool</description>
     *   <allow_duplicates>false</allow_duplicates>
     *   <ranges>
     *     <range>
     *       <from>00:1A:4A:16:01:51</from>
     *       <to>00:1A:4A:16:01:e6</to>
     *     </range>
     *     <range>
     *       <from>02:1A:4A:01:00:00</from>
     *       <to>02:1A:4A:FF:FF:FF</to>
     *     </range>
     *   </ranges>
     * </mac_pool>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Returns a reference to the service that manages the permissions that are associated with the MacPool.
     */
    AssignedPermissionsService permissionsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

