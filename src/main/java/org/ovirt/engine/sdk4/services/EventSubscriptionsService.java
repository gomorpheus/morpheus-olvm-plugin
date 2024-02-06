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
import org.ovirt.engine.sdk4.builders.EventSubscriptionBuilder;
import org.ovirt.engine.sdk4.types.EventSubscription;

/**
 * Represents a service to manage collection of event-subscription of a user.
 */
public interface EventSubscriptionsService extends Service {
    /**
     * Add a new event-subscription to the system.
     * 
     * An event-subscription is always added in the context of a user. For example, to add new
     * event-subscription for `host_high_cpu_use` for user `123`, and have the notification
     * sent to the e-mail address: `a@b.com`, send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/users/123/eventsubscriptions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <event_subscription>
     *     <event>host_high_cpu_use</event>
     *     <address>a@b.com</address>
     * </event_subscription>
     * ----
     * 
     * The event name will become the ID of the new event-subscription entity:
     * GET .../api/users/123/eventsubscriptions/host_high_cpu_use
     * 
     * Note that no user id is provided in the request body. This is because the user-id (in this case 123)
     * is already known to the API from the context. Note also that event-subscription entity contains
     * notification-method field, but it is not provided either in the request body. This is because currently
     * it's always set to SMTP as SNMP notifications are still unsupported by the API layer.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest eventSubscription(EventSubscription eventSubscription);
        /**
         * The added event-subscription.
         */
        AddRequest eventSubscription(EventSubscriptionBuilder eventSubscription);
    }
    
    /**
     * Add a new event-subscription to the system.
     * 
     * An event-subscription is always added in the context of a user. For example, to add new
     * event-subscription for `host_high_cpu_use` for user `123`, and have the notification
     * sent to the e-mail address: `a@b.com`, send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/users/123/eventsubscriptions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <event_subscription>
     *     <event>host_high_cpu_use</event>
     *     <address>a@b.com</address>
     * </event_subscription>
     * ----
     * 
     * The event name will become the ID of the new event-subscription entity:
     * GET .../api/users/123/eventsubscriptions/host_high_cpu_use
     * 
     * Note that no user id is provided in the request body. This is because the user-id (in this case 123)
     * is already known to the API from the context. Note also that event-subscription entity contains
     * notification-method field, but it is not provided either in the request body. This is because currently
     * it's always set to SMTP as SNMP notifications are still unsupported by the API layer.
     */
    public interface AddResponse extends Response {
        /**
         * The added event-subscription.
         */
        EventSubscription eventSubscription();
    }
    
    /**
     * Add a new event-subscription to the system.
     * 
     * An event-subscription is always added in the context of a user. For example, to add new
     * event-subscription for `host_high_cpu_use` for user `123`, and have the notification
     * sent to the e-mail address: `a@b.com`, send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/users/123/eventsubscriptions
     * ....
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <event_subscription>
     *     <event>host_high_cpu_use</event>
     *     <address>a@b.com</address>
     * </event_subscription>
     * ----
     * 
     * The event name will become the ID of the new event-subscription entity:
     * GET .../api/users/123/eventsubscriptions/host_high_cpu_use
     * 
     * Note that no user id is provided in the request body. This is because the user-id (in this case 123)
     * is already known to the API from the context. Note also that event-subscription entity contains
     * notification-method field, but it is not provided either in the request body. This is because currently
     * it's always set to SMTP as SNMP notifications are still unsupported by the API layer.
     */
    AddRequest add();
    
    /**
     * List the event-subscriptions for the provided user.
     * 
     * For example to list event-subscriptions for user `123`:
     * 
     * ....
     * GET /ovirt-engine/api/users/123/event-subscriptions
     * ....
     * 
     * [source,xml]
     * ----
     * <event-subscriptions>
     *   <event-subscription href="/ovirt-engine/api/users/123/event-subscriptions/host_install_failed">
     *     <event>host_install_failed</event>
     *     <notification_method>smtp</notification_method>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *     <address>a@b.com</address>
     *   </event-subscription>
     *   <event-subscription href="/ovirt-engine/api/users/123/event-subscriptions/vm_paused">
     *     <event>vm_paused</event>
     *     <notification_method>smtp</notification_method>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *     <address>a@b.com</address>
     *   </event-subscription>
     * </event-subscriptions>
     * ----
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of event-subscriptions to return.
         * If not specified all the event-subscriptions are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of event-subscriptions to return.
         * If not specified all the event-subscriptions are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of event-subscriptions to return.
         * If not specified all the event-subscriptions are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List the event-subscriptions for the provided user.
     * 
     * For example to list event-subscriptions for user `123`:
     * 
     * ....
     * GET /ovirt-engine/api/users/123/event-subscriptions
     * ....
     * 
     * [source,xml]
     * ----
     * <event-subscriptions>
     *   <event-subscription href="/ovirt-engine/api/users/123/event-subscriptions/host_install_failed">
     *     <event>host_install_failed</event>
     *     <notification_method>smtp</notification_method>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *     <address>a@b.com</address>
     *   </event-subscription>
     *   <event-subscription href="/ovirt-engine/api/users/123/event-subscriptions/vm_paused">
     *     <event>vm_paused</event>
     *     <notification_method>smtp</notification_method>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *     <address>a@b.com</address>
     *   </event-subscription>
     * </event-subscriptions>
     * ----
     */
    public interface ListResponse extends Response {
        /**
         * List of the event-subscriptions for the specified user
         */
        List<EventSubscription> eventSubscriptions();
    }
    
    /**
     * List the event-subscriptions for the provided user.
     * 
     * For example to list event-subscriptions for user `123`:
     * 
     * ....
     * GET /ovirt-engine/api/users/123/event-subscriptions
     * ....
     * 
     * [source,xml]
     * ----
     * <event-subscriptions>
     *   <event-subscription href="/ovirt-engine/api/users/123/event-subscriptions/host_install_failed">
     *     <event>host_install_failed</event>
     *     <notification_method>smtp</notification_method>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *     <address>a@b.com</address>
     *   </event-subscription>
     *   <event-subscription href="/ovirt-engine/api/users/123/event-subscriptions/vm_paused">
     *     <event>vm_paused</event>
     *     <notification_method>smtp</notification_method>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *     <address>a@b.com</address>
     *   </event-subscription>
     * </event-subscriptions>
     * ----
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific event-subscription.
     */
    EventSubscriptionService eventSubscriptionService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

