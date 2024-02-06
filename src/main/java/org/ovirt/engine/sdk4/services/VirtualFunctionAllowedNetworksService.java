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

public interface VirtualFunctionAllowedNetworksService extends Service {
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest network(Network network);
        AddRequest network(NetworkBuilder network);
    }
    
    public interface AddResponse extends Response {
        Network network();
    }
    
    AddRequest add();
    
    /**
     * Returns the list of networks.
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
         * Sets the maximum number of networks to return. If not specified all the networks are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of networks to return. If not specified all the networks are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of networks to return. If not specified all the networks are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of networks.
     * 
     * The order of the returned list of networks isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Network> networks();
    }
    
    /**
     * Returns the list of networks.
     * 
     * The order of the returned list of networks isn't guaranteed.
     */
    ListRequest list();
    
    VirtualFunctionAllowedNetworkService networkService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

