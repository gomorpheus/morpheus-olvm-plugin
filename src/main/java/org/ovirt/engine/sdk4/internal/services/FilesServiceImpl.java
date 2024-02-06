/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.List;
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
import org.ovirt.engine.sdk4.internal.xml.XmlFileReader;
import org.ovirt.engine.sdk4.services.FileService;
import org.ovirt.engine.sdk4.services.FilesService;
import org.ovirt.engine.sdk4.types.File;

public class FilesServiceImpl extends ServiceImpl implements FilesService {
    
    public FilesServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class ListRequestImpl extends BaseRequest<ListRequest, ListResponse> implements ListRequest {
        private Boolean caseSensitive;
        public ListRequest caseSensitive(Boolean caseSensitive) {
            this.caseSensitive = caseSensitive;
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
        
        private Boolean refresh;
        public ListRequest refresh(Boolean refresh) {
            this.refresh = refresh;
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
                if (caseSensitive != null) {
                    uriBuilder.addParameter("case_sensitive", XmlWriter.renderBoolean(caseSensitive));
                }
                if (follow != null) {
                    uriBuilder.addParameter("follow", XmlWriter.renderString(follow));
                }
                if (max != null) {
                    uriBuilder.addParameter("max", XmlWriter.renderInteger(max));
                }
                if (refresh != null) {
                    uriBuilder.addParameter("refresh", XmlWriter.renderBoolean(refresh));
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
                    actionResponse.file(XmlFileReader.readMany(reader));
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
        private List<File> file;
        
        public void file(List<File> file) {
            this.file = file;
        }
        
        public List<File> file() {
            return file;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    public FileService fileService(String id) {
        return new FileServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return fileService(path);
        }
        return fileService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "FilesService:" + getPath();
    }
    
}

