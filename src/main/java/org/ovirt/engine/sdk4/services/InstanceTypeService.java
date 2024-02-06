/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.InstanceTypeBuilder;
import org.ovirt.engine.sdk4.types.InstanceType;

public interface InstanceTypeService extends Service {
    /**
     * Get a specific instance type and it's attributes.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/instancetypes/123
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
     * Get a specific instance type and it's attributes.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/instancetypes/123
     * ----
     */
    public interface GetResponse extends Response {
        InstanceType instanceType();
    }
    
    /**
     * Get a specific instance type and it's attributes.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/instancetypes/123
     * ----
     */
    GetRequest get();
    
    /**
     * Removes a specific instance type from the system.
     * 
     * If a virtual machine was created using an instance type X after removal of the instance type
     * the virtual machine's instance type will be set to `custom`.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/instancetypes/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes a specific instance type from the system.
     * 
     * If a virtual machine was created using an instance type X after removal of the instance type
     * the virtual machine's instance type will be set to `custom`.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/instancetypes/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a specific instance type from the system.
     * 
     * If a virtual machine was created using an instance type X after removal of the instance type
     * the virtual machine's instance type will be set to `custom`.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/instancetypes/123
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Update a specific instance type and it's attributes.
     * 
     * All the attributes are editable after creation.
     * If a virtual machine was created using an instance type X and some configuration in instance
     * type X was updated, the virtual machine's configuration will be updated automatically by the
     * engine.
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/instancetypes/123
     * ----
     * 
     * For example, to update the memory of instance type `123` to 1 GiB and set the cpu topology
     * to 2 sockets and 1 core, send a request like this:
     * 
     * [source, xml]
     * ----
     * 
     * <instance_type>
     *   <memory>1073741824</memory>
     *   <cpu>
     *     <topology>
     *       <cores>1</cores>
     *       <sockets>2</sockets>
     *       <threads>1</threads>
     *     </topology>
     *   </cpu>
     * </instance_type>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest instanceType(InstanceType instanceType);
        UpdateRequest instanceType(InstanceTypeBuilder instanceType);
    }
    
    /**
     * Update a specific instance type and it's attributes.
     * 
     * All the attributes are editable after creation.
     * If a virtual machine was created using an instance type X and some configuration in instance
     * type X was updated, the virtual machine's configuration will be updated automatically by the
     * engine.
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/instancetypes/123
     * ----
     * 
     * For example, to update the memory of instance type `123` to 1 GiB and set the cpu topology
     * to 2 sockets and 1 core, send a request like this:
     * 
     * [source, xml]
     * ----
     * 
     * <instance_type>
     *   <memory>1073741824</memory>
     *   <cpu>
     *     <topology>
     *       <cores>1</cores>
     *       <sockets>2</sockets>
     *       <threads>1</threads>
     *     </topology>
     *   </cpu>
     * </instance_type>
     * ----
     */
    public interface UpdateResponse extends Response {
        InstanceType instanceType();
    }
    
    /**
     * Update a specific instance type and it's attributes.
     * 
     * All the attributes are editable after creation.
     * If a virtual machine was created using an instance type X and some configuration in instance
     * type X was updated, the virtual machine's configuration will be updated automatically by the
     * engine.
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/instancetypes/123
     * ----
     * 
     * For example, to update the memory of instance type `123` to 1 GiB and set the cpu topology
     * to 2 sockets and 1 core, send a request like this:
     * 
     * [source, xml]
     * ----
     * 
     * <instance_type>
     *   <memory>1073741824</memory>
     *   <cpu>
     *     <topology>
     *       <cores>1</cores>
     *       <sockets>2</sockets>
     *       <threads>1</threads>
     *     </topology>
     *   </cpu>
     * </instance_type>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Reference to the service that manages the graphic consoles that are attached to this
     * instance type.
     */
    InstanceTypeGraphicsConsolesService graphicsConsolesService();
    /**
     * Reference to the service that manages the NICs that are attached to this instance type.
     */
    InstanceTypeNicsService nicsService();
    /**
     * Reference to the service that manages the watchdogs that are attached to this instance type.
     */
    InstanceTypeWatchdogsService watchdogsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

