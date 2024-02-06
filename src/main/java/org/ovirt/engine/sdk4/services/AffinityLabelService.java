/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.AffinityLabelBuilder;
import org.ovirt.engine.sdk4.types.AffinityLabel;

/**
 * The details of a single affinity label.
 */
public interface AffinityLabelService extends Service {
    /**
     * Retrieves the details of a label.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves the details of a label.
     */
    public interface GetResponse extends Response {
        AffinityLabel label();
    }
    
    /**
     * Retrieves the details of a label.
     */
    GetRequest get();
    
    /**
     * Removes a label from the system and clears all assignments
     * of the removed label.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
    }
    
    /**
     * Removes a label from the system and clears all assignments
     * of the removed label.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a label from the system and clears all assignments
     * of the removed label.
     */
    RemoveRequest remove();
    
    /**
     * Updates a label. This call will update all metadata, such as the name
     * or description.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        UpdateRequest label(AffinityLabel label);
        UpdateRequest label(AffinityLabelBuilder label);
    }
    
    /**
     * Updates a label. This call will update all metadata, such as the name
     * or description.
     */
    public interface UpdateResponse extends Response {
        AffinityLabel label();
    }
    
    /**
     * Updates a label. This call will update all metadata, such as the name
     * or description.
     */
    UpdateRequest update();
    
    /**
     * List all hosts with this label.
     */
    AffinityLabelHostsService hostsService();
    /**
     * List all virtual machines with this label.
     */
    AffinityLabelVmsService vmsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

