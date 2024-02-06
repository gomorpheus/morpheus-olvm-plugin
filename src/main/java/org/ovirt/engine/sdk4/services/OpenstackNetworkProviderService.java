/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.OpenStackNetworkProviderBuilder;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProvider;

/**
 * This service manages the OpenStack network provider.
 */
public interface OpenstackNetworkProviderService extends ExternalProviderService {
    /**
     * Returns the representation of the object managed by this service.
     * 
     * For example, to get the OpenStack network provider with identifier `1234`, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/openstacknetworkproviders/1234
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
     * Returns the representation of the object managed by this service.
     * 
     * For example, to get the OpenStack network provider with identifier `1234`, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     */
    public interface GetResponse extends Response {
        OpenStackNetworkProvider provider();
    }
    
    /**
     * Returns the representation of the object managed by this service.
     * 
     * For example, to get the OpenStack network provider with identifier `1234`, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     */
    GetRequest get();
    
    /**
     * Removes the provider.
     * 
     * For example, to remove the OpenStack network provider with identifier `1234`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the provider.
     * 
     * For example, to remove the OpenStack network provider with identifier `1234`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the provider.
     * 
     * For example, to remove the OpenStack network provider with identifier `1234`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Updates the provider.
     * 
     * For example, to update `provider_name`, `requires_authentication`, `url`, `tenant_name` and `type` properties,
     * for the OpenStack network provider with identifier `1234`, send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <openstack_network_provider>
     *   <name>ovn-network-provider</name>
     *   <requires_authentication>false</requires_authentication>
     *   <url>http://some_server_url.domain.com:9696</url>
     *   <tenant_name>oVirt</tenant_name>
     *   <type>external</type>
     * </openstack_network_provider>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest provider(OpenStackNetworkProvider provider);
        /**
         * The provider to update.
         */
        UpdateRequest provider(OpenStackNetworkProviderBuilder provider);
    }
    
    /**
     * Updates the provider.
     * 
     * For example, to update `provider_name`, `requires_authentication`, `url`, `tenant_name` and `type` properties,
     * for the OpenStack network provider with identifier `1234`, send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <openstack_network_provider>
     *   <name>ovn-network-provider</name>
     *   <requires_authentication>false</requires_authentication>
     *   <url>http://some_server_url.domain.com:9696</url>
     *   <tenant_name>oVirt</tenant_name>
     *   <type>external</type>
     * </openstack_network_provider>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * The provider to update.
         */
        OpenStackNetworkProvider provider();
    }
    
    /**
     * Updates the provider.
     * 
     * For example, to update `provider_name`, `requires_authentication`, `url`, `tenant_name` and `type` properties,
     * for the OpenStack network provider with identifier `1234`, send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <openstack_network_provider>
     *   <name>ovn-network-provider</name>
     *   <requires_authentication>false</requires_authentication>
     *   <url>http://some_server_url.domain.com:9696</url>
     *   <tenant_name>oVirt</tenant_name>
     *   <type>external</type>
     * </openstack_network_provider>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Reference to OpenStack networks service.
     */
    OpenstackNetworksService networksService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

