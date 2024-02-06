/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.OpenStackVolumeProviderBuilder;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;

/**
 * Openstack Volume (Cinder) integration has been replaced by Managed Block Storage.
 */
public interface OpenstackVolumeProviderService extends ExternalProviderService {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        OpenStackVolumeProvider provider();
    }
    
    GetRequest get();
    
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
        /**
         * Indicates if the operation should succeed, and the provider removed from the database,
         * even if something fails during the operation.
         * 
         * This parameter is optional, and the default value is `false`.
         */
        RemoveRequest force(Boolean force);
    }
    
    public interface RemoveResponse extends Response {
    }
    
    RemoveRequest remove();
    
    /**
     * Update the specified OpenStack volume provider in the system.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest provider(OpenStackVolumeProvider provider);
        UpdateRequest provider(OpenStackVolumeProviderBuilder provider);
    }
    
    /**
     * Update the specified OpenStack volume provider in the system.
     */
    public interface UpdateResponse extends Response {
        OpenStackVolumeProvider provider();
    }
    
    /**
     * Update the specified OpenStack volume provider in the system.
     */
    UpdateRequest update();
    
    OpenstackVolumeAuthenticationKeysService authenticationKeysService();
    OpenstackVolumeTypesService volumeTypesService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

