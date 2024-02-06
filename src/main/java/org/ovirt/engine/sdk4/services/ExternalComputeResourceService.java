/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.ExternalComputeResource;

/**
 * Manages a single external compute resource.
 * 
 * Compute resource is a term of host external provider. The external provider also needs to know to where the
 * provisioned host needs to register. The login details of the engine are saved as a compute resource  in the external
 * provider side.
 */
public interface ExternalComputeResourceService extends Service {
    /**
     * Retrieves external compute resource details.
     * 
     * For example, to get the details of compute resource `234` of provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/computeresources/234
     * ....
     * 
     * It will return a response like this:
     * 
     * [source,xml]
     * ----
     * <external_compute_resource href="/ovirt-engine/api/externalhostproviders/123/computeresources/234" id="234">
     *   <name>hostname</name>
     *   <provider>oVirt</provider>
     *   <url>https://hostname/api</url>
     *   <user>admin@internal</user>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     * </external_compute_resource>
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
     * Retrieves external compute resource details.
     * 
     * For example, to get the details of compute resource `234` of provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/computeresources/234
     * ....
     * 
     * It will return a response like this:
     * 
     * [source,xml]
     * ----
     * <external_compute_resource href="/ovirt-engine/api/externalhostproviders/123/computeresources/234" id="234">
     *   <name>hostname</name>
     *   <provider>oVirt</provider>
     *   <url>https://hostname/api</url>
     *   <user>admin@internal</user>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     * </external_compute_resource>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * External compute resource information
         */
        ExternalComputeResource resource();
    }
    
    /**
     * Retrieves external compute resource details.
     * 
     * For example, to get the details of compute resource `234` of provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/computeresources/234
     * ....
     * 
     * It will return a response like this:
     * 
     * [source,xml]
     * ----
     * <external_compute_resource href="/ovirt-engine/api/externalhostproviders/123/computeresources/234" id="234">
     *   <name>hostname</name>
     *   <provider>oVirt</provider>
     *   <url>https://hostname/api</url>
     *   <user>admin@internal</user>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     * </external_compute_resource>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

