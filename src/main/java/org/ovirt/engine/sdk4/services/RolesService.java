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
import org.ovirt.engine.sdk4.builders.RoleBuilder;
import org.ovirt.engine.sdk4.types.Role;

/**
 * Provides read-only access to the global set of roles
 */
public interface RolesService extends Service {
    /**
     * Create a new role. The role can be administrative or non-administrative and can have different permits.
     * 
     * For example, to add the `MyRole` non-administrative role with permits to login and create virtual machines
     * send a request like this (note that you have to pass permit id):
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/roles
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <role>
     *   <name>MyRole</name>
     *   <description>My custom role to create virtual machines</description>
     *   <administrative>false</administrative>
     *   <permits>
     *     <permit id="1"/>
     *     <permit id="1300"/>
     *   </permits>
     * </group>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest role(Role role);
        /**
         * Role that will be added.
         */
        AddRequest role(RoleBuilder role);
    }
    
    /**
     * Create a new role. The role can be administrative or non-administrative and can have different permits.
     * 
     * For example, to add the `MyRole` non-administrative role with permits to login and create virtual machines
     * send a request like this (note that you have to pass permit id):
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/roles
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <role>
     *   <name>MyRole</name>
     *   <description>My custom role to create virtual machines</description>
     *   <administrative>false</administrative>
     *   <permits>
     *     <permit id="1"/>
     *     <permit id="1300"/>
     *   </permits>
     * </group>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * Role that will be added.
         */
        Role role();
    }
    
    /**
     * Create a new role. The role can be administrative or non-administrative and can have different permits.
     * 
     * For example, to add the `MyRole` non-administrative role with permits to login and create virtual machines
     * send a request like this (note that you have to pass permit id):
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/roles
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <role>
     *   <name>MyRole</name>
     *   <description>My custom role to create virtual machines</description>
     *   <administrative>false</administrative>
     *   <permits>
     *     <permit id="1"/>
     *     <permit id="1300"/>
     *   </permits>
     * </group>
     * ----
     */
    AddRequest add();
    
    /**
     * List roles.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/roles
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <roles>
     *   <role id="123">
     *      <name>SuperUser</name>
     *      <description>Roles management administrator</description>
     *      <link href="/ovirt-engine/api/roles/123/permits" rel="permits"/>
     *      <administrative>true</administrative>
     *      <mutable>false</mutable>
     *   </role>
     *   ...
     * </roles>
     * ----
     * 
     * The order of the returned list of roles isn't guaranteed.
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
     * List roles.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/roles
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <roles>
     *   <role id="123">
     *      <name>SuperUser</name>
     *      <description>Roles management administrator</description>
     *      <link href="/ovirt-engine/api/roles/123/permits" rel="permits"/>
     *      <administrative>true</administrative>
     *      <mutable>false</mutable>
     *   </role>
     *   ...
     * </roles>
     * ----
     * 
     * The order of the returned list of roles isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * Retrieved list of roles.
         */
        List<Role> roles();
    }
    
    /**
     * List roles.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/roles
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <roles>
     *   <role id="123">
     *      <name>SuperUser</name>
     *      <description>Roles management administrator</description>
     *      <link href="/ovirt-engine/api/roles/123/permits" rel="permits"/>
     *      <administrative>true</administrative>
     *      <mutable>false</mutable>
     *   </role>
     *   ...
     * </roles>
     * ----
     * 
     * The order of the returned list of roles isn't guaranteed.
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

