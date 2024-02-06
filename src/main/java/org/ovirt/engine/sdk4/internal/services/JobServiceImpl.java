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
import org.ovirt.engine.sdk4.builders.ActionBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlJobReader;
import org.ovirt.engine.sdk4.services.JobService;
import org.ovirt.engine.sdk4.services.StepsService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Job;

public class JobServiceImpl extends ServiceImpl implements JobService {
    
    public JobServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class ClearRequestImpl extends BaseRequest<ClearRequest, ClearResponse> implements ClearRequest {
        private Boolean async;
        public ClearRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ClearResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/clear");
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
            return new ClearResponseImpl();
        }
        
    }
    
    private class ClearResponseImpl implements ClearResponse {
    }
    
    public ClearRequest clear() {
        return new ClearRequestImpl();
    }
    
    private class EndRequestImpl extends BaseRequest<EndRequest, EndResponse> implements EndRequest {
        private Boolean async;
        public EndRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean force;
        public EndRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        private Boolean succeeded;
        public EndRequest succeeded(Boolean succeeded) {
            this.succeeded = succeeded;
            return this;
        }
        
        public EndResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/end");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.force(force);
                action.succeeded(succeeded);
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
            return new EndResponseImpl();
        }
        
    }
    
    private class EndResponseImpl implements EndResponse {
    }
    
    public EndRequest end() {
        return new EndRequestImpl();
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
                    actionResponse.job(XmlJobReader.readOne(reader));
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
        private Job job;
        
        public void job(Job job) {
            this.job = job;
        }
        
        public Job job() {
            return job;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    public StepsService stepsService() {
        return new StepsServiceImpl(getConnection(), getPath() + "/steps");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("steps")) {
            return stepsService();
        }
        if (path.startsWith("steps/")) {
            return stepsService().service(path.substring(6));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "JobService:" + getPath();
    }
    
}

