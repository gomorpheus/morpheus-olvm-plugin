/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.ovirt.engine.sdk4.builders.AuthorizedKeyBuilder;
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.builders.DiskBuilder;
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.SnapshotBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainLeaseBuilder;
import org.ovirt.engine.sdk4.builders.TicketBuilder;
import org.ovirt.engine.sdk4.builders.VmBuilder;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.xml.XmlActionWriter;
import org.ovirt.engine.sdk4.internal.xml.XmlVmReader;
import org.ovirt.engine.sdk4.internal.xml.XmlVmWriter;
import org.ovirt.engine.sdk4.services.AssignedAffinityLabelsService;
import org.ovirt.engine.sdk4.services.AssignedPermissionsService;
import org.ovirt.engine.sdk4.services.AssignedTagsService;
import org.ovirt.engine.sdk4.services.DiskAttachmentsService;
import org.ovirt.engine.sdk4.services.KatelloErrataService;
import org.ovirt.engine.sdk4.services.SnapshotsService;
import org.ovirt.engine.sdk4.services.StatisticsService;
import org.ovirt.engine.sdk4.services.VmApplicationsService;
import org.ovirt.engine.sdk4.services.VmBackupsService;
import org.ovirt.engine.sdk4.services.VmCdromsService;
import org.ovirt.engine.sdk4.services.VmCheckpointsService;
import org.ovirt.engine.sdk4.services.VmGraphicsConsolesService;
import org.ovirt.engine.sdk4.services.VmHostDevicesService;
import org.ovirt.engine.sdk4.services.VmNicsService;
import org.ovirt.engine.sdk4.services.VmNumaNodesService;
import org.ovirt.engine.sdk4.services.VmReportedDevicesService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmSessionsService;
import org.ovirt.engine.sdk4.services.VmWatchdogsService;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.AuthorizedKey;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageDomainLease;
import org.ovirt.engine.sdk4.types.Ticket;
import org.ovirt.engine.sdk4.types.Vm;

public class VmServiceImpl extends MeasurableServiceImpl implements VmService {
    
    public VmServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    private class AutoPinCpuAndNumaNodesRequestImpl extends BaseRequest<AutoPinCpuAndNumaNodesRequest, AutoPinCpuAndNumaNodesResponse> implements AutoPinCpuAndNumaNodesRequest {
        private Boolean async;
        public AutoPinCpuAndNumaNodesRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean optimizeCpuSettings;
        public AutoPinCpuAndNumaNodesRequest optimizeCpuSettings(Boolean optimizeCpuSettings) {
            this.optimizeCpuSettings = optimizeCpuSettings;
            return this;
        }
        
        public AutoPinCpuAndNumaNodesResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/autopincpuandnumanodes");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.optimizeCpuSettings(optimizeCpuSettings);
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
            return new AutoPinCpuAndNumaNodesResponseImpl();
        }
        
    }
    
    private class AutoPinCpuAndNumaNodesResponseImpl implements AutoPinCpuAndNumaNodesResponse {
    }
    
    public AutoPinCpuAndNumaNodesRequest autoPinCpuAndNumaNodes() {
        return new AutoPinCpuAndNumaNodesRequestImpl();
    }
    
    private class CancelMigrationRequestImpl extends BaseRequest<CancelMigrationRequest, CancelMigrationResponse> implements CancelMigrationRequest {
        private Boolean async;
        public CancelMigrationRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public CancelMigrationResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/cancelmigration");
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
            return new CancelMigrationResponseImpl();
        }
        
    }
    
    private class CancelMigrationResponseImpl implements CancelMigrationResponse {
    }
    
    public CancelMigrationRequest cancelMigration() {
        return new CancelMigrationRequestImpl();
    }
    
    private class CloneRequestImpl extends BaseRequest<CloneRequest, CloneResponse> implements CloneRequest {
        private Boolean async;
        public CloneRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean discardSnapshots;
        public CloneRequest discardSnapshots(Boolean discardSnapshots) {
            this.discardSnapshots = discardSnapshots;
            return this;
        }
        
        private StorageDomain storageDomain;
        public CloneRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public CloneRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        private Vm vm;
        public CloneRequest vm(Vm vm) {
            this.vm = vm;
            return this;
        }
        
        public CloneRequest vm(VmBuilder vm) {
            this.vm = vm.build();
            return this;
        }
        
        public CloneResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/clone");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.discardSnapshots(discardSnapshots);
                action.storageDomain(storageDomain);
                action.vm(vm);
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
            return new CloneResponseImpl();
        }
        
    }
    
    private class CloneResponseImpl implements CloneResponse {
    }
    
    public CloneRequest clone_() {
        return new CloneRequestImpl();
    }
    
    private class CommitSnapshotRequestImpl extends BaseRequest<CommitSnapshotRequest, CommitSnapshotResponse> implements CommitSnapshotRequest {
        private Boolean async;
        public CommitSnapshotRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public CommitSnapshotResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/commitsnapshot");
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
            return new CommitSnapshotResponseImpl();
        }
        
    }
    
    private class CommitSnapshotResponseImpl implements CommitSnapshotResponse {
    }
    
    public CommitSnapshotRequest commitSnapshot() {
        return new CommitSnapshotRequestImpl();
    }
    
    private class DetachRequestImpl extends BaseRequest<DetachRequest, DetachResponse> implements DetachRequest {
        private Boolean async;
        public DetachRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public DetachResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/detach");
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
            return new DetachResponseImpl();
        }
        
    }
    
    private class DetachResponseImpl implements DetachResponse {
    }
    
    public DetachRequest detach() {
        return new DetachRequestImpl();
    }
    
    private class ExportRequestImpl extends BaseRequest<ExportRequest, ExportResponse> implements ExportRequest {
        private Boolean async;
        public ExportRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean discardSnapshots;
        public ExportRequest discardSnapshots(Boolean discardSnapshots) {
            this.discardSnapshots = discardSnapshots;
            return this;
        }
        
        private Boolean exclusive;
        public ExportRequest exclusive(Boolean exclusive) {
            this.exclusive = exclusive;
            return this;
        }
        
        private StorageDomain storageDomain;
        public ExportRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public ExportRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        public ExportResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/export");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.discardSnapshots(discardSnapshots);
                action.exclusive(exclusive);
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
            return new ExportResponseImpl();
        }
        
    }
    
    private class ExportResponseImpl implements ExportResponse {
    }
    
    public ExportRequest export() {
        return new ExportRequestImpl();
    }
    
    private class FreezeFilesystemsRequestImpl extends BaseRequest<FreezeFilesystemsRequest, FreezeFilesystemsResponse> implements FreezeFilesystemsRequest {
        private Boolean async;
        public FreezeFilesystemsRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public FreezeFilesystemsResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/freezefilesystems");
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
            return new FreezeFilesystemsResponseImpl();
        }
        
    }
    
    private class FreezeFilesystemsResponseImpl implements FreezeFilesystemsResponse {
    }
    
    public FreezeFilesystemsRequest freezeFilesystems() {
        return new FreezeFilesystemsRequestImpl();
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
        
        private Boolean nextRun;
        public GetRequest nextRun(Boolean nextRun) {
            this.nextRun = nextRun;
            return this;
        }
        
        private Boolean ovfAsOva;
        public GetRequest ovfAsOva(Boolean ovfAsOva) {
            this.ovfAsOva = ovfAsOva;
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
                if (nextRun != null) {
                    uriBuilder.addParameter("next_run", XmlWriter.renderBoolean(nextRun));
                }
                if (ovfAsOva != null) {
                    uriBuilder.addParameter("ovf_as_ova", XmlWriter.renderBoolean(ovfAsOva));
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
                    actionResponse.vm(XmlVmReader.readOne(reader));
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
        private Vm vm;
        
        public void vm(Vm vm) {
            this.vm = vm;
        }
        
        public Vm vm() {
            return vm;
        }
        
    }
    
    public GetRequest get() {
        return new GetRequestImpl();
    }
    
    private class LogonRequestImpl extends BaseRequest<LogonRequest, LogonResponse> implements LogonRequest {
        private Boolean async;
        public LogonRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public LogonResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/logon");
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
            return new LogonResponseImpl();
        }
        
    }
    
    private class LogonResponseImpl implements LogonResponse {
    }
    
    public LogonRequest logon() {
        return new LogonRequestImpl();
    }
    
    private class MaintenanceRequestImpl extends BaseRequest<MaintenanceRequest, MaintenanceResponse> implements MaintenanceRequest {
        private Boolean async;
        public MaintenanceRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean maintenanceEnabled;
        public MaintenanceRequest maintenanceEnabled(Boolean maintenanceEnabled) {
            this.maintenanceEnabled = maintenanceEnabled;
            return this;
        }
        
        public MaintenanceResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/maintenance");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.maintenanceEnabled(maintenanceEnabled);
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
            return new MaintenanceResponseImpl();
        }
        
    }
    
    private class MaintenanceResponseImpl implements MaintenanceResponse {
    }
    
    public MaintenanceRequest maintenance() {
        return new MaintenanceRequestImpl();
    }
    
    private class MigrateRequestImpl extends BaseRequest<MigrateRequest, MigrateResponse> implements MigrateRequest {
        private Boolean async;
        public MigrateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Cluster cluster;
        public MigrateRequest cluster(Cluster cluster) {
            this.cluster = cluster;
            return this;
        }
        
        public MigrateRequest cluster(ClusterBuilder cluster) {
            this.cluster = cluster.build();
            return this;
        }
        
        private Boolean force;
        public MigrateRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        private Host host;
        public MigrateRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public MigrateRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private Boolean migrateVmsInAffinityClosure;
        public MigrateRequest migrateVmsInAffinityClosure(Boolean migrateVmsInAffinityClosure) {
            this.migrateVmsInAffinityClosure = migrateVmsInAffinityClosure;
            return this;
        }
        
        public MigrateResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/migrate");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.cluster(cluster);
                action.force(force);
                action.host(host);
                action.migrateVmsInAffinityClosure(migrateVmsInAffinityClosure);
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
            return new MigrateResponseImpl();
        }
        
    }
    
    private class MigrateResponseImpl implements MigrateResponse {
    }
    
    public MigrateRequest migrate() {
        return new MigrateRequestImpl();
    }
    
    private class PreviewSnapshotRequestImpl extends BaseRequest<PreviewSnapshotRequest, PreviewSnapshotResponse> implements PreviewSnapshotRequest {
        private Boolean async;
        public PreviewSnapshotRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private List<Disk> disks;
        public PreviewSnapshotRequest disks(List<Disk> disks) {
            this.disks = disks;
            return this;
        }
        
        public PreviewSnapshotRequest disks(Disk... disks) {
            this.disks = Arrays.asList(disks);
            return this;
        }
        
        public PreviewSnapshotRequest disks(DiskBuilder... disks) {
            this.disks = new ArrayList<>(disks.length);
            for (DiskBuilder element : disks) {
                this.disks.add(element.build());
            }
            return this;
        }
        
        private StorageDomainLease lease;
        public PreviewSnapshotRequest lease(StorageDomainLease lease) {
            this.lease = lease;
            return this;
        }
        
        public PreviewSnapshotRequest lease(StorageDomainLeaseBuilder lease) {
            this.lease = lease.build();
            return this;
        }
        
        private Boolean restoreMemory;
        public PreviewSnapshotRequest restoreMemory(Boolean restoreMemory) {
            this.restoreMemory = restoreMemory;
            return this;
        }
        
        private Snapshot snapshot;
        public PreviewSnapshotRequest snapshot(Snapshot snapshot) {
            this.snapshot = snapshot;
            return this;
        }
        
        public PreviewSnapshotRequest snapshot(SnapshotBuilder snapshot) {
            this.snapshot = snapshot.build();
            return this;
        }
        
        private Vm vm;
        public PreviewSnapshotRequest vm(Vm vm) {
            this.vm = vm;
            return this;
        }
        
        public PreviewSnapshotRequest vm(VmBuilder vm) {
            this.vm = vm.build();
            return this;
        }
        
        public PreviewSnapshotResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/previewsnapshot");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.disks(disks);
                action.lease(lease);
                action.restoreMemory(restoreMemory);
                action.snapshot(snapshot);
                action.vm(vm);
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
            return new PreviewSnapshotResponseImpl();
        }
        
    }
    
    private class PreviewSnapshotResponseImpl implements PreviewSnapshotResponse {
    }
    
    public PreviewSnapshotRequest previewSnapshot() {
        return new PreviewSnapshotRequestImpl();
    }
    
    private class RebootRequestImpl extends BaseRequest<RebootRequest, RebootResponse> implements RebootRequest {
        private Boolean async;
        public RebootRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean force;
        public RebootRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        public RebootResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/reboot");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.force(force);
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
            return new RebootResponseImpl();
        }
        
    }
    
    private class RebootResponseImpl implements RebootResponse {
    }
    
    public RebootRequest reboot() {
        return new RebootRequestImpl();
    }
    
    private class RemoveRequestImpl extends BaseRequest<RemoveRequest, RemoveResponse> implements RemoveRequest {
        private Boolean async;
        public RemoveRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean detachOnly;
        public RemoveRequest detachOnly(Boolean detachOnly) {
            this.detachOnly = detachOnly;
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
                if (detachOnly != null) {
                    uriBuilder.addParameter("detach_only", XmlWriter.renderBoolean(detachOnly));
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
    
    private class ReorderMacAddressesRequestImpl extends BaseRequest<ReorderMacAddressesRequest, ReorderMacAddressesResponse> implements ReorderMacAddressesRequest {
        private Boolean async;
        public ReorderMacAddressesRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ReorderMacAddressesResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/reordermacaddresses");
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
            return new ReorderMacAddressesResponseImpl();
        }
        
    }
    
    private class ReorderMacAddressesResponseImpl implements ReorderMacAddressesResponse {
    }
    
    public ReorderMacAddressesRequest reorderMacAddresses() {
        return new ReorderMacAddressesRequestImpl();
    }
    
    private class ResetRequestImpl extends BaseRequest<ResetRequest, ResetResponse> implements ResetRequest {
        private Boolean async;
        public ResetRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ResetResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/reset");
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
            return new ResetResponseImpl();
        }
        
    }
    
    private class ResetResponseImpl implements ResetResponse {
    }
    
    public ResetRequest reset() {
        return new ResetRequestImpl();
    }
    
    private class ShutdownRequestImpl extends BaseRequest<ShutdownRequest, ShutdownResponse> implements ShutdownRequest {
        private Boolean async;
        public ShutdownRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean force;
        public ShutdownRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        private String reason;
        public ShutdownRequest reason(String reason) {
            this.reason = reason;
            return this;
        }
        
        public ShutdownResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/shutdown");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.force(force);
                action.reason(reason);
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
            return new ShutdownResponseImpl();
        }
        
    }
    
    private class ShutdownResponseImpl implements ShutdownResponse {
    }
    
    public ShutdownRequest shutdown() {
        return new ShutdownRequestImpl();
    }
    
    private class StartRequestImpl extends BaseRequest<StartRequest, StartResponse> implements StartRequest {
        private Boolean async;
        public StartRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private AuthorizedKey authorizedKey;
        public StartRequest authorizedKey(AuthorizedKey authorizedKey) {
            this.authorizedKey = authorizedKey;
            return this;
        }
        
        public StartRequest authorizedKey(AuthorizedKeyBuilder authorizedKey) {
            this.authorizedKey = authorizedKey.build();
            return this;
        }
        
        private Boolean filter;
        public StartRequest filter(Boolean filter) {
            this.filter = filter;
            return this;
        }
        
        private Boolean pause;
        public StartRequest pause(Boolean pause) {
            this.pause = pause;
            return this;
        }
        
        private Boolean useCloudInit;
        public StartRequest useCloudInit(Boolean useCloudInit) {
            this.useCloudInit = useCloudInit;
            return this;
        }
        
        private Boolean useIgnition;
        public StartRequest useIgnition(Boolean useIgnition) {
            this.useIgnition = useIgnition;
            return this;
        }
        
        private Boolean useInitialization;
        public StartRequest useInitialization(Boolean useInitialization) {
            this.useInitialization = useInitialization;
            return this;
        }
        
        private Boolean useSysprep;
        public StartRequest useSysprep(Boolean useSysprep) {
            this.useSysprep = useSysprep;
            return this;
        }
        
        private Vm vm;
        public StartRequest vm(Vm vm) {
            this.vm = vm;
            return this;
        }
        
        public StartRequest vm(VmBuilder vm) {
            this.vm = vm.build();
            return this;
        }
        
        private Boolean volatile_;
        public StartRequest volatile_(Boolean volatile_) {
            this.volatile_ = volatile_;
            return this;
        }
        
        public StartResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/start");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.authorizedKey(authorizedKey);
                action.filter(filter);
                action.pause(pause);
                action.useCloudInit(useCloudInit);
                action.useIgnition(useIgnition);
                action.useInitialization(useInitialization);
                action.useSysprep(useSysprep);
                action.vm(vm);
                action.volatile_(volatile_);
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
            return new StartResponseImpl();
        }
        
    }
    
    private class StartResponseImpl implements StartResponse {
    }
    
    public StartRequest start() {
        return new StartRequestImpl();
    }
    
    private class StopRequestImpl extends BaseRequest<StopRequest, StopResponse> implements StopRequest {
        private Boolean async;
        public StopRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean force;
        public StopRequest force(Boolean force) {
            this.force = force;
            return this;
        }
        
        private String reason;
        public StopRequest reason(String reason) {
            this.reason = reason;
            return this;
        }
        
        public StopResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/stop");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.force(force);
                action.reason(reason);
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
            return new StopResponseImpl();
        }
        
    }
    
    private class StopResponseImpl implements StopResponse {
    }
    
    public StopRequest stop() {
        return new StopRequestImpl();
    }
    
    private class SuspendRequestImpl extends BaseRequest<SuspendRequest, SuspendResponse> implements SuspendRequest {
        private Boolean async;
        public SuspendRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public SuspendResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/suspend");
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
            return new SuspendResponseImpl();
        }
        
    }
    
    private class SuspendResponseImpl implements SuspendResponse {
    }
    
    public SuspendRequest suspend() {
        return new SuspendRequestImpl();
    }
    
    private class ThawFilesystemsRequestImpl extends BaseRequest<ThawFilesystemsRequest, ThawFilesystemsResponse> implements ThawFilesystemsRequest {
        private Boolean async;
        public ThawFilesystemsRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public ThawFilesystemsResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/thawfilesystems");
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
            return new ThawFilesystemsResponseImpl();
        }
        
    }
    
    private class ThawFilesystemsResponseImpl implements ThawFilesystemsResponse {
    }
    
    public ThawFilesystemsRequest thawFilesystems() {
        return new ThawFilesystemsRequestImpl();
    }
    
    private class TicketRequestImpl extends BaseRequest<TicketRequest, TicketResponse> implements TicketRequest {
        private Boolean async;
        public TicketRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
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
                action.async(async);
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
    
    private class ExportToExportDomainRequestImpl extends BaseRequest<ExportToExportDomainRequest, ExportToExportDomainResponse> implements ExportToExportDomainRequest {
        private Boolean async;
        public ExportToExportDomainRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean discardSnapshots;
        public ExportToExportDomainRequest discardSnapshots(Boolean discardSnapshots) {
            this.discardSnapshots = discardSnapshots;
            return this;
        }
        
        private Boolean exclusive;
        public ExportToExportDomainRequest exclusive(Boolean exclusive) {
            this.exclusive = exclusive;
            return this;
        }
        
        private StorageDomain storageDomain;
        public ExportToExportDomainRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public ExportToExportDomainRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        public ExportToExportDomainResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/export");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.discardSnapshots(discardSnapshots);
                action.exclusive(exclusive);
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
            return new ExportToExportDomainResponseImpl();
        }
        
    }
    
    private class ExportToExportDomainResponseImpl implements ExportToExportDomainResponse {
    }
    
    public ExportToExportDomainRequest exportToExportDomain() {
        return new ExportToExportDomainRequestImpl();
    }
    
    private class ExportToPathOnHostRequestImpl extends BaseRequest<ExportToPathOnHostRequest, ExportToPathOnHostResponse> implements ExportToPathOnHostRequest {
        private Boolean async;
        public ExportToPathOnHostRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private String directory;
        public ExportToPathOnHostRequest directory(String directory) {
            this.directory = directory;
            return this;
        }
        
        private Boolean discardSnapshots;
        public ExportToPathOnHostRequest discardSnapshots(Boolean discardSnapshots) {
            this.discardSnapshots = discardSnapshots;
            return this;
        }
        
        private Boolean exclusive;
        public ExportToPathOnHostRequest exclusive(Boolean exclusive) {
            this.exclusive = exclusive;
            return this;
        }
        
        private String filename;
        public ExportToPathOnHostRequest filename(String filename) {
            this.filename = filename;
            return this;
        }
        
        private Host host;
        public ExportToPathOnHostRequest host(Host host) {
            this.host = host;
            return this;
        }
        
        public ExportToPathOnHostRequest host(HostBuilder host) {
            this.host = host.build();
            return this;
        }
        
        private StorageDomain storageDomain;
        public ExportToPathOnHostRequest storageDomain(StorageDomain storageDomain) {
            this.storageDomain = storageDomain;
            return this;
        }
        
        public ExportToPathOnHostRequest storageDomain(StorageDomainBuilder storageDomain) {
            this.storageDomain = storageDomain.build();
            return this;
        }
        
        public ExportToPathOnHostResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/export");
            try (
              ByteArrayOutputStream output = new ByteArrayOutputStream();
              XmlWriter xmlWriter = new XmlWriter(output, true)
            ) {
                ActionBuilder action = new ActionBuilder();
                action.async(async);
                action.directory(directory);
                action.discardSnapshots(discardSnapshots);
                action.exclusive(exclusive);
                action.filename(filename);
                action.host(host);
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
            return new ExportToPathOnHostResponseImpl();
        }
        
    }
    
    private class ExportToPathOnHostResponseImpl implements ExportToPathOnHostResponse {
    }
    
    public ExportToPathOnHostRequest exportToPathOnHost() {
        return new ExportToPathOnHostRequestImpl();
    }
    
    private class UndoSnapshotRequestImpl extends BaseRequest<UndoSnapshotRequest, UndoSnapshotResponse> implements UndoSnapshotRequest {
        private Boolean async;
        public UndoSnapshotRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        public UndoSnapshotResponse send() {
            HttpPost request = new HttpPost(getConnection().getUrl() + getPath() + "/undosnapshot");
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
            return new UndoSnapshotResponseImpl();
        }
        
    }
    
    private class UndoSnapshotResponseImpl implements UndoSnapshotResponse {
    }
    
    public UndoSnapshotRequest undoSnapshot() {
        return new UndoSnapshotRequestImpl();
    }
    
    private class UpdateRequestImpl extends BaseRequest<UpdateRequest, UpdateResponse> implements UpdateRequest {
        private Boolean async;
        public UpdateRequest async(Boolean async) {
            this.async = async;
            return this;
        }
        
        private Boolean nextRun;
        public UpdateRequest nextRun(Boolean nextRun) {
            this.nextRun = nextRun;
            return this;
        }
        
        private Vm vm;
        public UpdateRequest vm(Vm vm) {
            this.vm = vm;
            return this;
        }
        
        public UpdateRequest vm(VmBuilder vm) {
            this.vm = vm.build();
            return this;
        }
        
        public UpdateResponse send() {
            HttpPut request = null;
            try {
                URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());
                if (async != null) {
                    uriBuilder.addParameter("async", XmlWriter.renderBoolean(async));
                }
                if (nextRun != null) {
                    uriBuilder.addParameter("next_run", XmlWriter.renderBoolean(nextRun));
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
                XmlVmWriter.writeOne(vm, xmlWriter);
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
                    actionResponse.vm(XmlVmReader.readOne(reader));
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
        private Vm vm;
        
        public void vm(Vm vm) {
            this.vm = vm;
        }
        
        public Vm vm() {
            return vm;
        }
        
    }
    
    public UpdateRequest update() {
        return new UpdateRequestImpl();
    }
    
    public AssignedAffinityLabelsService affinityLabelsService() {
        return new AssignedAffinityLabelsServiceImpl(getConnection(), getPath() + "/affinitylabels");
    }
    
    public VmApplicationsService applicationsService() {
        return new VmApplicationsServiceImpl(getConnection(), getPath() + "/applications");
    }
    
    public VmBackupsService backupsService() {
        return new VmBackupsServiceImpl(getConnection(), getPath() + "/backups");
    }
    
    public VmCdromsService cdromsService() {
        return new VmCdromsServiceImpl(getConnection(), getPath() + "/cdroms");
    }
    
    public VmCheckpointsService checkpointsService() {
        return new VmCheckpointsServiceImpl(getConnection(), getPath() + "/checkpoints");
    }
    
    public DiskAttachmentsService diskAttachmentsService() {
        return new DiskAttachmentsServiceImpl(getConnection(), getPath() + "/diskattachments");
    }
    
    public VmGraphicsConsolesService graphicsConsolesService() {
        return new VmGraphicsConsolesServiceImpl(getConnection(), getPath() + "/graphicsconsoles");
    }
    
    public VmHostDevicesService hostDevicesService() {
        return new VmHostDevicesServiceImpl(getConnection(), getPath() + "/hostdevices");
    }
    
    public KatelloErrataService katelloErrataService() {
        return new KatelloErrataServiceImpl(getConnection(), getPath() + "/katelloerrata");
    }
    
    public VmNicsService nicsService() {
        return new VmNicsServiceImpl(getConnection(), getPath() + "/nics");
    }
    
    public VmNumaNodesService numaNodesService() {
        return new VmNumaNodesServiceImpl(getConnection(), getPath() + "/numanodes");
    }
    
    public AssignedPermissionsService permissionsService() {
        return new AssignedPermissionsServiceImpl(getConnection(), getPath() + "/permissions");
    }
    
    public VmReportedDevicesService reportedDevicesService() {
        return new VmReportedDevicesServiceImpl(getConnection(), getPath() + "/reporteddevices");
    }
    
    public VmSessionsService sessionsService() {
        return new VmSessionsServiceImpl(getConnection(), getPath() + "/sessions");
    }
    
    public SnapshotsService snapshotsService() {
        return new SnapshotsServiceImpl(getConnection(), getPath() + "/snapshots");
    }
    
    public StatisticsService statisticsService() {
        return new StatisticsServiceImpl(getConnection(), getPath() + "/statistics");
    }
    
    public AssignedTagsService tagsService() {
        return new AssignedTagsServiceImpl(getConnection(), getPath() + "/tags");
    }
    
    public VmWatchdogsService watchdogsService() {
        return new VmWatchdogsServiceImpl(getConnection(), getPath() + "/watchdogs");
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
        if (path.equals("applications")) {
            return applicationsService();
        }
        if (path.startsWith("applications/")) {
            return applicationsService().service(path.substring(13));
        }
        if (path.equals("backups")) {
            return backupsService();
        }
        if (path.startsWith("backups/")) {
            return backupsService().service(path.substring(8));
        }
        if (path.equals("cdroms")) {
            return cdromsService();
        }
        if (path.startsWith("cdroms/")) {
            return cdromsService().service(path.substring(7));
        }
        if (path.equals("checkpoints")) {
            return checkpointsService();
        }
        if (path.startsWith("checkpoints/")) {
            return checkpointsService().service(path.substring(12));
        }
        if (path.equals("diskattachments")) {
            return diskAttachmentsService();
        }
        if (path.startsWith("diskattachments/")) {
            return diskAttachmentsService().service(path.substring(16));
        }
        if (path.equals("graphicsconsoles")) {
            return graphicsConsolesService();
        }
        if (path.startsWith("graphicsconsoles/")) {
            return graphicsConsolesService().service(path.substring(17));
        }
        if (path.equals("hostdevices")) {
            return hostDevicesService();
        }
        if (path.startsWith("hostdevices/")) {
            return hostDevicesService().service(path.substring(12));
        }
        if (path.equals("katelloerrata")) {
            return katelloErrataService();
        }
        if (path.startsWith("katelloerrata/")) {
            return katelloErrataService().service(path.substring(14));
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
        if (path.equals("reporteddevices")) {
            return reportedDevicesService();
        }
        if (path.startsWith("reporteddevices/")) {
            return reportedDevicesService().service(path.substring(16));
        }
        if (path.equals("sessions")) {
            return sessionsService();
        }
        if (path.startsWith("sessions/")) {
            return sessionsService().service(path.substring(9));
        }
        if (path.equals("snapshots")) {
            return snapshotsService();
        }
        if (path.startsWith("snapshots/")) {
            return snapshotsService().service(path.substring(10));
        }
        if (path.equals("statistics")) {
            return statisticsService();
        }
        if (path.startsWith("statistics/")) {
            return statisticsService().service(path.substring(11));
        }
        if (path.equals("tags")) {
            return tagsService();
        }
        if (path.startsWith("tags/")) {
            return tagsService().service(path.substring(5));
        }
        if (path.equals("watchdogs")) {
            return watchdogsService();
        }
        if (path.startsWith("watchdogs/")) {
            return watchdogsService().service(path.substring(10));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "VmService:" + getPath();
    }
    
}

