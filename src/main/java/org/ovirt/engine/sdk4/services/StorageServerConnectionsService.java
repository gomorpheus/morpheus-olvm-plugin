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
import org.ovirt.engine.sdk4.builders.StorageConnectionBuilder;
import org.ovirt.engine.sdk4.types.StorageConnection;

public interface StorageServerConnectionsService extends Service {
    /**
     * Creates a new storage connection.
     * 
     * For example, to create a new storage connection for the NFS server `mynfs.example.com` and NFS share
     * `/export/mydata` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageconnections
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection>
     *   <type>nfs</type>
     *   <address>mynfs.example.com</address>
     *   <path>/export/mydata</path>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_connection>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest connection(StorageConnection connection);
        AddRequest connection(StorageConnectionBuilder connection);
    }
    
    /**
     * Creates a new storage connection.
     * 
     * For example, to create a new storage connection for the NFS server `mynfs.example.com` and NFS share
     * `/export/mydata` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageconnections
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection>
     *   <type>nfs</type>
     *   <address>mynfs.example.com</address>
     *   <path>/export/mydata</path>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_connection>
     * ----
     */
    public interface AddResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Creates a new storage connection.
     * 
     * For example, to create a new storage connection for the NFS server `mynfs.example.com` and NFS share
     * `/export/mydata` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageconnections
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_connection>
     *   <type>nfs</type>
     *   <address>mynfs.example.com</address>
     *   <path>/export/mydata</path>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_connection>
     * ----
     */
    AddRequest add();
    
    /**
     * Add a Glusterfs storage connection to the system.
     */
    public interface AddGlusterfsRequest extends Request<AddGlusterfsRequest, AddGlusterfsResponse> {
        AddGlusterfsRequest connection(StorageConnection connection);
        AddGlusterfsRequest connection(StorageConnectionBuilder connection);
    }
    
    /**
     * Add a Glusterfs storage connection to the system.
     */
    public interface AddGlusterfsResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Add a Glusterfs storage connection to the system.
     */
    AddGlusterfsRequest addGlusterfs();
    
    /**
     * Add a iSCSI storage connection to the system.
     */
    public interface AddIscsiRequest extends Request<AddIscsiRequest, AddIscsiResponse> {
        AddIscsiRequest connection(StorageConnection connection);
        AddIscsiRequest connection(StorageConnectionBuilder connection);
    }
    
    /**
     * Add a iSCSI storage connection to the system.
     */
    public interface AddIscsiResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Add a iSCSI storage connection to the system.
     */
    AddIscsiRequest addIscsi();
    
    /**
     * Returns the list of storage connections.
     * 
     * The order of the returned list of connections isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of connections to return. If not specified all the connections are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of connections to return. If not specified all the connections are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of connections to return. If not specified all the connections are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of storage connections.
     * 
     * The order of the returned list of connections isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<StorageConnection> connections();
    }
    
    /**
     * Returns the list of storage connections.
     * 
     * The order of the returned list of connections isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Add a local storage connection to the system.
     */
    public interface AddLocalRequest extends Request<AddLocalRequest, AddLocalResponse> {
        AddLocalRequest connection(StorageConnection connection);
        AddLocalRequest connection(StorageConnectionBuilder connection);
    }
    
    /**
     * Add a local storage connection to the system.
     */
    public interface AddLocalResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Add a local storage connection to the system.
     */
    AddLocalRequest addLocal();
    
    /**
     * Add a nfs storage connection to the system.
     */
    public interface AddNfsRequest extends Request<AddNfsRequest, AddNfsResponse> {
        AddNfsRequest connection(StorageConnection connection);
        AddNfsRequest connection(StorageConnectionBuilder connection);
    }
    
    /**
     * Add a nfs storage connection to the system.
     */
    public interface AddNfsResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Add a nfs storage connection to the system.
     */
    AddNfsRequest addNfs();
    
    /**
     * Add a vfs storage connection to the system.
     */
    public interface AddVfsRequest extends Request<AddVfsRequest, AddVfsResponse> {
        AddVfsRequest connection(StorageConnection connection);
        AddVfsRequest connection(StorageConnectionBuilder connection);
    }
    
    /**
     * Add a vfs storage connection to the system.
     */
    public interface AddVfsResponse extends Response {
        StorageConnection connection();
    }
    
    /**
     * Add a vfs storage connection to the system.
     */
    AddVfsRequest addVfs();
    
    StorageServerConnectionService storageConnectionService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

