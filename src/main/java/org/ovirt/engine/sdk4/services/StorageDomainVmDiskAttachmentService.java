/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.DiskAttachment;

/**
 * Returns the details of the disks attached to a virtual machine in the export domain.
 */
public interface StorageDomainVmDiskAttachmentService extends Service {
    /**
     * Returns the details of the attachment with all its properties and a link to the disk.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns the details of the attachment with all its properties and a link to the disk.
     */
    public interface GetResponse extends Response {
        /**
         * The disk attachment.
         */
        DiskAttachment attachment();
    }
    
    /**
     * Returns the details of the attachment with all its properties and a link to the disk.
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

