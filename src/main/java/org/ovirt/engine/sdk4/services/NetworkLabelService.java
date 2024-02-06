/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.NetworkLabel;

public interface NetworkLabelService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        NetworkLabel label();
    }
    
    GetRequest get();
    
    /**
     * Removes a label from a logical network.
     * 
     * For example, to remove the label `exemplary` from a logical network having id `123` send the following request:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/networks/123/networklabels/exemplary
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes a label from a logical network.
     * 
     * For example, to remove the label `exemplary` from a logical network having id `123` send the following request:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/networks/123/networklabels/exemplary
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a label from a logical network.
     * 
     * For example, to remove the label `exemplary` from a logical network having id `123` send the following request:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/networks/123/networklabels/exemplary
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

