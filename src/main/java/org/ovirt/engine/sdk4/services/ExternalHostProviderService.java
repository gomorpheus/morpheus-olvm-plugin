/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ExternalHostProviderBuilder;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

/**
 * Represents an external host provider, such as Foreman or Satellite.
 * 
 * See https://www.theforeman.org/ for more details on Foreman.
 * See https://access.redhat.com/products/red-hat-satellite for more details on Red Hat Satellite.
 */
public interface ExternalHostProviderService extends ExternalProviderService {
    /**
     * Get external host provider information
     * 
     * Host provider, Foreman or Satellite, can be set as an external provider in ovirt. To see details about specific
     * host providers attached to ovirt use this API.
     * 
     * For example, to get the details of host provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123
     * ....
     * 
     * The response will be like this:
     * 
     * [source,xml]
     * ----
     * <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123">
     *   <name>mysatellite</name>
     *   <requires_authentication>true</requires_authentication>
     *   <url>https://mysatellite.example.com</url>
     *   <username>admin</username>
     * </external_host_provider>
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
     * Get external host provider information
     * 
     * Host provider, Foreman or Satellite, can be set as an external provider in ovirt. To see details about specific
     * host providers attached to ovirt use this API.
     * 
     * For example, to get the details of host provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123
     * ....
     * 
     * The response will be like this:
     * 
     * [source,xml]
     * ----
     * <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123">
     *   <name>mysatellite</name>
     *   <requires_authentication>true</requires_authentication>
     *   <url>https://mysatellite.example.com</url>
     *   <username>admin</username>
     * </external_host_provider>
     * ----
     */
    public interface GetResponse extends Response {
        ExternalHostProvider provider();
    }
    
    /**
     * Get external host provider information
     * 
     * Host provider, Foreman or Satellite, can be set as an external provider in ovirt. To see details about specific
     * host providers attached to ovirt use this API.
     * 
     * For example, to get the details of host provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123
     * ....
     * 
     * The response will be like this:
     * 
     * [source,xml]
     * ----
     * <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123">
     *   <name>mysatellite</name>
     *   <requires_authentication>true</requires_authentication>
     *   <url>https://mysatellite.example.com</url>
     *   <username>admin</username>
     * </external_host_provider>
     * ----
     */
    GetRequest get();
    
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    public interface RemoveResponse extends Response {
    }
    
    RemoveRequest remove();
    
    /**
     * Update the specified external host provider in the system.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest provider(ExternalHostProvider provider);
        UpdateRequest provider(ExternalHostProviderBuilder provider);
    }
    
    /**
     * Update the specified external host provider in the system.
     */
    public interface UpdateResponse extends Response {
        ExternalHostProvider provider();
    }
    
    /**
     * Update the specified external host provider in the system.
     */
    UpdateRequest update();
    
    ExternalComputeResourcesService computeResourcesService();
    ExternalDiscoveredHostsService discoveredHostsService();
    ExternalHostGroupsService hostGroupsService();
    ExternalHostsService hostsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

