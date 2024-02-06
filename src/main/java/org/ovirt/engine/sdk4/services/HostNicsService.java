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
import org.ovirt.engine.sdk4.types.HostNic;

/**
 * A service to manage the network interfaces of a host.
 */
public interface HostNicsService extends Service {
    /**
     * Returns the list of network interfaces of the host.
     * 
     * The order of the returned list of network interfaces isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if all of the attributes of the host network interface should be included in the response.
         * 
         * By default the following attributes are excluded:
         * 
         * - `virtual_functions_configuration`
         * 
         * For example, to retrieve the complete representation of network interface '456' of host '123':
         * 
         * ....
         * GET /ovirt-engine/api/hosts/123/nics?all_content=true
         * ....
         * 
         * NOTE: These attributes are not included by default because retrieving them impacts performance. They are
         * seldom used and require additional queries to the database. Use this parameter with caution and only when
         * specifically required.
         */
        ListRequest allContent(Boolean allContent);
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
    }
    
    /**
     * Returns the list of network interfaces of the host.
     * 
     * The order of the returned list of network interfaces isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<HostNic> nics();
    }
    
    /**
     * Returns the list of network interfaces of the host.
     * 
     * The order of the returned list of network interfaces isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a single network interface.
     */
    HostNicService nicService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

