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
import org.ovirt.engine.sdk4.builders.OpenStackSubnetBuilder;
import org.ovirt.engine.sdk4.types.OpenStackSubnet;

public interface OpenstackSubnetsService extends Service {
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest subnet(OpenStackSubnet subnet);
        AddRequest subnet(OpenStackSubnetBuilder subnet);
    }
    
    public interface AddResponse extends Response {
        OpenStackSubnet subnet();
    }
    
    AddRequest add();
    
    /**
     * Returns the list of sub-networks.
     * 
     * The order of the returned list of sub-networks isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of sub-networks to return. If not specified all the sub-networks are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of sub-networks to return. If not specified all the sub-networks are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of sub-networks to return. If not specified all the sub-networks are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of sub-networks.
     * 
     * The order of the returned list of sub-networks isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<OpenStackSubnet> subnets();
    }
    
    /**
     * Returns the list of sub-networks.
     * 
     * The order of the returned list of sub-networks isn't guaranteed.
     */
    ListRequest list();
    
    OpenstackSubnetService subnetService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

