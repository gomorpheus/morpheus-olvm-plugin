/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.DataCenterBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.StorageDomain;

/**
 * A service to manage a data center.
 */
public interface DataCenterService extends Service {
    /**
     * Currently, the storage pool manager (SPM) fails to
     * switch to another host if the SPM has uncleared tasks.
     * Clearing all finished tasks enables the SPM switching.
     * 
     * For example, to clean all the finished tasks on a data center with ID `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/cleanfinishedtasks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface CleanFinishedTasksRequest extends Request<CleanFinishedTasksRequest, CleanFinishedTasksResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        CleanFinishedTasksRequest async(Boolean async);
    }
    
    /**
     * Currently, the storage pool manager (SPM) fails to
     * switch to another host if the SPM has uncleared tasks.
     * Clearing all finished tasks enables the SPM switching.
     * 
     * For example, to clean all the finished tasks on a data center with ID `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/cleanfinishedtasks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface CleanFinishedTasksResponse extends Response {
    }
    
    /**
     * Currently, the storage pool manager (SPM) fails to
     * switch to another host if the SPM has uncleared tasks.
     * Clearing all finished tasks enables the SPM switching.
     * 
     * For example, to clean all the finished tasks on a data center with ID `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/cleanfinishedtasks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    CleanFinishedTasksRequest cleanFinishedTasks();
    
    /**
     * Get a data center.
     * 
     * An example of getting a data center:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters/123
     * ----
     * 
     * [source,xml]
     * ----
     * <data_center href="/ovirt-engine/api/datacenters/123" id="123">
     *   <name>Default</name>
     *   <description>The default Data Center</description>
     *   <link href="/ovirt-engine/api/datacenters/123/clusters" rel="clusters"/>
     *   <link href="/ovirt-engine/api/datacenters/123/storagedomains" rel="storagedomains"/>
     *   <link href="/ovirt-engine/api/datacenters/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/datacenters/123/networks" rel="networks"/>
     *   <link href="/ovirt-engine/api/datacenters/123/quotas" rel="quotas"/>
     *   <link href="/ovirt-engine/api/datacenters/123/qoss" rel="qoss"/>
     *   <link href="/ovirt-engine/api/datacenters/123/iscsibonds" rel="iscsibonds"/>
     *   <local>false</local>
     *   <quota_mode>disabled</quota_mode>
     *   <status>up</status>
     *   <storage_format>v3</storage_format>
     *   <supported_versions>
     *     <version>
     *       <major>4</major>
     *       <minor>0</minor>
     *    </version>
     *   </supported_versions>
     *   <version>
     *     <major>4</major>
     *     <minor>0</minor>
     *   </version>
     *   <mac_pool href="/ovirt-engine/api/macpools/456" id="456"/>
     * </data_center>
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
     * Get a data center.
     * 
     * An example of getting a data center:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters/123
     * ----
     * 
     * [source,xml]
     * ----
     * <data_center href="/ovirt-engine/api/datacenters/123" id="123">
     *   <name>Default</name>
     *   <description>The default Data Center</description>
     *   <link href="/ovirt-engine/api/datacenters/123/clusters" rel="clusters"/>
     *   <link href="/ovirt-engine/api/datacenters/123/storagedomains" rel="storagedomains"/>
     *   <link href="/ovirt-engine/api/datacenters/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/datacenters/123/networks" rel="networks"/>
     *   <link href="/ovirt-engine/api/datacenters/123/quotas" rel="quotas"/>
     *   <link href="/ovirt-engine/api/datacenters/123/qoss" rel="qoss"/>
     *   <link href="/ovirt-engine/api/datacenters/123/iscsibonds" rel="iscsibonds"/>
     *   <local>false</local>
     *   <quota_mode>disabled</quota_mode>
     *   <status>up</status>
     *   <storage_format>v3</storage_format>
     *   <supported_versions>
     *     <version>
     *       <major>4</major>
     *       <minor>0</minor>
     *    </version>
     *   </supported_versions>
     *   <version>
     *     <major>4</major>
     *     <minor>0</minor>
     *   </version>
     *   <mac_pool href="/ovirt-engine/api/macpools/456" id="456"/>
     * </data_center>
     * ----
     */
    public interface GetResponse extends Response {
        DataCenter dataCenter();
    }
    
    /**
     * Get a data center.
     * 
     * An example of getting a data center:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters/123
     * ----
     * 
     * [source,xml]
     * ----
     * <data_center href="/ovirt-engine/api/datacenters/123" id="123">
     *   <name>Default</name>
     *   <description>The default Data Center</description>
     *   <link href="/ovirt-engine/api/datacenters/123/clusters" rel="clusters"/>
     *   <link href="/ovirt-engine/api/datacenters/123/storagedomains" rel="storagedomains"/>
     *   <link href="/ovirt-engine/api/datacenters/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/datacenters/123/networks" rel="networks"/>
     *   <link href="/ovirt-engine/api/datacenters/123/quotas" rel="quotas"/>
     *   <link href="/ovirt-engine/api/datacenters/123/qoss" rel="qoss"/>
     *   <link href="/ovirt-engine/api/datacenters/123/iscsibonds" rel="iscsibonds"/>
     *   <local>false</local>
     *   <quota_mode>disabled</quota_mode>
     *   <status>up</status>
     *   <storage_format>v3</storage_format>
     *   <supported_versions>
     *     <version>
     *       <major>4</major>
     *       <minor>0</minor>
     *    </version>
     *   </supported_versions>
     *   <version>
     *     <major>4</major>
     *     <minor>0</minor>
     *   </version>
     *   <mac_pool href="/ovirt-engine/api/macpools/456" id="456"/>
     * </data_center>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes the data center.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123
     * ----
     * 
     * Without any special parameters, the storage domains attached to the data center are detached and then removed
     * from the storage. If something fails when performing this operation, for example if there is no host available to
     * remove the storage domains from the storage, the complete operation will fail.
     * 
     * If the `force` parameter is `true` then the operation will always succeed, even if something fails while removing
     * one storage domain, for example. The failure is just ignored and the data center is removed from the database
     * anyway.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
        /**
         * Indicates if the operation should succeed, and the storage domain removed from the database, even if
         * something fails during the operation.
         * 
         * This parameter is optional, and the default value is `false`.
         */
        RemoveRequest force(Boolean force);
    }
    
    /**
     * Removes the data center.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123
     * ----
     * 
     * Without any special parameters, the storage domains attached to the data center are detached and then removed
     * from the storage. If something fails when performing this operation, for example if there is no host available to
     * remove the storage domains from the storage, the complete operation will fail.
     * 
     * If the `force` parameter is `true` then the operation will always succeed, even if something fails while removing
     * one storage domain, for example. The failure is just ignored and the data center is removed from the database
     * anyway.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the data center.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123
     * ----
     * 
     * Without any special parameters, the storage domains attached to the data center are detached and then removed
     * from the storage. If something fails when performing this operation, for example if there is no host available to
     * remove the storage domains from the storage, the complete operation will fail.
     * 
     * If the `force` parameter is `true` then the operation will always succeed, even if something fails while removing
     * one storage domain, for example. The failure is just ignored and the data center is removed from the database
     * anyway.
     */
    RemoveRequest remove();
    
    /**
     * Used for manually setting a storage domain in the data center as a master.
     * For example, for setting a storage domain with ID '456' as a master on a data center with ID '123',
     * send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/setmaster
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     * </action>
     * ----
     * 
     * The new master storage domain can be also specified by its name.
     */
    public interface SetMasterRequest extends Request<SetMasterRequest, SetMasterResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        SetMasterRequest async(Boolean async);
        SetMasterRequest storageDomain(StorageDomain storageDomain);
        /**
         * The new master storage domain for the data center.
         */
        SetMasterRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Used for manually setting a storage domain in the data center as a master.
     * For example, for setting a storage domain with ID '456' as a master on a data center with ID '123',
     * send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/setmaster
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     * </action>
     * ----
     * 
     * The new master storage domain can be also specified by its name.
     */
    public interface SetMasterResponse extends Response {
    }
    
    /**
     * Used for manually setting a storage domain in the data center as a master.
     * For example, for setting a storage domain with ID '456' as a master on a data center with ID '123',
     * send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/setmaster
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     * </action>
     * ----
     * 
     * The new master storage domain can be also specified by its name.
     */
    SetMasterRequest setMaster();
    
    /**
     * Updates the data center.
     * 
     * The `name`, `description`, `storage_type`, `version`, `storage_format` and `mac_pool` elements are updatable
     * post-creation. For example, to change the name and description of data center `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <data_center>
     *   <name>myupdatedname</name>
     *   <description>An updated description for the data center</description>
     * </data_center>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest dataCenter(DataCenter dataCenter);
        /**
         * The data center that is being updated.
         */
        UpdateRequest dataCenter(DataCenterBuilder dataCenter);
    }
    
    /**
     * Updates the data center.
     * 
     * The `name`, `description`, `storage_type`, `version`, `storage_format` and `mac_pool` elements are updatable
     * post-creation. For example, to change the name and description of data center `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <data_center>
     *   <name>myupdatedname</name>
     *   <description>An updated description for the data center</description>
     * </data_center>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * The data center that is being updated.
         */
        DataCenter dataCenter();
    }
    
    /**
     * Updates the data center.
     * 
     * The `name`, `description`, `storage_type`, `version`, `storage_format` and `mac_pool` elements are updatable
     * post-creation. For example, to change the name and description of data center `123` send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <data_center>
     *   <name>myupdatedname</name>
     *   <description>An updated description for the data center</description>
     * </data_center>
     * ----
     */
    UpdateRequest update();
    
    ClustersService clustersService();
    /**
     * Reference to the iSCSI bonds service.
     */
    IscsiBondsService iscsiBondsService();
    /**
     * Returns a reference to the service, that manages the networks, that are associated with the data center.
     */
    DataCenterNetworksService networksService();
    /**
     * Reference to the permissions service.
     */
    AssignedPermissionsService permissionsService();
    /**
     * Reference to the QOSs service.
     */
    QossService qossService();
    /**
     * Reference to the quotas service.
     */
    QuotasService quotasService();
    /**
     * Attach and detach storage domains to and from a data center.
     * 
     * For attaching a single storage domain we should use the following POST request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/storagedomains
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>data1</name>
     * </storage_domain>
     * ----
     * 
     * For detaching a single storage domain we should use the following DELETE request:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/storagedomains/123
     * ----
     */
    AttachedStorageDomainsService storageDomainsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

