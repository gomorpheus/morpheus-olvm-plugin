/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.VmPoolBuilder;
import org.ovirt.engine.sdk4.types.VmPool;

/**
 * A service to manage a virtual machines pool.
 */
public interface VmPoolService extends Service {
    /**
     * This operation allocates a virtual machine in the virtual machine pool.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vmpools/123/allocatevm
     * ----
     * 
     * The allocate virtual machine action does not take any action specific parameters, so the request body should
     * contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface AllocateVmRequest extends Request<AllocateVmRequest, AllocateVmResponse> {
        /**
         * Indicates if the allocation should be performed asynchronously.
         */
        AllocateVmRequest async(Boolean async);
    }
    
    /**
     * This operation allocates a virtual machine in the virtual machine pool.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vmpools/123/allocatevm
     * ----
     * 
     * The allocate virtual machine action does not take any action specific parameters, so the request body should
     * contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface AllocateVmResponse extends Response {
    }
    
    /**
     * This operation allocates a virtual machine in the virtual machine pool.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vmpools/123/allocatevm
     * ----
     * 
     * The allocate virtual machine action does not take any action specific parameters, so the request body should
     * contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    AllocateVmRequest allocateVm();
    
    /**
     * Get the virtual machine pool.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vmpools/123
     * ----
     * 
     * You will get a XML response like that one:
     * [source,xml]
     * ----
     * <vm_pool id="123">
     *   <actions>...</actions>
     *   <name>MyVmPool</name>
     *   <description>MyVmPool description</description>
     *   <link href="/ovirt-engine/api/vmpools/123/permissions" rel="permissions"/>
     *   <max_user_vms>1</max_user_vms>
     *   <prestarted_vms>0</prestarted_vms>
     *   <size>100</size>
     *   <stateful>false</stateful>
     *   <type>automatic</type>
     *   <use_latest_template_version>false</use_latest_template_version>
     *   <cluster id="123"/>
     *   <template id="123"/>
     *   <vm id="123">...</vm>
     *   ...
     * </vm_pool>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        GetRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Get the virtual machine pool.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vmpools/123
     * ----
     * 
     * You will get a XML response like that one:
     * [source,xml]
     * ----
     * <vm_pool id="123">
     *   <actions>...</actions>
     *   <name>MyVmPool</name>
     *   <description>MyVmPool description</description>
     *   <link href="/ovirt-engine/api/vmpools/123/permissions" rel="permissions"/>
     *   <max_user_vms>1</max_user_vms>
     *   <prestarted_vms>0</prestarted_vms>
     *   <size>100</size>
     *   <stateful>false</stateful>
     *   <type>automatic</type>
     *   <use_latest_template_version>false</use_latest_template_version>
     *   <cluster id="123"/>
     *   <template id="123"/>
     *   <vm id="123">...</vm>
     *   ...
     * </vm_pool>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Retrieved virtual machines pool.
         */
        VmPool pool();
    }
    
    /**
     * Get the virtual machine pool.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vmpools/123
     * ----
     * 
     * You will get a XML response like that one:
     * [source,xml]
     * ----
     * <vm_pool id="123">
     *   <actions>...</actions>
     *   <name>MyVmPool</name>
     *   <description>MyVmPool description</description>
     *   <link href="/ovirt-engine/api/vmpools/123/permissions" rel="permissions"/>
     *   <max_user_vms>1</max_user_vms>
     *   <prestarted_vms>0</prestarted_vms>
     *   <size>100</size>
     *   <stateful>false</stateful>
     *   <type>automatic</type>
     *   <use_latest_template_version>false</use_latest_template_version>
     *   <cluster id="123"/>
     *   <template id="123"/>
     *   <vm id="123">...</vm>
     *   ...
     * </vm_pool>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes a virtual machine pool.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vmpools/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes a virtual machine pool.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vmpools/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a virtual machine pool.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vmpools/123
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Update the virtual machine pool.
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vmpools/123
     * ----
     * 
     * The `name`, `description`, `size`, `prestarted_vms` and `max_user_vms`
     * attributes can be updated after the virtual machine pool has been
     * created.
     * 
     * [source,xml]
     * ----
     * <vmpool>
     *   <name>VM_Pool_B</name>
     *   <description>Virtual Machine Pool B</description>
     *   <size>3</size>
     *   <prestarted_vms>1</size>
     *   <max_user_vms>2</size>
     * </vmpool>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest pool(VmPool pool);
        /**
         * The virtual machine pool that is being updated.
         */
        UpdateRequest pool(VmPoolBuilder pool);
    }
    
    /**
     * Update the virtual machine pool.
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vmpools/123
     * ----
     * 
     * The `name`, `description`, `size`, `prestarted_vms` and `max_user_vms`
     * attributes can be updated after the virtual machine pool has been
     * created.
     * 
     * [source,xml]
     * ----
     * <vmpool>
     *   <name>VM_Pool_B</name>
     *   <description>Virtual Machine Pool B</description>
     *   <size>3</size>
     *   <prestarted_vms>1</size>
     *   <max_user_vms>2</size>
     * </vmpool>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * The virtual machine pool that is being updated.
         */
        VmPool pool();
    }
    
    /**
     * Update the virtual machine pool.
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vmpools/123
     * ----
     * 
     * The `name`, `description`, `size`, `prestarted_vms` and `max_user_vms`
     * attributes can be updated after the virtual machine pool has been
     * created.
     * 
     * [source,xml]
     * ----
     * <vmpool>
     *   <name>VM_Pool_B</name>
     *   <description>Virtual Machine Pool B</description>
     *   <size>3</size>
     *   <prestarted_vms>1</size>
     *   <max_user_vms>2</size>
     * </vmpool>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Reference to a service managing the virtual machine pool assigned permissions.
     */
    AssignedPermissionsService permissionsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

