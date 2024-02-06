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
import org.ovirt.engine.sdk4.builders.AffinityGroupBuilder;
import org.ovirt.engine.sdk4.types.AffinityGroup;

/**
 * The affinity groups service manages virtual machine relationships and dependencies.
 */
public interface AffinityGroupsService extends Service {
    /**
     * Create a new affinity group.
     * 
     * Post a request like in the example below to create a new affinity group:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/000-000/affinitygroups
     * ----
     * 
     * And use the following example in its body:
     * 
     * [source,xml]
     * ----
     * <affinity_group>
     *   <name>AF_GROUP_001</name>
     *   <hosts_rule>
     *     <enforcing>true</enforcing>
     *     <positive>true</positive>
     *   </hosts_rule>
     *   <vms_rule>
     *     <enabled>false</enabled>
     *   </vms_rule>
     * </affinity_group>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest group(AffinityGroup group);
        /**
         * The affinity group object to create.
         */
        AddRequest group(AffinityGroupBuilder group);
    }
    
    /**
     * Create a new affinity group.
     * 
     * Post a request like in the example below to create a new affinity group:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/000-000/affinitygroups
     * ----
     * 
     * And use the following example in its body:
     * 
     * [source,xml]
     * ----
     * <affinity_group>
     *   <name>AF_GROUP_001</name>
     *   <hosts_rule>
     *     <enforcing>true</enforcing>
     *     <positive>true</positive>
     *   </hosts_rule>
     *   <vms_rule>
     *     <enabled>false</enabled>
     *   </vms_rule>
     * </affinity_group>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The affinity group object to create.
         */
        AffinityGroup group();
    }
    
    /**
     * Create a new affinity group.
     * 
     * Post a request like in the example below to create a new affinity group:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/000-000/affinitygroups
     * ----
     * 
     * And use the following example in its body:
     * 
     * [source,xml]
     * ----
     * <affinity_group>
     *   <name>AF_GROUP_001</name>
     *   <hosts_rule>
     *     <enforcing>true</enforcing>
     *     <positive>true</positive>
     *   </hosts_rule>
     *   <vms_rule>
     *     <enabled>false</enabled>
     *   </vms_rule>
     * </affinity_group>
     * ----
     */
    AddRequest add();
    
    /**
     * List existing affinity groups.
     * 
     * The order of the affinity groups results isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of affinity groups to return. If not specified all the affinity groups are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of affinity groups to return. If not specified all the affinity groups are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of affinity groups to return. If not specified all the affinity groups are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List existing affinity groups.
     * 
     * The order of the affinity groups results isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of existing affinity groups.
         */
        List<AffinityGroup> groups();
    }
    
    /**
     * List existing affinity groups.
     * 
     * The order of the affinity groups results isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Access the affinity group service that manages the affinity group specified by an ID.
     */
    AffinityGroupService groupService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

