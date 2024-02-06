/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.HostStorage;

/**
 * A service to manage host storages.
 */
public interface HostStorageService extends Service {
    /**
     * Get list of storages.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/storage
     * ----
     * 
     * The XML response you get will be like this one:
     * 
     * [source,xml]
     * ----
     * <host_storages>
     *   <host_storage id="123">
     *     ...
     *   </host_storage>
     *   ...
     * </host_storages>
     * ----
     * 
     * The order of the returned list of storages isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Indicates if the status of the LUNs in the storage should be checked.
         * Checking the status of the LUN is an heavy weight operation and
         * this data is not always needed by the user.
         * This parameter will give the option to not perform the status check of the LUNs.
         * 
         * The default is `true` for backward compatibility.
         * 
         * Here an example with the LUN status :
         * 
         * [source,xml]
         * ----
         * <host_storage id="123">
         *   <logical_units>
         *     <logical_unit id="123">
         *       <lun_mapping>0</lun_mapping>
         *       <paths>1</paths>
         *       <product_id>lun0</product_id>
         *       <serial>123</serial>
         *       <size>10737418240</size>
         *       <status>used</status>
         *       <vendor_id>LIO-ORG</vendor_id>
         *       <volume_group_id>123</volume_group_id>
         *     </logical_unit>
         *   </logical_units>
         *   <type>iscsi</type>
         *   <host id="123"/>
         * </host_storage>
         * ----
         * 
         * Here an example without the LUN status :
         * 
         * [source,xml]
         * ----
         * <host_storage id="123">
         *   <logical_units>
         *     <logical_unit id="123">
         *       <lun_mapping>0</lun_mapping>
         *       <paths>1</paths>
         *       <product_id>lun0</product_id>
         *       <serial>123</serial>
         *       <size>10737418240</size>
         *       <vendor_id>LIO-ORG</vendor_id>
         *       <volume_group_id>123</volume_group_id>
         *     </logical_unit>
         *   </logical_units>
         *   <type>iscsi</type>
         *   <host id="123"/>
         * </host_storage>
         * ----
         */
        ListRequest reportStatus(Boolean reportStatus);
    }
    
    /**
     * Get list of storages.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/storage
     * ----
     * 
     * The XML response you get will be like this one:
     * 
     * [source,xml]
     * ----
     * <host_storages>
     *   <host_storage id="123">
     *     ...
     *   </host_storage>
     *   ...
     * </host_storages>
     * ----
     * 
     * The order of the returned list of storages isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * Retrieved list of storages.
         */
        List<HostStorage> storages();
    }
    
    /**
     * Get list of storages.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/storage
     * ----
     * 
     * The XML response you get will be like this one:
     * 
     * [source,xml]
     * ----
     * <host_storages>
     *   <host_storage id="123">
     *     ...
     *   </host_storage>
     *   ...
     * </host_storages>
     * ----
     * 
     * The order of the returned list of storages isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to a service managing the storage.
     */
    StorageService storageService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

