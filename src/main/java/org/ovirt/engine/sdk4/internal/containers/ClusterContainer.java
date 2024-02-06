/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.AffinityGroup;
import org.ovirt.engine.sdk4.types.BiosType;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.ClusterFeature;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Display;
import org.ovirt.engine.sdk4.types.ErrorHandling;
import org.ovirt.engine.sdk4.types.ExternalProvider;
import org.ovirt.engine.sdk4.types.FencingPolicy;
import org.ovirt.engine.sdk4.types.FipsMode;
import org.ovirt.engine.sdk4.types.FirewallType;
import org.ovirt.engine.sdk4.types.GlusterHook;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.Ksm;
import org.ovirt.engine.sdk4.types.LogMaxMemoryUsedThresholdType;
import org.ovirt.engine.sdk4.types.MacPool;
import org.ovirt.engine.sdk4.types.MemoryPolicy;
import org.ovirt.engine.sdk4.types.MigrationOptions;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkFilter;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.RngSource;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;
import org.ovirt.engine.sdk4.types.SerialNumber;
import org.ovirt.engine.sdk4.types.SwitchType;
import org.ovirt.engine.sdk4.types.Version;

public class ClusterContainer extends IdentifiedContainer implements Cluster {
    private Boolean ballooningEnabled;
    private BiosType biosType;
    private Cpu cpu;
    private List<Property> customSchedulingPolicyProperties;
    private Display display;
    private ErrorHandling errorHandling;
    private FencingPolicy fencingPolicy;
    private FipsMode fipsMode;
    private FirewallType firewallType;
    private Boolean glusterService;
    private String glusterTunedProfile;
    private Boolean haReservation;
    private Ksm ksm;
    private BigInteger logMaxMemoryUsedThreshold;
    private LogMaxMemoryUsedThresholdType logMaxMemoryUsedThresholdType;
    private Boolean maintenanceReasonRequired;
    private MemoryPolicy memoryPolicy;
    private MigrationOptions migration;
    private Boolean optionalReason;
    private List<RngSource> requiredRngSources;
    private SerialNumber serialNumber;
    private List<Version> supportedVersions;
    private SwitchType switchType;
    private Boolean threadsAsCores;
    private Boolean trustedService;
    private Boolean tunnelMigration;
    private Version version;
    private Boolean virtService;
    private Boolean vncEncryption;
    private List<AffinityGroup> affinityGroups;
    private List<CpuProfile> cpuProfiles;
    private DataCenter dataCenter;
    private List<ClusterFeature> enabledFeatures;
    private List<ExternalProvider> externalNetworkProviders;
    private List<GlusterHook> glusterHooks;
    private List<GlusterVolume> glusterVolumes;
    private MacPool macPool;
    private Network managementNetwork;
    private List<NetworkFilter> networkFilters;
    private List<Network> networks;
    private List<Permission> permissions;
    private SchedulingPolicy schedulingPolicy;
    
    public boolean ballooningEnabled() {
        return ballooningEnabled;
    }
    
    public void ballooningEnabled(boolean newBallooningEnabled) {
        ballooningEnabled = Boolean.valueOf(newBallooningEnabled);
    }
    
    public void ballooningEnabled(Boolean newBallooningEnabled) {
        ballooningEnabled = newBallooningEnabled;
    }
    
    public boolean ballooningEnabledPresent() {
        return ballooningEnabled != null;
    }
    
    public BiosType biosType() {
        return biosType;
    }
    
    public void biosType(BiosType newBiosType) {
        biosType = newBiosType;
    }
    
    public boolean biosTypePresent() {
        return biosType != null;
    }
    
    public Cpu cpu() {
        return cpu;
    }
    
    public void cpu(Cpu newCpu) {
        cpu = newCpu;
    }
    
    public boolean cpuPresent() {
        return cpu != null;
    }
    
    public List<Property> customSchedulingPolicyProperties() {
        return makeUnmodifiableList(customSchedulingPolicyProperties);
    }
    
    public void customSchedulingPolicyProperties(List<Property> newCustomSchedulingPolicyProperties) {
        customSchedulingPolicyProperties = makeArrayList(newCustomSchedulingPolicyProperties);
    }
    
    public boolean customSchedulingPolicyPropertiesPresent() {
        return customSchedulingPolicyProperties != null && !customSchedulingPolicyProperties.isEmpty();
    }
    
    public Display display() {
        return display;
    }
    
    public void display(Display newDisplay) {
        display = newDisplay;
    }
    
    public boolean displayPresent() {
        return display != null;
    }
    
    public ErrorHandling errorHandling() {
        return errorHandling;
    }
    
    public void errorHandling(ErrorHandling newErrorHandling) {
        errorHandling = newErrorHandling;
    }
    
    public boolean errorHandlingPresent() {
        return errorHandling != null;
    }
    
    public FencingPolicy fencingPolicy() {
        return fencingPolicy;
    }
    
    public void fencingPolicy(FencingPolicy newFencingPolicy) {
        fencingPolicy = newFencingPolicy;
    }
    
    public boolean fencingPolicyPresent() {
        return fencingPolicy != null;
    }
    
    public FipsMode fipsMode() {
        return fipsMode;
    }
    
    public void fipsMode(FipsMode newFipsMode) {
        fipsMode = newFipsMode;
    }
    
    public boolean fipsModePresent() {
        return fipsMode != null;
    }
    
    public FirewallType firewallType() {
        return firewallType;
    }
    
    public void firewallType(FirewallType newFirewallType) {
        firewallType = newFirewallType;
    }
    
    public boolean firewallTypePresent() {
        return firewallType != null;
    }
    
    public boolean glusterService() {
        return glusterService;
    }
    
    public void glusterService(boolean newGlusterService) {
        glusterService = Boolean.valueOf(newGlusterService);
    }
    
    public void glusterService(Boolean newGlusterService) {
        glusterService = newGlusterService;
    }
    
    public boolean glusterServicePresent() {
        return glusterService != null;
    }
    
    public String glusterTunedProfile() {
        return glusterTunedProfile;
    }
    
    public void glusterTunedProfile(String newGlusterTunedProfile) {
        glusterTunedProfile = newGlusterTunedProfile;
    }
    
    public boolean glusterTunedProfilePresent() {
        return glusterTunedProfile != null;
    }
    
    public boolean haReservation() {
        return haReservation;
    }
    
    public void haReservation(boolean newHaReservation) {
        haReservation = Boolean.valueOf(newHaReservation);
    }
    
    public void haReservation(Boolean newHaReservation) {
        haReservation = newHaReservation;
    }
    
    public boolean haReservationPresent() {
        return haReservation != null;
    }
    
    public Ksm ksm() {
        return ksm;
    }
    
    public void ksm(Ksm newKsm) {
        ksm = newKsm;
    }
    
    public boolean ksmPresent() {
        return ksm != null;
    }
    
    public BigInteger logMaxMemoryUsedThreshold() {
        return logMaxMemoryUsedThreshold;
    }
    
    public Byte logMaxMemoryUsedThresholdAsByte() {
        return asByte("Cluster", "logMaxMemoryUsedThreshold", logMaxMemoryUsedThreshold);
    }
    
    public Short logMaxMemoryUsedThresholdAsShort() {
        return asShort("Cluster", "logMaxMemoryUsedThreshold", logMaxMemoryUsedThreshold);
    }
    
    public Integer logMaxMemoryUsedThresholdAsInteger() {
        return asInteger("Cluster", "logMaxMemoryUsedThreshold", logMaxMemoryUsedThreshold);
    }
    
    public Long logMaxMemoryUsedThresholdAsLong() {
        return asLong("Cluster", "logMaxMemoryUsedThreshold", logMaxMemoryUsedThreshold);
    }
    
    public void logMaxMemoryUsedThreshold(BigInteger newLogMaxMemoryUsedThreshold) {
        logMaxMemoryUsedThreshold = newLogMaxMemoryUsedThreshold;
    }
    
    public boolean logMaxMemoryUsedThresholdPresent() {
        return logMaxMemoryUsedThreshold != null;
    }
    
    public LogMaxMemoryUsedThresholdType logMaxMemoryUsedThresholdType() {
        return logMaxMemoryUsedThresholdType;
    }
    
    public void logMaxMemoryUsedThresholdType(LogMaxMemoryUsedThresholdType newLogMaxMemoryUsedThresholdType) {
        logMaxMemoryUsedThresholdType = newLogMaxMemoryUsedThresholdType;
    }
    
    public boolean logMaxMemoryUsedThresholdTypePresent() {
        return logMaxMemoryUsedThresholdType != null;
    }
    
    public boolean maintenanceReasonRequired() {
        return maintenanceReasonRequired;
    }
    
    public void maintenanceReasonRequired(boolean newMaintenanceReasonRequired) {
        maintenanceReasonRequired = Boolean.valueOf(newMaintenanceReasonRequired);
    }
    
    public void maintenanceReasonRequired(Boolean newMaintenanceReasonRequired) {
        maintenanceReasonRequired = newMaintenanceReasonRequired;
    }
    
    public boolean maintenanceReasonRequiredPresent() {
        return maintenanceReasonRequired != null;
    }
    
    public MemoryPolicy memoryPolicy() {
        return memoryPolicy;
    }
    
    public void memoryPolicy(MemoryPolicy newMemoryPolicy) {
        memoryPolicy = newMemoryPolicy;
    }
    
    public boolean memoryPolicyPresent() {
        return memoryPolicy != null;
    }
    
    public MigrationOptions migration() {
        return migration;
    }
    
    public void migration(MigrationOptions newMigration) {
        migration = newMigration;
    }
    
    public boolean migrationPresent() {
        return migration != null;
    }
    
    public boolean optionalReason() {
        return optionalReason;
    }
    
    public void optionalReason(boolean newOptionalReason) {
        optionalReason = Boolean.valueOf(newOptionalReason);
    }
    
    public void optionalReason(Boolean newOptionalReason) {
        optionalReason = newOptionalReason;
    }
    
    public boolean optionalReasonPresent() {
        return optionalReason != null;
    }
    
    public List<RngSource> requiredRngSources() {
        return makeUnmodifiableList(requiredRngSources);
    }
    
    public void requiredRngSources(List<RngSource> newRequiredRngSources) {
        requiredRngSources = makeArrayList(newRequiredRngSources);
    }
    
    public boolean requiredRngSourcesPresent() {
        return requiredRngSources != null && !requiredRngSources.isEmpty();
    }
    
    public SerialNumber serialNumber() {
        return serialNumber;
    }
    
    public void serialNumber(SerialNumber newSerialNumber) {
        serialNumber = newSerialNumber;
    }
    
    public boolean serialNumberPresent() {
        return serialNumber != null;
    }
    
    public List<Version> supportedVersions() {
        return makeUnmodifiableList(supportedVersions);
    }
    
    public void supportedVersions(List<Version> newSupportedVersions) {
        supportedVersions = makeArrayList(newSupportedVersions);
    }
    
    public boolean supportedVersionsPresent() {
        return supportedVersions != null && !supportedVersions.isEmpty();
    }
    
    public SwitchType switchType() {
        return switchType;
    }
    
    public void switchType(SwitchType newSwitchType) {
        switchType = newSwitchType;
    }
    
    public boolean switchTypePresent() {
        return switchType != null;
    }
    
    public boolean threadsAsCores() {
        return threadsAsCores;
    }
    
    public void threadsAsCores(boolean newThreadsAsCores) {
        threadsAsCores = Boolean.valueOf(newThreadsAsCores);
    }
    
    public void threadsAsCores(Boolean newThreadsAsCores) {
        threadsAsCores = newThreadsAsCores;
    }
    
    public boolean threadsAsCoresPresent() {
        return threadsAsCores != null;
    }
    
    public boolean trustedService() {
        return trustedService;
    }
    
    public void trustedService(boolean newTrustedService) {
        trustedService = Boolean.valueOf(newTrustedService);
    }
    
    public void trustedService(Boolean newTrustedService) {
        trustedService = newTrustedService;
    }
    
    public boolean trustedServicePresent() {
        return trustedService != null;
    }
    
    public boolean tunnelMigration() {
        return tunnelMigration;
    }
    
    public void tunnelMigration(boolean newTunnelMigration) {
        tunnelMigration = Boolean.valueOf(newTunnelMigration);
    }
    
    public void tunnelMigration(Boolean newTunnelMigration) {
        tunnelMigration = newTunnelMigration;
    }
    
    public boolean tunnelMigrationPresent() {
        return tunnelMigration != null;
    }
    
    public Version version() {
        return version;
    }
    
    public void version(Version newVersion) {
        version = newVersion;
    }
    
    public boolean versionPresent() {
        return version != null;
    }
    
    public boolean virtService() {
        return virtService;
    }
    
    public void virtService(boolean newVirtService) {
        virtService = Boolean.valueOf(newVirtService);
    }
    
    public void virtService(Boolean newVirtService) {
        virtService = newVirtService;
    }
    
    public boolean virtServicePresent() {
        return virtService != null;
    }
    
    public boolean vncEncryption() {
        return vncEncryption;
    }
    
    public void vncEncryption(boolean newVncEncryption) {
        vncEncryption = Boolean.valueOf(newVncEncryption);
    }
    
    public void vncEncryption(Boolean newVncEncryption) {
        vncEncryption = newVncEncryption;
    }
    
    public boolean vncEncryptionPresent() {
        return vncEncryption != null;
    }
    
    public List<AffinityGroup> affinityGroups() {
        return makeUnmodifiableList(affinityGroups);
    }
    
    public void affinityGroups(List<AffinityGroup> newAffinityGroups) {
        affinityGroups = makeArrayList(newAffinityGroups);
    }
    
    public boolean affinityGroupsPresent() {
        return affinityGroups != null && !affinityGroups.isEmpty();
    }
    
    public List<CpuProfile> cpuProfiles() {
        return makeUnmodifiableList(cpuProfiles);
    }
    
    public void cpuProfiles(List<CpuProfile> newCpuProfiles) {
        cpuProfiles = makeArrayList(newCpuProfiles);
    }
    
    public boolean cpuProfilesPresent() {
        return cpuProfiles != null && !cpuProfiles.isEmpty();
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
    
    public List<ClusterFeature> enabledFeatures() {
        return makeUnmodifiableList(enabledFeatures);
    }
    
    public void enabledFeatures(List<ClusterFeature> newEnabledFeatures) {
        enabledFeatures = makeArrayList(newEnabledFeatures);
    }
    
    public boolean enabledFeaturesPresent() {
        return enabledFeatures != null && !enabledFeatures.isEmpty();
    }
    
    public List<ExternalProvider> externalNetworkProviders() {
        return makeUnmodifiableList(externalNetworkProviders);
    }
    
    public void externalNetworkProviders(List<ExternalProvider> newExternalNetworkProviders) {
        externalNetworkProviders = makeArrayList(newExternalNetworkProviders);
    }
    
    public boolean externalNetworkProvidersPresent() {
        return externalNetworkProviders != null && !externalNetworkProviders.isEmpty();
    }
    
    public List<GlusterHook> glusterHooks() {
        return makeUnmodifiableList(glusterHooks);
    }
    
    public void glusterHooks(List<GlusterHook> newGlusterHooks) {
        glusterHooks = makeArrayList(newGlusterHooks);
    }
    
    public boolean glusterHooksPresent() {
        return glusterHooks != null && !glusterHooks.isEmpty();
    }
    
    public List<GlusterVolume> glusterVolumes() {
        return makeUnmodifiableList(glusterVolumes);
    }
    
    public void glusterVolumes(List<GlusterVolume> newGlusterVolumes) {
        glusterVolumes = makeArrayList(newGlusterVolumes);
    }
    
    public boolean glusterVolumesPresent() {
        return glusterVolumes != null && !glusterVolumes.isEmpty();
    }
    
    public MacPool macPool() {
        return macPool;
    }
    
    public void macPool(MacPool newMacPool) {
        macPool = newMacPool;
    }
    
    public boolean macPoolPresent() {
        return macPool != null;
    }
    
    public Network managementNetwork() {
        return managementNetwork;
    }
    
    public void managementNetwork(Network newManagementNetwork) {
        managementNetwork = newManagementNetwork;
    }
    
    public boolean managementNetworkPresent() {
        return managementNetwork != null;
    }
    
    public List<NetworkFilter> networkFilters() {
        return makeUnmodifiableList(networkFilters);
    }
    
    public void networkFilters(List<NetworkFilter> newNetworkFilters) {
        networkFilters = makeArrayList(newNetworkFilters);
    }
    
    public boolean networkFiltersPresent() {
        return networkFilters != null && !networkFilters.isEmpty();
    }
    
    public List<Network> networks() {
        return makeUnmodifiableList(networks);
    }
    
    public void networks(List<Network> newNetworks) {
        networks = makeArrayList(newNetworks);
    }
    
    public boolean networksPresent() {
        return networks != null && !networks.isEmpty();
    }
    
    public List<Permission> permissions() {
        return makeUnmodifiableList(permissions);
    }
    
    public void permissions(List<Permission> newPermissions) {
        permissions = makeArrayList(newPermissions);
    }
    
    public boolean permissionsPresent() {
        return permissions != null && !permissions.isEmpty();
    }
    
    public SchedulingPolicy schedulingPolicy() {
        return schedulingPolicy;
    }
    
    public void schedulingPolicy(SchedulingPolicy newSchedulingPolicy) {
        schedulingPolicy = newSchedulingPolicy;
    }
    
    public boolean schedulingPolicyPresent() {
        return schedulingPolicy != null;
    }
    
}
