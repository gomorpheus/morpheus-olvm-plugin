/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.StorageConnectionExtensionBuilder;
import org.ovirt.engine.sdk4.types.StorageConnectionExtension;

public interface StorageServerConnectionExtensionService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        StorageConnectionExtension extension();
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
     * Update a storage server connection extension for the given host.
     * 
     * To update the storage connection `456` of host `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/hosts/123/storageconnectionextensions/456
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection_extension>
     *   <target>iqn.2016-01.com.example:mytarget</target>
     *   <username>myuser</username>
     *   <password>mypassword</password>
     * </storage_connection_extension>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest extension(StorageConnectionExtension extension);
        UpdateRequest extension(StorageConnectionExtensionBuilder extension);
    }
    
    /**
     * Update a storage server connection extension for the given host.
     * 
     * To update the storage connection `456` of host `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/hosts/123/storageconnectionextensions/456
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection_extension>
     *   <target>iqn.2016-01.com.example:mytarget</target>
     *   <username>myuser</username>
     *   <password>mypassword</password>
     * </storage_connection_extension>
     * ----
     */
    public interface UpdateResponse extends Response {
        StorageConnectionExtension extension();
    }
    
    /**
     * Update a storage server connection extension for the given host.
     * 
     * To update the storage connection `456` of host `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/hosts/123/storageconnectionextensions/456
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection_extension>
     *   <target>iqn.2016-01.com.example:mytarget</target>
     *   <username>myuser</username>
     *   <password>mypassword</password>
     * </storage_connection_extension>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

