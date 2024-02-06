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
import org.ovirt.engine.sdk4.builders.AgentBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlAgentReader;
import org.ovirt.engine.sdk4.internal.xml.XmlAgentWriter;
import org.ovirt.engine.sdk4.services.FenceAgentService;
import org.ovirt.engine.sdk4.types.Agent;

public class FenceAgentServiceImpl extends ServiceImpl implements FenceAgentService {
    
    public FenceAgentServiceImpl(HttpConnection connection, String path) {
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
                    actionResponse.agent(XmlAgentReader.readOne(reader));
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
        private Agent agent;
        
        public void agent(Agent agent) {
            this.agent = agent;
        }
        
        public Agent agent() {
            return agent;
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
        private Agent agent;
        public UpdateRequest agent(Agent agent) {
            this.agent = agent;
            return this;
        }
        
        public UpdateRequest agent(AgentBuilder agent) {
            this.agent = agent.build();
            return this;
        }
        
        private Boolean async;
        public UpdateRequest async(Boolean async) {
            this.async = async;
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
                XmlAgentWriter.writeOne(agent, xmlWriter);
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
                    actionResponse.agent(XmlAgentReader.readOne(reader));
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
        private Agent agent;
        
        public void agent(Agent agent) {
            this.agent = agent;
        }
        
        public Agent agent() {
            return agent;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "FenceAgentService:" + getPath();
    }
    
}

