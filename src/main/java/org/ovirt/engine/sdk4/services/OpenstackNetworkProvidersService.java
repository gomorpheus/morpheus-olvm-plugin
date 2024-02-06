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
import org.ovirt.engine.sdk4.builders.OpenStackNetworkProviderBuilder;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProvider;

/**
 * This service manages OpenStack network providers.
 */
public interface OpenstackNetworkProvidersService extends Service {
    /**
     * The operation adds a new network provider to the system.
     * If the `type` property is not present, a default value of `NEUTRON` will be used.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest provider(OpenStackNetworkProvider provider);
        AddRequest provider(OpenStackNetworkProviderBuilder provider);
    }
    
    /**
     * The operation adds a new network provider to the system.
     * If the `type` property is not present, a default value of `NEUTRON` will be used.
     */
    public interface AddResponse extends Response {
        OpenStackNetworkProvider provider();
    }
    
    /**
     * The operation adds a new network provider to the system.
     * If the `type` property is not present, a default value of `NEUTRON` will be used.
     */
    AddRequest add();
    
    /**
     * Returns the list of providers.
     * 
     * The order of the returned list of providers isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of providers to return. If not specified all the providers are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of providers to return. If not specified all the providers are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of providers to return. If not specified all the providers are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned OpenStack network providers.
         */
        ListRequest search(String search);
    }
    
    /**
     * Returns the list of providers.
     * 
     * The order of the returned list of providers isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<OpenStackNetworkProvider> providers();
    }
    
    /**
     * Returns the list of providers.
     * 
     * The order of the returned list of providers isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to OpenStack network provider service.
     */
    OpenstackNetworkProviderService providerService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

