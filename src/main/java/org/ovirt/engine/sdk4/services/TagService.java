/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.TagBuilder;
import org.ovirt.engine.sdk4.types.Tag;

/**
 * A service to manage a specific tag in the system.
 */
public interface TagService extends Service {
    /**
     * Gets the information about the tag.
     * 
     * For example to retrieve the information about the tag with the id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/tags/123
     * ....
     * 
     * [source,xml]
     * ----
     * <tag href="/ovirt-engine/api/tags/123" id="123">
     *   <name>root</name>
     *   <description>root</description>
     * </tag>
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
     * Gets the information about the tag.
     * 
     * For example to retrieve the information about the tag with the id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/tags/123
     * ....
     * 
     * [source,xml]
     * ----
     * <tag href="/ovirt-engine/api/tags/123" id="123">
     *   <name>root</name>
     *   <description>root</description>
     * </tag>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The tag.
         */
        Tag tag();
    }
    
    /**
     * Gets the information about the tag.
     * 
     * For example to retrieve the information about the tag with the id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/tags/123
     * ....
     * 
     * [source,xml]
     * ----
     * <tag href="/ovirt-engine/api/tags/123" id="123">
     *   <name>root</name>
     *   <description>root</description>
     * </tag>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes the tag from the system.
     * 
     * For example to remove the tag with id `123` send a request like this:
     * 
     * ....
     * DELETE /ovirt-engine/api/tags/123
     * ....
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the tag from the system.
     * 
     * For example to remove the tag with id `123` send a request like this:
     * 
     * ....
     * DELETE /ovirt-engine/api/tags/123
     * ....
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the tag from the system.
     * 
     * For example to remove the tag with id `123` send a request like this:
     * 
     * ....
     * DELETE /ovirt-engine/api/tags/123
     * ....
     */
    RemoveRequest remove();
    
    /**
     * Updates the tag entity.
     * 
     * For example to update parent tag to tag with id `456` of the tag with id `123` send a request like this:
     * 
     * ....
     * PUT /ovirt-engine/api/tags/123
     * ....
     * 
     * With request body like:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <parent id="456"/>
     * </tag>
     * ----
     * 
     * You may also specify a tag name instead of id. For example to update parent tag to tag with name `mytag`
     * of the tag with id `123` send a request like this:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <parent>
     *     <name>mytag</name>
     *   </parent>
     * </tag>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest tag(Tag tag);
        /**
         * The updated tag.
         */
        UpdateRequest tag(TagBuilder tag);
    }
    
    /**
     * Updates the tag entity.
     * 
     * For example to update parent tag to tag with id `456` of the tag with id `123` send a request like this:
     * 
     * ....
     * PUT /ovirt-engine/api/tags/123
     * ....
     * 
     * With request body like:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <parent id="456"/>
     * </tag>
     * ----
     * 
     * You may also specify a tag name instead of id. For example to update parent tag to tag with name `mytag`
     * of the tag with id `123` send a request like this:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <parent>
     *     <name>mytag</name>
     *   </parent>
     * </tag>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * The updated tag.
         */
        Tag tag();
    }
    
    /**
     * Updates the tag entity.
     * 
     * For example to update parent tag to tag with id `456` of the tag with id `123` send a request like this:
     * 
     * ....
     * PUT /ovirt-engine/api/tags/123
     * ....
     * 
     * With request body like:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <parent id="456"/>
     * </tag>
     * ----
     * 
     * You may also specify a tag name instead of id. For example to update parent tag to tag with name `mytag`
     * of the tag with id `123` send a request like this:
     * 
     * [source,xml]
     * ----
     * <tag>
     *   <parent>
     *     <name>mytag</name>
     *   </parent>
     * </tag>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

