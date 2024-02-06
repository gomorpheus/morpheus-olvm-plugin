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
import org.ovirt.engine.sdk4.builders.GlusterVolumeBuilder;
import org.ovirt.engine.sdk4.types.GlusterVolume;

/**
 * This service manages a collection of gluster volumes available in a cluster.
 */
public interface GlusterVolumesService extends Service {
    /**
     * Creates a new gluster volume.
     * 
     * The volume is created based on properties of the `volume` parameter. The properties `name`, `volume_type` and
     * `bricks` are required.
     * 
     * For example, to add a volume with name `myvolume` to the cluster `123`, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/glustervolumes
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <gluster_volume>
     *   <name>myvolume</name>
     *   <volume_type>replicate</volume_type>
     *   <replica_count>3</replica_count>
     *   <bricks>
     *     <brick>
     *       <server_id>server1</server_id>
     *       <brick_dir>/exp1</brick_dir>
     *     </brick>
     *     <brick>
     *       <server_id>server2</server_id>
     *       <brick_dir>/exp1</brick_dir>
     *     </brick>
     *     <brick>
     *       <server_id>server3</server_id>
     *       <brick_dir>/exp1</brick_dir>
     *     </brick>
     *   <bricks>
     * </gluster_volume>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest volume(GlusterVolume volume);
        /**
         * The gluster volume definition from which to create the volume is passed as input and the newly created
         * volume is returned.
         */
        AddRequest volume(GlusterVolumeBuilder volume);
    }
    
    /**
     * Creates a new gluster volume.
     * 
     * The volume is created based on properties of the `volume` parameter. The properties `name`, `volume_type` and
     * `bricks` are required.
     * 
     * For example, to add a volume with name `myvolume` to the cluster `123`, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/glustervolumes
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <gluster_volume>
     *   <name>myvolume</name>
     *   <volume_type>replicate</volume_type>
     *   <replica_count>3</replica_count>
     *   <bricks>
     *     <brick>
     *       <server_id>server1</server_id>
     *       <brick_dir>/exp1</brick_dir>
     *     </brick>
     *     <brick>
     *       <server_id>server2</server_id>
     *       <brick_dir>/exp1</brick_dir>
     *     </brick>
     *     <brick>
     *       <server_id>server3</server_id>
     *       <brick_dir>/exp1</brick_dir>
     *     </brick>
     *   <bricks>
     * </gluster_volume>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The gluster volume definition from which to create the volume is passed as input and the newly created
         * volume is returned.
         */
        GlusterVolume volume();
    }
    
    /**
     * Creates a new gluster volume.
     * 
     * The volume is created based on properties of the `volume` parameter. The properties `name`, `volume_type` and
     * `bricks` are required.
     * 
     * For example, to add a volume with name `myvolume` to the cluster `123`, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/glustervolumes
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <gluster_volume>
     *   <name>myvolume</name>
     *   <volume_type>replicate</volume_type>
     *   <replica_count>3</replica_count>
     *   <bricks>
     *     <brick>
     *       <server_id>server1</server_id>
     *       <brick_dir>/exp1</brick_dir>
     *     </brick>
     *     <brick>
     *       <server_id>server2</server_id>
     *       <brick_dir>/exp1</brick_dir>
     *     </brick>
     *     <brick>
     *       <server_id>server3</server_id>
     *       <brick_dir>/exp1</brick_dir>
     *     </brick>
     *   <bricks>
     * </gluster_volume>
     * ----
     */
    AddRequest add();
    
    /**
     * Lists all gluster volumes in the cluster.
     * 
     * For example, to list all Gluster Volumes in cluster `456`, send a request like
     * this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/456/glustervolumes
     * ----
     * 
     * The order of the returned list of volumes isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of volumes to return. If not specified all the volumes are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of volumes to return. If not specified all the volumes are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of volumes to return. If not specified all the volumes are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned volumes.
         */
        ListRequest search(String search);
    }
    
    /**
     * Lists all gluster volumes in the cluster.
     * 
     * For example, to list all Gluster Volumes in cluster `456`, send a request like
     * this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/456/glustervolumes
     * ----
     * 
     * The order of the returned list of volumes isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<GlusterVolume> volumes();
    }
    
    /**
     * Lists all gluster volumes in the cluster.
     * 
     * For example, to list all Gluster Volumes in cluster `456`, send a request like
     * this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/456/glustervolumes
     * ----
     * 
     * The order of the returned list of volumes isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to a service managing gluster volume.
     */
    GlusterVolumeService volumeService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

