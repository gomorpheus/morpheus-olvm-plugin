/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.BaseRequest;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.NetworkLabelBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlNetworkLabelReader;
import org.ovirt.engine.sdk4.internal.xml.XmlNetworkLabelWriter;
import org.ovirt.engine.sdk4.services.NetworkLabelService;
import org.ovirt.engine.sdk4.services.NetworkLabelsService;
import org.ovirt.engine.sdk4.types.NetworkLabel;

public class NetworkLabelsServiceImpl extends ServiceImpl implements NetworkLabelsService {
    
    public NetworkLabelsServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class AddRequestImpl extends BaseRequest<AddRequest, AddResponse> implements AddRequest {
        private NetworkLabel label;
        public AddRequest label(NetworkLabel label) {
            this.label = label;
            return this;
        }
        
        public AddRequest label(NetworkLabelBuilder label) {
            this.label = label.build();
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
                XmlNetworkLabelWriter.writeOne(label, xmlWriter);
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
                    actionResponse.label(XmlNetworkLabelReader.readOne(reader));
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
        private NetworkLabel label;
        
        public void label(NetworkLabel label) {
            this.label = label;
        }
        
        public NetworkLabel label() {
            return label;
        }
        
    }
    
    public AddRequest add() {
        return new AddRequestImpl();
    }
    
    private class ListRequestImpl extends BaseRequest<ListRequest, ListResponse> implements ListRequest {
        private String follow;
        public ListRequest follow(String follow) {
            this.follow = follow;
            return this;
        }
        
        private BigInteger max;
        public ListRequest max(BigInteger max) {
            this.max = max;
            return this;
        }
        
        public ListRequest max(Integer max) {
            this.max = BigInteger.valueOf(max);
            return this;
        }
        
        public ListRequest max(Long max) {
            this.max = BigInteger.valueOf(max);
            return this;
        }
        
        public ListResponse send() {
            HttpGet request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (follow != null) {
                    uriBuilder.addParameter("follow", XmlWriter.renderString(follow));
                }
                if (max != null) {
                    uriBuilder.addParameter("max", XmlWriter.renderInteger(max));
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
                    actionResponse.labels(XmlNetworkLabelReader.readMany(reader));
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
        private List<NetworkLabel> labels;
        
        public void labels(List<NetworkLabel> labels) {
            this.labels = labels;
        }
        
        public List<NetworkLabel> labels() {
            return labels;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    public NetworkLabelService labelService(String id) {
        return new NetworkLabelServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return labelService(path);
        }
        return labelService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "NetworkLabelsService:" + getPath();
    }
    
}

