/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Api;

public interface SystemService extends Service {
    /**
     * Returns basic information describing the API, like the product name, the version number and a summary of the
     * number of relevant objects.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api
     * ----
     * 
     * We get following response:
     * 
     * [source,xml]
     * ----
     * <api>
     *   <link rel="capabilities" href="/api/capabilities"/>
     *   <link rel="clusters" href="/api/clusters"/>
     *   <link rel="clusters/search" href="/api/clusters?search={query}"/>
     *   <link rel="datacenters" href="/api/datacenters"/>
     *   <link rel="datacenters/search" href="/api/datacenters?search={query}"/>
     *   <link rel="events" href="/api/events"/>
     *   <link rel="events/search" href="/api/events?search={query}"/>
     *   <link rel="hosts" href="/api/hosts"/>
     *   <link rel="hosts/search" href="/api/hosts?search={query}"/>
     *   <link rel="networks" href="/api/networks"/>
     *   <link rel="roles" href="/api/roles"/>
     *   <link rel="storagedomains" href="/api/storagedomains"/>
     *   <link rel="storagedomains/search" href="/api/storagedomains?search={query}"/>
     *   <link rel="tags" href="/api/tags"/>
     *   <link rel="templates" href="/api/templates"/>
     *   <link rel="templates/search" href="/api/templates?search={query}"/>
     *   <link rel="users" href="/api/users"/>
     *   <link rel="groups" href="/api/groups"/>
     *   <link rel="domains" href="/api/domains"/>
     *   <link rel="vmpools" href="/api/vmpools"/>
     *   <link rel="vmpools/search" href="/api/vmpools?search={query}"/>
     *   <link rel="vms" href="/api/vms"/>
     *   <link rel="vms/search" href="/api/vms?search={query}"/>
     *   <product_info>
     *     <name>oVirt Engine</name>
     *     <vendor>ovirt.org</vendor>
     *     <version>
     *       <build>4</build>
     *       <full_version>4.0.4</full_version>
     *       <major>4</major>
     *       <minor>0</minor>
     *       <revision>0</revision>
     *     </version>
     *   </product_info>
     *   <special_objects>
     *     <blank_template href="/ovirt-engine/api/templates/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000"/>
     *     <root_tag href="/ovirt-engine/api/tags/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000"/>
     *   </special_objects>
     *   <summary>
     *     <hosts>
     *       <active>0</active>
     *       <total>0</total>
     *     </hosts>
     *     <storage_domains>
     *       <active>0</active>
     *       <total>1</total>
     *     </storage_domains>
     *     <users>
     *       <active>1</active>
     *       <total>1</total>
     *     </users>
     *     <vms>
     *       <active>0</active>
     *       <total>0</total>
     *     </vms>
     *   </summary>
     *   <time>2016-09-14T12:00:48.132+02:00</time>
     * </api>
     * ----
     * 
     * The entry point provides a user with links to the collections in a
     * virtualization environment. The `rel` attribute of each collection link
     * provides a reference point for each link.
     * 
     * The entry point also contains other data such as `product_info`,
     * `special_objects` and `summary`.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns basic information describing the API, like the product name, the version number and a summary of the
     * number of relevant objects.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api
     * ----
     * 
     * We get following response:
     * 
     * [source,xml]
     * ----
     * <api>
     *   <link rel="capabilities" href="/api/capabilities"/>
     *   <link rel="clusters" href="/api/clusters"/>
     *   <link rel="clusters/search" href="/api/clusters?search={query}"/>
     *   <link rel="datacenters" href="/api/datacenters"/>
     *   <link rel="datacenters/search" href="/api/datacenters?search={query}"/>
     *   <link rel="events" href="/api/events"/>
     *   <link rel="events/search" href="/api/events?search={query}"/>
     *   <link rel="hosts" href="/api/hosts"/>
     *   <link rel="hosts/search" href="/api/hosts?search={query}"/>
     *   <link rel="networks" href="/api/networks"/>
     *   <link rel="roles" href="/api/roles"/>
     *   <link rel="storagedomains" href="/api/storagedomains"/>
     *   <link rel="storagedomains/search" href="/api/storagedomains?search={query}"/>
     *   <link rel="tags" href="/api/tags"/>
     *   <link rel="templates" href="/api/templates"/>
     *   <link rel="templates/search" href="/api/templates?search={query}"/>
     *   <link rel="users" href="/api/users"/>
     *   <link rel="groups" href="/api/groups"/>
     *   <link rel="domains" href="/api/domains"/>
     *   <link rel="vmpools" href="/api/vmpools"/>
     *   <link rel="vmpools/search" href="/api/vmpools?search={query}"/>
     *   <link rel="vms" href="/api/vms"/>
     *   <link rel="vms/search" href="/api/vms?search={query}"/>
     *   <product_info>
     *     <name>oVirt Engine</name>
     *     <vendor>ovirt.org</vendor>
     *     <version>
     *       <build>4</build>
     *       <full_version>4.0.4</full_version>
     *       <major>4</major>
     *       <minor>0</minor>
     *       <revision>0</revision>
     *     </version>
     *   </product_info>
     *   <special_objects>
     *     <blank_template href="/ovirt-engine/api/templates/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000"/>
     *     <root_tag href="/ovirt-engine/api/tags/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000"/>
     *   </special_objects>
     *   <summary>
     *     <hosts>
     *       <active>0</active>
     *       <total>0</total>
     *     </hosts>
     *     <storage_domains>
     *       <active>0</active>
     *       <total>1</total>
     *     </storage_domains>
     *     <users>
     *       <active>1</active>
     *       <total>1</total>
     *     </users>
     *     <vms>
     *       <active>0</active>
     *       <total>0</total>
     *     </vms>
     *   </summary>
     *   <time>2016-09-14T12:00:48.132+02:00</time>
     * </api>
     * ----
     * 
     * The entry point provides a user with links to the collections in a
     * virtualization environment. The `rel` attribute of each collection link
     * provides a reference point for each link.
     * 
     * The entry point also contains other data such as `product_info`,
     * `special_objects` and `summary`.
     */
    public interface GetResponse extends Response {
        Api api();
    }
    
    /**
     * Returns basic information describing the API, like the product name, the version number and a summary of the
     * number of relevant objects.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api
     * ----
     * 
     * We get following response:
     * 
     * [source,xml]
     * ----
     * <api>
     *   <link rel="capabilities" href="/api/capabilities"/>
     *   <link rel="clusters" href="/api/clusters"/>
     *   <link rel="clusters/search" href="/api/clusters?search={query}"/>
     *   <link rel="datacenters" href="/api/datacenters"/>
     *   <link rel="datacenters/search" href="/api/datacenters?search={query}"/>
     *   <link rel="events" href="/api/events"/>
     *   <link rel="events/search" href="/api/events?search={query}"/>
     *   <link rel="hosts" href="/api/hosts"/>
     *   <link rel="hosts/search" href="/api/hosts?search={query}"/>
     *   <link rel="networks" href="/api/networks"/>
     *   <link rel="roles" href="/api/roles"/>
     *   <link rel="storagedomains" href="/api/storagedomains"/>
     *   <link rel="storagedomains/search" href="/api/storagedomains?search={query}"/>
     *   <link rel="tags" href="/api/tags"/>
     *   <link rel="templates" href="/api/templates"/>
     *   <link rel="templates/search" href="/api/templates?search={query}"/>
     *   <link rel="users" href="/api/users"/>
     *   <link rel="groups" href="/api/groups"/>
     *   <link rel="domains" href="/api/domains"/>
     *   <link rel="vmpools" href="/api/vmpools"/>
     *   <link rel="vmpools/search" href="/api/vmpools?search={query}"/>
     *   <link rel="vms" href="/api/vms"/>
     *   <link rel="vms/search" href="/api/vms?search={query}"/>
     *   <product_info>
     *     <name>oVirt Engine</name>
     *     <vendor>ovirt.org</vendor>
     *     <version>
     *       <build>4</build>
     *       <full_version>4.0.4</full_version>
     *       <major>4</major>
     *       <minor>0</minor>
     *       <revision>0</revision>
     *     </version>
     *   </product_info>
     *   <special_objects>
     *     <blank_template href="/ovirt-engine/api/templates/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000"/>
     *     <root_tag href="/ovirt-engine/api/tags/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000"/>
     *   </special_objects>
     *   <summary>
     *     <hosts>
     *       <active>0</active>
     *       <total>0</total>
     *     </hosts>
     *     <storage_domains>
     *       <active>0</active>
     *       <total>1</total>
     *     </storage_domains>
     *     <users>
     *       <active>1</active>
     *       <total>1</total>
     *     </users>
     *     <vms>
     *       <active>0</active>
     *       <total>0</total>
     *     </vms>
     *   </summary>
     *   <time>2016-09-14T12:00:48.132+02:00</time>
     * </api>
     * ----
     * 
     * The entry point provides a user with links to the collections in a
     * virtualization environment. The `rel` attribute of each collection link
     * provides a reference point for each link.
     * 
     * The entry point also contains other data such as `product_info`,
     * `special_objects` and `summary`.
     */
    GetRequest get();
    
    public interface ReloadConfigurationsRequest extends Request<ReloadConfigurationsRequest, ReloadConfigurationsResponse> {
        /**
         * Indicates if the reload should be performed asynchronously.
         */
        ReloadConfigurationsRequest async(Boolean async);
    }
    
    public interface ReloadConfigurationsResponse extends Response {
    }
    
    ReloadConfigurationsRequest reloadConfigurations();
    
    /**
     * List all known affinity labels.
     */
    AffinityLabelsService affinityLabelsService();
    BookmarksService bookmarksService();
    /**
     * Reference to the service that provides information about the cluster levels supported by the system.
     */
    ClusterLevelsService clusterLevelsService();
    ClustersService clustersService();
    CpuProfilesService cpuProfilesService();
    DataCentersService dataCentersService();
    DiskProfilesService diskProfilesService();
    DisksService disksService();
    DomainsService domainsService();
    EventsService eventsService();
    ExternalHostProvidersService externalHostProvidersService();
    /**
     * Reference to service facilitating import of external templates.
     */
    ExternalTemplateImportsService externalTemplateImportsService();
    /**
     * Reference to service facilitating import of external virtual machines.
     */
    ExternalVmImportsService externalVmImportsService();
    GroupsService groupsService();
    HostsService hostsService();
    IconsService iconsService();
    /**
     * List of all image transfers being performed for image I/O in oVirt.
     */
    ImageTransfersService imageTransfersService();
    InstanceTypesService instanceTypesService();
    /**
     * List all the jobs monitored by the engine.
     */
    JobsService jobsService();
    /**
     * List the available Katello errata assigned to the engine.
     */
    EngineKatelloErrataService katelloErrataService();
    MacPoolsService macPoolsService();
    /**
     * Network filters will enhance the admin ability to manage the network packets traffic from/to the participated
     * VMs.
     */
    NetworkFiltersService networkFiltersService();
    NetworksService networksService();
    OpenstackImageProvidersService openstackImageProvidersService();
    OpenstackNetworkProvidersService openstackNetworkProvidersService();
    OpenstackVolumeProvidersService openstackVolumeProvidersService();
    OperatingSystemsService operatingSystemsService();
    /**
     * Reference to the service that provides values of configuration options of the system.
     */
    SystemOptionsService optionsService();
    SystemPermissionsService permissionsService();
    RolesService rolesService();
    SchedulingPoliciesService schedulingPoliciesService();
    SchedulingPolicyUnitsService schedulingPolicyUnitsService();
    StorageServerConnectionsService storageConnectionsService();
    StorageDomainsService storageDomainsService();
    TagsService tagsService();
    TemplatesService templatesService();
    UsersService usersService();
    VmPoolsService vmPoolsService();
    VmsService vmsService();
    VnicProfilesService vnicProfilesService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

