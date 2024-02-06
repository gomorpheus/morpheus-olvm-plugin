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
import org.ovirt.engine.sdk4.builders.BookmarkBuilder;
import org.ovirt.engine.sdk4.types.Bookmark;

/**
 * A service to manage bookmarks.
 */
public interface BookmarksService extends Service {
    /**
     * Adding a new bookmark.
     * 
     * Example of adding a bookmark:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/bookmarks
     * ----
     * 
     * [source,xml]
     * ----
     * <bookmark>
     *   <name>new_example_vm</name>
     *   <value>vm: name=new_example*</value>
     * </bookmark>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest bookmark(Bookmark bookmark);
        /**
         * The added bookmark.
         */
        AddRequest bookmark(BookmarkBuilder bookmark);
    }
    
    /**
     * Adding a new bookmark.
     * 
     * Example of adding a bookmark:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/bookmarks
     * ----
     * 
     * [source,xml]
     * ----
     * <bookmark>
     *   <name>new_example_vm</name>
     *   <value>vm: name=new_example*</value>
     * </bookmark>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The added bookmark.
         */
        Bookmark bookmark();
    }
    
    /**
     * Adding a new bookmark.
     * 
     * Example of adding a bookmark:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/bookmarks
     * ----
     * 
     * [source,xml]
     * ----
     * <bookmark>
     *   <name>new_example_vm</name>
     *   <value>vm: name=new_example*</value>
     * </bookmark>
     * ----
     */
    AddRequest add();
    
    /**
     * Listing all the available bookmarks.
     * 
     * Example of listing bookmarks:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/bookmarks
     * ----
     * 
     * [source,xml]
     * ----
     * <bookmarks>
     *   <bookmark href="/ovirt-engine/api/bookmarks/123" id="123">
     *     <name>database</name>
     *     <value>vm: name=database*</value>
     *   </bookmark>
     *   <bookmark href="/ovirt-engine/api/bookmarks/456" id="456">
     *     <name>example</name>
     *     <value>vm: name=example*</value>
     *   </bookmark>
     * </bookmarks>
     * ----
     * 
     * The order of the returned bookmarks isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of bookmarks to return. If not specified all the bookmarks are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of bookmarks to return. If not specified all the bookmarks are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of bookmarks to return. If not specified all the bookmarks are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Listing all the available bookmarks.
     * 
     * Example of listing bookmarks:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/bookmarks
     * ----
     * 
     * [source,xml]
     * ----
     * <bookmarks>
     *   <bookmark href="/ovirt-engine/api/bookmarks/123" id="123">
     *     <name>database</name>
     *     <value>vm: name=database*</value>
     *   </bookmark>
     *   <bookmark href="/ovirt-engine/api/bookmarks/456" id="456">
     *     <name>example</name>
     *     <value>vm: name=example*</value>
     *   </bookmark>
     * </bookmarks>
     * ----
     * 
     * The order of the returned bookmarks isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of available bookmarks.
         */
        List<Bookmark> bookmarks();
    }
    
    /**
     * Listing all the available bookmarks.
     * 
     * Example of listing bookmarks:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/bookmarks
     * ----
     * 
     * [source,xml]
     * ----
     * <bookmarks>
     *   <bookmark href="/ovirt-engine/api/bookmarks/123" id="123">
     *     <name>database</name>
     *     <value>vm: name=database*</value>
     *   </bookmark>
     *   <bookmark href="/ovirt-engine/api/bookmarks/456" id="456">
     *     <name>example</name>
     *     <value>vm: name=example*</value>
     *   </bookmark>
     * </bookmarks>
     * ----
     * 
     * The order of the returned bookmarks isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * A reference to the service managing a specific bookmark.
     */
    BookmarkService bookmarkService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

