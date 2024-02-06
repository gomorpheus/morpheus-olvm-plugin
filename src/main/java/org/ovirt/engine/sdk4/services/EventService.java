/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Event;

/**
 * A service to manage an event in the system.
 */
public interface EventService extends Service {
    /**
     * Get an event.
     * 
     * An example of getting an event:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/events/123
     * ----
     * 
     * [source,xml]
     * ----
     * <event href="/ovirt-engine/api/events/123" id="123">
     *   <description>Host example.com was added by admin@internal-authz.</description>
     *   <code>42</code>
     *   <correlation_id>135</correlation_id>
     *   <custom_id>-1</custom_id>
     *   <flood_rate>30</flood_rate>
     *   <origin>oVirt</origin>
     *   <severity>normal</severity>
     *   <time>2016-12-11T11:13:44.654+02:00</time>
     *   <cluster href="/ovirt-engine/api/clusters/456" id="456"/>
     *   <host href="/ovirt-engine/api/hosts/789" id="789"/>
     *   <user href="/ovirt-engine/api/users/987" id="987"/>
     * </event>
     * ----
     * 
     * Note that the number of fields changes according to the information that resides on the event.
     * For example, for storage domain related events you will get the storage domain reference,
     * as well as the reference for the data center this storage domain resides in.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Get an event.
     * 
     * An example of getting an event:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/events/123
     * ----
     * 
     * [source,xml]
     * ----
     * <event href="/ovirt-engine/api/events/123" id="123">
     *   <description>Host example.com was added by admin@internal-authz.</description>
     *   <code>42</code>
     *   <correlation_id>135</correlation_id>
     *   <custom_id>-1</custom_id>
     *   <flood_rate>30</flood_rate>
     *   <origin>oVirt</origin>
     *   <severity>normal</severity>
     *   <time>2016-12-11T11:13:44.654+02:00</time>
     *   <cluster href="/ovirt-engine/api/clusters/456" id="456"/>
     *   <host href="/ovirt-engine/api/hosts/789" id="789"/>
     *   <user href="/ovirt-engine/api/users/987" id="987"/>
     * </event>
     * ----
     * 
     * Note that the number of fields changes according to the information that resides on the event.
     * For example, for storage domain related events you will get the storage domain reference,
     * as well as the reference for the data center this storage domain resides in.
     */
    public interface GetResponse extends Response {
        Event event();
    }
    
    /**
     * Get an event.
     * 
     * An example of getting an event:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/events/123
     * ----
     * 
     * [source,xml]
     * ----
     * <event href="/ovirt-engine/api/events/123" id="123">
     *   <description>Host example.com was added by admin@internal-authz.</description>
     *   <code>42</code>
     *   <correlation_id>135</correlation_id>
     *   <custom_id>-1</custom_id>
     *   <flood_rate>30</flood_rate>
     *   <origin>oVirt</origin>
     *   <severity>normal</severity>
     *   <time>2016-12-11T11:13:44.654+02:00</time>
     *   <cluster href="/ovirt-engine/api/clusters/456" id="456"/>
     *   <host href="/ovirt-engine/api/hosts/789" id="789"/>
     *   <user href="/ovirt-engine/api/users/987" id="987"/>
     * </event>
     * ----
     * 
     * Note that the number of fields changes according to the information that resides on the event.
     * For example, for storage domain related events you will get the storage domain reference,
     * as well as the reference for the data center this storage domain resides in.
     */
    GetRequest get();
    
    /**
     * Removes an event from internal audit log.
     * 
     * An event can be removed by sending following request
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/events/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes an event from internal audit log.
     * 
     * An event can be removed by sending following request
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/events/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes an event from internal audit log.
     * 
     * An event can be removed by sending following request
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/events/123
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

