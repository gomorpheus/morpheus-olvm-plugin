/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.BaseRequest;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ActionBuilder;
import org.ovirt.engine.sdk4.builders.CertificateBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.services.ExternalProviderCertificatesService;
import org.ovirt.engine.sdk4.services.ExternalProviderService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Certificate;

public class ExternalProviderServiceImpl extends ServiceImpl implements ExternalProviderService {
    
    public ExternalProviderServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class ImportCertificatesRequestImpl extends BaseRequest<ImportCertificatesRequest, ImportCertificatesResponse> implements ImportCertificatesRequest {
        private List<Certificate> certificates;
        public ImportCertificatesRequest certificates(List<Certificate> certificates) {
            this.certificates = certificates;
            return this;
        }
        
        public ImportCertificatesRequest certificates(Certificate... certificates) {
            this.certificates = Arrays.asList(certificates);
            return this;
        }
        
        public ImportCertificatesRequest certificates(CertificateBuilder... certificates) {
            this.certificates = new ArrayList<>(certificates.length);
            for (CertificateBuilder element : certificates) {
                this.certificates.add(element.build());
            }
            return this;
        }
        
        public ImportCertificatesResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/importcertificates");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.certificates(certificates);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new ImportCertificatesResponseImpl();
        }
        
    }
    
    private class ImportCertificatesResponseImpl implements ImportCertificatesResponse {
    }
    
    public ImportCertificatesRequest importCertificates() {
        return new ImportCertificatesRequestImpl();
    }
    
    private class TestConnectivityRequestImpl extends BaseRequest<TestConnectivityRequest, TestConnectivityResponse> implements TestConnectivityRequest {
        private Boolean async;
        public TestConnectivityRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public TestConnectivityResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/testconnectivity");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                XmlActionWriter.writeOne(action.build(), xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to write request", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            Action action = checkAction(response);
            EntityUtils.consumeQuietly(response.getEntity());
            return new TestConnectivityResponseImpl();
        }
        
    }
    
    private class TestConnectivityResponseImpl implements TestConnectivityResponse {
    }
    
    public TestConnectivityRequest testConnectivity() {
        return new TestConnectivityRequestImpl();
    }
    
    public ExternalProviderCertificatesService certificatesService() {
        return new ExternalProviderCertificatesServiceImpl(getConnection(), getPath() + "/certificates");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("certificates")) {
            return certificatesService();
        }
        if (path.startsWith("certificates/")) {
            return certificatesService().service(path.substring(13));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "ExternalProviderService:" + getPath();
    }
    
}

