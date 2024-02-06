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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
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
import org.ovirt.engine.sdk4.builders.DiskProfileBuilder;
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.QuotaBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlDiskReader;
import org.ovirt.engine.sdk4.internal.xml.XmlDiskWriter;
import org.ovirt.engine.sdk4.services.AssignedPermissionsService;
import org.ovirt.engine.sdk4.services.DiskService;
import org.ovirt.engine.sdk4.services.DiskSnapshotsService;
import org.ovirt.engine.sdk4.services.StatisticsService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskProfile;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class DiskServiceImpl extends MeasurableServiceImpl implements DiskService {
    
    public DiskServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class CopyRequestImpl extends BaseRequest<CopyRequest, CopyResponse> implements CopyRequest {
        private Boolean async;
        public CopyRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Disk disk;
        public CopyRequest disk(Disk disk) {
            this.disk = disk;
            return this;
        }
        
        public CopyRequest disk(DiskBuilder disk) {
            this.disk = disk.build();
            return this;
        }
        
        private DiskProfile diskProfile;
        public CopyRequest diskProfile(DiskProfile diskProfile) {
            this.diskProfile = diskProfile;
            return this;
        }
        
        public CopyRequest diskProfile(DiskProfileBuilder diskProfile) {
            this.diskProfile = diskProfile.build();
            return this;
        }
        
        private Boolean filter;
        public CopyRequest filter(Boolean filter) {
            this.filter = filter;
            return this;
        }
        
        private Quota quota;
        public CopyRequest quota(Quota quota) {
            this.quota = quota;
            return this;
        }
        
        public CopyRequest quota(QuotaBuilder quota) {
            this.quota = quota.build();
            return this;
        }
        
        private StorageDomain storageDomain;
        public CopyRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public CopyRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        public CopyResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/copy");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.disk(disk);
                action.diskProfile(diskProfile);
                action.filter(filter);
                action.quota(quota);
                action.storageDomain(storageDomain);
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
            return new CopyResponseImpl();
        }
        
    }
    
    private class CopyResponseImpl implements CopyResponse {
    }
    
    public CopyRequest copy() {
        return new CopyRequestImpl();
    }
    
    private class ExportRequestImpl extends BaseRequest<ExportRequest, ExportResponse> implements ExportRequest {
        private Boolean async;
        public ExportRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean filter;
        public ExportRequest filter(Boolean filter) {
            this.filter = filter;
            return this;
        }
        
        private StorageDomain storageDomain;
        public ExportRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public ExportRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        public ExportResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/export");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.filter(filter);
                action.storageDomain(storageDomain);
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
            return new ExportResponseImpl();
        }
        
    }
    
    private class ExportResponseImpl implements ExportResponse {
    }
    
    public ExportRequest export() {
        return new ExportRequestImpl();
    }
    
    private class GetRequestImpl extends BaseRequest<GetRequest, GetResponse> implements GetRequest {
        private Boolean allContent;
        public GetRequest allContent(Boolean allContent) {
            this.allContent = allContent;
            return this;
        }
        
        private String follow;
        public GetRequest follow(String follow) {
            this.follow = follow;
            return this;
        }
        
        public GetResponse send() {
            HttpGet request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (allContent != null) {
                    uriBuilder.addParameter("all_content", XmlWriter.renderBoolean(allContent));
                }
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
                    actionResponse.disk(XmlDiskReader.readOne(reader));
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
        private Disk disk;
        
        public void disk(Disk disk) {
            this.disk = disk;
        }
        
        public Disk disk() {
            return disk;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class MoveRequestImpl extends BaseRequest<MoveRequest, MoveResponse> implements MoveRequest {
        private Boolean async;
        public MoveRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private DiskProfile diskProfile;
        public MoveRequest diskProfile(DiskProfile diskProfile) {
            this.diskProfile = diskProfile;
            return this;
        }
        
        public MoveRequest diskProfile(DiskProfileBuilder diskProfile) {
            this.diskProfile = diskProfile.build();
            return this;
        }
        
        private Boolean filter;
        public MoveRequest filter(Boolean filter) {
            this.filter = filter;
            return this;
        }
        
        private Quota quota;
        public MoveRequest quota(Quota quota) {
            this.quota = quota;
            return this;
        }
        
        public MoveRequest quota(QuotaBuilder quota) {
            this.quota = quota.build();
            return this;
        }
        
        private StorageDomain storageDomain;
        public MoveRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public MoveRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        public MoveResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/move");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.diskProfile(diskProfile);
                action.filter(filter);
                action.quota(quota);
                action.storageDomain(storageDomain);
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
            return new MoveResponseImpl();
        }
        
    }
    
    private class MoveResponseImpl implements MoveResponse {
    }
    
    public MoveRequest move() {
        return new MoveRequestImpl();
    }
    
    private class ReduceRequestImpl extends BaseRequest<ReduceRequest, ReduceResponse> implements ReduceRequest {
        private Boolean async;
        public ReduceRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ReduceResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/reduce");
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
            return new ReduceResponseImpl();
        }
        
    }
    
    private class ReduceResponseImpl implements ReduceResponse {
    }
    
    public ReduceRequest reduce() {
        return new ReduceRequestImpl();
    }
    
    private class RefreshLunRequestImpl extends BaseRequest<RefreshLunRequest, RefreshLunResponse> implements RefreshLunRequest {
        private Host host;
        public RefreshLunRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public RefreshLunRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        public RefreshLunResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/refreshlun");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.host(host);
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
            return new RefreshLunResponseImpl();
        }
        
    }
    
    private class RefreshLunResponseImpl implements RefreshLunResponse {
    }
    
    public RefreshLunRequest refreshLun() {
        return new RefreshLunRequestImpl();
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
    
    private class SparsifyRequestImpl extends BaseRequest<SparsifyRequest, SparsifyResponse> implements SparsifyRequest {
        public SparsifyResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/sparsify");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
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
            return new SparsifyResponseImpl();
        }
        
    }
    
    private class SparsifyResponseImpl implements SparsifyResponse {
    }
    
    public SparsifyRequest sparsify() {
        return new SparsifyRequestImpl();
    }
    
    private class UpdateRequestImpl extends BaseRequest<UpdateRequest, UpdateResponse> implements UpdateRequest {
        private Disk disk;
        public UpdateRequest disk(Disk disk) {
            this.disk = disk;
            return this;
        }
        
        public UpdateRequest disk(DiskBuilder disk) {
            this.disk = disk.build();
            return this;
        }
        
        public UpdateResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
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
                XmlDiskWriter.writeOne(disk, xmlWriter);
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
                    actionResponse.disk(XmlDiskReader.readOne(reader));
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
        private Disk disk;
        
        public void disk(Disk disk) {
            this.disk = disk;
        }
        
        public Disk disk() {
            return disk;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    public DiskSnapshotsService diskSnapshotsService() {
        return new DiskSnapshotsServiceImpl(getConnection(), getPath() + "/disksnapshots");
    }
    
    public AssignedPermissionsService permissionsService() {
        return new AssignedPermissionsServiceImpl(getConnection(), getPath() + "/permissions");
    }
    
    public StatisticsService statisticsService() {
        return new StatisticsServiceImpl(getConnection(), getPath() + "/statistics");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("disksnapshots")) {
            return diskSnapshotsService();
        }
        if (path.startsWith("disksnapshots/")) {
            return diskSnapshotsService().service(path.substring(14));
        }
        if (path.equals("permissions")) {
            return permissionsService();
        }
        if (path.startsWith("permissions/")) {
            return permissionsService().service(path.substring(12));
        }
        if (path.equals("statistics")) {
            return statisticsService();
        }
        if (path.startsWith("statistics/")) {
            return statisticsService().service(path.substring(11));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "DiskService:" + getPath();
    }
    
}

