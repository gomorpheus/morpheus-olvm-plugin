/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.NetworkFilter;

/**
 * Manages a network filter.
 * 
 * [source,xml]
 * ----
 * <network_filter id="00000019-0019-0019-0019-00000000026b">
 *   <name>example-network-filter-b</name>
 *   <version>
 *     <major>4</major>
 *     <minor>0</minor>
 *     <build>-1</build>
 *     <revision>-1</revision>
 *   </version>
 * </network_filter>
 * ----
 * 
 * Please note that version is referring to the minimal support version for the specific filter.
 */
public interface NetworkFilterService extends Service {
    /**
     * Retrieves a representation of the network filter.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves a representation of the network filter.
     */
    public interface GetResponse extends Response {
        NetworkFilter networkFilter();
    }
    
    /**
     * Retrieves a representation of the network filter.
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

