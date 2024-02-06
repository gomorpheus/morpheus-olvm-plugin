/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.ClusterLevel;

/**
 * Provides information about a specific cluster level. See the <<services/cluster_levels,ClusterLevels>> service for
 * more information.
 */
public interface ClusterLevelService extends Service {
    /**
     * Provides the information about the capabilities of the specific cluster level managed by this service.
     * 
     * For example, to find what CPU types are supported by level 3.6 you can send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/3.6
     * ----
     * 
     * That will return a <<types/cluster_level, ClusterLevel>> object containing the supported CPU types, and other
     * information which describes the cluster level:
     * 
     * [source,xml]
     * ----
     * <cluster_level id="3.6">
     *   <cpu_types>
     *     <cpu_type>
     *       <name>Intel Nehalem Family</name>
     *       <level>3</level>
     *       <architecture>x86_64</architecture>
     *     </cpu_type>
     *     ...
     *   </cpu_types>
     *   <permits>
     *     <permit id="1">
     *       <name>create_vm</name>
     *       <administrative>false</administrative>
     *     </permit>
     *     ...
     *   </permits>
     * </cluster_level>
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
     * Provides the information about the capabilities of the specific cluster level managed by this service.
     * 
     * For example, to find what CPU types are supported by level 3.6 you can send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/3.6
     * ----
     * 
     * That will return a <<types/cluster_level, ClusterLevel>> object containing the supported CPU types, and other
     * information which describes the cluster level:
     * 
     * [source,xml]
     * ----
     * <cluster_level id="3.6">
     *   <cpu_types>
     *     <cpu_type>
     *       <name>Intel Nehalem Family</name>
     *       <level>3</level>
     *       <architecture>x86_64</architecture>
     *     </cpu_type>
     *     ...
     *   </cpu_types>
     *   <permits>
     *     <permit id="1">
     *       <name>create_vm</name>
     *       <administrative>false</administrative>
     *     </permit>
     *     ...
     *   </permits>
     * </cluster_level>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Retreived cluster level.
         */
        ClusterLevel level();
    }
    
    /**
     * Provides the information about the capabilities of the specific cluster level managed by this service.
     * 
     * For example, to find what CPU types are supported by level 3.6 you can send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/3.6
     * ----
     * 
     * That will return a <<types/cluster_level, ClusterLevel>> object containing the supported CPU types, and other
     * information which describes the cluster level:
     * 
     * [source,xml]
     * ----
     * <cluster_level id="3.6">
     *   <cpu_types>
     *     <cpu_type>
     *       <name>Intel Nehalem Family</name>
     *       <level>3</level>
     *       <architecture>x86_64</architecture>
     *     </cpu_type>
     *     ...
     *   </cpu_types>
     *   <permits>
     *     <permit id="1">
     *       <name>create_vm</name>
     *       <administrative>false</administrative>
     *     </permit>
     *     ...
     *   </permits>
     * </cluster_level>
     * ----
     */
    GetRequest get();
    
    /**
     * Reference to the service that manages the collection of supported features for this cluster level.
     */
    ClusterFeaturesService clusterFeaturesService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

