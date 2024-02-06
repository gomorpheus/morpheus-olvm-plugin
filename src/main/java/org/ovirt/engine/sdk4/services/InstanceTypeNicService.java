/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.NicBuilder;
import org.ovirt.engine.sdk4.types.Nic;

public interface InstanceTypeNicService extends Service {
    /**
     * Gets network interface configuration of the instance type.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Gets network interface configuration of the instance type.
     */
    public interface GetResponse extends Response {
        Nic nic();
    }
    
    /**
     * Gets network interface configuration of the instance type.
     */
    GetRequest get();
    
    /**
     * Remove the network interface from the instance type.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove the network interface from the instance type.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove the network interface from the instance type.
     */
    RemoveRequest remove();
    
    /**
     * Updates the network interface configuration of the instance type.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest nic(Nic nic);
        UpdateRequest nic(NicBuilder nic);
    }
    
    /**
     * Updates the network interface configuration of the instance type.
     */
    public interface UpdateResponse extends Response {
        Nic nic();
    }
    
    /**
     * Updates the network interface configuration of the instance type.
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

