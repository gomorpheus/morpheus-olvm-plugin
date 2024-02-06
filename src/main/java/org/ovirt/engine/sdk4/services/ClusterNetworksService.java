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
import org.ovirt.engine.sdk4.builders.NetworkBuilder;
import org.ovirt.engine.sdk4.types.Network;

/**
 * A service to manage cluster networks.
 */
public interface ClusterNetworksService extends Service {
    /**
     * Assigns the network to a cluster.
     * 
     * Post a request like in the example below to assign the network to a cluster:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/networks
     * ----
     * 
     * Use the following example in its body:
     * 
     * [source,xml]
     * ----
     * <network id="123" />
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest network(Network network);
        /**
         * The network object to be assigned to the cluster.
         */
        AddRequest network(NetworkBuilder network);
    }
    
    /**
     * Assigns the network to a cluster.
     * 
     * Post a request like in the example below to assign the network to a cluster:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/networks
     * ----
     * 
     * Use the following example in its body:
     * 
     * [source,xml]
     * ----
     * <network id="123" />
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The network object to be assigned to the cluster.
         */
        Network network();
    }
    
    /**
     * Assigns the network to a cluster.
     * 
     * Post a request like in the example below to assign the network to a cluster:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/networks
     * ----
     * 
     * Use the following example in its body:
     * 
     * [source,xml]
     * ----
     * <network id="123" />
     * ----
     */
    AddRequest add();
    
    /**
     * Lists the networks that are assigned to the cluster.
     * 
     * The order of the returned clusters isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of networks to return. If not specified, all the networks are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of networks to return. If not specified, all the networks are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of networks to return. If not specified, all the networks are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Lists the networks that are assigned to the cluster.
     * 
     * The order of the returned clusters isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of networks that are assigned to the cluster.
         */
        List<Network> networks();
    }
    
    /**
     * Lists the networks that are assigned to the cluster.
     * 
     * The order of the returned clusters isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Access the cluster network service that manages the cluster network specified by an ID.
     */
    ClusterNetworkService networkService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

