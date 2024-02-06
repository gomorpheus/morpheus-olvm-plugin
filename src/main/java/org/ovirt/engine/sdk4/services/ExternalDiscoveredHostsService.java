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
import org.ovirt.engine.sdk4.types.ExternalDiscoveredHost;

/**
 * This service manages external discovered hosts.
 */
public interface ExternalDiscoveredHostsService extends Service {
    /**
     * Get list of discovered hosts' information.
     * 
     * Discovered hosts are fetched from third-party providers such as Foreman.
     * 
     * To list all discovered hosts for provider `123` send the following:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/externalhostproviders/123/discoveredhost
     * ----
     * 
     * [source,xml]
     * ----
     * <external_discovered_hosts>
     *  <external_discovered_host href="/ovirt-engine/api/externalhostproviders/123/discoveredhosts/456" id="456">
     *   <name>mac001a4ad04031</name>
     *   <ip>10.34.67.42</ip>
     *   <last_report>2017-04-24 11:05:41 UTC</last_report>
     *   <mac>00:1a:4a:d0:40:31</mac>
     *   <subnet_name>sat0</subnet_name>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *  </external_discovered_host>
     *  <external_discovered_host href="/ovirt-engine/api/externalhostproviders/123/discoveredhosts/789" id="789">
     *   <name>mac001a4ad04040</name>
     *   <ip>10.34.67.43</ip>
     *   <last_report>2017-04-24 11:05:41 UTC</last_report>
     *   <mac>00:1a:4a:d0:40:40</mac>
     *   <subnet_name>sat0</subnet_name>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *  </external_discovered_host>
     *  ...
     * </external_discovered_hosts>
     * ----
     * 
     * The order of the returned list of hosts isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of hosts to return. If not specified all the hosts are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of hosts to return. If not specified all the hosts are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of hosts to return. If not specified all the hosts are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Get list of discovered hosts' information.
     * 
     * Discovered hosts are fetched from third-party providers such as Foreman.
     * 
     * To list all discovered hosts for provider `123` send the following:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/externalhostproviders/123/discoveredhost
     * ----
     * 
     * [source,xml]
     * ----
     * <external_discovered_hosts>
     *  <external_discovered_host href="/ovirt-engine/api/externalhostproviders/123/discoveredhosts/456" id="456">
     *   <name>mac001a4ad04031</name>
     *   <ip>10.34.67.42</ip>
     *   <last_report>2017-04-24 11:05:41 UTC</last_report>
     *   <mac>00:1a:4a:d0:40:31</mac>
     *   <subnet_name>sat0</subnet_name>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *  </external_discovered_host>
     *  <external_discovered_host href="/ovirt-engine/api/externalhostproviders/123/discoveredhosts/789" id="789">
     *   <name>mac001a4ad04040</name>
     *   <ip>10.34.67.43</ip>
     *   <last_report>2017-04-24 11:05:41 UTC</last_report>
     *   <mac>00:1a:4a:d0:40:40</mac>
     *   <subnet_name>sat0</subnet_name>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *  </external_discovered_host>
     *  ...
     * </external_discovered_hosts>
     * ----
     * 
     * The order of the returned list of hosts isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * List of discovered hosts
         */
        List<ExternalDiscoveredHost> hosts();
    }
    
    /**
     * Get list of discovered hosts' information.
     * 
     * Discovered hosts are fetched from third-party providers such as Foreman.
     * 
     * To list all discovered hosts for provider `123` send the following:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/externalhostproviders/123/discoveredhost
     * ----
     * 
     * [source,xml]
     * ----
     * <external_discovered_hosts>
     *  <external_discovered_host href="/ovirt-engine/api/externalhostproviders/123/discoveredhosts/456" id="456">
     *   <name>mac001a4ad04031</name>
     *   <ip>10.34.67.42</ip>
     *   <last_report>2017-04-24 11:05:41 UTC</last_report>
     *   <mac>00:1a:4a:d0:40:31</mac>
     *   <subnet_name>sat0</subnet_name>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *  </external_discovered_host>
     *  <external_discovered_host href="/ovirt-engine/api/externalhostproviders/123/discoveredhosts/789" id="789">
     *   <name>mac001a4ad04040</name>
     *   <ip>10.34.67.43</ip>
     *   <last_report>2017-04-24 11:05:41 UTC</last_report>
     *   <mac>00:1a:4a:d0:40:40</mac>
     *   <subnet_name>sat0</subnet_name>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *  </external_discovered_host>
     *  ...
     * </external_discovered_hosts>
     * ----
     * 
     * The order of the returned list of hosts isn't guaranteed.
     */
    ListRequest list();
    
    ExternalDiscoveredHostService hostService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

