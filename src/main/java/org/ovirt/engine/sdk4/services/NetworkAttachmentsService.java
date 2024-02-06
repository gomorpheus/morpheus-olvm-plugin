/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.NetworkAttachmentBuilder;
import org.ovirt.engine.sdk4.types.NetworkAttachment;

/**
 * Manages the set of network attachments of a host or host NIC.
 */
public interface NetworkAttachmentsService extends Service {
    /**
     * Add a new network attachment to the network interface.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest attachment(NetworkAttachment attachment);
        AddRequest attachment(NetworkAttachmentBuilder attachment);
    }
    
    /**
     * Add a new network attachment to the network interface.
     */
    public interface AddResponse extends Response {
        NetworkAttachment attachment();
    }
    
    /**
     * Add a new network attachment to the network interface.
     */
    AddRequest add();
    
    /**
     * Returns the list of network attachments of the host or host NIC.
     * 
     * The order of the returned list of network attachments isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of attachments to return. If not specified all the attachments are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of attachments to return. If not specified all the attachments are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of attachments to return. If not specified all the attachments are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of network attachments of the host or host NIC.
     * 
     * The order of the returned list of network attachments isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<NetworkAttachment> attachments();
    }
    
    /**
     * Returns the list of network attachments of the host or host NIC.
     * 
     * The order of the returned list of network attachments isn't guaranteed.
     */
    ListRequest list();
    
    NetworkAttachmentService attachmentService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

