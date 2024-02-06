/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;

public interface CopyableService extends Service {
    public interface CopyRequest extends Request<CopyRequest, CopyResponse> {
        /**
         * Indicates if the copy should be performed asynchronously.
         */
        CopyRequest async(Boolean async);
    }
    
    public interface CopyResponse extends Response {
    }
    
    CopyRequest copy();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

