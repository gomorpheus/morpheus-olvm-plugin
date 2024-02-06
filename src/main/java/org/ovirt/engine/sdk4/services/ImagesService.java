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
import org.ovirt.engine.sdk4.types.Image;

/**
 * Manages the set of images available in an storage domain or in an OpenStack image provider.
 */
public interface ImagesService extends Service {
    /**
     * Returns the list of images available in the storage domain or provider.
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
     * Returns the list of images available in the storage domain or provider.
     * 
     * The order of the returned list of images isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Image> images();
    }
    
    /**
     * Returns the list of images available in the storage domain or provider.
     * 
     * The order of the returned list of images isn't guaranteed.
     */
    ListRequest list();
    
    ImageService imageService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

