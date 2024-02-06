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
import org.ovirt.engine.sdk4.builders.CertificateBuilder;
import org.ovirt.engine.sdk4.types.Certificate;

/**
 * Provides capability to manage external providers.
 */
public interface ExternalProviderService extends Service {
    /**
     * Import the SSL certificates of the external host provider.
     */
    public interface ImportCertificatesRequest extends Request<ImportCertificatesRequest, ImportCertificatesResponse> {
        ImportCertificatesRequest certificates(List<Certificate> certificates);
        ImportCertificatesRequest certificates(Certificate... certificates);
        ImportCertificatesRequest certificates(CertificateBuilder... certificates);
    }
    
    /**
     * Import the SSL certificates of the external host provider.
     */
    public interface ImportCertificatesResponse extends Response {
    }
    
    /**
     * Import the SSL certificates of the external host provider.
     */
    ImportCertificatesRequest importCertificates();
    
    /**
     * In order to test connectivity for external provider we need
     * to run following request where 123 is an id of a provider.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/externalhostproviders/123/testconnectivity
     * ----
     */
    public interface TestConnectivityRequest extends Request<TestConnectivityRequest, TestConnectivityResponse> {
        /**
         * Indicates if the test should be performed asynchronously.
         */
        TestConnectivityRequest async(Boolean async);
    }
    
    /**
     * In order to test connectivity for external provider we need
     * to run following request where 123 is an id of a provider.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/externalhostproviders/123/testconnectivity
     * ----
     */
    public interface TestConnectivityResponse extends Response {
    }
    
    /**
     * In order to test connectivity for external provider we need
     * to run following request where 123 is an id of a provider.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/externalhostproviders/123/testconnectivity
     * ----
     */
    TestConnectivityRequest testConnectivity();
    
    /**
     * A service to view certificates for this external provider.
     */
    ExternalProviderCertificatesService certificatesService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

