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
import org.ovirt.engine.sdk4.builders.TagBuilder;
import org.ovirt.engine.sdk4.types.Tag;

/**
 * Represents a service to manage collection of the tags in the system.
 */
public interface TagsService extends Service {
    /**
     * Add a new tag to the system.
     * 
     * For example, to add new tag with name `mytag` to the system send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/tags
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <name>mytag</name>
     * </tag>
     * ----
     * 
     * NOTE: The root tag is a special pseudo-tag assumed as the default parent tag if no parent tag is specified.
     * The root tag cannot be deleted nor assigned a parent tag.
     * 
     * To create new tag with specific parent tag send a request body like this:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <name>mytag</name>
     *   <parent>
     *     <name>myparenttag</name>
     *   </parent>
     * </tag>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest tag(Tag tag);
        /**
         * The added tag.
         */
        AddRequest tag(TagBuilder tag);
    }
    
    /**
     * Add a new tag to the system.
     * 
     * For example, to add new tag with name `mytag` to the system send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/tags
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <name>mytag</name>
     * </tag>
     * ----
     * 
     * NOTE: The root tag is a special pseudo-tag assumed as the default parent tag if no parent tag is specified.
     * The root tag cannot be deleted nor assigned a parent tag.
     * 
     * To create new tag with specific parent tag send a request body like this:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <name>mytag</name>
     *   <parent>
     *     <name>myparenttag</name>
     *   </parent>
     * </tag>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The added tag.
         */
        Tag tag();
    }
    
    /**
     * Add a new tag to the system.
     * 
     * For example, to add new tag with name `mytag` to the system send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/tags
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <name>mytag</name>
     * </tag>
     * ----
     * 
     * NOTE: The root tag is a special pseudo-tag assumed as the default parent tag if no parent tag is specified.
     * The root tag cannot be deleted nor assigned a parent tag.
     * 
     * To create new tag with specific parent tag send a request body like this:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <name>mytag</name>
     *   <parent>
     *     <name>myparenttag</name>
     *   </parent>
     * </tag>
     * ----
     */
    AddRequest add();
    
    /**
     * List the tags in the system.
     * 
     * For example to list the full hierarchy of the tags in the system send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/tags
     * ....
     * 
     * [source,xml]
     * ----
     * <tags>
     *   <tag href="/ovirt-engine/api/tags/222" id="222">
     *     <name>root2</name>
     *     <description>root2</description>
     *     <parent href="/ovirt-engine/api/tags/111" id="111"/>
     *   </tag>
     *   <tag href="/ovirt-engine/api/tags/333" id="333">
     *     <name>root3</name>
     *     <description>root3</description>
     *     <parent href="/ovirt-engine/api/tags/222" id="222"/>
     *   </tag>
     *   <tag href="/ovirt-engine/api/tags/111" id="111">
     *     <name>root</name>
     *     <description>root</description>
     *   </tag>
     * </tags>
     * ----
     * 
     * In the previous XML output you can see the following hierarchy of the tags:
     * ....
     * root:        (id: 111)
     *   - root2    (id: 222)
     *     - root3  (id: 333)
     * ....
     * 
     * The order of the returned list of tags isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of tags to return. If not specified all the tags are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of tags to return. If not specified all the tags are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of tags to return. If not specified all the tags are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List the tags in the system.
     * 
     * For example to list the full hierarchy of the tags in the system send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/tags
     * ....
     * 
     * [source,xml]
     * ----
     * <tags>
     *   <tag href="/ovirt-engine/api/tags/222" id="222">
     *     <name>root2</name>
     *     <description>root2</description>
     *     <parent href="/ovirt-engine/api/tags/111" id="111"/>
     *   </tag>
     *   <tag href="/ovirt-engine/api/tags/333" id="333">
     *     <name>root3</name>
     *     <description>root3</description>
     *     <parent href="/ovirt-engine/api/tags/222" id="222"/>
     *   </tag>
     *   <tag href="/ovirt-engine/api/tags/111" id="111">
     *     <name>root</name>
     *     <description>root</description>
     *   </tag>
     * </tags>
     * ----
     * 
     * In the previous XML output you can see the following hierarchy of the tags:
     * ....
     * root:        (id: 111)
     *   - root2    (id: 222)
     *     - root3  (id: 333)
     * ....
     * 
     * The order of the returned list of tags isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * List of all tags in the system.
         */
        List<Tag> tags();
    }
    
    /**
     * List the tags in the system.
     * 
     * For example to list the full hierarchy of the tags in the system send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/tags
     * ....
     * 
     * [source,xml]
     * ----
     * <tags>
     *   <tag href="/ovirt-engine/api/tags/222" id="222">
     *     <name>root2</name>
     *     <description>root2</description>
     *     <parent href="/ovirt-engine/api/tags/111" id="111"/>
     *   </tag>
     *   <tag href="/ovirt-engine/api/tags/333" id="333">
     *     <name>root3</name>
     *     <description>root3</description>
     *     <parent href="/ovirt-engine/api/tags/222" id="222"/>
     *   </tag>
     *   <tag href="/ovirt-engine/api/tags/111" id="111">
     *     <name>root</name>
     *     <description>root</description>
     *   </tag>
     * </tags>
     * ----
     * 
     * In the previous XML output you can see the following hierarchy of the tags:
     * ....
     * root:        (id: 111)
     *   - root2    (id: 222)
     *     - root3  (id: 333)
     * ....
     * 
     * The order of the returned list of tags isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific tag.
     */
    TagService tagService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

