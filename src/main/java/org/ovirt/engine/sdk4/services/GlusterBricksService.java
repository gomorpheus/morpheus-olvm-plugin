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
import org.ovirt.engine.sdk4.builders.GlusterBrickBuilder;
import org.ovirt.engine.sdk4.types.GlusterBrick;

/**
 * This service manages the gluster bricks in a gluster volume
 */
public interface GlusterBricksService extends Service {
    /**
     * Activate the bricks post data migration of remove brick operation.
     * 
     * Used to activate brick(s) once the data migration from bricks is complete but user no longer wishes to remove
     * bricks. The bricks that were previously marked for removal will now be used as normal bricks.
     * 
     * For example, to retain the bricks that on glustervolume `123` from which data was migrated, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks/activate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <bricks>
     *     <brick>
     *       <name>host1:/rhgs/brick1</name>
     *     </brick>
     *   </bricks>
     * </action>
     * ----
     */
    public interface ActivateRequest extends Request<ActivateRequest, ActivateResponse> {
        /**
         * Indicates if the activation should be performed asynchronously.
         */
        ActivateRequest async(Boolean async);
        ActivateRequest bricks(List<GlusterBrick> bricks);
        /**
         * The list of bricks that need to be re-activated.
         */
        ActivateRequest bricks(GlusterBrick... bricks);
        /**
         * The list of bricks that need to be re-activated.
         */
        ActivateRequest bricks(GlusterBrickBuilder... bricks);
    }
    
    /**
     * Activate the bricks post data migration of remove brick operation.
     * 
     * Used to activate brick(s) once the data migration from bricks is complete but user no longer wishes to remove
     * bricks. The bricks that were previously marked for removal will now be used as normal bricks.
     * 
     * For example, to retain the bricks that on glustervolume `123` from which data was migrated, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks/activate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <bricks>
     *     <brick>
     *       <name>host1:/rhgs/brick1</name>
     *     </brick>
     *   </bricks>
     * </action>
     * ----
     */
    public interface ActivateResponse extends Response {
    }
    
    /**
     * Activate the bricks post data migration of remove brick operation.
     * 
     * Used to activate brick(s) once the data migration from bricks is complete but user no longer wishes to remove
     * bricks. The bricks that were previously marked for removal will now be used as normal bricks.
     * 
     * For example, to retain the bricks that on glustervolume `123` from which data was migrated, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks/activate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <bricks>
     *     <brick>
     *       <name>host1:/rhgs/brick1</name>
     *     </brick>
     *   </bricks>
     * </action>
     * ----
     */
    ActivateRequest activate();
    
    /**
     * Adds a list of bricks to gluster volume.
     * 
     * Used to expand a gluster volume by adding bricks. For replicated volume types, the parameter `replica_count`
     * needs to be passed. In case the replica count is being increased, then the number of bricks needs to be
     * equivalent to the number of replica sets.
     * 
     * For example, to add bricks to gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick>
     *     <server_id>111</server_id>
     *     <brick_dir>/export/data/brick3</brick_dir>
     *   </brick>
     * </bricks>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest bricks(List<GlusterBrick> bricks);
        /**
         * The list of bricks to be added to the volume
         */
        AddRequest bricks(GlusterBrick... bricks);
        /**
         * The list of bricks to be added to the volume
         */
        AddRequest bricks(GlusterBrickBuilder... bricks);
        /**
         * Replica count of volume post add operation.
         */
        AddRequest replicaCount(Integer replicaCount);
        /**
         * Replica count of volume post add operation.
         */
        AddRequest replicaCount(Long replicaCount);
        /**
         * Replica count of volume post add operation.
         */
        AddRequest replicaCount(BigInteger replicaCount);
        /**
         * Stripe count of volume post add operation.
         */
        AddRequest stripeCount(Integer stripeCount);
        /**
         * Stripe count of volume post add operation.
         */
        AddRequest stripeCount(Long stripeCount);
        /**
         * Stripe count of volume post add operation.
         */
        AddRequest stripeCount(BigInteger stripeCount);
    }
    
    /**
     * Adds a list of bricks to gluster volume.
     * 
     * Used to expand a gluster volume by adding bricks. For replicated volume types, the parameter `replica_count`
     * needs to be passed. In case the replica count is being increased, then the number of bricks needs to be
     * equivalent to the number of replica sets.
     * 
     * For example, to add bricks to gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick>
     *     <server_id>111</server_id>
     *     <brick_dir>/export/data/brick3</brick_dir>
     *   </brick>
     * </bricks>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The list of bricks to be added to the volume
         */
        List<GlusterBrick> bricks();
    }
    
    /**
     * Adds a list of bricks to gluster volume.
     * 
     * Used to expand a gluster volume by adding bricks. For replicated volume types, the parameter `replica_count`
     * needs to be passed. In case the replica count is being increased, then the number of bricks needs to be
     * equivalent to the number of replica sets.
     * 
     * For example, to add bricks to gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick>
     *     <server_id>111</server_id>
     *     <brick_dir>/export/data/brick3</brick_dir>
     *   </brick>
     * </bricks>
     * ----
     */
    AddRequest add();
    
    /**
     * Lists the bricks of a gluster volume.
     * 
     * For example, to list bricks of gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks
     * ----
     * 
     * Provides an output as below:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick id="234">
     *     <name>host1:/rhgs/data/brick1</name>
     *     <brick_dir>/rhgs/data/brick1</brick_dir>
     *     <server_id>111</server_id>
     *     <status>up</status>
     *   </brick>
     *   <brick id="233">
     *     <name>host2:/rhgs/data/brick1</name>
     *     <brick_dir>/rhgs/data/brick1</brick_dir>
     *     <server_id>222</server_id>
     *     <status>up</status>
     *   </brick>
     * </bricks>
     * ----
     * 
     * The order of the returned list is based on the brick order provided at gluster volume creation.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of bricks to return. If not specified all the bricks are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of bricks to return. If not specified all the bricks are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of bricks to return. If not specified all the bricks are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Lists the bricks of a gluster volume.
     * 
     * For example, to list bricks of gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks
     * ----
     * 
     * Provides an output as below:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick id="234">
     *     <name>host1:/rhgs/data/brick1</name>
     *     <brick_dir>/rhgs/data/brick1</brick_dir>
     *     <server_id>111</server_id>
     *     <status>up</status>
     *   </brick>
     *   <brick id="233">
     *     <name>host2:/rhgs/data/brick1</name>
     *     <brick_dir>/rhgs/data/brick1</brick_dir>
     *     <server_id>222</server_id>
     *     <status>up</status>
     *   </brick>
     * </bricks>
     * ----
     * 
     * The order of the returned list is based on the brick order provided at gluster volume creation.
     */
    public interface ListResponse extends Response {
        List<GlusterBrick> bricks();
    }
    
    /**
     * Lists the bricks of a gluster volume.
     * 
     * For example, to list bricks of gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks
     * ----
     * 
     * Provides an output as below:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick id="234">
     *     <name>host1:/rhgs/data/brick1</name>
     *     <brick_dir>/rhgs/data/brick1</brick_dir>
     *     <server_id>111</server_id>
     *     <status>up</status>
     *   </brick>
     *   <brick id="233">
     *     <name>host2:/rhgs/data/brick1</name>
     *     <brick_dir>/rhgs/data/brick1</brick_dir>
     *     <server_id>222</server_id>
     *     <status>up</status>
     *   </brick>
     * </bricks>
     * ----
     * 
     * The order of the returned list is based on the brick order provided at gluster volume creation.
     */
    ListRequest list();
    
    /**
     * Start migration of data prior to removing bricks.
     * 
     * Removing bricks is a two-step process, where the data on bricks to be removed, is first migrated to remaining
     * bricks. Once migration is completed the removal of bricks is confirmed via the API
     * <<services/gluster_bricks/methods/remove, remove>>. If at any point, the action needs to be cancelled
     * <<services/gluster_bricks/methods/stop_migrate, stopmigrate>> has to be called.
     * 
     * For instance, to delete a brick from a gluster volume with id `123`, send a request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks/migrate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <bricks>
     *     <brick>
     *       <name>host1:/rhgs/brick1</name>
     *     </brick>
     *   </bricks>
     * </action>
     * ----
     * 
     * The migration process can be tracked from the job id returned from the API using
     * <<services/job/methods/get, job>> and steps in job using <<services/step/methods/get, step>>
     */
    public interface MigrateRequest extends Request<MigrateRequest, MigrateResponse> {
        /**
         * Indicates if the migration should be performed asynchronously.
         */
        MigrateRequest async(Boolean async);
        MigrateRequest bricks(List<GlusterBrick> bricks);
        /**
         * List of bricks for which data migration needs to be started.
         */
        MigrateRequest bricks(GlusterBrick... bricks);
        /**
         * List of bricks for which data migration needs to be started.
         */
        MigrateRequest bricks(GlusterBrickBuilder... bricks);
    }
    
    /**
     * Start migration of data prior to removing bricks.
     * 
     * Removing bricks is a two-step process, where the data on bricks to be removed, is first migrated to remaining
     * bricks. Once migration is completed the removal of bricks is confirmed via the API
     * <<services/gluster_bricks/methods/remove, remove>>. If at any point, the action needs to be cancelled
     * <<services/gluster_bricks/methods/stop_migrate, stopmigrate>> has to be called.
     * 
     * For instance, to delete a brick from a gluster volume with id `123`, send a request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks/migrate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <bricks>
     *     <brick>
     *       <name>host1:/rhgs/brick1</name>
     *     </brick>
     *   </bricks>
     * </action>
     * ----
     * 
     * The migration process can be tracked from the job id returned from the API using
     * <<services/job/methods/get, job>> and steps in job using <<services/step/methods/get, step>>
     */
    public interface MigrateResponse extends Response {
    }
    
    /**
     * Start migration of data prior to removing bricks.
     * 
     * Removing bricks is a two-step process, where the data on bricks to be removed, is first migrated to remaining
     * bricks. Once migration is completed the removal of bricks is confirmed via the API
     * <<services/gluster_bricks/methods/remove, remove>>. If at any point, the action needs to be cancelled
     * <<services/gluster_bricks/methods/stop_migrate, stopmigrate>> has to be called.
     * 
     * For instance, to delete a brick from a gluster volume with id `123`, send a request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks/migrate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <bricks>
     *     <brick>
     *       <name>host1:/rhgs/brick1</name>
     *     </brick>
     *   </bricks>
     * </action>
     * ----
     * 
     * The migration process can be tracked from the job id returned from the API using
     * <<services/job/methods/get, job>> and steps in job using <<services/step/methods/get, step>>
     */
    MigrateRequest migrate();
    
    /**
     * Removes bricks from gluster volume.
     * 
     * The recommended way to remove bricks without data loss is to first migrate the data using
     * <<services/gluster_bricks/methods/stop_migrate, stopmigrate>> and then removing them. If migrate was not called on
     * bricks prior to remove, the bricks are removed without data migration which may lead to data loss.
     * 
     * For example, to delete the bricks from gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick>
     *     <name>host:brick_directory</name>
     *   </brick>
     * </bricks>
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
        RemoveRequest bricks(List<GlusterBrick> bricks);
        /**
         * The list of bricks to be removed
         */
        RemoveRequest bricks(GlusterBrick... bricks);
        /**
         * The list of bricks to be removed
         */
        RemoveRequest bricks(GlusterBrickBuilder... bricks);
        /**
         * Replica count of volume post add operation.
         */
        RemoveRequest replicaCount(Integer replicaCount);
        /**
         * Replica count of volume post add operation.
         */
        RemoveRequest replicaCount(Long replicaCount);
        /**
         * Replica count of volume post add operation.
         */
        RemoveRequest replicaCount(BigInteger replicaCount);
    }
    
    /**
     * Removes bricks from gluster volume.
     * 
     * The recommended way to remove bricks without data loss is to first migrate the data using
     * <<services/gluster_bricks/methods/stop_migrate, stopmigrate>> and then removing them. If migrate was not called on
     * bricks prior to remove, the bricks are removed without data migration which may lead to data loss.
     * 
     * For example, to delete the bricks from gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick>
     *     <name>host:brick_directory</name>
     *   </brick>
     * </bricks>
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes bricks from gluster volume.
     * 
     * The recommended way to remove bricks without data loss is to first migrate the data using
     * <<services/gluster_bricks/methods/stop_migrate, stopmigrate>> and then removing them. If migrate was not called on
     * bricks prior to remove, the bricks are removed without data migration which may lead to data loss.
     * 
     * For example, to delete the bricks from gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick>
     *     <name>host:brick_directory</name>
     *   </brick>
     * </bricks>
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Stops migration of data from bricks for a remove brick operation.
     * 
     * To cancel data migration that was started as part of the 2-step remove brick process in case the user wishes to
     * continue using the bricks. The bricks that were marked for removal will function as normal bricks post this
     * operation.
     * 
     * For example, to stop migration of data from the bricks of gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks/stopmigrate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick>
     *     <name>host:brick_directory</name>
     *   </brick>
     * </bricks>
     * ----
     */
    public interface StopMigrateRequest extends Request<StopMigrateRequest, StopMigrateResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        StopMigrateRequest async(Boolean async);
        StopMigrateRequest bricks(List<GlusterBrick> bricks);
        /**
         * List of bricks for which data migration needs to be stopped. This list should match the arguments passed to
         * <<services/gluster_bricks/methods/migrate, migrate>>.
         */
        StopMigrateRequest bricks(GlusterBrick... bricks);
        /**
         * List of bricks for which data migration needs to be stopped. This list should match the arguments passed to
         * <<services/gluster_bricks/methods/migrate, migrate>>.
         */
        StopMigrateRequest bricks(GlusterBrickBuilder... bricks);
    }
    
    /**
     * Stops migration of data from bricks for a remove brick operation.
     * 
     * To cancel data migration that was started as part of the 2-step remove brick process in case the user wishes to
     * continue using the bricks. The bricks that were marked for removal will function as normal bricks post this
     * operation.
     * 
     * For example, to stop migration of data from the bricks of gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks/stopmigrate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick>
     *     <name>host:brick_directory</name>
     *   </brick>
     * </bricks>
     * ----
     */
    public interface StopMigrateResponse extends Response {
    }
    
    /**
     * Stops migration of data from bricks for a remove brick operation.
     * 
     * To cancel data migration that was started as part of the 2-step remove brick process in case the user wishes to
     * continue using the bricks. The bricks that were marked for removal will function as normal bricks post this
     * operation.
     * 
     * For example, to stop migration of data from the bricks of gluster volume `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/567/glustervolumes/123/glusterbricks/stopmigrate
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <bricks>
     *   <brick>
     *     <name>host:brick_directory</name>
     *   </brick>
     * </bricks>
     * ----
     */
    StopMigrateRequest stopMigrate();
    
    /**
     * Returns a reference to the service managing a single gluster brick.
     */
    GlusterBrickService brickService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

