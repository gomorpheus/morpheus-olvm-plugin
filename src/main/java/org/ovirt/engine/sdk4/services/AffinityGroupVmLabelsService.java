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
import org.ovirt.engine.sdk4.builders.AffinityLabelBuilder;
import org.ovirt.engine.sdk4.types.AffinityLabel;

/**
 * This service manages a collection of all virtual machine labels assigned to an affinity group.
 */
public interface AffinityGroupVmLabelsService extends Service {
    /**
     * Adds a virtual machine label to the affinity group.
     * 
     * For example, to add the label `789` to the affinity group `456` of cluster `123`,
     * send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/affinitygroups/456/vmlabels
     * ....
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <affinity_label id="789"/>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest label(AffinityLabel label);
        /**
         * The AffinityLabel object to add to the affinity group.
         */
        AddRequest label(AffinityLabelBuilder label);
    }
    
    /**
     * Adds a virtual machine label to the affinity group.
     * 
     * For example, to add the label `789` to the affinity group `456` of cluster `123`,
     * send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/affinitygroups/456/vmlabels
     * ....
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <affinity_label id="789"/>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The AffinityLabel object to add to the affinity group.
         */
        AffinityLabel label();
    }
    
    /**
     * Adds a virtual machine label to the affinity group.
     * 
     * For example, to add the label `789` to the affinity group `456` of cluster `123`,
     * send a request like this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/affinitygroups/456/vmlabels
     * ....
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <affinity_label id="789"/>
     * ----
     */
    AddRequest add();
    
    /**
     * List all virtual machine labels assigned to this affinity group.
     * 
     * The order of the returned labels isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of virtual machine labels to return.
         * If not specified, all the labels are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of virtual machine labels to return.
         * If not specified, all the labels are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of virtual machine labels to return.
         * If not specified, all the labels are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List all virtual machine labels assigned to this affinity group.
     * 
     * The order of the returned labels isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * Virtual machine labels assigned to the affinity group.
         */
        List<AffinityLabel> labels();
    }
    
    /**
     * List all virtual machine labels assigned to this affinity group.
     * 
     * The order of the returned labels isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Access the service that manages the virtual machine label assignment to this affinity group.
     */
    AffinityGroupVmLabelService labelService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

