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
import org.ovirt.engine.sdk4.types.Role;

/**
 * Represents a roles sub-collection, for example scoped by user.
 */
public interface AssignedRolesService extends Service {
    /**
     * Returns the roles assigned to the permission.
     * 
     * The order of the returned roles isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of roles to return. If not specified all the roles are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of roles to return. If not specified all the roles are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of roles to return. If not specified all the roles are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the roles assigned to the permission.
     * 
     * The order of the returned roles isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Role> roles();
    }
    
    /**
     * Returns the roles assigned to the permission.
     * 
     * The order of the returned roles isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Sub-resource locator method, returns individual role resource on which the remainder of the URI is dispatched.
     */
    RoleService roleService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

