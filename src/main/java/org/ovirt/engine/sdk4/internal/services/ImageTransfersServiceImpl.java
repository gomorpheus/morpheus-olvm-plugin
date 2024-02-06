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
import org.ovirt.engine.sdk4.builders.ImageTransferBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlImageTransferReader;
import org.ovirt.engine.sdk4.internal.xml.XmlImageTransferWriter;
import org.ovirt.engine.sdk4.services.ImageTransferService;
import org.ovirt.engine.sdk4.services.ImageTransfersService;
import org.ovirt.engine.sdk4.types.ImageTransfer;

public class ImageTransfersServiceImpl extends ServiceImpl implements ImageTransfersService {
    
    public ImageTransfersServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class AddRequestImpl extends BaseRequest<AddRequest, AddResponse> implements AddRequest {
        private ImageTransfer imageTransfer;
        public AddRequest imageTransfer(ImageTransfer imageTransfer) {
            this.imageTransfer = imageTransfer;
            return this;
        }
        
        public AddRequest imageTransfer(ImageTransferBuilder imageTransfer) {
            this.imageTransfer = imageTransfer.build();
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
                XmlImageTransferWriter.writeOne(imageTransfer, xmlWriter);
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
                    actionResponse.imageTransfer(XmlImageTransferReader.readOne(reader));
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
        private ImageTransfer imageTransfer;
        
        public void imageTransfer(ImageTransfer imageTransfer) {
            this.imageTransfer = imageTransfer;
        }
        
        public ImageTransfer imageTransfer() {
            return imageTransfer;
        }
        
    }
    
    public AddRequest add() {
        return new AddRequestImpl();
    }
    
    private class AddForDiskRequestImpl extends BaseRequest<AddForDiskRequest, AddForDiskResponse> implements AddForDiskRequest {
        private ImageTransfer imageTransfer;
        public AddForDiskRequest imageTransfer(ImageTransfer imageTransfer) {
            this.imageTransfer = imageTransfer;
            return this;
        }
        
        public AddForDiskRequest imageTransfer(ImageTransferBuilder imageTransfer) {
            this.imageTransfer = imageTransfer.build();
            return this;
        }
        
        public AddForDiskResponse send() {
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
                XmlImageTransferWriter.writeOne(imageTransfer, xmlWriter);
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
                    AddForDiskResponseImpl actionResponse = new AddForDiskResponseImpl();
                    actionResponse.imageTransfer(XmlImageTransferReader.readOne(reader));
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
                return new AddForDiskResponseImpl();
            }
        }
        
    }
    
    private class AddForDiskResponseImpl implements AddForDiskResponse {
        private ImageTransfer imageTransfer;
        
        public void imageTransfer(ImageTransfer imageTransfer) {
            this.imageTransfer = imageTransfer;
        }
        
        public ImageTransfer imageTransfer() {
            return imageTransfer;
        }
        
    }
    
    public AddForDiskRequest addForDisk() {
        return new AddForDiskRequestImpl();
    }
    
    private class AddForImageRequestImpl extends BaseRequest<AddForImageRequest, AddForImageResponse> implements AddForImageRequest {
        private ImageTransfer imageTransfer;
        public AddForImageRequest imageTransfer(ImageTransfer imageTransfer) {
            this.imageTransfer = imageTransfer;
            return this;
        }
        
        public AddForImageRequest imageTransfer(ImageTransferBuilder imageTransfer) {
            this.imageTransfer = imageTransfer.build();
            return this;
        }
        
        public AddForImageResponse send() {
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
                XmlImageTransferWriter.writeOne(imageTransfer, xmlWriter);
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
                    AddForImageResponseImpl actionResponse = new AddForImageResponseImpl();
                    actionResponse.imageTransfer(XmlImageTransferReader.readOne(reader));
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
                return new AddForImageResponseImpl();
            }
        }
        
    }
    
    private class AddForImageResponseImpl implements AddForImageResponse {
        private ImageTransfer imageTransfer;
        
        public void imageTransfer(ImageTransfer imageTransfer) {
            this.imageTransfer = imageTransfer;
        }
        
        public ImageTransfer imageTransfer() {
            return imageTransfer;
        }
        
    }
    
    public AddForImageRequest addForImage() {
        return new AddForImageRequestImpl();
    }
    
    private class AddForSnapshotRequestImpl extends BaseRequest<AddForSnapshotRequest, AddForSnapshotResponse> implements AddForSnapshotRequest {
        private ImageTransfer imageTransfer;
        public AddForSnapshotRequest imageTransfer(ImageTransfer imageTransfer) {
            this.imageTransfer = imageTransfer;
            return this;
        }
        
        public AddForSnapshotRequest imageTransfer(ImageTransferBuilder imageTransfer) {
            this.imageTransfer = imageTransfer.build();
            return this;
        }
        
        public AddForSnapshotResponse send() {
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
                XmlImageTransferWriter.writeOne(imageTransfer, xmlWriter);
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
                    AddForSnapshotResponseImpl actionResponse = new AddForSnapshotResponseImpl();
                    actionResponse.imageTransfer(XmlImageTransferReader.readOne(reader));
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
                return new AddForSnapshotResponseImpl();
            }
        }
        
    }
    
    private class AddForSnapshotResponseImpl implements AddForSnapshotResponse {
        private ImageTransfer imageTransfer;
        
        public void imageTransfer(ImageTransfer imageTransfer) {
            this.imageTransfer = imageTransfer;
        }
        
        public ImageTransfer imageTransfer() {
            return imageTransfer;
        }
        
    }
    
    public AddForSnapshotRequest addForSnapshot() {
        return new AddForSnapshotRequestImpl();
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
                    actionResponse.imageTransfer(XmlImageTransferReader.readMany(reader));
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
        private List<ImageTransfer> imageTransfer;
        
        public void imageTransfer(List<ImageTransfer> imageTransfer) {
            this.imageTransfer = imageTransfer;
        }
        
        public List<ImageTransfer> imageTransfer() {
            return imageTransfer;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    public ImageTransferService imageTransferService(String id) {
        return new ImageTransferServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return imageTransferService(path);
        }
        return imageTransferService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "ImageTransfersService:" + getPath();
    }
    
}

