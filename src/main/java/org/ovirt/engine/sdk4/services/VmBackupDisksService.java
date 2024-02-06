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

public interface VmBackupDisksService extends Service {
    /**
     * Returns the list of disks in backup.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of disks to return. If not specified, all the disks are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of disks to return. If not specified, all the disks are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of disks to return. If not specified, all the disks are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of disks in backup.
     */
    public interface ListResponse extends Response {
        /**
         * The list of retrieved disks.
         */
        List<Disk> disks();
    }
    
    /**
     * Returns the list of disks in backup.
     */
    ListRequest list();
    
    /**
     * A reference to the service that manages a specific disk.
     */
    VmBackupDiskService diskService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

