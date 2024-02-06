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
import org.ovirt.engine.sdk4.types.Cdrom;

/**
 * Lists the CD-ROM devices of a template.
 */
public interface TemplateCdromsService extends Service {
    /**
     * Returns the list of CD-ROM devices of the template.
     * 
     * The order of the returned list of CD-ROM devices isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of CD-ROMs to return. If not specified all the CD-ROMs are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of CD-ROMs to return. If not specified all the CD-ROMs are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of CD-ROMs to return. If not specified all the CD-ROMs are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of CD-ROM devices of the template.
     * 
     * The order of the returned list of CD-ROM devices isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of CD-ROM devices of the template.
         */
        List<Cdrom> cdroms();
    }
    
    /**
     * Returns the list of CD-ROM devices of the template.
     * 
     * The order of the returned list of CD-ROM devices isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific CD-ROM device.
     */
    TemplateCdromService cdromService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

