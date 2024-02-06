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
import org.ovirt.engine.sdk4.types.DiskAttachment;

/**
 * This service manages the set of disks attached to a template. Each attached disk is represented by a
 * <<types/disk_attachment,DiskAttachment>>.
 */
public interface TemplateDiskAttachmentsService extends Service {
    /**
     * List the disks that are attached to the template.
     * 
     * The order of the returned list of attachments isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * List the disks that are attached to the template.
     * 
     * The order of the returned list of attachments isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<DiskAttachment> attachments();
    }
    
    /**
     * List the disks that are attached to the template.
     * 
     * The order of the returned list of attachments isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific attachment.
     */
    TemplateDiskAttachmentService attachmentService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

