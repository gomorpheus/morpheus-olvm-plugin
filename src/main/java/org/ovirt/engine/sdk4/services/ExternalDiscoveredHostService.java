/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.ExternalDiscoveredHost;

/**
 * This service manages a single discovered host.
 */
public interface ExternalDiscoveredHostService extends Service {
    /**
     * Get discovered host info.
     * 
     * Retrieves information about an host that is managed in external provider management system, such as Foreman. The
     * information includes hostname, address, subnet, base image and more.
     * 
     * For example, to get the details of host `234` from provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/discoveredhosts/234
     * ....
     * 
     * The result will be like this:
     * 
     * [source,xml]
     * ----
     * <external_discovered_host href="/ovirt-engine/api/externalhostproviders/123/discoveredhosts/234" id="234">
     *  <name>mac001a4ad04040</name>
     *  <ip>10.34.67.43</ip>
     *  <last_report>2017-04-24 11:05:41 UTC</last_report>
     *  <mac>00:1a:4a:d0:40:40</mac>
     *  <subnet_name>sat0</subnet_name>
     *  <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     * </external_discovered_host>
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
     * Get discovered host info.
     * 
     * Retrieves information about an host that is managed in external provider management system, such as Foreman. The
     * information includes hostname, address, subnet, base image and more.
     * 
     * For example, to get the details of host `234` from provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/discoveredhosts/234
     * ....
     * 
     * The result will be like this:
     * 
     * [source,xml]
     * ----
     * <external_discovered_host href="/ovirt-engine/api/externalhostproviders/123/discoveredhosts/234" id="234">
     *  <name>mac001a4ad04040</name>
     *  <ip>10.34.67.43</ip>
     *  <last_report>2017-04-24 11:05:41 UTC</last_report>
     *  <mac>00:1a:4a:d0:40:40</mac>
     *  <subnet_name>sat0</subnet_name>
     *  <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     * </external_discovered_host>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Host's hardware and config information.
         */
        ExternalDiscoveredHost host();
    }
    
    /**
     * Get discovered host info.
     * 
     * Retrieves information about an host that is managed in external provider management system, such as Foreman. The
     * information includes hostname, address, subnet, base image and more.
     * 
     * For example, to get the details of host `234` from provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/discoveredhosts/234
     * ....
     * 
     * The result will be like this:
     * 
     * [source,xml]
     * ----
     * <external_discovered_host href="/ovirt-engine/api/externalhostproviders/123/discoveredhosts/234" id="234">
     *  <name>mac001a4ad04040</name>
     *  <ip>10.34.67.43</ip>
     *  <last_report>2017-04-24 11:05:41 UTC</last_report>
     *  <mac>00:1a:4a:d0:40:40</mac>
     *  <subnet_name>sat0</subnet_name>
     *  <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     * </external_discovered_host>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

