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
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.types.Cluster;

/**
 * A service to manage clusters.
 */
public interface ClustersService extends Service {
    /**
     * Creates a new cluster.
     * 
     * This requires the `name`, `cpu.type`, and `data_center` attributes. Identify the data center with either the `id`
     * or `name` attribute.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <cluster>
     *   <name>mycluster</name>
     *   <cpu>
     *     <type>Intel Nehalem Family</type>
     *   </cpu>
     *   <data_center id="123"/>
     * </cluster>
     * ----
     * 
     * To create a cluster with an external network provider to be deployed on
     * every host that is added to the cluster, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters
     * ----
     * 
     * With a request body containing a reference to the desired provider:
     * 
     * [source,xml]
     * ----
     * <cluster>
     *   <name>mycluster</name>
     *   <cpu>
     *     <type>Intel Nehalem Family</type>
     *   </cpu>
     *   <data_center id="123"/>
     *   <external_network_providers>
     *     <external_provider name="ovirt-provider-ovn"/>
     *   </external_network_providers>
     * </cluster>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest cluster(Cluster cluster);
        AddRequest cluster(ClusterBuilder cluster);
    }
    
    /**
     * Creates a new cluster.
     * 
     * This requires the `name`, `cpu.type`, and `data_center` attributes. Identify the data center with either the `id`
     * or `name` attribute.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <cluster>
     *   <name>mycluster</name>
     *   <cpu>
     *     <type>Intel Nehalem Family</type>
     *   </cpu>
     *   <data_center id="123"/>
     * </cluster>
     * ----
     * 
     * To create a cluster with an external network provider to be deployed on
     * every host that is added to the cluster, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters
     * ----
     * 
     * With a request body containing a reference to the desired provider:
     * 
     * [source,xml]
     * ----
     * <cluster>
     *   <name>mycluster</name>
     *   <cpu>
     *     <type>Intel Nehalem Family</type>
     *   </cpu>
     *   <data_center id="123"/>
     *   <external_network_providers>
     *     <external_provider name="ovirt-provider-ovn"/>
     *   </external_network_providers>
     * </cluster>
     * ----
     */
    public interface AddResponse extends Response {
        Cluster cluster();
    }
    
    /**
     * Creates a new cluster.
     * 
     * This requires the `name`, `cpu.type`, and `data_center` attributes. Identify the data center with either the `id`
     * or `name` attribute.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <cluster>
     *   <name>mycluster</name>
     *   <cpu>
     *     <type>Intel Nehalem Family</type>
     *   </cpu>
     *   <data_center id="123"/>
     * </cluster>
     * ----
     * 
     * To create a cluster with an external network provider to be deployed on
     * every host that is added to the cluster, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters
     * ----
     * 
     * With a request body containing a reference to the desired provider:
     * 
     * [source,xml]
     * ----
     * <cluster>
     *   <name>mycluster</name>
     *   <cpu>
     *     <type>Intel Nehalem Family</type>
     *   </cpu>
     *   <data_center id="123"/>
     *   <external_network_providers>
     *     <external_provider name="ovirt-provider-ovn"/>
     *   </external_network_providers>
     * </cluster>
     * ----
     */
    AddRequest add();
    
    /**
     * Returns the list of clusters of the system.
     * 
     * The order of the returned clusters is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search should be performed taking case into account.
         * The default value is `true`, which means that case is taken into account. To search
         * ignoring case, set it to `false`.
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
         * Sets the maximum number of clusters to return. If not specified, all the clusters are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of clusters to return. If not specified, all the clusters are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of clusters to return. If not specified, all the clusters are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned clusters.
         */
        ListRequest search(String search);
    }
    
    /**
     * Returns the list of clusters of the system.
     * 
     * The order of the returned clusters is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListResponse extends Response {
        List<Cluster> clusters();
    }
    
    /**
     * Returns the list of clusters of the system.
     * 
     * The order of the returned clusters is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    ListRequest list();
    
    /**
     * A reference to the service that manages a specific cluster.
     */
    ClusterService clusterService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

