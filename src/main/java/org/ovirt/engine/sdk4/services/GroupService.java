/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Group;

/**
 * Manages a group of users. Use this service to either get groups details or remove groups. In order
 * to add new groups please use <<services/groups, service>> that manages the collection of groups.
 */
public interface GroupService extends Service {
    /**
     * Gets the system group information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/groups/123
     * ....
     * 
     * Will return the group information:
     * 
     * [source,xml]
     * ----
     * <group href="/ovirt-engine/api/groups/123" id="123">
     *   <name>mygroup</name>
     *   <link href="/ovirt-engine/api/groups/123/roles" rel="roles"/>
     *   <link href="/ovirt-engine/api/groups/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/groups/123/tags" rel="tags"/>
     *   <domain_entry_id>476652557A382F67696B6D2B32762B37796E46476D513D3D</domain_entry_id>
     *   <namespace>DC=example,DC=com</namespace>
     *   <domain href="/ovirt-engine/api/domains/ABCDEF" id="ABCDEF">
     *     <name>myextension-authz</name>
     *   </domain>
     * </group>
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
     * Gets the system group information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/groups/123
     * ....
     * 
     * Will return the group information:
     * 
     * [source,xml]
     * ----
     * <group href="/ovirt-engine/api/groups/123" id="123">
     *   <name>mygroup</name>
     *   <link href="/ovirt-engine/api/groups/123/roles" rel="roles"/>
     *   <link href="/ovirt-engine/api/groups/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/groups/123/tags" rel="tags"/>
     *   <domain_entry_id>476652557A382F67696B6D2B32762B37796E46476D513D3D</domain_entry_id>
     *   <namespace>DC=example,DC=com</namespace>
     *   <domain href="/ovirt-engine/api/domains/ABCDEF" id="ABCDEF">
     *     <name>myextension-authz</name>
     *   </domain>
     * </group>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The system group.
         */
        Group get();
    }
    
    /**
     * Gets the system group information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/groups/123
     * ....
     * 
     * Will return the group information:
     * 
     * [source,xml]
     * ----
     * <group href="/ovirt-engine/api/groups/123" id="123">
     *   <name>mygroup</name>
     *   <link href="/ovirt-engine/api/groups/123/roles" rel="roles"/>
     *   <link href="/ovirt-engine/api/groups/123/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/groups/123/tags" rel="tags"/>
     *   <domain_entry_id>476652557A382F67696B6D2B32762B37796E46476D513D3D</domain_entry_id>
     *   <namespace>DC=example,DC=com</namespace>
     *   <domain href="/ovirt-engine/api/domains/ABCDEF" id="ABCDEF">
     *     <name>myextension-authz</name>
     *   </domain>
     * </group>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes the system group.
     * 
     * Usage:
     * 
     * ....
     * DELETE /ovirt-engine/api/groups/123
     * ....
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the system group.
     * 
     * Usage:
     * 
     * ....
     * DELETE /ovirt-engine/api/groups/123
     * ....
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the system group.
     * 
     * Usage:
     * 
     * ....
     * DELETE /ovirt-engine/api/groups/123
     * ....
     */
    RemoveRequest remove();
    
    /**
     * Reference to the service that manages the collection of permissions assigned to this system group.
     */
    AssignedPermissionsService permissionsService();
    /**
     * Reference to the service that manages the collection of roles assigned to this system group.
     */
    AssignedRolesService rolesService();
    /**
     * Reference to the service that manages the collection of tags assigned to this system group.
     */
    AssignedTagsService tagsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

