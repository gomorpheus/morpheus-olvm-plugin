/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Checkpoint;

/**
 * A service managing a checkpoint of a virtual machines.
 */
public interface VmCheckpointService extends Service {
    /**
     * Returns information about the virtual machine checkpoint.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns information about the virtual machine checkpoint.
     */
    public interface GetResponse extends Response {
        /**
         * The information about the virtual machine checkpoint entity.
         * 
         * [source,xml]
         * ----
         * <checkpoint id="checkpoint-uuid">
         *  <link href="/ovirt-engine/api/vms/vm-uuid/checkpoints/checkpoint-uuid/disks" rel="disks"/>
         *  <parent_id>parent-checkpoint-uuid</parent_id>
         *  <creation_date>xxx</creation_date>
         *  <vm href="/ovirt-engine/api/vms/vm-uuid" id="vm-uuid"/>
         * </checkpoint>
         * ----
         */
        Checkpoint checkpoint();
    }
    
    /**
     * Returns information about the virtual machine checkpoint.
     */
    GetRequest get();
    
    /**
     * Remove the virtual machine checkpoint entity.
     * 
     * Remove the checkpoint from libvirt and the database.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove the virtual machine checkpoint entity.
     * 
     * Remove the checkpoint from libvirt and the database.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove the virtual machine checkpoint entity.
     * 
     * Remove the checkpoint from libvirt and the database.
     */
    RemoveRequest remove();
    
    /**
     * A reference to the service that lists the disks in checkpoint.
     */
    VmCheckpointDisksService disksService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

