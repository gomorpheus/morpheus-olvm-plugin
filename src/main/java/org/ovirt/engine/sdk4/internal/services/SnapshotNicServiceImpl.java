/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.BaseRequest;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlNicReader;
import org.ovirt.engine.sdk4.services.SnapshotNicService;
import org.ovirt.engine.sdk4.types.Nic;

public class SnapshotNicServiceImpl extends ServiceImpl implements SnapshotNicService {
    
    public SnapshotNicServiceImpl(HttpConnection connection, String path) {
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
                    actionResponse.nic(XmlNicReader.readOne(reader));
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
        private Nic nic;
        
        public void nic(Nic nic) {
            this.nic = nic;
        }
        
        public Nic nic() {
            return nic;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "SnapshotNicService:" + getPath();
    }
    
}

