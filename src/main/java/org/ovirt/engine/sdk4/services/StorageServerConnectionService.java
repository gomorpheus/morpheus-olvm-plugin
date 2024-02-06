/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.StorageConnectionBuilder;
import org.ovirt.engine.sdk4.types.StorageConnection;

public interface StorageServerConnectionService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        StorageConnection conection();
    }
    
    GetRequest get();
    
    /**
     * Update the specified Glusterfs storage connection in the system.
     */
    public interface UpdateGlusterfsRequest extends Request<UpdateGlusterfsRequest, UpdateGlusterfsResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateGlusterfsRequest async(Boolean async);
        UpdateGlusterfsRequest connection(StorageConnection connection);
        UpdateGlusterfsRequest connection(StorageConnectionBuilder connection);
        /**
         * Indicates if the operation should succeed regardless to the relevant storage domain's status
         * (i.e. updating is also applicable when storage domain's status is not maintenance).
         * 
         * This parameter is optional, and the default value is `false`.
         */
        UpdateGlusterfsRequest force(Boolean force);
    }
    
    /**
     * Update the specified Glusterfs storage connection in the system.
     */
    public interface UpdateGlusterfsResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Update the specified Glusterfs storage connection in the system.
     */
    UpdateGlusterfsRequest updateGlusterfs();
    
    /**
     * Update the specified iSCSI storage connection in the system.
     */
    public interface UpdateIscsiRequest extends Request<UpdateIscsiRequest, UpdateIscsiResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateIscsiRequest async(Boolean async);
        UpdateIscsiRequest connection(StorageConnection connection);
        UpdateIscsiRequest connection(StorageConnectionBuilder connection);
        /**
         * Indicates if the operation should succeed regardless to the relevant storage domain's status
         * (i.e. updating is also applicable when storage domain's status is not maintenance).
         * 
         * This parameter is optional, and the default value is `false`.
         */
        UpdateIscsiRequest force(Boolean force);
    }
    
    /**
     * Update the specified iSCSI storage connection in the system.
     */
    public interface UpdateIscsiResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Update the specified iSCSI storage connection in the system.
     */
    UpdateIscsiRequest updateIscsi();
    
    /**
     * Update the specified local storage connection in the system.
     */
    public interface UpdateLocalRequest extends Request<UpdateLocalRequest, UpdateLocalResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateLocalRequest async(Boolean async);
        UpdateLocalRequest connection(StorageConnection connection);
        UpdateLocalRequest connection(StorageConnectionBuilder connection);
        /**
         * Indicates if the operation should succeed regardless to the relevant storage domain's status
         * (i.e. updating is also applicable when storage domain's status is not maintenance).
         * 
         * This parameter is optional, and the default value is `false`.
         */
        UpdateLocalRequest force(Boolean force);
    }
    
    /**
     * Update the specified local storage connection in the system.
     */
    public interface UpdateLocalResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Update the specified local storage connection in the system.
     */
    UpdateLocalRequest updateLocal();
    
    /**
     * Update the specified NFS storage connection in the system.
     */
    public interface UpdateNfsRequest extends Request<UpdateNfsRequest, UpdateNfsResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateNfsRequest async(Boolean async);
        UpdateNfsRequest connection(StorageConnection connection);
        UpdateNfsRequest connection(StorageConnectionBuilder connection);
        /**
         * Indicates if the operation should succeed regardless to the relevant storage domain's status
         * (i.e. updating is also applicable when storage domain's status is not maintenance).
         * 
         * This parameter is optional, and the default value is `false`.
         */
        UpdateNfsRequest force(Boolean force);
    }
    
    /**
     * Update the specified NFS storage connection in the system.
     */
    public interface UpdateNfsResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Update the specified NFS storage connection in the system.
     */
    UpdateNfsRequest updateNfs();
    
    /**
     * Removes a storage connection.
     * 
     * A storage connection can only be deleted if neither storage domain nor LUN disks reference it. The host name or
     * id is optional; providing it disconnects (unmounts) the connection from that host.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
        /**
         * The name or identifier of the host from which the connection would be unmounted (disconnected). If not
         * provided, no host will be disconnected.
         * 
         * For example, to use the host with identifier `456` to delete the storage connection with identifier `123`
         * send a request like this:
         * 
         * [source]
         * ----
         * DELETE /ovirt-engine/api/storageconnections/123?host=456
         * ----
         */
        RemoveRequest host(String host);
    }
    
    /**
     * Removes a storage connection.
     * 
     * A storage connection can only be deleted if neither storage domain nor LUN disks reference it. The host name or
     * id is optional; providing it disconnects (unmounts) the connection from that host.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a storage connection.
     * 
     * A storage connection can only be deleted if neither storage domain nor LUN disks reference it. The host name or
     * id is optional; providing it disconnects (unmounts) the connection from that host.
     */
    RemoveRequest remove();
    
    /**
     * Updates the storage connection.
     * 
     * For example, to change the address of an NFS storage server, send a request like this:
     * 
     * [source,xml]
     * ----
     * PUT /ovirt-engine/api/storageconnections/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection>
     *   <address>mynewnfs.example.com</address>
     * </storage_connection>
     * ----
     * 
     * To change the connection of an iSCSI storage server, send a request like this:
     * 
     * [source,xml]
     * ----
     * PUT /ovirt-engine/api/storageconnections/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection>
     *   <port>3260</port>
     *   <target>iqn.2017-01.com.myhost:444</target>
     * </storage_connection>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest connection(StorageConnection connection);
        UpdateRequest connection(StorageConnectionBuilder connection);
        /**
         * Indicates if the operation should succeed regardless to the relevant storage domain's status
         * (i.e. updating is also applicable when storage domain's status is not maintenance).
         * 
         * This parameter is optional, and the default value is `false`.
         */
        UpdateRequest force(Boolean force);
    }
    
    /**
     * Updates the storage connection.
     * 
     * For example, to change the address of an NFS storage server, send a request like this:
     * 
     * [source,xml]
     * ----
     * PUT /ovirt-engine/api/storageconnections/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection>
     *   <address>mynewnfs.example.com</address>
     * </storage_connection>
     * ----
     * 
     * To change the connection of an iSCSI storage server, send a request like this:
     * 
     * [source,xml]
     * ----
     * PUT /ovirt-engine/api/storageconnections/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection>
     *   <port>3260</port>
     *   <target>iqn.2017-01.com.myhost:444</target>
     * </storage_connection>
     * ----
     */
    public interface UpdateResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Updates the storage connection.
     * 
     * For example, to change the address of an NFS storage server, send a request like this:
     * 
     * [source,xml]
     * ----
     * PUT /ovirt-engine/api/storageconnections/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection>
     *   <address>mynewnfs.example.com</address>
     * </storage_connection>
     * ----
     * 
     * To change the connection of an iSCSI storage server, send a request like this:
     * 
     * [source,xml]
     * ----
     * PUT /ovirt-engine/api/storageconnections/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection>
     *   <port>3260</port>
     *   <target>iqn.2017-01.com.myhost:444</target>
     * </storage_connection>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Update the specified VFS storage connection in the system.
     */
    public interface UpdateVfsRequest extends Request<UpdateVfsRequest, UpdateVfsResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateVfsRequest async(Boolean async);
        UpdateVfsRequest connection(StorageConnection connection);
        UpdateVfsRequest connection(StorageConnectionBuilder connection);
        /**
         * Indicates if the operation should succeed regardless to the relevant storage domain's status
         * (i.e. updating is also applicable when storage domain's status is not maintenance).
         * 
         * This parameter is optional, and the default value is `false`.
         */
        UpdateVfsRequest force(Boolean force);
    }
    
    /**
     * Update the specified VFS storage connection in the system.
     */
    public interface UpdateVfsResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Update the specified VFS storage connection in the system.
     */
    UpdateVfsRequest updateVfs();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

