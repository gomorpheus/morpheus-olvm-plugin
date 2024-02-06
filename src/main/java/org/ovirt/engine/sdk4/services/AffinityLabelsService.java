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
 * Manages the affinity labels available in the system.
 */
public interface AffinityLabelsService extends Service {
    /**
     * Creates a new label. The label is automatically attached
     * to all entities mentioned in the vms or hosts lists.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest label(AffinityLabel label);
        AddRequest label(AffinityLabelBuilder label);
    }
    
    /**
     * Creates a new label. The label is automatically attached
     * to all entities mentioned in the vms or hosts lists.
     */
    public interface AddResponse extends Response {
        AffinityLabel label();
    }
    
    /**
     * Creates a new label. The label is automatically attached
     * to all entities mentioned in the vms or hosts lists.
     */
    AddRequest add();
    
    /**
     * Lists all labels present in the system.
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
     * Lists all labels present in the system.
     * 
     * The order of the returned labels isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<AffinityLabel> labels();
    }
    
    /**
     * Lists all labels present in the system.
     * 
     * The order of the returned labels isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Link to a single label details.
     */
    AffinityLabelService labelService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

