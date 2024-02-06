/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Vm;

/**
 * This service represents a vm that has a specific
 * label when accessed through the affinitylabels/vms
 * subcollection.
 */
public interface AffinityLabelVmService extends Service {
    /**
     * Retrieves details about a vm that has this label assigned.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves details about a vm that has this label assigned.
     */
    public interface GetResponse extends Response {
        Vm vm();
    }
    
    /**
     * Retrieves details about a vm that has this label assigned.
     */
    GetRequest get();
    
    /**
     * Remove a label from a vm.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
    }
    
    /**
     * Remove a label from a vm.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove a label from a vm.
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

