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
import org.ovirt.engine.sdk4.builders.VirtualNumaNodeBuilder;
import org.ovirt.engine.sdk4.types.VirtualNumaNode;

public interface VmNumaNodesService extends Service {
    /**
     * Creates a new virtual NUMA node for the virtual machine.
     * 
     * An example of creating a NUMA node:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/c7ecd2dc/numanodes
     * Accept: application/xml
     * Content-type: application/xml
     * ----
     * The request body can contain the following:
     * [source,xml]
     * ----
     * <vm_numa_node>
     *   <cpu>
     *     <cores>
     *       <core>
     *         <index>0</index>
     *       </core>
     *     </cores>
     *   </cpu>
     *   <index>0</index>
     *   <memory>1024</memory>
     *   <numa_tune_mode>strict</numa_tune_mode>
     * </vm_numa_node>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest node(VirtualNumaNode node);
        AddRequest node(VirtualNumaNodeBuilder node);
    }
    
    /**
     * Creates a new virtual NUMA node for the virtual machine.
     * 
     * An example of creating a NUMA node:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/c7ecd2dc/numanodes
     * Accept: application/xml
     * Content-type: application/xml
     * ----
     * The request body can contain the following:
     * [source,xml]
     * ----
     * <vm_numa_node>
     *   <cpu>
     *     <cores>
     *       <core>
     *         <index>0</index>
     *       </core>
     *     </cores>
     *   </cpu>
     *   <index>0</index>
     *   <memory>1024</memory>
     *   <numa_tune_mode>strict</numa_tune_mode>
     * </vm_numa_node>
     * ----
     */
    public interface AddResponse extends Response {
        VirtualNumaNode node();
    }
    
    /**
     * Creates a new virtual NUMA node for the virtual machine.
     * 
     * An example of creating a NUMA node:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/c7ecd2dc/numanodes
     * Accept: application/xml
     * Content-type: application/xml
     * ----
     * The request body can contain the following:
     * [source,xml]
     * ----
     * <vm_numa_node>
     *   <cpu>
     *     <cores>
     *       <core>
     *         <index>0</index>
     *       </core>
     *     </cores>
     *   </cpu>
     *   <index>0</index>
     *   <memory>1024</memory>
     *   <numa_tune_mode>strict</numa_tune_mode>
     * </vm_numa_node>
     * ----
     */
    AddRequest add();
    
    /**
     * Lists virtual NUMA nodes of a virtual machine.
     * 
     * The order of the returned list of NUMA nodes isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of nodes to return. If not specified all the nodes are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of nodes to return. If not specified all the nodes are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of nodes to return. If not specified all the nodes are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Lists virtual NUMA nodes of a virtual machine.
     * 
     * The order of the returned list of NUMA nodes isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<VirtualNumaNode> nodes();
    }
    
    /**
     * Lists virtual NUMA nodes of a virtual machine.
     * 
     * The order of the returned list of NUMA nodes isn't guaranteed.
     */
    ListRequest list();
    
    VmNumaNodeService nodeService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

