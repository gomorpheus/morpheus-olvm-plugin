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
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlHostReader;
import org.ovirt.engine.sdk4.internal.xml.XmlHostWriter;
import org.ovirt.engine.sdk4.services.HostService;
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.types.Host;

public class HostsServiceImpl extends ServiceImpl implements HostsService {
    
    public HostsServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class AddRequestImpl extends BaseRequest<AddRequest, AddResponse> implements AddRequest {
        private Boolean activate;
        public AddRequest activate(Boolean activate) {
            this.activate = activate;
            return this;
        }
        
        private Boolean deployHostedEngine;
        public AddRequest deployHostedEngine(Boolean deployHostedEngine) {
            this.deployHostedEngine = deployHostedEngine;
            return this;
        }
        
        private Host host;
        public AddRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public AddRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private Boolean reboot;
        public AddRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        private Boolean undeployHostedEngine;
        public AddRequest undeployHostedEngine(Boolean undeployHostedEngine) {
            this.undeployHostedEngine = undeployHostedEngine;
            return this;
        }
        
        public AddResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (activate != null) {
                    uriBuilder.addParameter("activate", XmlWriter.renderBoolean(activate));
                }
                if (deployHostedEngine != null) {
                    uriBuilder.addParameter("deploy_hosted_engine", XmlWriter.renderBoolean(deployHostedEngine));
                }
                if (reboot != null) {
                    uriBuilder.addParameter("reboot", XmlWriter.renderBoolean(reboot));
                }
                if (undeployHostedEngine != null) {
                    uriBuilder.addParameter("undeploy_hosted_engine", XmlWriter.renderBoolean(undeployHostedEngine));
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
                XmlHostWriter.writeOne(host, xmlWriter);
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
                    actionResponse.host(XmlHostReader.readOne(reader));
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
        private Host host;
        
        public void host(Host host) {
            this.host = host;
        }
        
        public Host host() {
            return host;
        }
        
    }
    
    public AddRequest add() {
        return new AddRequestImpl();
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
        
        private Boolean checkVmsInAffinityClosure;
        public ListRequest checkVmsInAffinityClosure(Boolean checkVmsInAffinityClosure) {
            this.checkVmsInAffinityClosure = checkVmsInAffinityClosure;
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
        
        private String migrationTargetOf;
        public ListRequest migrationTargetOf(String migrationTargetOf) {
            this.migrationTargetOf = migrationTargetOf;
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
                if (checkVmsInAffinityClosure != null) {
                    uriBuilder.addParameter("check_vms_in_affinity_closure", XmlWriter.renderBoolean(checkVmsInAffinityClosure));
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
                if (migrationTargetOf != null) {
                    uriBuilder.addParameter("migration_target_of", XmlWriter.renderString(migrationTargetOf));
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
                    actionResponse.hosts(XmlHostReader.readMany(reader));
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
        private List<Host> hosts;
        
        public void hosts(List<Host> hosts) {
            this.hosts = hosts;
        }
        
        public List<Host> hosts() {
            return hosts;
        }
        
    }
    
    public ListRequest list() {
        return new ListRequestImpl();
    }
    
    private class AddUsingRootPasswordRequestImpl extends BaseRequest<AddUsingRootPasswordRequest, AddUsingRootPasswordResponse> implements AddUsingRootPasswordRequest {
        private Boolean activate;
        public AddUsingRootPasswordRequest activate(Boolean activate) {
            this.activate = activate;
            return this;
        }
        
        private Boolean deployHostedEngine;
        public AddUsingRootPasswordRequest deployHostedEngine(Boolean deployHostedEngine) {
            this.deployHostedEngine = deployHostedEngine;
            return this;
        }
        
        private Host host;
        public AddUsingRootPasswordRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public AddUsingRootPasswordRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private Boolean reboot;
        public AddUsingRootPasswordRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        private Boolean undeployHostedEngine;
        public AddUsingRootPasswordRequest undeployHostedEngine(Boolean undeployHostedEngine) {
            this.undeployHostedEngine = undeployHostedEngine;
            return this;
        }
        
        public AddUsingRootPasswordResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (activate != null) {
                    uriBuilder.addParameter("activate", XmlWriter.renderBoolean(activate));
                }
                if (deployHostedEngine != null) {
                    uriBuilder.addParameter("deploy_hosted_engine", XmlWriter.renderBoolean(deployHostedEngine));
                }
                if (reboot != null) {
                    uriBuilder.addParameter("reboot", XmlWriter.renderBoolean(reboot));
                }
                if (undeployHostedEngine != null) {
                    uriBuilder.addParameter("undeploy_hosted_engine", XmlWriter.renderBoolean(undeployHostedEngine));
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
                XmlHostWriter.writeOne(host, xmlWriter);
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
                    AddUsingRootPasswordResponseImpl actionResponse = new AddUsingRootPasswordResponseImpl();
                    actionResponse.host(XmlHostReader.readOne(reader));
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
                return new AddUsingRootPasswordResponseImpl();
            }
        }
        
    }
    
    private class AddUsingRootPasswordResponseImpl implements AddUsingRootPasswordResponse {
        private Host host;
        
        public void host(Host host) {
            this.host = host;
        }
        
        public Host host() {
            return host;
        }
        
    }
    
    public AddUsingRootPasswordRequest addUsingRootPassword() {
        return new AddUsingRootPasswordRequestImpl();
    }
    
    private class AddUsingSshRequestImpl extends BaseRequest<AddUsingSshRequest, AddUsingSshResponse> implements AddUsingSshRequest {
        private Boolean activate;
        public AddUsingSshRequest activate(Boolean activate) {
            this.activate = activate;
            return this;
        }
        
        private Boolean deployHostedEngine;
        public AddUsingSshRequest deployHostedEngine(Boolean deployHostedEngine) {
            this.deployHostedEngine = deployHostedEngine;
            return this;
        }
        
        private Host host;
        public AddUsingSshRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public AddUsingSshRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private Boolean reboot;
        public AddUsingSshRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        private Boolean undeployHostedEngine;
        public AddUsingSshRequest undeployHostedEngine(Boolean undeployHostedEngine) {
            this.undeployHostedEngine = undeployHostedEngine;
            return this;
        }
        
        public AddUsingSshResponse send() {
            HttpPost request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (activate != null) {
                    uriBuilder.addParameter("activate", XmlWriter.renderBoolean(activate));
                }
                if (deployHostedEngine != null) {
                    uriBuilder.addParameter("deploy_hosted_engine", XmlWriter.renderBoolean(deployHostedEngine));
                }
                if (reboot != null) {
                    uriBuilder.addParameter("reboot", XmlWriter.renderBoolean(reboot));
                }
                if (undeployHostedEngine != null) {
                    uriBuilder.addParameter("undeploy_hosted_engine", XmlWriter.renderBoolean(undeployHostedEngine));
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
                XmlHostWriter.writeOne(host, xmlWriter);
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
                    AddUsingSshResponseImpl actionResponse = new AddUsingSshResponseImpl();
                    actionResponse.host(XmlHostReader.readOne(reader));
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
                return new AddUsingSshResponseImpl();
            }
        }
        
    }
    
    private class AddUsingSshResponseImpl implements AddUsingSshResponse {
        private Host host;
        
        public void host(Host host) {
            this.host = host;
        }
        
        public Host host() {
            return host;
        }
        
    }
    
    public AddUsingSshRequest addUsingSsh() {
        return new AddUsingSshRequestImpl();
    }
    
    public HostService hostService(String id) {
        return new HostServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return hostService(path);
        }
        return hostService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "HostsService:" + getPath();
    }
    
}

