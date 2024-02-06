/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.VirtualNumaNodeBuilder;
import org.ovirt.engine.sdk4.types.VirtualNumaNode;

public interface VmNumaNodeService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        VirtualNumaNode node();
    }
    
    GetRequest get();
    
    /**
     * Removes a virtual NUMA node.
     * 
     * An example of removing a virtual NUMA node:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/numanodes/456
     * ----
     * 
     * NOTE: It's required to remove the numa nodes from the highest index
     * first.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes a virtual NUMA node.
     * 
     * An example of removing a virtual NUMA node:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/numanodes/456
     * ----
     * 
     * NOTE: It's required to remove the numa nodes from the highest index
     * first.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a virtual NUMA node.
     * 
     * An example of removing a virtual NUMA node:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/numanodes/456
     * ----
     * 
     * NOTE: It's required to remove the numa nodes from the highest index
     * first.
     */
    RemoveRequest remove();
    
    /**
     * Updates a virtual NUMA node.
     * 
     * An example of pinning a virtual NUMA node to a physical NUMA node on the host:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/numanodes/456
     * ----
     * 
     * The request body should contain the following:
     * 
     * [source,xml]
     * ----
     * <vm_numa_node>
     *   <numa_node_pins>
     *     <numa_node_pin>
     *       <index>0</index>
     *     </numa_node_pin>
     *   </numa_node_pins>
     * </vm_numa_node>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest node(VirtualNumaNode node);
        UpdateRequest node(VirtualNumaNodeBuilder node);
    }
    
    /**
     * Updates a virtual NUMA node.
     * 
     * An example of pinning a virtual NUMA node to a physical NUMA node on the host:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/numanodes/456
     * ----
     * 
     * The request body should contain the following:
     * 
     * [source,xml]
     * ----
     * <vm_numa_node>
     *   <numa_node_pins>
     *     <numa_node_pin>
     *       <index>0</index>
     *     </numa_node_pin>
     *   </numa_node_pins>
     * </vm_numa_node>
     * ----
     */
    public interface UpdateResponse extends Response {
        VirtualNumaNode node();
    }
    
    /**
     * Updates a virtual NUMA node.
     * 
     * An example of pinning a virtual NUMA node to a physical NUMA node on the host:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/numanodes/456
     * ----
     * 
     * The request body should contain the following:
     * 
     * [source,xml]
     * ----
     * <vm_numa_node>
     *   <numa_node_pins>
     *     <numa_node_pin>
     *       <index>0</index>
     *     </numa_node_pin>
     *   </numa_node_pins>
     * </vm_numa_node>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

