/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.UserOptionBuilder;
import org.ovirt.engine.sdk4.types.UserOption;

public interface UserOptionsService extends Service {
    /**
     * Adds a new user profile property of type JSON.
     * 
     * Example request(for user with identifier `123`):
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/users/123/options
     * ----
     * 
     * Payload:
     * 
     * [source,xml]
     * ----
     *   <user_option>
     *     <name>SomeName</name>
     *     <content>["any", "JSON"]</content>
     *   </user_option>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest option(UserOption option);
        AddRequest option(UserOptionBuilder option);
    }
    
    /**
     * Adds a new user profile property of type JSON.
     * 
     * Example request(for user with identifier `123`):
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/users/123/options
     * ----
     * 
     * Payload:
     * 
     * [source,xml]
     * ----
     *   <user_option>
     *     <name>SomeName</name>
     *     <content>["any", "JSON"]</content>
     *   </user_option>
     * ----
     */
    public interface AddResponse extends Response {
        UserOption option();
    }
    
    /**
     * Adds a new user profile property of type JSON.
     * 
     * Example request(for user with identifier `123`):
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/users/123/options
     * ----
     * 
     * Payload:
     * 
     * [source,xml]
     * ----
     *   <user_option>
     *     <name>SomeName</name>
     *     <content>["any", "JSON"]</content>
     *   </user_option>
     * ----
     */
    AddRequest add();
    
    /**
     * Returns a list of user profile properties of type JSON.
     * 
     * Example request(for user with identifier `123`):
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/users/123/options
     * ----
     * 
     * The result will be the following XML document:
     * 
     * [source,xml]
     * ----
     * <user_options>
     *   <user_option href="/ovirt-engine/api/users/123/options/456" id="456">
     *     <name>SomeName</name>
     *     <content>["any", "JSON"]</content>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *   </user_option>
     * </user_options>
     * ----
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
    }
    
    /**
     * Returns a list of user profile properties of type JSON.
     * 
     * Example request(for user with identifier `123`):
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/users/123/options
     * ----
     * 
     * The result will be the following XML document:
     * 
     * [source,xml]
     * ----
     * <user_options>
     *   <user_option href="/ovirt-engine/api/users/123/options/456" id="456">
     *     <name>SomeName</name>
     *     <content>["any", "JSON"]</content>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *   </user_option>
     * </user_options>
     * ----
     */
    public interface ListResponse extends Response {
        List<UserOption> options();
    }
    
    /**
     * Returns a list of user profile properties of type JSON.
     * 
     * Example request(for user with identifier `123`):
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/users/123/options
     * ----
     * 
     * The result will be the following XML document:
     * 
     * [source,xml]
     * ----
     * <user_options>
     *   <user_option href="/ovirt-engine/api/users/123/options/456" id="456">
     *     <name>SomeName</name>
     *     <content>["any", "JSON"]</content>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *   </user_option>
     * </user_options>
     * ----
     */
    ListRequest list();
    
    UserOptionService optionService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

