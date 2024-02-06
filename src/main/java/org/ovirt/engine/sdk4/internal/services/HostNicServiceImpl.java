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
import org.ovirt.engine.sdk4.builders.HostNicVirtualFunctionsConfigurationBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlHostNicReader;
import org.ovirt.engine.sdk4.services.HostNicService;
import org.ovirt.engine.sdk4.services.LinkLayerDiscoveryProtocolService;
import org.ovirt.engine.sdk4.services.NetworkAttachmentsService;
import org.ovirt.engine.sdk4.services.NetworkLabelsService;
import org.ovirt.engine.sdk4.services.StatisticsService;
import org.ovirt.engine.sdk4.services.VirtualFunctionAllowedNetworksService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.HostNicVirtualFunctionsConfiguration;

public class HostNicServiceImpl extends MeasurableServiceImpl implements HostNicService {
    
    public HostNicServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class GetRequestImpl extends BaseRequest<GetRequest, GetResponse> implements GetRequest {
        private Boolean allContent;
        public GetRequest allContent(Boolean allContent) {
            this.allContent = allContent;
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
                if (allContent != null) {
                    uriBuilder.addParameter("all_content", XmlWriter.renderBoolean(allContent));
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
                    actionResponse.nic(XmlHostNicReader.readOne(reader));
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
        private HostNic nic;
        
        public void nic(HostNic nic) {
            this.nic = nic;
        }
        
        public HostNic nic() {
            return nic;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class UpdateVirtualFunctionsConfigurationRequestImpl extends BaseRequest<UpdateVirtualFunctionsConfigurationRequest, UpdateVirtualFunctionsConfigurationResponse> implements UpdateVirtualFunctionsConfigurationRequest {
        private Boolean async;
        public UpdateVirtualFunctionsConfigurationRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration;
        public UpdateVirtualFunctionsConfigurationRequest virtualFunctionsConfiguration(HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration) {
            this.virtualFunctionsConfiguration = virtualFunctionsConfiguration;
            return this;
        }
        
        public UpdateVirtualFunctionsConfigurationRequest virtualFunctionsConfiguration(HostNicVirtualFunctionsConfigurationBuilder virtualFunctionsConfiguration) {
            this.virtualFunctionsConfiguration = virtualFunctionsConfiguration.build();
            return this;
        }
        
        public UpdateVirtualFunctionsConfigurationResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/updatevirtualfunctionsconfiguration");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.virtualFunctionsConfiguration(virtualFunctionsConfiguration);
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
            return new UpdateVirtualFunctionsConfigurationResponseImpl();
        }
        
    }
    
    private class UpdateVirtualFunctionsConfigurationResponseImpl implements UpdateVirtualFunctionsConfigurationResponse {
    }
    
    public UpdateVirtualFunctionsConfigurationRequest updateVirtualFunctionsConfiguration() {
        return new UpdateVirtualFunctionsConfigurationRequestImpl();
    }
    
    public LinkLayerDiscoveryProtocolService linkLayerDiscoveryProtocolElementsService() {
        return new LinkLayerDiscoveryProtocolServiceImpl(getConnection(), getPath() + "/linklayerdiscoveryprotocolelements");
    }
    
    public NetworkAttachmentsService networkAttachmentsService() {
        return new NetworkAttachmentsServiceImpl(getConnection(), getPath() + "/networkattachments");
    }
    
    public NetworkLabelsService networkLabelsService() {
        return new NetworkLabelsServiceImpl(getConnection(), getPath() + "/networklabels");
    }
    
    public StatisticsService statisticsService() {
        return new StatisticsServiceImpl(getConnection(), getPath() + "/statistics");
    }
    
    public NetworkLabelsService virtualFunctionAllowedLabelsService() {
        return new NetworkLabelsServiceImpl(getConnection(), getPath() + "/virtualfunctionallowedlabels");
    }
    
    public VirtualFunctionAllowedNetworksService virtualFunctionAllowedNetworksService() {
        return new VirtualFunctionAllowedNetworksServiceImpl(getConnection(), getPath() + "/virtualfunctionallowednetworks");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("linklayerdiscoveryprotocolelements")) {
            return linkLayerDiscoveryProtocolElementsService();
        }
        if (path.startsWith("linklayerdiscoveryprotocolelements/")) {
            return linkLayerDiscoveryProtocolElementsService().service(path.substring(35));
        }
        if (path.equals("networkattachments")) {
            return networkAttachmentsService();
        }
        if (path.startsWith("networkattachments/")) {
            return networkAttachmentsService().service(path.substring(19));
        }
        if (path.equals("networklabels")) {
            return networkLabelsService();
        }
        if (path.startsWith("networklabels/")) {
            return networkLabelsService().service(path.substring(14));
        }
        if (path.equals("statistics")) {
            return statisticsService();
        }
        if (path.startsWith("statistics/")) {
            return statisticsService().service(path.substring(11));
        }
        if (path.equals("virtualfunctionallowedlabels")) {
            return virtualFunctionAllowedLabelsService();
        }
        if (path.startsWith("virtualfunctionallowedlabels/")) {
            return virtualFunctionAllowedLabelsService().service(path.substring(29));
        }
        if (path.equals("virtualfunctionallowednetworks")) {
            return virtualFunctionAllowedNetworksService();
        }
        if (path.startsWith("virtualfunctionallowednetworks/")) {
            return virtualFunctionAllowedNetworksService().service(path.substring(31));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "HostNicService:" + getPath();
    }
    
}

