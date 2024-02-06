/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.VnicProfileBuilder;
import org.ovirt.engine.sdk4.types.VnicProfile;

/**
 * This service manages a vNIC profile.
 */
public interface VnicProfileService extends Service {
    /**
     * Retrieves details about a vNIC profile.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves details about a vNIC profile.
     */
    public interface GetResponse extends Response {
        VnicProfile profile();
    }
    
    /**
     * Retrieves details about a vNIC profile.
     */
    GetRequest get();
    
    /**
     * Removes the vNIC profile.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the vNIC profile.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the vNIC profile.
     */
    RemoveRequest remove();
    
    /**
     * Updates details of a vNIC profile.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest profile(VnicProfile profile);
        /**
         * The vNIC profile that is being updated.
         */
        UpdateRequest profile(VnicProfileBuilder profile);
    }
    
    /**
     * Updates details of a vNIC profile.
     */
    public interface UpdateResponse extends Response {
        /**
         * The vNIC profile that is being updated.
         */
        VnicProfile profile();
    }
    
    /**
     * Updates details of a vNIC profile.
     */
    UpdateRequest update();
    
    AssignedPermissionsService permissionsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

