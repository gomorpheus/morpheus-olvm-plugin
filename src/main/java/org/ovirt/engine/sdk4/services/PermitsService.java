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
import org.ovirt.engine.sdk4.builders.PermitBuilder;
import org.ovirt.engine.sdk4.types.Permit;

/**
 * Represents a permits sub-collection of the specific role.
 */
public interface PermitsService extends Service {
    /**
     * Adds a permit to the role. The permit name can be retrieved from the <<services/cluster_levels>> service.
     * 
     * For example to assign a permit `create_vm` to the role with id `123` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/roles/123/permits
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permit>
     *   <name>create_vm</name>
     * </permit>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest permit(Permit permit);
        /**
         * The permit to add.
         */
        AddRequest permit(PermitBuilder permit);
    }
    
    /**
     * Adds a permit to the role. The permit name can be retrieved from the <<services/cluster_levels>> service.
     * 
     * For example to assign a permit `create_vm` to the role with id `123` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/roles/123/permits
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permit>
     *   <name>create_vm</name>
     * </permit>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The permit to add.
         */
        Permit permit();
    }
    
    /**
     * Adds a permit to the role. The permit name can be retrieved from the <<services/cluster_levels>> service.
     * 
     * For example to assign a permit `create_vm` to the role with id `123` send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/roles/123/permits
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <permit>
     *   <name>create_vm</name>
     * </permit>
     * ----
     */
    AddRequest add();
    
    /**
     * List the permits of the role.
     * 
     * For example to list the permits of the role with the id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/roles/123/permits
     * ....
     * 
     * [source,xml]
     * ----
     * <permits>
     *   <permit href="/ovirt-engine/api/roles/123/permits/5" id="5">
     *     <name>change_vm_cd</name>
     *     <administrative>false</administrative>
     *     <role href="/ovirt-engine/api/roles/123" id="123"/>
     *   </permit>
     *   <permit href="/ovirt-engine/api/roles/123/permits/7" id="7">
     *     <name>connect_to_vm</name>
     *     <administrative>false</administrative>
     *     <role href="/ovirt-engine/api/roles/123" id="123"/>
     *   </permit>
     * </permits>
     * ----
     * 
     * The order of the returned list of permits isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of permits to return. If not specified all the permits are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of permits to return. If not specified all the permits are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of permits to return. If not specified all the permits are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List the permits of the role.
     * 
     * For example to list the permits of the role with the id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/roles/123/permits
     * ....
     * 
     * [source,xml]
     * ----
     * <permits>
     *   <permit href="/ovirt-engine/api/roles/123/permits/5" id="5">
     *     <name>change_vm_cd</name>
     *     <administrative>false</administrative>
     *     <role href="/ovirt-engine/api/roles/123" id="123"/>
     *   </permit>
     *   <permit href="/ovirt-engine/api/roles/123/permits/7" id="7">
     *     <name>connect_to_vm</name>
     *     <administrative>false</administrative>
     *     <role href="/ovirt-engine/api/roles/123" id="123"/>
     *   </permit>
     * </permits>
     * ----
     * 
     * The order of the returned list of permits isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * List of permits.
         */
        List<Permit> permits();
    }
    
    /**
     * List the permits of the role.
     * 
     * For example to list the permits of the role with the id `123` send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/roles/123/permits
     * ....
     * 
     * [source,xml]
     * ----
     * <permits>
     *   <permit href="/ovirt-engine/api/roles/123/permits/5" id="5">
     *     <name>change_vm_cd</name>
     *     <administrative>false</administrative>
     *     <role href="/ovirt-engine/api/roles/123" id="123"/>
     *   </permit>
     *   <permit href="/ovirt-engine/api/roles/123/permits/7" id="7">
     *     <name>connect_to_vm</name>
     *     <administrative>false</administrative>
     *     <role href="/ovirt-engine/api/roles/123" id="123"/>
     *   </permit>
     * </permits>
     * ----
     * 
     * The order of the returned list of permits isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Sub-resource locator method, returns individual permit resource on which the remainder of the URI is dispatched.
     */
    PermitService permitService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

