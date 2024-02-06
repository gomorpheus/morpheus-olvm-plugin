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
 * A service managing a network
 */
public interface NetworkService extends Service {
    /**
     * Gets a logical network.
     * 
     * For example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/networks/123
     * ----
     * 
     * Will respond:
     * 
     * [source,xml]
     * ----
     * <network href="/ovirt-engine/api/networks/123" id="123">
     *   <name>ovirtmgmt</name>
     *   <description>Default Management Network</description>
     *   <link href="/ovirt-engine/api/networks/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/networks/123/vnicprofiles" rel="vnicprofiles"/>
     *   <link href="/ovirt-engine/api/networks/123/networklabels" rel="networklabels"/>
     *   <mtu>0</mtu>
     *   <stp>false</stp>
     *   <usages>
     *     <usage>vm</usage>
     *   </usages>
     *   <data_center href="/ovirt-engine/api/datacenters/456" id="456"/>
     * </network>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Gets a logical network.
     * 
     * For example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/networks/123
     * ----
     * 
     * Will respond:
     * 
     * [source,xml]
     * ----
     * <network href="/ovirt-engine/api/networks/123" id="123">
     *   <name>ovirtmgmt</name>
     *   <description>Default Management Network</description>
     *   <link href="/ovirt-engine/api/networks/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/networks/123/vnicprofiles" rel="vnicprofiles"/>
     *   <link href="/ovirt-engine/api/networks/123/networklabels" rel="networklabels"/>
     *   <mtu>0</mtu>
     *   <stp>false</stp>
     *   <usages>
     *     <usage>vm</usage>
     *   </usages>
     *   <data_center href="/ovirt-engine/api/datacenters/456" id="456"/>
     * </network>
     * ----
     */
    public interface GetResponse extends Response {
        Network network();
    }
    
    /**
     * Gets a logical network.
     * 
     * For example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/networks/123
     * ----
     * 
     * Will respond:
     * 
     * [source,xml]
     * ----
     * <network href="/ovirt-engine/api/networks/123" id="123">
     *   <name>ovirtmgmt</name>
     *   <description>Default Management Network</description>
     *   <link href="/ovirt-engine/api/networks/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/networks/123/vnicprofiles" rel="vnicprofiles"/>
     *   <link href="/ovirt-engine/api/networks/123/networklabels" rel="networklabels"/>
     *   <mtu>0</mtu>
     *   <stp>false</stp>
     *   <usages>
     *     <usage>vm</usage>
     *   </usages>
     *   <data_center href="/ovirt-engine/api/datacenters/456" id="456"/>
     * </network>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes a logical network, or the association of a logical network to a data center.
     * 
     * For example, to remove the logical network `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/networks/123
     * ----
     * 
     * Each network is bound exactly to one data center. So if we disassociate network with data center it has the same
     * result as if we would just remove that network. However it might be more specific to say we're removing network
     * `456` of data center `123`.
     * 
     * For example, to remove the association of network `456` to data center `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/networks/456
     * ----
     * 
     * NOTE: To remove an external logical network, the network has to be removed directly from its provider by
     * https://developer.openstack.org/api-ref/network[OpenStack Networking API].
     * The entity representing the external network inside {product-name} is removed automatically,
     * if <<types/open_stack_network_provider/attributes/auto_sync,`auto_sync`>> is enabled for the provider,
     * otherwise the entity has to be removed using this method.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes a logical network, or the association of a logical network to a data center.
     * 
     * For example, to remove the logical network `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/networks/123
     * ----
     * 
     * Each network is bound exactly to one data center. So if we disassociate network with data center it has the same
     * result as if we would just remove that network. However it might be more specific to say we're removing network
     * `456` of data center `123`.
     * 
     * For example, to remove the association of network `456` to data center `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/networks/456
     * ----
     * 
     * NOTE: To remove an external logical network, the network has to be removed directly from its provider by
     * https://developer.openstack.org/api-ref/network[OpenStack Networking API].
     * The entity representing the external network inside {product-name} is removed automatically,
     * if <<types/open_stack_network_provider/attributes/auto_sync,`auto_sync`>> is enabled for the provider,
     * otherwise the entity has to be removed using this method.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a logical network, or the association of a logical network to a data center.
     * 
     * For example, to remove the logical network `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/networks/123
     * ----
     * 
     * Each network is bound exactly to one data center. So if we disassociate network with data center it has the same
     * result as if we would just remove that network. However it might be more specific to say we're removing network
     * `456` of data center `123`.
     * 
     * For example, to remove the association of network `456` to data center `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/networks/456
     * ----
     * 
     * NOTE: To remove an external logical network, the network has to be removed directly from its provider by
     * https://developer.openstack.org/api-ref/network[OpenStack Networking API].
     * The entity representing the external network inside {product-name} is removed automatically,
     * if <<types/open_stack_network_provider/attributes/auto_sync,`auto_sync`>> is enabled for the provider,
     * otherwise the entity has to be removed using this method.
     */
    RemoveRequest remove();
    
    /**
     * Updates a logical network.
     * 
     * The `name`, `description`, `ip`, `vlan`, `stp` and `display` attributes can be updated.
     * 
     * For example, to update the description of the logical network `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/networks/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <description>My updated description</description>
     * </network>
     * ----
     * 
     * 
     * The maximum transmission unit of a network is set using a PUT request to
     * specify the integer value of the `mtu` attribute.
     * 
     * For example, to set the maximum transmission unit send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/networks/456
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <mtu>1500</mtu>
     * </network>
     * ----
     * 
     * NOTE: Updating external networks is not propagated to the provider.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest network(Network network);
        UpdateRequest network(NetworkBuilder network);
    }
    
    /**
     * Updates a logical network.
     * 
     * The `name`, `description`, `ip`, `vlan`, `stp` and `display` attributes can be updated.
     * 
     * For example, to update the description of the logical network `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/networks/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <description>My updated description</description>
     * </network>
     * ----
     * 
     * 
     * The maximum transmission unit of a network is set using a PUT request to
     * specify the integer value of the `mtu` attribute.
     * 
     * For example, to set the maximum transmission unit send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/networks/456
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <mtu>1500</mtu>
     * </network>
     * ----
     * 
     * NOTE: Updating external networks is not propagated to the provider.
     */
    public interface UpdateResponse extends Response {
        Network network();
    }
    
    /**
     * Updates a logical network.
     * 
     * The `name`, `description`, `ip`, `vlan`, `stp` and `display` attributes can be updated.
     * 
     * For example, to update the description of the logical network `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/networks/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <description>My updated description</description>
     * </network>
     * ----
     * 
     * 
     * The maximum transmission unit of a network is set using a PUT request to
     * specify the integer value of the `mtu` attribute.
     * 
     * For example, to set the maximum transmission unit send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/networks/456
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network>
     *   <mtu>1500</mtu>
     * </network>
     * ----
     * 
     * NOTE: Updating external networks is not propagated to the provider.
     */
    UpdateRequest update();
    
    /**
     * Reference to the service that manages the network labels assigned to this network.
     */
    NetworkLabelsService networkLabelsService();
    /**
     * Reference to the service that manages the permissions assigned to this network.
     */
    AssignedPermissionsService permissionsService();
    /**
     * Reference to the service that manages the vNIC profiles assigned to this network.
     */
    AssignedVnicProfilesService vnicProfilesService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

