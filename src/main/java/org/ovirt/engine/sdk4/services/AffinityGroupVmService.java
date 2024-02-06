/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;

/**
 * This service manages a single virtual machine to affinity group assignment.
 */
public interface AffinityGroupVmService extends Service {
    /**
     * Remove this virtual machine from the affinity group.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the removal should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove this virtual machine from the affinity group.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove this virtual machine from the affinity group.
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

