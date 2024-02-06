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
import org.ovirt.engine.sdk4.types.Icon;

/**
 * A service to manage icons.
 */
public interface IconsService extends Service {
    /**
     * Get a list of icons.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/icons
     * ----
     * 
     * You will get a XML response which is similar to this one:
     * 
     * [source,xml]
     * ----
     * <icons>
     *   <icon id="123">
     *     <data>...</data>
     *     <media_type>image/png</media_type>
     *   </icon>
     *   ...
     * </icons>
     * ----
     * 
     * The order of the returned list of icons isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of icons to return. If not specified all the icons are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of icons to return. If not specified all the icons are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of icons to return. If not specified all the icons are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Get a list of icons.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/icons
     * ----
     * 
     * You will get a XML response which is similar to this one:
     * 
     * [source,xml]
     * ----
     * <icons>
     *   <icon id="123">
     *     <data>...</data>
     *     <media_type>image/png</media_type>
     *   </icon>
     *   ...
     * </icons>
     * ----
     * 
     * The order of the returned list of icons isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * Retrieved list of icons.
         */
        List<Icon> icons();
    }
    
    /**
     * Get a list of icons.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/icons
     * ----
     * 
     * You will get a XML response which is similar to this one:
     * 
     * [source,xml]
     * ----
     * <icons>
     *   <icon id="123">
     *     <data>...</data>
     *     <media_type>image/png</media_type>
     *   </icon>
     *   ...
     * </icons>
     * ----
     * 
     * The order of the returned list of icons isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages an specific icon.
     */
    IconService iconService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

