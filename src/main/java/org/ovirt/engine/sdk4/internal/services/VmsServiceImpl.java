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
import org.ovirt.engine.sdk4.builders.VmBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlVmReader;
import org.ovirt.engine.sdk4.internal.xml.XmlVmWriter;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.AutoPinningPolicy;
import org.ovirt.engine.sdk4.types.Vm;

public class VmsServiceImpl extends ServiceImpl implements VmsService {
    
    public VmsServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class AddRequestImpl extends BaseRequest<AddRequest, AddResponse> implements AddRequest {
        private AutoPinningPolicy autoPinningPolicy;
        public AddRequest autoPinningPolicy(AutoPinningPolicy autoPinningPolicy) {
            this.autoPinningPolicy = autoPinningPolicy;
            return this;
        }
        
        private Boolean clone_;
        public AddRequest clone_(Boolean clone_) {
            this.clone_ = clone_;
            return this;
        }
        
        private Boolean clonePermissions;
        public AddRequest clonePermissions(Boolean clonePermissions) {
            this.clonePermissions = clonePermissions;
            return this;
        }
        
        private Boolean filter;
        public AddRequest filter(Boolean filter) {
            this.filter = filter;
            return this;
        }
        
        private Vm vm;
        public AddRequest vm(Vm vm) {
            this.vm = vm;
            return this;
        }
        
        public AddRequest vm(VmBuilder vm) {
            this.vm = vm.build();
            return this;
        }
        
        public AddResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (autoPinningPolicy != null) {
                    uriBuilder.addParameter("auto_pinning_policy", XmlWriter.renderOther(autoPinningPolicy));
                }
                if (clone_ != null) {
                    uriBuilder.addParameter("clone", XmlWriter.renderBoolean(clone_));
                }
                if (clonePermissions != null) {
                    uriBuilder.addParameter("clone_permissions", XmlWriter.renderBoolean(clonePermissions));
                }
                if (filter != null) {
                    uriBuilder.addParameter("filter", XmlWriter.renderBoolean(filter));
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
                XmlVmWriter.writeOne(vm, xmlWriter);
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
                    actionResponse.vm(XmlVmReader.readOne(reader));
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
        private Vm vm;
        
        public void vm(Vm vm) {
            this.vm = vm;
        }
        
        public Vm vm() {
            return vm;
        }
        
    }
    
    public AddRequest add() {
        return new AddRequestImpl();
    }
    
    private class AddFromConfigurationRequestImpl extends BaseRequest<AddFromConfigurationRequest, AddFromConfigurationResponse> implements AddFromConfigurationRequest {
        private AutoPinningPolicy autoPinningPolicy;
        public AddFromConfigurationRequest autoPinningPolicy(AutoPinningPolicy autoPinningPolicy) {
            this.autoPinningPolicy = autoPinningPolicy;
            return this;
        }
        
        private Boolean clone_;
        public AddFromConfigurationRequest clone_(Boolean clone_) {
            this.clone_ = clone_;
            return this;
        }
        
        private Boolean clonePermissions;
        public AddFromConfigurationRequest clonePermissions(Boolean clonePermissions) {
            this.clonePermissions = clonePermissions;
            return this;
        }
        
        private Boolean filter;
        public AddFromConfigurationRequest filter(Boolean filter) {
            this.filter = filter;
            return this;
        }
        
        private Vm vm;
        public AddFromConfigurationRequest vm(Vm vm) {
            this.vm = vm;
            return this;
        }
        
        public AddFromConfigurationRequest vm(VmBuilder vm) {
            this.vm = vm.build();
            return this;
        }
        
        public AddFromConfigurationResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (autoPinningPolicy != null) {
                    uriBuilder.addParameter("auto_pinning_policy", XmlWriter.renderOther(autoPinningPolicy));
                }
                if (clone_ != null) {
                    uriBuilder.addParameter("clone", XmlWriter.renderBoolean(clone_));
                }
                if (clonePermissions != null) {
                    uriBuilder.addParameter("clone_permissions", XmlWriter.renderBoolean(clonePermissions));
                }
                if (filter != null) {
                    uriBuilder.addParameter("filter", XmlWriter.renderBoolean(filter));
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
                XmlVmWriter.writeOne(vm, xmlWriter);
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
                    actionResponse.vm(XmlVmReader.readOne(reader));
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
        private Vm vm;
        
        public void vm(Vm vm) {
            this.vm = vm;
        }
        
        public Vm vm() {
            return vm;
        }
        
    }
    
    public AddFromConfigurationRequest addFromConfiguration() {
        return new AddFromConfigurationRequestImpl();
    }
    
    private class AddFromScratchRequestImpl extends BaseRequest<AddFromScratchRequest, AddFromScratchResponse> implements AddFromScratchRequest {
        private AutoPinningPolicy autoPinningPolicy;
        public AddFromScratchRequest autoPinningPolicy(AutoPinningPolicy autoPinningPolicy) {
            this.autoPinningPolicy = autoPinningPolicy;
            return this;
        }
        
        private Boolean clone_;
        public AddFromScratchRequest clone_(Boolean clone_) {
            this.clone_ = clone_;
            return this;
        }
        
        private Boolean clonePermissions;
        public AddFromScratchRequest clonePermissions(Boolean clonePermissions) {
            this.clonePermissions = clonePermissions;
            return this;
        }
        
        private Boolean filter;
        public AddFromScratchRequest filter(Boolean filter) {
            this.filter = filter;
            return this;
        }
        
        private Vm vm;
        public AddFromScratchRequest vm(Vm vm) {
            this.vm = vm;
            return this;
        }
        
        public AddFromScratchRequest vm(VmBuilder vm) {
            this.vm = vm.build();
            return this;
        }
        
        public AddFromScratchResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (autoPinningPolicy != null) {
                    uriBuilder.addParameter("auto_pinning_policy", XmlWriter.renderOther(autoPinningPolicy));
                }
                if (clone_ != null) {
                    uriBuilder.addParameter("clone", XmlWriter.renderBoolean(clone_));
                }
                if (clonePermissions != null) {
                    uriBuilder.addParameter("clone_permissions", XmlWriter.renderBoolean(clonePermissions));
                }
                if (filter != null) {
                    uriBuilder.addParameter("filter", XmlWriter.renderBoolean(filter));
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
                XmlVmWriter.writeOne(vm, xmlWriter);
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
                    AddFromScratchResponseImpl actionResponse = new AddFromScratchResponseImpl();
                    actionResponse.vm(XmlVmReader.readOne(reader));
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
                return new AddFromScratchResponseImpl();
            }
        }
        
    }
    
    private class AddFromScratchResponseImpl implements AddFromScratchResponse {
        private Vm vm;
        
        public void vm(Vm vm) {
            this.vm = vm;
        }
        
        public Vm vm() {
            return vm;
        }
        
    }
    
    public AddFromScratchRequest addFromScratch() {
        return new AddFromScratchRequestImpl();
    }
    
    private class AddFromSnapshotRequestImpl extends BaseRequest<AddFromSnapshotRequest, AddFromSnapshotResponse> implements AddFromSnapshotRequest {
        private AutoPinningPolicy autoPinningPolicy;
        public AddFromSnapshotRequest autoPinningPolicy(AutoPinningPolicy autoPinningPolicy) {
            this.autoPinningPolicy = autoPinningPolicy;
            return this;
        }
        
        private Boolean clone_;
        public AddFromSnapshotRequest clone_(Boolean clone_) {
            this.clone_ = clone_;
            return this;
        }
        
        private Boolean clonePermissions;
        public AddFromSnapshotRequest clonePermissions(Boolean clonePermissions) {
            this.clonePermissions = clonePermissions;
            return this;
        }
        
        private Boolean filter;
        public AddFromSnapshotRequest filter(Boolean filter) {
            this.filter = filter;
            return this;
        }
        
        private Vm vm;
        public AddFromSnapshotRequest vm(Vm vm) {
            this.vm = vm;
            return this;
        }
        
        public AddFromSnapshotRequest vm(VmBuilder vm) {
            this.vm = vm.build();
            return this;
        }
        
        public AddFromSnapshotResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (autoPinningPolicy != null) {
                    uriBuilder.addParameter("auto_pinning_policy", XmlWriter.renderOther(autoPinningPolicy));
                }
                if (clone_ != null) {
                    uriBuilder.addParameter("clone", XmlWriter.renderBoolean(clone_));
                }
                if (clonePermissions != null) {
                    uriBuilder.addParameter("clone_permissions", XmlWriter.renderBoolean(clonePermissions));
                }
                if (filter != null) {
                    uriBuilder.addParameter("filter", XmlWriter.renderBoolean(filter));
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
                XmlVmWriter.writeOne(vm, xmlWriter);
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
                    AddFromSnapshotResponseImpl actionResponse = new AddFromSnapshotResponseImpl();
                    actionResponse.vm(XmlVmReader.readOne(reader));
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
                return new AddFromSnapshotResponseImpl();
            }
        }
        
    }
    
    private class AddFromSnapshotResponseImpl implements AddFromSnapshotResponse {
        private Vm vm;
        
        public void vm(Vm vm) {
            this.vm = vm;
        }
        
        public Vm vm() {
            return vm;
        }
        
    }
    
    public AddFromSnapshotRequest addFromSnapshot() {
        return new AddFromSnapshotRequestImpl();
    }
    
    private class ListRequestImpl extends BaseRequest<ListRequest, ListResponse> implements ListRequest {
        private Boolean allContent;
        public ListRequest allContent(Boolean allContent) {
            this.allContent = allContent;
            return this;
        }
        
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
        
        private Boolean ovfAsOva;
        public ListRequest ovfAsOva(Boolean ovfAsOva) {
            this.ovfAsOva = ovfAsOva;
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
                if (allContent != null) {
                    uriBuilder.addParameter("all_content", XmlWriter.renderBoolean(allContent));
                }
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
                if (ovfAsOva != null) {
                    uriBuilder.addParameter("ovf_as_ova", XmlWriter.renderBoolean(ovfAsOva));
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
                    actionResponse.vms(XmlVmReader.readMany(reader));
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
        private List<Vm> vms;
        
        public void vms(List<Vm> vms) {
            this.vms = vms;
        }
        
        public List<Vm> vms() {
            return vms;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    public VmService vmService(String id) {
        return new VmServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return vmService(path);
        }
        return vmService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "VmsService:" + getPath();
    }
    
}

