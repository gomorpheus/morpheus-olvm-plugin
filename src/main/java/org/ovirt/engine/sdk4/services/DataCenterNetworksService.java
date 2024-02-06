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
 * A service to manage data center networks.
 */
public interface DataCenterNetworksService extends Service {
    /**
     * Create a new network in a data center.
     * 
     * Post a request like in the example below to create a new network in a data center with an ID of `123`.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/networks
     * ----
     * 
     * Use the following example in its body:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>mynetwork</name>
     * </network>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest network(Network network);
        /**
         * The network object to be created in the data center.
         */
        AddRequest network(NetworkBuilder network);
    }
    
    /**
     * Create a new network in a data center.
     * 
     * Post a request like in the example below to create a new network in a data center with an ID of `123`.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/networks
     * ----
     * 
     * Use the following example in its body:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>mynetwork</name>
     * </network>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The network object to be created in the data center.
         */
        Network network();
    }
    
    /**
     * Create a new network in a data center.
     * 
     * Post a request like in the example below to create a new network in a data center with an ID of `123`.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/networks
     * ----
     * 
     * Use the following example in its body:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>mynetwork</name>
     * </network>
     * ----
     */
    AddRequest add();
    
    /**
     * Lists networks in the data center.
     * 
     * The order of the returned list of networks isn't guaranteed.
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
     * Lists networks in the data center.
     * 
     * The order of the returned list of networks isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of networks which are in the data center.
         */
        List<Network> networks();
    }
    
    /**
     * Lists networks in the data center.
     * 
     * The order of the returned list of networks isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Access the data center network service that manages the data center network specified by an ID.
     */
    DataCenterNetworkService networkService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

