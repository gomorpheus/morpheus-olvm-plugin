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
 * This service manages the attachment of a disk to a template.
 */
public interface TemplateDiskAttachmentService extends Service {
    /**
     * Returns the details of the attachment.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns the details of the attachment.
     */
    public interface GetResponse extends Response {
        DiskAttachment attachment();
    }
    
    /**
     * Returns the details of the attachment.
     */
    GetRequest get();
    
    /**
     * Removes the disk from the template. The disk will only be removed if there are other existing copies of the
     * disk on other storage domains.
     * 
     * A storage domain has to be specified to determine which of the copies should be removed (template disks can
     * have copies on multiple storage domains).
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/templates/{template:id}/diskattachments/{attachment:id}?storage_domain=072fbaa1-08f3-4a40-9f34-a5ca22dd1d74
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        RemoveRequest force(Boolean force);
        /**
         * Specifies the identifier of the storage domain the image to be removed resides on.
         */
        RemoveRequest storageDomain(String storageDomain);
    }
    
    /**
     * Removes the disk from the template. The disk will only be removed if there are other existing copies of the
     * disk on other storage domains.
     * 
     * A storage domain has to be specified to determine which of the copies should be removed (template disks can
     * have copies on multiple storage domains).
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/templates/{template:id}/diskattachments/{attachment:id}?storage_domain=072fbaa1-08f3-4a40-9f34-a5ca22dd1d74
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the disk from the template. The disk will only be removed if there are other existing copies of the
     * disk on other storage domains.
     * 
     * A storage domain has to be specified to determine which of the copies should be removed (template disks can
     * have copies on multiple storage domains).
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/templates/{template:id}/diskattachments/{attachment:id}?storage_domain=072fbaa1-08f3-4a40-9f34-a5ca22dd1d74
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

