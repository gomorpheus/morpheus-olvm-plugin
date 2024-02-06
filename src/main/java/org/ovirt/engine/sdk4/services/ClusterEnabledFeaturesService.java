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
import org.ovirt.engine.sdk4.builders.ClusterFeatureBuilder;
import org.ovirt.engine.sdk4.types.ClusterFeature;

/**
 * Provides information about the additional features that are enabled for this cluster.
 * The features that are enabled are the available features for the cluster level
 */
public interface ClusterEnabledFeaturesService extends Service {
    /**
     * Enable an additional feature for a cluster.
     * 
     * For example, to enable a feature `456` on cluster `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/enabledfeatures
     * ----
     * 
     * The request body should look like this:
     * 
     * [source,xml]
     * ----
     * <cluster_feature id="456"/>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest feature(ClusterFeature feature);
        AddRequest feature(ClusterFeatureBuilder feature);
    }
    
    /**
     * Enable an additional feature for a cluster.
     * 
     * For example, to enable a feature `456` on cluster `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/enabledfeatures
     * ----
     * 
     * The request body should look like this:
     * 
     * [source,xml]
     * ----
     * <cluster_feature id="456"/>
     * ----
     */
    public interface AddResponse extends Response {
        ClusterFeature feature();
    }
    
    /**
     * Enable an additional feature for a cluster.
     * 
     * For example, to enable a feature `456` on cluster `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/123/enabledfeatures
     * ----
     * 
     * The request body should look like this:
     * 
     * [source,xml]
     * ----
     * <cluster_feature id="456"/>
     * ----
     */
    AddRequest add();
    
    /**
     * Lists the additional features enabled for the cluster.
     * 
     * For example, to get the features enabled for cluster `123` send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/123/enabledfeatures
     * ----
     * 
     * This will return a list of features:
     * 
     * [source,xml]
     * ----
     * <enabled_features>
     *   <cluster_feature id="123">
     *      <name>test_feature</name>
     *   </cluster_feature>
     *   ...
     * </enabled_features>
     * ----
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * Lists the additional features enabled for the cluster.
     * 
     * For example, to get the features enabled for cluster `123` send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/123/enabledfeatures
     * ----
     * 
     * This will return a list of features:
     * 
     * [source,xml]
     * ----
     * <enabled_features>
     *   <cluster_feature id="123">
     *      <name>test_feature</name>
     *   </cluster_feature>
     *   ...
     * </enabled_features>
     * ----
     */
    public interface ListResponse extends Response {
        /**
         * Retrieved features.
         */
        List<ClusterFeature> features();
    }
    
    /**
     * Lists the additional features enabled for the cluster.
     * 
     * For example, to get the features enabled for cluster `123` send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusters/123/enabledfeatures
     * ----
     * 
     * This will return a list of features:
     * 
     * [source,xml]
     * ----
     * <enabled_features>
     *   <cluster_feature id="123">
     *      <name>test_feature</name>
     *   </cluster_feature>
     *   ...
     * </enabled_features>
     * ----
     */
    ListRequest list();
    
    /**
     * A reference to the service that provides information about a specific
     * feature enabled for the cluster.
     */
    ClusterEnabledFeatureService featureService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

