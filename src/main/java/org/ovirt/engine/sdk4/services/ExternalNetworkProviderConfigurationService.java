/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.ExternalNetworkProviderConfiguration;

/**
 * Describes how an external network provider is provisioned by the system on the host.
 */
public interface ExternalNetworkProviderConfigurationService extends Service {
    /**
     * Returns the information about an external network provider on the host.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns the information about an external network provider on the host.
     */
    public interface GetResponse extends Response {
        ExternalNetworkProviderConfiguration configuration();
    }
    
    /**
     * Returns the information about an external network provider on the host.
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

