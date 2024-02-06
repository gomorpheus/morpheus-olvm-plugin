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
import org.ovirt.engine.sdk4.types.Session;

/**
 * Provides information about virtual machine user sessions.
 */
public interface VmSessionsService extends Service {
    /**
     * Lists all user sessions for this virtual machine.
     * 
     * For example, to retrieve the session information for virtual machine `123` send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/sessions
     * ----
     * 
     * The response body will contain something like this:
     * 
     * [source,xml]
     * ----
     * <sessions>
     *   <session href="/ovirt-engine/api/vms/123/sessions/456" id="456">
     *     <console_user>true</console_user>
     *     <ip>
     *       <address>192.168.122.1</address>
     *     </ip>
     *     <user href="/ovirt-engine/api/users/789" id="789"/>
     *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   </session>
     *   ...
     * </sessions>
     * ----
     * 
     * The order of the returned list of sessions isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of sessions to return. If not specified all the sessions are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of sessions to return. If not specified all the sessions are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of sessions to return. If not specified all the sessions are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Lists all user sessions for this virtual machine.
     * 
     * For example, to retrieve the session information for virtual machine `123` send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/sessions
     * ----
     * 
     * The response body will contain something like this:
     * 
     * [source,xml]
     * ----
     * <sessions>
     *   <session href="/ovirt-engine/api/vms/123/sessions/456" id="456">
     *     <console_user>true</console_user>
     *     <ip>
     *       <address>192.168.122.1</address>
     *     </ip>
     *     <user href="/ovirt-engine/api/users/789" id="789"/>
     *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   </session>
     *   ...
     * </sessions>
     * ----
     * 
     * The order of the returned list of sessions isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Session> sessions();
    }
    
    /**
     * Lists all user sessions for this virtual machine.
     * 
     * For example, to retrieve the session information for virtual machine `123` send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/sessions
     * ----
     * 
     * The response body will contain something like this:
     * 
     * [source,xml]
     * ----
     * <sessions>
     *   <session href="/ovirt-engine/api/vms/123/sessions/456" id="456">
     *     <console_user>true</console_user>
     *     <ip>
     *       <address>192.168.122.1</address>
     *     </ip>
     *     <user href="/ovirt-engine/api/users/789" id="789"/>
     *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   </session>
     *   ...
     * </sessions>
     * ----
     * 
     * The order of the returned list of sessions isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific session.
     */
    VmSessionService sessionService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

