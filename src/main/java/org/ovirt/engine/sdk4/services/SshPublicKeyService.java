/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.SshPublicKeyBuilder;
import org.ovirt.engine.sdk4.types.SshPublicKey;

public interface SshPublicKeyService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        SshPublicKey key();
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
     * Replaces the key with a new resource.
     * 
     * IMPORTANT: Since version 4.4.8 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. Instead please use DELETE followed by <<services/ssh_public_keys/methods/add, add operation>>.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest key(SshPublicKey key);
        UpdateRequest key(SshPublicKeyBuilder key);
    }
    
    /**
     * Replaces the key with a new resource.
     * 
     * IMPORTANT: Since version 4.4.8 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. Instead please use DELETE followed by <<services/ssh_public_keys/methods/add, add operation>>.
     */
    public interface UpdateResponse extends Response {
        SshPublicKey key();
    }
    
    /**
     * Replaces the key with a new resource.
     * 
     * IMPORTANT: Since version 4.4.8 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. Instead please use DELETE followed by <<services/ssh_public_keys/methods/add, add operation>>.
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

