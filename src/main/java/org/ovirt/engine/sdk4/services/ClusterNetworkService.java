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
 * A service to manage a specific cluster network.
 */
public interface ClusterNetworkService extends Service {
    /**
     * Retrieves the cluster network details.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves the cluster network details.
     */
    public interface GetResponse extends Response {
        /**
         * The cluster network.
         */
        Network network();
    }
    
    /**
     * Retrieves the cluster network details.
     */
    GetRequest get();
    
    /**
     * Unassigns the network from a cluster.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
    }
    
    /**
     * Unassigns the network from a cluster.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Unassigns the network from a cluster.
     */
    RemoveRequest remove();
    
    /**
     * Updates the network in the cluster.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        UpdateRequest network(Network network);
        /**
         * The cluster network.
         */
        UpdateRequest network(NetworkBuilder network);
    }
    
    /**
     * Updates the network in the cluster.
     */
    public interface UpdateResponse extends Response {
        /**
         * The cluster network.
         */
        Network network();
    }
    
    /**
     * Updates the network in the cluster.
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

