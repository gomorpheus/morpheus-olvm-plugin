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
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.StorageDomain;

/**
 * Manages a single disk available in a storage domain.
 * 
 * IMPORTANT: Since version 4.2 of the engine this service is intended only to list disks available in the storage
 * domain, and to register unregistered disks. All the other operations, like copying a disk, moving a disk, etc, have
 * been deprecated and will be removed in the future. To perform those operations use the <<services/disks, service
 * that manages all the disks of the system>>, or the <<services/disk, service that manages an specific disk>>.
 */
public interface StorageDomainDiskService extends MeasurableService {
    /**
     * Copies a disk to the specified storage domain.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To copy a disk use the <<services/disk/methods/copy, copy>>
     * operation of the service that manages that disk.
     */
    public interface CopyRequest extends Request<CopyRequest, CopyResponse> {
        CopyRequest disk(Disk disk);
        /**
         * Description of the resulting disk.
         */
        CopyRequest disk(DiskBuilder disk);
        CopyRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain where the new disk will be created.
         */
        CopyRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Copies a disk to the specified storage domain.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To copy a disk use the <<services/disk/methods/copy, copy>>
     * operation of the service that manages that disk.
     */
    public interface CopyResponse extends Response {
    }
    
    /**
     * Copies a disk to the specified storage domain.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To copy a disk use the <<services/disk/methods/copy, copy>>
     * operation of the service that manages that disk.
     */
    CopyRequest copy();
    
    /**
     * Exports a disk to an export storage domain.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To export a disk use the <<services/disk/methods/export, export>>
     * operation of the service that manages that disk.
     */
    public interface ExportRequest extends Request<ExportRequest, ExportResponse> {
        ExportRequest storageDomain(StorageDomain storageDomain);
        /**
         * The export storage domain where the disk should be exported to.
         */
        ExportRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Exports a disk to an export storage domain.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To export a disk use the <<services/disk/methods/export, export>>
     * operation of the service that manages that disk.
     */
    public interface ExportResponse extends Response {
    }
    
    /**
     * Exports a disk to an export storage domain.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To export a disk use the <<services/disk/methods/export, export>>
     * operation of the service that manages that disk.
     */
    ExportRequest export();
    
    /**
     * Retrieves the description of the disk.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
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
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To move a disk use the <<services/disk/methods/move, move>>
     * operation of the service that manages that disk.
     */
    public interface MoveRequest extends Request<MoveRequest, MoveResponse> {
        /**
         * Indicates if the move should be performed asynchronously.
         */
        MoveRequest async(Boolean async);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        MoveRequest filter(Boolean filter);
        MoveRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain where the disk will be moved to.
         */
        MoveRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Moves a disk to another storage domain.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To move a disk use the <<services/disk/methods/move, move>>
     * operation of the service that manages that disk.
     */
    public interface MoveResponse extends Response {
    }
    
    /**
     * Moves a disk to another storage domain.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To move a disk use the <<services/disk/methods/move, move>>
     * operation of the service that manages that disk.
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
     * Removes a disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To remove a disk use the <<services/disk/methods/remove, remove>>
     * operation of the service that manages that disk.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
    }
    
    /**
     * Removes a disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To remove a disk use the <<services/disk/methods/remove, remove>>
     * operation of the service that manages that disk.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To remove a disk use the <<services/disk/methods/remove, remove>>
     * operation of the service that manages that disk.
     */
    RemoveRequest remove();
    
    /**
     * Sparsify the disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To remove a disk use the <<services/disk/methods/remove, remove>>
     * operation of the service that manages that disk.
     */
    public interface SparsifyRequest extends Request<SparsifyRequest, SparsifyResponse> {
    }
    
    /**
     * Sparsify the disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To remove a disk use the <<services/disk/methods/remove, remove>>
     * operation of the service that manages that disk.
     */
    public interface SparsifyResponse extends Response {
    }
    
    /**
     * Sparsify the disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To remove a disk use the <<services/disk/methods/remove, remove>>
     * operation of the service that manages that disk.
     */
    SparsifyRequest sparsify();
    
    /**
     * Updates the disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To update a disk use the
     * <<services/disk/methods/update, update>> operation of the service that manages that disk.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        UpdateRequest disk(Disk disk);
        /**
         * The update to apply to the disk.
         */
        UpdateRequest disk(DiskBuilder disk);
    }
    
    /**
     * Updates the disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To update a disk use the
     * <<services/disk/methods/update, update>> operation of the service that manages that disk.
     */
    public interface UpdateResponse extends Response {
        /**
         * The update to apply to the disk.
         */
        Disk disk();
    }
    
    /**
     * Updates the disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To update a disk use the
     * <<services/disk/methods/update, update>> operation of the service that manages that disk.
     */
    UpdateRequest update();
    
    /**
     * Reference to the service that manages the permissions assigned to the disk.
     */
    AssignedPermissionsService permissionsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

