/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.NetworkFilter;

/**
 * Represents a readonly network filters sub-collection.
 * 
 * The network filter enables to filter packets send to/from the VM's nic according to defined rules.
 * For more information please refer to <<services/network_filter,NetworkFilter>> service documentation
 * 
 * Network filters are supported in different versions, starting from version 3.0.
 * 
 * A network filter is defined for each vnic profile.
 * 
 * A vnic profile is defined for a specific network.
 * 
 * A network can be assigned to several different clusters. In the future, each network will be defined in
 * cluster level.
 * 
 * Currently, each network is being defined at data center level. Potential network filters for each network
 * are determined by the network's data center compatibility version V.
 * V must be >= the network filter version in order to configure this network filter for a specific network.
 * Please note, that if a network is assigned to cluster with a version supporting a network filter, the filter
 * may not be available due to the data center version being smaller then the network filter's version.
 * 
 * Example of listing all of the supported network filters for a specific cluster:
 * 
 * [source]
 * ----
 * GET http://localhost:8080/ovirt-engine/api/clusters/{cluster:id}/networkfilters
 * ----
 * 
 * Output:
 * 
 * [source,xml]
 * ----
 * <network_filters>
 *   <network_filter id="00000019-0019-0019-0019-00000000026c">
 *     <name>example-network-filter-a</name>
 *     <version>
 *       <major>4</major>
 *       <minor>0</minor>
 *       <build>-1</build>
 *       <revision>-1</revision>
 *     </version>
 *   </network_filter>
 *   <network_filter id="00000019-0019-0019-0019-00000000026b">
 *     <name>example-network-filter-b</name>
 *     <version>
 *       <major>4</major>
 *       <minor>0</minor>
 *       <build>-1</build>
 *       <revision>-1</revision>
 *     </version>
 *   </network_filter>
 *   <network_filter id="00000019-0019-0019-0019-00000000026a">
 *     <name>example-network-filter-a</name>
 *     <version>
 *       <major>3</major>
 *       <minor>0</minor>
 *       <build>-1</build>
 *       <revision>-1</revision>
 *     </version>
 *   </network_filter>
 * </network_filters>
 * ----
 */
public interface NetworkFiltersService extends Service {
    /**
     * Retrieves the representations of the network filters.
     * 
     * The order of the returned list of network filters isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * Retrieves the representations of the network filters.
     * 
     * The order of the returned list of network filters isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<NetworkFilter> filters();
    }
    
    /**
     * Retrieves the representations of the network filters.
     * 
     * The order of the returned list of network filters isn't guaranteed.
     */
    ListRequest list();
    
    NetworkFilterService networkFilterService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

