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
import org.ovirt.engine.sdk4.types.Certificate;

/**
 * A service to view certificates for external provider.
 */
public interface ExternalProviderCertificatesService extends Service {
    /**
     * Returns the chain of certificates presented by the external provider.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/externalhostproviders/123/certificates
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <certificates>
     *   <certificate id="789">...</certificate>
     *   ...
     * </certificates>
     * ----
     * 
     * The order of the returned certificates is always guaranteed to be the sign order: the first is the
     * certificate of the server itself, the second the certificate of the CA that signs the first, so on.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of certificates to return. If not specified all the certificates are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of certificates to return. If not specified all the certificates are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of certificates to return. If not specified all the certificates are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the chain of certificates presented by the external provider.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/externalhostproviders/123/certificates
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <certificates>
     *   <certificate id="789">...</certificate>
     *   ...
     * </certificates>
     * ----
     * 
     * The order of the returned certificates is always guaranteed to be the sign order: the first is the
     * certificate of the server itself, the second the certificate of the CA that signs the first, so on.
     */
    public interface ListResponse extends Response {
        /**
         * List containing certificate details.
         */
        List<Certificate> certificates();
    }
    
    /**
     * Returns the chain of certificates presented by the external provider.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/externalhostproviders/123/certificates
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <certificates>
     *   <certificate id="789">...</certificate>
     *   ...
     * </certificates>
     * ----
     * 
     * The order of the returned certificates is always guaranteed to be the sign order: the first is the
     * certificate of the server itself, the second the certificate of the CA that signs the first, so on.
     */
    ListRequest list();
    
    /**
     * Reference to service that manages a specific certificate
     * for this external provider.
     */
    ExternalProviderCertificateService certificateService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

