/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.BaseRequest;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ExternalTemplateImportBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlExternalTemplateImportReader;
import org.ovirt.engine.sdk4.internal.xml.XmlExternalTemplateImportWriter;
import org.ovirt.engine.sdk4.services.ExternalTemplateImportsService;
import org.ovirt.engine.sdk4.types.ExternalTemplateImport;

public class ExternalTemplateImportsServiceImpl extends ServiceImpl implements ExternalTemplateImportsService {
    
    public ExternalTemplateImportsServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class AddRequestImpl extends BaseRequest<AddRequest, AddResponse> implements AddRequest {
        private ExternalTemplateImport import_;
        public AddRequest import_(ExternalTemplateImport import_) {
            this.import_ = import_;
            return this;
        }
        
        public AddRequest import_(ExternalTemplateImportBuilder import_) {
            this.import_ = import_.build();
            return this;
        }
        
        public AddResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPost(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlExternalTemplateImportWriter.writeOne(import_, xmlWriter);
                xmlWriter.flush();
                request.setEntity(new ByteArrayEntity(output.toByteArray()));
            }
            catch (IOException ex) {
                throw new Error("Failed to parse response", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            if (
              response.getStatusLine().getStatusCode() == 200
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddResponseImpl actionResponse = new AddResponseImpl();
                    actionResponse.import_(XmlExternalTemplateImportReader.readOne(reader));
                    return actionResponse;
                }
                catch (IOException ex) {
                    throw new Error("Failed to read response", ex);
                }
                finally {
                    EntityUtils.consumeQuietly(response.getEntity());
                }
            }
            else {
                checkFault(response);
                return new AddResponseImpl();
            }
        }
        
    }
    
    private class AddResponseImpl implements AddResponse {
        private ExternalTemplateImport import_;
        
        public void import_(ExternalTemplateImport import_) {
            this.import_ = import_;
        }
        
        public ExternalTemplateImport import_() {
            return import_;
        }
        
    }
    
    public AddRequest add() {
        return new AddRequestImpl();
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "ExternalTemplateImportsService:" + getPath();
    }
    
}

