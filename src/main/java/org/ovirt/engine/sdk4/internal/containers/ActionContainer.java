/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
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

public class ActionContainer extends IdentifiedContainer implements Action {
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
    private Boolean commitOnSuccess;
    private StorageConnection connection;
    private BigInteger connectivityTimeout;
    private DataCenter dataCenter;
    private Boolean deployHostedEngine;
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
    
    public boolean activate() {
        return activate;
    }
    
    public void activate(boolean newActivate) {
        activate = Boolean.valueOf(newActivate);
    }
    
    public void activate(Boolean newActivate) {
        activate = newActivate;
    }
    
    public boolean activatePresent() {
        return activate != null;
    }
    
    public boolean allowPartialImport() {
        return allowPartialImport;
    }
    
    public void allowPartialImport(boolean newAllowPartialImport) {
        allowPartialImport = Boolean.valueOf(newAllowPartialImport);
    }
    
    public void allowPartialImport(Boolean newAllowPartialImport) {
        allowPartialImport = newAllowPartialImport;
    }
    
    public boolean allowPartialImportPresent() {
        return allowPartialImport != null;
    }
    
    public boolean async() {
        return async;
    }
    
    public void async(boolean newAsync) {
        async = Boolean.valueOf(newAsync);
    }
    
    public void async(Boolean newAsync) {
        async = newAsync;
    }
    
    public boolean asyncPresent() {
        return async != null;
    }
    
    public DiskAttachment attachment() {
        return attachment;
    }
    
    public void attachment(DiskAttachment newAttachment) {
        attachment = newAttachment;
    }
    
    public boolean attachmentPresent() {
        return attachment != null;
    }
    
    public AuthorizedKey authorizedKey() {
        return authorizedKey;
    }
    
    public void authorizedKey(AuthorizedKey newAuthorizedKey) {
        authorizedKey = newAuthorizedKey;
    }
    
    public boolean authorizedKeyPresent() {
        return authorizedKey != null;
    }
    
    public AutoPinningPolicy autoPinningPolicy() {
        return autoPinningPolicy;
    }
    
    public void autoPinningPolicy(AutoPinningPolicy newAutoPinningPolicy) {
        autoPinningPolicy = newAutoPinningPolicy;
    }
    
    public boolean autoPinningPolicyPresent() {
        return autoPinningPolicy != null;
    }
    
    public List<GlusterBrick> bricks() {
        return makeUnmodifiableList(bricks);
    }
    
    public void bricks(List<GlusterBrick> newBricks) {
        bricks = makeArrayList(newBricks);
    }
    
    public boolean bricksPresent() {
        return bricks != null && !bricks.isEmpty();
    }
    
    public List<Certificate> certificates() {
        return makeUnmodifiableList(certificates);
    }
    
    public void certificates(List<Certificate> newCertificates) {
        certificates = makeArrayList(newCertificates);
    }
    
    public boolean certificatesPresent() {
        return certificates != null && !certificates.isEmpty();
    }
    
    public boolean checkConnectivity() {
        return checkConnectivity;
    }
    
    public void checkConnectivity(boolean newCheckConnectivity) {
        checkConnectivity = Boolean.valueOf(newCheckConnectivity);
    }
    
    public void checkConnectivity(Boolean newCheckConnectivity) {
        checkConnectivity = newCheckConnectivity;
    }
    
    public boolean checkConnectivityPresent() {
        return checkConnectivity != null;
    }
    
    public boolean clone_() {
        return clone_;
    }
    
    public void clone_(boolean newClone) {
        clone_ = Boolean.valueOf(newClone);
    }
    
    public void clone_(Boolean newClone) {
        clone_ = newClone;
    }
    
    public boolean clone_Present() {
        return clone_ != null;
    }
    
    public boolean clonePermissions() {
        return clonePermissions;
    }
    
    public void clonePermissions(boolean newClonePermissions) {
        clonePermissions = Boolean.valueOf(newClonePermissions);
    }
    
    public void clonePermissions(Boolean newClonePermissions) {
        clonePermissions = newClonePermissions;
    }
    
    public boolean clonePermissionsPresent() {
        return clonePermissions != null;
    }
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
    }
    
    public boolean collapseSnapshots() {
        return collapseSnapshots;
    }
    
    public void collapseSnapshots(boolean newCollapseSnapshots) {
        collapseSnapshots = Boolean.valueOf(newCollapseSnapshots);
    }
    
    public void collapseSnapshots(Boolean newCollapseSnapshots) {
        collapseSnapshots = newCollapseSnapshots;
    }
    
    public boolean collapseSnapshotsPresent() {
        return collapseSnapshots != null;
    }
    
    public boolean commitOnSuccess() {
        return commitOnSuccess;
    }
    
    public void commitOnSuccess(boolean newCommitOnSuccess) {
        commitOnSuccess = Boolean.valueOf(newCommitOnSuccess);
    }
    
    public void commitOnSuccess(Boolean newCommitOnSuccess) {
        commitOnSuccess = newCommitOnSuccess;
    }
    
    public boolean commitOnSuccessPresent() {
        return commitOnSuccess != null;
    }
    
    public StorageConnection connection() {
        return connection;
    }
    
    public void connection(StorageConnection newConnection) {
        connection = newConnection;
    }
    
    public boolean connectionPresent() {
        return connection != null;
    }
    
    public BigInteger connectivityTimeout() {
        return connectivityTimeout;
    }
    
    public Byte connectivityTimeoutAsByte() {
        return asByte("Action", "connectivityTimeout", connectivityTimeout);
    }
    
    public Short connectivityTimeoutAsShort() {
        return asShort("Action", "connectivityTimeout", connectivityTimeout);
    }
    
    public Integer connectivityTimeoutAsInteger() {
        return asInteger("Action", "connectivityTimeout", connectivityTimeout);
    }
    
    public Long connectivityTimeoutAsLong() {
        return asLong("Action", "connectivityTimeout", connectivityTimeout);
    }
    
    public void connectivityTimeout(BigInteger newConnectivityTimeout) {
        connectivityTimeout = newConnectivityTimeout;
    }
    
    public boolean connectivityTimeoutPresent() {
        return connectivityTimeout != null;
    }
    
    public DataCenter dataCenter() {
        return dataCenter;
    }
    
    public void dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
    }
    
    public boolean dataCenterPresent() {
        return dataCenter != null;
    }
    
    public boolean deployHostedEngine() {
        return deployHostedEngine;
    }
    
    public void deployHostedEngine(boolean newDeployHostedEngine) {
        deployHostedEngine = Boolean.valueOf(newDeployHostedEngine);
    }
    
    public void deployHostedEngine(Boolean newDeployHostedEngine) {
        deployHostedEngine = newDeployHostedEngine;
    }
    
    public boolean deployHostedEnginePresent() {
        return deployHostedEngine != null;
    }
    
    public GlusterVolumeProfileDetails details() {
        return details;
    }
    
    public void details(GlusterVolumeProfileDetails newDetails) {
        details = newDetails;
    }
    
    public boolean detailsPresent() {
        return details != null;
    }
    
    public String directory() {
        return directory;
    }
    
    public void directory(String newDirectory) {
        directory = newDirectory;
    }
    
    public boolean directoryPresent() {
        return directory != null;
    }
    
    public boolean discardSnapshots() {
        return discardSnapshots;
    }
    
    public void discardSnapshots(boolean newDiscardSnapshots) {
        discardSnapshots = Boolean.valueOf(newDiscardSnapshots);
    }
    
    public void discardSnapshots(Boolean newDiscardSnapshots) {
        discardSnapshots = newDiscardSnapshots;
    }
    
    public boolean discardSnapshotsPresent() {
        return discardSnapshots != null;
    }
    
    public List<IscsiDetails> discoveredTargets() {
        return makeUnmodifiableList(discoveredTargets);
    }
    
    public void discoveredTargets(List<IscsiDetails> newDiscoveredTargets) {
        discoveredTargets = makeArrayList(newDiscoveredTargets);
    }
    
    public boolean discoveredTargetsPresent() {
        return discoveredTargets != null && !discoveredTargets.isEmpty();
    }
    
    public Disk disk() {
        return disk;
    }
    
    public void disk(Disk newDisk) {
        disk = newDisk;
    }
    
    public boolean diskPresent() {
        return disk != null;
    }
    
    public DiskProfile diskProfile() {
        return diskProfile;
    }
    
    public void diskProfile(DiskProfile newDiskProfile) {
        diskProfile = newDiskProfile;
    }
    
    public boolean diskProfilePresent() {
        return diskProfile != null;
    }
    
    public List<Disk> disks() {
        return makeUnmodifiableList(disks);
    }
    
    public void disks(List<Disk> newDisks) {
        disks = makeArrayList(newDisks);
    }
    
    public boolean disksPresent() {
        return disks != null && !disks.isEmpty();
    }
    
    public boolean exclusive() {
        return exclusive;
    }
    
    public void exclusive(boolean newExclusive) {
        exclusive = Boolean.valueOf(newExclusive);
    }
    
    public void exclusive(Boolean newExclusive) {
        exclusive = newExclusive;
    }
    
    public boolean exclusivePresent() {
        return exclusive != null;
    }
    
    public Fault fault() {
        return fault;
    }
    
    public void fault(Fault newFault) {
        fault = newFault;
    }
    
    public boolean faultPresent() {
        return fault != null;
    }
    
    public String fenceType() {
        return fenceType;
    }
    
    public void fenceType(String newFenceType) {
        fenceType = newFenceType;
    }
    
    public boolean fenceTypePresent() {
        return fenceType != null;
    }
    
    public String filename() {
        return filename;
    }
    
    public void filename(String newFilename) {
        filename = newFilename;
    }
    
    public boolean filenamePresent() {
        return filename != null;
    }
    
    public boolean filter() {
        return filter;
    }
    
    public void filter(boolean newFilter) {
        filter = Boolean.valueOf(newFilter);
    }
    
    public void filter(Boolean newFilter) {
        filter = newFilter;
    }
    
    public boolean filterPresent() {
        return filter != null;
    }
    
    public boolean fixLayout() {
        return fixLayout;
    }
    
    public void fixLayout(boolean newFixLayout) {
        fixLayout = Boolean.valueOf(newFixLayout);
    }
    
    public void fixLayout(Boolean newFixLayout) {
        fixLayout = newFixLayout;
    }
    
    public boolean fixLayoutPresent() {
        return fixLayout != null;
    }
    
    public boolean force() {
        return force;
    }
    
    public void force(boolean newForce) {
        force = Boolean.valueOf(newForce);
    }
    
    public void force(Boolean newForce) {
        force = newForce;
    }
    
    public boolean forcePresent() {
        return force != null;
    }
    
    public GracePeriod gracePeriod() {
        return gracePeriod;
    }
    
    public void gracePeriod(GracePeriod newGracePeriod) {
        gracePeriod = newGracePeriod;
    }
    
    public boolean gracePeriodPresent() {
        return gracePeriod != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public String image() {
        return image;
    }
    
    public void image(String newImage) {
        image = newImage;
    }
    
    public boolean imagePresent() {
        return image != null;
    }
    
    public ImageTransfer imageTransfer() {
        return imageTransfer;
    }
    
    public void imageTransfer(ImageTransfer newImageTransfer) {
        imageTransfer = newImageTransfer;
    }
    
    public boolean imageTransferPresent() {
        return imageTransfer != null;
    }
    
    public boolean importAsTemplate() {
        return importAsTemplate;
    }
    
    public void importAsTemplate(boolean newImportAsTemplate) {
        importAsTemplate = Boolean.valueOf(newImportAsTemplate);
    }
    
    public void importAsTemplate(Boolean newImportAsTemplate) {
        importAsTemplate = newImportAsTemplate;
    }
    
    public boolean importAsTemplatePresent() {
        return importAsTemplate != null;
    }
    
    public boolean isAttached() {
        return isAttached;
    }
    
    public void isAttached(boolean newIsAttached) {
        isAttached = Boolean.valueOf(newIsAttached);
    }
    
    public void isAttached(Boolean newIsAttached) {
        isAttached = newIsAttached;
    }
    
    public boolean isAttachedPresent() {
        return isAttached != null;
    }
    
    public IscsiDetails iscsi() {
        return iscsi;
    }
    
    public void iscsi(IscsiDetails newIscsi) {
        iscsi = newIscsi;
    }
    
    public boolean iscsiPresent() {
        return iscsi != null;
    }
    
    public List<String> iscsiTargets() {
        return makeUnmodifiableList(iscsiTargets);
    }
    
    public void iscsiTargets(List<String> newIscsiTargets) {
        iscsiTargets = makeArrayList(newIscsiTargets);
    }
    
    public boolean iscsiTargetsPresent() {
        return iscsiTargets != null && !iscsiTargets.isEmpty();
    }
    
    public Job job() {
        return job;
    }
    
    public void job(Job newJob) {
        job = newJob;
    }
    
    public boolean jobPresent() {
        return job != null;
    }
    
    public StorageDomainLease lease() {
        return lease;
    }
    
    public void lease(StorageDomainLease newLease) {
        lease = newLease;
    }
    
    public boolean leasePresent() {
        return lease != null;
    }
    
    public List<LogicalUnit> logicalUnits() {
        return makeUnmodifiableList(logicalUnits);
    }
    
    public void logicalUnits(List<LogicalUnit> newLogicalUnits) {
        logicalUnits = makeArrayList(newLogicalUnits);
    }
    
    public boolean logicalUnitsPresent() {
        return logicalUnits != null && !logicalUnits.isEmpty();
    }
    
    public boolean maintenanceAfterRestart() {
        return maintenanceAfterRestart;
    }
    
    public void maintenanceAfterRestart(boolean newMaintenanceAfterRestart) {
        maintenanceAfterRestart = Boolean.valueOf(newMaintenanceAfterRestart);
    }
    
    public void maintenanceAfterRestart(Boolean newMaintenanceAfterRestart) {
        maintenanceAfterRestart = newMaintenanceAfterRestart;
    }
    
    public boolean maintenanceAfterRestartPresent() {
        return maintenanceAfterRestart != null;
    }
    
    public boolean maintenanceEnabled() {
        return maintenanceEnabled;
    }
    
    public void maintenanceEnabled(boolean newMaintenanceEnabled) {
        maintenanceEnabled = Boolean.valueOf(newMaintenanceEnabled);
    }
    
    public void maintenanceEnabled(Boolean newMaintenanceEnabled) {
        maintenanceEnabled = newMaintenanceEnabled;
    }
    
    public boolean maintenanceEnabledPresent() {
        return maintenanceEnabled != null;
    }
    
    public boolean migrateVmsInAffinityClosure() {
        return migrateVmsInAffinityClosure;
    }
    
    public void migrateVmsInAffinityClosure(boolean newMigrateVmsInAffinityClosure) {
        migrateVmsInAffinityClosure = Boolean.valueOf(newMigrateVmsInAffinityClosure);
    }
    
    public void migrateVmsInAffinityClosure(Boolean newMigrateVmsInAffinityClosure) {
        migrateVmsInAffinityClosure = newMigrateVmsInAffinityClosure;
    }
    
    public boolean migrateVmsInAffinityClosurePresent() {
        return migrateVmsInAffinityClosure != null;
    }
    
    public List<HostNic> modifiedBonds() {
        return makeUnmodifiableList(modifiedBonds);
    }
    
    public void modifiedBonds(List<HostNic> newModifiedBonds) {
        modifiedBonds = makeArrayList(newModifiedBonds);
    }
    
    public boolean modifiedBondsPresent() {
        return modifiedBonds != null && !modifiedBonds.isEmpty();
    }
    
    public List<NetworkLabel> modifiedLabels() {
        return makeUnmodifiableList(modifiedLabels);
    }
    
    public void modifiedLabels(List<NetworkLabel> newModifiedLabels) {
        modifiedLabels = makeArrayList(newModifiedLabels);
    }
    
    public boolean modifiedLabelsPresent() {
        return modifiedLabels != null && !modifiedLabels.isEmpty();
    }
    
    public List<NetworkAttachment> modifiedNetworkAttachments() {
        return makeUnmodifiableList(modifiedNetworkAttachments);
    }
    
    public void modifiedNetworkAttachments(List<NetworkAttachment> newModifiedNetworkAttachments) {
        modifiedNetworkAttachments = makeArrayList(newModifiedNetworkAttachments);
    }
    
    public boolean modifiedNetworkAttachmentsPresent() {
        return modifiedNetworkAttachments != null && !modifiedNetworkAttachments.isEmpty();
    }
    
    public boolean optimizeCpuSettings() {
        return optimizeCpuSettings;
    }
    
    public void optimizeCpuSettings(boolean newOptimizeCpuSettings) {
        optimizeCpuSettings = Boolean.valueOf(newOptimizeCpuSettings);
    }
    
    public void optimizeCpuSettings(Boolean newOptimizeCpuSettings) {
        optimizeCpuSettings = newOptimizeCpuSettings;
    }
    
    public boolean optimizeCpuSettingsPresent() {
        return optimizeCpuSettings != null;
    }
    
    public Option option() {
        return option;
    }
    
    public void option(Option newOption) {
        option = newOption;
    }
    
    public boolean optionPresent() {
        return option != null;
    }
    
    public boolean pause() {
        return pause;
    }
    
    public void pause(boolean newPause) {
        pause = Boolean.valueOf(newPause);
    }
    
    public void pause(Boolean newPause) {
        pause = newPause;
    }
    
    public boolean pausePresent() {
        return pause != null;
    }
    
    public Permission permission() {
        return permission;
    }
    
    public void permission(Permission newPermission) {
        permission = newPermission;
    }
    
    public boolean permissionPresent() {
        return permission != null;
    }
    
    public PowerManagement powerManagement() {
        return powerManagement;
    }
    
    public void powerManagement(PowerManagement newPowerManagement) {
        powerManagement = newPowerManagement;
    }
    
    public boolean powerManagementPresent() {
        return powerManagement != null;
    }
    
    public ProxyTicket proxyTicket() {
        return proxyTicket;
    }
    
    public void proxyTicket(ProxyTicket newProxyTicket) {
        proxyTicket = newProxyTicket;
    }
    
    public boolean proxyTicketPresent() {
        return proxyTicket != null;
    }
    
    public Quota quota() {
        return quota;
    }
    
    public void quota(Quota newQuota) {
        quota = newQuota;
    }
    
    public boolean quotaPresent() {
        return quota != null;
    }
    
    public String reason() {
        return reason;
    }
    
    public void reason(String newReason) {
        reason = newReason;
    }
    
    public boolean reasonPresent() {
        return reason != null;
    }
    
    public boolean reassignBadMacs() {
        return reassignBadMacs;
    }
    
    public void reassignBadMacs(boolean newReassignBadMacs) {
        reassignBadMacs = Boolean.valueOf(newReassignBadMacs);
    }
    
    public void reassignBadMacs(Boolean newReassignBadMacs) {
        reassignBadMacs = newReassignBadMacs;
    }
    
    public boolean reassignBadMacsPresent() {
        return reassignBadMacs != null;
    }
    
    public boolean reboot() {
        return reboot;
    }
    
    public void reboot(boolean newReboot) {
        reboot = Boolean.valueOf(newReboot);
    }
    
    public void reboot(Boolean newReboot) {
        reboot = newReboot;
    }
    
    public boolean rebootPresent() {
        return reboot != null;
    }
    
    public RegistrationConfiguration registrationConfiguration() {
        return registrationConfiguration;
    }
    
    public void registrationConfiguration(RegistrationConfiguration newRegistrationConfiguration) {
        registrationConfiguration = newRegistrationConfiguration;
    }
    
    public boolean registrationConfigurationPresent() {
        return registrationConfiguration != null;
    }
    
    public String remoteViewerConnectionFile() {
        return remoteViewerConnectionFile;
    }
    
    public void remoteViewerConnectionFile(String newRemoteViewerConnectionFile) {
        remoteViewerConnectionFile = newRemoteViewerConnectionFile;
    }
    
    public boolean remoteViewerConnectionFilePresent() {
        return remoteViewerConnectionFile != null;
    }
    
    public List<HostNic> removedBonds() {
        return makeUnmodifiableList(removedBonds);
    }
    
    public void removedBonds(List<HostNic> newRemovedBonds) {
        removedBonds = makeArrayList(newRemovedBonds);
    }
    
    public boolean removedBondsPresent() {
        return removedBonds != null && !removedBonds.isEmpty();
    }
    
    public List<NetworkLabel> removedLabels() {
        return makeUnmodifiableList(removedLabels);
    }
    
    public void removedLabels(List<NetworkLabel> newRemovedLabels) {
        removedLabels = makeArrayList(newRemovedLabels);
    }
    
    public boolean removedLabelsPresent() {
        return removedLabels != null && !removedLabels.isEmpty();
    }
    
    public List<NetworkAttachment> removedNetworkAttachments() {
        return makeUnmodifiableList(removedNetworkAttachments);
    }
    
    public void removedNetworkAttachments(List<NetworkAttachment> newRemovedNetworkAttachments) {
        removedNetworkAttachments = makeArrayList(newRemovedNetworkAttachments);
    }
    
    public boolean removedNetworkAttachmentsPresent() {
        return removedNetworkAttachments != null && !removedNetworkAttachments.isEmpty();
    }
    
    public String resolutionType() {
        return resolutionType;
    }
    
    public void resolutionType(String newResolutionType) {
        resolutionType = newResolutionType;
    }
    
    public boolean resolutionTypePresent() {
        return resolutionType != null;
    }
    
    public boolean restoreMemory() {
        return restoreMemory;
    }
    
    public void restoreMemory(boolean newRestoreMemory) {
        restoreMemory = Boolean.valueOf(newRestoreMemory);
    }
    
    public void restoreMemory(Boolean newRestoreMemory) {
        restoreMemory = newRestoreMemory;
    }
    
    public boolean restoreMemoryPresent() {
        return restoreMemory != null;
    }
    
    public String rootPassword() {
        return rootPassword;
    }
    
    public void rootPassword(String newRootPassword) {
        rootPassword = newRootPassword;
    }
    
    public boolean rootPasswordPresent() {
        return rootPassword != null;
    }
    
    public boolean seal() {
        return seal;
    }
    
    public void seal(boolean newSeal) {
        seal = Boolean.valueOf(newSeal);
    }
    
    public void seal(Boolean newSeal) {
        seal = newSeal;
    }
    
    public boolean sealPresent() {
        return seal != null;
    }
    
    public Snapshot snapshot() {
        return snapshot;
    }
    
    public void snapshot(Snapshot newSnapshot) {
        snapshot = newSnapshot;
    }
    
    public boolean snapshotPresent() {
        return snapshot != null;
    }
    
    public Host sourceHost() {
        return sourceHost;
    }
    
    public void sourceHost(Host newSourceHost) {
        sourceHost = newSourceHost;
    }
    
    public boolean sourceHostPresent() {
        return sourceHost != null;
    }
    
    public Ssh ssh() {
        return ssh;
    }
    
    public void ssh(Ssh newSsh) {
        ssh = newSsh;
    }
    
    public boolean sshPresent() {
        return ssh != null;
    }
    
    public String status() {
        return status;
    }
    
    public void status(String newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public boolean stopGlusterService() {
        return stopGlusterService;
    }
    
    public void stopGlusterService(boolean newStopGlusterService) {
        stopGlusterService = Boolean.valueOf(newStopGlusterService);
    }
    
    public void stopGlusterService(Boolean newStopGlusterService) {
        stopGlusterService = newStopGlusterService;
    }
    
    public boolean stopGlusterServicePresent() {
        return stopGlusterService != null;
    }
    
    public StorageDomain storageDomain() {
        return storageDomain;
    }
    
    public void storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
    }
    
    public boolean storageDomainPresent() {
        return storageDomain != null;
    }
    
    public List<StorageDomain> storageDomains() {
        return makeUnmodifiableList(storageDomains);
    }
    
    public void storageDomains(List<StorageDomain> newStorageDomains) {
        storageDomains = makeArrayList(newStorageDomains);
    }
    
    public boolean storageDomainsPresent() {
        return storageDomains != null && !storageDomains.isEmpty();
    }
    
    public boolean succeeded() {
        return succeeded;
    }
    
    public void succeeded(boolean newSucceeded) {
        succeeded = Boolean.valueOf(newSucceeded);
    }
    
    public void succeeded(Boolean newSucceeded) {
        succeeded = newSucceeded;
    }
    
    public boolean succeededPresent() {
        return succeeded != null;
    }
    
    public List<NetworkAttachment> synchronizedNetworkAttachments() {
        return makeUnmodifiableList(synchronizedNetworkAttachments);
    }
    
    public void synchronizedNetworkAttachments(List<NetworkAttachment> newSynchronizedNetworkAttachments) {
        synchronizedNetworkAttachments = makeArrayList(newSynchronizedNetworkAttachments);
    }
    
    public boolean synchronizedNetworkAttachmentsPresent() {
        return synchronizedNetworkAttachments != null && !synchronizedNetworkAttachments.isEmpty();
    }
    
    public Template template() {
        return template;
    }
    
    public void template(Template newTemplate) {
        template = newTemplate;
    }
    
    public boolean templatePresent() {
        return template != null;
    }
    
    public Ticket ticket() {
        return ticket;
    }
    
    public void ticket(Ticket newTicket) {
        ticket = newTicket;
    }
    
    public boolean ticketPresent() {
        return ticket != null;
    }
    
    public BigInteger timeout() {
        return timeout;
    }
    
    public Byte timeoutAsByte() {
        return asByte("Action", "timeout", timeout);
    }
    
    public Short timeoutAsShort() {
        return asShort("Action", "timeout", timeout);
    }
    
    public Integer timeoutAsInteger() {
        return asInteger("Action", "timeout", timeout);
    }
    
    public Long timeoutAsLong() {
        return asLong("Action", "timeout", timeout);
    }
    
    public void timeout(BigInteger newTimeout) {
        timeout = newTimeout;
    }
    
    public boolean timeoutPresent() {
        return timeout != null;
    }
    
    public boolean undeployHostedEngine() {
        return undeployHostedEngine;
    }
    
    public void undeployHostedEngine(boolean newUndeployHostedEngine) {
        undeployHostedEngine = Boolean.valueOf(newUndeployHostedEngine);
    }
    
    public void undeployHostedEngine(Boolean newUndeployHostedEngine) {
        undeployHostedEngine = newUndeployHostedEngine;
    }
    
    public boolean undeployHostedEnginePresent() {
        return undeployHostedEngine != null;
    }
    
    public ClusterUpgradeAction upgradeAction() {
        return upgradeAction;
    }
    
    public void upgradeAction(ClusterUpgradeAction newUpgradeAction) {
        upgradeAction = newUpgradeAction;
    }
    
    public boolean upgradeActionPresent() {
        return upgradeAction != null;
    }
    
    public boolean useCloudInit() {
        return useCloudInit;
    }
    
    public void useCloudInit(boolean newUseCloudInit) {
        useCloudInit = Boolean.valueOf(newUseCloudInit);
    }
    
    public void useCloudInit(Boolean newUseCloudInit) {
        useCloudInit = newUseCloudInit;
    }
    
    public boolean useCloudInitPresent() {
        return useCloudInit != null;
    }
    
    public boolean useIgnition() {
        return useIgnition;
    }
    
    public void useIgnition(boolean newUseIgnition) {
        useIgnition = Boolean.valueOf(newUseIgnition);
    }
    
    public void useIgnition(Boolean newUseIgnition) {
        useIgnition = newUseIgnition;
    }
    
    public boolean useIgnitionPresent() {
        return useIgnition != null;
    }
    
    public boolean useInitialization() {
        return useInitialization;
    }
    
    public void useInitialization(boolean newUseInitialization) {
        useInitialization = Boolean.valueOf(newUseInitialization);
    }
    
    public void useInitialization(Boolean newUseInitialization) {
        useInitialization = newUseInitialization;
    }
    
    public boolean useInitializationPresent() {
        return useInitialization != null;
    }
    
    public boolean useSysprep() {
        return useSysprep;
    }
    
    public void useSysprep(boolean newUseSysprep) {
        useSysprep = Boolean.valueOf(newUseSysprep);
    }
    
    public void useSysprep(Boolean newUseSysprep) {
        useSysprep = newUseSysprep;
    }
    
    public boolean useSysprepPresent() {
        return useSysprep != null;
    }
    
    public HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration() {
        return virtualFunctionsConfiguration;
    }
    
    public void virtualFunctionsConfiguration(HostNicVirtualFunctionsConfiguration newVirtualFunctionsConfiguration) {
        virtualFunctionsConfiguration = newVirtualFunctionsConfiguration;
    }
    
    public boolean virtualFunctionsConfigurationPresent() {
        return virtualFunctionsConfiguration != null;
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
    public List<VnicProfileMapping> vnicProfileMappings() {
        return makeUnmodifiableList(vnicProfileMappings);
    }
    
    public void vnicProfileMappings(List<VnicProfileMapping> newVnicProfileMappings) {
        vnicProfileMappings = makeArrayList(newVnicProfileMappings);
    }
    
    public boolean vnicProfileMappingsPresent() {
        return vnicProfileMappings != null && !vnicProfileMappings.isEmpty();
    }
    
    public boolean volatile_() {
        return volatile_;
    }
    
    public void volatile_(boolean newVolatile) {
        volatile_ = Boolean.valueOf(newVolatile);
    }
    
    public void volatile_(Boolean newVolatile) {
        volatile_ = newVolatile;
    }
    
    public boolean volatile_Present() {
        return volatile_ != null;
    }
    
}
