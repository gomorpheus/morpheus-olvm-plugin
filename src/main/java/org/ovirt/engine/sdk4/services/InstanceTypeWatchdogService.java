/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.WatchdogBuilder;
import org.ovirt.engine.sdk4.types.Watchdog;

public interface InstanceTypeWatchdogService extends Service {
    /**
     * Gets watchdog configuration of the instance type.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Gets watchdog configuration of the instance type.
     */
    public interface GetResponse extends Response {
        Watchdog watchdog();
    }
    
    /**
     * Gets watchdog configuration of the instance type.
     */
    GetRequest get();
    
    /**
     * Remove a watchdog from the instance type.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove a watchdog from the instance type.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove a watchdog from the instance type.
     */
    RemoveRequest remove();
    
    /**
     * Updates the watchdog configuration of the instance type.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest watchdog(Watchdog watchdog);
        UpdateRequest watchdog(WatchdogBuilder watchdog);
    }
    
    /**
     * Updates the watchdog configuration of the instance type.
     */
    public interface UpdateResponse extends Response {
        Watchdog watchdog();
    }
    
    /**
     * Updates the watchdog configuration of the instance type.
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

