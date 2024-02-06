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
import org.ovirt.engine.sdk4.builders.QosBuilder;
import org.ovirt.engine.sdk4.types.Qos;

/**
 * Manages the set of _quality of service_ configurations available in a data center.
 */
public interface QossService extends Service {
    /**
     * Add a new QoS to the dataCenter.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/qoss
     * ----
     * 
     * The response will look as follows:
     * 
     * [source,xml]
     * ----
     * <qos href="/ovirt-engine/api/datacenters/123/qoss/123" id="123">
     *   <name>123</name>
     *   <description>123</description>
     *   <max_iops>10</max_iops>
     *   <type>storage</type>
     *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
     * </qos>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest qos(Qos qos);
        /**
         * Added QoS object.
         */
        AddRequest qos(QosBuilder qos);
    }
    
    /**
     * Add a new QoS to the dataCenter.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/qoss
     * ----
     * 
     * The response will look as follows:
     * 
     * [source,xml]
     * ----
     * <qos href="/ovirt-engine/api/datacenters/123/qoss/123" id="123">
     *   <name>123</name>
     *   <description>123</description>
     *   <max_iops>10</max_iops>
     *   <type>storage</type>
     *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
     * </qos>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * Added QoS object.
         */
        Qos qos();
    }
    
    /**
     * Add a new QoS to the dataCenter.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/qoss
     * ----
     * 
     * The response will look as follows:
     * 
     * [source,xml]
     * ----
     * <qos href="/ovirt-engine/api/datacenters/123/qoss/123" id="123">
     *   <name>123</name>
     *   <description>123</description>
     *   <max_iops>10</max_iops>
     *   <type>storage</type>
     *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
     * </qos>
     * ----
     */
    AddRequest add();
    
    /**
     * Returns the list of _quality of service_ configurations available in the data center.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenter/123/qoss
     * ----
     * 
     * You will get response which will look like this:
     * 
     * [source, xml]
     * ----
     * <qoss>
     *   <qos href="/ovirt-engine/api/datacenters/123/qoss/1" id="1">...</qos>
     *   <qos href="/ovirt-engine/api/datacenters/123/qoss/2" id="2">...</qos>
     *   <qos href="/ovirt-engine/api/datacenters/123/qoss/3" id="3">...</qos>
     * </qoss>
     * ----
     * 
     * The returned list of quality of service configurations isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of QoS descriptors to return. If not specified all the descriptors are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of QoS descriptors to return. If not specified all the descriptors are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of QoS descriptors to return. If not specified all the descriptors are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of _quality of service_ configurations available in the data center.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenter/123/qoss
     * ----
     * 
     * You will get response which will look like this:
     * 
     * [source, xml]
     * ----
     * <qoss>
     *   <qos href="/ovirt-engine/api/datacenters/123/qoss/1" id="1">...</qos>
     *   <qos href="/ovirt-engine/api/datacenters/123/qoss/2" id="2">...</qos>
     *   <qos href="/ovirt-engine/api/datacenters/123/qoss/3" id="3">...</qos>
     * </qoss>
     * ----
     * 
     * The returned list of quality of service configurations isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * List of queried QoS objects.
         */
        List<Qos> qoss();
    }
    
    /**
     * Returns the list of _quality of service_ configurations available in the data center.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/datacenter/123/qoss
     * ----
     * 
     * You will get response which will look like this:
     * 
     * [source, xml]
     * ----
     * <qoss>
     *   <qos href="/ovirt-engine/api/datacenters/123/qoss/1" id="1">...</qos>
     *   <qos href="/ovirt-engine/api/datacenters/123/qoss/2" id="2">...</qos>
     *   <qos href="/ovirt-engine/api/datacenters/123/qoss/3" id="3">...</qos>
     * </qoss>
     * ----
     * 
     * The returned list of quality of service configurations isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * A reference to a service managing a specific QoS.
     */
    QosService qosService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

