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
import org.ovirt.engine.sdk4.types.Application;

/**
 * A service that provides information about applications installed in a virtual machine.
 */
public interface VmApplicationsService extends Service {
    /**
     * Returns a list of applications installed in the virtual machine.
     * 
     * The order of the returned list of applications isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ListRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of applications to return. If not specified all the applications are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of applications to return. If not specified all the applications are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of applications to return. If not specified all the applications are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns a list of applications installed in the virtual machine.
     * 
     * The order of the returned list of applications isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * A list of applications installed in the virtual machine.
         * 
         * For example, a request like this:
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/vms/123/applications/
         * ----
         * 
         * May return a list like this:
         * 
         * [source,xml]
         * ----
         * <applications>
         *   <application href="/ovirt-engine/api/vms/123/applications/456" id="456">
         *     <name>kernel-3.10.0-327.36.1.el7</name>
         *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
         *   </application>
         *   <application href="/ovirt-engine/api/vms/123/applications/789" id="789">
         *     <name>ovirt-guest-agent-common-1.0.12-3.el7</name>
         *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
         *   </application>
         * </applications>
         * ----
         */
        List<Application> applications();
    }
    
    /**
     * Returns a list of applications installed in the virtual machine.
     * 
     * The order of the returned list of applications isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that provides information about a specific application.
     */
    VmApplicationService applicationService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

