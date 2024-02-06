/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.UserBuilder;
import org.ovirt.engine.sdk4.types.User;

/**
 * A service to manage a user in the system.
 * Use this service to either get users details or remove users.
 * In order to add new users please use
 * <<services/users>>.
 */
public interface UserService extends Service {
    /**
     * Gets the system user information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/users/1234
     * ....
     * 
     * Will return the user information:
     * 
     * [source,xml]
     * ----
     * <user href="/ovirt-engine/api/users/1234" id="1234">
     *   <name>admin</name>
     *   <link href="/ovirt-engine/api/users/1234/sshpublickeys" rel="sshpublickeys"/>
     *   <link href="/ovirt-engine/api/users/1234/roles" rel="roles"/>
     *   <link href="/ovirt-engine/api/users/1234/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/users/1234/tags" rel="tags"/>
     *   <department></department>
     *   <domain_entry_id>23456</domain_entry_id>
     *   <email>user1@domain.com</email>
     *   <last_name>Lastname</last_name>
     *   <namespace>*</namespace>
     *   <principal>user1</principal>
     *   <user_name>user1@domain-authz</user_name>
     *   <domain href="/ovirt-engine/api/domains/45678" id="45678">
     *     <name>domain-authz</name>
     *   </domain>
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
     * Gets the system user information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/users/1234
     * ....
     * 
     * Will return the user information:
     * 
     * [source,xml]
     * ----
     * <user href="/ovirt-engine/api/users/1234" id="1234">
     *   <name>admin</name>
     *   <link href="/ovirt-engine/api/users/1234/sshpublickeys" rel="sshpublickeys"/>
     *   <link href="/ovirt-engine/api/users/1234/roles" rel="roles"/>
     *   <link href="/ovirt-engine/api/users/1234/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/users/1234/tags" rel="tags"/>
     *   <department></department>
     *   <domain_entry_id>23456</domain_entry_id>
     *   <email>user1@domain.com</email>
     *   <last_name>Lastname</last_name>
     *   <namespace>*</namespace>
     *   <principal>user1</principal>
     *   <user_name>user1@domain-authz</user_name>
     *   <domain href="/ovirt-engine/api/domains/45678" id="45678">
     *     <name>domain-authz</name>
     *   </domain>
     * </user>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The system user.
         */
        User user();
    }
    
    /**
     * Gets the system user information.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/users/1234
     * ....
     * 
     * Will return the user information:
     * 
     * [source,xml]
     * ----
     * <user href="/ovirt-engine/api/users/1234" id="1234">
     *   <name>admin</name>
     *   <link href="/ovirt-engine/api/users/1234/sshpublickeys" rel="sshpublickeys"/>
     *   <link href="/ovirt-engine/api/users/1234/roles" rel="roles"/>
     *   <link href="/ovirt-engine/api/users/1234/permissions" rel="permissions"/>
     *   <link href="/ovirt-engine/api/users/1234/tags" rel="tags"/>
     *   <department></department>
     *   <domain_entry_id>23456</domain_entry_id>
     *   <email>user1@domain.com</email>
     *   <last_name>Lastname</last_name>
     *   <namespace>*</namespace>
     *   <principal>user1</principal>
     *   <user_name>user1@domain-authz</user_name>
     *   <domain href="/ovirt-engine/api/domains/45678" id="45678">
     *     <name>domain-authz</name>
     *   </domain>
     * </user>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes the system user.
     * 
     * Usage:
     * 
     * ....
     * DELETE /ovirt-engine/api/users/1234
     * ....
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the system user.
     * 
     * Usage:
     * 
     * ....
     * DELETE /ovirt-engine/api/users/1234
     * ....
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the system user.
     * 
     * Usage:
     * 
     * ....
     * DELETE /ovirt-engine/api/users/1234
     * ....
     */
    RemoveRequest remove();
    
    /**
     * Updates information about the user.
     * 
     * Only the `user_options` field can be updated.
     * 
     * For example, to update user options:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/users/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <user>
     *    <user_options>
     *       <property>
     *          <name>test</name>
     *          <value>["any","JSON"]</value>
     *       </property>
     *    </user_options>
     * </user>
     * ----
     * 
     * IMPORTANT: Since version 4.4.5 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. Please use the <<services/user_option, options>>
     * endpoint instead.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        UpdateRequest user(User user);
        UpdateRequest user(UserBuilder user);
    }
    
    /**
     * Updates information about the user.
     * 
     * Only the `user_options` field can be updated.
     * 
     * For example, to update user options:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/users/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <user>
     *    <user_options>
     *       <property>
     *          <name>test</name>
     *          <value>["any","JSON"]</value>
     *       </property>
     *    </user_options>
     * </user>
     * ----
     * 
     * IMPORTANT: Since version 4.4.5 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. Please use the <<services/user_option, options>>
     * endpoint instead.
     */
    public interface UpdateResponse extends Response {
        User user();
    }
    
    /**
     * Updates information about the user.
     * 
     * Only the `user_options` field can be updated.
     * 
     * For example, to update user options:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/users/123
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <user>
     *    <user_options>
     *       <property>
     *          <name>test</name>
     *          <value>["any","JSON"]</value>
     *       </property>
     *    </user_options>
     * </user>
     * ----
     * 
     * IMPORTANT: Since version 4.4.5 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. Please use the <<services/user_option, options>>
     * endpoint instead.
     */
    UpdateRequest update();
    
    /**
     * List of event-subscriptions for this user.
     */
    EventSubscriptionsService eventSubscriptionsService();
    DomainUserGroupsService groupsService();
    UserOptionsService optionsService();
    AssignedPermissionsService permissionsService();
    AssignedRolesService rolesService();
    SshPublicKeysService sshPublicKeysService();
    AssignedTagsService tagsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

