/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.String;
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
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.HostNicBuilder;
import org.ovirt.engine.sdk4.builders.IscsiDetailsBuilder;
import org.ovirt.engine.sdk4.builders.NetworkAttachmentBuilder;
import org.ovirt.engine.sdk4.builders.NetworkLabelBuilder;
import org.ovirt.engine.sdk4.builders.SshBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlHostReader;
import org.ovirt.engine.sdk4.internal.xml.XmlHostWriter;
import org.ovirt.engine.sdk4.services.AssignedAffinityLabelsService;
import org.ovirt.engine.sdk4.services.AssignedPermissionsService;
import org.ovirt.engine.sdk4.services.AssignedTagsService;
import org.ovirt.engine.sdk4.services.ExternalNetworkProviderConfigurationsService;
import org.ovirt.engine.sdk4.services.FenceAgentsService;
import org.ovirt.engine.sdk4.services.HostDevicesService;
import org.ovirt.engine.sdk4.services.HostHooksService;
import org.ovirt.engine.sdk4.services.HostNicsService;
import org.ovirt.engine.sdk4.services.HostNumaNodesService;
import org.ovirt.engine.sdk4.services.HostService;
import org.ovirt.engine.sdk4.services.HostStorageService;
import org.ovirt.engine.sdk4.services.KatelloErrataService;
import org.ovirt.engine.sdk4.services.NetworkAttachmentsService;
import org.ovirt.engine.sdk4.services.StatisticsService;
import org.ovirt.engine.sdk4.services.StorageServerConnectionExtensionsService;
import org.ovirt.engine.sdk4.services.UnmanagedNetworksService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.IscsiDetails;
import org.ovirt.engine.sdk4.types.NetworkAttachment;
import org.ovirt.engine.sdk4.types.NetworkLabel;
import org.ovirt.engine.sdk4.types.PowerManagement;
import org.ovirt.engine.sdk4.types.Ssh;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class HostServiceImpl extends MeasurableServiceImpl implements HostService {
    
    public HostServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class ActivateRequestImpl extends BaseRequest<ActivateRequest, ActivateResponse> implements ActivateRequest {
        private Boolean async;
        public ActivateRequest async(Boolean async) {
            this.async = async;
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
    
    private class ApproveRequestImpl extends BaseRequest<ApproveRequest, ApproveResponse> implements ApproveRequest {
        private Boolean activate;
        public ApproveRequest activate(Boolean activate) {
            this.activate = activate;
            return this;
        }
        
        private Boolean async;
        public ApproveRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Cluster cluster;
        public ApproveRequest cluster(Cluster cluster) {
            this.cluster = cluster;
            return this;
        }
        
        public ApproveRequest cluster(ClusterBuilder cluster) {
            this.cluster = cluster.build();
            return this;
        }
        
        private Host host;
        public ApproveRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public ApproveRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private Boolean reboot;
        public ApproveRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        public ApproveResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/approve");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.activate(activate);
                action.async(async);
                action.cluster(cluster);
                action.host(host);
                action.reboot(reboot);
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
            return new ApproveResponseImpl();
        }
        
    }
    
    private class ApproveResponseImpl implements ApproveResponse {
    }
    
    public ApproveRequest approve() {
        return new ApproveRequestImpl();
    }
    
    private class CommitNetConfigRequestImpl extends BaseRequest<CommitNetConfigRequest, CommitNetConfigResponse> implements CommitNetConfigRequest {
        private Boolean async;
        public CommitNetConfigRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public CommitNetConfigResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/commitnetconfig");
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
            return new CommitNetConfigResponseImpl();
        }
        
    }
    
    private class CommitNetConfigResponseImpl implements CommitNetConfigResponse {
    }
    
    public CommitNetConfigRequest commitNetConfig() {
        return new CommitNetConfigRequestImpl();
    }
    
    private class CopyHostNetworksRequestImpl extends BaseRequest<CopyHostNetworksRequest, CopyHostNetworksResponse> implements CopyHostNetworksRequest {
        private Boolean async;
        public CopyHostNetworksRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Host sourceHost;
        public CopyHostNetworksRequest sourceHost(Host sourceHost) {
            this.sourceHost = sourceHost;
            return this;
        }
        
        public CopyHostNetworksRequest sourceHost(HostBuilder sourceHost) {
            this.sourceHost = sourceHost.build();
            return this;
        }
        
        public CopyHostNetworksResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/copyhostnetworks");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.sourceHost(sourceHost);
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
            return new CopyHostNetworksResponseImpl();
        }
        
    }
    
    private class CopyHostNetworksResponseImpl implements CopyHostNetworksResponse {
    }
    
    public CopyHostNetworksRequest copyHostNetworks() {
        return new CopyHostNetworksRequestImpl();
    }
    
    private class DeactivateRequestImpl extends BaseRequest<DeactivateRequest, DeactivateResponse> implements DeactivateRequest {
        private Boolean async;
        public DeactivateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private String reason;
        public DeactivateRequest reason(String reason) {
            this.reason = reason;
            return this;
        }
        
        private Boolean stopGlusterService;
        public DeactivateRequest stopGlusterService(Boolean stopGlusterService) {
            this.stopGlusterService = stopGlusterService;
            return this;
        }
        
        public DeactivateResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/deactivate");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.reason(reason);
                action.stopGlusterService(stopGlusterService);
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
            return new DeactivateResponseImpl();
        }
        
    }
    
    private class DeactivateResponseImpl implements DeactivateResponse {
    }
    
    public DeactivateRequest deactivate() {
        return new DeactivateRequestImpl();
    }
    
    private class DiscoverIscsiRequestImpl extends BaseRequest<DiscoverIscsiRequest, DiscoverIscsiResponse> implements DiscoverIscsiRequest {
        private Boolean async;
        public DiscoverIscsiRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private IscsiDetails iscsi;
        public DiscoverIscsiRequest iscsi(IscsiDetails iscsi) {
            this.iscsi = iscsi;
            return this;
        }
        
        public DiscoverIscsiRequest iscsi(IscsiDetailsBuilder iscsi) {
            this.iscsi = iscsi.build();
            return this;
        }
        
        public DiscoverIscsiResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/discoveriscsi");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.iscsi(iscsi);
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
            DiscoverIscsiResponseImpl actionResponse = new DiscoverIscsiResponseImpl();
            actionResponse.discoveredTargets(action.discoveredTargets());
            return actionResponse;
        }
        
    }
    
    private class DiscoverIscsiResponseImpl implements DiscoverIscsiResponse {
        private List<IscsiDetails> discoveredTargets;
        
        public void discoveredTargets(List<IscsiDetails> discoveredTargets) {
            this.discoveredTargets = discoveredTargets;
        }
        
        public List<IscsiDetails> discoveredTargets() {
            return discoveredTargets;
        }
        
    }
    
    public DiscoverIscsiRequest discoverIscsi() {
        return new DiscoverIscsiRequestImpl();
    }
    
    private class EnrollCertificateRequestImpl extends BaseRequest<EnrollCertificateRequest, EnrollCertificateResponse> implements EnrollCertificateRequest {
        private Boolean async;
        public EnrollCertificateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public EnrollCertificateResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/enrollcertificate");
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
            return new EnrollCertificateResponseImpl();
        }
        
    }
    
    private class EnrollCertificateResponseImpl implements EnrollCertificateResponse {
    }
    
    public EnrollCertificateRequest enrollCertificate() {
        return new EnrollCertificateRequestImpl();
    }
    
    private class FenceRequestImpl extends BaseRequest<FenceRequest, FenceResponse> implements FenceRequest {
        private Boolean async;
        public FenceRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private String fenceType;
        public FenceRequest fenceType(String fenceType) {
            this.fenceType = fenceType;
            return this;
        }
        
        private Boolean maintenanceAfterRestart;
        public FenceRequest maintenanceAfterRestart(Boolean maintenanceAfterRestart) {
            this.maintenanceAfterRestart = maintenanceAfterRestart;
            return this;
        }
        
        public FenceResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/fence");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.fenceType(fenceType);
                action.maintenanceAfterRestart(maintenanceAfterRestart);
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
            FenceResponseImpl actionResponse = new FenceResponseImpl();
            actionResponse.powerManagement(action.powerManagement());
            return actionResponse;
        }
        
    }
    
    private class FenceResponseImpl implements FenceResponse {
        private PowerManagement powerManagement;
        
        public void powerManagement(PowerManagement powerManagement) {
            this.powerManagement = powerManagement;
        }
        
        public PowerManagement powerManagement() {
            return powerManagement;
        }
        
    }
    
    public FenceRequest fence() {
        return new FenceRequestImpl();
    }
    
    private class ForceSelectSpmRequestImpl extends BaseRequest<ForceSelectSpmRequest, ForceSelectSpmResponse> implements ForceSelectSpmRequest {
        private Boolean async;
        public ForceSelectSpmRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ForceSelectSpmResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/forceselectspm");
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
            return new ForceSelectSpmResponseImpl();
        }
        
    }
    
    private class ForceSelectSpmResponseImpl implements ForceSelectSpmResponse {
    }
    
    public ForceSelectSpmRequest forceSelectSpm() {
        return new ForceSelectSpmRequestImpl();
    }
    
    private class GetRequestImpl extends BaseRequest<GetRequest, GetResponse> implements GetRequest {
        private Boolean allContent;
        public GetRequest allContent(Boolean allContent) {
            this.allContent = allContent;
            return this;
        }
        
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
                if (allContent != null) {
                    uriBuilder.addParameter("all_content", XmlWriter.renderBoolean(allContent));
                }
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
                return new GetResponseImpl();
            }
        }
        
    }
    
    private class GetResponseImpl implements GetResponse {
        private Host host;
        
        public void host(Host host) {
            this.host = host;
        }
        
        public Host host() {
            return host;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class InstallRequestImpl extends BaseRequest<InstallRequest, InstallResponse> implements InstallRequest {
        private Boolean activate;
        public InstallRequest activate(Boolean activate) {
            this.activate = activate;
            return this;
        }
        
        private Boolean async;
        public InstallRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean deployHostedEngine;
        public InstallRequest deployHostedEngine(Boolean deployHostedEngine) {
            this.deployHostedEngine = deployHostedEngine;
            return this;
        }
        
        private Host host;
        public InstallRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public InstallRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private String image;
        public InstallRequest image(String image) {
            this.image = image;
            return this;
        }
        
        private Boolean reboot;
        public InstallRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        private String rootPassword;
        public InstallRequest rootPassword(String rootPassword) {
            this.rootPassword = rootPassword;
            return this;
        }
        
        private Ssh ssh;
        public InstallRequest ssh(Ssh ssh) {
            this.ssh = ssh;
            return this;
        }
        
        public InstallRequest ssh(SshBuilder ssh) {
            this.ssh = ssh.build();
            return this;
        }
        
        private Boolean undeployHostedEngine;
        public InstallRequest undeployHostedEngine(Boolean undeployHostedEngine) {
            this.undeployHostedEngine = undeployHostedEngine;
            return this;
        }
        
        public InstallResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/install");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.activate(activate);
                action.async(async);
                action.deployHostedEngine(deployHostedEngine);
                action.host(host);
                action.image(image);
                action.reboot(reboot);
                action.rootPassword(rootPassword);
                action.ssh(ssh);
                action.undeployHostedEngine(undeployHostedEngine);
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
            return new InstallResponseImpl();
        }
        
    }
    
    private class InstallResponseImpl implements InstallResponse {
    }
    
    public InstallRequest install() {
        return new InstallRequestImpl();
    }
    
    private class IscsiDiscoverRequestImpl extends BaseRequest<IscsiDiscoverRequest, IscsiDiscoverResponse> implements IscsiDiscoverRequest {
        private Boolean async;
        public IscsiDiscoverRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private IscsiDetails iscsi;
        public IscsiDiscoverRequest iscsi(IscsiDetails iscsi) {
            this.iscsi = iscsi;
            return this;
        }
        
        public IscsiDiscoverRequest iscsi(IscsiDetailsBuilder iscsi) {
            this.iscsi = iscsi.build();
            return this;
        }
        
        public IscsiDiscoverResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/iscsidiscover");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.iscsi(iscsi);
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
            IscsiDiscoverResponseImpl actionResponse = new IscsiDiscoverResponseImpl();
            actionResponse.iscsiTargets(action.iscsiTargets());
            return actionResponse;
        }
        
    }
    
    private class IscsiDiscoverResponseImpl implements IscsiDiscoverResponse {
        private List<String> iscsiTargets;
        
        public void iscsiTargets(List<String> iscsiTargets) {
            this.iscsiTargets = iscsiTargets;
        }
        
        public List<String> iscsiTargets() {
            return iscsiTargets;
        }
        
    }
    
    public IscsiDiscoverRequest iscsiDiscover() {
        return new IscsiDiscoverRequestImpl();
    }
    
    private class IscsiLoginRequestImpl extends BaseRequest<IscsiLoginRequest, IscsiLoginResponse> implements IscsiLoginRequest {
        private Boolean async;
        public IscsiLoginRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private IscsiDetails iscsi;
        public IscsiLoginRequest iscsi(IscsiDetails iscsi) {
            this.iscsi = iscsi;
            return this;
        }
        
        public IscsiLoginRequest iscsi(IscsiDetailsBuilder iscsi) {
            this.iscsi = iscsi.build();
            return this;
        }
        
        public IscsiLoginResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/iscsilogin");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.iscsi(iscsi);
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
            return new IscsiLoginResponseImpl();
        }
        
    }
    
    private class IscsiLoginResponseImpl implements IscsiLoginResponse {
    }
    
    public IscsiLoginRequest iscsiLogin() {
        return new IscsiLoginRequestImpl();
    }
    
    private class RefreshRequestImpl extends BaseRequest<RefreshRequest, RefreshResponse> implements RefreshRequest {
        private Boolean async;
        public RefreshRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public RefreshResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/refresh");
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
            return new RefreshResponseImpl();
        }
        
    }
    
    private class RefreshResponseImpl implements RefreshResponse {
    }
    
    public RefreshRequest refresh() {
        return new RefreshRequestImpl();
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
    
    private class SetupNetworksRequestImpl extends BaseRequest<SetupNetworksRequest, SetupNetworksResponse> implements SetupNetworksRequest {
        private Boolean async;
        public SetupNetworksRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean checkConnectivity;
        public SetupNetworksRequest checkConnectivity(Boolean checkConnectivity) {
            this.checkConnectivity = checkConnectivity;
            return this;
        }
        
        private Boolean commitOnSuccess;
        public SetupNetworksRequest commitOnSuccess(Boolean commitOnSuccess) {
            this.commitOnSuccess = commitOnSuccess;
            return this;
        }
        
        private BigInteger connectivityTimeout;
        public SetupNetworksRequest connectivityTimeout(BigInteger connectivityTimeout) {
            this.connectivityTimeout = connectivityTimeout;
            return this;
        }
        
        public SetupNetworksRequest connectivityTimeout(Integer connectivityTimeout) {
            this.connectivityTimeout = BigInteger.valueOf(connectivityTimeout);
            return this;
        }
        
        public SetupNetworksRequest connectivityTimeout(Long connectivityTimeout) {
            this.connectivityTimeout = BigInteger.valueOf(connectivityTimeout);
            return this;
        }
        
        private List<HostNic> modifiedBonds;
        public SetupNetworksRequest modifiedBonds(List<HostNic> modifiedBonds) {
            this.modifiedBonds = modifiedBonds;
            return this;
        }
        
        public SetupNetworksRequest modifiedBonds(HostNic... modifiedBonds) {
            this.modifiedBonds = Arrays.asList(modifiedBonds);
            return this;
        }
        
        public SetupNetworksRequest modifiedBonds(HostNicBuilder... modifiedBonds) {
            this.modifiedBonds = new ArrayList<>(modifiedBonds.length);
            for (HostNicBuilder element : modifiedBonds) {
                this.modifiedBonds.add(element.build());
            }
            return this;
        }
        
        private List<NetworkLabel> modifiedLabels;
        public SetupNetworksRequest modifiedLabels(List<NetworkLabel> modifiedLabels) {
            this.modifiedLabels = modifiedLabels;
            return this;
        }
        
        public SetupNetworksRequest modifiedLabels(NetworkLabel... modifiedLabels) {
            this.modifiedLabels = Arrays.asList(modifiedLabels);
            return this;
        }
        
        public SetupNetworksRequest modifiedLabels(NetworkLabelBuilder... modifiedLabels) {
            this.modifiedLabels = new ArrayList<>(modifiedLabels.length);
            for (NetworkLabelBuilder element : modifiedLabels) {
                this.modifiedLabels.add(element.build());
            }
            return this;
        }
        
        private List<NetworkAttachment> modifiedNetworkAttachments;
        public SetupNetworksRequest modifiedNetworkAttachments(List<NetworkAttachment> modifiedNetworkAttachments) {
            this.modifiedNetworkAttachments = modifiedNetworkAttachments;
            return this;
        }
        
        public SetupNetworksRequest modifiedNetworkAttachments(NetworkAttachment... modifiedNetworkAttachments) {
            this.modifiedNetworkAttachments = Arrays.asList(modifiedNetworkAttachments);
            return this;
        }
        
        public SetupNetworksRequest modifiedNetworkAttachments(NetworkAttachmentBuilder... modifiedNetworkAttachments) {
            this.modifiedNetworkAttachments = new ArrayList<>(modifiedNetworkAttachments.length);
            for (NetworkAttachmentBuilder element : modifiedNetworkAttachments) {
                this.modifiedNetworkAttachments.add(element.build());
            }
            return this;
        }
        
        private List<HostNic> removedBonds;
        public SetupNetworksRequest removedBonds(List<HostNic> removedBonds) {
            this.removedBonds = removedBonds;
            return this;
        }
        
        public SetupNetworksRequest removedBonds(HostNic... removedBonds) {
            this.removedBonds = Arrays.asList(removedBonds);
            return this;
        }
        
        public SetupNetworksRequest removedBonds(HostNicBuilder... removedBonds) {
            this.removedBonds = new ArrayList<>(removedBonds.length);
            for (HostNicBuilder element : removedBonds) {
                this.removedBonds.add(element.build());
            }
            return this;
        }
        
        private List<NetworkLabel> removedLabels;
        public SetupNetworksRequest removedLabels(List<NetworkLabel> removedLabels) {
            this.removedLabels = removedLabels;
            return this;
        }
        
        public SetupNetworksRequest removedLabels(NetworkLabel... removedLabels) {
            this.removedLabels = Arrays.asList(removedLabels);
            return this;
        }
        
        public SetupNetworksRequest removedLabels(NetworkLabelBuilder... removedLabels) {
            this.removedLabels = new ArrayList<>(removedLabels.length);
            for (NetworkLabelBuilder element : removedLabels) {
                this.removedLabels.add(element.build());
            }
            return this;
        }
        
        private List<NetworkAttachment> removedNetworkAttachments;
        public SetupNetworksRequest removedNetworkAttachments(List<NetworkAttachment> removedNetworkAttachments) {
            this.removedNetworkAttachments = removedNetworkAttachments;
            return this;
        }
        
        public SetupNetworksRequest removedNetworkAttachments(NetworkAttachment... removedNetworkAttachments) {
            this.removedNetworkAttachments = Arrays.asList(removedNetworkAttachments);
            return this;
        }
        
        public SetupNetworksRequest removedNetworkAttachments(NetworkAttachmentBuilder... removedNetworkAttachments) {
            this.removedNetworkAttachments = new ArrayList<>(removedNetworkAttachments.length);
            for (NetworkAttachmentBuilder element : removedNetworkAttachments) {
                this.removedNetworkAttachments.add(element.build());
            }
            return this;
        }
        
        private List<NetworkAttachment> synchronizedNetworkAttachments;
        public SetupNetworksRequest synchronizedNetworkAttachments(List<NetworkAttachment> synchronizedNetworkAttachments) {
            this.synchronizedNetworkAttachments = synchronizedNetworkAttachments;
            return this;
        }
        
        public SetupNetworksRequest synchronizedNetworkAttachments(NetworkAttachment... synchronizedNetworkAttachments) {
            this.synchronizedNetworkAttachments = Arrays.asList(synchronizedNetworkAttachments);
            return this;
        }
        
        public SetupNetworksRequest synchronizedNetworkAttachments(NetworkAttachmentBuilder... synchronizedNetworkAttachments) {
            this.synchronizedNetworkAttachments = new ArrayList<>(synchronizedNetworkAttachments.length);
            for (NetworkAttachmentBuilder element : synchronizedNetworkAttachments) {
                this.synchronizedNetworkAttachments.add(element.build());
            }
            return this;
        }
        
        public SetupNetworksResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/setupnetworks");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.checkConnectivity(checkConnectivity);
                action.commitOnSuccess(commitOnSuccess);
                action.connectivityTimeout(connectivityTimeout);
                action.modifiedBonds(modifiedBonds);
                action.modifiedLabels(modifiedLabels);
                action.modifiedNetworkAttachments(modifiedNetworkAttachments);
                action.removedBonds(removedBonds);
                action.removedLabels(removedLabels);
                action.removedNetworkAttachments(removedNetworkAttachments);
                action.synchronizedNetworkAttachments(synchronizedNetworkAttachments);
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
            return new SetupNetworksResponseImpl();
        }
        
    }
    
    private class SetupNetworksResponseImpl implements SetupNetworksResponse {
    }
    
    public SetupNetworksRequest setupNetworks() {
        return new SetupNetworksRequestImpl();
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
    
    private class UnregisteredStorageDomainsDiscoverRequestImpl extends BaseRequest<UnregisteredStorageDomainsDiscoverRequest, UnregisteredStorageDomainsDiscoverResponse> implements UnregisteredStorageDomainsDiscoverRequest {
        private Boolean async;
        public UnregisteredStorageDomainsDiscoverRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private IscsiDetails iscsi;
        public UnregisteredStorageDomainsDiscoverRequest iscsi(IscsiDetails iscsi) {
            this.iscsi = iscsi;
            return this;
        }
        
        public UnregisteredStorageDomainsDiscoverRequest iscsi(IscsiDetailsBuilder iscsi) {
            this.iscsi = iscsi.build();
            return this;
        }
        
        public UnregisteredStorageDomainsDiscoverResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/unregisteredstoragedomainsdiscover");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.iscsi(iscsi);
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
            UnregisteredStorageDomainsDiscoverResponseImpl actionResponse = new UnregisteredStorageDomainsDiscoverResponseImpl();
            actionResponse.storageDomains(action.storageDomains());
            return actionResponse;
        }
        
    }
    
    private class UnregisteredStorageDomainsDiscoverResponseImpl implements UnregisteredStorageDomainsDiscoverResponse {
        private List<StorageDomain> storageDomains;
        
        public void storageDomains(List<StorageDomain> storageDomains) {
            this.storageDomains = storageDomains;
        }
        
        public List<StorageDomain> storageDomains() {
            return storageDomains;
        }
        
    }
    
    public UnregisteredStorageDomainsDiscoverRequest unregisteredStorageDomainsDiscover() {
        return new UnregisteredStorageDomainsDiscoverRequestImpl();
    }
    
    private class UpdateRequestImpl extends BaseRequest<UpdateRequest, UpdateResponse> implements UpdateRequest {
        private Boolean async;
        public UpdateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Host host;
        public UpdateRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public UpdateRequest host(HostBuilder host) {
            this.host = host.build();
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
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    UpdateResponseImpl actionResponse = new UpdateResponseImpl();
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
                return new UpdateResponseImpl();
            }
        }
        
    }
    
    private class UpdateResponseImpl implements UpdateResponse {
        private Host host;
        
        public void host(Host host) {
            this.host = host;
        }
        
        public Host host() {
            return host;
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
        
        private String image;
        public UpgradeRequest image(String image) {
            this.image = image;
            return this;
        }
        
        private Boolean reboot;
        public UpgradeRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        private BigInteger timeout;
        public UpgradeRequest timeout(BigInteger timeout) {
            this.timeout = timeout;
            return this;
        }
        
        public UpgradeRequest timeout(Integer timeout) {
            this.timeout = BigInteger.valueOf(timeout);
            return this;
        }
        
        public UpgradeRequest timeout(Long timeout) {
            this.timeout = BigInteger.valueOf(timeout);
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
                action.image(image);
                action.reboot(reboot);
                action.timeout(timeout);
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
    
    private class UpgradeCheckRequestImpl extends BaseRequest<UpgradeCheckRequest, UpgradeCheckResponse> implements UpgradeCheckRequest {
        public UpgradeCheckResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/upgradecheck");
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
            return new UpgradeCheckResponseImpl();
        }
        
    }
    
    private class UpgradeCheckResponseImpl implements UpgradeCheckResponse {
    }
    
    public UpgradeCheckRequest upgradeCheck() {
        return new UpgradeCheckRequestImpl();
    }
    
    private class ApproveUsingRootPasswordRequestImpl extends BaseRequest<ApproveUsingRootPasswordRequest, ApproveUsingRootPasswordResponse> implements ApproveUsingRootPasswordRequest {
        private Boolean activate;
        public ApproveUsingRootPasswordRequest activate(Boolean activate) {
            this.activate = activate;
            return this;
        }
        
        private Boolean async;
        public ApproveUsingRootPasswordRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Cluster cluster;
        public ApproveUsingRootPasswordRequest cluster(Cluster cluster) {
            this.cluster = cluster;
            return this;
        }
        
        public ApproveUsingRootPasswordRequest cluster(ClusterBuilder cluster) {
            this.cluster = cluster.build();
            return this;
        }
        
        private Host host;
        public ApproveUsingRootPasswordRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public ApproveUsingRootPasswordRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private Boolean reboot;
        public ApproveUsingRootPasswordRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        public ApproveUsingRootPasswordResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/approve");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.activate(activate);
                action.async(async);
                action.cluster(cluster);
                action.host(host);
                action.reboot(reboot);
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
            return new ApproveUsingRootPasswordResponseImpl();
        }
        
    }
    
    private class ApproveUsingRootPasswordResponseImpl implements ApproveUsingRootPasswordResponse {
    }
    
    public ApproveUsingRootPasswordRequest approveUsingRootPassword() {
        return new ApproveUsingRootPasswordRequestImpl();
    }
    
    private class InstallUsingRootPasswordRequestImpl extends BaseRequest<InstallUsingRootPasswordRequest, InstallUsingRootPasswordResponse> implements InstallUsingRootPasswordRequest {
        private Boolean activate;
        public InstallUsingRootPasswordRequest activate(Boolean activate) {
            this.activate = activate;
            return this;
        }
        
        private Boolean async;
        public InstallUsingRootPasswordRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean deployHostedEngine;
        public InstallUsingRootPasswordRequest deployHostedEngine(Boolean deployHostedEngine) {
            this.deployHostedEngine = deployHostedEngine;
            return this;
        }
        
        private Host host;
        public InstallUsingRootPasswordRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public InstallUsingRootPasswordRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private String image;
        public InstallUsingRootPasswordRequest image(String image) {
            this.image = image;
            return this;
        }
        
        private Boolean reboot;
        public InstallUsingRootPasswordRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        private String rootPassword;
        public InstallUsingRootPasswordRequest rootPassword(String rootPassword) {
            this.rootPassword = rootPassword;
            return this;
        }
        
        private Ssh ssh;
        public InstallUsingRootPasswordRequest ssh(Ssh ssh) {
            this.ssh = ssh;
            return this;
        }
        
        public InstallUsingRootPasswordRequest ssh(SshBuilder ssh) {
            this.ssh = ssh.build();
            return this;
        }
        
        private Boolean undeployHostedEngine;
        public InstallUsingRootPasswordRequest undeployHostedEngine(Boolean undeployHostedEngine) {
            this.undeployHostedEngine = undeployHostedEngine;
            return this;
        }
        
        public InstallUsingRootPasswordResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/install");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.activate(activate);
                action.async(async);
                action.deployHostedEngine(deployHostedEngine);
                action.host(host);
                action.image(image);
                action.reboot(reboot);
                action.rootPassword(rootPassword);
                action.ssh(ssh);
                action.undeployHostedEngine(undeployHostedEngine);
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
            return new InstallUsingRootPasswordResponseImpl();
        }
        
    }
    
    private class InstallUsingRootPasswordResponseImpl implements InstallUsingRootPasswordResponse {
    }
    
    public InstallUsingRootPasswordRequest installUsingRootPassword() {
        return new InstallUsingRootPasswordRequestImpl();
    }
    
    private class UpdateUsingRootPasswordRequestImpl extends BaseRequest<UpdateUsingRootPasswordRequest, UpdateUsingRootPasswordResponse> implements UpdateUsingRootPasswordRequest {
        private Boolean async;
        public UpdateUsingRootPasswordRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Host host;
        public UpdateUsingRootPasswordRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public UpdateUsingRootPasswordRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        public UpdateUsingRootPasswordResponse send() {
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
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    UpdateUsingRootPasswordResponseImpl actionResponse = new UpdateUsingRootPasswordResponseImpl();
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
                return new UpdateUsingRootPasswordResponseImpl();
            }
        }
        
    }
    
    private class UpdateUsingRootPasswordResponseImpl implements UpdateUsingRootPasswordResponse {
        private Host host;
        
        public void host(Host host) {
            this.host = host;
        }
        
        public Host host() {
            return host;
        }
        
    }
    
    public UpdateUsingRootPasswordRequest updateUsingRootPassword() {
        return new UpdateUsingRootPasswordRequestImpl();
    }
    
    private class ApproveUsingSshRequestImpl extends BaseRequest<ApproveUsingSshRequest, ApproveUsingSshResponse> implements ApproveUsingSshRequest {
        private Boolean activate;
        public ApproveUsingSshRequest activate(Boolean activate) {
            this.activate = activate;
            return this;
        }
        
        private Boolean async;
        public ApproveUsingSshRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Cluster cluster;
        public ApproveUsingSshRequest cluster(Cluster cluster) {
            this.cluster = cluster;
            return this;
        }
        
        public ApproveUsingSshRequest cluster(ClusterBuilder cluster) {
            this.cluster = cluster.build();
            return this;
        }
        
        private Host host;
        public ApproveUsingSshRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public ApproveUsingSshRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private Boolean reboot;
        public ApproveUsingSshRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        public ApproveUsingSshResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/approve");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.activate(activate);
                action.async(async);
                action.cluster(cluster);
                action.host(host);
                action.reboot(reboot);
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
            return new ApproveUsingSshResponseImpl();
        }
        
    }
    
    private class ApproveUsingSshResponseImpl implements ApproveUsingSshResponse {
    }
    
    public ApproveUsingSshRequest approveUsingSsh() {
        return new ApproveUsingSshRequestImpl();
    }
    
    private class InstallUsingSshRequestImpl extends BaseRequest<InstallUsingSshRequest, InstallUsingSshResponse> implements InstallUsingSshRequest {
        private Boolean activate;
        public InstallUsingSshRequest activate(Boolean activate) {
            this.activate = activate;
            return this;
        }
        
        private Boolean async;
        public InstallUsingSshRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean deployHostedEngine;
        public InstallUsingSshRequest deployHostedEngine(Boolean deployHostedEngine) {
            this.deployHostedEngine = deployHostedEngine;
            return this;
        }
        
        private Host host;
        public InstallUsingSshRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public InstallUsingSshRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private String image;
        public InstallUsingSshRequest image(String image) {
            this.image = image;
            return this;
        }
        
        private Boolean reboot;
        public InstallUsingSshRequest reboot(Boolean reboot) {
            this.reboot = reboot;
            return this;
        }
        
        private String rootPassword;
        public InstallUsingSshRequest rootPassword(String rootPassword) {
            this.rootPassword = rootPassword;
            return this;
        }
        
        private Ssh ssh;
        public InstallUsingSshRequest ssh(Ssh ssh) {
            this.ssh = ssh;
            return this;
        }
        
        public InstallUsingSshRequest ssh(SshBuilder ssh) {
            this.ssh = ssh.build();
            return this;
        }
        
        private Boolean undeployHostedEngine;
        public InstallUsingSshRequest undeployHostedEngine(Boolean undeployHostedEngine) {
            this.undeployHostedEngine = undeployHostedEngine;
            return this;
        }
        
        public InstallUsingSshResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/install");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.activate(activate);
                action.async(async);
                action.deployHostedEngine(deployHostedEngine);
                action.host(host);
                action.image(image);
                action.reboot(reboot);
                action.rootPassword(rootPassword);
                action.ssh(ssh);
                action.undeployHostedEngine(undeployHostedEngine);
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
            return new InstallUsingSshResponseImpl();
        }
        
    }
    
    private class InstallUsingSshResponseImpl implements InstallUsingSshResponse {
    }
    
    public InstallUsingSshRequest installUsingSsh() {
        return new InstallUsingSshRequestImpl();
    }
    
    private class UpdateUsingSshRequestImpl extends BaseRequest<UpdateUsingSshRequest, UpdateUsingSshResponse> implements UpdateUsingSshRequest {
        private Boolean async;
        public UpdateUsingSshRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Host host;
        public UpdateUsingSshRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public UpdateUsingSshRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        public UpdateUsingSshResponse send() {
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
            ) {
                try (
                  XmlReader reader = new XmlReader(response.getEntity().getContent())
                ) {
                    UpdateUsingSshResponseImpl actionResponse = new UpdateUsingSshResponseImpl();
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
                return new UpdateUsingSshResponseImpl();
            }
        }
        
    }
    
    private class UpdateUsingSshResponseImpl implements UpdateUsingSshResponse {
        private Host host;
        
        public void host(Host host) {
            this.host = host;
        }
        
        public Host host() {
            return host;
        }
        
    }
    
    public UpdateUsingSshRequest updateUsingSsh() {
        return new UpdateUsingSshRequestImpl();
    }
    
    public AssignedAffinityLabelsService affinityLabelsService() {
        return new AssignedAffinityLabelsServiceImpl(getConnection(), getPath() + "/affinitylabels");
    }
    
    public HostDevicesService devicesService() {
        return new HostDevicesServiceImpl(getConnection(), getPath() + "/devices");
    }
    
    public ExternalNetworkProviderConfigurationsService externalNetworkProviderConfigurationsService() {
        return new ExternalNetworkProviderConfigurationsServiceImpl(getConnection(), getPath() + "/externalnetworkproviderconfigurations");
    }
    
    public FenceAgentsService fenceAgentsService() {
        return new FenceAgentsServiceImpl(getConnection(), getPath() + "/fenceagents");
    }
    
    public HostHooksService hooksService() {
        return new HostHooksServiceImpl(getConnection(), getPath() + "/hooks");
    }
    
    public KatelloErrataService katelloErrataService() {
        return new KatelloErrataServiceImpl(getConnection(), getPath() + "/katelloerrata");
    }
    
    public NetworkAttachmentsService networkAttachmentsService() {
        return new NetworkAttachmentsServiceImpl(getConnection(), getPath() + "/networkattachments");
    }
    
    public HostNicsService nicsService() {
        return new HostNicsServiceImpl(getConnection(), getPath() + "/nics");
    }
    
    public HostNumaNodesService numaNodesService() {
        return new HostNumaNodesServiceImpl(getConnection(), getPath() + "/numanodes");
    }
    
    public AssignedPermissionsService permissionsService() {
        return new AssignedPermissionsServiceImpl(getConnection(), getPath() + "/permissions");
    }
    
    public StatisticsService statisticsService() {
        return new StatisticsServiceImpl(getConnection(), getPath() + "/statistics");
    }
    
    public HostStorageService storageService() {
        return new HostStorageServiceImpl(getConnection(), getPath() + "/storage");
    }
    
    public StorageServerConnectionExtensionsService storageConnectionExtensionsService() {
        return new StorageServerConnectionExtensionsServiceImpl(getConnection(), getPath() + "/storageconnectionextensions");
    }
    
    public AssignedTagsService tagsService() {
        return new AssignedTagsServiceImpl(getConnection(), getPath() + "/tags");
    }
    
    public UnmanagedNetworksService unmanagedNetworksService() {
        return new UnmanagedNetworksServiceImpl(getConnection(), getPath() + "/unmanagednetworks");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("affinitylabels")) {
            return affinityLabelsService();
        }
        if (path.startsWith("affinitylabels/")) {
            return affinityLabelsService().service(path.substring(15));
        }
        if (path.equals("devices")) {
            return devicesService();
        }
        if (path.startsWith("devices/")) {
            return devicesService().service(path.substring(8));
        }
        if (path.equals("externalnetworkproviderconfigurations")) {
            return externalNetworkProviderConfigurationsService();
        }
        if (path.startsWith("externalnetworkproviderconfigurations/")) {
            return externalNetworkProviderConfigurationsService().service(path.substring(38));
        }
        if (path.equals("fenceagents")) {
            return fenceAgentsService();
        }
        if (path.startsWith("fenceagents/")) {
            return fenceAgentsService().service(path.substring(12));
        }
        if (path.equals("hooks")) {
            return hooksService();
        }
        if (path.startsWith("hooks/")) {
            return hooksService().service(path.substring(6));
        }
        if (path.equals("katelloerrata")) {
            return katelloErrataService();
        }
        if (path.startsWith("katelloerrata/")) {
            return katelloErrataService().service(path.substring(14));
        }
        if (path.equals("networkattachments")) {
            return networkAttachmentsService();
        }
        if (path.startsWith("networkattachments/")) {
            return networkAttachmentsService().service(path.substring(19));
        }
        if (path.equals("nics")) {
            return nicsService();
        }
        if (path.startsWith("nics/")) {
            return nicsService().service(path.substring(5));
        }
        if (path.equals("numanodes")) {
            return numaNodesService();
        }
        if (path.startsWith("numanodes/")) {
            return numaNodesService().service(path.substring(10));
        }
        if (path.equals("permissions")) {
            return permissionsService();
        }
        if (path.startsWith("permissions/")) {
            return permissionsService().service(path.substring(12));
        }
        if (path.equals("statistics")) {
            return statisticsService();
        }
        if (path.startsWith("statistics/")) {
            return statisticsService().service(path.substring(11));
        }
        if (path.equals("storage")) {
            return storageService();
        }
        if (path.startsWith("storage/")) {
            return storageService().service(path.substring(8));
        }
        if (path.equals("storageconnectionextensions")) {
            return storageConnectionExtensionsService();
        }
        if (path.startsWith("storageconnectionextensions/")) {
            return storageConnectionExtensionsService().service(path.substring(28));
        }
        if (path.equals("tags")) {
            return tagsService();
        }
        if (path.startsWith("tags/")) {
            return tagsService().service(path.substring(5));
        }
        if (path.equals("unmanagednetworks")) {
            return unmanagedNetworksService();
        }
        if (path.startsWith("unmanagednetworks/")) {
            return unmanagedNetworksService().service(path.substring(18));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "HostService:" + getPath();
    }
    
}

