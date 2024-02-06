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
import org.ovirt.engine.sdk4.builders.DataCenterBuilder;
import org.ovirt.engine.sdk4.types.DataCenter;

/**
 * A service to manage data centers.
 */
public interface DataCentersService extends Service {
    /**
     * Creates a new data center.
     * 
     * Creation of a new data center requires the `name` and `local` elements. For example, to create a data center
     * named `mydc` that uses shared storage (NFS, iSCSI or fibre channel) send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <data_center>
     *   <name>mydc</name>
     *   <local>false</local>
     * </data_center>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest dataCenter(DataCenter dataCenter);
        /**
         * The data center that is being added.
         */
        AddRequest dataCenter(DataCenterBuilder dataCenter);
    }
    
    /**
     * Creates a new data center.
     * 
     * Creation of a new data center requires the `name` and `local` elements. For example, to create a data center
     * named `mydc` that uses shared storage (NFS, iSCSI or fibre channel) send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <data_center>
     *   <name>mydc</name>
     *   <local>false</local>
     * </data_center>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The data center that is being added.
         */
        DataCenter dataCenter();
    }
    
    /**
     * Creates a new data center.
     * 
     * Creation of a new data center requires the `name` and `local` elements. For example, to create a data center
     * named `mydc` that uses shared storage (NFS, iSCSI or fibre channel) send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <data_center>
     *   <name>mydc</name>
     *   <local>false</local>
     * </data_center>
     * ----
     */
    AddRequest add();
    
    /**
     * Lists the data centers.
     * 
     * The following request retrieves a representation of the data centers:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters
     * ----
     * 
     * The above request performed with `curl`:
     * 
     * [source,bash]
     * ----
     * curl \
     * --request GET \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --header "Version: 4" \
     * --header "Accept: application/xml" \
     * --user "admin@internal:mypassword" \
     * https://myengine.example.com/ovirt-engine/api/datacenters
     * ----
     * 
     * This is what an example response could look like:
     * 
     * [source,xml]
     * ----
     * <data_center href="/ovirt-engine/api/datacenters/123" id="123">
     *   <name>Default</name>
     *   <description>The default Data Center</description>
     *   <link href="/ovirt-engine/api/datacenters/123/networks" rel="networks"/>
     *   <link href="/ovirt-engine/api/datacenters/123/storagedomains" rel="storagedomains"/>
     *   <link href="/ovirt-engine/api/datacenters/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/datacenters/123/clusters" rel="clusters"/>
     *   <link href="/ovirt-engine/api/datacenters/123/qoss" rel="qoss"/>
     *   <link href="/ovirt-engine/api/datacenters/123/iscsibonds" rel="iscsibonds"/>
     *   <link href="/ovirt-engine/api/datacenters/123/quotas" rel="quotas"/>
     *   <local>false</local>
     *   <quota_mode>disabled</quota_mode>
     *   <status>up</status>
     *   <supported_versions>
     *     <version>
     *       <major>4</major>
     *       <minor>0</minor>
     *     </version>
     *   </supported_versions>
     *   <version>
     *     <major>4</major>
     *     <minor>0</minor>
     *   </version>
     * </data_center>
     * ----
     * 
     * Note the `id` code of your `Default` data center. This code identifies this data center in relation to other
     * resources of your virtual environment.
     * 
     * The data center also contains a link to the storage domains collection. The data center uses this collection to
     * attach storage domains from the storage domains main collection.
     * 
     * The order of the returned list of data centers is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ListRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of data centers to return. If not specified all the data centers are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of data centers to return. If not specified all the data centers are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of data centers to return. If not specified all the data centers are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned data centers.
         */
        ListRequest search(String search);
    }
    
    /**
     * Lists the data centers.
     * 
     * The following request retrieves a representation of the data centers:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters
     * ----
     * 
     * The above request performed with `curl`:
     * 
     * [source,bash]
     * ----
     * curl \
     * --request GET \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --header "Version: 4" \
     * --header "Accept: application/xml" \
     * --user "admin@internal:mypassword" \
     * https://myengine.example.com/ovirt-engine/api/datacenters
     * ----
     * 
     * This is what an example response could look like:
     * 
     * [source,xml]
     * ----
     * <data_center href="/ovirt-engine/api/datacenters/123" id="123">
     *   <name>Default</name>
     *   <description>The default Data Center</description>
     *   <link href="/ovirt-engine/api/datacenters/123/networks" rel="networks"/>
     *   <link href="/ovirt-engine/api/datacenters/123/storagedomains" rel="storagedomains"/>
     *   <link href="/ovirt-engine/api/datacenters/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/datacenters/123/clusters" rel="clusters"/>
     *   <link href="/ovirt-engine/api/datacenters/123/qoss" rel="qoss"/>
     *   <link href="/ovirt-engine/api/datacenters/123/iscsibonds" rel="iscsibonds"/>
     *   <link href="/ovirt-engine/api/datacenters/123/quotas" rel="quotas"/>
     *   <local>false</local>
     *   <quota_mode>disabled</quota_mode>
     *   <status>up</status>
     *   <supported_versions>
     *     <version>
     *       <major>4</major>
     *       <minor>0</minor>
     *     </version>
     *   </supported_versions>
     *   <version>
     *     <major>4</major>
     *     <minor>0</minor>
     *   </version>
     * </data_center>
     * ----
     * 
     * Note the `id` code of your `Default` data center. This code identifies this data center in relation to other
     * resources of your virtual environment.
     * 
     * The data center also contains a link to the storage domains collection. The data center uses this collection to
     * attach storage domains from the storage domains main collection.
     * 
     * The order of the returned list of data centers is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListResponse extends Response {
        List<DataCenter> dataCenters();
    }
    
    /**
     * Lists the data centers.
     * 
     * The following request retrieves a representation of the data centers:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters
     * ----
     * 
     * The above request performed with `curl`:
     * 
     * [source,bash]
     * ----
     * curl \
     * --request GET \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --header "Version: 4" \
     * --header "Accept: application/xml" \
     * --user "admin@internal:mypassword" \
     * https://myengine.example.com/ovirt-engine/api/datacenters
     * ----
     * 
     * This is what an example response could look like:
     * 
     * [source,xml]
     * ----
     * <data_center href="/ovirt-engine/api/datacenters/123" id="123">
     *   <name>Default</name>
     *   <description>The default Data Center</description>
     *   <link href="/ovirt-engine/api/datacenters/123/networks" rel="networks"/>
     *   <link href="/ovirt-engine/api/datacenters/123/storagedomains" rel="storagedomains"/>
     *   <link href="/ovirt-engine/api/datacenters/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/datacenters/123/clusters" rel="clusters"/>
     *   <link href="/ovirt-engine/api/datacenters/123/qoss" rel="qoss"/>
     *   <link href="/ovirt-engine/api/datacenters/123/iscsibonds" rel="iscsibonds"/>
     *   <link href="/ovirt-engine/api/datacenters/123/quotas" rel="quotas"/>
     *   <local>false</local>
     *   <quota_mode>disabled</quota_mode>
     *   <status>up</status>
     *   <supported_versions>
     *     <version>
     *       <major>4</major>
     *       <minor>0</minor>
     *     </version>
     *   </supported_versions>
     *   <version>
     *     <major>4</major>
     *     <minor>0</minor>
     *   </version>
     * </data_center>
     * ----
     * 
     * Note the `id` code of your `Default` data center. This code identifies this data center in relation to other
     * resources of your virtual environment.
     * 
     * The data center also contains a link to the storage domains collection. The data center uses this collection to
     * attach storage domains from the storage domains main collection.
     * 
     * The order of the returned list of data centers is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific data center.
     */
    DataCenterService dataCenterService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

