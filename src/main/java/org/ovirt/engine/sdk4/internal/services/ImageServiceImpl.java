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
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.builders.DiskBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.builders.TemplateBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlImageReader;
import org.ovirt.engine.sdk4.services.ImageService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Image;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;

public class ImageServiceImpl extends ServiceImpl implements ImageService {
    
    public ImageServiceImpl(HttpConnection connection, String path) {
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
                    actionResponse.image(XmlImageReader.readOne(reader));
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
        private Image image;
        
        public void image(Image image) {
            this.image = image;
        }
        
        public Image image() {
            return image;
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
        
        private Cluster cluster;
        public ImportRequest cluster(Cluster cluster) {
            this.cluster = cluster;
            return this;
        }
        
        public ImportRequest cluster(ClusterBuilder cluster) {
            this.cluster = cluster.build();
            return this;
        }
        
        private Disk disk;
        public ImportRequest disk(Disk disk) {
            this.disk = disk;
            return this;
        }
        
        public ImportRequest disk(DiskBuilder disk) {
            this.disk = disk.build();
            return this;
        }
        
        private Boolean importAsTemplate;
        public ImportRequest importAsTemplate(Boolean importAsTemplate) {
            this.importAsTemplate = importAsTemplate;
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
        
        public ImportResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/import");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.cluster(cluster);
                action.disk(disk);
                action.importAsTemplate(importAsTemplate);
                action.storageDomain(storageDomain);
                action.template(template);
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
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "ImageService:" + getPath();
    }
    
}

