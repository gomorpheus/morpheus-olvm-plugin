/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.AffinityGroupBuilder;
import org.ovirt.engine.sdk4.types.AffinityGroup;

/**
 * This service manages a single affinity group.
 */
public interface AffinityGroupService extends Service {
    /**
     * Retrieve the affinity group details.
     * 
     * [source,xml]
     * ----
     * <affinity_group id="00000000-0000-0000-0000-000000000000">
     *   <name>AF_GROUP_001</name>
     *   <cluster id="00000000-0000-0000-0000-000000000000"/>
     *   <positive>true</positive>
     *   <enforcing>true</enforcing>
     * </affinity_group>
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
     * Retrieve the affinity group details.
     * 
     * [source,xml]
     * ----
     * <affinity_group id="00000000-0000-0000-0000-000000000000">
     *   <name>AF_GROUP_001</name>
     *   <cluster id="00000000-0000-0000-0000-000000000000"/>
     *   <positive>true</positive>
     *   <enforcing>true</enforcing>
     * </affinity_group>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The affinity group.
         */
        AffinityGroup group();
    }
    
    /**
     * Retrieve the affinity group details.
     * 
     * [source,xml]
     * ----
     * <affinity_group id="00000000-0000-0000-0000-000000000000">
     *   <name>AF_GROUP_001</name>
     *   <cluster id="00000000-0000-0000-0000-000000000000"/>
     *   <positive>true</positive>
     *   <enforcing>true</enforcing>
     * </affinity_group>
     * ----
     */
    GetRequest get();
    
    /**
     * Remove the affinity group.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/000-000/affinitygroups/123-456
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the removal should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove the affinity group.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/000-000/affinitygroups/123-456
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove the affinity group.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/000-000/affinitygroups/123-456
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Update the affinity group.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest group(AffinityGroup group);
        /**
         * The affinity group.
         */
        UpdateRequest group(AffinityGroupBuilder group);
    }
    
    /**
     * Update the affinity group.
     */
    public interface UpdateResponse extends Response {
        /**
         * The affinity group.
         */
        AffinityGroup group();
    }
    
    /**
     * Update the affinity group.
     */
    UpdateRequest update();
    
    /**
     * Returns a reference to the service that manages the
     * list of all host labels attached to this affinity
     * group.
     */
    AffinityGroupHostLabelsService hostLabelsService();
    /**
     * Returns a reference to the service that manages the
     * list of all hosts attached to this affinity
     * group.
     */
    AffinityGroupHostsService hostsService();
    /**
     * Returns a reference to the service that manages the
     * list of all virtual machine labels attached to this affinity
     * group.
     */
    AffinityGroupVmLabelsService vmLabelsService();
    /**
     * Returns a reference to the service that manages the
     * list of all virtual machines attached to this affinity
     * group.
     */
    AffinityGroupVmsService vmsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

