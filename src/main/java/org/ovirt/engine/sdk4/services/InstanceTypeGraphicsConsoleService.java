/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.GraphicsConsole;

public interface InstanceTypeGraphicsConsoleService extends Service {
    /**
     * Gets graphics console configuration of the instance type.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Gets graphics console configuration of the instance type.
     */
    public interface GetResponse extends Response {
        /**
         * The information about the graphics console of the instance type.
         */
        GraphicsConsole console();
    }
    
    /**
     * Gets graphics console configuration of the instance type.
     */
    GetRequest get();
    
    /**
     * Remove the graphics console from the instance type.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove the graphics console from the instance type.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove the graphics console from the instance type.
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

