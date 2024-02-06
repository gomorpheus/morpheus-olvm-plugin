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
import org.ovirt.engine.sdk4.types.Disk;

/**
 * Manages the set of disks available in a storage domain.
 */
public interface StorageDomainContentDisksService extends Service {
    /**
     * Returns the list of disks available in the storage domain.
     * 
     * The order of the returned list of disks is guaranteed only if the `sortby` clause is included in
     * the `search` parameter.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of disks to return. If not specified all the disks are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of disks to return. If not specified all the disks are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of disks to return. If not specified all the disks are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned disks.
         */
        ListRequest search(String search);
    }
    
    /**
     * Returns the list of disks available in the storage domain.
     * 
     * The order of the returned list of disks is guaranteed only if the `sortby` clause is included in
     * the `search` parameter.
     */
    public interface ListResponse extends Response {
        List<Disk> disks();
    }
    
    /**
     * Returns the list of disks available in the storage domain.
     * 
     * The order of the returned list of disks is guaranteed only if the `sortby` clause is included in
     * the `search` parameter.
     */
    ListRequest list();
    
    StorageDomainContentDiskService diskService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

