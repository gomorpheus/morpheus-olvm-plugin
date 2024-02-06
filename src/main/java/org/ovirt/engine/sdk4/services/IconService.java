/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Icon;

/**
 * A service to manage an icon (read-only).
 */
public interface IconService extends Service {
    /**
     * Get an icon.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/icons/123
     * ----
     * 
     * You will get a XML response like this one:
     * 
     * [source,xml]
     * ----
     * <icon id="123">
     *   <data>Some binary data here</data>
     *   <media_type>image/png</media_type>
     * </icon>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Get an icon.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/icons/123
     * ----
     * 
     * You will get a XML response like this one:
     * 
     * [source,xml]
     * ----
     * <icon id="123">
     *   <data>Some binary data here</data>
     *   <media_type>image/png</media_type>
     * </icon>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Retrieved icon.
         */
        Icon icon();
    }
    
    /**
     * Get an icon.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/icons/123
     * ----
     * 
     * You will get a XML response like this one:
     * 
     * [source,xml]
     * ----
     * <icon id="123">
     *   <data>Some binary data here</data>
     *   <media_type>image/png</media_type>
     * </icon>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

