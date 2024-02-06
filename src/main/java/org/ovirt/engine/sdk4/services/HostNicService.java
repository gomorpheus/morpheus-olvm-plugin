/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.HostNicVirtualFunctionsConfigurationBuilder;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.HostNicVirtualFunctionsConfiguration;

/**
 * A service to manage a network interface of a host.
 */
public interface HostNicService extends MeasurableService {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if all of the attributes of the host network interface should be included in the response.
         * 
         * By default the following attributes are excluded:
         * 
         * - `virtual_functions_configuration`
         * 
         * For example, to retrieve the complete representation network interface '456' of host '123':
         * 
         * ....
         * GET /ovirt-engine/api/hosts/123/nics/456?all_content=true
         * ....
         * 
         * NOTE: These attributes are not included by default because retrieving them impacts performance. They are
         * seldom used and require additional queries to the database. Use this parameter with caution and only when
         * specifically required.
         */
        GetRequest allContent(Boolean allContent);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        HostNic nic();
    }
    
    GetRequest get();
    
    /**
     * The action updates virtual function configuration in case the current resource represents an SR-IOV enabled NIC.
     * The input should be consisted of at least one of the following properties:
     * 
     * - `allNetworksAllowed`
     * - `numberOfVirtualFunctions`
     * 
     * Please see the `HostNicVirtualFunctionsConfiguration` type for the meaning of the properties.
     */
    public interface UpdateVirtualFunctionsConfigurationRequest extends Request<UpdateVirtualFunctionsConfigurationRequest, UpdateVirtualFunctionsConfigurationResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateVirtualFunctionsConfigurationRequest async(Boolean async);
        UpdateVirtualFunctionsConfigurationRequest virtualFunctionsConfiguration(HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration);
        UpdateVirtualFunctionsConfigurationRequest virtualFunctionsConfiguration(HostNicVirtualFunctionsConfigurationBuilder virtualFunctionsConfiguration);
    }
    
    /**
     * The action updates virtual function configuration in case the current resource represents an SR-IOV enabled NIC.
     * The input should be consisted of at least one of the following properties:
     * 
     * - `allNetworksAllowed`
     * - `numberOfVirtualFunctions`
     * 
     * Please see the `HostNicVirtualFunctionsConfiguration` type for the meaning of the properties.
     */
    public interface UpdateVirtualFunctionsConfigurationResponse extends Response {
    }
    
    /**
     * The action updates virtual function configuration in case the current resource represents an SR-IOV enabled NIC.
     * The input should be consisted of at least one of the following properties:
     * 
     * - `allNetworksAllowed`
     * - `numberOfVirtualFunctions`
     * 
     * Please see the `HostNicVirtualFunctionsConfiguration` type for the meaning of the properties.
     */
    UpdateVirtualFunctionsConfigurationRequest updateVirtualFunctionsConfiguration();
    
    /**
     * A reference to information elements received by LLDP on the NIC.
     */
    LinkLayerDiscoveryProtocolService linkLayerDiscoveryProtocolElementsService();
    /**
     * Reference to the service that manages the network attachments assigned to this network interface.
     */
    NetworkAttachmentsService networkAttachmentsService();
    /**
     * Reference to the service that manages the network labels assigned to this network interface.
     */
    NetworkLabelsService networkLabelsService();
    /**
     * Retrieves sub-collection resource of network labels that are allowed on an the virtual functions
     * in case that the current resource represents an SR-IOV physical function NIC.
     */
    NetworkLabelsService virtualFunctionAllowedLabelsService();
    /**
     * Retrieves sub-collection resource of networks that are allowed on an the virtual functions
     * in case that the current resource represents an SR-IOV physical function NIC.
     */
    VirtualFunctionAllowedNetworksService virtualFunctionAllowedNetworksService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

