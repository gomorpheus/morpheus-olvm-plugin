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
import org.ovirt.engine.sdk4.types.Checkpoint;

/**
 * Lists the checkpoints of a virtual machine.
 */
public interface VmCheckpointsService extends Service {
    /**
     * The list of virtual machine checkpoints.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of virtual machine checkpoints to return.
         * If not specified, all the virtual machine checkpoints are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of virtual machine checkpoints to return.
         * If not specified, all the virtual machine checkpoints are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of virtual machine checkpoints to return.
         * If not specified, all the virtual machine checkpoints are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * The list of virtual machine checkpoints.
     */
    public interface ListResponse extends Response {
        /**
         * The information about the virtual machine checkpoint entities.
         * 
         * [source,xml]
         * ----
         * <checkpoints>
         *   <checkpoint id="checkpoint-uuid">
         *     <link href="/ovirt-engine/api/vms/vm-uuid/checkpoints/checkpoint-uuid/disks" rel="disks"/>
         *     <parent_id>parent-checkpoint-uuid</parent_id>
         *     <creation_date>xxx</creation_date>
         *     <vm href="/ovirt-engine/api/vmsvm-uuid" id="vm-uuid"/>
         *  </checkpoint>
         * </checkpoints>
         * ----
         */
        List<Checkpoint> checkpoints();
    }
    
    /**
     * The list of virtual machine checkpoints.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific VM checkpoint.
     */
    VmCheckpointService checkpointService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

