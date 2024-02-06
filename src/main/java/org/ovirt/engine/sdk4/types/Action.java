/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

public interface Action extends Identified {
    boolean activate();
    
    boolean activatePresent();
    
    boolean allowPartialImport();
    
    boolean allowPartialImportPresent();
    
    boolean async();
    
    boolean asyncPresent();
    
    DiskAttachment attachment();
    
    boolean attachmentPresent();
    
    AuthorizedKey authorizedKey();
    
    boolean authorizedKeyPresent();
    
    AutoPinningPolicy autoPinningPolicy();
    
    boolean autoPinningPolicyPresent();
    
    List<GlusterBrick> bricks();
    
    boolean bricksPresent();
    
    List<Certificate> certificates();
    
    boolean certificatesPresent();
    
    boolean checkConnectivity();
    
    boolean checkConnectivityPresent();
    
    boolean clone_();
    
    boolean clone_Present();
    
    boolean clonePermissions();
    
    boolean clonePermissionsPresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    boolean collapseSnapshots();
    
    boolean collapseSnapshotsPresent();
    
    boolean commitOnSuccess();
    
    boolean commitOnSuccessPresent();
    
    StorageConnection connection();
    
    boolean connectionPresent();
    
    BigInteger connectivityTimeout();
    Byte connectivityTimeoutAsByte();
    Short connectivityTimeoutAsShort();
    Integer connectivityTimeoutAsInteger();
    Long connectivityTimeoutAsLong();
    
    boolean connectivityTimeoutPresent();
    
    DataCenter dataCenter();
    
    boolean dataCenterPresent();
    
    boolean deployHostedEngine();
    
    boolean deployHostedEnginePresent();
    
    GlusterVolumeProfileDetails details();
    
    boolean detailsPresent();
    
    String directory();
    
    boolean directoryPresent();
    
    boolean discardSnapshots();
    
    boolean discardSnapshotsPresent();
    
    List<IscsiDetails> discoveredTargets();
    
    boolean discoveredTargetsPresent();
    
    Disk disk();
    
    boolean diskPresent();
    
    DiskProfile diskProfile();
    
    boolean diskProfilePresent();
    
    List<Disk> disks();
    
    boolean disksPresent();
    
    boolean exclusive();
    
    boolean exclusivePresent();
    
    Fault fault();
    
    boolean faultPresent();
    
    String fenceType();
    
    boolean fenceTypePresent();
    
    String filename();
    
    boolean filenamePresent();
    
    boolean filter();
    
    boolean filterPresent();
    
    boolean fixLayout();
    
    boolean fixLayoutPresent();
    
    boolean force();
    
    boolean forcePresent();
    
    GracePeriod gracePeriod();
    
    boolean gracePeriodPresent();
    
    Host host();
    
    boolean hostPresent();
    
    String image();
    
    boolean imagePresent();
    
    ImageTransfer imageTransfer();
    
    boolean imageTransferPresent();
    
    boolean importAsTemplate();
    
    boolean importAsTemplatePresent();
    
    boolean isAttached();
    
    boolean isAttachedPresent();
    
    IscsiDetails iscsi();
    
    boolean iscsiPresent();
    
    List<String> iscsiTargets();
    
    boolean iscsiTargetsPresent();
    
    Job job();
    
    boolean jobPresent();
    
    StorageDomainLease lease();
    
    boolean leasePresent();
    
    List<LogicalUnit> logicalUnits();
    
    boolean logicalUnitsPresent();
    
    boolean maintenanceAfterRestart();
    
    boolean maintenanceAfterRestartPresent();
    
    boolean maintenanceEnabled();
    
    boolean maintenanceEnabledPresent();
    
    boolean migrateVmsInAffinityClosure();
    
    boolean migrateVmsInAffinityClosurePresent();
    
    List<HostNic> modifiedBonds();
    
    boolean modifiedBondsPresent();
    
    List<NetworkLabel> modifiedLabels();
    
    boolean modifiedLabelsPresent();
    
    List<NetworkAttachment> modifiedNetworkAttachments();
    
    boolean modifiedNetworkAttachmentsPresent();
    
    boolean optimizeCpuSettings();
    
    boolean optimizeCpuSettingsPresent();
    
    Option option();
    
    boolean optionPresent();
    
    boolean pause();
    
    boolean pausePresent();
    
    Permission permission();
    
    boolean permissionPresent();
    
    PowerManagement powerManagement();
    
    boolean powerManagementPresent();
    
    ProxyTicket proxyTicket();
    
    boolean proxyTicketPresent();
    
    Quota quota();
    
    boolean quotaPresent();
    
    String reason();
    
    boolean reasonPresent();
    
    boolean reassignBadMacs();
    
    boolean reassignBadMacsPresent();
    
    boolean reboot();
    
    boolean rebootPresent();
    
    RegistrationConfiguration registrationConfiguration();
    
    boolean registrationConfigurationPresent();
    
    String remoteViewerConnectionFile();
    
    boolean remoteViewerConnectionFilePresent();
    
    List<HostNic> removedBonds();
    
    boolean removedBondsPresent();
    
    List<NetworkLabel> removedLabels();
    
    boolean removedLabelsPresent();
    
    List<NetworkAttachment> removedNetworkAttachments();
    
    boolean removedNetworkAttachmentsPresent();
    
    String resolutionType();
    
    boolean resolutionTypePresent();
    
    boolean restoreMemory();
    
    boolean restoreMemoryPresent();
    
    String rootPassword();
    
    boolean rootPasswordPresent();
    
    boolean seal();
    
    boolean sealPresent();
    
    Snapshot snapshot();
    
    boolean snapshotPresent();
    
    Host sourceHost();
    
    boolean sourceHostPresent();
    
    Ssh ssh();
    
    boolean sshPresent();
    
    String status();
    
    boolean statusPresent();
    
    boolean stopGlusterService();
    
    boolean stopGlusterServicePresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
    List<StorageDomain> storageDomains();
    
    boolean storageDomainsPresent();
    
    boolean succeeded();
    
    boolean succeededPresent();
    
    List<NetworkAttachment> synchronizedNetworkAttachments();
    
    boolean synchronizedNetworkAttachmentsPresent();
    
    Template template();
    
    boolean templatePresent();
    
    Ticket ticket();
    
    boolean ticketPresent();
    
    BigInteger timeout();
    Byte timeoutAsByte();
    Short timeoutAsShort();
    Integer timeoutAsInteger();
    Long timeoutAsLong();
    
    boolean timeoutPresent();
    
    boolean undeployHostedEngine();
    
    boolean undeployHostedEnginePresent();
    
    ClusterUpgradeAction upgradeAction();
    
    boolean upgradeActionPresent();
    
    boolean useCloudInit();
    
    boolean useCloudInitPresent();
    
    boolean useIgnition();
    
    boolean useIgnitionPresent();
    
    boolean useInitialization();
    
    boolean useInitializationPresent();
    
    boolean useSysprep();
    
    boolean useSysprepPresent();
    
    HostNicVirtualFunctionsConfiguration virtualFunctionsConfiguration();
    
    boolean virtualFunctionsConfigurationPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
    List<VnicProfileMapping> vnicProfileMappings();
    
    boolean vnicProfileMappingsPresent();
    
    boolean volatile_();
    
    boolean volatile_Present();
    
}
