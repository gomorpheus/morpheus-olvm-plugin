/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.User;

/**
 * A service to view a domain user in the system.
 */
public interface DomainUserService extends Service {
    /**
     * Gets the domain user information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains/5678/users/1234
     * ....
     * 
     * Will return the domain user information:
     * 
     * [source,xml]
     * ----
     * <user href="/ovirt-engine/api/users/1234" id="1234">
     *   <name>admin</name>
     *   <namespace>*</namespace>
     *   <principal>admin</principal>
     *   <user_name>admin@internal-authz</user_name>
     *   <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *     <name>internal-authz</name>
     *   </domain>
     *   <groups/>
     * </user>
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
     * Gets the domain user information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains/5678/users/1234
     * ....
     * 
     * Will return the domain user information:
     * 
     * [source,xml]
     * ----
     * <user href="/ovirt-engine/api/users/1234" id="1234">
     *   <name>admin</name>
     *   <namespace>*</namespace>
     *   <principal>admin</principal>
     *   <user_name>admin@internal-authz</user_name>
     *   <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *     <name>internal-authz</name>
     *   </domain>
     *   <groups/>
     * </user>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The domain user.
         */
        User user();
    }
    
    /**
     * Gets the domain user information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/domains/5678/users/1234
     * ....
     * 
     * Will return the domain user information:
     * 
     * [source,xml]
     * ----
     * <user href="/ovirt-engine/api/users/1234" id="1234">
     *   <name>admin</name>
     *   <namespace>*</namespace>
     *   <principal>admin</principal>
     *   <user_name>admin@internal-authz</user_name>
     *   <domain href="/ovirt-engine/api/domains/5678" id="5678">
     *     <name>internal-authz</name>
     *   </domain>
     *   <groups/>
     * </user>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

