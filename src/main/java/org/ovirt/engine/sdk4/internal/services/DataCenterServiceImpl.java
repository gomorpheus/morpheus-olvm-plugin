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
import org.ovirt.engine.sdk4.builders.DataCenterBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlDataCenterReader;
import org.ovirt.engine.sdk4.internal.xml.XmlDataCenterWriter;
import org.ovirt.engine.sdk4.services.AssignedPermissionsService;
import org.ovirt.engine.sdk4.services.AttachedStorageDomainsService;
import org.ovirt.engine.sdk4.services.ClustersService;
import org.ovirt.engine.sdk4.services.DataCenterNetworksService;
import org.ovirt.engine.sdk4.services.DataCenterService;
import org.ovirt.engine.sdk4.services.IscsiBondsService;
import org.ovirt.engine.sdk4.services.QossService;
import org.ovirt.engine.sdk4.services.QuotasService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class DataCenterServiceImpl extends ServiceImpl implements DataCenterService {
    
    public DataCenterServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class CleanFinishedTasksRequestImpl extends BaseRequest<CleanFinishedTasksRequest, CleanFinishedTasksResponse> implements CleanFinishedTasksRequest {
        private Boolean async;
        public CleanFinishedTasksRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public CleanFinishedTasksResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/cleanfinishedtasks");
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
            return new CleanFinishedTasksResponseImpl();
        }
        
    }
    
    private class CleanFinishedTasksResponseImpl implements CleanFinishedTasksResponse {
    }
    
    public CleanFinishedTasksRequest cleanFinishedTasks() {
        return new CleanFinishedTasksRequestImpl();
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
                    actionResponse.dataCenter(XmlDataCenterReader.readOne(reader));
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
        private DataCenter dataCenter;
        
        public void dataCenter(DataCenter dataCenter) {
            this.dataCenter = dataCenter;
        }
        
        public DataCenter dataCenter() {
            return dataCenter;
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
        
        private Boolean force;
        public RemoveRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public RemoveResponse send() {
            HttpDelete request = null;
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
    
    private class SetMasterRequestImpl extends BaseRequest<SetMasterRequest, SetMasterResponse> implements SetMasterRequest {
        private Boolean async;
        public SetMasterRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private StorageDomain storageDomain;
        public SetMasterRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public SetMasterRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        public SetMasterResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/setmaster");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
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
            return new SetMasterResponseImpl();
        }
        
    }
    
    private class SetMasterResponseImpl implements SetMasterResponse {
    }
    
    public SetMasterRequest setMaster() {
        return new SetMasterRequestImpl();
    }
    
    private class UpdateRequestImpl extends BaseRequest<UpdateRequest, UpdateResponse> implements UpdateRequest {
        private Boolean async;
        public UpdateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private DataCenter dataCenter;
        public UpdateRequest dataCenter(DataCenter dataCenter) {
            this.dataCenter = dataCenter;
            return this;
        }
        
        public UpdateRequest dataCenter(DataCenterBuilder dataCenter) {
            this.dataCenter = dataCenter.build();
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
                XmlDataCenterWriter.writeOne(dataCenter, xmlWriter);
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
                    actionResponse.dataCenter(XmlDataCenterReader.readOne(reader));
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
        private DataCenter dataCenter;
        
        public void dataCenter(DataCenter dataCenter) {
            this.dataCenter = dataCenter;
        }
        
        public DataCenter dataCenter() {
            return dataCenter;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    public ClustersService clustersService() {
        return new ClustersServiceImpl(getConnection(), getPath() + "/clusters");
    }
    
    public IscsiBondsService iscsiBondsService() {
        return new IscsiBondsServiceImpl(getConnection(), getPath() + "/iscsibonds");
    }
    
    public DataCenterNetworksService networksService() {
        return new DataCenterNetworksServiceImpl(getConnection(), getPath() + "/networks");
    }
    
    public AssignedPermissionsService permissionsService() {
        return new AssignedPermissionsServiceImpl(getConnection(), getPath() + "/permissions");
    }
    
    public QossService qossService() {
        return new QossServiceImpl(getConnection(), getPath() + "/qoss");
    }
    
    public QuotasService quotasService() {
        return new QuotasServiceImpl(getConnection(), getPath() + "/quotas");
    }
    
    public AttachedStorageDomainsService storageDomainsService() {
        return new AttachedStorageDomainsServiceImpl(getConnection(), getPath() + "/storagedomains");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("clusters")) {
            return clustersService();
        }
        if (path.startsWith("clusters/")) {
            return clustersService().service(path.substring(9));
        }
        if (path.equals("iscsibonds")) {
            return iscsiBondsService();
        }
        if (path.startsWith("iscsibonds/")) {
            return iscsiBondsService().service(path.substring(11));
        }
        if (path.equals("networks")) {
            return networksService();
        }
        if (path.startsWith("networks/")) {
            return networksService().service(path.substring(9));
        }
        if (path.equals("permissions")) {
            return permissionsService();
        }
        if (path.startsWith("permissions/")) {
            return permissionsService().service(path.substring(12));
        }
        if (path.equals("qoss")) {
            return qossService();
        }
        if (path.startsWith("qoss/")) {
            return qossService().service(path.substring(5));
        }
        if (path.equals("quotas")) {
            return quotasService();
        }
        if (path.startsWith("quotas/")) {
            return quotasService().service(path.substring(7));
        }
        if (path.equals("storagedomains")) {
            return storageDomainsService();
        }
        if (path.startsWith("storagedomains/")) {
            return storageDomainsService().service(path.substring(15));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "DataCenterService:" + getPath();
    }
    
}

