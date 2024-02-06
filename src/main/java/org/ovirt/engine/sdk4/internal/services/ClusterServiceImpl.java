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
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlClusterReader;
import org.ovirt.engine.sdk4.internal.xml.XmlClusterWriter;
import org.ovirt.engine.sdk4.services.AffinityGroupsService;
import org.ovirt.engine.sdk4.services.AssignedCpuProfilesService;
import org.ovirt.engine.sdk4.services.AssignedPermissionsService;
import org.ovirt.engine.sdk4.services.ClusterEnabledFeaturesService;
import org.ovirt.engine.sdk4.services.ClusterExternalProvidersService;
import org.ovirt.engine.sdk4.services.ClusterNetworksService;
import org.ovirt.engine.sdk4.services.ClusterService;
import org.ovirt.engine.sdk4.services.GlusterHooksService;
import org.ovirt.engine.sdk4.services.GlusterVolumesService;
import org.ovirt.engine.sdk4.services.NetworkFiltersService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.ClusterUpgradeAction;

public class ClusterServiceImpl extends ServiceImpl implements ClusterService {
    
    public ClusterServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
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
                    actionResponse.cluster(XmlClusterReader.readOne(reader));
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
        private Cluster cluster;
        
        public void cluster(Cluster cluster) {
            this.cluster = cluster;
        }
        
        public Cluster cluster() {
            return cluster;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class RefreshGlusterHealStatusRequestImpl extends BaseRequest<RefreshGlusterHealStatusRequest, RefreshGlusterHealStatusResponse> implements RefreshGlusterHealStatusRequest {
        public RefreshGlusterHealStatusResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/refreshglusterhealstatus");
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
            return new RefreshGlusterHealStatusResponseImpl();
        }
        
    }
    
    private class RefreshGlusterHealStatusResponseImpl implements RefreshGlusterHealStatusResponse {
    }
    
    public RefreshGlusterHealStatusRequest refreshGlusterHealStatus() {
        return new RefreshGlusterHealStatusRequestImpl();
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
    
    private class ResetEmulatedMachineRequestImpl extends BaseRequest<ResetEmulatedMachineRequest, ResetEmulatedMachineResponse> implements ResetEmulatedMachineRequest {
        private Boolean async;
        public ResetEmulatedMachineRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ResetEmulatedMachineResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/resetemulatedmachine");
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
            return new ResetEmulatedMachineResponseImpl();
        }
        
    }
    
    private class ResetEmulatedMachineResponseImpl implements ResetEmulatedMachineResponse {
    }
    
    public ResetEmulatedMachineRequest resetEmulatedMachine() {
        return new ResetEmulatedMachineRequestImpl();
    }
    
    private class SyncAllNetworksRequestImpl extends BaseRequest<SyncAllNetworksRequest, SyncAllNetworksResponse> implements SyncAllNetworksRequest {
        private Boolean async;
        public SyncAllNetworksRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public SyncAllNetworksResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/syncallnetworks");
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
            return new SyncAllNetworksResponseImpl();
        }
        
    }
    
    private class SyncAllNetworksResponseImpl implements SyncAllNetworksResponse {
    }
    
    public SyncAllNetworksRequest syncAllNetworks() {
        return new SyncAllNetworksRequestImpl();
    }
    
    private class UpdateRequestImpl extends BaseRequest<UpdateRequest, UpdateResponse> implements UpdateRequest {
        private Boolean async;
        public UpdateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Cluster cluster;
        public UpdateRequest cluster(Cluster cluster) {
            this.cluster = cluster;
            return this;
        }
        
        public UpdateRequest cluster(ClusterBuilder cluster) {
            this.cluster = cluster.build();
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
                XmlClusterWriter.writeOne(cluster, xmlWriter);
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
                    actionResponse.cluster(XmlClusterReader.readOne(reader));
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
        private Cluster cluster;
        
        public void cluster(Cluster cluster) {
            this.cluster = cluster;
        }
        
        public Cluster cluster() {
            return cluster;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    private class UpgradeRequestImpl extends BaseRequest<UpgradeRequest, UpgradeResponse> implements UpgradeRequest {
        private Boolean async;
        public UpgradeRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private ClusterUpgradeAction upgradeAction;
        public UpgradeRequest upgradeAction(ClusterUpgradeAction upgradeAction) {
            this.upgradeAction = upgradeAction;
            return this;
        }
        
        public UpgradeResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/upgrade");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.upgradeAction(upgradeAction);
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
            return new UpgradeResponseImpl();
        }
        
    }
    
    private class UpgradeResponseImpl implements UpgradeResponse {
    }
    
    public UpgradeRequest upgrade() {
        return new UpgradeRequestImpl();
    }
    
    public AffinityGroupsService affinityGroupsService() {
        return new AffinityGroupsServiceImpl(getConnection(), getPath() + "/affinitygroups");
    }
    
    public AssignedCpuProfilesService cpuProfilesService() {
        return new AssignedCpuProfilesServiceImpl(getConnection(), getPath() + "/cpuprofiles");
    }
    
    public ClusterEnabledFeaturesService enabledFeaturesService() {
        return new ClusterEnabledFeaturesServiceImpl(getConnection(), getPath() + "/enabledfeatures");
    }
    
    public ClusterExternalProvidersService externalNetworkProvidersService() {
        return new ClusterExternalProvidersServiceImpl(getConnection(), getPath() + "/externalnetworkproviders");
    }
    
    public GlusterHooksService glusterHooksService() {
        return new GlusterHooksServiceImpl(getConnection(), getPath() + "/glusterhooks");
    }
    
    public GlusterVolumesService glusterVolumesService() {
        return new GlusterVolumesServiceImpl(getConnection(), getPath() + "/glustervolumes");
    }
    
    public NetworkFiltersService networkFiltersService() {
        return new NetworkFiltersServiceImpl(getConnection(), getPath() + "/networkfilters");
    }
    
    public ClusterNetworksService networksService() {
        return new ClusterNetworksServiceImpl(getConnection(), getPath() + "/networks");
    }
    
    public AssignedPermissionsService permissionsService() {
        return new AssignedPermissionsServiceImpl(getConnection(), getPath() + "/permissions");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("affinitygroups")) {
            return affinityGroupsService();
        }
        if (path.startsWith("affinitygroups/")) {
            return affinityGroupsService().service(path.substring(15));
        }
        if (path.equals("cpuprofiles")) {
            return cpuProfilesService();
        }
        if (path.startsWith("cpuprofiles/")) {
            return cpuProfilesService().service(path.substring(12));
        }
        if (path.equals("enabledfeatures")) {
            return enabledFeaturesService();
        }
        if (path.startsWith("enabledfeatures/")) {
            return enabledFeaturesService().service(path.substring(16));
        }
        if (path.equals("externalnetworkproviders")) {
            return externalNetworkProvidersService();
        }
        if (path.startsWith("externalnetworkproviders/")) {
            return externalNetworkProvidersService().service(path.substring(25));
        }
        if (path.equals("glusterhooks")) {
            return glusterHooksService();
        }
        if (path.startsWith("glusterhooks/")) {
            return glusterHooksService().service(path.substring(13));
        }
        if (path.equals("glustervolumes")) {
            return glusterVolumesService();
        }
        if (path.startsWith("glustervolumes/")) {
            return glusterVolumesService().service(path.substring(15));
        }
        if (path.equals("networkfilters")) {
            return networkFiltersService();
        }
        if (path.startsWith("networkfilters/")) {
            return networkFiltersService().service(path.substring(15));
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
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "ClusterService:" + getPath();
    }
    
}

