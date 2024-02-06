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
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.builders.TemplateBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlTemplateReader;
import org.ovirt.engine.sdk4.internal.xml.XmlTemplateWriter;
import org.ovirt.engine.sdk4.services.AssignedPermissionsService;
import org.ovirt.engine.sdk4.services.AssignedTagsService;
import org.ovirt.engine.sdk4.services.TemplateCdromsService;
import org.ovirt.engine.sdk4.services.TemplateDiskAttachmentsService;
import org.ovirt.engine.sdk4.services.TemplateGraphicsConsolesService;
import org.ovirt.engine.sdk4.services.TemplateNicsService;
import org.ovirt.engine.sdk4.services.TemplateService;
import org.ovirt.engine.sdk4.services.TemplateWatchdogsService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;

public class TemplateServiceImpl extends ServiceImpl implements TemplateService {
    
    public TemplateServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class ExportRequestImpl extends BaseRequest<ExportRequest, ExportResponse> implements ExportRequest {
        private Boolean exclusive;
        public ExportRequest exclusive(Boolean exclusive) {
            this.exclusive = exclusive;
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
                action.exclusive(exclusive);
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
                    actionResponse.template(XmlTemplateReader.readOne(reader));
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
        private Template template;
        
        public void template(Template template) {
            this.template = template;
        }
        
        public Template template() {
            return template;
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
    
    private class ExportToExportDomainRequestImpl extends BaseRequest<ExportToExportDomainRequest, ExportToExportDomainResponse> implements ExportToExportDomainRequest {
        private Boolean exclusive;
        public ExportToExportDomainRequest exclusive(Boolean exclusive) {
            this.exclusive = exclusive;
            return this;
        }
        
        private StorageDomain storageDomain;
        public ExportToExportDomainRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public ExportToExportDomainRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        public ExportToExportDomainResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/export");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.exclusive(exclusive);
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
            return new ExportToExportDomainResponseImpl();
        }
        
    }
    
    private class ExportToExportDomainResponseImpl implements ExportToExportDomainResponse {
    }
    
    public ExportToExportDomainRequest exportToExportDomain() {
        return new ExportToExportDomainRequestImpl();
    }
    
    private class ExportToPathOnHostRequestImpl extends BaseRequest<ExportToPathOnHostRequest, ExportToPathOnHostResponse> implements ExportToPathOnHostRequest {
        private String directory;
        public ExportToPathOnHostRequest directory(String directory) {
            this.directory = directory;
            return this;
        }
        
        private Boolean exclusive;
        public ExportToPathOnHostRequest exclusive(Boolean exclusive) {
            this.exclusive = exclusive;
            return this;
        }
        
        private String filename;
        public ExportToPathOnHostRequest filename(String filename) {
            this.filename = filename;
            return this;
        }
        
        private Host host;
        public ExportToPathOnHostRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public ExportToPathOnHostRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private StorageDomain storageDomain;
        public ExportToPathOnHostRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public ExportToPathOnHostRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        public ExportToPathOnHostResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/export");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.directory(directory);
                action.exclusive(exclusive);
                action.filename(filename);
                action.host(host);
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
            return new ExportToPathOnHostResponseImpl();
        }
        
    }
    
    private class ExportToPathOnHostResponseImpl implements ExportToPathOnHostResponse {
    }
    
    public ExportToPathOnHostRequest exportToPathOnHost() {
        return new ExportToPathOnHostRequestImpl();
    }
    
    private class UpdateRequestImpl extends BaseRequest<UpdateRequest, UpdateResponse> implements UpdateRequest {
        private Boolean async;
        public UpdateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Template template;
        public UpdateRequest template(Template template) {
            this.template = template;
            return this;
        }
        
        public UpdateRequest template(TemplateBuilder template) {
            this.template = template.build();
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
                XmlTemplateWriter.writeOne(template, xmlWriter);
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
                    actionResponse.template(XmlTemplateReader.readOne(reader));
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
        private Template template;
        
        public void template(Template template) {
            this.template = template;
        }
        
        public Template template() {
            return template;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    public TemplateCdromsService cdromsService() {
        return new TemplateCdromsServiceImpl(getConnection(), getPath() + "/cdroms");
    }
    
    public TemplateDiskAttachmentsService diskAttachmentsService() {
        return new TemplateDiskAttachmentsServiceImpl(getConnection(), getPath() + "/diskattachments");
    }
    
    public TemplateGraphicsConsolesService graphicsConsolesService() {
        return new TemplateGraphicsConsolesServiceImpl(getConnection(), getPath() + "/graphicsconsoles");
    }
    
    public TemplateNicsService nicsService() {
        return new TemplateNicsServiceImpl(getConnection(), getPath() + "/nics");
    }
    
    public AssignedPermissionsService permissionsService() {
        return new AssignedPermissionsServiceImpl(getConnection(), getPath() + "/permissions");
    }
    
    public AssignedTagsService tagsService() {
        return new AssignedTagsServiceImpl(getConnection(), getPath() + "/tags");
    }
    
    public TemplateWatchdogsService watchdogsService() {
        return new TemplateWatchdogsServiceImpl(getConnection(), getPath() + "/watchdogs");
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
        if (path.equals("diskattachments")) {
            return diskAttachmentsService();
        }
        if (path.startsWith("diskattachments/")) {
            return diskAttachmentsService().service(path.substring(16));
        }
        if (path.equals("graphicsconsoles")) {
            return graphicsConsolesService();
        }
        if (path.startsWith("graphicsconsoles/")) {
            return graphicsConsolesService().service(path.substring(17));
        }
        if (path.equals("nics")) {
            return nicsService();
        }
        if (path.startsWith("nics/")) {
            return nicsService().service(path.substring(5));
        }
        if (path.equals("permissions")) {
            return permissionsService();
        }
        if (path.startsWith("permissions/")) {
            return permissionsService().service(path.substring(12));
        }
        if (path.equals("tags")) {
            return tagsService();
        }
        if (path.startsWith("tags/")) {
            return tagsService().service(path.substring(5));
        }
        if (path.equals("watchdogs")) {
            return watchdogsService();
        }
        if (path.startsWith("watchdogs/")) {
            return watchdogsService().service(path.substring(10));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "TemplateService:" + getPath();
    }
    
}

