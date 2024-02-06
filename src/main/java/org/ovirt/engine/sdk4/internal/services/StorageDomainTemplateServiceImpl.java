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
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.builders.RegistrationConfigurationBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.builders.TemplateBuilder;
import org.ovirt.engine.sdk4.builders.VmBuilder;
import org.ovirt.engine.sdk4.builders.VnicProfileMappingBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlTemplateReader;
import org.ovirt.engine.sdk4.services.StorageDomainContentDisksService;
import org.ovirt.engine.sdk4.services.StorageDomainTemplateService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.RegistrationConfiguration;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VnicProfileMapping;

public class StorageDomainTemplateServiceImpl extends ServiceImpl implements StorageDomainTemplateService {
    
    public StorageDomainTemplateServiceImpl(HttpConnection connection, String path) {
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
    
    private class ImportRequestImpl extends BaseRequest<ImportRequest, ImportResponse> implements ImportRequest {
        private Boolean async;
        public ImportRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean clone_;
        public ImportRequest clone_(Boolean clone_) {
            this.clone_ = clone_;
            return this;
        }
        
        private Cluster cluster;
        public ImportRequest cluster(Cluster cluster) {
            this.cluster = cluster;
            return this;
        }
        
        public ImportRequest cluster(ClusterBuilder cluster) {
            this.cluster = cluster.build();
            return this;
        }
        
        private Boolean exclusive;
        public ImportRequest exclusive(Boolean exclusive) {
            this.exclusive = exclusive;
            return this;
        }
        
        private StorageDomain storageDomain;
        public ImportRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public ImportRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        private Template template;
        public ImportRequest template(Template template) {
            this.template = template;
            return this;
        }
        
        public ImportRequest template(TemplateBuilder template) {
            this.template = template.build();
            return this;
        }
        
        private Vm vm;
        public ImportRequest vm(Vm vm) {
            this.vm = vm;
            return this;
        }
        
        public ImportRequest vm(VmBuilder vm) {
            this.vm = vm.build();
            return this;
        }
        
        public ImportResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/import");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.clone_(clone_);
                action.cluster(cluster);
                action.exclusive(exclusive);
                action.storageDomain(storageDomain);
                action.template(template);
                action.vm(vm);
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
            return new ImportResponseImpl();
        }
        
    }
    
    private class ImportResponseImpl implements ImportResponse {
    }
    
    public ImportRequest import_() {
        return new ImportRequestImpl();
    }
    
    private class RegisterRequestImpl extends BaseRequest<RegisterRequest, RegisterResponse> implements RegisterRequest {
        private Boolean allowPartialImport;
        public RegisterRequest allowPartialImport(Boolean allowPartialImport) {
            this.allowPartialImport = allowPartialImport;
            return this;
        }
        
        private Boolean async;
        public RegisterRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean clone_;
        public RegisterRequest clone_(Boolean clone_) {
            this.clone_ = clone_;
            return this;
        }
        
        private Cluster cluster;
        public RegisterRequest cluster(Cluster cluster) {
            this.cluster = cluster;
            return this;
        }
        
        public RegisterRequest cluster(ClusterBuilder cluster) {
            this.cluster = cluster.build();
            return this;
        }
        
        private Boolean exclusive;
        public RegisterRequest exclusive(Boolean exclusive) {
            this.exclusive = exclusive;
            return this;
        }
        
        private RegistrationConfiguration registrationConfiguration;
        public RegisterRequest registrationConfiguration(RegistrationConfiguration registrationConfiguration) {
            this.registrationConfiguration = registrationConfiguration;
            return this;
        }
        
        public RegisterRequest registrationConfiguration(RegistrationConfigurationBuilder registrationConfiguration) {
            this.registrationConfiguration = registrationConfiguration.build();
            return this;
        }
        
        private Template template;
        public RegisterRequest template(Template template) {
            this.template = template;
            return this;
        }
        
        public RegisterRequest template(TemplateBuilder template) {
            this.template = template.build();
            return this;
        }
        
        private List<VnicProfileMapping> vnicProfileMappings;
        public RegisterRequest vnicProfileMappings(List<VnicProfileMapping> vnicProfileMappings) {
            this.vnicProfileMappings = vnicProfileMappings;
            return this;
        }
        
        public RegisterRequest vnicProfileMappings(VnicProfileMapping... vnicProfileMappings) {
            this.vnicProfileMappings = Arrays.asList(vnicProfileMappings);
            return this;
        }
        
        public RegisterRequest vnicProfileMappings(VnicProfileMappingBuilder... vnicProfileMappings) {
            this.vnicProfileMappings = new ArrayList<>(vnicProfileMappings.length);
            for (VnicProfileMappingBuilder element : vnicProfileMappings) {
                this.vnicProfileMappings.add(element.build());
            }
            return this;
        }
        
        public RegisterResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/register");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.allowPartialImport(allowPartialImport);
                action.async(async);
                action.clone_(clone_);
                action.cluster(cluster);
                action.exclusive(exclusive);
                action.registrationConfiguration(registrationConfiguration);
                action.template(template);
                action.vnicProfileMappings(vnicProfileMappings);
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
            return new RegisterResponseImpl();
        }
        
    }
    
    private class RegisterResponseImpl implements RegisterResponse {
    }
    
    public RegisterRequest register() {
        return new RegisterRequestImpl();
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
    
    public StorageDomainContentDisksService disksService() {
        return new StorageDomainContentDisksServiceImpl(getConnection(), getPath() + "/disks");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("disks")) {
            return disksService();
        }
        if (path.startsWith("disks/")) {
            return disksService().service(path.substring(6));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "StorageDomainTemplateService:" + getPath();
    }
    
}

