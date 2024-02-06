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
import org.ovirt.engine.sdk4.builders.WatchdogBuilder;
import org.ovirt.engine.sdk4.types.Watchdog;

public interface InstanceTypeWatchdogsService extends Service {
    /**
     * Add new watchdog to the instance type.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest watchdog(Watchdog watchdog);
        AddRequest watchdog(WatchdogBuilder watchdog);
    }
    
    /**
     * Add new watchdog to the instance type.
     */
    public interface AddResponse extends Response {
        Watchdog watchdog();
    }
    
    /**
     * Add new watchdog to the instance type.
     */
    AddRequest add();
    
    /**
     * Lists all the configured watchdogs of the instance type.
     * 
     * The order of the returned list of watchdogs isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of watchdogs to return. If not specified all the watchdogs are
         * returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of watchdogs to return. If not specified all the watchdogs are
         * returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of watchdogs to return. If not specified all the watchdogs are
         * returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned templates.
         */
        ListRequest search(String search);
    }
    
    /**
     * Lists all the configured watchdogs of the instance type.
     * 
     * The order of the returned list of watchdogs isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Watchdog> watchdogs();
    }
    
    /**
     * Lists all the configured watchdogs of the instance type.
     * 
     * The order of the returned list of watchdogs isn't guaranteed.
     */
    ListRequest list();
    
    InstanceTypeWatchdogService watchdogService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

