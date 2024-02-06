/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.NetworkBuilder;
import org.ovirt.engine.sdk4.types.Network;

/**
 * A service to manage a specific data center network.
 */
public interface DataCenterNetworkService extends Service {
    /**
     * Retrieves the data center network details.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves the data center network details.
     */
    public interface GetResponse extends Response {
        /**
         * The data center network.
         */
        Network network();
    }
    
    /**
     * Retrieves the data center network details.
     */
    GetRequest get();
    
    /**
     * Removes the network.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
    }
    
    /**
     * Removes the network.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the network.
     */
    RemoveRequest remove();
    
    /**
     * Updates the network in the data center.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        UpdateRequest network(Network network);
        /**
         * The data center network.
         */
        UpdateRequest network(NetworkBuilder network);
    }
    
    /**
     * Updates the network in the data center.
     */
    public interface UpdateResponse extends Response {
        /**
         * The data center network.
         */
        Network network();
    }
    
    /**
     * Updates the network in the data center.
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

