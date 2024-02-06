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
import org.ovirt.engine.sdk4.builders.StorageConnectionExtensionBuilder;
import org.ovirt.engine.sdk4.types.StorageConnectionExtension;

public interface StorageServerConnectionExtensionsService extends Service {
    /**
     * Creates a new storage server connection extension for the given host.
     * 
     * The extension lets the user define credentials for an iSCSI target for a specific host. For example to use
     * `myuser` and `mypassword` as the credentials when connecting to the iSCSI target from host `123` send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/storageconnectionextensions
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
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest extension(StorageConnectionExtension extension);
        AddRequest extension(StorageConnectionExtensionBuilder extension);
    }
    
    /**
     * Creates a new storage server connection extension for the given host.
     * 
     * The extension lets the user define credentials for an iSCSI target for a specific host. For example to use
     * `myuser` and `mypassword` as the credentials when connecting to the iSCSI target from host `123` send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/storageconnectionextensions
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
    public interface AddResponse extends Response {
        StorageConnectionExtension extension();
    }
    
    /**
     * Creates a new storage server connection extension for the given host.
     * 
     * The extension lets the user define credentials for an iSCSI target for a specific host. For example to use
     * `myuser` and `mypassword` as the credentials when connecting to the iSCSI target from host `123` send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/storageconnectionextensions
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
    AddRequest add();
    
    /**
     * Returns the list os storage connection extensions.
     * 
     * The order of the returned list of storage connections isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of extensions to return. If not specified all the extensions are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of extensions to return. If not specified all the extensions are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of extensions to return. If not specified all the extensions are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list os storage connection extensions.
     * 
     * The order of the returned list of storage connections isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<StorageConnectionExtension> extensions();
    }
    
    /**
     * Returns the list os storage connection extensions.
     * 
     * The order of the returned list of storage connections isn't guaranteed.
     */
    ListRequest list();
    
    StorageServerConnectionExtensionService storageConnectionExtensionService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

