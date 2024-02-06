/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.DiskBuilder;
import org.ovirt.engine.sdk4.builders.DiskProfileBuilder;
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.QuotaBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskProfile;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.StorageDomain;

/**
 * Manages a single disk.
 */
public interface DiskService extends MeasurableService {
    /**
     * This operation copies a disk to the specified storage domain.
     * 
     * For example, a disk can be copied using the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks/123/copy
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <disk>
     *     <name>mydisk</name>
     *   </disk>
     * </action>
     * ----
     * 
     * If the disk profile or the quota currently used by the disk are not defined for the new storage domain, they
     * can be explicitly specified. If they are not specified, the first available disk profile and the default quota are used.
     * 
     * For example, to specify disk profile `987` and quota `753`, send a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <disk_profile id="987"/>
     *   <quota id="753"/>
     * </action>
     * ----
     */
    public interface CopyRequest extends Request<CopyRequest, CopyResponse> {
        /**
         * Indicates if the copy should be performed asynchronously.
         */
        CopyRequest async(Boolean async);
        CopyRequest disk(Disk disk);
        CopyRequest disk(DiskBuilder disk);
        CopyRequest diskProfile(DiskProfile diskProfile);
        /**
         * Disk profile for the disk in the new storage domain.
         * 
         * Disk profiles are defined for storage domains,
         * so the old disk profile will not exist in the new storage domain.
         * If this parameter is not used, the first disk profile from the new storage domain
         * to which the user has permissions will be assigned to the disk.
         */
        CopyRequest diskProfile(DiskProfileBuilder diskProfile);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        CopyRequest filter(Boolean filter);
        CopyRequest quota(Quota quota);
        /**
         * Quota for the disk in the new storage domain.
         * 
         * This optional parameter can be used to specify new quota for the disk,
         * because the current quota may not be defined for the new storage domain.
         * If this parameter is not used and the old quota is not defined for the new storage domain,
         * the default (unlimited) quota will be assigned to the disk.
         */
        CopyRequest quota(QuotaBuilder quota);
        CopyRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain where the new disk is created. This can be specified using the `id` or `name`
         * attributes. For example, to copy a disk to the storage domain called `mydata`, send a request like this:
         * 
         * ....
         * POST /ovirt-engine/api/storagedomains/123/disks/789
         * ....
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <action>
         *   <storage_domain>
         *     <name>mydata</name>
         *   </storage_domain>
         * </action>
         * ----
         */
        CopyRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * This operation copies a disk to the specified storage domain.
     * 
     * For example, a disk can be copied using the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks/123/copy
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <disk>
     *     <name>mydisk</name>
     *   </disk>
     * </action>
     * ----
     * 
     * If the disk profile or the quota currently used by the disk are not defined for the new storage domain, they
     * can be explicitly specified. If they are not specified, the first available disk profile and the default quota are used.
     * 
     * For example, to specify disk profile `987` and quota `753`, send a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <disk_profile id="987"/>
     *   <quota id="753"/>
     * </action>
     * ----
     */
    public interface CopyResponse extends Response {
    }
    
    /**
     * This operation copies a disk to the specified storage domain.
     * 
     * For example, a disk can be copied using the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks/123/copy
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <disk>
     *     <name>mydisk</name>
     *   </disk>
     * </action>
     * ----
     * 
     * If the disk profile or the quota currently used by the disk are not defined for the new storage domain, they
     * can be explicitly specified. If they are not specified, the first available disk profile and the default quota are used.
     * 
     * For example, to specify disk profile `987` and quota `753`, send a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <disk_profile id="987"/>
     *   <quota id="753"/>
     * </action>
     * ----
     */
    CopyRequest copy();
    
    /**
     * Exports a disk to an export storage domain.
     */
    public interface ExportRequest extends Request<ExportRequest, ExportResponse> {
        /**
         * Indicates if the export should be performed asynchronously.
         */
        ExportRequest async(Boolean async);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ExportRequest filter(Boolean filter);
        ExportRequest storageDomain(StorageDomain storageDomain);
        /**
         * The export storage domain where the disk will be exported to.
         */
        ExportRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Exports a disk to an export storage domain.
     */
    public interface ExportResponse extends Response {
    }
    
    /**
     * Exports a disk to an export storage domain.
     */
    ExportRequest export();
    
    /**
     * Retrieves the description of the disk.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if all of the attributes of the disk should be included in the response.
         * 
         * By default the following disk attributes are excluded:
         * 
         * - `vms`
         * 
         * For example, to retrieve the complete representation of disk '123':
         * 
         * ....
         * GET /ovirt-engine/api/disks/123?all_content=true
         * ....
         */
        GetRequest allContent(Boolean allContent);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves the description of the disk.
     */
    public interface GetResponse extends Response {
        /**
         * The description of the disk.
         */
        Disk disk();
    }
    
    /**
     * Retrieves the description of the disk.
     */
    GetRequest get();
    
    /**
     * Moves a disk to another storage domain.
     * 
     * For example, to move the disk with identifier `123` to a storage domain with identifier `456` send the following
     * request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks/123/move
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     * </action>
     * ----
     * 
     * If the disk profile or the quota used currently by
     * the disk aren't defined for the new storage domain,
     * then they can be explicitly specified. If they aren't
     * then the first available disk profile and the default
     * quota are used.
     * 
     * For example, to explicitly use disk profile `987` and
     * quota `753` send a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <disk_profile id="987"/>
     *   <quota id="753"/>
     * </action>
     * ----
     */
    public interface MoveRequest extends Request<MoveRequest, MoveResponse> {
        /**
         * Indicates if the move should be performed asynchronously.
         */
        MoveRequest async(Boolean async);
        MoveRequest diskProfile(DiskProfile diskProfile);
        /**
         * Disk profile for the disk in the new storage domain.
         * 
         * Disk profiles are defined for storage domains,
         * so the old disk profile will not exist in the new storage domain.
         * If this parameter is not used, the first disk profile from the new storage domain
         * to which the user has permissions will be assigned to the disk.
         */
        MoveRequest diskProfile(DiskProfileBuilder diskProfile);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        MoveRequest filter(Boolean filter);
        MoveRequest quota(Quota quota);
        /**
         * Quota for the disk in the new storage domain.
         * 
         * This optional parameter can be used to specify new quota for the disk,
         * because the current quota may not be defined for the new storage domain.
         * If this parameter is not used and the old quota is not defined for the new storage domain,
         * the default (unlimited) quota will be assigned to the disk.
         */
        MoveRequest quota(QuotaBuilder quota);
        MoveRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain where the disk will be moved to.
         */
        MoveRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Moves a disk to another storage domain.
     * 
     * For example, to move the disk with identifier `123` to a storage domain with identifier `456` send the following
     * request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks/123/move
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     * </action>
     * ----
     * 
     * If the disk profile or the quota used currently by
     * the disk aren't defined for the new storage domain,
     * then they can be explicitly specified. If they aren't
     * then the first available disk profile and the default
     * quota are used.
     * 
     * For example, to explicitly use disk profile `987` and
     * quota `753` send a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <disk_profile id="987"/>
     *   <quota id="753"/>
     * </action>
     * ----
     */
    public interface MoveResponse extends Response {
    }
    
    /**
     * Moves a disk to another storage domain.
     * 
     * For example, to move the disk with identifier `123` to a storage domain with identifier `456` send the following
     * request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks/123/move
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     * </action>
     * ----
     * 
     * If the disk profile or the quota used currently by
     * the disk aren't defined for the new storage domain,
     * then they can be explicitly specified. If they aren't
     * then the first available disk profile and the default
     * quota are used.
     * 
     * For example, to explicitly use disk profile `987` and
     * quota `753` send a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <disk_profile id="987"/>
     *   <quota id="753"/>
     * </action>
     * ----
     */
    MoveRequest move();
    
    /**
     * Reduces the size of the disk image.
     * 
     * Invokes _reduce_ on the logical volume (i.e. this is only applicable for block storage domains).
     * This is applicable for floating disks and disks attached to non-running virtual machines.
     * There is no need to specify the size as the optimal size is calculated automatically.
     */
    public interface ReduceRequest extends Request<ReduceRequest, ReduceResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        ReduceRequest async(Boolean async);
    }
    
    /**
     * Reduces the size of the disk image.
     * 
     * Invokes _reduce_ on the logical volume (i.e. this is only applicable for block storage domains).
     * This is applicable for floating disks and disks attached to non-running virtual machines.
     * There is no need to specify the size as the optimal size is calculated automatically.
     */
    public interface ReduceResponse extends Response {
    }
    
    /**
     * Reduces the size of the disk image.
     * 
     * Invokes _reduce_ on the logical volume (i.e. this is only applicable for block storage domains).
     * This is applicable for floating disks and disks attached to non-running virtual machines.
     * There is no need to specify the size as the optimal size is calculated automatically.
     */
    ReduceRequest reduce();
    
    /**
     * Refreshes a direct LUN disk with up-to-date information from the storage.
     * 
     * Refreshing a direct LUN disk is useful when:
     * 
     * - The LUN was added using the API without the host parameter, and therefore does not contain
     *   any information from the storage (see <<services/disks/methods/add, DisksService::add>>).
     * - New information about the LUN is available on the storage and you want to update the LUN with it.
     * 
     * To refresh direct LUN disk `123` using host `456`, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks/123/refreshlun
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <host id='456'/>
     * </action>
     * ----
     */
    public interface RefreshLunRequest extends Request<RefreshLunRequest, RefreshLunResponse> {
        RefreshLunRequest host(Host host);
        /**
         * The host that will be used to refresh the direct LUN disk.
         */
        RefreshLunRequest host(HostBuilder host);
    }
    
    /**
     * Refreshes a direct LUN disk with up-to-date information from the storage.
     * 
     * Refreshing a direct LUN disk is useful when:
     * 
     * - The LUN was added using the API without the host parameter, and therefore does not contain
     *   any information from the storage (see <<services/disks/methods/add, DisksService::add>>).
     * - New information about the LUN is available on the storage and you want to update the LUN with it.
     * 
     * To refresh direct LUN disk `123` using host `456`, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks/123/refreshlun
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <host id='456'/>
     * </action>
     * ----
     */
    public interface RefreshLunResponse extends Response {
    }
    
    /**
     * Refreshes a direct LUN disk with up-to-date information from the storage.
     * 
     * Refreshing a direct LUN disk is useful when:
     * 
     * - The LUN was added using the API without the host parameter, and therefore does not contain
     *   any information from the storage (see <<services/disks/methods/add, DisksService::add>>).
     * - New information about the LUN is available on the storage and you want to update the LUN with it.
     * 
     * To refresh direct LUN disk `123` using host `456`, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks/123/refreshlun
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <host id='456'/>
     * </action>
     * ----
     */
    RefreshLunRequest refreshLun();
    
    /**
     * Removes a disk.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes a disk.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a disk.
     */
    RemoveRequest remove();
    
    /**
     * Sparsify the disk.
     * 
     * Sparsification frees space in the disk image that is not used by its
     * filesystem. As a result, the image will occupy less space on the storage.
     * 
     * Currently sparsification works only on disks without snapshots. Disks
     * having derived disks are also not allowed.
     */
    public interface SparsifyRequest extends Request<SparsifyRequest, SparsifyResponse> {
    }
    
    /**
     * Sparsify the disk.
     * 
     * Sparsification frees space in the disk image that is not used by its
     * filesystem. As a result, the image will occupy less space on the storage.
     * 
     * Currently sparsification works only on disks without snapshots. Disks
     * having derived disks are also not allowed.
     */
    public interface SparsifyResponse extends Response {
    }
    
    /**
     * Sparsify the disk.
     * 
     * Sparsification frees space in the disk image that is not used by its
     * filesystem. As a result, the image will occupy less space on the storage.
     * 
     * Currently sparsification works only on disks without snapshots. Disks
     * having derived disks are also not allowed.
     */
    SparsifyRequest sparsify();
    
    /**
     * Updates the parameters of the specified disk.
     * 
     * This operation allows updating the following floating disk properties:
     * 
     * * For Image disks: `provisioned_size`, `alias`, `description`, `wipe_after_delete`, `shareable`, `backup` and `disk_profile`.
     * 
     * * For LUN disks: `alias`, `description` and `shareable`.
     * 
     * * Cinder integration has been replaced by Managed Block Storage.
     * 
     * * For Managed Block disks: `provisioned_size`, `alias` and `description`.
     * 
     * * For VM attached disks, the `qcow_version` can also be updated.
     * 
     * For example, a disk's update can be done by using the following request:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/disks/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <disk>
     *   <qcow_version>qcow2_v3</qcow_version>
     *   <alias>new-alias</alias>
     *   <description>new-desc</description>
     * </disk>
     * ----
     * 
     * Since the backend operation is asynchronous, the disk element that is returned
     * to the user might not be synced with the changed properties.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        UpdateRequest disk(Disk disk);
        /**
         * The update to apply to the disk.
         */
        UpdateRequest disk(DiskBuilder disk);
    }
    
    /**
     * Updates the parameters of the specified disk.
     * 
     * This operation allows updating the following floating disk properties:
     * 
     * * For Image disks: `provisioned_size`, `alias`, `description`, `wipe_after_delete`, `shareable`, `backup` and `disk_profile`.
     * 
     * * For LUN disks: `alias`, `description` and `shareable`.
     * 
     * * Cinder integration has been replaced by Managed Block Storage.
     * 
     * * For Managed Block disks: `provisioned_size`, `alias` and `description`.
     * 
     * * For VM attached disks, the `qcow_version` can also be updated.
     * 
     * For example, a disk's update can be done by using the following request:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/disks/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <disk>
     *   <qcow_version>qcow2_v3</qcow_version>
     *   <alias>new-alias</alias>
     *   <description>new-desc</description>
     * </disk>
     * ----
     * 
     * Since the backend operation is asynchronous, the disk element that is returned
     * to the user might not be synced with the changed properties.
     */
    public interface UpdateResponse extends Response {
        /**
         * The update to apply to the disk.
         */
        Disk disk();
    }
    
    /**
     * Updates the parameters of the specified disk.
     * 
     * This operation allows updating the following floating disk properties:
     * 
     * * For Image disks: `provisioned_size`, `alias`, `description`, `wipe_after_delete`, `shareable`, `backup` and `disk_profile`.
     * 
     * * For LUN disks: `alias`, `description` and `shareable`.
     * 
     * * Cinder integration has been replaced by Managed Block Storage.
     * 
     * * For Managed Block disks: `provisioned_size`, `alias` and `description`.
     * 
     * * For VM attached disks, the `qcow_version` can also be updated.
     * 
     * For example, a disk's update can be done by using the following request:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/disks/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <disk>
     *   <qcow_version>qcow2_v3</qcow_version>
     *   <alias>new-alias</alias>
     *   <description>new-desc</description>
     * </disk>
     * ----
     * 
     * Since the backend operation is asynchronous, the disk element that is returned
     * to the user might not be synced with the changed properties.
     */
    UpdateRequest update();
    
    /**
     * Reference to the service that manages the DiskSnapshots.
     * 
     * For example, to list all disk snapshots under the disks resource '123':
     * 
     * ....
     * GET /ovirt-engine/api/disks/123/disksnapshots
     * ....
     * 
     * For example, to retrieve a specific disk snapshot '789' under the disk resource '123':
     * ....
     * GET /ovirt-engine/api/disks/123/disksnapshots/789
     * ....
     */
    DiskSnapshotsService diskSnapshotsService();
    /**
     * Reference to the service that manages the permissions assigned to the disk.
     */
    AssignedPermissionsService permissionsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

