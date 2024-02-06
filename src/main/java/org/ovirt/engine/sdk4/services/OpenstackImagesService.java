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
import org.ovirt.engine.sdk4.types.OpenStackImage;

public interface OpenstackImagesService extends Service {
    /**
     * Lists the images of a Glance image storage domain.
     * 
     * The order of the returned list of images isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of images to return. If not specified all the images are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of images to return. If not specified all the images are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of images to return. If not specified all the images are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Lists the images of a Glance image storage domain.
     * 
     * The order of the returned list of images isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<OpenStackImage> images();
    }
    
    /**
     * Lists the images of a Glance image storage domain.
     * 
     * The order of the returned list of images isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific image.
     */
    OpenstackImageService imageService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

