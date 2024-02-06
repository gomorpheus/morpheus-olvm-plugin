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
import org.ovirt.engine.sdk4.builders.EventBuilder;
import org.ovirt.engine.sdk4.types.Event;

/**
 * A service to manage events in the system.
 */
public interface EventsService extends Service {
    /**
     * Adds an external event to the internal audit log.
     * 
     * This is intended for integration with external systems that detect or produce events relevant for the
     * administrator of the system. For example, an external monitoring tool may be able to detect that a file system
     * is full inside the guest operating system of a virtual machine. This event can be added to the internal audit
     * log sending a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/events
     * <event>
     *   <description>File system /home is full</description>
     *   <severity>alert</severity>
     *   <origin>mymonitor</origin>
     *   <custom_id>1467879754</custom_id>
     * </event>
     * ----
     * 
     * Events can also be linked to specific objects. For example, the above event could be linked to the specific
     * virtual machine where it happened, using the `vm` link:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/events
     * <event>
     *   <description>File system /home is full</description>
     *   <severity>alert</severity>
     *   <origin>mymonitor</origin>
     *   <custom_id>1467879754</custom_id>
     *   <vm id="aae98225-5b73-490d-a252-899209af17e9"/>
     * </event>
     * ----
     * 
     * NOTE: When using links, like the `vm` in the previous example, only the `id` attribute is accepted. The `name`
     * attribute, if provided, is simply ignored.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest event(Event event);
        AddRequest event(EventBuilder event);
    }
    
    /**
     * Adds an external event to the internal audit log.
     * 
     * This is intended for integration with external systems that detect or produce events relevant for the
     * administrator of the system. For example, an external monitoring tool may be able to detect that a file system
     * is full inside the guest operating system of a virtual machine. This event can be added to the internal audit
     * log sending a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/events
     * <event>
     *   <description>File system /home is full</description>
     *   <severity>alert</severity>
     *   <origin>mymonitor</origin>
     *   <custom_id>1467879754</custom_id>
     * </event>
     * ----
     * 
     * Events can also be linked to specific objects. For example, the above event could be linked to the specific
     * virtual machine where it happened, using the `vm` link:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/events
     * <event>
     *   <description>File system /home is full</description>
     *   <severity>alert</severity>
     *   <origin>mymonitor</origin>
     *   <custom_id>1467879754</custom_id>
     *   <vm id="aae98225-5b73-490d-a252-899209af17e9"/>
     * </event>
     * ----
     * 
     * NOTE: When using links, like the `vm` in the previous example, only the `id` attribute is accepted. The `name`
     * attribute, if provided, is simply ignored.
     */
    public interface AddResponse extends Response {
        Event event();
    }
    
    /**
     * Adds an external event to the internal audit log.
     * 
     * This is intended for integration with external systems that detect or produce events relevant for the
     * administrator of the system. For example, an external monitoring tool may be able to detect that a file system
     * is full inside the guest operating system of a virtual machine. This event can be added to the internal audit
     * log sending a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/events
     * <event>
     *   <description>File system /home is full</description>
     *   <severity>alert</severity>
     *   <origin>mymonitor</origin>
     *   <custom_id>1467879754</custom_id>
     * </event>
     * ----
     * 
     * Events can also be linked to specific objects. For example, the above event could be linked to the specific
     * virtual machine where it happened, using the `vm` link:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/events
     * <event>
     *   <description>File system /home is full</description>
     *   <severity>alert</severity>
     *   <origin>mymonitor</origin>
     *   <custom_id>1467879754</custom_id>
     *   <vm id="aae98225-5b73-490d-a252-899209af17e9"/>
     * </event>
     * ----
     * 
     * NOTE: When using links, like the `vm` in the previous example, only the `id` attribute is accepted. The `name`
     * attribute, if provided, is simply ignored.
     */
    AddRequest add();
    
    /**
     * Get list of events.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/events
     * ----
     * 
     * To the above request we get following response:
     * 
     * [source,xml]
     * ----
     * <events>
     *   <event href="/ovirt-engine/api/events/2" id="2">
     *     <description>User admin@internal-authz logged out.</description>
     *     <code>31</code>
     *     <correlation_id>1e892ea9</correlation_id>
     *     <custom_id>-1</custom_id>
     *     <flood_rate>30</flood_rate>
     *     <origin>oVirt</origin>
     *     <severity>normal</severity>
     *     <time>2016-09-14T12:14:34.541+02:00</time>
     *     <user href="/ovirt-engine/api/users/57d91d48-00da-0137-0138-000000000244" id="57d91d48-00da-0137-0138-000000000244"/>
     *   </event>
     *   <event href="/ovirt-engine/api/events/1" id="1">
     *     <description>User admin logged in.</description>
     *     <code>30</code>
     *     <correlation_id>1fbd81f4</correlation_id>
     *     <custom_id>-1</custom_id>
     *     <flood_rate>30</flood_rate>
     *     <origin>oVirt</origin>
     *     <severity>normal</severity>
     *     <time>2016-09-14T11:54:35.229+02:00</time>
     *     <user href="/ovirt-engine/api/users/57d91d48-00da-0137-0138-000000000244" id="57d91d48-00da-0137-0138-000000000244"/>
     *   </event>
     * </events>
     * ----
     * 
     * The following events occur:
     * 
     * * id="1" - The API logs in the admin user account.
     * * id="2" - The API logs out of the admin user account.
     * 
     * The order of the returned list of events is always garanteed. If the `sortby` clause is included in the
     * `search` parameter, then the events will be ordered according to that clause. If the `sortby` clause isn't
     * included, then the events will be sorted by the numeric value of the `id` attribute, starting with the
     * highest value. This, combined with the `max` parameter, simplifies obtaining the most recent event:
     * 
     * ....
     * GET /ovirt-engine/api/events?max=1
     * ....
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Indicates the event index after which events should be returned. The indexes of events are
         * strictly increasing, so when this parameter is used only the events with greater indexes
         * will be returned. For example, the following request will return only the events
         * with indexes greater than `123`:
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/events?from=123
         * ----
         * 
         * This parameter is optional, and if not specified then the first event returned will be most recently
         * generated.
         */
        ListRequest from(Integer from);
        /**
         * Indicates the event index after which events should be returned. The indexes of events are
         * strictly increasing, so when this parameter is used only the events with greater indexes
         * will be returned. For example, the following request will return only the events
         * with indexes greater than `123`:
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/events?from=123
         * ----
         * 
         * This parameter is optional, and if not specified then the first event returned will be most recently
         * generated.
         */
        ListRequest from(Long from);
        /**
         * Indicates the event index after which events should be returned. The indexes of events are
         * strictly increasing, so when this parameter is used only the events with greater indexes
         * will be returned. For example, the following request will return only the events
         * with indexes greater than `123`:
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/events?from=123
         * ----
         * 
         * This parameter is optional, and if not specified then the first event returned will be most recently
         * generated.
         */
        ListRequest from(BigInteger from);
        /**
         * Sets the maximum number of events to return. If not specified all the events are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of events to return. If not specified all the events are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of events to return. If not specified all the events are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * The events service provides search queries similar to other resource services.
         * 
         * We can search by providing specific severity.
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/events?search=severity%3Dnormal
         * ----
         * 
         * To the above request we get a list of events which severity is equal to `normal`:
         * 
         * [source,xml]
         * ----
         * <events>
         *   <event href="/ovirt-engine/api/events/2" id="2">
         *     <description>User admin@internal-authz logged out.</description>
         *     <code>31</code>
         *     <correlation_id>1fbd81f4</correlation_id>
         *     <custom_id>-1</custom_id>
         *     <flood_rate>30</flood_rate>
         *     <origin>oVirt</origin>
         *     <severity>normal</severity>
         *     <time>2016-09-14T11:54:35.229+02:00</time>
         *     <user href="/ovirt-engine/api/users/57d91d48-00da-0137-0138-000000000244" id="57d91d48-00da-0137-0138-000000000244"/>
         *   </event>
         *   <event href="/ovirt-engine/api/events/1" id="1">
         *     <description>Affinity Rules Enforcement Manager started.</description>
         *     <code>10780</code>
         *     <custom_id>-1</custom_id>
         *     <flood_rate>30</flood_rate>
         *     <origin>oVirt</origin>
         *     <severity>normal</severity>
         *     <time>2016-09-14T11:52:18.861+02:00</time>
         *   </event>
         * </events>
         * ----
         * 
         * A virtualization environment generates a large amount of events after
         * a period of time. However, the API only displays a default number of
         * events for one search query. To display more than the default, the API
         * separates results into pages with the page command in a search query.
         * The following search query tells the API to paginate results using a
         * page value in combination with the sortby clause:
         * 
         * [source]
         * ----
         * sortby time asc page 1
         * ----
         * 
         * Below example paginates event resources. The URL-encoded request is:
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/events?search=sortby%20time%20asc%20page%201
         * ----
         * 
         * Increase the page value to view the next page of results.
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/events?search=sortby%20time%20asc%20page%202
         * ----
         */
        ListRequest search(String search);
    }
    
    /**
     * Get list of events.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/events
     * ----
     * 
     * To the above request we get following response:
     * 
     * [source,xml]
     * ----
     * <events>
     *   <event href="/ovirt-engine/api/events/2" id="2">
     *     <description>User admin@internal-authz logged out.</description>
     *     <code>31</code>
     *     <correlation_id>1e892ea9</correlation_id>
     *     <custom_id>-1</custom_id>
     *     <flood_rate>30</flood_rate>
     *     <origin>oVirt</origin>
     *     <severity>normal</severity>
     *     <time>2016-09-14T12:14:34.541+02:00</time>
     *     <user href="/ovirt-engine/api/users/57d91d48-00da-0137-0138-000000000244" id="57d91d48-00da-0137-0138-000000000244"/>
     *   </event>
     *   <event href="/ovirt-engine/api/events/1" id="1">
     *     <description>User admin logged in.</description>
     *     <code>30</code>
     *     <correlation_id>1fbd81f4</correlation_id>
     *     <custom_id>-1</custom_id>
     *     <flood_rate>30</flood_rate>
     *     <origin>oVirt</origin>
     *     <severity>normal</severity>
     *     <time>2016-09-14T11:54:35.229+02:00</time>
     *     <user href="/ovirt-engine/api/users/57d91d48-00da-0137-0138-000000000244" id="57d91d48-00da-0137-0138-000000000244"/>
     *   </event>
     * </events>
     * ----
     * 
     * The following events occur:
     * 
     * * id="1" - The API logs in the admin user account.
     * * id="2" - The API logs out of the admin user account.
     * 
     * The order of the returned list of events is always garanteed. If the `sortby` clause is included in the
     * `search` parameter, then the events will be ordered according to that clause. If the `sortby` clause isn't
     * included, then the events will be sorted by the numeric value of the `id` attribute, starting with the
     * highest value. This, combined with the `max` parameter, simplifies obtaining the most recent event:
     * 
     * ....
     * GET /ovirt-engine/api/events?max=1
     * ....
     */
    public interface ListResponse extends Response {
        List<Event> events();
    }
    
    /**
     * Get list of events.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/events
     * ----
     * 
     * To the above request we get following response:
     * 
     * [source,xml]
     * ----
     * <events>
     *   <event href="/ovirt-engine/api/events/2" id="2">
     *     <description>User admin@internal-authz logged out.</description>
     *     <code>31</code>
     *     <correlation_id>1e892ea9</correlation_id>
     *     <custom_id>-1</custom_id>
     *     <flood_rate>30</flood_rate>
     *     <origin>oVirt</origin>
     *     <severity>normal</severity>
     *     <time>2016-09-14T12:14:34.541+02:00</time>
     *     <user href="/ovirt-engine/api/users/57d91d48-00da-0137-0138-000000000244" id="57d91d48-00da-0137-0138-000000000244"/>
     *   </event>
     *   <event href="/ovirt-engine/api/events/1" id="1">
     *     <description>User admin logged in.</description>
     *     <code>30</code>
     *     <correlation_id>1fbd81f4</correlation_id>
     *     <custom_id>-1</custom_id>
     *     <flood_rate>30</flood_rate>
     *     <origin>oVirt</origin>
     *     <severity>normal</severity>
     *     <time>2016-09-14T11:54:35.229+02:00</time>
     *     <user href="/ovirt-engine/api/users/57d91d48-00da-0137-0138-000000000244" id="57d91d48-00da-0137-0138-000000000244"/>
     *   </event>
     * </events>
     * ----
     * 
     * The following events occur:
     * 
     * * id="1" - The API logs in the admin user account.
     * * id="2" - The API logs out of the admin user account.
     * 
     * The order of the returned list of events is always garanteed. If the `sortby` clause is included in the
     * `search` parameter, then the events will be ordered according to that clause. If the `sortby` clause isn't
     * included, then the events will be sorted by the numeric value of the `id` attribute, starting with the
     * highest value. This, combined with the `max` parameter, simplifies obtaining the most recent event:
     * 
     * ....
     * GET /ovirt-engine/api/events?max=1
     * ....
     */
    ListRequest list();
    
    public interface UndeleteRequest extends Request<UndeleteRequest, UndeleteResponse> {
        /**
         * Indicates if the un-delete should be performed asynchronously.
         */
        UndeleteRequest async(Boolean async);
    }
    
    public interface UndeleteResponse extends Response {
    }
    
    UndeleteRequest undelete();
    
    /**
     * Reference to the service that manages a specific event.
     */
    EventService eventService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

