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
import org.ovirt.engine.sdk4.builders.VmPoolBuilder;
import org.ovirt.engine.sdk4.types.VmPool;

/**
 * Provides read-write access to virtual machines pools.
 */
public interface VmPoolsService extends Service {
    /**
     * Creates a new virtual machine pool.
     * 
     * A new pool requires the `name`, `cluster` and `template` attributes. Identify the cluster and template with the
     * `id` or `name` nested attributes:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vmpools
     * ----
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <vmpool>
     *   <name>mypool</name>
     *   <cluster id="123"/>
     *   <template id="456"/>
     * </vmpool>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest pool(VmPool pool);
        /**
         * Pool to add.
         */
        AddRequest pool(VmPoolBuilder pool);
    }
    
    /**
     * Creates a new virtual machine pool.
     * 
     * A new pool requires the `name`, `cluster` and `template` attributes. Identify the cluster and template with the
     * `id` or `name` nested attributes:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vmpools
     * ----
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <vmpool>
     *   <name>mypool</name>
     *   <cluster id="123"/>
     *   <template id="456"/>
     * </vmpool>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * Pool to add.
         */
        VmPool pool();
    }
    
    /**
     * Creates a new virtual machine pool.
     * 
     * A new pool requires the `name`, `cluster` and `template` attributes. Identify the cluster and template with the
     * `id` or `name` nested attributes:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vmpools
     * ----
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <vmpool>
     *   <name>mypool</name>
     *   <cluster id="123"/>
     *   <template id="456"/>
     * </vmpool>
     * ----
     */
    AddRequest add();
    
    /**
     * Get a list of available virtual machines pools.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vmpools
     * ----
     * 
     * You will receive the following response:
     * 
     * [source,xml]
     * ----
     * <vm_pools>
     *   <vm_pool id="123">
     *     ...
     *   </vm_pool>
     *   ...
     * </vm_pools>
     * ----
     * 
     * The order of the returned list of pools is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ListRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of pools to return. If this value is not specified, all of the pools are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of pools to return. If this value is not specified, all of the pools are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of pools to return. If this value is not specified, all of the pools are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned pools.
         */
        ListRequest search(String search);
    }
    
    /**
     * Get a list of available virtual machines pools.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vmpools
     * ----
     * 
     * You will receive the following response:
     * 
     * [source,xml]
     * ----
     * <vm_pools>
     *   <vm_pool id="123">
     *     ...
     *   </vm_pool>
     *   ...
     * </vm_pools>
     * ----
     * 
     * The order of the returned list of pools is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListResponse extends Response {
        /**
         * Retrieved pools.
         */
        List<VmPool> pools();
    }
    
    /**
     * Get a list of available virtual machines pools.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vmpools
     * ----
     * 
     * You will receive the following response:
     * 
     * [source,xml]
     * ----
     * <vm_pools>
     *   <vm_pool id="123">
     *     ...
     *   </vm_pool>
     *   ...
     * </vm_pools>
     * ----
     * 
     * The order of the returned list of pools is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific virtual machine pool.
     */
    VmPoolService poolService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

