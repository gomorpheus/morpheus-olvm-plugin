/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Certificate;

/**
 * A service to view specific certificate for external provider.
 */
public interface ExternalProviderCertificateService extends Service {
    /**
     * Get specific certificate.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/externalhostproviders/123/certificate/0
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <certificate id="0">
     *   <organization>provider.example.com</organization>
     *   <subject>CN=provider.example.com</subject>
     *   <content>...</content>
     * </certificate>
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
     * Get specific certificate.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/externalhostproviders/123/certificate/0
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <certificate id="0">
     *   <organization>provider.example.com</organization>
     *   <subject>CN=provider.example.com</subject>
     *   <content>...</content>
     * </certificate>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The details of the certificate.
         */
        Certificate certificate();
    }
    
    /**
     * Get specific certificate.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/externalhostproviders/123/certificate/0
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <certificate id="0">
     *   <organization>provider.example.com</organization>
     *   <subject>CN=provider.example.com</subject>
     *   <content>...</content>
     * </certificate>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

