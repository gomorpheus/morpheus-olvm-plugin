/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.types.GlusterHook;
import org.ovirt.engine.sdk4.types.Host;

public interface GlusterHookService extends Service {
    /**
     * Resolves status conflict of hook among servers in cluster by disabling Gluster hook in all servers of the
     * cluster. This updates the hook status to `DISABLED` in database.
     */
    public interface DisableRequest extends Request<DisableRequest, DisableResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        DisableRequest async(Boolean async);
    }
    
    /**
     * Resolves status conflict of hook among servers in cluster by disabling Gluster hook in all servers of the
     * cluster. This updates the hook status to `DISABLED` in database.
     */
    public interface DisableResponse extends Response {
    }
    
    /**
     * Resolves status conflict of hook among servers in cluster by disabling Gluster hook in all servers of the
     * cluster. This updates the hook status to `DISABLED` in database.
     */
    DisableRequest disable();
    
    /**
     * Resolves status conflict of hook among servers in cluster by disabling Gluster hook in all servers of the
     * cluster. This updates the hook status to `DISABLED` in database.
     */
    public interface EnableRequest extends Request<EnableRequest, EnableResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        EnableRequest async(Boolean async);
    }
    
    /**
     * Resolves status conflict of hook among servers in cluster by disabling Gluster hook in all servers of the
     * cluster. This updates the hook status to `DISABLED` in database.
     */
    public interface EnableResponse extends Response {
    }
    
    /**
     * Resolves status conflict of hook among servers in cluster by disabling Gluster hook in all servers of the
     * cluster. This updates the hook status to `DISABLED` in database.
     */
    EnableRequest enable();
    
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        GlusterHook hook();
    }
    
    GetRequest get();
    
    /**
     * Removes the this Gluster hook from all servers in cluster and deletes it from the database.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the this Gluster hook from all servers in cluster and deletes it from the database.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the this Gluster hook from all servers in cluster and deletes it from the database.
     */
    RemoveRequest remove();
    
    /**
     * Resolves missing hook conflict depending on the resolution type.
     * 
     * For `ADD` resolves by copying hook stored in engine database to all servers where the hook is missing. The
     * engine maintains a list of all servers where hook is missing.
     * 
     * For `COPY` resolves conflict in hook content by copying hook stored in engine database to all servers where
     * the hook is missing. The engine maintains a list of all servers where the content is conflicting. If a host
     * id is passed as parameter, the hook content from the server is used as the master to copy to other servers
     * in cluster.
     */
    public interface ResolveRequest extends Request<ResolveRequest, ResolveResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        ResolveRequest async(Boolean async);
        ResolveRequest host(Host host);
        ResolveRequest host(HostBuilder host);
        ResolveRequest resolutionType(String resolutionType);
    }
    
    /**
     * Resolves missing hook conflict depending on the resolution type.
     * 
     * For `ADD` resolves by copying hook stored in engine database to all servers where the hook is missing. The
     * engine maintains a list of all servers where hook is missing.
     * 
     * For `COPY` resolves conflict in hook content by copying hook stored in engine database to all servers where
     * the hook is missing. The engine maintains a list of all servers where the content is conflicting. If a host
     * id is passed as parameter, the hook content from the server is used as the master to copy to other servers
     * in cluster.
     */
    public interface ResolveResponse extends Response {
    }
    
    /**
     * Resolves missing hook conflict depending on the resolution type.
     * 
     * For `ADD` resolves by copying hook stored in engine database to all servers where the hook is missing. The
     * engine maintains a list of all servers where hook is missing.
     * 
     * For `COPY` resolves conflict in hook content by copying hook stored in engine database to all servers where
     * the hook is missing. The engine maintains a list of all servers where the content is conflicting. If a host
     * id is passed as parameter, the hook content from the server is used as the master to copy to other servers
     * in cluster.
     */
    ResolveRequest resolve();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

