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
import org.ovirt.engine.sdk4.types.Domain;

/**
 * A service to list all authentication domains in the system.
 */
public interface DomainsService extends Service {
    /**
     * List all the authentication domains in the system.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains
     * ....
     * 
     * Will return the list of domains:
     * 
     * [source,xml]
     * ----
     * <domains>
     *   <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *     <name>internal-authz</name>
     *     <link href="/ovirt-engine/api/domains/5678/users" rel="users"/>
     *     <link href="/ovirt-engine/api/domains/5678/groups" rel="groups"/>
     *     <link href="/ovirt-engine/api/domains/5678/users?search={query}" rel="users/search"/>
     *     <link href="/ovirt-engine/api/domains/5678/groups?search={query}" rel="groups/search"/>
     *   </domain>
     * </domains>
     * ----
     * 
     * The order of the returned list of domains isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of domains to return. If not specified all the domains are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of domains to return. If not specified all the domains are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of domains to return. If not specified all the domains are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List all the authentication domains in the system.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains
     * ....
     * 
     * Will return the list of domains:
     * 
     * [source,xml]
     * ----
     * <domains>
     *   <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *     <name>internal-authz</name>
     *     <link href="/ovirt-engine/api/domains/5678/users" rel="users"/>
     *     <link href="/ovirt-engine/api/domains/5678/groups" rel="groups"/>
     *     <link href="/ovirt-engine/api/domains/5678/users?search={query}" rel="users/search"/>
     *     <link href="/ovirt-engine/api/domains/5678/groups?search={query}" rel="groups/search"/>
     *   </domain>
     * </domains>
     * ----
     * 
     * The order of the returned list of domains isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of domains.
         */
        List<Domain> domains();
    }
    
    /**
     * List all the authentication domains in the system.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains
     * ....
     * 
     * Will return the list of domains:
     * 
     * [source,xml]
     * ----
     * <domains>
     *   <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *     <name>internal-authz</name>
     *     <link href="/ovirt-engine/api/domains/5678/users" rel="users"/>
     *     <link href="/ovirt-engine/api/domains/5678/groups" rel="groups"/>
     *     <link href="/ovirt-engine/api/domains/5678/users?search={query}" rel="users/search"/>
     *     <link href="/ovirt-engine/api/domains/5678/groups?search={query}" rel="groups/search"/>
     *   </domain>
     * </domains>
     * ----
     * 
     * The order of the returned list of domains isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to a service to view details of a domain.
     */
    DomainService domainService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

