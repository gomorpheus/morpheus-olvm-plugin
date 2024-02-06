/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.AffinityLabel;

/**
 * This service represents one label to entity assignment
 * when accessed using the entities/affinitylabels subcollection.
 */
public interface AssignedAffinityLabelService extends Service {
    /**
     * Retrieves details about the attached label.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves details about the attached label.
     */
    public interface GetResponse extends Response {
        AffinityLabel label();
    }
    
    /**
     * Retrieves details about the attached label.
     */
    GetRequest get();
    
    /**
     * Removes the label from an entity. Does not touch the label itself.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
    }
    
    /**
     * Removes the label from an entity. Does not touch the label itself.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the label from an entity. Does not touch the label itself.
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

