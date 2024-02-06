/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.HostDevice;

/**
 * A service to access a particular device of a host.
 */
public interface HostDeviceService extends Service {
    /**
     * Retrieve information about a particular host's device.
     * 
     * An example of getting a host device:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/devices/456
     * ----
     * 
     * [source,xml]
     * ----
     * <host_device href="/ovirt-engine/api/hosts/123/devices/456" id="456">
     *   <name>usb_1_9_1_1_0</name>
     *   <capability>usb</capability>
     *   <host href="/ovirt-engine/api/hosts/123" id="123"/>
     *   <parent_device href="/ovirt-engine/api/hosts/123/devices/789" id="789">
     *     <name>usb_1_9_1</name>
     *   </parent_device>
     * </host_device>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieve information about a particular host's device.
     * 
     * An example of getting a host device:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/devices/456
     * ----
     * 
     * [source,xml]
     * ----
     * <host_device href="/ovirt-engine/api/hosts/123/devices/456" id="456">
     *   <name>usb_1_9_1_1_0</name>
     *   <capability>usb</capability>
     *   <host href="/ovirt-engine/api/hosts/123" id="123"/>
     *   <parent_device href="/ovirt-engine/api/hosts/123/devices/789" id="789">
     *     <name>usb_1_9_1</name>
     *   </parent_device>
     * </host_device>
     * ----
     */
    public interface GetResponse extends Response {
        HostDevice device();
    }
    
    /**
     * Retrieve information about a particular host's device.
     * 
     * An example of getting a host device:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/devices/456
     * ----
     * 
     * [source,xml]
     * ----
     * <host_device href="/ovirt-engine/api/hosts/123/devices/456" id="456">
     *   <name>usb_1_9_1_1_0</name>
     *   <capability>usb</capability>
     *   <host href="/ovirt-engine/api/hosts/123" id="123"/>
     *   <parent_device href="/ovirt-engine/api/hosts/123/devices/789" id="789">
     *     <name>usb_1_9_1</name>
     *   </parent_device>
     * </host_device>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

