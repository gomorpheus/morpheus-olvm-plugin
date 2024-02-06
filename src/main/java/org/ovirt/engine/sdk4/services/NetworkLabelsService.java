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
import org.ovirt.engine.sdk4.builders.NetworkLabelBuilder;
import org.ovirt.engine.sdk4.types.NetworkLabel;

/**
 * Manages the ser of labels attached to a network or to a host NIC.
 */
public interface NetworkLabelsService extends Service {
    /**
     * Attaches label to logical network.
     * 
     * You can attach labels to a logical network to automate the association of that logical network with physical host
     * network interfaces to which the same label has been attached.
     * 
     * For example, to attach the label `mylabel` to a logical network having id `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks/123/networklabels
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network_label id="mylabel"/>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest label(NetworkLabel label);
        AddRequest label(NetworkLabelBuilder label);
    }
    
    /**
     * Attaches label to logical network.
     * 
     * You can attach labels to a logical network to automate the association of that logical network with physical host
     * network interfaces to which the same label has been attached.
     * 
     * For example, to attach the label `mylabel` to a logical network having id `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks/123/networklabels
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network_label id="mylabel"/>
     * ----
     */
    public interface AddResponse extends Response {
        NetworkLabel label();
    }
    
    /**
     * Attaches label to logical network.
     * 
     * You can attach labels to a logical network to automate the association of that logical network with physical host
     * network interfaces to which the same label has been attached.
     * 
     * For example, to attach the label `mylabel` to a logical network having id `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks/123/networklabels
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <network_label id="mylabel"/>
     * ----
     */
    AddRequest add();
    
    /**
     * Returns the list of labels attached to the network or host NIC.
     * 
     * The order of the returned list of labels isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of labels to return. If not specified all the labels are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of labels to return. If not specified all the labels are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of labels to return. If not specified all the labels are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of labels attached to the network or host NIC.
     * 
     * The order of the returned list of labels isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<NetworkLabel> labels();
    }
    
    /**
     * Returns the list of labels attached to the network or host NIC.
     * 
     * The order of the returned list of labels isn't guaranteed.
     */
    ListRequest list();
    
    NetworkLabelService labelService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

