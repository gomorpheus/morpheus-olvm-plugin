/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.ovirt.engine.sdk4.builders.DiskAttachmentBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlDiskAttachmentReader;
import org.ovirt.engine.sdk4.internal.xml.XmlDiskAttachmentWriter;
import org.ovirt.engine.sdk4.services.DiskAttachmentService;
import org.ovirt.engine.sdk4.services.DiskAttachmentsService;
import org.ovirt.engine.sdk4.types.DiskAttachment;

public class DiskAttachmentsServiceImpl extends ServiceImpl implements DiskAttachmentsService {
    
    public DiskAttachmentsServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class AddRequestImpl extends BaseRequest<AddRequest, AddResponse> implements AddRequest {
        private DiskAttachment attachment;
        public AddRequest attachment(DiskAttachment attachment) {
            this.attachment = attachment;
            return this;
        }
        
        public AddRequest attachment(DiskAttachmentBuilder attachment) {
            this.attachment = attachment.build();
            return this;
        }
        
        public AddResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
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
                XmlDiskAttachmentWriter.writeOne(attachment, xmlWriter);
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
                    actionResponse.attachment(XmlDiskAttachmentReader.readOne(reader));
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
        private DiskAttachment attachment;
        
        public void attachment(DiskAttachment attachment) {
            this.attachment = attachment;
        }
        
        public DiskAttachment attachment() {
            return attachment;
        }
        
    }
    
    public AddRequest add() {
        return new AddRequestImpl();
    }
    
    private class ListRequestImpl extends BaseRequest<ListRequest, ListResponse> implements ListRequest {
        private String follow;
        public ListRequest follow(String follow) {
            this.follow = follow;
            return this;
        }
        
        public ListResponse send() {
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
                    ListResponseImpl actionResponse = new ListResponseImpl();
                    actionResponse.attachments(XmlDiskAttachmentReader.readMany(reader));
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
        private List<DiskAttachment> attachments;
        
        public void attachments(List<DiskAttachment> attachments) {
            this.attachments = attachments;
        }
        
        public List<DiskAttachment> attachments() {
            return attachments;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    private class AddProvidingDiskIdRequestImpl extends BaseRequest<AddProvidingDiskIdRequest, AddProvidingDiskIdResponse> implements AddProvidingDiskIdRequest {
        private DiskAttachment attachment;
        public AddProvidingDiskIdRequest attachment(DiskAttachment attachment) {
            this.attachment = attachment;
            return this;
        }
        
        public AddProvidingDiskIdRequest attachment(DiskAttachmentBuilder attachment) {
            this.attachment = attachment.build();
            return this;
        }
        
        public AddProvidingDiskIdResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
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
                XmlDiskAttachmentWriter.writeOne(attachment, xmlWriter);
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
                    AddProvidingDiskIdResponseImpl actionResponse = new AddProvidingDiskIdResponseImpl();
                    actionResponse.attachment(XmlDiskAttachmentReader.readOne(reader));
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
                return new AddProvidingDiskIdResponseImpl();
            }
        }
        
    }
    
    private class AddProvidingDiskIdResponseImpl implements AddProvidingDiskIdResponse {
        private DiskAttachment attachment;
        
        public void attachment(DiskAttachment attachment) {
            this.attachment = attachment;
        }
        
        public DiskAttachment attachment() {
            return attachment;
        }
        
    }
    
    public AddProvidingDiskIdRequest addProvidingDiskId() {
        return new AddProvidingDiskIdRequestImpl();
    }
    
    private class AddSignature1RequestImpl extends BaseRequest<AddSignature1Request, AddSignature1Response> implements AddSignature1Request {
        private DiskAttachment attachment;
        public AddSignature1Request attachment(DiskAttachment attachment) {
            this.attachment = attachment;
            return this;
        }
        
        public AddSignature1Request attachment(DiskAttachmentBuilder attachment) {
            this.attachment = attachment.build();
            return this;
        }
        
        public AddSignature1Response send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
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
                XmlDiskAttachmentWriter.writeOne(attachment, xmlWriter);
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
                    AddSignature1ResponseImpl actionResponse = new AddSignature1ResponseImpl();
                    actionResponse.attachment(XmlDiskAttachmentReader.readOne(reader));
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
                return new AddSignature1ResponseImpl();
            }
        }
        
    }
    
    private class AddSignature1ResponseImpl implements AddSignature1Response {
        private DiskAttachment attachment;
        
        public void attachment(DiskAttachment attachment) {
            this.attachment = attachment;
        }
        
        public DiskAttachment attachment() {
            return attachment;
        }
        
    }
    
    public AddSignature1Request addSignature1() {
        return new AddSignature1RequestImpl();
    }
    
    public DiskAttachmentService attachmentService(String id) {
        return new DiskAttachmentServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return attachmentService(path);
        }
        return attachmentService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "DiskAttachmentsService:" + getPath();
    }
    
}

