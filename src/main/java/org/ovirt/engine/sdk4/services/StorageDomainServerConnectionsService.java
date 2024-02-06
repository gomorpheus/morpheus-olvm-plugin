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

/**
 * Manages the set of connections to storage servers that exist in a storage domain.
 */
public interface StorageDomainServerConnectionsService extends Service {
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest connection(StorageConnection connection);
        AddRequest connection(StorageConnectionBuilder connection);
    }
    
    public interface AddResponse extends Response {
        StorageConnection connection();
    }
    
    AddRequest add();
    
    /**
     * Returns the list of connections to storage servers that existin the storage domain.
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
     * Returns the list of connections to storage servers that existin the storage domain.
     * 
     * The order of the returned list of connections isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<StorageConnection> connections();
    }
    
    /**
     * Returns the list of connections to storage servers that existin the storage domain.
     * 
     * The order of the returned list of connections isn't guaranteed.
     */
    ListRequest list();
    
    StorageDomainServerConnectionService connectionService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

