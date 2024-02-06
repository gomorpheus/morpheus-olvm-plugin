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
import org.ovirt.engine.sdk4.builders.NicBuilder;
import org.ovirt.engine.sdk4.types.Nic;

public interface InstanceTypeNicsService extends Service {
    /**
     * Add new network interface to the instance type.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest nic(Nic nic);
        AddRequest nic(NicBuilder nic);
    }
    
    /**
     * Add new network interface to the instance type.
     */
    public interface AddResponse extends Response {
        Nic nic();
    }
    
    /**
     * Add new network interface to the instance type.
     */
    AddRequest add();
    
    /**
     * Lists all the configured network interface of the instance type.
     * 
     * The order of the returned list of network interfaces isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of NICs to return. If not specified all the NICs are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of NICs to return. If not specified all the NICs are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of NICs to return. If not specified all the NICs are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned templates.
         */
        ListRequest search(String search);
    }
    
    /**
     * Lists all the configured network interface of the instance type.
     * 
     * The order of the returned list of network interfaces isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Nic> nics();
    }
    
    /**
     * Lists all the configured network interface of the instance type.
     * 
     * The order of the returned list of network interfaces isn't guaranteed.
     */
    ListRequest list();
    
    InstanceTypeNicService nicService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

