/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;

public interface MoveableService extends Service {
    public interface MoveRequest extends Request<MoveRequest, MoveResponse> {
        /**
         * Indicates if the move should be performed asynchronously.
         */
        MoveRequest async(Boolean async);
    }
    
    public interface MoveResponse extends Response {
    }
    
    MoveRequest move();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

