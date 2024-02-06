/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Permit;

/**
 * A service to manage a specific permit of the role.
 */
public interface PermitService extends Service {
    /**
     * Gets the information about the permit of the role.
     * 
     * For example to retrieve the information about the permit with the id `456` of the role with the id `123`
     * send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/roles/123/permits/456
     * ....
     * 
     * [source,xml]
     * ----
     * <permit href="/ovirt-engine/api/roles/123/permits/456" id="456">
     *   <name>change_vm_cd</name>
     *   <administrative>false</administrative>
     *   <role href="/ovirt-engine/api/roles/123" id="123"/>
     * </permit>
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
     * Gets the information about the permit of the role.
     * 
     * For example to retrieve the information about the permit with the id `456` of the role with the id `123`
     * send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/roles/123/permits/456
     * ....
     * 
     * [source,xml]
     * ----
     * <permit href="/ovirt-engine/api/roles/123/permits/456" id="456">
     *   <name>change_vm_cd</name>
     *   <administrative>false</administrative>
     *   <role href="/ovirt-engine/api/roles/123" id="123"/>
     * </permit>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The permit of the role.
         */
        Permit permit();
    }
    
    /**
     * Gets the information about the permit of the role.
     * 
     * For example to retrieve the information about the permit with the id `456` of the role with the id `123`
     * send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/roles/123/permits/456
     * ....
     * 
     * [source,xml]
     * ----
     * <permit href="/ovirt-engine/api/roles/123/permits/456" id="456">
     *   <name>change_vm_cd</name>
     *   <administrative>false</administrative>
     *   <role href="/ovirt-engine/api/roles/123" id="123"/>
     * </permit>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes the permit from the role.
     * 
     * For example to remove the permit with id `456` from the role with id `123` send a request like this:
     * 
     * ....
     * DELETE /ovirt-engine/api/roles/123/permits/456
     * ....
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the permit from the role.
     * 
     * For example to remove the permit with id `456` from the role with id `123` send a request like this:
     * 
     * ....
     * DELETE /ovirt-engine/api/roles/123/permits/456
     * ....
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the permit from the role.
     * 
     * For example to remove the permit with id `456` from the role with id `123` send a request like this:
     * 
     * ....
     * DELETE /ovirt-engine/api/roles/123/permits/456
     * ....
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

