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
import org.ovirt.engine.sdk4.types.ClusterFeature;

/**
 * Provides information about the cluster features that are supported by a cluster level.
 */
public interface ClusterFeaturesService extends Service {
    /**
     * Lists the cluster features supported by the cluster level.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/4.1/clusterfeatures
     * ----
     * 
     * This will return a list of cluster features supported by the cluster level:
     * 
     * [source,xml]
     * ----
     * <cluster_features>
     *   <cluster_feature id="123">
     *      <name>test_feature</name>
     *   </cluster_feature>
     *   ...
     * </cluster_features>
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
     * Lists the cluster features supported by the cluster level.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/4.1/clusterfeatures
     * ----
     * 
     * This will return a list of cluster features supported by the cluster level:
     * 
     * [source,xml]
     * ----
     * <cluster_features>
     *   <cluster_feature id="123">
     *      <name>test_feature</name>
     *   </cluster_feature>
     *   ...
     * </cluster_features>
     * ----
     */
    public interface ListResponse extends Response {
        /**
         * Retrieved features.
         */
        List<ClusterFeature> features();
    }
    
    /**
     * Lists the cluster features supported by the cluster level.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/4.1/clusterfeatures
     * ----
     * 
     * This will return a list of cluster features supported by the cluster level:
     * 
     * [source,xml]
     * ----
     * <cluster_features>
     *   <cluster_feature id="123">
     *      <name>test_feature</name>
     *   </cluster_feature>
     *   ...
     * </cluster_features>
     * ----
     */
    ListRequest list();
    
    /**
     * Reference to the service that provides information about a specific feature.
     */
    ClusterFeatureService featureService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

