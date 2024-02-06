/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
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
import org.ovirt.engine.sdk4.builders.GlusterBrickBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlGlusterBrickReader;
import org.ovirt.engine.sdk4.internal.xml.XmlGlusterBrickWriter;
import org.ovirt.engine.sdk4.services.GlusterBrickService;
import org.ovirt.engine.sdk4.services.GlusterBricksService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.GlusterBrick;

public class GlusterBricksServiceImpl extends ServiceImpl implements GlusterBricksService {
    
    public GlusterBricksServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class ActivateRequestImpl extends BaseRequest<ActivateRequest, ActivateResponse> implements ActivateRequest {
        private Boolean async;
        public ActivateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private List<GlusterBrick> bricks;
        public ActivateRequest bricks(List<GlusterBrick> bricks) {
            this.bricks = bricks;
            return this;
        }
        
        public ActivateRequest bricks(GlusterBrick... bricks) {
            this.bricks = Arrays.asList(bricks);
            return this;
        }
        
        public ActivateRequest bricks(GlusterBrickBuilder... bricks) {
            this.bricks = new ArrayList<>(bricks.length);
            for (GlusterBrickBuilder element : bricks) {
                this.bricks.add(element.build());
            }
            return this;
        }
        
        public ActivateResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/activate");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.bricks(bricks);
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
            return new ActivateResponseImpl();
        }
        
    }
    
    private class ActivateResponseImpl implements ActivateResponse {
    }
    
    public ActivateRequest activate() {
        return new ActivateRequestImpl();
    }
    
    private class AddRequestImpl extends BaseRequest<AddRequest, AddResponse> implements AddRequest {
        private List<GlusterBrick> bricks;
        public AddRequest bricks(List<GlusterBrick> bricks) {
            this.bricks = bricks;
            return this;
        }
        
        public AddRequest bricks(GlusterBrick... bricks) {
            this.bricks = Arrays.asList(bricks);
            return this;
        }
        
        public AddRequest bricks(GlusterBrickBuilder... bricks) {
            this.bricks = new ArrayList<>(bricks.length);
            for (GlusterBrickBuilder element : bricks) {
                this.bricks.add(element.build());
            }
            return this;
        }
        
        private BigInteger replicaCount;
        public AddRequest replicaCount(BigInteger replicaCount) {
            this.replicaCount = replicaCount;
            return this;
        }
        
        public AddRequest replicaCount(Integer replicaCount) {
            this.replicaCount = BigInteger.valueOf(replicaCount);
            return this;
        }
        
        public AddRequest replicaCount(Long replicaCount) {
            this.replicaCount = BigInteger.valueOf(replicaCount);
            return this;
        }
        
        private BigInteger stripeCount;
        public AddRequest stripeCount(BigInteger stripeCount) {
            this.stripeCount = stripeCount;
            return this;
        }
        
        public AddRequest stripeCount(Integer stripeCount) {
            this.stripeCount = BigInteger.valueOf(stripeCount);
            return this;
        }
        
        public AddRequest stripeCount(Long stripeCount) {
            this.stripeCount = BigInteger.valueOf(stripeCount);
            return this;
        }
        
        public AddResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (replicaCount != null) {
                    uriBuilder.addParameter("replica_count", XmlWriter.renderInteger(replicaCount));
                }
                if (stripeCount != null) {
                    uriBuilder.addParameter("stripe_count", XmlWriter.renderInteger(stripeCount));
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
                XmlGlusterBrickWriter.writeMany(bricks.iterator(), xmlWriter);
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
                    actionResponse.bricks(XmlGlusterBrickReader.readMany(reader));
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
        private List<GlusterBrick> bricks;
        
        public void bricks(List<GlusterBrick> bricks) {
            this.bricks = bricks;
        }
        
        public List<GlusterBrick> bricks() {
            return bricks;
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
        
        public ListResponse send() {
            HttpGet request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (follow != null) {
                    uriBuilder.addParameter("follow", XmlWriter.renderString(follow));
                }
                if (max != null) {
                    uriBuilder.addParameter("max", XmlWriter.renderInteger(max));
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
                    actionResponse.bricks(XmlGlusterBrickReader.readMany(reader));
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
        private List<GlusterBrick> bricks;
        
        public void bricks(List<GlusterBrick> bricks) {
            this.bricks = bricks;
        }
        
        public List<GlusterBrick> bricks() {
            return bricks;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    private class MigrateRequestImpl extends BaseRequest<MigrateRequest, MigrateResponse> implements MigrateRequest {
        private Boolean async;
        public MigrateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private List<GlusterBrick> bricks;
        public MigrateRequest bricks(List<GlusterBrick> bricks) {
            this.bricks = bricks;
            return this;
        }
        
        public MigrateRequest bricks(GlusterBrick... bricks) {
            this.bricks = Arrays.asList(bricks);
            return this;
        }
        
        public MigrateRequest bricks(GlusterBrickBuilder... bricks) {
            this.bricks = new ArrayList<>(bricks.length);
            for (GlusterBrickBuilder element : bricks) {
                this.bricks.add(element.build());
            }
            return this;
        }
        
        public MigrateResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/migrate");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.bricks(bricks);
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
            return new MigrateResponseImpl();
        }
        
    }
    
    private class MigrateResponseImpl implements MigrateResponse {
    }
    
    public MigrateRequest migrate() {
        return new MigrateRequestImpl();
    }
    
    private class RemoveRequestImpl extends BaseRequest<RemoveRequest, RemoveResponse> implements RemoveRequest {
        private Boolean async;
        public RemoveRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private List<GlusterBrick> bricks;
        public RemoveRequest bricks(List<GlusterBrick> bricks) {
            this.bricks = bricks;
            return this;
        }
        
        public RemoveRequest bricks(GlusterBrick... bricks) {
            this.bricks = Arrays.asList(bricks);
            return this;
        }
        
        public RemoveRequest bricks(GlusterBrickBuilder... bricks) {
            this.bricks = new ArrayList<>(bricks.length);
            for (GlusterBrickBuilder element : bricks) {
                this.bricks.add(element.build());
            }
            return this;
        }
        
        private BigInteger replicaCount;
        public RemoveRequest replicaCount(BigInteger replicaCount) {
            this.replicaCount = replicaCount;
            return this;
        }
        
        public RemoveRequest replicaCount(Integer replicaCount) {
            this.replicaCount = BigInteger.valueOf(replicaCount);
            return this;
        }
        
        public RemoveRequest replicaCount(Long replicaCount) {
            this.replicaCount = BigInteger.valueOf(replicaCount);
            return this;
        }
        
        public RemoveResponse send() {
            HttpDelete request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (replicaCount != null) {
                    uriBuilder.addParameter("replica_count", XmlWriter.renderInteger(replicaCount));
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
    
    private class StopMigrateRequestImpl extends BaseRequest<StopMigrateRequest, StopMigrateResponse> implements StopMigrateRequest {
        private Boolean async;
        public StopMigrateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private List<GlusterBrick> bricks;
        public StopMigrateRequest bricks(List<GlusterBrick> bricks) {
            this.bricks = bricks;
            return this;
        }
        
        public StopMigrateRequest bricks(GlusterBrick... bricks) {
            this.bricks = Arrays.asList(bricks);
            return this;
        }
        
        public StopMigrateRequest bricks(GlusterBrickBuilder... bricks) {
            this.bricks = new ArrayList<>(bricks.length);
            for (GlusterBrickBuilder element : bricks) {
                this.bricks.add(element.build());
            }
            return this;
        }
        
        public StopMigrateResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/stopmigrate");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.bricks(bricks);
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
            return new StopMigrateResponseImpl();
        }
        
    }
    
    private class StopMigrateResponseImpl implements StopMigrateResponse {
    }
    
    public StopMigrateRequest stopMigrate() {
        return new StopMigrateRequestImpl();
    }
    
    public GlusterBrickService brickService(String id) {
        return new GlusterBrickServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return brickService(path);
        }
        return brickService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "GlusterBricksService:" + getPath();
    }
    
}

