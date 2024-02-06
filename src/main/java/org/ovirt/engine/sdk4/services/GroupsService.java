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
import org.ovirt.engine.sdk4.builders.GroupBuilder;
import org.ovirt.engine.sdk4.types.Group;

/**
 * Manages the collection of groups of users.
 */
public interface GroupsService extends Service {
    /**
     * Add group from a directory service. Please note that domain name is name of the authorization provider.
     * 
     * For example, to add the `Developers` group from the `internal-authz` authorization provider send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/groups
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <group>
     *   <name>Developers</name>
     *   <domain>
     *     <name>internal-authz</name>
     *   </domain>
     * </group>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest group(Group group);
        /**
         * The group to be added.
         */
        AddRequest group(GroupBuilder group);
    }
    
    /**
     * Add group from a directory service. Please note that domain name is name of the authorization provider.
     * 
     * For example, to add the `Developers` group from the `internal-authz` authorization provider send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/groups
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <group>
     *   <name>Developers</name>
     *   <domain>
     *     <name>internal-authz</name>
     *   </domain>
     * </group>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The group to be added.
         */
        Group group();
    }
    
    /**
     * Add group from a directory service. Please note that domain name is name of the authorization provider.
     * 
     * For example, to add the `Developers` group from the `internal-authz` authorization provider send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/groups
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <group>
     *   <name>Developers</name>
     *   <domain>
     *     <name>internal-authz</name>
     *   </domain>
     * </group>
     * ----
     */
    AddRequest add();
    
    /**
     * List all the groups in the system.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/groups
     * ....
     * 
     * Will return the list of groups:
     * 
     * [source,xml]
     * ----
     * <groups>
     *   <group href="/ovirt-engine/api/groups/123" id="123">
     *     <name>mygroup</name>
     *     <link href="/ovirt-engine/api/groups/123/roles" rel="roles"/>
     *     <link href="/ovirt-engine/api/groups/123/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/groups/123/tags" rel="tags"/>
     *     <domain_entry_id>476652557A382F67696B6D2B32762B37796E46476D513D3D</domain_entry_id>
     *     <namespace>DC=example,DC=com</namespace>
     *     <domain href="/ovirt-engine/api/domains/ABCDEF" id="ABCDEF">
     *       <name>myextension-authz</name>
     *     </domain>
     *   </group>
     *   ...
     * </groups>
     * ----
     * 
     * The order of the returned list of groups isn't guaranteed.
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
         * Sets the maximum number of groups to return. If not specified all the groups are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of groups to return. If not specified all the groups are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of groups to return. If not specified all the groups are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned groups.
         */
        ListRequest search(String search);
    }
    
    /**
     * List all the groups in the system.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/groups
     * ....
     * 
     * Will return the list of groups:
     * 
     * [source,xml]
     * ----
     * <groups>
     *   <group href="/ovirt-engine/api/groups/123" id="123">
     *     <name>mygroup</name>
     *     <link href="/ovirt-engine/api/groups/123/roles" rel="roles"/>
     *     <link href="/ovirt-engine/api/groups/123/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/groups/123/tags" rel="tags"/>
     *     <domain_entry_id>476652557A382F67696B6D2B32762B37796E46476D513D3D</domain_entry_id>
     *     <namespace>DC=example,DC=com</namespace>
     *     <domain href="/ovirt-engine/api/domains/ABCDEF" id="ABCDEF">
     *       <name>myextension-authz</name>
     *     </domain>
     *   </group>
     *   ...
     * </groups>
     * ----
     * 
     * The order of the returned list of groups isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of groups.
         */
        List<Group> groups();
    }
    
    /**
     * List all the groups in the system.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/groups
     * ....
     * 
     * Will return the list of groups:
     * 
     * [source,xml]
     * ----
     * <groups>
     *   <group href="/ovirt-engine/api/groups/123" id="123">
     *     <name>mygroup</name>
     *     <link href="/ovirt-engine/api/groups/123/roles" rel="roles"/>
     *     <link href="/ovirt-engine/api/groups/123/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/groups/123/tags" rel="tags"/>
     *     <domain_entry_id>476652557A382F67696B6D2B32762B37796E46476D513D3D</domain_entry_id>
     *     <namespace>DC=example,DC=com</namespace>
     *     <domain href="/ovirt-engine/api/domains/ABCDEF" id="ABCDEF">
     *       <name>myextension-authz</name>
     *     </domain>
     *   </group>
     *   ...
     * </groups>
     * ----
     * 
     * The order of the returned list of groups isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific group.
     */
    GroupService groupService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

