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
import org.ovirt.engine.sdk4.builders.SnapshotBuilder;
import org.ovirt.engine.sdk4.types.Snapshot;

/**
 * Manages the set of snapshots of a storage domain or virtual machine.
 */
public interface SnapshotsService extends Service {
    /**
     * Creates a virtual machine snapshot.
     * 
     * For example, to create a new snapshot for virtual machine `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/snapshots
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <snapshot>
     *   <description>My snapshot</description>
     * </snapshot>
     * ----
     * 
     * For including only a sub-set of disks in the snapshots, add `disk_attachments` element to the
     * request body. Note that disks which are not specified in `disk_attachments` element will not be a
     * part of the snapshot. If an empty `disk_attachments` element is passed, the snapshot will include
     * only the virtual machine configuration. If no `disk_attachments` element is passed, then all
     * the disks will be included in the snapshot.
     * 
     * For each disk, `image_id` element can be specified for setting the new active image id.
     * This is used in order to restore a chain of images from backup. I.e. when restoring
     * a disk with snapshots, the relevant `image_id` should be specified for each snapshot
     * (so the identifiers of the disk snapshots are identical to the backup).
     * 
     * [source,xml]
     * ----
     * <snapshot>
     *   <description>My snapshot</description>
     *   <disk_attachments>
     *     <disk_attachment>
     *       <disk id="123">
     *         <image_id>456</image_id>
     *       </disk>
     *     </disk_attachment>
     *   </disk_attachments>
     * </snapshot>
     * ----
     * 
     * [IMPORTANT]
     * ====
     * When a snapshot is created the default value for the <<types/snapshot/attributes/persist_memorystate,
     * persist_memorystate>> attribute is `true`. That means that the content of the memory of the virtual
     * machine will be included in the snapshot, and it also means that the virtual machine will be paused
     * for a longer time. That can negatively affect applications that are very sensitive to timing (NTP
     * servers, for example). In those cases make sure that you set the attribute to `false`:
     * 
     * [source,xml]
     * ----
     * <snapshot>
     *   <description>My snapshot</description>
     *   <persist_memorystate>false</persist_memorystate>
     * </snapshot>
     * ----
     * ====
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest snapshot(Snapshot snapshot);
        AddRequest snapshot(SnapshotBuilder snapshot);
    }
    
    /**
     * Creates a virtual machine snapshot.
     * 
     * For example, to create a new snapshot for virtual machine `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/snapshots
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <snapshot>
     *   <description>My snapshot</description>
     * </snapshot>
     * ----
     * 
     * For including only a sub-set of disks in the snapshots, add `disk_attachments` element to the
     * request body. Note that disks which are not specified in `disk_attachments` element will not be a
     * part of the snapshot. If an empty `disk_attachments` element is passed, the snapshot will include
     * only the virtual machine configuration. If no `disk_attachments` element is passed, then all
     * the disks will be included in the snapshot.
     * 
     * For each disk, `image_id` element can be specified for setting the new active image id.
     * This is used in order to restore a chain of images from backup. I.e. when restoring
     * a disk with snapshots, the relevant `image_id` should be specified for each snapshot
     * (so the identifiers of the disk snapshots are identical to the backup).
     * 
     * [source,xml]
     * ----
     * <snapshot>
     *   <description>My snapshot</description>
     *   <disk_attachments>
     *     <disk_attachment>
     *       <disk id="123">
     *         <image_id>456</image_id>
     *       </disk>
     *     </disk_attachment>
     *   </disk_attachments>
     * </snapshot>
     * ----
     * 
     * [IMPORTANT]
     * ====
     * When a snapshot is created the default value for the <<types/snapshot/attributes/persist_memorystate,
     * persist_memorystate>> attribute is `true`. That means that the content of the memory of the virtual
     * machine will be included in the snapshot, and it also means that the virtual machine will be paused
     * for a longer time. That can negatively affect applications that are very sensitive to timing (NTP
     * servers, for example). In those cases make sure that you set the attribute to `false`:
     * 
     * [source,xml]
     * ----
     * <snapshot>
     *   <description>My snapshot</description>
     *   <persist_memorystate>false</persist_memorystate>
     * </snapshot>
     * ----
     * ====
     */
    public interface AddResponse extends Response {
        Snapshot snapshot();
    }
    
    /**
     * Creates a virtual machine snapshot.
     * 
     * For example, to create a new snapshot for virtual machine `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/snapshots
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <snapshot>
     *   <description>My snapshot</description>
     * </snapshot>
     * ----
     * 
     * For including only a sub-set of disks in the snapshots, add `disk_attachments` element to the
     * request body. Note that disks which are not specified in `disk_attachments` element will not be a
     * part of the snapshot. If an empty `disk_attachments` element is passed, the snapshot will include
     * only the virtual machine configuration. If no `disk_attachments` element is passed, then all
     * the disks will be included in the snapshot.
     * 
     * For each disk, `image_id` element can be specified for setting the new active image id.
     * This is used in order to restore a chain of images from backup. I.e. when restoring
     * a disk with snapshots, the relevant `image_id` should be specified for each snapshot
     * (so the identifiers of the disk snapshots are identical to the backup).
     * 
     * [source,xml]
     * ----
     * <snapshot>
     *   <description>My snapshot</description>
     *   <disk_attachments>
     *     <disk_attachment>
     *       <disk id="123">
     *         <image_id>456</image_id>
     *       </disk>
     *     </disk_attachment>
     *   </disk_attachments>
     * </snapshot>
     * ----
     * 
     * [IMPORTANT]
     * ====
     * When a snapshot is created the default value for the <<types/snapshot/attributes/persist_memorystate,
     * persist_memorystate>> attribute is `true`. That means that the content of the memory of the virtual
     * machine will be included in the snapshot, and it also means that the virtual machine will be paused
     * for a longer time. That can negatively affect applications that are very sensitive to timing (NTP
     * servers, for example). In those cases make sure that you set the attribute to `false`:
     * 
     * [source,xml]
     * ----
     * <snapshot>
     *   <description>My snapshot</description>
     *   <persist_memorystate>false</persist_memorystate>
     * </snapshot>
     * ----
     * ====
     */
    AddRequest add();
    
    /**
     * Returns the list of snapshots of the storage domain or virtual machine.
     * 
     * The order of the returned list of snapshots isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if all the attributes of the virtual machine snapshot should be included in the response.
         * 
         * By default the attribute `initialization.configuration.data` is excluded.
         * 
         * For example, to retrieve the complete representation of the virtual machine with id `123` snapshots send a
         * request like this:
         * 
         * ....
         * GET /ovirt-engine/api/vms/123/snapshots?all_content=true
         * ....
         */
        ListRequest allContent(Boolean allContent);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
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
     * Returns the list of snapshots of the storage domain or virtual machine.
     * 
     * The order of the returned list of snapshots isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Snapshot> snapshots();
    }
    
    /**
     * Returns the list of snapshots of the storage domain or virtual machine.
     * 
     * The order of the returned list of snapshots isn't guaranteed.
     */
    ListRequest list();
    
    SnapshotService snapshotService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

