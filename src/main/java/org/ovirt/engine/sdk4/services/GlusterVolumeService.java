/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.OptionBuilder;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.GlusterVolumeProfileDetails;
import org.ovirt.engine.sdk4.types.Option;

/**
 * This service manages a single gluster volume.
 */
public interface GlusterVolumeService extends MeasurableService {
    /**
     * Get the gluster volume details.
     * 
     * For example, to get details of a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/456/glustervolumes/123
     * ----
     * 
     * This GET request will return the following output:
     * 
     * [source,xml]
     * ----
     * <gluster_volume id="123">
     *  <name>data</name>
     *  <link href="/ovirt-engine/api/clusters/456/glustervolumes/123/glusterbricks" rel="glusterbricks"/>
     *  <disperse_count>0</disperse_count>
     *  <options>
     *    <option>
     *      <name>storage.owner-gid</name>
     *      <value>36</value>
     *    </option>
     *    <option>
     *      <name>performance.io-cache</name>
     *      <value>off</value>
     *    </option>
     *    <option>
     *      <name>cluster.data-self-heal-algorithm</name>
     *      <value>full</value>
     *    </option>
     *  </options>
     *  <redundancy_count>0</redundancy_count>
     *  <replica_count>3</replica_count>
     *  <status>up</status>
     *  <stripe_count>0</stripe_count>
     *  <transport_types>
     *    <transport_type>tcp</transport_type>
     *  </transport_types>
     *  <volume_type>replicate</volume_type>
     *  </gluster_volume>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Get the gluster volume details.
     * 
     * For example, to get details of a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/456/glustervolumes/123
     * ----
     * 
     * This GET request will return the following output:
     * 
     * [source,xml]
     * ----
     * <gluster_volume id="123">
     *  <name>data</name>
     *  <link href="/ovirt-engine/api/clusters/456/glustervolumes/123/glusterbricks" rel="glusterbricks"/>
     *  <disperse_count>0</disperse_count>
     *  <options>
     *    <option>
     *      <name>storage.owner-gid</name>
     *      <value>36</value>
     *    </option>
     *    <option>
     *      <name>performance.io-cache</name>
     *      <value>off</value>
     *    </option>
     *    <option>
     *      <name>cluster.data-self-heal-algorithm</name>
     *      <value>full</value>
     *    </option>
     *  </options>
     *  <redundancy_count>0</redundancy_count>
     *  <replica_count>3</replica_count>
     *  <status>up</status>
     *  <stripe_count>0</stripe_count>
     *  <transport_types>
     *    <transport_type>tcp</transport_type>
     *  </transport_types>
     *  <volume_type>replicate</volume_type>
     *  </gluster_volume>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Representation of the gluster volume.
         */
        GlusterVolume volume();
    }
    
    /**
     * Get the gluster volume details.
     * 
     * For example, to get details of a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/456/glustervolumes/123
     * ----
     * 
     * This GET request will return the following output:
     * 
     * [source,xml]
     * ----
     * <gluster_volume id="123">
     *  <name>data</name>
     *  <link href="/ovirt-engine/api/clusters/456/glustervolumes/123/glusterbricks" rel="glusterbricks"/>
     *  <disperse_count>0</disperse_count>
     *  <options>
     *    <option>
     *      <name>storage.owner-gid</name>
     *      <value>36</value>
     *    </option>
     *    <option>
     *      <name>performance.io-cache</name>
     *      <value>off</value>
     *    </option>
     *    <option>
     *      <name>cluster.data-self-heal-algorithm</name>
     *      <value>full</value>
     *    </option>
     *  </options>
     *  <redundancy_count>0</redundancy_count>
     *  <replica_count>3</replica_count>
     *  <status>up</status>
     *  <stripe_count>0</stripe_count>
     *  <transport_types>
     *    <transport_type>tcp</transport_type>
     *  </transport_types>
     *  <volume_type>replicate</volume_type>
     *  </gluster_volume>
     * ----
     */
    GetRequest get();
    
    /**
     * Get gluster volume profile statistics.
     * 
     * For example, to get profile statistics for a gluster volume with identifier `123` in cluster `456`, send a
     * request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/getprofilestatistics
     * ----
     */
    public interface GetProfileStatisticsRequest extends Request<GetProfileStatisticsRequest, GetProfileStatisticsResponse> {
    }
    
    /**
     * Get gluster volume profile statistics.
     * 
     * For example, to get profile statistics for a gluster volume with identifier `123` in cluster `456`, send a
     * request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/getprofilestatistics
     * ----
     */
    public interface GetProfileStatisticsResponse extends Response {
        /**
         * Gluster volume profiling information returned from the action.
         */
        GlusterVolumeProfileDetails details();
    }
    
    /**
     * Get gluster volume profile statistics.
     * 
     * For example, to get profile statistics for a gluster volume with identifier `123` in cluster `456`, send a
     * request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/getprofilestatistics
     * ----
     */
    GetProfileStatisticsRequest getProfileStatistics();
    
    /**
     * Rebalance the gluster volume.
     * 
     * Rebalancing a gluster volume helps to distribute the data evenly across all the bricks. After expanding or
     * shrinking a gluster volume (without migrating data), we need to rebalance the data among the bricks. In a
     * non-replicated volume, all bricks should be online to perform the rebalance operation. In a replicated volume, at
     * least one of the bricks in the replica should be online.
     * 
     * For example, to rebalance a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/rebalance
     * ----
     */
    public interface RebalanceRequest extends Request<RebalanceRequest, RebalanceResponse> {
        /**
         * Indicates if the rebalance should be performed asynchronously.
         */
        RebalanceRequest async(Boolean async);
        /**
         * If set to true, rebalance will only fix the layout so that new data added to the volume is distributed
         * across all the hosts. But it will not migrate/rebalance the existing data. Default is `false`.
         */
        RebalanceRequest fixLayout(Boolean fixLayout);
        /**
         * Indicates if the rebalance should be force started. The rebalance command can be executed with the force
         * option even when the older clients are connected to the cluster. However, this could lead to a data loss
         * situation. Default is `false`.
         */
        RebalanceRequest force(Boolean force);
    }
    
    /**
     * Rebalance the gluster volume.
     * 
     * Rebalancing a gluster volume helps to distribute the data evenly across all the bricks. After expanding or
     * shrinking a gluster volume (without migrating data), we need to rebalance the data among the bricks. In a
     * non-replicated volume, all bricks should be online to perform the rebalance operation. In a replicated volume, at
     * least one of the bricks in the replica should be online.
     * 
     * For example, to rebalance a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/rebalance
     * ----
     */
    public interface RebalanceResponse extends Response {
    }
    
    /**
     * Rebalance the gluster volume.
     * 
     * Rebalancing a gluster volume helps to distribute the data evenly across all the bricks. After expanding or
     * shrinking a gluster volume (without migrating data), we need to rebalance the data among the bricks. In a
     * non-replicated volume, all bricks should be online to perform the rebalance operation. In a replicated volume, at
     * least one of the bricks in the replica should be online.
     * 
     * For example, to rebalance a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/rebalance
     * ----
     */
    RebalanceRequest rebalance();
    
    /**
     * Removes the gluster volume.
     * 
     * For example, to remove a volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/456/glustervolumes/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the gluster volume.
     * 
     * For example, to remove a volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/456/glustervolumes/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the gluster volume.
     * 
     * For example, to remove a volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/456/glustervolumes/123
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Resets all the options set in the gluster volume.
     * 
     * For example, to reset all options in a gluster volume with identifier `123` in cluster `456`, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/resetalloptions
     * ----
     */
    public interface ResetAllOptionsRequest extends Request<ResetAllOptionsRequest, ResetAllOptionsResponse> {
        /**
         * Indicates if the reset should be performed asynchronously.
         */
        ResetAllOptionsRequest async(Boolean async);
    }
    
    /**
     * Resets all the options set in the gluster volume.
     * 
     * For example, to reset all options in a gluster volume with identifier `123` in cluster `456`, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/resetalloptions
     * ----
     */
    public interface ResetAllOptionsResponse extends Response {
    }
    
    /**
     * Resets all the options set in the gluster volume.
     * 
     * For example, to reset all options in a gluster volume with identifier `123` in cluster `456`, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/resetalloptions
     * ----
     */
    ResetAllOptionsRequest resetAllOptions();
    
    /**
     * Resets a particular option in the gluster volume.
     * 
     * For example, to reset a particular option `option1` in a gluster volume with identifier `123` in cluster `456`,
     * send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/resetoption
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *  <option name="option1"/>
     * </action>
     * ----
     */
    public interface ResetOptionRequest extends Request<ResetOptionRequest, ResetOptionResponse> {
        /**
         * Indicates if the reset should be performed asynchronously.
         */
        ResetOptionRequest async(Boolean async);
        ResetOptionRequest force(Boolean force);
        ResetOptionRequest option(Option option);
        /**
         * Option to reset.
         */
        ResetOptionRequest option(OptionBuilder option);
    }
    
    /**
     * Resets a particular option in the gluster volume.
     * 
     * For example, to reset a particular option `option1` in a gluster volume with identifier `123` in cluster `456`,
     * send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/resetoption
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *  <option name="option1"/>
     * </action>
     * ----
     */
    public interface ResetOptionResponse extends Response {
    }
    
    /**
     * Resets a particular option in the gluster volume.
     * 
     * For example, to reset a particular option `option1` in a gluster volume with identifier `123` in cluster `456`,
     * send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/resetoption
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *  <option name="option1"/>
     * </action>
     * ----
     */
    ResetOptionRequest resetOption();
    
    /**
     * Sets a particular option in the gluster volume.
     * 
     * For example, to set `option1` with value `value1` in a gluster volume with identifier `123` in cluster `456`,
     * send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/setoption
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *  <option name="option1" value="value1"/>
     * </action>
     * ----
     */
    public interface SetOptionRequest extends Request<SetOptionRequest, SetOptionResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        SetOptionRequest async(Boolean async);
        SetOptionRequest option(Option option);
        /**
         * Option to set.
         */
        SetOptionRequest option(OptionBuilder option);
    }
    
    /**
     * Sets a particular option in the gluster volume.
     * 
     * For example, to set `option1` with value `value1` in a gluster volume with identifier `123` in cluster `456`,
     * send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/setoption
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *  <option name="option1" value="value1"/>
     * </action>
     * ----
     */
    public interface SetOptionResponse extends Response {
    }
    
    /**
     * Sets a particular option in the gluster volume.
     * 
     * For example, to set `option1` with value `value1` in a gluster volume with identifier `123` in cluster `456`,
     * send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/setoption
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *  <option name="option1" value="value1"/>
     * </action>
     * ----
     */
    SetOptionRequest setOption();
    
    /**
     * Starts the gluster volume.
     * 
     * A Gluster Volume should be started to read/write data. For example, to start a gluster volume with identifier
     * `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/start
     * ----
     */
    public interface StartRequest extends Request<StartRequest, StartResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        StartRequest async(Boolean async);
        /**
         * Indicates if the volume should be force started. If a gluster volume is started already but few/all bricks
         * are down then force start can be used to bring all the bricks up. Default is `false`.
         */
        StartRequest force(Boolean force);
    }
    
    /**
     * Starts the gluster volume.
     * 
     * A Gluster Volume should be started to read/write data. For example, to start a gluster volume with identifier
     * `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/start
     * ----
     */
    public interface StartResponse extends Response {
    }
    
    /**
     * Starts the gluster volume.
     * 
     * A Gluster Volume should be started to read/write data. For example, to start a gluster volume with identifier
     * `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/start
     * ----
     */
    StartRequest start();
    
    /**
     * Start profiling the gluster volume.
     * 
     * For example, to start profiling a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/startprofile
     * ----
     */
    public interface StartProfileRequest extends Request<StartProfileRequest, StartProfileResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        StartProfileRequest async(Boolean async);
    }
    
    /**
     * Start profiling the gluster volume.
     * 
     * For example, to start profiling a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/startprofile
     * ----
     */
    public interface StartProfileResponse extends Response {
    }
    
    /**
     * Start profiling the gluster volume.
     * 
     * For example, to start profiling a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/startprofile
     * ----
     */
    StartProfileRequest startProfile();
    
    /**
     * Stops the gluster volume.
     * 
     * Stopping a volume will make its data inaccessible.
     * 
     * For example, to stop a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/stop
     * ----
     */
    public interface StopRequest extends Request<StopRequest, StopResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        StopRequest async(Boolean async);
        StopRequest force(Boolean force);
    }
    
    /**
     * Stops the gluster volume.
     * 
     * Stopping a volume will make its data inaccessible.
     * 
     * For example, to stop a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/stop
     * ----
     */
    public interface StopResponse extends Response {
    }
    
    /**
     * Stops the gluster volume.
     * 
     * Stopping a volume will make its data inaccessible.
     * 
     * For example, to stop a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/stop
     * ----
     */
    StopRequest stop();
    
    /**
     * Stop profiling the gluster volume.
     * 
     * For example, to stop profiling a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/stopprofile
     * ----
     */
    public interface StopProfileRequest extends Request<StopProfileRequest, StopProfileResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        StopProfileRequest async(Boolean async);
    }
    
    /**
     * Stop profiling the gluster volume.
     * 
     * For example, to stop profiling a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/stopprofile
     * ----
     */
    public interface StopProfileResponse extends Response {
    }
    
    /**
     * Stop profiling the gluster volume.
     * 
     * For example, to stop profiling a gluster volume with identifier `123` in cluster `456`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/stopprofile
     * ----
     */
    StopProfileRequest stopProfile();
    
    /**
     * Stop rebalancing the gluster volume.
     * 
     * For example, to stop rebalancing a gluster volume with identifier `123` in cluster `456`, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/stoprebalance
     * ----
     */
    public interface StopRebalanceRequest extends Request<StopRebalanceRequest, StopRebalanceResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        StopRebalanceRequest async(Boolean async);
    }
    
    /**
     * Stop rebalancing the gluster volume.
     * 
     * For example, to stop rebalancing a gluster volume with identifier `123` in cluster `456`, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/stoprebalance
     * ----
     */
    public interface StopRebalanceResponse extends Response {
    }
    
    /**
     * Stop rebalancing the gluster volume.
     * 
     * For example, to stop rebalancing a gluster volume with identifier `123` in cluster `456`, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/456/glustervolumes/123/stoprebalance
     * ----
     */
    StopRebalanceRequest stopRebalance();
    
    /**
     * Reference to a service managing gluster bricks.
     */
    GlusterBricksService glusterBricksService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

