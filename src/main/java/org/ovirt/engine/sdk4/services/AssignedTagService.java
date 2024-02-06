/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Tag;

/**
 * A service to manage assignment of specific tag to specific entities in system.
 */
public interface AssignedTagService extends Service {
    /**
     * Gets the information about the assigned tag.
     * 
     * For example to retrieve the information about the tag with the id `456` which is assigned to virtual machine
     * with id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/vms/123/tags/456
     * ....
     * 
     * [source,xml]
     * ----
     * <tag href="/ovirt-engine/api/tags/456" id="456">
     *   <name>root</name>
     *   <description>root</description>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </tag>
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
     * Gets the information about the assigned tag.
     * 
     * For example to retrieve the information about the tag with the id `456` which is assigned to virtual machine
     * with id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/vms/123/tags/456
     * ....
     * 
     * [source,xml]
     * ----
     * <tag href="/ovirt-engine/api/tags/456" id="456">
     *   <name>root</name>
     *   <description>root</description>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </tag>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The assigned tag.
         */
        Tag tag();
    }
    
    /**
     * Gets the information about the assigned tag.
     * 
     * For example to retrieve the information about the tag with the id `456` which is assigned to virtual machine
     * with id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/vms/123/tags/456
     * ....
     * 
     * [source,xml]
     * ----
     * <tag href="/ovirt-engine/api/tags/456" id="456">
     *   <name>root</name>
     *   <description>root</description>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </tag>
     * ----
     */
    GetRequest get();
    
    /**
     * Unassign tag from specific entity in the system.
     * 
     * For example to unassign the tag with id `456` from virtual machine with id `123` send a request like this:
     * 
     * ....
     * DELETE /ovirt-engine/api/vms/123/tags/456
     * ....
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Unassign tag from specific entity in the system.
     * 
     * For example to unassign the tag with id `456` from virtual machine with id `123` send a request like this:
     * 
     * ....
     * DELETE /ovirt-engine/api/vms/123/tags/456
     * ....
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Unassign tag from specific entity in the system.
     * 
     * For example to unassign the tag with id `456` from virtual machine with id `123` send a request like this:
     * 
     * ....
     * DELETE /ovirt-engine/api/vms/123/tags/456
     * ....
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

