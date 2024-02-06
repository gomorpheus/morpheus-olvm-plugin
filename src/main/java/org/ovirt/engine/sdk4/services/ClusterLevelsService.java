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
import org.ovirt.engine.sdk4.types.ClusterLevel;

/**
 * Provides information about the capabilities of different cluster levels supported by the engine. Version 4.0 of the
 * engine supports levels 4.0 and 3.6. Each of these levels support different sets of CPU types, for example. This
 * service provides that information.
 */
public interface ClusterLevelsService extends Service {
    /**
     * Lists the cluster levels supported by the system.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels
     * ----
     * 
     * This will return a list of available cluster levels.
     * 
     * [source,xml]
     * ----
     * <cluster_levels>
     *   <cluster_level id="4.0">
     *      ...
     *   </cluster_level>
     *   ...
     * </cluster_levels>
     * ----
     * 
     * The order of the returned cluster levels isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * Lists the cluster levels supported by the system.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels
     * ----
     * 
     * This will return a list of available cluster levels.
     * 
     * [source,xml]
     * ----
     * <cluster_levels>
     *   <cluster_level id="4.0">
     *      ...
     *   </cluster_level>
     *   ...
     * </cluster_levels>
     * ----
     * 
     * The order of the returned cluster levels isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * Retrieved cluster levels.
         */
        List<ClusterLevel> levels();
    }
    
    /**
     * Lists the cluster levels supported by the system.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels
     * ----
     * 
     * This will return a list of available cluster levels.
     * 
     * [source,xml]
     * ----
     * <cluster_levels>
     *   <cluster_level id="4.0">
     *      ...
     *   </cluster_level>
     *   ...
     * </cluster_levels>
     * ----
     * 
     * The order of the returned cluster levels isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that provides information about an specific cluster level.
     */
    ClusterLevelService levelService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

