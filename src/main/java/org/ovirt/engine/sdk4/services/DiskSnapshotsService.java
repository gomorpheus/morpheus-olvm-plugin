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
import org.ovirt.engine.sdk4.types.DiskSnapshot;

/**
 * Manages the collection of disk snapshots available in an storage domain.
 */
public interface DiskSnapshotsService extends Service {
    /**
     * Returns the list of disk snapshots of the storage domain.
     * 
     * The order of the returned list of disk snapshots isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * If true return also active snapshots. If not specified active snapshots are not returned.
         */
        ListRequest includeActive(Boolean includeActive);
        /**
         * If true return also template snapshots. If not specified template snapshots are not returned.
         */
        ListRequest includeTemplate(Boolean includeTemplate);
        /**
         * Sets the maximum number of snapshots to return. If not specified all the snapshots are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of snapshots to return. If not specified all the snapshots are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of snapshots to return. If not specified all the snapshots are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of disk snapshots of the storage domain.
     * 
     * The order of the returned list of disk snapshots isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<DiskSnapshot> snapshots();
    }
    
    /**
     * Returns the list of disk snapshots of the storage domain.
     * 
     * The order of the returned list of disk snapshots isn't guaranteed.
     */
    ListRequest list();
    
    DiskSnapshotService snapshotService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

