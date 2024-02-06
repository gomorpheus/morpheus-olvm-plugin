/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.DiskBuilder;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Snapshot;

public interface SnapshotService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        Snapshot snapshot();
    }
    
    GetRequest get();
    
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if all the attributes of the virtual machine snapshot should be included in the response.
         * 
         * By default the attribute `initialization.configuration.data` is excluded.
         * 
         * For example, to retrieve the complete representation of the snapshot with id `456` of the virtual machine
         * with id `123` send a request like this:
         * 
         * ....
         * GET /ovirt-engine/api/vms/123/snapshots/456?all_content=true
         * ....
         */
        RemoveRequest allContent(Boolean allContent);
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    public interface RemoveResponse extends Response {
    }
    
    RemoveRequest remove();
    
    /**
     * Restores a virtual machine snapshot.
     * 
     * For example, to restore the snapshot with identifier `456` of virtual machine with identifier `123` send a
     * request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/snapshots/456/restore
     * ----
     * 
     * With an empty `action` in the body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * NOTE: Confirm that the commit operation is finished and the virtual machine is down before running the virtual machine.
     */
    public interface RestoreRequest extends Request<RestoreRequest, RestoreResponse> {
        /**
         * Indicates if the restore should be performed asynchronously.
         */
        RestoreRequest async(Boolean async);
        RestoreRequest disks(List<Disk> disks);
        /**
         * Specify the disks included in the snapshot's restore.
         * 
         * For each disk parameter, it is also required to specify its `image_id`.
         * 
         * For example, to restore a snapshot with an identifier `456` of a virtual machine with identifier `123`, including
         * a disk with identifier `111` and `image_id` of `222`, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/vms/123/snapshots/456/restore
         * ----
         * 
         * Request body:
         * 
         * [source,xml]
         * ----
         * <action>
         *   <disks>
         *     <disk id="111">
         *       <image_id>222</image_id>
         *     </disk>
         *   </disks>
         * </action>
         * ----
         */
        RestoreRequest disks(Disk... disks);
        /**
         * Specify the disks included in the snapshot's restore.
         * 
         * For each disk parameter, it is also required to specify its `image_id`.
         * 
         * For example, to restore a snapshot with an identifier `456` of a virtual machine with identifier `123`, including
         * a disk with identifier `111` and `image_id` of `222`, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/vms/123/snapshots/456/restore
         * ----
         * 
         * Request body:
         * 
         * [source,xml]
         * ----
         * <action>
         *   <disks>
         *     <disk id="111">
         *       <image_id>222</image_id>
         *     </disk>
         *   </disks>
         * </action>
         * ----
         */
        RestoreRequest disks(DiskBuilder... disks);
        RestoreRequest restoreMemory(Boolean restoreMemory);
    }
    
    /**
     * Restores a virtual machine snapshot.
     * 
     * For example, to restore the snapshot with identifier `456` of virtual machine with identifier `123` send a
     * request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/snapshots/456/restore
     * ----
     * 
     * With an empty `action` in the body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * NOTE: Confirm that the commit operation is finished and the virtual machine is down before running the virtual machine.
     */
    public interface RestoreResponse extends Response {
    }
    
    /**
     * Restores a virtual machine snapshot.
     * 
     * For example, to restore the snapshot with identifier `456` of virtual machine with identifier `123` send a
     * request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/snapshots/456/restore
     * ----
     * 
     * With an empty `action` in the body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * NOTE: Confirm that the commit operation is finished and the virtual machine is down before running the virtual machine.
     */
    RestoreRequest restore();
    
    SnapshotCdromsService cdromsService();
    SnapshotDisksService disksService();
    SnapshotNicsService nicsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

