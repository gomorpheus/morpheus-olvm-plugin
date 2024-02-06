/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.ActionContainer;
import org.ovirt.engine.sdk4.types.Action;
import org.ovirt.engine.sdk4.types.AuthorizedKey;
import org.ovirt.engine.sdk4.types.AutoPinningPolicy;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.ClusterUpgradeAction;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.DiskProfile;
import org.ovirt.engine.sdk4.types.Fault;
import org.ovirt.engine.sdk4.types.GlusterBrick;
import org.ovirt.engine.sdk4.types.GlusterVolumeProfileDetails;
import org.ovirt.engine.sdk4.types.GracePeriod;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.HostNicVirtualFunctionsConfiguration;
import org.ovirt.engine.sdk4.types.ImageTransfer;
import org.ovirt.engine.sdk4.types.IscsiDetails;
import org.ovirt.engine.sdk4.types.Job;
import org.ovirt.engine.sdk4.types.LogicalUnit;
import org.ovirt.engine.sdk4.types.NetworkAttachment;
import org.ovirt.engine.sdk4.types.NetworkLabel;
import org.ovirt.engine.sdk4.types.Option;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.PowerManagement;
import org.ovirt.engine.sdk4.types.ProxyTicket;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.RegistrationConfiguration;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.Ssh;
import org.ovirt.engine.sdk4.types.StorageConnection;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageDomainLease;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Ticket;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VnicProfileMapping;

public class ActionBuilder {
    private Boolean activate;
    private Boolean allowPartialImport;
    private Boolean async;
    private DiskAttachment attachment;
    private AuthorizedKey authorizedKey;
    private AutoPinningPolicy autoPinningPolicy;
    private List<GlusterBrick> bricks;
    private List<Certificate> certificates;
    private Boolean checkConnectivity;
    private Boolean clone_;
    private Boolean clonePermissions;
    private Cluster cluster;
    private Boolean collapseSnapshots;
    private String comment;
    private Boolean commitOnSuccess;
    private StorageConnection connection;
    private BigInteger connectivityTimeout;
    private DataCenter dataCenter;
    private Boolean deployHostedEngine;
    private String description;
    private GlusterVolumeProfileDetails details;
    private String directory;
    private Boolean discardSnapshots;
    private List<IscsiDetails> discoveredTargets;
    private Disk disk;
    private DiskProfile diskProfile;
    private List<Disk> disks;
    private Boolean exclusive;
    private Fault fault;
    private String fenceType;
    private String filename;
    private Boolean filter;
    private Boolean fixLayout;
    private Boolean force;
    private GracePeriod gracePeriod;
    private Host host;
    private String href;
    private String id;
    private String image;
    private ImageTransfer imageTransfer;
    private Boolean importAsTemplate;
    private Boolean isAttached;
    private IscsiDetails iscsi;
    private List<String> iscsiTargets;
    private Job job;
    private StorageDomainLease lease;
    private List<LogicalUnit> logicalUnits;
    private Boolean maintenanceAfterRestart;
    private Boolean maintenanceEnabled;
    private Boolean migrateVmsInAffinityClosure;
    private List<HostNic> modifiedBonds;
    private List<NetworkLabel> modifiedLabels;
    private List<NetworkAttachment> modifiedNetworkAttachments;
    private String name;
    private Boolean optimizeCpuSettings;
    private Option option;
    private Boolean pause;
    private Permission permission;
    private PowerManagement powerManagement;
    private ProxyTicket proxyTicket;
    private Quota quota;
    private String reason;
    private Boolean reassignBadMacs;
    private Boolean reboot;
    private RegistrationConfiguration registrationConfiguration;
    private String remoteViewerConnectionFile;
    private List<HostNic> removedBonds;
    private List<NetworkLabel> removedLabels;
    private List<NetworkAttachment> removedNetworkAttachments;
    private String resolutionType;
    private Boolean restoreMemory;
    private String rootPassword;
    private Boolean seal;
    private Snapshot snapshot;
    private Host sourceHost;
    private Ssh ssh;
    private String status;
    private Boolean stopGlusterService;
    private StorageDomain storageDomain;
    private List<StorageDomain> storageDomains;
    private Boolean succeeded;
    private List<NetworkAttachment> synchronizedNetworkAttachments;
    private Template template;
    private Ticket ticket;
    private BigInteger timeout;
    private Boolean undeployHostedEngine;
    private ClusterUpgradeAction upgradeAction;
    private Boolean useCloudInit;
    private Boolean useIgnition;
    private Boolean useInitialization;
    private Boolean useSysprep;
    private HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration;
    private Vm vm;
    private List<VnicProfileMapping> vnicProfileMappings;
    private Boolean volatile_;
    
    public ActionBuilder activate(boolean newActivate) {
        activate = Boolean.valueOf(newActivate);
        return this;
    }
    
    public ActionBuilder activate(Boolean newActivate) {
        activate = newActivate;
        return this;
    }
    
    
    public ActionBuilder allowPartialImport(boolean newAllowPartialImport) {
        allowPartialImport = Boolean.valueOf(newAllowPartialImport);
        return this;
    }
    
    public ActionBuilder allowPartialImport(Boolean newAllowPartialImport) {
        allowPartialImport = newAllowPartialImport;
        return this;
    }
    
    
    public ActionBuilder async(boolean newAsync) {
        async = Boolean.valueOf(newAsync);
        return this;
    }
    
    public ActionBuilder async(Boolean newAsync) {
        async = newAsync;
        return this;
    }
    
    
    public ActionBuilder attachment(DiskAttachment newAttachment) {
        attachment = newAttachment;
        return this;
    }
    
    public ActionBuilder attachment(DiskAttachmentBuilder newAttachment) {
        if (newAttachment == null) {
            attachment = null;
        }
        else {
            attachment = newAttachment.build();
        }
        return this;
    }
    
    
    public ActionBuilder authorizedKey(AuthorizedKey newAuthorizedKey) {
        authorizedKey = newAuthorizedKey;
        return this;
    }
    
    public ActionBuilder authorizedKey(AuthorizedKeyBuilder newAuthorizedKey) {
        if (newAuthorizedKey == null) {
            authorizedKey = null;
        }
        else {
            authorizedKey = newAuthorizedKey.build();
        }
        return this;
    }
    
    
    public ActionBuilder autoPinningPolicy(AutoPinningPolicy newAutoPinningPolicy) {
        autoPinningPolicy = newAutoPinningPolicy;
        return this;
    }
    
    
    public ActionBuilder bricks(List<GlusterBrick> newBricks) {
        if (newBricks != null) {
            if (bricks == null) {
                bricks = new ArrayList<>(newBricks);
            }
            else {
                bricks.addAll(newBricks);
            }
        }
        return this;
    }
    
    public ActionBuilder bricks(GlusterBrick... newBricks) {
        if (newBricks != null) {
            if (bricks == null) {
                bricks = new ArrayList<>(newBricks.length);
            }
            Collections.addAll(bricks, newBricks);
        }
        return this;
    }
    
    public ActionBuilder bricks(GlusterBrickBuilder... newBricks) {
        if (newBricks != null) {
            if (bricks == null) {
                bricks = new ArrayList<>(newBricks.length);
            }
            for (GlusterBrickBuilder builder : newBricks) {
                bricks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder certificates(List<Certificate> newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates);
            }
            else {
                certificates.addAll(newCertificates);
            }
        }
        return this;
    }
    
    public ActionBuilder certificates(Certificate... newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates.length);
            }
            Collections.addAll(certificates, newCertificates);
        }
        return this;
    }
    
    public ActionBuilder certificates(CertificateBuilder... newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates.length);
            }
            for (CertificateBuilder builder : newCertificates) {
                certificates.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder checkConnectivity(boolean newCheckConnectivity) {
        checkConnectivity = Boolean.valueOf(newCheckConnectivity);
        return this;
    }
    
    public ActionBuilder checkConnectivity(Boolean newCheckConnectivity) {
        checkConnectivity = newCheckConnectivity;
        return this;
    }
    
    
    public ActionBuilder clone_(boolean newClone) {
        clone_ = Boolean.valueOf(newClone);
        return this;
    }
    
    public ActionBuilder clone_(Boolean newClone) {
        clone_ = newClone;
        return this;
    }
    
    
    public ActionBuilder clonePermissions(boolean newClonePermissions) {
        clonePermissions = Boolean.valueOf(newClonePermissions);
        return this;
    }
    
    public ActionBuilder clonePermissions(Boolean newClonePermissions) {
        clonePermissions = newClonePermissions;
        return this;
    }
    
    
    public ActionBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public ActionBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public ActionBuilder collapseSnapshots(boolean newCollapseSnapshots) {
        collapseSnapshots = Boolean.valueOf(newCollapseSnapshots);
        return this;
    }
    
    public ActionBuilder collapseSnapshots(Boolean newCollapseSnapshots) {
        collapseSnapshots = newCollapseSnapshots;
        return this;
    }
    
    
    public ActionBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ActionBuilder commitOnSuccess(boolean newCommitOnSuccess) {
        commitOnSuccess = Boolean.valueOf(newCommitOnSuccess);
        return this;
    }
    
    public ActionBuilder commitOnSuccess(Boolean newCommitOnSuccess) {
        commitOnSuccess = newCommitOnSuccess;
        return this;
    }
    
    
    public ActionBuilder connection(StorageConnection newConnection) {
        connection = newConnection;
        return this;
    }
    
    public ActionBuilder connection(StorageConnectionBuilder newConnection) {
        if (newConnection == null) {
            connection = null;
        }
        else {
            connection = newConnection.build();
        }
        return this;
    }
    
    
    public ActionBuilder connectivityTimeout(int newConnectivityTimeout) {
        connectivityTimeout = BigInteger.valueOf((long) newConnectivityTimeout);
        return this;
    }
    
    public ActionBuilder connectivityTimeout(Integer newConnectivityTimeout) {
        if (newConnectivityTimeout == null) {
            connectivityTimeout = null;
        }
        else {
            connectivityTimeout = BigInteger.valueOf(newConnectivityTimeout.longValue());
        }
        return this;
    }
    
    public ActionBuilder connectivityTimeout(long newConnectivityTimeout) {
        connectivityTimeout = BigInteger.valueOf(newConnectivityTimeout);
        return this;
    }
    
    public ActionBuilder connectivityTimeout(Long newConnectivityTimeout) {
        if (newConnectivityTimeout == null) {
            connectivityTimeout = null;
        }
        else {
            connectivityTimeout = BigInteger.valueOf(newConnectivityTimeout.longValue());
        }
        return this;
    }
    
    public ActionBuilder connectivityTimeout(BigInteger newConnectivityTimeout) {
        connectivityTimeout = newConnectivityTimeout;
        return this;
    }
    
    
    public ActionBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public ActionBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public ActionBuilder deployHostedEngine(boolean newDeployHostedEngine) {
        deployHostedEngine = Boolean.valueOf(newDeployHostedEngine);
        return this;
    }
    
    public ActionBuilder deployHostedEngine(Boolean newDeployHostedEngine) {
        deployHostedEngine = newDeployHostedEngine;
        return this;
    }
    
    
    public ActionBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ActionBuilder details(GlusterVolumeProfileDetails newDetails) {
        details = newDetails;
        return this;
    }
    
    public ActionBuilder details(GlusterVolumeProfileDetailsBuilder newDetails) {
        if (newDetails == null) {
            details = null;
        }
        else {
            details = newDetails.build();
        }
        return this;
    }
    
    
    public ActionBuilder directory(String newDirectory) {
        directory = newDirectory;
        return this;
    }
    
    
    public ActionBuilder discardSnapshots(boolean newDiscardSnapshots) {
        discardSnapshots = Boolean.valueOf(newDiscardSnapshots);
        return this;
    }
    
    public ActionBuilder discardSnapshots(Boolean newDiscardSnapshots) {
        discardSnapshots = newDiscardSnapshots;
        return this;
    }
    
    
    public ActionBuilder discoveredTargets(List<IscsiDetails> newDiscoveredTargets) {
        if (newDiscoveredTargets != null) {
            if (discoveredTargets == null) {
                discoveredTargets = new ArrayList<>(newDiscoveredTargets);
            }
            else {
                discoveredTargets.addAll(newDiscoveredTargets);
            }
        }
        return this;
    }
    
    public ActionBuilder discoveredTargets(IscsiDetails... newDiscoveredTargets) {
        if (newDiscoveredTargets != null) {
            if (discoveredTargets == null) {
                discoveredTargets = new ArrayList<>(newDiscoveredTargets.length);
            }
            Collections.addAll(discoveredTargets, newDiscoveredTargets);
        }
        return this;
    }
    
    public ActionBuilder discoveredTargets(IscsiDetailsBuilder... newDiscoveredTargets) {
        if (newDiscoveredTargets != null) {
            if (discoveredTargets == null) {
                discoveredTargets = new ArrayList<>(newDiscoveredTargets.length);
            }
            for (IscsiDetailsBuilder builder : newDiscoveredTargets) {
                discoveredTargets.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder disk(Disk newDisk) {
        disk = newDisk;
        return this;
    }
    
    public ActionBuilder disk(DiskBuilder newDisk) {
        if (newDisk == null) {
            disk = null;
        }
        else {
            disk = newDisk.build();
        }
        return this;
    }
    
    
    public ActionBuilder diskProfile(DiskProfile newDiskProfile) {
        diskProfile = newDiskProfile;
        return this;
    }
    
    public ActionBuilder diskProfile(DiskProfileBuilder newDiskProfile) {
        if (newDiskProfile == null) {
            diskProfile = null;
        }
        else {
            diskProfile = newDiskProfile.build();
        }
        return this;
    }
    
    
    public ActionBuilder disks(List<Disk> newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks);
            }
            else {
                disks.addAll(newDisks);
            }
        }
        return this;
    }
    
    public ActionBuilder disks(Disk... newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks.length);
            }
            Collections.addAll(disks, newDisks);
        }
        return this;
    }
    
    public ActionBuilder disks(DiskBuilder... newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks.length);
            }
            for (DiskBuilder builder : newDisks) {
                disks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder exclusive(boolean newExclusive) {
        exclusive = Boolean.valueOf(newExclusive);
        return this;
    }
    
    public ActionBuilder exclusive(Boolean newExclusive) {
        exclusive = newExclusive;
        return this;
    }
    
    
    public ActionBuilder fault(Fault newFault) {
        fault = newFault;
        return this;
    }
    
    public ActionBuilder fault(FaultBuilder newFault) {
        if (newFault == null) {
            fault = null;
        }
        else {
            fault = newFault.build();
        }
        return this;
    }
    
    
    public ActionBuilder fenceType(String newFenceType) {
        fenceType = newFenceType;
        return this;
    }
    
    
    public ActionBuilder filename(String newFilename) {
        filename = newFilename;
        return this;
    }
    
    
    public ActionBuilder filter(boolean newFilter) {
        filter = Boolean.valueOf(newFilter);
        return this;
    }
    
    public ActionBuilder filter(Boolean newFilter) {
        filter = newFilter;
        return this;
    }
    
    
    public ActionBuilder fixLayout(boolean newFixLayout) {
        fixLayout = Boolean.valueOf(newFixLayout);
        return this;
    }
    
    public ActionBuilder fixLayout(Boolean newFixLayout) {
        fixLayout = newFixLayout;
        return this;
    }
    
    
    public ActionBuilder force(boolean newForce) {
        force = Boolean.valueOf(newForce);
        return this;
    }
    
    public ActionBuilder force(Boolean newForce) {
        force = newForce;
        return this;
    }
    
    
    public ActionBuilder gracePeriod(GracePeriod newGracePeriod) {
        gracePeriod = newGracePeriod;
        return this;
    }
    
    public ActionBuilder gracePeriod(GracePeriodBuilder newGracePeriod) {
        if (newGracePeriod == null) {
            gracePeriod = null;
        }
        else {
            gracePeriod = newGracePeriod.build();
        }
        return this;
    }
    
    
    public ActionBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public ActionBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public ActionBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ActionBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ActionBuilder image(String newImage) {
        image = newImage;
        return this;
    }
    
    
    public ActionBuilder imageTransfer(ImageTransfer newImageTransfer) {
        imageTransfer = newImageTransfer;
        return this;
    }
    
    public ActionBuilder imageTransfer(ImageTransferBuilder newImageTransfer) {
        if (newImageTransfer == null) {
            imageTransfer = null;
        }
        else {
            imageTransfer = newImageTransfer.build();
        }
        return this;
    }
    
    
    public ActionBuilder importAsTemplate(boolean newImportAsTemplate) {
        importAsTemplate = Boolean.valueOf(newImportAsTemplate);
        return this;
    }
    
    public ActionBuilder importAsTemplate(Boolean newImportAsTemplate) {
        importAsTemplate = newImportAsTemplate;
        return this;
    }
    
    
    public ActionBuilder isAttached(boolean newIsAttached) {
        isAttached = Boolean.valueOf(newIsAttached);
        return this;
    }
    
    public ActionBuilder isAttached(Boolean newIsAttached) {
        isAttached = newIsAttached;
        return this;
    }
    
    
    public ActionBuilder iscsi(IscsiDetails newIscsi) {
        iscsi = newIscsi;
        return this;
    }
    
    public ActionBuilder iscsi(IscsiDetailsBuilder newIscsi) {
        if (newIscsi == null) {
            iscsi = null;
        }
        else {
            iscsi = newIscsi.build();
        }
        return this;
    }
    
    
    public ActionBuilder iscsiTargets(List<String> newIscsiTargets) {
        if (newIscsiTargets != null) {
            if (iscsiTargets == null) {
                iscsiTargets = new ArrayList<>(newIscsiTargets);
            }
            else {
                iscsiTargets.addAll(newIscsiTargets);
            }
        }
        return this;
    }
    
    public ActionBuilder iscsiTargets(String... newIscsiTargets) {
        if (newIscsiTargets != null) {
            if (iscsiTargets == null) {
                iscsiTargets = new ArrayList<>(newIscsiTargets.length);
            }
            Collections.addAll(iscsiTargets, newIscsiTargets);
        }
        return this;
    }
    
    
    public ActionBuilder job(Job newJob) {
        job = newJob;
        return this;
    }
    
    public ActionBuilder job(JobBuilder newJob) {
        if (newJob == null) {
            job = null;
        }
        else {
            job = newJob.build();
        }
        return this;
    }
    
    
    public ActionBuilder lease(StorageDomainLease newLease) {
        lease = newLease;
        return this;
    }
    
    public ActionBuilder lease(StorageDomainLeaseBuilder newLease) {
        if (newLease == null) {
            lease = null;
        }
        else {
            lease = newLease.build();
        }
        return this;
    }
    
    
    public ActionBuilder logicalUnits(List<LogicalUnit> newLogicalUnits) {
        if (newLogicalUnits != null) {
            if (logicalUnits == null) {
                logicalUnits = new ArrayList<>(newLogicalUnits);
            }
            else {
                logicalUnits.addAll(newLogicalUnits);
            }
        }
        return this;
    }
    
    public ActionBuilder logicalUnits(LogicalUnit... newLogicalUnits) {
        if (newLogicalUnits != null) {
            if (logicalUnits == null) {
                logicalUnits = new ArrayList<>(newLogicalUnits.length);
            }
            Collections.addAll(logicalUnits, newLogicalUnits);
        }
        return this;
    }
    
    public ActionBuilder logicalUnits(LogicalUnitBuilder... newLogicalUnits) {
        if (newLogicalUnits != null) {
            if (logicalUnits == null) {
                logicalUnits = new ArrayList<>(newLogicalUnits.length);
            }
            for (LogicalUnitBuilder builder : newLogicalUnits) {
                logicalUnits.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder maintenanceAfterRestart(boolean newMaintenanceAfterRestart) {
        maintenanceAfterRestart = Boolean.valueOf(newMaintenanceAfterRestart);
        return this;
    }
    
    public ActionBuilder maintenanceAfterRestart(Boolean newMaintenanceAfterRestart) {
        maintenanceAfterRestart = newMaintenanceAfterRestart;
        return this;
    }
    
    
    public ActionBuilder maintenanceEnabled(boolean newMaintenanceEnabled) {
        maintenanceEnabled = Boolean.valueOf(newMaintenanceEnabled);
        return this;
    }
    
    public ActionBuilder maintenanceEnabled(Boolean newMaintenanceEnabled) {
        maintenanceEnabled = newMaintenanceEnabled;
        return this;
    }
    
    
    public ActionBuilder migrateVmsInAffinityClosure(boolean newMigrateVmsInAffinityClosure) {
        migrateVmsInAffinityClosure = Boolean.valueOf(newMigrateVmsInAffinityClosure);
        return this;
    }
    
    public ActionBuilder migrateVmsInAffinityClosure(Boolean newMigrateVmsInAffinityClosure) {
        migrateVmsInAffinityClosure = newMigrateVmsInAffinityClosure;
        return this;
    }
    
    
    public ActionBuilder modifiedBonds(List<HostNic> newModifiedBonds) {
        if (newModifiedBonds != null) {
            if (modifiedBonds == null) {
                modifiedBonds = new ArrayList<>(newModifiedBonds);
            }
            else {
                modifiedBonds.addAll(newModifiedBonds);
            }
        }
        return this;
    }
    
    public ActionBuilder modifiedBonds(HostNic... newModifiedBonds) {
        if (newModifiedBonds != null) {
            if (modifiedBonds == null) {
                modifiedBonds = new ArrayList<>(newModifiedBonds.length);
            }
            Collections.addAll(modifiedBonds, newModifiedBonds);
        }
        return this;
    }
    
    public ActionBuilder modifiedBonds(HostNicBuilder... newModifiedBonds) {
        if (newModifiedBonds != null) {
            if (modifiedBonds == null) {
                modifiedBonds = new ArrayList<>(newModifiedBonds.length);
            }
            for (HostNicBuilder builder : newModifiedBonds) {
                modifiedBonds.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder modifiedLabels(List<NetworkLabel> newModifiedLabels) {
        if (newModifiedLabels != null) {
            if (modifiedLabels == null) {
                modifiedLabels = new ArrayList<>(newModifiedLabels);
            }
            else {
                modifiedLabels.addAll(newModifiedLabels);
            }
        }
        return this;
    }
    
    public ActionBuilder modifiedLabels(NetworkLabel... newModifiedLabels) {
        if (newModifiedLabels != null) {
            if (modifiedLabels == null) {
                modifiedLabels = new ArrayList<>(newModifiedLabels.length);
            }
            Collections.addAll(modifiedLabels, newModifiedLabels);
        }
        return this;
    }
    
    public ActionBuilder modifiedLabels(NetworkLabelBuilder... newModifiedLabels) {
        if (newModifiedLabels != null) {
            if (modifiedLabels == null) {
                modifiedLabels = new ArrayList<>(newModifiedLabels.length);
            }
            for (NetworkLabelBuilder builder : newModifiedLabels) {
                modifiedLabels.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder modifiedNetworkAttachments(List<NetworkAttachment> newModifiedNetworkAttachments) {
        if (newModifiedNetworkAttachments != null) {
            if (modifiedNetworkAttachments == null) {
                modifiedNetworkAttachments = new ArrayList<>(newModifiedNetworkAttachments);
            }
            else {
                modifiedNetworkAttachments.addAll(newModifiedNetworkAttachments);
            }
        }
        return this;
    }
    
    public ActionBuilder modifiedNetworkAttachments(NetworkAttachment... newModifiedNetworkAttachments) {
        if (newModifiedNetworkAttachments != null) {
            if (modifiedNetworkAttachments == null) {
                modifiedNetworkAttachments = new ArrayList<>(newModifiedNetworkAttachments.length);
            }
            Collections.addAll(modifiedNetworkAttachments, newModifiedNetworkAttachments);
        }
        return this;
    }
    
    public ActionBuilder modifiedNetworkAttachments(NetworkAttachmentBuilder... newModifiedNetworkAttachments) {
        if (newModifiedNetworkAttachments != null) {
            if (modifiedNetworkAttachments == null) {
                modifiedNetworkAttachments = new ArrayList<>(newModifiedNetworkAttachments.length);
            }
            for (NetworkAttachmentBuilder builder : newModifiedNetworkAttachments) {
                modifiedNetworkAttachments.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ActionBuilder optimizeCpuSettings(boolean newOptimizeCpuSettings) {
        optimizeCpuSettings = Boolean.valueOf(newOptimizeCpuSettings);
        return this;
    }
    
    public ActionBuilder optimizeCpuSettings(Boolean newOptimizeCpuSettings) {
        optimizeCpuSettings = newOptimizeCpuSettings;
        return this;
    }
    
    
    public ActionBuilder option(Option newOption) {
        option = newOption;
        return this;
    }
    
    public ActionBuilder option(OptionBuilder newOption) {
        if (newOption == null) {
            option = null;
        }
        else {
            option = newOption.build();
        }
        return this;
    }
    
    
    public ActionBuilder pause(boolean newPause) {
        pause = Boolean.valueOf(newPause);
        return this;
    }
    
    public ActionBuilder pause(Boolean newPause) {
        pause = newPause;
        return this;
    }
    
    
    public ActionBuilder permission(Permission newPermission) {
        permission = newPermission;
        return this;
    }
    
    public ActionBuilder permission(PermissionBuilder newPermission) {
        if (newPermission == null) {
            permission = null;
        }
        else {
            permission = newPermission.build();
        }
        return this;
    }
    
    
    public ActionBuilder powerManagement(PowerManagement newPowerManagement) {
        powerManagement = newPowerManagement;
        return this;
    }
    
    public ActionBuilder powerManagement(PowerManagementBuilder newPowerManagement) {
        if (newPowerManagement == null) {
            powerManagement = null;
        }
        else {
            powerManagement = newPowerManagement.build();
        }
        return this;
    }
    
    
    public ActionBuilder proxyTicket(ProxyTicket newProxyTicket) {
        proxyTicket = newProxyTicket;
        return this;
    }
    
    public ActionBuilder proxyTicket(ProxyTicketBuilder newProxyTicket) {
        if (newProxyTicket == null) {
            proxyTicket = null;
        }
        else {
            proxyTicket = newProxyTicket.build();
        }
        return this;
    }
    
    
    public ActionBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public ActionBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public ActionBuilder reason(String newReason) {
        reason = newReason;
        return this;
    }
    
    
    public ActionBuilder reassignBadMacs(boolean newReassignBadMacs) {
        reassignBadMacs = Boolean.valueOf(newReassignBadMacs);
        return this;
    }
    
    public ActionBuilder reassignBadMacs(Boolean newReassignBadMacs) {
        reassignBadMacs = newReassignBadMacs;
        return this;
    }
    
    
    public ActionBuilder reboot(boolean newReboot) {
        reboot = Boolean.valueOf(newReboot);
        return this;
    }
    
    public ActionBuilder reboot(Boolean newReboot) {
        reboot = newReboot;
        return this;
    }
    
    
    public ActionBuilder registrationConfiguration(RegistrationConfiguration newRegistrationConfiguration) {
        registrationConfiguration = newRegistrationConfiguration;
        return this;
    }
    
    public ActionBuilder registrationConfiguration(RegistrationConfigurationBuilder newRegistrationConfiguration) {
        if (newRegistrationConfiguration == null) {
            registrationConfiguration = null;
        }
        else {
            registrationConfiguration = newRegistrationConfiguration.build();
        }
        return this;
    }
    
    
    public ActionBuilder remoteViewerConnectionFile(String newRemoteViewerConnectionFile) {
        remoteViewerConnectionFile = newRemoteViewerConnectionFile;
        return this;
    }
    
    
    public ActionBuilder removedBonds(List<HostNic> newRemovedBonds) {
        if (newRemovedBonds != null) {
            if (removedBonds == null) {
                removedBonds = new ArrayList<>(newRemovedBonds);
            }
            else {
                removedBonds.addAll(newRemovedBonds);
            }
        }
        return this;
    }
    
    public ActionBuilder removedBonds(HostNic... newRemovedBonds) {
        if (newRemovedBonds != null) {
            if (removedBonds == null) {
                removedBonds = new ArrayList<>(newRemovedBonds.length);
            }
            Collections.addAll(removedBonds, newRemovedBonds);
        }
        return this;
    }
    
    public ActionBuilder removedBonds(HostNicBuilder... newRemovedBonds) {
        if (newRemovedBonds != null) {
            if (removedBonds == null) {
                removedBonds = new ArrayList<>(newRemovedBonds.length);
            }
            for (HostNicBuilder builder : newRemovedBonds) {
                removedBonds.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder removedLabels(List<NetworkLabel> newRemovedLabels) {
        if (newRemovedLabels != null) {
            if (removedLabels == null) {
                removedLabels = new ArrayList<>(newRemovedLabels);
            }
            else {
                removedLabels.addAll(newRemovedLabels);
            }
        }
        return this;
    }
    
    public ActionBuilder removedLabels(NetworkLabel... newRemovedLabels) {
        if (newRemovedLabels != null) {
            if (removedLabels == null) {
                removedLabels = new ArrayList<>(newRemovedLabels.length);
            }
            Collections.addAll(removedLabels, newRemovedLabels);
        }
        return this;
    }
    
    public ActionBuilder removedLabels(NetworkLabelBuilder... newRemovedLabels) {
        if (newRemovedLabels != null) {
            if (removedLabels == null) {
                removedLabels = new ArrayList<>(newRemovedLabels.length);
            }
            for (NetworkLabelBuilder builder : newRemovedLabels) {
                removedLabels.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder removedNetworkAttachments(List<NetworkAttachment> newRemovedNetworkAttachments) {
        if (newRemovedNetworkAttachments != null) {
            if (removedNetworkAttachments == null) {
                removedNetworkAttachments = new ArrayList<>(newRemovedNetworkAttachments);
            }
            else {
                removedNetworkAttachments.addAll(newRemovedNetworkAttachments);
            }
        }
        return this;
    }
    
    public ActionBuilder removedNetworkAttachments(NetworkAttachment... newRemovedNetworkAttachments) {
        if (newRemovedNetworkAttachments != null) {
            if (removedNetworkAttachments == null) {
                removedNetworkAttachments = new ArrayList<>(newRemovedNetworkAttachments.length);
            }
            Collections.addAll(removedNetworkAttachments, newRemovedNetworkAttachments);
        }
        return this;
    }
    
    public ActionBuilder removedNetworkAttachments(NetworkAttachmentBuilder... newRemovedNetworkAttachments) {
        if (newRemovedNetworkAttachments != null) {
            if (removedNetworkAttachments == null) {
                removedNetworkAttachments = new ArrayList<>(newRemovedNetworkAttachments.length);
            }
            for (NetworkAttachmentBuilder builder : newRemovedNetworkAttachments) {
                removedNetworkAttachments.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder resolutionType(String newResolutionType) {
        resolutionType = newResolutionType;
        return this;
    }
    
    
    public ActionBuilder restoreMemory(boolean newRestoreMemory) {
        restoreMemory = Boolean.valueOf(newRestoreMemory);
        return this;
    }
    
    public ActionBuilder restoreMemory(Boolean newRestoreMemory) {
        restoreMemory = newRestoreMemory;
        return this;
    }
    
    
    public ActionBuilder rootPassword(String newRootPassword) {
        rootPassword = newRootPassword;
        return this;
    }
    
    
    public ActionBuilder seal(boolean newSeal) {
        seal = Boolean.valueOf(newSeal);
        return this;
    }
    
    public ActionBuilder seal(Boolean newSeal) {
        seal = newSeal;
        return this;
    }
    
    
    public ActionBuilder snapshot(Snapshot newSnapshot) {
        snapshot = newSnapshot;
        return this;
    }
    
    public ActionBuilder snapshot(SnapshotBuilder newSnapshot) {
        if (newSnapshot == null) {
            snapshot = null;
        }
        else {
            snapshot = newSnapshot.build();
        }
        return this;
    }
    
    
    public ActionBuilder sourceHost(Host newSourceHost) {
        sourceHost = newSourceHost;
        return this;
    }
    
    public ActionBuilder sourceHost(HostBuilder newSourceHost) {
        if (newSourceHost == null) {
            sourceHost = null;
        }
        else {
            sourceHost = newSourceHost.build();
        }
        return this;
    }
    
    
    public ActionBuilder ssh(Ssh newSsh) {
        ssh = newSsh;
        return this;
    }
    
    public ActionBuilder ssh(SshBuilder newSsh) {
        if (newSsh == null) {
            ssh = null;
        }
        else {
            ssh = newSsh.build();
        }
        return this;
    }
    
    
    public ActionBuilder status(String newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public ActionBuilder stopGlusterService(boolean newStopGlusterService) {
        stopGlusterService = Boolean.valueOf(newStopGlusterService);
        return this;
    }
    
    public ActionBuilder stopGlusterService(Boolean newStopGlusterService) {
        stopGlusterService = newStopGlusterService;
        return this;
    }
    
    
    public ActionBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public ActionBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public ActionBuilder storageDomains(List<StorageDomain> newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains);
            }
            else {
                storageDomains.addAll(newStorageDomains);
            }
        }
        return this;
    }
    
    public ActionBuilder storageDomains(StorageDomain... newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains.length);
            }
            Collections.addAll(storageDomains, newStorageDomains);
        }
        return this;
    }
    
    public ActionBuilder storageDomains(StorageDomainBuilder... newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains.length);
            }
            for (StorageDomainBuilder builder : newStorageDomains) {
                storageDomains.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder succeeded(boolean newSucceeded) {
        succeeded = Boolean.valueOf(newSucceeded);
        return this;
    }
    
    public ActionBuilder succeeded(Boolean newSucceeded) {
        succeeded = newSucceeded;
        return this;
    }
    
    
    public ActionBuilder synchronizedNetworkAttachments(List<NetworkAttachment> newSynchronizedNetworkAttachments) {
        if (newSynchronizedNetworkAttachments != null) {
            if (synchronizedNetworkAttachments == null) {
                synchronizedNetworkAttachments = new ArrayList<>(newSynchronizedNetworkAttachments);
            }
            else {
                synchronizedNetworkAttachments.addAll(newSynchronizedNetworkAttachments);
            }
        }
        return this;
    }
    
    public ActionBuilder synchronizedNetworkAttachments(NetworkAttachment... newSynchronizedNetworkAttachments) {
        if (newSynchronizedNetworkAttachments != null) {
            if (synchronizedNetworkAttachments == null) {
                synchronizedNetworkAttachments = new ArrayList<>(newSynchronizedNetworkAttachments.length);
            }
            Collections.addAll(synchronizedNetworkAttachments, newSynchronizedNetworkAttachments);
        }
        return this;
    }
    
    public ActionBuilder synchronizedNetworkAttachments(NetworkAttachmentBuilder... newSynchronizedNetworkAttachments) {
        if (newSynchronizedNetworkAttachments != null) {
            if (synchronizedNetworkAttachments == null) {
                synchronizedNetworkAttachments = new ArrayList<>(newSynchronizedNetworkAttachments.length);
            }
            for (NetworkAttachmentBuilder builder : newSynchronizedNetworkAttachments) {
                synchronizedNetworkAttachments.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public ActionBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public ActionBuilder ticket(Ticket newTicket) {
        ticket = newTicket;
        return this;
    }
    
    public ActionBuilder ticket(TicketBuilder newTicket) {
        if (newTicket == null) {
            ticket = null;
        }
        else {
            ticket = newTicket.build();
        }
        return this;
    }
    
    
    public ActionBuilder timeout(int newTimeout) {
        timeout = BigInteger.valueOf((long) newTimeout);
        return this;
    }
    
    public ActionBuilder timeout(Integer newTimeout) {
        if (newTimeout == null) {
            timeout = null;
        }
        else {
            timeout = BigInteger.valueOf(newTimeout.longValue());
        }
        return this;
    }
    
    public ActionBuilder timeout(long newTimeout) {
        timeout = BigInteger.valueOf(newTimeout);
        return this;
    }
    
    public ActionBuilder timeout(Long newTimeout) {
        if (newTimeout == null) {
            timeout = null;
        }
        else {
            timeout = BigInteger.valueOf(newTimeout.longValue());
        }
        return this;
    }
    
    public ActionBuilder timeout(BigInteger newTimeout) {
        timeout = newTimeout;
        return this;
    }
    
    
    public ActionBuilder undeployHostedEngine(boolean newUndeployHostedEngine) {
        undeployHostedEngine = Boolean.valueOf(newUndeployHostedEngine);
        return this;
    }
    
    public ActionBuilder undeployHostedEngine(Boolean newUndeployHostedEngine) {
        undeployHostedEngine = newUndeployHostedEngine;
        return this;
    }
    
    
    public ActionBuilder upgradeAction(ClusterUpgradeAction newUpgradeAction) {
        upgradeAction = newUpgradeAction;
        return this;
    }
    
    
    public ActionBuilder useCloudInit(boolean newUseCloudInit) {
        useCloudInit = Boolean.valueOf(newUseCloudInit);
        return this;
    }
    
    public ActionBuilder useCloudInit(Boolean newUseCloudInit) {
        useCloudInit = newUseCloudInit;
        return this;
    }
    
    
    public ActionBuilder useIgnition(boolean newUseIgnition) {
        useIgnition = Boolean.valueOf(newUseIgnition);
        return this;
    }
    
    public ActionBuilder useIgnition(Boolean newUseIgnition) {
        useIgnition = newUseIgnition;
        return this;
    }
    
    
    public ActionBuilder useInitialization(boolean newUseInitialization) {
        useInitialization = Boolean.valueOf(newUseInitialization);
        return this;
    }
    
    public ActionBuilder useInitialization(Boolean newUseInitialization) {
        useInitialization = newUseInitialization;
        return this;
    }
    
    
    public ActionBuilder useSysprep(boolean newUseSysprep) {
        useSysprep = Boolean.valueOf(newUseSysprep);
        return this;
    }
    
    public ActionBuilder useSysprep(Boolean newUseSysprep) {
        useSysprep = newUseSysprep;
        return this;
    }
    
    
    public ActionBuilder virtualFunctionsConfiguration(HostNicVirtualFunctionsConfiguration newVirtualFunctionsConfiguration) {
        virtualFunctionsConfiguration = newVirtualFunctionsConfiguration;
        return this;
    }
    
    public ActionBuilder virtualFunctionsConfiguration(HostNicVirtualFunctionsConfigurationBuilder newVirtualFunctionsConfiguration) {
        if (newVirtualFunctionsConfiguration == null) {
            virtualFunctionsConfiguration = null;
        }
        else {
            virtualFunctionsConfiguration = newVirtualFunctionsConfiguration.build();
        }
        return this;
    }
    
    
    public ActionBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public ActionBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public ActionBuilder vnicProfileMappings(List<VnicProfileMapping> newVnicProfileMappings) {
        if (newVnicProfileMappings != null) {
            if (vnicProfileMappings == null) {
                vnicProfileMappings = new ArrayList<>(newVnicProfileMappings);
            }
            else {
                vnicProfileMappings.addAll(newVnicProfileMappings);
            }
        }
        return this;
    }
    
    public ActionBuilder vnicProfileMappings(VnicProfileMapping... newVnicProfileMappings) {
        if (newVnicProfileMappings != null) {
            if (vnicProfileMappings == null) {
                vnicProfileMappings = new ArrayList<>(newVnicProfileMappings.length);
            }
            Collections.addAll(vnicProfileMappings, newVnicProfileMappings);
        }
        return this;
    }
    
    public ActionBuilder vnicProfileMappings(VnicProfileMappingBuilder... newVnicProfileMappings) {
        if (newVnicProfileMappings != null) {
            if (vnicProfileMappings == null) {
                vnicProfileMappings = new ArrayList<>(newVnicProfileMappings.length);
            }
            for (VnicProfileMappingBuilder builder : newVnicProfileMappings) {
                vnicProfileMappings.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ActionBuilder volatile_(boolean newVolatile) {
        volatile_ = Boolean.valueOf(newVolatile);
        return this;
    }
    
    public ActionBuilder volatile_(Boolean newVolatile) {
        volatile_ = newVolatile;
        return this;
    }
    
    
    public Action build() {
        ActionContainer container = new ActionContainer();
        container.activate(activate);
        container.allowPartialImport(allowPartialImport);
        container.async(async);
        container.attachment(attachment);
        container.authorizedKey(authorizedKey);
        container.autoPinningPolicy(autoPinningPolicy);
        container.bricks(bricks);
        container.certificates(certificates);
        container.checkConnectivity(checkConnectivity);
        container.clone_(clone_);
        container.clonePermissions(clonePermissions);
        container.cluster(cluster);
        container.collapseSnapshots(collapseSnapshots);
        container.comment(comment);
        container.commitOnSuccess(commitOnSuccess);
        container.connection(connection);
        container.connectivityTimeout(connectivityTimeout);
        container.dataCenter(dataCenter);
        container.deployHostedEngine(deployHostedEngine);
        container.description(description);
        container.details(details);
        container.directory(directory);
        container.discardSnapshots(discardSnapshots);
        container.discoveredTargets(discoveredTargets);
        container.disk(disk);
        container.diskProfile(diskProfile);
        container.disks(disks);
        container.exclusive(exclusive);
        container.fault(fault);
        container.fenceType(fenceType);
        container.filename(filename);
        container.filter(filter);
        container.fixLayout(fixLayout);
        container.force(force);
        container.gracePeriod(gracePeriod);
        container.host(host);
        container.href(href);
        container.id(id);
        container.image(image);
        container.imageTransfer(imageTransfer);
        container.importAsTemplate(importAsTemplate);
        container.isAttached(isAttached);
        container.iscsi(iscsi);
        container.iscsiTargets(iscsiTargets);
        container.job(job);
        container.lease(lease);
        container.logicalUnits(logicalUnits);
        container.maintenanceAfterRestart(maintenanceAfterRestart);
        container.maintenanceEnabled(maintenanceEnabled);
        container.migrateVmsInAffinityClosure(migrateVmsInAffinityClosure);
        container.modifiedBonds(modifiedBonds);
        container.modifiedLabels(modifiedLabels);
        container.modifiedNetworkAttachments(modifiedNetworkAttachments);
        container.name(name);
        container.optimizeCpuSettings(optimizeCpuSettings);
        container.option(option);
        container.pause(pause);
        container.permission(permission);
        container.powerManagement(powerManagement);
        container.proxyTicket(proxyTicket);
        container.quota(quota);
        container.reason(reason);
        container.reassignBadMacs(reassignBadMacs);
        container.reboot(reboot);
        container.registrationConfiguration(registrationConfiguration);
        container.remoteViewerConnectionFile(remoteViewerConnectionFile);
        container.removedBonds(removedBonds);
        container.removedLabels(removedLabels);
        container.removedNetworkAttachments(removedNetworkAttachments);
        container.resolutionType(resolutionType);
        container.restoreMemory(restoreMemory);
        container.rootPassword(rootPassword);
        container.seal(seal);
        container.snapshot(snapshot);
        container.sourceHost(sourceHost);
        container.ssh(ssh);
        container.status(status);
        container.stopGlusterService(stopGlusterService);
        container.storageDomain(storageDomain);
        container.storageDomains(storageDomains);
        container.succeeded(succeeded);
        container.synchronizedNetworkAttachments(synchronizedNetworkAttachments);
        container.template(template);
        container.ticket(ticket);
        container.timeout(timeout);
        container.undeployHostedEngine(undeployHostedEngine);
        container.upgradeAction(upgradeAction);
        container.useCloudInit(useCloudInit);
        container.useIgnition(useIgnition);
        container.useInitialization(useInitialization);
        container.useSysprep(useSysprep);
        container.virtualFunctionsConfiguration(virtualFunctionsConfiguration);
        container.vm(vm);
        container.vnicProfileMappings(vnicProfileMappings);
        container.volatile_(volatile_);
        return container;
    }
}
