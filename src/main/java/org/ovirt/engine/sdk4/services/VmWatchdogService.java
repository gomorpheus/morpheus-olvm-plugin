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

/**
 * A service managing a watchdog on virtual machines.
 */
public interface VmWatchdogService extends Service {
    /**
     * Returns the information about the watchdog.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns the information about the watchdog.
     */
    public interface GetResponse extends Response {
        /**
         * The information about the watchdog.
         * 
         * The information consists of `model` element, `action` element and the reference to the
         * virtual machine. It may look like this:
         * 
         * [source,xml]
         * ----
         * <watchdogs>
         *   <watchdog href="/ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000">
         *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
         *     <action>poweroff</action>
         *     <model>i6300esb</model>
         *   </watchdog>
         * </watchdogs>
         * ----
         */
        Watchdog watchdog();
    }
    
    /**
     * Returns the information about the watchdog.
     */
    GetRequest get();
    
    /**
     * Removes the watchdog from the virtual machine.
     * 
     * For example, to remove a watchdog from a virtual machine, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the watchdog from the virtual machine.
     * 
     * For example, to remove a watchdog from a virtual machine, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the watchdog from the virtual machine.
     * 
     * For example, to remove a watchdog from a virtual machine, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Updates the information about the watchdog.
     * 
     * You can update the information using `action` and `model` elements.
     * 
     * For example, to update a watchdog, send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/watchdogs
     * <watchdog>
     *   <action>reset</action>
     * </watchdog>
     * ----
     * 
     * with response body:
     * 
     * [source,xml]
     * ----
     * <watchdog href="/ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000">
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   <action>reset</action>
     *   <model>i6300esb</model>
     * </watchdog>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest watchdog(Watchdog watchdog);
        /**
         * The information about the watchdog.
         * 
         * The request data must contain at least one of `model` and `action`
         * elements. The response data contains complete information about the
         * updated watchdog.
         */
        UpdateRequest watchdog(WatchdogBuilder watchdog);
    }
    
    /**
     * Updates the information about the watchdog.
     * 
     * You can update the information using `action` and `model` elements.
     * 
     * For example, to update a watchdog, send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/watchdogs
     * <watchdog>
     *   <action>reset</action>
     * </watchdog>
     * ----
     * 
     * with response body:
     * 
     * [source,xml]
     * ----
     * <watchdog href="/ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000">
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   <action>reset</action>
     *   <model>i6300esb</model>
     * </watchdog>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * The information about the watchdog.
         * 
         * The request data must contain at least one of `model` and `action`
         * elements. The response data contains complete information about the
         * updated watchdog.
         */
        Watchdog watchdog();
    }
    
    /**
     * Updates the information about the watchdog.
     * 
     * You can update the information using `action` and `model` elements.
     * 
     * For example, to update a watchdog, send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/watchdogs
     * <watchdog>
     *   <action>reset</action>
     * </watchdog>
     * ----
     * 
     * with response body:
     * 
     * [source,xml]
     * ----
     * <watchdog href="/ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000">
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   <action>reset</action>
     *   <model>i6300esb</model>
     * </watchdog>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

