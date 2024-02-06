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
import org.ovirt.engine.sdk4.types.User;

/**
 * A service to list all domain users in the system.
 */
public interface DomainUsersService extends Service {
    /**
     * List all the users in the domain.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains/5678/users
     * ....
     * 
     * Will return the list of users in the domain:
     * 
     * [source,xml]
     * ----
     * <users>
     *   <user href="/ovirt-engine/api/domains/5678/users/1234" id="1234">
     *     <name>admin</name>
     *     <namespace>*</namespace>
     *     <principal>admin</principal>
     *     <user_name>admin@internal-authz</user_name>
     *     <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *       <name>internal-authz</name>
     *     </domain>
     *     <groups/>
     *   </user>
     * </users>
     * ----
     * 
     * The order of the returned list of users isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of users to return. If not specified all the users are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of users to return. If not specified all the users are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of users to return. If not specified all the users are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned users.
         */
        ListRequest search(String search);
    }
    
    /**
     * List all the users in the domain.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains/5678/users
     * ....
     * 
     * Will return the list of users in the domain:
     * 
     * [source,xml]
     * ----
     * <users>
     *   <user href="/ovirt-engine/api/domains/5678/users/1234" id="1234">
     *     <name>admin</name>
     *     <namespace>*</namespace>
     *     <principal>admin</principal>
     *     <user_name>admin@internal-authz</user_name>
     *     <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *       <name>internal-authz</name>
     *     </domain>
     *     <groups/>
     *   </user>
     * </users>
     * ----
     * 
     * The order of the returned list of users isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of users in the domain.
         */
        List<User> users();
    }
    
    /**
     * List all the users in the domain.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains/5678/users
     * ....
     * 
     * Will return the list of users in the domain:
     * 
     * [source,xml]
     * ----
     * <users>
     *   <user href="/ovirt-engine/api/domains/5678/users/1234" id="1234">
     *     <name>admin</name>
     *     <namespace>*</namespace>
     *     <principal>admin</principal>
     *     <user_name>admin@internal-authz</user_name>
     *     <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *       <name>internal-authz</name>
     *     </domain>
     *     <groups/>
     *   </user>
     * </users>
     * ----
     * 
     * The order of the returned list of users isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to a service to view details of a domain user.
     */
    DomainUserService userService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

