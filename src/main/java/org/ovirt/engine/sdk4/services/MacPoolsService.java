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
import org.ovirt.engine.sdk4.builders.MacPoolBuilder;
import org.ovirt.engine.sdk4.types.MacPool;

public interface MacPoolsService extends Service {
    /**
     * Creates a new MAC address pool.
     * 
     * Creation of a MAC address pool requires values for the `name` and `ranges` attributes.
     * 
     * For example, to create MAC address pool send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/macpools
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <mac_pool>
     *   <name>MACPool</name>
     *   <description>A MAC address pool</description>
     *   <allow_duplicates>true</allow_duplicates>
     *   <default_pool>false</default_pool>
     *   <ranges>
     *     <range>
     *       <from>00:1A:4A:16:01:51</from>
     *       <to>00:1A:4A:16:01:e6</to>
     *     </range>
     *   </ranges>
     * </mac_pool>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest pool(MacPool pool);
        AddRequest pool(MacPoolBuilder pool);
    }
    
    /**
     * Creates a new MAC address pool.
     * 
     * Creation of a MAC address pool requires values for the `name` and `ranges` attributes.
     * 
     * For example, to create MAC address pool send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/macpools
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <mac_pool>
     *   <name>MACPool</name>
     *   <description>A MAC address pool</description>
     *   <allow_duplicates>true</allow_duplicates>
     *   <default_pool>false</default_pool>
     *   <ranges>
     *     <range>
     *       <from>00:1A:4A:16:01:51</from>
     *       <to>00:1A:4A:16:01:e6</to>
     *     </range>
     *   </ranges>
     * </mac_pool>
     * ----
     */
    public interface AddResponse extends Response {
        MacPool pool();
    }
    
    /**
     * Creates a new MAC address pool.
     * 
     * Creation of a MAC address pool requires values for the `name` and `ranges` attributes.
     * 
     * For example, to create MAC address pool send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/macpools
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <mac_pool>
     *   <name>MACPool</name>
     *   <description>A MAC address pool</description>
     *   <allow_duplicates>true</allow_duplicates>
     *   <default_pool>false</default_pool>
     *   <ranges>
     *     <range>
     *       <from>00:1A:4A:16:01:51</from>
     *       <to>00:1A:4A:16:01:e6</to>
     *     </range>
     *   </ranges>
     * </mac_pool>
     * ----
     */
    AddRequest add();
    
    /**
     * Return the list of MAC address pools of the system.
     * 
     * The returned list of MAC address pools isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of pools to return. If not specified all the pools are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of pools to return. If not specified all the pools are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of pools to return. If not specified all the pools are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Return the list of MAC address pools of the system.
     * 
     * The returned list of MAC address pools isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<MacPool> pools();
    }
    
    /**
     * Return the list of MAC address pools of the system.
     * 
     * The returned list of MAC address pools isn't guaranteed.
     */
    ListRequest list();
    
    MacPoolService macPoolService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

