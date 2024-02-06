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
import org.ovirt.engine.sdk4.builders.OpenStackImageProviderBuilder;
import org.ovirt.engine.sdk4.types.OpenStackImageProvider;

public interface OpenstackImageProvidersService extends Service {
    /**
     * Add a new OpenStack image provider to the system.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest provider(OpenStackImageProvider provider);
        AddRequest provider(OpenStackImageProviderBuilder provider);
    }
    
    /**
     * Add a new OpenStack image provider to the system.
     */
    public interface AddResponse extends Response {
        OpenStackImageProvider provider();
    }
    
    /**
     * Add a new OpenStack image provider to the system.
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
         * A query string used to restrict the returned OpenStack image providers.
         */
        ListRequest search(String search);
    }
    
    /**
     * Returns the list of providers.
     * 
     * The order of the returned list of providers isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<OpenStackImageProvider> providers();
    }
    
    /**
     * Returns the list of providers.
     * 
     * The order of the returned list of providers isn't guaranteed.
     */
    ListRequest list();
    
    OpenstackImageProviderService providerService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

