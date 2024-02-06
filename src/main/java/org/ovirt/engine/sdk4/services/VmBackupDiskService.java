/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Disk;

public interface VmBackupDiskService extends Service {
    /**
     * Retrieves the description of the disk.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves the description of the disk.
     */
    public interface GetResponse extends Response {
        /**
         * The description of the disk.
         */
        Disk disk();
    }
    
    /**
     * Retrieves the description of the disk.
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

