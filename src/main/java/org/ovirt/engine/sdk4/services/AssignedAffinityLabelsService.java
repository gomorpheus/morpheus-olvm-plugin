/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.AffinityLabelBuilder;
import org.ovirt.engine.sdk4.types.AffinityLabel;

/**
 * This service is used to list and manipulate affinity labels that are
 * assigned to supported entities when accessed using entities/affinitylabels.
 */
public interface AssignedAffinityLabelsService extends Service {
    /**
     * Attaches a label to an entity.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest label(AffinityLabel label);
        AddRequest label(AffinityLabelBuilder label);
    }
    
    /**
     * Attaches a label to an entity.
     */
    public interface AddResponse extends Response {
        AffinityLabel label();
    }
    
    /**
     * Attaches a label to an entity.
     */
    AddRequest add();
    
    /**
     * Lists all labels that are attached to an entity.
     * 
     * The order of the returned entities isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * Lists all labels that are attached to an entity.
     * 
     * The order of the returned entities isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<AffinityLabel> label();
    }
    
    /**
     * Lists all labels that are attached to an entity.
     * 
     * The order of the returned entities isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Link to the specific entity-label assignment to allow
     * removal.
     */
    AssignedAffinityLabelService labelService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

