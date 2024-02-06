/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.Boolean;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.LogicalUnitBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlStorageDomainReader;
import org.ovirt.engine.sdk4.internal.xml.XmlStorageDomainWriter;
import org.ovirt.engine.sdk4.services.AssignedDiskProfilesService;
import org.ovirt.engine.sdk4.services.AssignedPermissionsService;
import org.ovirt.engine.sdk4.services.DiskSnapshotsService;
import org.ovirt.engine.sdk4.services.FilesService;
import org.ovirt.engine.sdk4.services.ImagesService;
import org.ovirt.engine.sdk4.services.StorageDomainDisksService;
import org.ovirt.engine.sdk4.services.StorageDomainServerConnectionsService;
import org.ovirt.engine.sdk4.services.StorageDomainService;
import org.ovirt.engine.sdk4.services.StorageDomainTemplatesService;
import org.ovirt.engine.sdk4.services.StorageDomainVmsService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.LogicalUnit;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class StorageDomainServiceImpl extends ServiceImpl implements StorageDomainService {
    
    public StorageDomainServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class GetRequestImpl extends BaseRequest<GetRequest, GetResponse> implements GetRequest {
        private Boolean filter;
        public GetRequest filter(Boolean filter) {
            this.filter = filter;
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
                if (filter != null) {
                    uriBuilder.addParameter("filter", XmlWriter.renderBoolean(filter));
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
                    actionResponse.storageDomain(XmlStorageDomainReader.readOne(reader));
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
        private StorageDomain storageDomain;
        
        public void storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
        }
        
        public StorageDomain storageDomain() {
            return storageDomain;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class IsAttachedRequestImpl extends BaseRequest<IsAttachedRequest, IsAttachedResponse> implements IsAttachedRequest {
        private Boolean async;
        public IsAttachedRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Host host;
        public IsAttachedRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public IsAttachedRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        public IsAttachedResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/isattached");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
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
            IsAttachedResponseImpl actionResponse = new IsAttachedResponseImpl();
            actionResponse.isAttached(action.isAttached());
            return actionResponse;
        }
        
    }
    
    private class IsAttachedResponseImpl implements IsAttachedResponse {
        private Boolean isAttached;
        
        public void isAttached(Boolean isAttached) {
            this.isAttached = isAttached;
        }
        
        public Boolean isAttached() {
            return isAttached;
        }
        
    }
    
    public IsAttachedRequest isAttached() {
        return new IsAttachedRequestImpl();
    }
    
    private class ReduceLunsRequestImpl extends BaseRequest<ReduceLunsRequest, ReduceLunsResponse> implements ReduceLunsRequest {
        private List<LogicalUnit> logicalUnits;
        public ReduceLunsRequest logicalUnits(List<LogicalUnit> logicalUnits) {
            this.logicalUnits = logicalUnits;
            return this;
        }
        
        public ReduceLunsRequest logicalUnits(LogicalUnit... logicalUnits) {
            this.logicalUnits = Arrays.asList(logicalUnits);
            return this;
        }
        
        public ReduceLunsRequest logicalUnits(LogicalUnitBuilder... logicalUnits) {
            this.logicalUnits = new ArrayList<>(logicalUnits.length);
            for (LogicalUnitBuilder element : logicalUnits) {
                this.logicalUnits.add(element.build());
            }
            return this;
        }
        
        public ReduceLunsResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/reduceluns");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.logicalUnits(logicalUnits);
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
            return new ReduceLunsResponseImpl();
        }
        
    }
    
    private class ReduceLunsResponseImpl implements ReduceLunsResponse {
    }
    
    public ReduceLunsRequest reduceLuns() {
        return new ReduceLunsRequestImpl();
    }
    
    private class RefreshLunsRequestImpl extends BaseRequest<RefreshLunsRequest, RefreshLunsResponse> implements RefreshLunsRequest {
        private Boolean async;
        public RefreshLunsRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private List<LogicalUnit> logicalUnits;
        public RefreshLunsRequest logicalUnits(List<LogicalUnit> logicalUnits) {
            this.logicalUnits = logicalUnits;
            return this;
        }
        
        public RefreshLunsRequest logicalUnits(LogicalUnit... logicalUnits) {
            this.logicalUnits = Arrays.asList(logicalUnits);
            return this;
        }
        
        public RefreshLunsRequest logicalUnits(LogicalUnitBuilder... logicalUnits) {
            this.logicalUnits = new ArrayList<>(logicalUnits.length);
            for (LogicalUnitBuilder element : logicalUnits) {
                this.logicalUnits.add(element.build());
            }
            return this;
        }
        
        public RefreshLunsResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/refreshluns");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.logicalUnits(logicalUnits);
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
            return new RefreshLunsResponseImpl();
        }
        
    }
    
    private class RefreshLunsResponseImpl implements RefreshLunsResponse {
    }
    
    public RefreshLunsRequest refreshLuns() {
        return new RefreshLunsRequestImpl();
    }
    
    private class RemoveRequestImpl extends BaseRequest<RemoveRequest, RemoveResponse> implements RemoveRequest {
        private Boolean async;
        public RemoveRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean destroy;
        public RemoveRequest destroy(Boolean destroy) {
            this.destroy = destroy;
            return this;
        }
        
        private Boolean format;
        public RemoveRequest format(Boolean format) {
            this.format = format;
            return this;
        }
        
        private String host;
        public RemoveRequest host(String host) {
            this.host = host;
            return this;
        }
        
        public RemoveResponse send() {
            HttpDelete request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (destroy != null) {
                    uriBuilder.addParameter("destroy", XmlWriter.renderBoolean(destroy));
                }
                if (format != null) {
                    uriBuilder.addParameter("format", XmlWriter.renderBoolean(format));
                }
                if (host != null) {
                    uriBuilder.addParameter("host", XmlWriter.renderString(host));
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
        
        private StorageDomain storageDomain;
        public UpdateRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public UpdateRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
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
                XmlStorageDomainWriter.writeOne(storageDomain, xmlWriter);
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
                    actionResponse.storageDomain(XmlStorageDomainReader.readOne(reader));
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
        private StorageDomain storageDomain;
        
        public void storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
        }
        
        public StorageDomain storageDomain() {
            return storageDomain;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    private class UpdateOvfStoreRequestImpl extends BaseRequest<UpdateOvfStoreRequest, UpdateOvfStoreResponse> implements UpdateOvfStoreRequest {
        private Boolean async;
        public UpdateOvfStoreRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public UpdateOvfStoreResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/updateovfstore");
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
            return new UpdateOvfStoreResponseImpl();
        }
        
    }
    
    private class UpdateOvfStoreResponseImpl implements UpdateOvfStoreResponse {
    }
    
    public UpdateOvfStoreRequest updateOvfStore() {
        return new UpdateOvfStoreRequestImpl();
    }
    
    public AssignedDiskProfilesService diskProfilesService() {
        return new AssignedDiskProfilesServiceImpl(getConnection(), getPath() + "/diskprofiles");
    }
    
    public DiskSnapshotsService diskSnapshotsService() {
        return new DiskSnapshotsServiceImpl(getConnection(), getPath() + "/disksnapshots");
    }
    
    public StorageDomainDisksService disksService() {
        return new StorageDomainDisksServiceImpl(getConnection(), getPath() + "/disks");
    }
    
    public FilesService filesService() {
        return new FilesServiceImpl(getConnection(), getPath() + "/files");
    }
    
    public ImagesService imagesService() {
        return new ImagesServiceImpl(getConnection(), getPath() + "/images");
    }
    
    public AssignedPermissionsService permissionsService() {
        return new AssignedPermissionsServiceImpl(getConnection(), getPath() + "/permissions");
    }
    
    public StorageDomainServerConnectionsService storageConnectionsService() {
        return new StorageDomainServerConnectionsServiceImpl(getConnection(), getPath() + "/storageconnections");
    }
    
    public StorageDomainTemplatesService templatesService() {
        return new StorageDomainTemplatesServiceImpl(getConnection(), getPath() + "/templates");
    }
    
    public StorageDomainVmsService vmsService() {
        return new StorageDomainVmsServiceImpl(getConnection(), getPath() + "/vms");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("diskprofiles")) {
            return diskProfilesService();
        }
        if (path.startsWith("diskprofiles/")) {
            return diskProfilesService().service(path.substring(13));
        }
        if (path.equals("disksnapshots")) {
            return diskSnapshotsService();
        }
        if (path.startsWith("disksnapshots/")) {
            return diskSnapshotsService().service(path.substring(14));
        }
        if (path.equals("disks")) {
            return disksService();
        }
        if (path.startsWith("disks/")) {
            return disksService().service(path.substring(6));
        }
        if (path.equals("files")) {
            return filesService();
        }
        if (path.startsWith("files/")) {
            return filesService().service(path.substring(6));
        }
        if (path.equals("images")) {
            return imagesService();
        }
        if (path.startsWith("images/")) {
            return imagesService().service(path.substring(7));
        }
        if (path.equals("permissions")) {
            return permissionsService();
        }
        if (path.startsWith("permissions/")) {
            return permissionsService().service(path.substring(12));
        }
        if (path.equals("storageconnections")) {
            return storageConnectionsService();
        }
        if (path.startsWith("storageconnections/")) {
            return storageConnectionsService().service(path.substring(19));
        }
        if (path.equals("templates")) {
            return templatesService();
        }
        if (path.startsWith("templates/")) {
            return templatesService().service(path.substring(10));
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
        return "StorageDomainService:" + getPath();
    }
    
}

