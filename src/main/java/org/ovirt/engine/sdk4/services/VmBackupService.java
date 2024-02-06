/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Backup;

/**
 * A service managing a backup of a virtual machines.
 */
public interface VmBackupService extends Service {
    /**
     * Finalize the virtual machine backup entity.
     * 
     * End backup, unlock resources, and perform cleanups.
     */
    public interface FinalizeRequest extends Request<FinalizeRequest, FinalizeResponse> {
    }
    
    /**
     * Finalize the virtual machine backup entity.
     * 
     * End backup, unlock resources, and perform cleanups.
     */
    public interface FinalizeResponse extends Response {
    }
    
    /**
     * Finalize the virtual machine backup entity.
     * 
     * End backup, unlock resources, and perform cleanups.
     */
    FinalizeRequest finalize_();
    
    /**
     * Returns information about the virtual machine backup.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns information about the virtual machine backup.
     */
    public interface GetResponse extends Response {
        /**
         * The information about the virtual machine backup entities.
         * 
         * [source,xml]
         * ----
         * <backups>
         *   <backup id="backup-uuid">
         *     <from_checkpoint_id>previous-checkpoint-uuid</from_checkpoint_id>
         *     <disks>
         *       <disk id="disk-uuid" />
         *       ...
         *       ...
         *     </disks>
         *     <status>initializing</status>
         *     <creation_date>
         *  </backup>
         * </backups>
         * ----
         */
        Backup backup();
    }
    
    /**
     * Returns information about the virtual machine backup.
     */
    GetRequest get();
    
    /**
     * A reference to the service that lists the disks in backup.
     */
    VmBackupDisksService disksService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

