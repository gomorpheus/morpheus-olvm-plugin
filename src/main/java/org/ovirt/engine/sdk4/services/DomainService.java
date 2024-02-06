/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Domain;

/**
 * A service to view details of an authentication domain in the system.
 */
public interface DomainService extends Service {
    /**
     * Gets the authentication domain information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains/5678
     * ....
     * 
     * Will return the domain information:
     * 
     * [source,xml]
     * ----
     * <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *   <name>internal-authz</name>
     *   <link href="/ovirt-engine/api/domains/5678/users" rel="users"/>
     *   <link href="/ovirt-engine/api/domains/5678/groups" rel="groups"/>
     *   <link href="/ovirt-engine/api/domains/5678/users?search={query}" rel="users/search"/>
     *   <link href="/ovirt-engine/api/domains/5678/groups?search={query}" rel="groups/search"/>
     * </domain>
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
     * Gets the authentication domain information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains/5678
     * ....
     * 
     * Will return the domain information:
     * 
     * [source,xml]
     * ----
     * <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *   <name>internal-authz</name>
     *   <link href="/ovirt-engine/api/domains/5678/users" rel="users"/>
     *   <link href="/ovirt-engine/api/domains/5678/groups" rel="groups"/>
     *   <link href="/ovirt-engine/api/domains/5678/users?search={query}" rel="users/search"/>
     *   <link href="/ovirt-engine/api/domains/5678/groups?search={query}" rel="groups/search"/>
     * </domain>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The authentication domain.
         */
        Domain domain();
    }
    
    /**
     * Gets the authentication domain information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains/5678
     * ....
     * 
     * Will return the domain information:
     * 
     * [source,xml]
     * ----
     * <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *   <name>internal-authz</name>
     *   <link href="/ovirt-engine/api/domains/5678/users" rel="users"/>
     *   <link href="/ovirt-engine/api/domains/5678/groups" rel="groups"/>
     *   <link href="/ovirt-engine/api/domains/5678/users?search={query}" rel="users/search"/>
     *   <link href="/ovirt-engine/api/domains/5678/groups?search={query}" rel="groups/search"/>
     * </domain>
     * ----
     */
    GetRequest get();
    
    /**
     * Reference to a service to manage domain groups.
     */
    DomainGroupsService groupsService();
    /**
     * Reference to a service to manage domain users.
     */
    DomainUsersService usersService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

