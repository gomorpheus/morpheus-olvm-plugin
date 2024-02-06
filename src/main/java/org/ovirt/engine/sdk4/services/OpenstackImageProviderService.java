/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.OpenStackImageProviderBuilder;
import org.ovirt.engine.sdk4.types.OpenStackImageProvider;

public interface OpenstackImageProviderService extends ExternalProviderService {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        OpenStackImageProvider provider();
    }
    
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
     * Update the specified OpenStack image provider in the system.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest provider(OpenStackImageProvider provider);
        UpdateRequest provider(OpenStackImageProviderBuilder provider);
    }
    
    /**
     * Update the specified OpenStack image provider in the system.
     */
    public interface UpdateResponse extends Response {
        OpenStackImageProvider provider();
    }
    
    /**
     * Update the specified OpenStack image provider in the system.
     */
    UpdateRequest update();
    
    OpenstackImagesService imagesService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

