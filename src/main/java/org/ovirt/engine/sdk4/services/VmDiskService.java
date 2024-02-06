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
import org.ovirt.engine.sdk4.types.Disk;

public interface VmDiskService extends MeasurableService {
    public interface ActivateRequest extends Request<ActivateRequest, ActivateResponse> {
        /**
         * Indicates if the activation should be performed asynchronously.
         */
        ActivateRequest async(Boolean async);
    }
    
    public interface ActivateResponse extends Response {
    }
    
    ActivateRequest activate();
    
    public interface DeactivateRequest extends Request<DeactivateRequest, DeactivateResponse> {
        /**
         * Indicates if the deactivation should be performed asynchronously.
         */
        DeactivateRequest async(Boolean async);
    }
    
    public interface DeactivateResponse extends Response {
    }
    
    DeactivateRequest deactivate();
    
    public interface ExportRequest extends Request<ExportRequest, ExportResponse> {
        /**
         * Indicates if the export should be performed asynchronously.
         */
        ExportRequest async(Boolean async);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ExportRequest filter(Boolean filter);
    }
    
    public interface ExportResponse extends Response {
    }
    
    ExportRequest export();
    
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        Disk disk();
    }
    
    GetRequest get();
    
    public interface MoveRequest extends Request<MoveRequest, MoveResponse> {
        /**
         * Indicates if the move should be performed asynchronously.
         */
        MoveRequest async(Boolean async);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        MoveRequest filter(Boolean filter);
    }
    
    public interface MoveResponse extends Response {
    }
    
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
     * Detach the disk from the virtual machine.
     * 
     * NOTE: In version 3 of the API this used to also remove the disk completely from the system, but starting with
     * version 4 it doesn't. If you need to remove it completely use the <<services/disk/methods/remove,remove
     * method of the top level disk service>>.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Detach the disk from the virtual machine.
     * 
     * NOTE: In version 3 of the API this used to also remove the disk completely from the system, but starting with
     * version 4 it doesn't. If you need to remove it completely use the <<services/disk/methods/remove,remove
     * method of the top level disk service>>.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Detach the disk from the virtual machine.
     * 
     * NOTE: In version 3 of the API this used to also remove the disk completely from the system, but starting with
     * version 4 it doesn't. If you need to remove it completely use the <<services/disk/methods/remove,remove
     * method of the top level disk service>>.
     */
    RemoveRequest remove();
    
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest disk(Disk disk);
        UpdateRequest disk(DiskBuilder disk);
    }
    
    public interface UpdateResponse extends Response {
        Disk disk();
    }
    
    UpdateRequest update();
    
    AssignedPermissionsService permissionsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

