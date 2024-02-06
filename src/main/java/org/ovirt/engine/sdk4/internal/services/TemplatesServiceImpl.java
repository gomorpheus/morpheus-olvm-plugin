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
import org.ovirt.engine.sdk4.builders.TemplateBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlTemplateReader;
import org.ovirt.engine.sdk4.internal.xml.XmlTemplateWriter;
import org.ovirt.engine.sdk4.services.TemplateService;
import org.ovirt.engine.sdk4.services.TemplatesService;
import org.ovirt.engine.sdk4.types.Template;

public class TemplatesServiceImpl extends ServiceImpl implements TemplatesService {
    
    public TemplatesServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class AddRequestImpl extends BaseRequest<AddRequest, AddResponse> implements AddRequest {
        private Boolean clonePermissions;
        public AddRequest clonePermissions(Boolean clonePermissions) {
            this.clonePermissions = clonePermissions;
            return this;
        }
        
        private Boolean seal;
        public AddRequest seal(Boolean seal) {
            this.seal = seal;
            return this;
        }
        
        private Template template;
        public AddRequest template(Template template) {
            this.template = template;
            return this;
        }
        
        public AddRequest template(TemplateBuilder template) {
            this.template = template.build();
            return this;
        }
        
        public AddResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (clonePermissions != null) {
                    uriBuilder.addParameter("clone_permissions", XmlWriter.renderBoolean(clonePermissions));
                }
                if (seal != null) {
                    uriBuilder.addParameter("seal", XmlWriter.renderBoolean(seal));
                }
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddResponseImpl actionResponse = new AddResponseImpl();
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
                return new AddResponseImpl();
            }
        }
        
    }
    
    private class AddResponseImpl implements AddResponse {
        private Template template;
        
        public void template(Template template) {
            this.template = template;
        }
        
        public Template template() {
            return template;
        }
        
    }
    
    public AddRequest add() {
        return new AddRequestImpl();
    }
    
    private class AddFromConfigurationRequestImpl extends BaseRequest<AddFromConfigurationRequest, AddFromConfigurationResponse> implements AddFromConfigurationRequest {
        private Boolean clonePermissions;
        public AddFromConfigurationRequest clonePermissions(Boolean clonePermissions) {
            this.clonePermissions = clonePermissions;
            return this;
        }
        
        private Boolean seal;
        public AddFromConfigurationRequest seal(Boolean seal) {
            this.seal = seal;
            return this;
        }
        
        private Template template;
        public AddFromConfigurationRequest template(Template template) {
            this.template = template;
            return this;
        }
        
        public AddFromConfigurationRequest template(TemplateBuilder template) {
            this.template = template.build();
            return this;
        }
        
        public AddFromConfigurationResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (clonePermissions != null) {
                    uriBuilder.addParameter("clone_permissions", XmlWriter.renderBoolean(clonePermissions));
                }
                if (seal != null) {
                    uriBuilder.addParameter("seal", XmlWriter.renderBoolean(seal));
                }
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddFromConfigurationResponseImpl actionResponse = new AddFromConfigurationResponseImpl();
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
                return new AddFromConfigurationResponseImpl();
            }
        }
        
    }
    
    private class AddFromConfigurationResponseImpl implements AddFromConfigurationResponse {
        private Template template;
        
        public void template(Template template) {
            this.template = template;
        }
        
        public Template template() {
            return template;
        }
        
    }
    
    public AddFromConfigurationRequest addFromConfiguration() {
        return new AddFromConfigurationRequestImpl();
    }
    
    private class AddFromVmRequestImpl extends BaseRequest<AddFromVmRequest, AddFromVmResponse> implements AddFromVmRequest {
        private Boolean clonePermissions;
        public AddFromVmRequest clonePermissions(Boolean clonePermissions) {
            this.clonePermissions = clonePermissions;
            return this;
        }
        
        private Boolean seal;
        public AddFromVmRequest seal(Boolean seal) {
            this.seal = seal;
            return this;
        }
        
        private Template template;
        public AddFromVmRequest template(Template template) {
            this.template = template;
            return this;
        }
        
        public AddFromVmRequest template(TemplateBuilder template) {
            this.template = template.build();
            return this;
        }
        
        public AddFromVmResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (clonePermissions != null) {
                    uriBuilder.addParameter("clone_permissions", XmlWriter.renderBoolean(clonePermissions));
                }
                if (seal != null) {
                    uriBuilder.addParameter("seal", XmlWriter.renderBoolean(seal));
                }
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddFromVmResponseImpl actionResponse = new AddFromVmResponseImpl();
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
                return new AddFromVmResponseImpl();
            }
        }
        
    }
    
    private class AddFromVmResponseImpl implements AddFromVmResponse {
        private Template template;
        
        public void template(Template template) {
            this.template = template;
        }
        
        public Template template() {
            return template;
        }
        
    }
    
    public AddFromVmRequest addFromVm() {
        return new AddFromVmRequestImpl();
    }
    
    private class AddFromVmSnapshotRequestImpl extends BaseRequest<AddFromVmSnapshotRequest, AddFromVmSnapshotResponse> implements AddFromVmSnapshotRequest {
        private Boolean clonePermissions;
        public AddFromVmSnapshotRequest clonePermissions(Boolean clonePermissions) {
            this.clonePermissions = clonePermissions;
            return this;
        }
        
        private Boolean seal;
        public AddFromVmSnapshotRequest seal(Boolean seal) {
            this.seal = seal;
            return this;
        }
        
        private Template template;
        public AddFromVmSnapshotRequest template(Template template) {
            this.template = template;
            return this;
        }
        
        public AddFromVmSnapshotRequest template(TemplateBuilder template) {
            this.template = template.build();
            return this;
        }
        
        public AddFromVmSnapshotResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (clonePermissions != null) {
                    uriBuilder.addParameter("clone_permissions", XmlWriter.renderBoolean(clonePermissions));
                }
                if (seal != null) {
                    uriBuilder.addParameter("seal", XmlWriter.renderBoolean(seal));
                }
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
              || response.getStatusLine().getStatusCode() == 201
              || response.getStatusLine().getStatusCode() == 202
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    AddFromVmSnapshotResponseImpl actionResponse = new AddFromVmSnapshotResponseImpl();
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
                return new AddFromVmSnapshotResponseImpl();
            }
        }
        
    }
    
    private class AddFromVmSnapshotResponseImpl implements AddFromVmSnapshotResponse {
        private Template template;
        
        public void template(Template template) {
            this.template = template;
        }
        
        public Template template() {
            return template;
        }
        
    }
    
    public AddFromVmSnapshotRequest addFromVmSnapshot() {
        return new AddFromVmSnapshotRequestImpl();
    }
    
    private class ListRequestImpl extends BaseRequest<ListRequest, ListResponse> implements ListRequest {
        private Boolean caseSensitive;
        public ListRequest caseSensitive(Boolean caseSensitive) {
            this.caseSensitive = caseSensitive;
            return this;
        }
        
        private Boolean filter;
        public ListRequest filter(Boolean filter) {
            this.filter = filter;
            return this;
        }
        
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
        
        private String search;
        public ListRequest search(String search) {
            this.search = search;
            return this;
        }
        
        public ListResponse send() {
            HttpGet request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (caseSensitive != null) {
                    uriBuilder.addParameter("case_sensitive", XmlWriter.renderBoolean(caseSensitive));
                }
                if (filter != null) {
                    uriBuilder.addParameter("filter", XmlWriter.renderBoolean(filter));
                }
                if (follow != null) {
                    uriBuilder.addParameter("follow", XmlWriter.renderString(follow));
                }
                if (max != null) {
                    uriBuilder.addParameter("max", XmlWriter.renderInteger(max));
                }
                if (search != null) {
                    uriBuilder.addParameter("search", XmlWriter.renderString(search));
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
                    actionResponse.templates(XmlTemplateReader.readMany(reader));
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
        private List<Template> templates;
        
        public void templates(List<Template> templates) {
            this.templates = templates;
        }
        
        public List<Template> templates() {
            return templates;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    public TemplateService templateService(String id) {
        return new TemplateServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return templateService(path);
        }
        return templateService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "TemplatesService:" + getPath();
    }
    
}

