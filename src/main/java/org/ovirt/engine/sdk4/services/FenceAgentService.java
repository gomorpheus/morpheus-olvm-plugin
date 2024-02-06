/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.AgentBuilder;
import org.ovirt.engine.sdk4.types.Agent;

/**
 * A service to manage fence agent for a specific host.
 */
public interface FenceAgentService extends Service {
    /**
     * Gets details of this fence agent.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/fenceagents/0
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <agent id="0">
     *   <type>apc</type>
     *   <order>1</order>
     *   <ip>192.168.1.101</ip>
     *   <user>user</user>
     *   <password>xxx</password>
     *   <port>9</port>
     *   <options>name1=value1, name2=value2</options>
     * </agent>
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
     * Gets details of this fence agent.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/fenceagents/0
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <agent id="0">
     *   <type>apc</type>
     *   <order>1</order>
     *   <ip>192.168.1.101</ip>
     *   <user>user</user>
     *   <password>xxx</password>
     *   <port>9</port>
     *   <options>name1=value1, name2=value2</options>
     * </agent>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Fence agent details.
         */
        Agent agent();
    }
    
    /**
     * Gets details of this fence agent.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/fenceagents/0
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <agent id="0">
     *   <type>apc</type>
     *   <order>1</order>
     *   <ip>192.168.1.101</ip>
     *   <user>user</user>
     *   <password>xxx</password>
     *   <port>9</port>
     *   <options>name1=value1, name2=value2</options>
     * </agent>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes a fence agent for a specific host.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/hosts/123/fenceagents/0
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes a fence agent for a specific host.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/hosts/123/fenceagents/0
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a fence agent for a specific host.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/hosts/123/fenceagents/0
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Update a fencing-agent.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        UpdateRequest agent(Agent agent);
        /**
         * Fence agent details.
         */
        UpdateRequest agent(AgentBuilder agent);
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
    }
    
    /**
     * Update a fencing-agent.
     */
    public interface UpdateResponse extends Response {
        /**
         * Fence agent details.
         */
        Agent agent();
    }
    
    /**
     * Update a fencing-agent.
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

