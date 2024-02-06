/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.UserOption;

public interface UserOptionService extends Service {
    /**
     * Returns a user profile property of type JSON.
     * 
     * Example request(for user with identifier `123` and option with identifier `456`):
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/users/123/options/456
     * ----
     * 
     * The result will be the following XML document:
     * 
     * [source,xml]
     * ----
     *   <user_option href="/ovirt-engine/api/users/123/options/456" id="456">
     *     <name>SomeName</name>
     *     <content>["any", "JSON"]</content>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *   </user_option>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
    }
    
    /**
     * Returns a user profile property of type JSON.
     * 
     * Example request(for user with identifier `123` and option with identifier `456`):
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/users/123/options/456
     * ----
     * 
     * The result will be the following XML document:
     * 
     * [source,xml]
     * ----
     *   <user_option href="/ovirt-engine/api/users/123/options/456" id="456">
     *     <name>SomeName</name>
     *     <content>["any", "JSON"]</content>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *   </user_option>
     * ----
     */
    public interface GetResponse extends Response {
        UserOption option();
    }
    
    /**
     * Returns a user profile property of type JSON.
     * 
     * Example request(for user with identifier `123` and option with identifier `456`):
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/users/123/options/456
     * ----
     * 
     * The result will be the following XML document:
     * 
     * [source,xml]
     * ----
     *   <user_option href="/ovirt-engine/api/users/123/options/456" id="456">
     *     <name>SomeName</name>
     *     <content>["any", "JSON"]</content>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *   </user_option>
     * ----
     */
    GetRequest get();
    
    /**
     * Deletes an existing property of type JSON.
     * 
     * Example request(for user with identifier `123` and option with identifier `456`):
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/users/123/options/456
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
    }
    
    /**
     * Deletes an existing property of type JSON.
     * 
     * Example request(for user with identifier `123` and option with identifier `456`):
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/users/123/options/456
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Deletes an existing property of type JSON.
     * 
     * Example request(for user with identifier `123` and option with identifier `456`):
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/users/123/options/456
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

