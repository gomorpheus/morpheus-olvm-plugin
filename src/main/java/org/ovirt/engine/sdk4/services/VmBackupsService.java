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
import org.ovirt.engine.sdk4.builders.BackupBuilder;
import org.ovirt.engine.sdk4.types.Backup;

/**
 * Lists the backups of a virtual machine.
 */
public interface VmBackupsService extends Service {
    /**
     * Adds a new backup entity to a virtual machine.
     * 
     * For example, to start a new incremental backup of a virtual machine
     * since checkpoint id `previous-checkpoint-uuid`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/backups
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <backup>
     *   <from_checkpoint_id>previous-checkpoint-uuid</from_checkpoint_id>
     *   <disks>
     *       <disk id="disk-uuid" />
     *       ...
     *   </disks>
     * </backup>
     * ----
     * 
     * The response body:
     * 
     * [source,xml]
     * ----
     * <backup id="backup-uuid">
     *     <from_checkpoint_id>previous-checkpoint-uuid</from_checkpoint_id>
     *     <to_checkpoint_id>new-checkpoint-uuid</to_checkpoint_id>
     *     <disks>
     *         <disk id="disk-uuid" />
     *         ...
     *         ...
     *     </disks>
     *     <status>initializing</status>
     *     <creation_date>
     * </backup>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest backup(Backup backup);
        /**
         * The information about the virtual machine backup entity.
         */
        AddRequest backup(BackupBuilder backup);
        /**
         * Indicates if the backup will fail if VM failed to freeze or not.
         * 
         * If requireConsistency=True VM backup will fail in case of a
         * failure to freeze the VM.
         * 
         * The REST API call should look like this:
         * 
         * ....
         * POST /ovirt-engine/api/vms/123/backups?require_consistency=true
         * ....
         * 
         * The default value of the requireConsistency flag is `false`.
         */
        AddRequest requireConsistency(Boolean requireConsistency);
    }
    
    /**
     * Adds a new backup entity to a virtual machine.
     * 
     * For example, to start a new incremental backup of a virtual machine
     * since checkpoint id `previous-checkpoint-uuid`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/backups
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <backup>
     *   <from_checkpoint_id>previous-checkpoint-uuid</from_checkpoint_id>
     *   <disks>
     *       <disk id="disk-uuid" />
     *       ...
     *   </disks>
     * </backup>
     * ----
     * 
     * The response body:
     * 
     * [source,xml]
     * ----
     * <backup id="backup-uuid">
     *     <from_checkpoint_id>previous-checkpoint-uuid</from_checkpoint_id>
     *     <to_checkpoint_id>new-checkpoint-uuid</to_checkpoint_id>
     *     <disks>
     *         <disk id="disk-uuid" />
     *         ...
     *         ...
     *     </disks>
     *     <status>initializing</status>
     *     <creation_date>
     * </backup>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The information about the virtual machine backup entity.
         */
        Backup backup();
    }
    
    /**
     * Adds a new backup entity to a virtual machine.
     * 
     * For example, to start a new incremental backup of a virtual machine
     * since checkpoint id `previous-checkpoint-uuid`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/backups
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <backup>
     *   <from_checkpoint_id>previous-checkpoint-uuid</from_checkpoint_id>
     *   <disks>
     *       <disk id="disk-uuid" />
     *       ...
     *   </disks>
     * </backup>
     * ----
     * 
     * The response body:
     * 
     * [source,xml]
     * ----
     * <backup id="backup-uuid">
     *     <from_checkpoint_id>previous-checkpoint-uuid</from_checkpoint_id>
     *     <to_checkpoint_id>new-checkpoint-uuid</to_checkpoint_id>
     *     <disks>
     *         <disk id="disk-uuid" />
     *         ...
     *         ...
     *     </disks>
     *     <status>initializing</status>
     *     <creation_date>
     * </backup>
     * ----
     */
    AddRequest add();
    
    /**
     * The list of virtual machine backups.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of virtual machine backups to return. If not specified, all the virtual machine backups are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of virtual machine backups to return. If not specified, all the virtual machine backups are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of virtual machine backups to return. If not specified, all the virtual machine backups are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * The list of virtual machine backups.
     */
    public interface ListResponse extends Response {
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
         *     <status>initiailizing</status>
         *     <creation_date>
         *  </backup>
         * </backups>
         * ----
         */
        List<Backup> backups();
    }
    
    /**
     * The list of virtual machine backups.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific VM backup.
     */
    VmBackupService backupService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

