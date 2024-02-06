/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.BookmarkBuilder;
import org.ovirt.engine.sdk4.types.Bookmark;

/**
 * A service to manage a bookmark.
 */
public interface BookmarkService extends Service {
    /**
     * Get a bookmark.
     * 
     * An example for getting a bookmark:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/bookmarks/123
     * ----
     * 
     * [source,xml]
     * ----
     * <bookmark href="/ovirt-engine/api/bookmarks/123" id="123">
     *   <name>example_vm</name>
     *   <value>vm: name=example*</value>
     * </bookmark>
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
     * Get a bookmark.
     * 
     * An example for getting a bookmark:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/bookmarks/123
     * ----
     * 
     * [source,xml]
     * ----
     * <bookmark href="/ovirt-engine/api/bookmarks/123" id="123">
     *   <name>example_vm</name>
     *   <value>vm: name=example*</value>
     * </bookmark>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The requested bookmark.
         */
        Bookmark bookmark();
    }
    
    /**
     * Get a bookmark.
     * 
     * An example for getting a bookmark:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/bookmarks/123
     * ----
     * 
     * [source,xml]
     * ----
     * <bookmark href="/ovirt-engine/api/bookmarks/123" id="123">
     *   <name>example_vm</name>
     *   <value>vm: name=example*</value>
     * </bookmark>
     * ----
     */
    GetRequest get();
    
    /**
     * Remove a bookmark.
     * 
     * An example for removing a bookmark:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/bookmarks/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove a bookmark.
     * 
     * An example for removing a bookmark:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/bookmarks/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove a bookmark.
     * 
     * An example for removing a bookmark:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/bookmarks/123
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Update a bookmark.
     * 
     * An example for updating a bookmark:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/bookmarks/123
     * ----
     * 
     * With the request body:
     * 
     * [source,xml]
     * ----
     * <bookmark>
     *   <name>new_example_vm</name>
     *   <value>vm: name=new_example*</value>
     * </bookmark>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest bookmark(Bookmark bookmark);
        /**
         * The updated bookmark.
         */
        UpdateRequest bookmark(BookmarkBuilder bookmark);
    }
    
    /**
     * Update a bookmark.
     * 
     * An example for updating a bookmark:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/bookmarks/123
     * ----
     * 
     * With the request body:
     * 
     * [source,xml]
     * ----
     * <bookmark>
     *   <name>new_example_vm</name>
     *   <value>vm: name=new_example*</value>
     * </bookmark>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * The updated bookmark.
         */
        Bookmark bookmark();
    }
    
    /**
     * Update a bookmark.
     * 
     * An example for updating a bookmark:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/bookmarks/123
     * ----
     * 
     * With the request body:
     * 
     * [source,xml]
     * ----
     * <bookmark>
     *   <name>new_example_vm</name>
     *   <value>vm: name=new_example*</value>
     * </bookmark>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

