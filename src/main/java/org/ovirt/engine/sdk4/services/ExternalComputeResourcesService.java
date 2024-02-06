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
import org.ovirt.engine.sdk4.types.ExternalComputeResource;

/**
 * Manages a collection of external compute resources.
 * 
 * Compute resource is a term of host external provider. The external provider also needs to know to where the
 * provisioned host needs to register. The login details of the engine is saved as a compute resource in the external
 * provider side.
 */
public interface ExternalComputeResourcesService extends Service {
    /**
     * Retrieves a list of external compute resources.
     * 
     * For example, to retrieve the compute resources of external host provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/computeresources
     * ....
     * 
     * It will return a response like this:
     * 
     * [source,xml]
     * ----
     * <external_compute_resources>
     *   <external_compute_resource href="/ovirt-engine/api/externalhostproviders/123/computeresources/234" id="234">
     *     <name>hostname</name>
     *     <provider>oVirt</provider>
     *     <url>https://address/api</url>
     *     <user>admin@internal</user>
     *     <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *    </external_compute_resource>
     *    ...
     * </external_compute_resources>
     * ----
     * 
     * The order of the returned list of compute resources isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of resources to return. If not specified all the resources are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of resources to return. If not specified all the resources are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of resources to return. If not specified all the resources are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Retrieves a list of external compute resources.
     * 
     * For example, to retrieve the compute resources of external host provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/computeresources
     * ....
     * 
     * It will return a response like this:
     * 
     * [source,xml]
     * ----
     * <external_compute_resources>
     *   <external_compute_resource href="/ovirt-engine/api/externalhostproviders/123/computeresources/234" id="234">
     *     <name>hostname</name>
     *     <provider>oVirt</provider>
     *     <url>https://address/api</url>
     *     <user>admin@internal</user>
     *     <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *    </external_compute_resource>
     *    ...
     * </external_compute_resources>
     * ----
     * 
     * The order of the returned list of compute resources isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * List of external computer resources.
         */
        List<ExternalComputeResource> resources();
    }
    
    /**
     * Retrieves a list of external compute resources.
     * 
     * For example, to retrieve the compute resources of external host provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/computeresources
     * ....
     * 
     * It will return a response like this:
     * 
     * [source,xml]
     * ----
     * <external_compute_resources>
     *   <external_compute_resource href="/ovirt-engine/api/externalhostproviders/123/computeresources/234" id="234">
     *     <name>hostname</name>
     *     <provider>oVirt</provider>
     *     <url>https://address/api</url>
     *     <user>admin@internal</user>
     *     <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *    </external_compute_resource>
     *    ...
     * </external_compute_resources>
     * ----
     * 
     * The order of the returned list of compute resources isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * This service manages compute resource instance
     */
    ExternalComputeResourceService resourceService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

