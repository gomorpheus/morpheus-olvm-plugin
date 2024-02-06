/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.RoleBuilder;
import org.ovirt.engine.sdk4.types.Role;

public interface RoleService extends Service {
    /**
     * Get the role.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/roles/123
     * ----
     * 
     * You will receive XML response like this one:
     * 
     * [source,xml]
     * ----
     * <role id="123">
     *   <name>MyRole</name>
     *   <description>MyRole description</description>
     *   <link href="/ovirt-engine/api/roles/123/permits" rel="permits"/>
     *   <administrative>true</administrative>
     *   <mutable>false</mutable>
     * </role>
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
     * Get the role.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/roles/123
     * ----
     * 
     * You will receive XML response like this one:
     * 
     * [source,xml]
     * ----
     * <role id="123">
     *   <name>MyRole</name>
     *   <description>MyRole description</description>
     *   <link href="/ovirt-engine/api/roles/123/permits" rel="permits"/>
     *   <administrative>true</administrative>
     *   <mutable>false</mutable>
     * </role>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Retrieved role.
         */
        Role role();
    }
    
    /**
     * Get the role.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/roles/123
     * ----
     * 
     * You will receive XML response like this one:
     * 
     * [source,xml]
     * ----
     * <role id="123">
     *   <name>MyRole</name>
     *   <description>MyRole description</description>
     *   <link href="/ovirt-engine/api/roles/123/permits" rel="permits"/>
     *   <administrative>true</administrative>
     *   <mutable>false</mutable>
     * </role>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes the role.
     * 
     * To remove the role you need to know its id, then send request like this:
     * 
     * [source]
     * ----
 * DELETE /ovirt-engine/api/roles/{role_id}
 * ----
 */
public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
    /**
     * Indicates if the remove should be performed asynchronously.
     */
    RemoveRequest async(Boolean async);
}

/**
 * Removes the role.
 * 
 * To remove the role you need to know its id, then send request like this:
 * 
 * [source]
 * ----
 * DELETE /ovirt-engine/api/roles/{role_id}
 * ----
 */
public interface RemoveResponse extends Response {
}

/**
 * Removes the role.
 * 
 * To remove the role you need to know its id, then send request like this:
 * 
 * [source]
 * ----
 * DELETE /ovirt-engine/api/roles/{role_id}
 * ----
 */
RemoveRequest remove();

/**
 * Updates a role. You are allowed to update `name`, `description` and `administrative` attributes after role is
 * created. Within this endpoint you can't add or remove roles permits you need to use
 * <<services/permits, service>> that manages permits of role.
 * 
 * For example to update role's `name`, `description` and `administrative` attributes send a request like this:
 * 
 * [source]
 * ----
 * PUT /ovirt-engine/api/roles/123
 * ----
 * 
 * With a request body like this:
 * 
 * [source,xml]
 * ----
 * <role>
 *   <name>MyNewRoleName</name>
 *   <description>My new description of the role</description>
 *   <administrative>true</administrative>
 * </group>
 * ----
 */
public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
    /**
     * Indicates if the update should be performed asynchronously.
     */
    UpdateRequest async(Boolean async);
    UpdateRequest role(Role role);
    /**
     * Updated role.
     */
    UpdateRequest role(RoleBuilder role);
}

/**
 * Updates a role. You are allowed to update `name`, `description` and `administrative` attributes after role is
 * created. Within this endpoint you can't add or remove roles permits you need to use
 * <<services/permits, service>> that manages permits of role.
 * 
 * For example to update role's `name`, `description` and `administrative` attributes send a request like this:
 * 
 * [source]
 * ----
 * PUT /ovirt-engine/api/roles/123
 * ----
 * 
 * With a request body like this:
 * 
 * [source,xml]
 * ----
 * <role>
 *   <name>MyNewRoleName</name>
 *   <description>My new description of the role</description>
 *   <administrative>true</administrative>
 * </group>
 * ----
 */
public interface UpdateResponse extends Response {
    /**
     * Updated role.
     */
    Role role();
}

/**
 * Updates a role. You are allowed to update `name`, `description` and `administrative` attributes after role is
 * created. Within this endpoint you can't add or remove roles permits you need to use
 * <<services/permits, service>> that manages permits of role.
 * 
 * For example to update role's `name`, `description` and `administrative` attributes send a request like this:
 * 
 * [source]
 * ----
 * PUT /ovirt-engine/api/roles/123
 * ----
 * 
 * With a request body like this:
 * 
 * [source,xml]
 * ----
 * <role>
 *   <name>MyNewRoleName</name>
 *   <description>My new description of the role</description>
 *   <administrative>true</administrative>
 * </group>
 * ----
 */
UpdateRequest update();

/**
 * Sub-resource locator method, returns permits service.
 */
PermitsService permitsService();
/**
 * Service locator method, returns individual service on which the URI is dispatched.
 */
Service service(String path);
}

