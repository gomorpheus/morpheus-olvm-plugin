/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
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
import org.ovirt.engine.sdk4.builders.DiskBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlSnapshotReader;
import org.ovirt.engine.sdk4.services.SnapshotCdromsService;
import org.ovirt.engine.sdk4.services.SnapshotDisksService;
import org.ovirt.engine.sdk4.services.SnapshotNicsService;
import org.ovirt.engine.sdk4.services.SnapshotService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Snapshot;

public class SnapshotServiceImpl extends ServiceImpl implements SnapshotService {
    
    public SnapshotServiceImpl(HttpConnection connection, String path) {
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
                    actionResponse.snapshot(XmlSnapshotReader.readOne(reader));
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
        private Snapshot snapshot;
        
        public void snapshot(Snapshot snapshot) {
            this.snapshot = snapshot;
        }
        
        public Snapshot snapshot() {
            return snapshot;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class RemoveRequestImpl extends BaseRequest<RemoveRequest, RemoveResponse> implements RemoveRequest {
        private Boolean allContent;
        public RemoveRequest allContent(Boolean allContent) {
            this.allContent = allContent;
            return this;
        }
        
        private Boolean async;
        public RemoveRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public RemoveResponse send() {
            HttpDelete request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (allContent != null) {
                    uriBuilder.addParameter("all_content", XmlWriter.renderBoolean(allContent));
                }
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
    
    private class RestoreRequestImpl extends BaseRequest<RestoreRequest, RestoreResponse> implements RestoreRequest {
        private Boolean async;
        public RestoreRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private List<Disk> disks;
        public RestoreRequest disks(List<Disk> disks) {
            this.disks = disks;
            return this;
        }
        
        public RestoreRequest disks(Disk... disks) {
            this.disks = Arrays.asList(disks);
            return this;
        }
        
        public RestoreRequest disks(DiskBuilder... disks) {
            this.disks = new ArrayList<>(disks.length);
            for (DiskBuilder element : disks) {
                this.disks.add(element.build());
            }
            return this;
        }
        
        private Boolean restoreMemory;
        public RestoreRequest restoreMemory(Boolean restoreMemory) {
            this.restoreMemory = restoreMemory;
            return this;
        }
        
        public RestoreResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/restore");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.disks(disks);
                action.restoreMemory(restoreMemory);
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
            return new RestoreResponseImpl();
        }
        
    }
    
    private class RestoreResponseImpl implements RestoreResponse {
    }
    
    public RestoreRequest restore() {
        return new RestoreRequestImpl();
    }
    
    public SnapshotCdromsService cdromsService() {
        return new SnapshotCdromsServiceImpl(getConnection(), getPath() + "/cdroms");
    }
    
    public SnapshotDisksService disksService() {
        return new SnapshotDisksServiceImpl(getConnection(), getPath() + "/disks");
    }
    
    public SnapshotNicsService nicsService() {
        return new SnapshotNicsServiceImpl(getConnection(), getPath() + "/nics");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("cdroms")) {
            return cdromsService();
        }
        if (path.startsWith("cdroms/")) {
            return cdromsService().service(path.substring(7));
        }
        if (path.equals("disks")) {
            return disksService();
        }
        if (path.startsWith("disks/")) {
            return disksService().service(path.substring(6));
        }
        if (path.equals("nics")) {
            return nicsService();
        }
        if (path.startsWith("nics/")) {
            return nicsService().service(path.substring(5));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "SnapshotService:" + getPath();
    }
    
}

