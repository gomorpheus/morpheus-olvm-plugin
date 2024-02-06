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
import org.ovirt.engine.sdk4.types.HostDevice;

/**
 * A service to access host devices.
 */
public interface HostDevicesService extends Service {
    /**
     * List the devices of a host.
     * 
     * The order of the returned list of devices isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of devices to return. If not specified all the devices are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of devices to return. If not specified all the devices are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of devices to return. If not specified all the devices are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List the devices of a host.
     * 
     * The order of the returned list of devices isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<HostDevice> devices();
    }
    
    /**
     * List the devices of a host.
     * 
     * The order of the returned list of devices isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that can be used to access a specific host device.
     */
    HostDeviceService deviceService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

