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
import org.ovirt.engine.sdk4.types.Statistic;

public interface StatisticsService extends Service {
    /**
     * Retrieves a list of statistics.
     * 
     * For example, to retrieve the statistics for virtual machine `123` send a
     * request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/statistics
     * ----
     * 
     * The result will be like this:
     * 
     * [source,xml]
     * ----
     * <statistics>
     *   <statistic href="/ovirt-engine/api/vms/123/statistics/456" id="456">
     *     <name>memory.installed</name>
     *     <description>Total memory configured</description>
     *     <kind>gauge</kind>
     *     <type>integer</type>
     *     <unit>bytes</unit>
     *     <values>
     *       <value>
     *         <datum>1073741824</datum>
     *       </value>
     *     </values>
     *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   </statistic>
     *   ...
     * </statistics>
     * ----
     * 
     * Just a single part of the statistics can be retrieved by specifying its id at the end of the URI. That means:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/statistics/456
     * ----
     * 
     * Outputs:
     * 
     * [source,xml]
     * ----
     * <statistic href="/ovirt-engine/api/vms/123/statistics/456" id="456">
     *   <name>memory.installed</name>
     *   <description>Total memory configured</description>
     *   <kind>gauge</kind>
     *   <type>integer</type>
     *   <unit>bytes</unit>
     *   <values>
     *     <value>
     *       <datum>1073741824</datum>
     *     </value>
     *   </values>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </statistic>
     * ----
     * 
     * The order of the returned list of statistics isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of statistics to return. If not specified all the statistics are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of statistics to return. If not specified all the statistics are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of statistics to return. If not specified all the statistics are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Retrieves a list of statistics.
     * 
     * For example, to retrieve the statistics for virtual machine `123` send a
     * request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/statistics
     * ----
     * 
     * The result will be like this:
     * 
     * [source,xml]
     * ----
     * <statistics>
     *   <statistic href="/ovirt-engine/api/vms/123/statistics/456" id="456">
     *     <name>memory.installed</name>
     *     <description>Total memory configured</description>
     *     <kind>gauge</kind>
     *     <type>integer</type>
     *     <unit>bytes</unit>
     *     <values>
     *       <value>
     *         <datum>1073741824</datum>
     *       </value>
     *     </values>
     *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   </statistic>
     *   ...
     * </statistics>
     * ----
     * 
     * Just a single part of the statistics can be retrieved by specifying its id at the end of the URI. That means:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/statistics/456
     * ----
     * 
     * Outputs:
     * 
     * [source,xml]
     * ----
     * <statistic href="/ovirt-engine/api/vms/123/statistics/456" id="456">
     *   <name>memory.installed</name>
     *   <description>Total memory configured</description>
     *   <kind>gauge</kind>
     *   <type>integer</type>
     *   <unit>bytes</unit>
     *   <values>
     *     <value>
     *       <datum>1073741824</datum>
     *     </value>
     *   </values>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </statistic>
     * ----
     * 
     * The order of the returned list of statistics isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Statistic> statistics();
    }
    
    /**
     * Retrieves a list of statistics.
     * 
     * For example, to retrieve the statistics for virtual machine `123` send a
     * request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/statistics
     * ----
     * 
     * The result will be like this:
     * 
     * [source,xml]
     * ----
     * <statistics>
     *   <statistic href="/ovirt-engine/api/vms/123/statistics/456" id="456">
     *     <name>memory.installed</name>
     *     <description>Total memory configured</description>
     *     <kind>gauge</kind>
     *     <type>integer</type>
     *     <unit>bytes</unit>
     *     <values>
     *       <value>
     *         <datum>1073741824</datum>
     *       </value>
     *     </values>
     *     <vm href="/ovirt-engine/api/vms/123" id="123"/>
     *   </statistic>
     *   ...
     * </statistics>
     * ----
     * 
     * Just a single part of the statistics can be retrieved by specifying its id at the end of the URI. That means:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/statistics/456
     * ----
     * 
     * Outputs:
     * 
     * [source,xml]
     * ----
     * <statistic href="/ovirt-engine/api/vms/123/statistics/456" id="456">
     *   <name>memory.installed</name>
     *   <description>Total memory configured</description>
     *   <kind>gauge</kind>
     *   <type>integer</type>
     *   <unit>bytes</unit>
     *   <values>
     *     <value>
     *       <datum>1073741824</datum>
     *     </value>
     *   </values>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </statistic>
     * ----
     * 
     * The order of the returned list of statistics isn't guaranteed.
     */
    ListRequest list();
    
    StatisticService statisticService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

