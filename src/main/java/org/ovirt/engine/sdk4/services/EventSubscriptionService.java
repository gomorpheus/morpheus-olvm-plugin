/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.EventSubscription;

/**
 * A service to manage a specific event-subscription in the system.
 */
public interface EventSubscriptionService extends Service {
    /**
     * Gets the information about the event-subscription.
     * 
     * For example to retrieve the information about the subscription of user '123' to
     * the event 'vm_console_detected':
     * 
     * ....
     * GET /ovirt-engine/api/users/123/vm_console_detected
     * ....
     * 
     * [source,xml]
     * ----
     * <event-subscription href="/ovirt-engine/api/users/123/event-subscriptions/vm_console_detected">
     *   <event>vm_console_detected</event>
     *   <notification_method>smtp</notification_method>
     *   <user href="/ovirt-engine/api/users/123" id="123"/>
     *   <address>a@b.com</address>
     * </event-subscription>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
    }
    
    /**
     * Gets the information about the event-subscription.
     * 
     * For example to retrieve the information about the subscription of user '123' to
     * the event 'vm_console_detected':
     * 
     * ....
     * GET /ovirt-engine/api/users/123/vm_console_detected
     * ....
     * 
     * [source,xml]
     * ----
     * <event-subscription href="/ovirt-engine/api/users/123/event-subscriptions/vm_console_detected">
     *   <event>vm_console_detected</event>
     *   <notification_method>smtp</notification_method>
     *   <user href="/ovirt-engine/api/users/123" id="123"/>
     *   <address>a@b.com</address>
     * </event-subscription>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The event-subscription.
         */
        EventSubscription eventSubscription();
    }
    
    /**
     * Gets the information about the event-subscription.
     * 
     * For example to retrieve the information about the subscription of user '123' to
     * the event 'vm_console_detected':
     * 
     * ....
     * GET /ovirt-engine/api/users/123/vm_console_detected
     * ....
     * 
     * [source,xml]
     * ----
     * <event-subscription href="/ovirt-engine/api/users/123/event-subscriptions/vm_console_detected">
     *   <event>vm_console_detected</event>
     *   <notification_method>smtp</notification_method>
     *   <user href="/ovirt-engine/api/users/123" id="123"/>
     *   <address>a@b.com</address>
     * </event-subscription>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes the event-subscription from the system.
     * 
     * For example to remove user 123's subscription to `vm_console_detected` event:
     * 
     * ....
     * DELETE /ovirt-engine/api/users/123/vm_console_detected
     * ....
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the event-subscription from the system.
     * 
     * For example to remove user 123's subscription to `vm_console_detected` event:
     * 
     * ....
     * DELETE /ovirt-engine/api/users/123/vm_console_detected
     * ....
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the event-subscription from the system.
     * 
     * For example to remove user 123's subscription to `vm_console_detected` event:
     * 
     * ....
     * DELETE /ovirt-engine/api/users/123/vm_console_detected
     * ....
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

