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
import org.ovirt.engine.sdk4.builders.UserBuilder;
import org.ovirt.engine.sdk4.types.User;

/**
 * A service to manage the users in the system.
 */
public interface UsersService extends Service {
    /**
     * Add user from a directory service.
     * 
     * For example, to add the `myuser` user from the `myextension-authz` authorization provider send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/users
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <user>
     *   <user_name>myuser@myextension-authz</user_name>
     *   <domain>
     *     <name>myextension-authz</name>
     *   </domain>
     * </user>
     * ----
     * 
     * In case you are working with Active Directory you have to pass user principal name (UPN) as `username`, followed
     * by authorization provider name. Due to https://bugzilla.redhat.com/1147900[bug 1147900] you need to provide
     * also `principal` parameter set to UPN of the user.
     * 
     * For example, to add the user with UPN `myuser@mysubdomain.mydomain.com` from the `myextension-authz`
     * authorization provider send a request body like this:
     * 
     * [source,xml]
     * ----
     * <user>
     *   <principal>myuser@mysubdomain.mydomain.com</principal>
     *   <user_name>myuser@mysubdomain.mydomain.com@myextension-authz</user_name>
     *   <domain>
     *     <name>myextension-authz</name>
     *   </domain>
     * </user>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest user(User user);
        AddRequest user(UserBuilder user);
    }
    
    /**
     * Add user from a directory service.
     * 
     * For example, to add the `myuser` user from the `myextension-authz` authorization provider send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/users
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <user>
     *   <user_name>myuser@myextension-authz</user_name>
     *   <domain>
     *     <name>myextension-authz</name>
     *   </domain>
     * </user>
     * ----
     * 
     * In case you are working with Active Directory you have to pass user principal name (UPN) as `username`, followed
     * by authorization provider name. Due to https://bugzilla.redhat.com/1147900[bug 1147900] you need to provide
     * also `principal` parameter set to UPN of the user.
     * 
     * For example, to add the user with UPN `myuser@mysubdomain.mydomain.com` from the `myextension-authz`
     * authorization provider send a request body like this:
     * 
     * [source,xml]
     * ----
     * <user>
     *   <principal>myuser@mysubdomain.mydomain.com</principal>
     *   <user_name>myuser@mysubdomain.mydomain.com@myextension-authz</user_name>
     *   <domain>
     *     <name>myextension-authz</name>
     *   </domain>
     * </user>
     * ----
     */
    public interface AddResponse extends Response {
        User user();
    }
    
    /**
     * Add user from a directory service.
     * 
     * For example, to add the `myuser` user from the `myextension-authz` authorization provider send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/users
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <user>
     *   <user_name>myuser@myextension-authz</user_name>
     *   <domain>
     *     <name>myextension-authz</name>
     *   </domain>
     * </user>
     * ----
     * 
     * In case you are working with Active Directory you have to pass user principal name (UPN) as `username`, followed
     * by authorization provider name. Due to https://bugzilla.redhat.com/1147900[bug 1147900] you need to provide
     * also `principal` parameter set to UPN of the user.
     * 
     * For example, to add the user with UPN `myuser@mysubdomain.mydomain.com` from the `myextension-authz`
     * authorization provider send a request body like this:
     * 
     * [source,xml]
     * ----
     * <user>
     *   <principal>myuser@mysubdomain.mydomain.com</principal>
     *   <user_name>myuser@mysubdomain.mydomain.com@myextension-authz</user_name>
     *   <domain>
     *     <name>myextension-authz</name>
     *   </domain>
     * </user>
     * ----
     */
    AddRequest add();
    
    /**
     * List all the users in the system.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/users
     * ....
     * 
     * Will return the list of users:
     * 
     * [source,xml]
     * ----
     * <users>
     *   <user href="/ovirt-engine/api/users/1234" id="1234">
     *     <name>admin</name>
     *     <link href="/ovirt-engine/api/users/1234/sshpublickeys" rel="sshpublickeys"/>
     *     <link href="/ovirt-engine/api/users/1234/roles" rel="roles"/>
     *     <link href="/ovirt-engine/api/users/1234/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/users/1234/tags" rel="tags"/>
     *     <domain_entry_id>23456</domain_entry_id>
     *     <namespace>*</namespace>
     *     <principal>user1</principal>
     *     <user_name>user1@domain-authz</user_name>
     *     <domain href="/ovirt-engine/api/domains/45678" id="45678">
     *       <name>domain-authz</name>
     *     </domain>
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
     * List all the users in the system.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/users
     * ....
     * 
     * Will return the list of users:
     * 
     * [source,xml]
     * ----
     * <users>
     *   <user href="/ovirt-engine/api/users/1234" id="1234">
     *     <name>admin</name>
     *     <link href="/ovirt-engine/api/users/1234/sshpublickeys" rel="sshpublickeys"/>
     *     <link href="/ovirt-engine/api/users/1234/roles" rel="roles"/>
     *     <link href="/ovirt-engine/api/users/1234/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/users/1234/tags" rel="tags"/>
     *     <domain_entry_id>23456</domain_entry_id>
     *     <namespace>*</namespace>
     *     <principal>user1</principal>
     *     <user_name>user1@domain-authz</user_name>
     *     <domain href="/ovirt-engine/api/domains/45678" id="45678">
     *       <name>domain-authz</name>
     *     </domain>
     *   </user>
     * </users>
     * ----
     * 
     * The order of the returned list of users isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of users.
         */
        List<User> users();
    }
    
    /**
     * List all the users in the system.
     * 
     * Usage:
     * 
     * ....
     * GET /ovirt-engine/api/users
     * ....
     * 
     * Will return the list of users:
     * 
     * [source,xml]
     * ----
     * <users>
     *   <user href="/ovirt-engine/api/users/1234" id="1234">
     *     <name>admin</name>
     *     <link href="/ovirt-engine/api/users/1234/sshpublickeys" rel="sshpublickeys"/>
     *     <link href="/ovirt-engine/api/users/1234/roles" rel="roles"/>
     *     <link href="/ovirt-engine/api/users/1234/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/users/1234/tags" rel="tags"/>
     *     <domain_entry_id>23456</domain_entry_id>
     *     <namespace>*</namespace>
     *     <principal>user1</principal>
     *     <user_name>user1@domain-authz</user_name>
     *     <domain href="/ovirt-engine/api/domains/45678" id="45678">
     *       <name>domain-authz</name>
     *     </domain>
     *   </user>
     * </users>
     * ----
     * 
     * The order of the returned list of users isn't guaranteed.
     */
    ListRequest list();
    
    UserService userService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

