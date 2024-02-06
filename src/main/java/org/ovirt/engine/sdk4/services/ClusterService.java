/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.types.Cluster;

/**
 * A service to manage a specific cluster.
 */
public interface ClusterService extends Service {
    /**
     * Gets information about the cluster.
     * 
     * An example of getting a cluster:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/123
     * ----
     * 
     * [source,xml]
     * ----
     * <cluster href="/ovirt-engine/api/clusters/123" id="123">
     *   <actions>
     *     <link href="/ovirt-engine/api/clusters/123/resetemulatedmachine" rel="resetemulatedmachine"/>
     *   </actions>
     *   <name>Default</name>
     *   <description>The default server cluster</description>
     *   <link href="/ovirt-engine/api/clusters/123/networks" rel="networks"/>
     *   <link href="/ovirt-engine/api/clusters/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/clusters/123/glustervolumes" rel="glustervolumes"/>
     *   <link href="/ovirt-engine/api/clusters/123/glusterhooks" rel="glusterhooks"/>
     *   <link href="/ovirt-engine/api/clusters/123/affinitygroups" rel="affinitygroups"/>
     *   <link href="/ovirt-engine/api/clusters/123/cpuprofiles" rel="cpuprofiles"/>
     *   <ballooning_enabled>false</ballooning_enabled>
     *   <cpu>
     *     <architecture>x86_64</architecture>
     *     <type>Intel Nehalem Family</type>
     *   </cpu>
     *   <error_handling>
     *     <on_error>migrate</on_error>
     *   </error_handling>
     *   <fencing_policy>
     *     <enabled>true</enabled>
     *     <skip_if_connectivity_broken>
     *       <enabled>false</enabled>
     *       <threshold>50</threshold>
     *     </skip_if_connectivity_broken>
     *     <skip_if_sd_active>
     *       <enabled>false</enabled>
     *     </skip_if_sd_active>
     *   </fencing_policy>
     *   <gluster_service>false</gluster_service>
     *   <ha_reservation>false</ha_reservation>
     *   <ksm>
     *     <enabled>true</enabled>
     *     <merge_across_nodes>true</merge_across_nodes>
     *   </ksm>
     *   <memory_policy>
     *     <over_commit>
     *       <percent>100</percent>
     *     </over_commit>
     *     <transparent_hugepages>
     *       <enabled>true</enabled>
     *     </transparent_hugepages>
     *   </memory_policy>
     *   <migration>
     *     <auto_converge>inherit</auto_converge>
     *     <bandwidth>
     *       <assignment_method>auto</assignment_method>
     *     </bandwidth>
     *     <compressed>inherit</compressed>
     *   </migration>
     *   <required_rng_sources>
     *     <required_rng_source>random</required_rng_source>
     *   </required_rng_sources>
     *   <scheduling_policy href="/ovirt-engine/api/schedulingpolicies/456" id="456"/>
     *   <threads_as_cores>false</threads_as_cores>
     *   <trusted_service>false</trusted_service>
     *   <tunnel_migration>false</tunnel_migration>
     *   <version>
     *     <major>4</major>
     *     <minor>0</minor>
     *   </version>
     *   <virt_service>true</virt_service>
     *   <data_center href="/ovirt-engine/api/datacenters/111" id="111"/>
     * </cluster>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        GetRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Gets information about the cluster.
     * 
     * An example of getting a cluster:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/123
     * ----
     * 
     * [source,xml]
     * ----
     * <cluster href="/ovirt-engine/api/clusters/123" id="123">
     *   <actions>
     *     <link href="/ovirt-engine/api/clusters/123/resetemulatedmachine" rel="resetemulatedmachine"/>
     *   </actions>
     *   <name>Default</name>
     *   <description>The default server cluster</description>
     *   <link href="/ovirt-engine/api/clusters/123/networks" rel="networks"/>
     *   <link href="/ovirt-engine/api/clusters/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/clusters/123/glustervolumes" rel="glustervolumes"/>
     *   <link href="/ovirt-engine/api/clusters/123/glusterhooks" rel="glusterhooks"/>
     *   <link href="/ovirt-engine/api/clusters/123/affinitygroups" rel="affinitygroups"/>
     *   <link href="/ovirt-engine/api/clusters/123/cpuprofiles" rel="cpuprofiles"/>
     *   <ballooning_enabled>false</ballooning_enabled>
     *   <cpu>
     *     <architecture>x86_64</architecture>
     *     <type>Intel Nehalem Family</type>
     *   </cpu>
     *   <error_handling>
     *     <on_error>migrate</on_error>
     *   </error_handling>
     *   <fencing_policy>
     *     <enabled>true</enabled>
     *     <skip_if_connectivity_broken>
     *       <enabled>false</enabled>
     *       <threshold>50</threshold>
     *     </skip_if_connectivity_broken>
     *     <skip_if_sd_active>
     *       <enabled>false</enabled>
     *     </skip_if_sd_active>
     *   </fencing_policy>
     *   <gluster_service>false</gluster_service>
     *   <ha_reservation>false</ha_reservation>
     *   <ksm>
     *     <enabled>true</enabled>
     *     <merge_across_nodes>true</merge_across_nodes>
     *   </ksm>
     *   <memory_policy>
     *     <over_commit>
     *       <percent>100</percent>
     *     </over_commit>
     *     <transparent_hugepages>
     *       <enabled>true</enabled>
     *     </transparent_hugepages>
     *   </memory_policy>
     *   <migration>
     *     <auto_converge>inherit</auto_converge>
     *     <bandwidth>
     *       <assignment_method>auto</assignment_method>
     *     </bandwidth>
     *     <compressed>inherit</compressed>
     *   </migration>
     *   <required_rng_sources>
     *     <required_rng_source>random</required_rng_source>
     *   </required_rng_sources>
     *   <scheduling_policy href="/ovirt-engine/api/schedulingpolicies/456" id="456"/>
     *   <threads_as_cores>false</threads_as_cores>
     *   <trusted_service>false</trusted_service>
     *   <tunnel_migration>false</tunnel_migration>
     *   <version>
     *     <major>4</major>
     *     <minor>0</minor>
     *   </version>
     *   <virt_service>true</virt_service>
     *   <data_center href="/ovirt-engine/api/datacenters/111" id="111"/>
     * </cluster>
     * ----
     */
    public interface GetResponse extends Response {
        Cluster cluster();
    }
    
    /**
     * Gets information about the cluster.
     * 
     * An example of getting a cluster:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/123
     * ----
     * 
     * [source,xml]
     * ----
     * <cluster href="/ovirt-engine/api/clusters/123" id="123">
     *   <actions>
     *     <link href="/ovirt-engine/api/clusters/123/resetemulatedmachine" rel="resetemulatedmachine"/>
     *   </actions>
     *   <name>Default</name>
     *   <description>The default server cluster</description>
     *   <link href="/ovirt-engine/api/clusters/123/networks" rel="networks"/>
     *   <link href="/ovirt-engine/api/clusters/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/clusters/123/glustervolumes" rel="glustervolumes"/>
     *   <link href="/ovirt-engine/api/clusters/123/glusterhooks" rel="glusterhooks"/>
     *   <link href="/ovirt-engine/api/clusters/123/affinitygroups" rel="affinitygroups"/>
     *   <link href="/ovirt-engine/api/clusters/123/cpuprofiles" rel="cpuprofiles"/>
     *   <ballooning_enabled>false</ballooning_enabled>
     *   <cpu>
     *     <architecture>x86_64</architecture>
     *     <type>Intel Nehalem Family</type>
     *   </cpu>
     *   <error_handling>
     *     <on_error>migrate</on_error>
     *   </error_handling>
     *   <fencing_policy>
     *     <enabled>true</enabled>
     *     <skip_if_connectivity_broken>
     *       <enabled>false</enabled>
     *       <threshold>50</threshold>
     *     </skip_if_connectivity_broken>
     *     <skip_if_sd_active>
     *       <enabled>false</enabled>
     *     </skip_if_sd_active>
     *   </fencing_policy>
     *   <gluster_service>false</gluster_service>
     *   <ha_reservation>false</ha_reservation>
     *   <ksm>
     *     <enabled>true</enabled>
     *     <merge_across_nodes>true</merge_across_nodes>
     *   </ksm>
     *   <memory_policy>
     *     <over_commit>
     *       <percent>100</percent>
     *     </over_commit>
     *     <transparent_hugepages>
     *       <enabled>true</enabled>
     *     </transparent_hugepages>
     *   </memory_policy>
     *   <migration>
     *     <auto_converge>inherit</auto_converge>
     *     <bandwidth>
     *       <assignment_method>auto</assignment_method>
     *     </bandwidth>
     *     <compressed>inherit</compressed>
     *   </migration>
     *   <required_rng_sources>
     *     <required_rng_source>random</required_rng_source>
     *   </required_rng_sources>
     *   <scheduling_policy href="/ovirt-engine/api/schedulingpolicies/456" id="456"/>
     *   <threads_as_cores>false</threads_as_cores>
     *   <trusted_service>false</trusted_service>
     *   <tunnel_migration>false</tunnel_migration>
     *   <version>
     *     <major>4</major>
     *     <minor>0</minor>
     *   </version>
     *   <virt_service>true</virt_service>
     *   <data_center href="/ovirt-engine/api/datacenters/111" id="111"/>
     * </cluster>
     * ----
     */
    GetRequest get();
    
    /**
     * Refresh the Gluster heal info for all volumes in cluster.
     * 
     * For example, Cluster `123`, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/refreshglusterhealstatus
     * ----
     */
    public interface RefreshGlusterHealStatusRequest extends Request<RefreshGlusterHealStatusRequest, RefreshGlusterHealStatusResponse> {
    }
    
    /**
     * Refresh the Gluster heal info for all volumes in cluster.
     * 
     * For example, Cluster `123`, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/refreshglusterhealstatus
     * ----
     */
    public interface RefreshGlusterHealStatusResponse extends Response {
    }
    
    /**
     * Refresh the Gluster heal info for all volumes in cluster.
     * 
     * For example, Cluster `123`, send a request like
     * this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/refreshglusterhealstatus
     * ----
     */
    RefreshGlusterHealStatusRequest refreshGlusterHealStatus();
    
    /**
     * Removes the cluster from the system.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/00000000-0000-0000-0000-000000000000
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the cluster from the system.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/00000000-0000-0000-0000-000000000000
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the cluster from the system.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/clusters/00000000-0000-0000-0000-000000000000
     * ----
     */
    RemoveRequest remove();
    
    public interface ResetEmulatedMachineRequest extends Request<ResetEmulatedMachineRequest, ResetEmulatedMachineResponse> {
        /**
         * Indicates if the reset should be performed asynchronously.
         */
        ResetEmulatedMachineRequest async(Boolean async);
    }
    
    public interface ResetEmulatedMachineResponse extends Response {
    }
    
    ResetEmulatedMachineRequest resetEmulatedMachine();
    
    /**
     * Synchronizes all networks on the cluster.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/syncallnetworks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface SyncAllNetworksRequest extends Request<SyncAllNetworksRequest, SyncAllNetworksResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        SyncAllNetworksRequest async(Boolean async);
    }
    
    /**
     * Synchronizes all networks on the cluster.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/syncallnetworks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface SyncAllNetworksResponse extends Response {
    }
    
    /**
     * Synchronizes all networks on the cluster.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/syncallnetworks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    SyncAllNetworksRequest syncAllNetworks();
    
    /**
     * Updates information about the cluster.
     * 
     * Only the specified fields are updated; others remain unchanged.
     * 
     * For example, to update the cluster's CPU:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/clusters/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <cluster>
     *   <cpu>
     *     <type>Intel Haswell-noTSX Family</type>
     *   </cpu>
     * </cluster>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest cluster(Cluster cluster);
        UpdateRequest cluster(ClusterBuilder cluster);
    }
    
    /**
     * Updates information about the cluster.
     * 
     * Only the specified fields are updated; others remain unchanged.
     * 
     * For example, to update the cluster's CPU:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/clusters/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <cluster>
     *   <cpu>
     *     <type>Intel Haswell-noTSX Family</type>
     *   </cpu>
     * </cluster>
     * ----
     */
    public interface UpdateResponse extends Response {
        Cluster cluster();
    }
    
    /**
     * Updates information about the cluster.
     * 
     * Only the specified fields are updated; others remain unchanged.
     * 
     * For example, to update the cluster's CPU:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/clusters/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <cluster>
     *   <cpu>
     *     <type>Intel Haswell-noTSX Family</type>
     *   </cpu>
     * </cluster>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Start or finish upgrade process for the cluster based on the action value. This action marks the cluster for
     * upgrade or clears the upgrade running flag on the cluster based on the action value which takes values of
     * start or stop.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/upgrade
     * ----
     * 
     * With a request body like this to mark the cluster for upgrade:
     * 
     * [source,xml]
     * ----
     * <action>
     *     <upgrade_action>
     *         start
     *     </upgrade_action>
     * </action>
     * ----
     */
    public interface UpgradeRequest extends Request<UpgradeRequest, UpgradeResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        UpgradeRequest async(Boolean async);
    }
    
    /**
     * Start or finish upgrade process for the cluster based on the action value. This action marks the cluster for
     * upgrade or clears the upgrade running flag on the cluster based on the action value which takes values of
     * start or stop.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/upgrade
     * ----
     * 
     * With a request body like this to mark the cluster for upgrade:
     * 
     * [source,xml]
     * ----
     * <action>
     *     <upgrade_action>
     *         start
     *     </upgrade_action>
     * </action>
     * ----
     */
    public interface UpgradeResponse extends Response {
    }
    
    /**
     * Start or finish upgrade process for the cluster based on the action value. This action marks the cluster for
     * upgrade or clears the upgrade running flag on the cluster based on the action value which takes values of
     * start or stop.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/upgrade
     * ----
     * 
     * With a request body like this to mark the cluster for upgrade:
     * 
     * [source,xml]
     * ----
     * <action>
     *     <upgrade_action>
     *         start
     *     </upgrade_action>
     * </action>
     * ----
     */
    UpgradeRequest upgrade();
    
    /**
     * A reference to the service that manages affinity groups.
     */
    AffinityGroupsService affinityGroupsService();
    /**
     * A reference to the service that manages assigned CPU profiles for the cluster.
     */
    AssignedCpuProfilesService cpuProfilesService();
    /**
     * A reference to the service that manages the collection of enabled features for the cluster.
     */
    ClusterEnabledFeaturesService enabledFeaturesService();
    /**
     * A reference to the service that manages the collection of external network providers.
     */
    ClusterExternalProvidersService externalNetworkProvidersService();
    /**
     * A reference to the service that manages the Gluster hooks for the cluster.
     */
    GlusterHooksService glusterHooksService();
    /**
     * A reference to the service that manages Gluster volumes for the cluster.
     */
    GlusterVolumesService glusterVolumesService();
    /**
     * A sub-collection with all the supported network filters for the cluster.
     */
    NetworkFiltersService networkFiltersService();
    /**
     * A reference to the service that manages assigned networks for the cluster.
     */
    ClusterNetworksService networksService();
    /**
     * A reference to permissions.
     */
    AssignedPermissionsService permissionsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

