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
 * A service to manage collection of assignment of tags to specific entities in system.
 */
public interface AssignedTagsService extends Service {
    /**
     * Assign tag to specific entity in the system.
     * 
     * For example to assign tag `mytag` to virtual machine with the id `123` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/vms/123/tags
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
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest tag(Tag tag);
        /**
         * The assigned tag.
         */
        AddRequest tag(TagBuilder tag);
    }
    
    /**
     * Assign tag to specific entity in the system.
     * 
     * For example to assign tag `mytag` to virtual machine with the id `123` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/vms/123/tags
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
     */
    public interface AddResponse extends Response {
        /**
         * The assigned tag.
         */
        Tag tag();
    }
    
    /**
     * Assign tag to specific entity in the system.
     * 
     * For example to assign tag `mytag` to virtual machine with the id `123` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/vms/123/tags
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
     */
    AddRequest add();
    
    /**
     * List all tags assigned to the specific entity.
     * 
     * For example to list all the tags of the virtual machine with id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/vms/123/tags
     * ....
     * 
     * [source,xml]
     * ----
     * <tags>
     *   <tag href="/ovirt-engine/api/tags/222" id="222">
     *     <name>mytag</name>
     *     <description>mytag</description>
     *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   </tag>
     * </tags>
     * ----
     * 
     * The order of the returned tags isn't guaranteed.
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
     * List all tags assigned to the specific entity.
     * 
     * For example to list all the tags of the virtual machine with id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/vms/123/tags
     * ....
     * 
     * [source,xml]
     * ----
     * <tags>
     *   <tag href="/ovirt-engine/api/tags/222" id="222">
     *     <name>mytag</name>
     *     <description>mytag</description>
     *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   </tag>
     * </tags>
     * ----
     * 
     * The order of the returned tags isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of assigned tags.
         */
        List<Tag> tags();
    }
    
    /**
     * List all tags assigned to the specific entity.
     * 
     * For example to list all the tags of the virtual machine with id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/vms/123/tags
     * ....
     * 
     * [source,xml]
     * ----
     * <tags>
     *   <tag href="/ovirt-engine/api/tags/222" id="222">
     *     <name>mytag</name>
     *     <description>mytag</description>
     *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   </tag>
     * </tags>
     * ----
     * 
     * The order of the returned tags isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages assignment of specific tag.
     */
    AssignedTagService tagService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

