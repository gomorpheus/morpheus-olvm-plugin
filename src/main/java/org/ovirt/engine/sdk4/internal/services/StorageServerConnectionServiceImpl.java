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
import org.ovirt.engine.sdk4.builders.StorageConnectionBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlStorageConnectionReader;
import org.ovirt.engine.sdk4.internal.xml.XmlStorageConnectionWriter;
import org.ovirt.engine.sdk4.services.StorageServerConnectionService;
import org.ovirt.engine.sdk4.types.StorageConnection;

public class StorageServerConnectionServiceImpl extends ServiceImpl implements StorageServerConnectionService {
    
    public StorageServerConnectionServiceImpl(HttpConnection connection, String path) {
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
                    actionResponse.conection(XmlStorageConnectionReader.readOne(reader));
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
        private StorageConnection conection;
        
        public void conection(StorageConnection conection) {
            this.conection = conection;
        }
        
        public StorageConnection conection() {
            return conection;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class UpdateGlusterfsRequestImpl extends BaseRequest<UpdateGlusterfsRequest, UpdateGlusterfsResponse> implements UpdateGlusterfsRequest {
        private Boolean async;
        public UpdateGlusterfsRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private StorageConnection connection;
        public UpdateGlusterfsRequest connection(StorageConnection connection) {
            this.connection = connection;
            return this;
        }
        
        public UpdateGlusterfsRequest connection(StorageConnectionBuilder connection) {
            this.connection = connection.build();
            return this;
        }
        
        private Boolean force;
        public UpdateGlusterfsRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public UpdateGlusterfsResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (force != null) {
                    uriBuilder.addParameter("force", XmlWriter.renderBoolean(force));
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
                XmlStorageConnectionWriter.writeOne(connection, xmlWriter);
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
                    UpdateGlusterfsResponseImpl actionResponse = new UpdateGlusterfsResponseImpl();
                    actionResponse.connection(XmlStorageConnectionReader.readOne(reader));
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
                return new UpdateGlusterfsResponseImpl();
            }
        }
        
    }
    
    private class UpdateGlusterfsResponseImpl implements UpdateGlusterfsResponse {
        private StorageConnection connection;
        
        public void connection(StorageConnection connection) {
            this.connection = connection;
        }
        
        public StorageConnection connection() {
            return connection;
        }
        
    }
    
    public UpdateGlusterfsRequest updateGlusterfs() {
        return new UpdateGlusterfsRequestImpl();
    }
    
    private class UpdateIscsiRequestImpl extends BaseRequest<UpdateIscsiRequest, UpdateIscsiResponse> implements UpdateIscsiRequest {
        private Boolean async;
        public UpdateIscsiRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private StorageConnection connection;
        public UpdateIscsiRequest connection(StorageConnection connection) {
            this.connection = connection;
            return this;
        }
        
        public UpdateIscsiRequest connection(StorageConnectionBuilder connection) {
            this.connection = connection.build();
            return this;
        }
        
        private Boolean force;
        public UpdateIscsiRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public UpdateIscsiResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (force != null) {
                    uriBuilder.addParameter("force", XmlWriter.renderBoolean(force));
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
                XmlStorageConnectionWriter.writeOne(connection, xmlWriter);
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
                    UpdateIscsiResponseImpl actionResponse = new UpdateIscsiResponseImpl();
                    actionResponse.connection(XmlStorageConnectionReader.readOne(reader));
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
                return new UpdateIscsiResponseImpl();
            }
        }
        
    }
    
    private class UpdateIscsiResponseImpl implements UpdateIscsiResponse {
        private StorageConnection connection;
        
        public void connection(StorageConnection connection) {
            this.connection = connection;
        }
        
        public StorageConnection connection() {
            return connection;
        }
        
    }
    
    public UpdateIscsiRequest updateIscsi() {
        return new UpdateIscsiRequestImpl();
    }
    
    private class UpdateLocalRequestImpl extends BaseRequest<UpdateLocalRequest, UpdateLocalResponse> implements UpdateLocalRequest {
        private Boolean async;
        public UpdateLocalRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private StorageConnection connection;
        public UpdateLocalRequest connection(StorageConnection connection) {
            this.connection = connection;
            return this;
        }
        
        public UpdateLocalRequest connection(StorageConnectionBuilder connection) {
            this.connection = connection.build();
            return this;
        }
        
        private Boolean force;
        public UpdateLocalRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public UpdateLocalResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (force != null) {
                    uriBuilder.addParameter("force", XmlWriter.renderBoolean(force));
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
                XmlStorageConnectionWriter.writeOne(connection, xmlWriter);
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
                    UpdateLocalResponseImpl actionResponse = new UpdateLocalResponseImpl();
                    actionResponse.connection(XmlStorageConnectionReader.readOne(reader));
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
                return new UpdateLocalResponseImpl();
            }
        }
        
    }
    
    private class UpdateLocalResponseImpl implements UpdateLocalResponse {
        private StorageConnection connection;
        
        public void connection(StorageConnection connection) {
            this.connection = connection;
        }
        
        public StorageConnection connection() {
            return connection;
        }
        
    }
    
    public UpdateLocalRequest updateLocal() {
        return new UpdateLocalRequestImpl();
    }
    
    private class UpdateNfsRequestImpl extends BaseRequest<UpdateNfsRequest, UpdateNfsResponse> implements UpdateNfsRequest {
        private Boolean async;
        public UpdateNfsRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private StorageConnection connection;
        public UpdateNfsRequest connection(StorageConnection connection) {
            this.connection = connection;
            return this;
        }
        
        public UpdateNfsRequest connection(StorageConnectionBuilder connection) {
            this.connection = connection.build();
            return this;
        }
        
        private Boolean force;
        public UpdateNfsRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public UpdateNfsResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (force != null) {
                    uriBuilder.addParameter("force", XmlWriter.renderBoolean(force));
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
                XmlStorageConnectionWriter.writeOne(connection, xmlWriter);
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
                    UpdateNfsResponseImpl actionResponse = new UpdateNfsResponseImpl();
                    actionResponse.connection(XmlStorageConnectionReader.readOne(reader));
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
                return new UpdateNfsResponseImpl();
            }
        }
        
    }
    
    private class UpdateNfsResponseImpl implements UpdateNfsResponse {
        private StorageConnection connection;
        
        public void connection(StorageConnection connection) {
            this.connection = connection;
        }
        
        public StorageConnection connection() {
            return connection;
        }
        
    }
    
    public UpdateNfsRequest updateNfs() {
        return new UpdateNfsRequestImpl();
    }
    
    private class RemoveRequestImpl extends BaseRequest<RemoveRequest, RemoveResponse> implements RemoveRequest {
        private Boolean async;
        public RemoveRequest async(Boolean async) {
            this.async = async;
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
        
        private StorageConnection connection;
        public UpdateRequest connection(StorageConnection connection) {
            this.connection = connection;
            return this;
        }
        
        public UpdateRequest connection(StorageConnectionBuilder connection) {
            this.connection = connection.build();
            return this;
        }
        
        private Boolean force;
        public UpdateRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public UpdateResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (force != null) {
                    uriBuilder.addParameter("force", XmlWriter.renderBoolean(force));
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
                XmlStorageConnectionWriter.writeOne(connection, xmlWriter);
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
                    actionResponse.connection(XmlStorageConnectionReader.readOne(reader));
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
        private StorageConnection connection;
        
        public void connection(StorageConnection connection) {
            this.connection = connection;
        }
        
        public StorageConnection connection() {
            return connection;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    private class UpdateVfsRequestImpl extends BaseRequest<UpdateVfsRequest, UpdateVfsResponse> implements UpdateVfsRequest {
        private Boolean async;
        public UpdateVfsRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private StorageConnection connection;
        public UpdateVfsRequest connection(StorageConnection connection) {
            this.connection = connection;
            return this;
        }
        
        public UpdateVfsRequest connection(StorageConnectionBuilder connection) {
            this.connection = connection.build();
            return this;
        }
        
        private Boolean force;
        public UpdateVfsRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public UpdateVfsResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (force != null) {
                    uriBuilder.addParameter("force", XmlWriter.renderBoolean(force));
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
                XmlStorageConnectionWriter.writeOne(connection, xmlWriter);
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
                    UpdateVfsResponseImpl actionResponse = new UpdateVfsResponseImpl();
                    actionResponse.connection(XmlStorageConnectionReader.readOne(reader));
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
                return new UpdateVfsResponseImpl();
            }
        }
        
    }
    
    private class UpdateVfsResponseImpl implements UpdateVfsResponse {
        private StorageConnection connection;
        
        public void connection(StorageConnection connection) {
            this.connection = connection;
        }
        
        public StorageConnection connection() {
            return connection;
        }
        
    }
    
    public UpdateVfsRequest updateVfs() {
        return new UpdateVfsRequestImpl();
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "StorageServerConnectionService:" + getPath();
    }
    
}

