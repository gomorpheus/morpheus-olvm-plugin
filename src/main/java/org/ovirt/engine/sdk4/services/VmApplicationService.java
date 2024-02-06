/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Application;

/**
 * A service that provides information about an application installed in a virtual machine.
 */
public interface VmApplicationService extends Service {
    /**
     * Returns the information about the application.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        GetRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns the information about the application.
     */
    public interface GetResponse extends Response {
        /**
         * The information about the application.
         * 
         * The information consists of `name` attribute containing the name of the application
         * (which is an arbitrary string that may also contain additional information such as
         * version) and `vm` attribute identifying the virtual machine.
         * 
         * For example, a request like this:
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/vms/123/applications/789
         * ----
         * 
         * May return information like this:
         * 
         * [source,xml]
         * ----
         * <application href="/ovirt-engine/api/vms/123/applications/789" id="789">
         *   <name>ovirt-guest-agent-common-1.0.12-3.el7</name>
         *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
         * </application>
         * ----
         */
        Application application();
    }
    
    /**
     * Returns the information about the application.
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

