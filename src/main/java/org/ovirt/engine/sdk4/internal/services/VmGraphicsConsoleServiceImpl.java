/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.String;
import java.net.URISyntaxException;
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
import org.ovirt.engine.sdk4.builders.TicketBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlGraphicsConsoleReader;
import org.ovirt.engine.sdk4.services.VmGraphicsConsoleService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.ProxyTicket;
import org.ovirt.engine.sdk4.types.Ticket;

public class VmGraphicsConsoleServiceImpl extends ServiceImpl implements VmGraphicsConsoleService {
    
    public VmGraphicsConsoleServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class GetRequestImpl extends BaseRequest<GetRequest, GetResponse> implements GetRequest {
        private Boolean current;
        public GetRequest current(Boolean current) {
            this.current = current;
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
                if (current != null) {
                    uriBuilder.addParameter("current", XmlWriter.renderBoolean(current));
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
                    actionResponse.console(XmlGraphicsConsoleReader.readOne(reader));
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
        private GraphicsConsole console;
        
        public void console(GraphicsConsole console) {
            this.console = console;
        }
        
        public GraphicsConsole console() {
            return console;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class ProxyTicketRequestImpl extends BaseRequest<ProxyTicketRequest, ProxyTicketResponse> implements ProxyTicketRequest {
        private Boolean async;
        public ProxyTicketRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ProxyTicketResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/proxyticket");
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
            ProxyTicketResponseImpl actionResponse = new ProxyTicketResponseImpl();
            actionResponse.proxyTicket(action.proxyTicket());
            return actionResponse;
        }
        
    }
    
    private class ProxyTicketResponseImpl implements ProxyTicketResponse {
        private ProxyTicket proxyTicket;
        
        public void proxyTicket(ProxyTicket proxyTicket) {
            this.proxyTicket = proxyTicket;
        }
        
        public ProxyTicket proxyTicket() {
            return proxyTicket;
        }
        
    }
    
    public ProxyTicketRequest proxyTicket() {
        return new ProxyTicketRequestImpl();
    }
    
    private class RemoteViewerConnectionFileRequestImpl extends BaseRequest<RemoteViewerConnectionFileRequest, RemoteViewerConnectionFileResponse> implements RemoteViewerConnectionFileRequest {
        public RemoteViewerConnectionFileResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/remoteviewerconnectionfile");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
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
            RemoteViewerConnectionFileResponseImpl actionResponse = new RemoteViewerConnectionFileResponseImpl();
            actionResponse.remoteViewerConnectionFile(action.remoteViewerConnectionFile());
            return actionResponse;
        }
        
    }
    
    private class RemoteViewerConnectionFileResponseImpl implements RemoteViewerConnectionFileResponse {
        private String remoteViewerConnectionFile;
        
        public void remoteViewerConnectionFile(String remoteViewerConnectionFile) {
            this.remoteViewerConnectionFile = remoteViewerConnectionFile;
        }
        
        public String remoteViewerConnectionFile() {
            return remoteViewerConnectionFile;
        }
        
    }
    
    public RemoteViewerConnectionFileRequest remoteViewerConnectionFile() {
        return new RemoteViewerConnectionFileRequestImpl();
    }
    
    private class RemoveRequestImpl extends BaseRequest<RemoveRequest, RemoveResponse> implements RemoveRequest {
        private Boolean async;
        public RemoveRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public RemoveResponse send() {
            HttpDelete request = null;
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
    
    private class TicketRequestImpl extends BaseRequest<TicketRequest, TicketResponse> implements TicketRequest {
        private Ticket ticket;
        public TicketRequest ticket(Ticket ticket) {
            this.ticket = ticket;
            return this;
        }
        
        public TicketRequest ticket(TicketBuilder ticket) {
            this.ticket = ticket.build();
            return this;
        }
        
        public TicketResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/ticket");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.ticket(ticket);
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
            TicketResponseImpl actionResponse = new TicketResponseImpl();
            actionResponse.ticket(action.ticket());
            return actionResponse;
        }
        
    }
    
    private class TicketResponseImpl implements TicketResponse {
        private Ticket ticket;
        
        public void ticket(Ticket ticket) {
            this.ticket = ticket;
        }
        
        public Ticket ticket() {
            return ticket;
        }
        
    }
    
    public TicketRequest ticket() {
        return new TicketRequestImpl();
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "VmGraphicsConsoleService:" + getPath();
    }
    
}

