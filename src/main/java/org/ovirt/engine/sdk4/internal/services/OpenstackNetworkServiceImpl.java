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
import org.ovirt.engine.sdk4.builders.DataCenterBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlOpenStackNetworkReader;
import org.ovirt.engine.sdk4.services.OpenstackNetworkService;
import org.ovirt.engine.sdk4.services.OpenstackSubnetsService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.OpenStackNetwork;

public class OpenstackNetworkServiceImpl extends ServiceImpl implements OpenstackNetworkService {
    
    public OpenstackNetworkServiceImpl(HttpConnection connection, String path) {
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
                    actionResponse.network(XmlOpenStackNetworkReader.readOne(reader));
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
        private OpenStackNetwork network;
        
        public void network(OpenStackNetwork network) {
            this.network = network;
        }
        
        public OpenStackNetwork network() {
            return network;
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
        
        private DataCenter dataCenter;
        public ImportRequest dataCenter(DataCenter dataCenter) {
            this.dataCenter = dataCenter;
            return this;
        }
        
        public ImportRequest dataCenter(DataCenterBuilder dataCenter) {
            this.dataCenter = dataCenter.build();
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
                action.dataCenter(dataCenter);
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
    
    public OpenstackSubnetsService subnetsService() {
        return new OpenstackSubnetsServiceImpl(getConnection(), getPath() + "/subnets");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("subnets")) {
            return subnetsService();
        }
        if (path.startsWith("subnets/")) {
            return subnetsService().service(path.substring(8));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "OpenstackNetworkService:" + getPath();
    }
    
}

