/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.ClusterFeature;

/**
 * Represents a feature enabled for the cluster level
 */
public interface ClusterFeatureService extends Service {
    /**
     * Provides the information about the a cluster feature supported by a cluster level.
     * 
     * For example, to find details of the cluster feature `456` for cluster level 4.1, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/4.1/clusterfeatures/456
     * ----
     * 
     * That will return a <<types/cluster_feature, ClusterFeature>> object containing the name:
     * 
     * [source,xml]
     * ----
     * <cluster_feature id="456">
     *   <name>libgfapi_supported</name>
     * </cluster_feature>
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
     * Provides the information about the a cluster feature supported by a cluster level.
     * 
     * For example, to find details of the cluster feature `456` for cluster level 4.1, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/4.1/clusterfeatures/456
     * ----
     * 
     * That will return a <<types/cluster_feature, ClusterFeature>> object containing the name:
     * 
     * [source,xml]
     * ----
     * <cluster_feature id="456">
     *   <name>libgfapi_supported</name>
     * </cluster_feature>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Retrieved cluster feature.
         */
        ClusterFeature feature();
    }
    
    /**
     * Provides the information about the a cluster feature supported by a cluster level.
     * 
     * For example, to find details of the cluster feature `456` for cluster level 4.1, send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/4.1/clusterfeatures/456
     * ----
     * 
     * That will return a <<types/cluster_feature, ClusterFeature>> object containing the name:
     * 
     * [source,xml]
     * ----
     * <cluster_feature id="456">
     *   <name>libgfapi_supported</name>
     * </cluster_feature>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

