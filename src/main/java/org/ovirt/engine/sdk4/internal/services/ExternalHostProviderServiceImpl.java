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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.BaseRequest;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ExternalHostProviderBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlExternalHostProviderReader;
import org.ovirt.engine.sdk4.internal.xml.XmlExternalHostProviderWriter;
import org.ovirt.engine.sdk4.services.ExternalComputeResourcesService;
import org.ovirt.engine.sdk4.services.ExternalDiscoveredHostsService;
import org.ovirt.engine.sdk4.services.ExternalHostGroupsService;
import org.ovirt.engine.sdk4.services.ExternalHostProviderService;
import org.ovirt.engine.sdk4.services.ExternalHostsService;
import org.ovirt.engine.sdk4.services.ExternalProviderCertificatesService;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class ExternalHostProviderServiceImpl extends ExternalProviderServiceImpl implements ExternalHostProviderService {
    
    public ExternalHostProviderServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class GetRequestImpl extends BaseRequest<GetRequest, GetResponse> implements GetRequest {
        private String follow;
        public GetRequest follow(String follow) {
            this.follow = follow;
            return this;
        }
        
        public GetResponse send() {
            HttpGet request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (follow != null) {
                    uriBuilder.addParameter("follow", XmlWriter.renderString(follow));
                }
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpGet(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            if (
              response.getStatusLine().getStatusCode() == 200
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    GetResponseImpl actionResponse = new GetResponseImpl();
                    actionResponse.provider(XmlExternalHostProviderReader.readOne(reader));
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
                return new GetResponseImpl();
            }
        }
        
    }
    
    private class GetResponseImpl implements GetResponse {
        private ExternalHostProvider provider;
        
        public void provider(ExternalHostProvider provider) {
            this.provider = provider;
        }
        
        public ExternalHostProvider provider() {
            return provider;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class RemoveRequestImpl extends BaseRequest<RemoveRequest, RemoveResponse> implements RemoveRequest {
        private Boolean async;
        public RemoveRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public RemoveResponse send() {
            HttpDelete request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpDelete(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            
            HttpResponse response = getConnection().send(request);
            if (
              response.getStatusLine().getStatusCode() == 200
            ) {
                EntityUtils.consumeQuietly(response.getEntity());
                return new RemoveResponseImpl();
            }
            else {
                checkFault(response);
                return new RemoveResponseImpl();
            }
        }
        
    }
    
    private class RemoveResponseImpl implements RemoveResponse {
    }
    
    public RemoveRequest remove() {
        return new RemoveRequestImpl();
    }
    
    private class UpdateRequestImpl extends BaseRequest<UpdateRequest, UpdateResponse> implements UpdateRequest {
        private Boolean async;
        public UpdateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private ExternalHostProvider provider;
        public UpdateRequest provider(ExternalHostProvider provider) {
            this.provider = provider;
            return this;
        }
        
        public UpdateRequest provider(ExternalHostProviderBuilder provider) {
            this.provider = provider.build();
            return this;
        }
        
        public UpdateResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (query != null) {
                    for (Map.Entry<String, String> queryParam : query.entrySet()) {
                        uriBuilder.addParameter(queryParam.getKey(), queryParam.getValue());
                    }
                }
                request = new HttpPut(uriBuilder.build());
            }
            catch (URISyntaxException ex) {
                throw new Error("Failed to build URL", ex);
            }
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                XmlExternalHostProviderWriter.writeOne(provider, xmlWriter);
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
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    UpdateResponseImpl actionResponse = new UpdateResponseImpl();
                    actionResponse.provider(XmlExternalHostProviderReader.readOne(reader));
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
                return new UpdateResponseImpl();
            }
        }
        
    }
    
    private class UpdateResponseImpl implements UpdateResponse {
        private ExternalHostProvider provider;
        
        public void provider(ExternalHostProvider provider) {
            this.provider = provider;
        }
        
        public ExternalHostProvider provider() {
            return provider;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    public ExternalProviderCertificatesService certificatesService() {
        return new ExternalProviderCertificatesServiceImpl(getConnection(), getPath() + "/certificates");
    }
    
    public ExternalComputeResourcesService computeResourcesService() {
        return new ExternalComputeResourcesServiceImpl(getConnection(), getPath() + "/computeresources");
    }
    
    public ExternalDiscoveredHostsService discoveredHostsService() {
        return new ExternalDiscoveredHostsServiceImpl(getConnection(), getPath() + "/discoveredhosts");
    }
    
    public ExternalHostGroupsService hostGroupsService() {
        return new ExternalHostGroupsServiceImpl(getConnection(), getPath() + "/hostgroups");
    }
    
    public ExternalHostsService hostsService() {
        return new ExternalHostsServiceImpl(getConnection(), getPath() + "/hosts");
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
        if (path.equals("computeresources")) {
            return computeResourcesService();
        }
        if (path.startsWith("computeresources/")) {
            return computeResourcesService().service(path.substring(17));
        }
        if (path.equals("discoveredhosts")) {
            return discoveredHostsService();
        }
        if (path.startsWith("discoveredhosts/")) {
            return discoveredHostsService().service(path.substring(16));
        }
        if (path.equals("hostgroups")) {
            return hostGroupsService();
        }
        if (path.startsWith("hostgroups/")) {
            return hostGroupsService().service(path.substring(11));
        }
        if (path.equals("hosts")) {
            return hostsService();
        }
        if (path.startsWith("hosts/")) {
            return hostsService().service(path.substring(6));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "ExternalHostProviderService:" + getPath();
    }
    
}

