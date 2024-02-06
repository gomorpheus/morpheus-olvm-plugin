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
import org.ovirt.engine.sdk4.types.ExternalProvider;

/**
 * This service lists external providers.
 */
public interface ClusterExternalProvidersService extends Service {
    /**
     * Returns the list of external providers.
     * 
     * The order of the returned list of providers is not guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * Returns the list of external providers.
     * 
     * The order of the returned list of providers is not guaranteed.
     */
    public interface ListResponse extends Response {
        List<ExternalProvider> providers();
    }
    
    /**
     * Returns the list of external providers.
     * 
     * The order of the returned list of providers is not guaranteed.
     */
    ListRequest list();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

