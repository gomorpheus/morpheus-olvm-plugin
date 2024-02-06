/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.QosBuilder;
import org.ovirt.engine.sdk4.types.Qos;

public interface QosService extends Service {
    /**
     * Get specified QoS in the data center.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters/123/qoss/123
     * ----
     * 
     * You will get response like this one below:
     * 
     * [source,xml]
     * ----
     * <qos href="/ovirt-engine/api/datacenters/123/qoss/123" id="123">
     *   <name>123</name>
     *   <description>123</description>
     *   <max_iops>1</max_iops>
     *   <max_throughput>1</max_throughput>
     *   <type>storage</type>
     *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
     * </qos>
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
     * Get specified QoS in the data center.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters/123/qoss/123
     * ----
     * 
     * You will get response like this one below:
     * 
     * [source,xml]
     * ----
     * <qos href="/ovirt-engine/api/datacenters/123/qoss/123" id="123">
     *   <name>123</name>
     *   <description>123</description>
     *   <max_iops>1</max_iops>
     *   <max_throughput>1</max_throughput>
     *   <type>storage</type>
     *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
     * </qos>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Queried QoS object.
         */
        Qos qos();
    }
    
    /**
     * Get specified QoS in the data center.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenters/123/qoss/123
     * ----
     * 
     * You will get response like this one below:
     * 
     * [source,xml]
     * ----
     * <qos href="/ovirt-engine/api/datacenters/123/qoss/123" id="123">
     *   <name>123</name>
     *   <description>123</description>
     *   <max_iops>1</max_iops>
     *   <max_throughput>1</max_throughput>
     *   <type>storage</type>
     *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
     * </qos>
     * ----
     */
    GetRequest get();
    
    /**
     * Remove specified QoS from datacenter.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/qoss/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove specified QoS from datacenter.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/qoss/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove specified QoS from datacenter.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/qoss/123
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Update the specified QoS in the dataCenter.
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/qoss/123
     * ----
     * 
     * For example with curl:
     * 
     * [source]
     * ----
     * curl -u admin@internal:123456 -X PUT -H "content-type: application/xml" -d \
     * "<qos><name>321</name><description>321</description><max_iops>10</max_iops></qos>" \
     * https://engine/ovirt-engine/api/datacenters/123/qoss/123
     * ----
     * 
     * You will receive response like this:
     * 
     * [source,xml]
     * ----
     * <qos href="/ovirt-engine/api/datacenters/123/qoss/123" id="123">
     *   <name>321</name>
     *   <description>321</description>
     *   <max_iops>10</max_iops>
     *   <max_throughput>1</max_throughput>
     *   <type>storage</type>
     *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
     * </qos>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest qos(Qos qos);
        /**
         * Updated QoS object.
         */
        UpdateRequest qos(QosBuilder qos);
    }
    
    /**
     * Update the specified QoS in the dataCenter.
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/qoss/123
     * ----
     * 
     * For example with curl:
     * 
     * [source]
     * ----
     * curl -u admin@internal:123456 -X PUT -H "content-type: application/xml" -d \
     * "<qos><name>321</name><description>321</description><max_iops>10</max_iops></qos>" \
     * https://engine/ovirt-engine/api/datacenters/123/qoss/123
     * ----
     * 
     * You will receive response like this:
     * 
     * [source,xml]
     * ----
     * <qos href="/ovirt-engine/api/datacenters/123/qoss/123" id="123">
     *   <name>321</name>
     *   <description>321</description>
     *   <max_iops>10</max_iops>
     *   <max_throughput>1</max_throughput>
     *   <type>storage</type>
     *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
     * </qos>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * Updated QoS object.
         */
        Qos qos();
    }
    
    /**
     * Update the specified QoS in the dataCenter.
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/qoss/123
     * ----
     * 
     * For example with curl:
     * 
     * [source]
     * ----
     * curl -u admin@internal:123456 -X PUT -H "content-type: application/xml" -d \
     * "<qos><name>321</name><description>321</description><max_iops>10</max_iops></qos>" \
     * https://engine/ovirt-engine/api/datacenters/123/qoss/123
     * ----
     * 
     * You will receive response like this:
     * 
     * [source,xml]
     * ----
     * <qos href="/ovirt-engine/api/datacenters/123/qoss/123" id="123">
     *   <name>321</name>
     *   <description>321</description>
     *   <max_iops>10</max_iops>
     *   <max_throughput>1</max_throughput>
     *   <type>storage</type>
     *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
     * </qos>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

