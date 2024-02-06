/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.NetworkFilterParameterBuilder;
import org.ovirt.engine.sdk4.types.NetworkFilterParameter;

/**
 * This service manages a parameter for a network filter.
 */
public interface NicNetworkFilterParameterService extends Service {
    /**
     * Retrieves a representation of the network filter parameter.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves a representation of the network filter parameter.
     */
    public interface GetResponse extends Response {
        /**
         * The representation of the network filter parameter.
         */
        NetworkFilterParameter parameter();
    }
    
    /**
     * Retrieves a representation of the network filter parameter.
     */
    GetRequest get();
    
    /**
     * Removes the filter parameter.
     * 
     * For example, to remove the filter parameter with id `123` on NIC `456` of virtual machine `789`
     * send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/789/nics/456/networkfilterparameters/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
    }
    
    /**
     * Removes the filter parameter.
     * 
     * For example, to remove the filter parameter with id `123` on NIC `456` of virtual machine `789`
     * send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/789/nics/456/networkfilterparameters/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the filter parameter.
     * 
     * For example, to remove the filter parameter with id `123` on NIC `456` of virtual machine `789`
     * send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/789/nics/456/networkfilterparameters/123
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Updates the network filter parameter.
     * 
     * For example, to update the network filter parameter having with with id `123` on NIC `456` of
     * virtual machine `789` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/789/nics/456/networkfilterparameters/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network_filter_parameter>
     *   <name>updatedName</name>
     *   <value>updatedValue</value>
     * </network_filter_parameter>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        UpdateRequest parameter(NetworkFilterParameter parameter);
        /**
         * The network filter parameter that is being updated.
         */
        UpdateRequest parameter(NetworkFilterParameterBuilder parameter);
    }
    
    /**
     * Updates the network filter parameter.
     * 
     * For example, to update the network filter parameter having with with id `123` on NIC `456` of
     * virtual machine `789` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/789/nics/456/networkfilterparameters/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network_filter_parameter>
     *   <name>updatedName</name>
     *   <value>updatedValue</value>
     * </network_filter_parameter>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * The network filter parameter that is being updated.
         */
        NetworkFilterParameter parameter();
    }
    
    /**
     * Updates the network filter parameter.
     * 
     * For example, to update the network filter parameter having with with id `123` on NIC `456` of
     * virtual machine `789` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/789/nics/456/networkfilterparameters/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network_filter_parameter>
     *   <name>updatedName</name>
     *   <value>updatedValue</value>
     * </network_filter_parameter>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

