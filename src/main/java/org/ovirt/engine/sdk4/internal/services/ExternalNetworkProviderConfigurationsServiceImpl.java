/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.BaseRequest;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlExternalNetworkProviderConfigurationReader;
import org.ovirt.engine.sdk4.services.ExternalNetworkProviderConfigurationService;
import org.ovirt.engine.sdk4.services.ExternalNetworkProviderConfigurationsService;
import org.ovirt.engine.sdk4.types.ExternalNetworkProviderConfiguration;

public class ExternalNetworkProviderConfigurationsServiceImpl extends ServiceImpl implements ExternalNetworkProviderConfigurationsService {
    
    public ExternalNetworkProviderConfigurationsServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class ListRequestImpl extends BaseRequest<ListRequest, ListResponse> implements ListRequest {
        private String follow;
        public ListRequest follow(String follow) {
            this.follow = follow;
            return this;
        }
        
        public ListResponse send() {
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
                    ListResponseImpl actionResponse = new ListResponseImpl();
                    actionResponse.configurations(XmlExternalNetworkProviderConfigurationReader.readMany(reader));
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
                return new ListResponseImpl();
            }
        }
        
    }
    
    private class ListResponseImpl implements ListResponse {
        private List<ExternalNetworkProviderConfiguration> configurations;
        
        public void configurations(List<ExternalNetworkProviderConfiguration> configurations) {
            this.configurations = configurations;
        }
        
        public List<ExternalNetworkProviderConfiguration> configurations() {
            return configurations;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    public ExternalNetworkProviderConfigurationService configurationService(String id) {
        return new ExternalNetworkProviderConfigurationServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return configurationService(path);
        }
        return configurationService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "ExternalNetworkProviderConfigurationsService:" + getPath();
    }
    
}

