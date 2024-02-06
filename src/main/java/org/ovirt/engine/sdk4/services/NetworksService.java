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
 * Manages logical networks.
 * 
 * The engine creates a default `ovirtmgmt` network on installation. This network acts as the management network for
 * access to hypervisor hosts. This network is associated with the `Default` cluster and is a member of the `Default`
 * data center.
 */
public interface NetworksService extends Service {
    /**
     * Creates a new logical network, or associates an existing network with a data center.
     * 
     * Creation of a new network requires the `name` and `data_center` elements.
     * 
     * For example, to create a network named `mynetwork` for data center `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>mynetwork</name>
     *   <data_center id="123"/>
     * </network>
     * ----
     * 
     * 
     * To associate the existing network `456` with the data center `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/networks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>ovirtmgmt</name>
     * </network>
     * ----
     * 
     * To create a network named `exnetwork` on top of an external _OpenStack_ network provider `456` send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks
     * ----
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>exnetwork</name>
     *   <external_provider id="456"/>
     *   <data_center id="123"/>
     * </network>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest network(Network network);
        AddRequest network(NetworkBuilder network);
    }
    
    /**
     * Creates a new logical network, or associates an existing network with a data center.
     * 
     * Creation of a new network requires the `name` and `data_center` elements.
     * 
     * For example, to create a network named `mynetwork` for data center `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>mynetwork</name>
     *   <data_center id="123"/>
     * </network>
     * ----
     * 
     * 
     * To associate the existing network `456` with the data center `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/networks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>ovirtmgmt</name>
     * </network>
     * ----
     * 
     * To create a network named `exnetwork` on top of an external _OpenStack_ network provider `456` send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks
     * ----
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>exnetwork</name>
     *   <external_provider id="456"/>
     *   <data_center id="123"/>
     * </network>
     * ----
     */
    public interface AddResponse extends Response {
        Network network();
    }
    
    /**
     * Creates a new logical network, or associates an existing network with a data center.
     * 
     * Creation of a new network requires the `name` and `data_center` elements.
     * 
     * For example, to create a network named `mynetwork` for data center `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>mynetwork</name>
     *   <data_center id="123"/>
     * </network>
     * ----
     * 
     * 
     * To associate the existing network `456` with the data center `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/networks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>ovirtmgmt</name>
     * </network>
     * ----
     * 
     * To create a network named `exnetwork` on top of an external _OpenStack_ network provider `456` send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks
     * ----
     * 
     * [source,xml]
     * ----
     * <network>
     *   <name>exnetwork</name>
     *   <external_provider id="456"/>
     *   <data_center id="123"/>
     * </network>
     * ----
     */
    AddRequest add();
    
    /**
     * List logical networks.
     * 
     * For example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/networks
     * ----
     * 
     * Will respond:
     * 
     * [source,xml]
     * ----
     * <networks>
     *   <network href="/ovirt-engine/api/networks/123" id="123">
     *     <name>ovirtmgmt</name>
     *     <description>Default Management Network</description>
     *     <link href="/ovirt-engine/api/networks/123/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/networks/123/vnicprofiles" rel="vnicprofiles"/>
     *     <link href="/ovirt-engine/api/networks/123/networklabels" rel="networklabels"/>
     *     <mtu>0</mtu>
     *     <stp>false</stp>
     *     <usages>
     *       <usage>vm</usage>
     *     </usages>
     *     <data_center href="/ovirt-engine/api/datacenters/456" id="456"/>
     *   </network>
     *   ...
     * </networks>
     * ----
     * 
     * The order of the returned list of networks is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
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
        /**
         * A query string used to restrict the returned networks.
         */
        ListRequest search(String search);
    }
    
    /**
     * List logical networks.
     * 
     * For example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/networks
     * ----
     * 
     * Will respond:
     * 
     * [source,xml]
     * ----
     * <networks>
     *   <network href="/ovirt-engine/api/networks/123" id="123">
     *     <name>ovirtmgmt</name>
     *     <description>Default Management Network</description>
     *     <link href="/ovirt-engine/api/networks/123/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/networks/123/vnicprofiles" rel="vnicprofiles"/>
     *     <link href="/ovirt-engine/api/networks/123/networklabels" rel="networklabels"/>
     *     <mtu>0</mtu>
     *     <stp>false</stp>
     *     <usages>
     *       <usage>vm</usage>
     *     </usages>
     *     <data_center href="/ovirt-engine/api/datacenters/456" id="456"/>
     *   </network>
     *   ...
     * </networks>
     * ----
     * 
     * The order of the returned list of networks is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListResponse extends Response {
        List<Network> networks();
    }
    
    /**
     * List logical networks.
     * 
     * For example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/networks
     * ----
     * 
     * Will respond:
     * 
     * [source,xml]
     * ----
     * <networks>
     *   <network href="/ovirt-engine/api/networks/123" id="123">
     *     <name>ovirtmgmt</name>
     *     <description>Default Management Network</description>
     *     <link href="/ovirt-engine/api/networks/123/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/networks/123/vnicprofiles" rel="vnicprofiles"/>
     *     <link href="/ovirt-engine/api/networks/123/networklabels" rel="networklabels"/>
     *     <mtu>0</mtu>
     *     <stp>false</stp>
     *     <usages>
     *       <usage>vm</usage>
     *     </usages>
     *     <data_center href="/ovirt-engine/api/datacenters/456" id="456"/>
     *   </network>
     *   ...
     * </networks>
     * ----
     * 
     * The order of the returned list of networks is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific network.
     */
    NetworkService networkService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

