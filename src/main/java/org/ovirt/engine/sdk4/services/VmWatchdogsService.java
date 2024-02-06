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

/**
 * Lists the watchdogs of a virtual machine.
 */
public interface VmWatchdogsService extends Service {
    /**
     * Adds new watchdog to the virtual machine.
     * 
     * For example, to add a watchdog to a virtual machine, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/watchdogs
     * <watchdog>
     *   <action>poweroff</action>
     *   <model>i6300esb</model>
     * </watchdog>
     * ----
     * 
     * with response body:
     * 
     * [source,xml]
     * ----
     * <watchdog href="/ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000">
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   <action>poweroff</action>
     *   <model>i6300esb</model>
     * </watchdog>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest watchdog(Watchdog watchdog);
        /**
         * The information about the watchdog.
         * 
         * The request data must contain `model` element (such as `i6300esb`) and `action` element
         * (one of `none`, `reset`, `poweroff`, `dump`, `pause`). The response data additionally
         * contains references to the added watchdog and to the virtual machine.
         */
        AddRequest watchdog(WatchdogBuilder watchdog);
    }
    
    /**
     * Adds new watchdog to the virtual machine.
     * 
     * For example, to add a watchdog to a virtual machine, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/watchdogs
     * <watchdog>
     *   <action>poweroff</action>
     *   <model>i6300esb</model>
     * </watchdog>
     * ----
     * 
     * with response body:
     * 
     * [source,xml]
     * ----
     * <watchdog href="/ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000">
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   <action>poweroff</action>
     *   <model>i6300esb</model>
     * </watchdog>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The information about the watchdog.
         * 
         * The request data must contain `model` element (such as `i6300esb`) and `action` element
         * (one of `none`, `reset`, `poweroff`, `dump`, `pause`). The response data additionally
         * contains references to the added watchdog and to the virtual machine.
         */
        Watchdog watchdog();
    }
    
    /**
     * Adds new watchdog to the virtual machine.
     * 
     * For example, to add a watchdog to a virtual machine, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/watchdogs
     * <watchdog>
     *   <action>poweroff</action>
     *   <model>i6300esb</model>
     * </watchdog>
     * ----
     * 
     * with response body:
     * 
     * [source,xml]
     * ----
     * <watchdog href="/ovirt-engine/api/vms/123/watchdogs/00000000-0000-0000-0000-000000000000" id="00000000-0000-0000-0000-000000000000">
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   <action>poweroff</action>
     *   <model>i6300esb</model>
     * </watchdog>
     * ----
     */
    AddRequest add();
    
    /**
     * The list of watchdogs of the virtual machine.
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
         * Sets the maximum number of watchdogs to return. If not specified all the watchdogs are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of watchdogs to return. If not specified all the watchdogs are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of watchdogs to return. If not specified all the watchdogs are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * The list of watchdogs of the virtual machine.
     * 
     * The order of the returned list of watchdogs isn't guaranteed.
     */
    public interface ListResponse extends Response {
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
        List<Watchdog> watchdogs();
    }
    
    /**
     * The list of watchdogs of the virtual machine.
     * 
     * The order of the returned list of watchdogs isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific watchdog.
     */
    VmWatchdogService watchdogService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

