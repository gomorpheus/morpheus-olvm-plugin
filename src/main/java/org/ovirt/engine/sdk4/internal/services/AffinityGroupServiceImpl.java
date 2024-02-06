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
import org.ovirt.engine.sdk4.builders.AffinityGroupBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlAffinityGroupReader;
import org.ovirt.engine.sdk4.internal.xml.XmlAffinityGroupWriter;
import org.ovirt.engine.sdk4.services.AffinityGroupHostLabelsService;
import org.ovirt.engine.sdk4.services.AffinityGroupHostsService;
import org.ovirt.engine.sdk4.services.AffinityGroupService;
import org.ovirt.engine.sdk4.services.AffinityGroupVmLabelsService;
import org.ovirt.engine.sdk4.services.AffinityGroupVmsService;
import org.ovirt.engine.sdk4.types.AffinityGroup;

public class AffinityGroupServiceImpl extends ServiceImpl implements AffinityGroupService {
    
    public AffinityGroupServiceImpl(HttpConnection connection, String path) {
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
                    actionResponse.group(XmlAffinityGroupReader.readOne(reader));
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
        private AffinityGroup group;
        
        public void group(AffinityGroup group) {
            this.group = group;
        }
        
        public AffinityGroup group() {
            return group;
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
        
        private AffinityGroup group;
        public UpdateRequest group(AffinityGroup group) {
            this.group = group;
            return this;
        }
        
        public UpdateRequest group(AffinityGroupBuilder group) {
            this.group = group.build();
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
                XmlAffinityGroupWriter.writeOne(group, xmlWriter);
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
                    actionResponse.group(XmlAffinityGroupReader.readOne(reader));
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
        private AffinityGroup group;
        
        public void group(AffinityGroup group) {
            this.group = group;
        }
        
        public AffinityGroup group() {
            return group;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    public AffinityGroupHostLabelsService hostLabelsService() {
        return new AffinityGroupHostLabelsServiceImpl(getConnection(), getPath() + "/hostlabels");
    }
    
    public AffinityGroupHostsService hostsService() {
        return new AffinityGroupHostsServiceImpl(getConnection(), getPath() + "/hosts");
    }
    
    public AffinityGroupVmLabelsService vmLabelsService() {
        return new AffinityGroupVmLabelsServiceImpl(getConnection(), getPath() + "/vmlabels");
    }
    
    public AffinityGroupVmsService vmsService() {
        return new AffinityGroupVmsServiceImpl(getConnection(), getPath() + "/vms");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("hostlabels")) {
            return hostLabelsService();
        }
        if (path.startsWith("hostlabels/")) {
            return hostLabelsService().service(path.substring(11));
        }
        if (path.equals("hosts")) {
            return hostsService();
        }
        if (path.startsWith("hosts/")) {
            return hostsService().service(path.substring(6));
        }
        if (path.equals("vmlabels")) {
            return vmLabelsService();
        }
        if (path.startsWith("vmlabels/")) {
            return vmLabelsService().service(path.substring(9));
        }
        if (path.equals("vms")) {
            return vmsService();
        }
        if (path.startsWith("vms/")) {
            return vmsService().service(path.substring(4));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "AffinityGroupService:" + getPath();
    }
    
}

