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
import org.ovirt.engine.sdk4.builders.NetworkFilterParameterBuilder;
import org.ovirt.engine.sdk4.types.NetworkFilterParameter;

/**
 * This service manages a collection of parameters for network filters.
 */
public interface NicNetworkFilterParametersService extends Service {
    /**
     * Add a network filter parameter.
     * 
     * For example, to add the parameter for the network filter on NIC `456` of
     * virtual machine `789` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/789/nics/456/networkfilterparameters
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network_filter_parameter>
     *   <name>IP</name>
     *   <value>10.0.1.2</value>
     * </network_filter_parameter>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest parameter(NetworkFilterParameter parameter);
        /**
         * The network filter parameter that is being added.
         */
        AddRequest parameter(NetworkFilterParameterBuilder parameter);
    }
    
    /**
     * Add a network filter parameter.
     * 
     * For example, to add the parameter for the network filter on NIC `456` of
     * virtual machine `789` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/789/nics/456/networkfilterparameters
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network_filter_parameter>
     *   <name>IP</name>
     *   <value>10.0.1.2</value>
     * </network_filter_parameter>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The network filter parameter that is being added.
         */
        NetworkFilterParameter parameter();
    }
    
    /**
     * Add a network filter parameter.
     * 
     * For example, to add the parameter for the network filter on NIC `456` of
     * virtual machine `789` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/789/nics/456/networkfilterparameters
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network_filter_parameter>
     *   <name>IP</name>
     *   <value>10.0.1.2</value>
     * </network_filter_parameter>
     * ----
     */
    AddRequest add();
    
    /**
     * Retrieves the representations of the network filter parameters.
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
     * Retrieves the representations of the network filter parameters.
     * 
     * The order of the returned list of network filters isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of the network filter parameters.
         */
        List<NetworkFilterParameter> parameters();
    }
    
    /**
     * Retrieves the representations of the network filter parameters.
     * 
     * The order of the returned list of network filters isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific network filter parameter.
     */
    NicNetworkFilterParameterService parameterService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

