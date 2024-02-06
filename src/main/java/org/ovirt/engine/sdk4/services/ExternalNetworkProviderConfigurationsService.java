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
import org.ovirt.engine.sdk4.types.ExternalNetworkProviderConfiguration;

/**
 * A service to list all external network providers provisioned by the system on the host.
 */
public interface ExternalNetworkProviderConfigurationsService extends Service {
    /**
     * Returns the list of all external network providers on the host.
     * 
     * The order of the returned list of networks is not guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * Returns the list of all external network providers on the host.
     * 
     * The order of the returned list of networks is not guaranteed.
     */
    public interface ListResponse extends Response {
        List<ExternalNetworkProviderConfiguration> configurations();
    }
    
    /**
     * Returns the list of all external network providers on the host.
     * 
     * The order of the returned list of networks is not guaranteed.
     */
    ListRequest list();
    
    ExternalNetworkProviderConfigurationService configurationService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

