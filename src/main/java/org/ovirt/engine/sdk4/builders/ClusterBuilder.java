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
import org.ovirt.engine.sdk4.internal.containers.ClusterContainer;
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

public class ClusterBuilder {
    private List<AffinityGroup> affinityGroups;
    private Boolean ballooningEnabled;
    private BiosType biosType;
    private String comment;
    private Cpu cpu;
    private List<CpuProfile> cpuProfiles;
    private List<Property> customSchedulingPolicyProperties;
    private DataCenter dataCenter;
    private String description;
    private Display display;
    private List<ClusterFeature> enabledFeatures;
    private ErrorHandling errorHandling;
    private List<ExternalProvider> externalNetworkProviders;
    private FencingPolicy fencingPolicy;
    private FipsMode fipsMode;
    private FirewallType firewallType;
    private List<GlusterHook> glusterHooks;
    private Boolean glusterService;
    private String glusterTunedProfile;
    private List<GlusterVolume> glusterVolumes;
    private Boolean haReservation;
    private String href;
    private String id;
    private Ksm ksm;
    private BigInteger logMaxMemoryUsedThreshold;
    private LogMaxMemoryUsedThresholdType logMaxMemoryUsedThresholdType;
    private MacPool macPool;
    private Boolean maintenanceReasonRequired;
    private Network managementNetwork;
    private MemoryPolicy memoryPolicy;
    private MigrationOptions migration;
    private String name;
    private List<NetworkFilter> networkFilters;
    private List<Network> networks;
    private Boolean optionalReason;
    private List<Permission> permissions;
    private List<RngSource> requiredRngSources;
    private SchedulingPolicy schedulingPolicy;
    private SerialNumber serialNumber;
    private List<Version> supportedVersions;
    private SwitchType switchType;
    private Boolean threadsAsCores;
    private Boolean trustedService;
    private Boolean tunnelMigration;
    private Version version;
    private Boolean virtService;
    private Boolean vncEncryption;
    
    public ClusterBuilder affinityGroups(List<AffinityGroup> newAffinityGroups) {
        if (newAffinityGroups != null) {
            if (affinityGroups == null) {
                affinityGroups = new ArrayList<>(newAffinityGroups);
            }
            else {
                affinityGroups.addAll(newAffinityGroups);
            }
        }
        return this;
    }
    
    public ClusterBuilder affinityGroups(AffinityGroup... newAffinityGroups) {
        if (newAffinityGroups != null) {
            if (affinityGroups == null) {
                affinityGroups = new ArrayList<>(newAffinityGroups.length);
            }
            Collections.addAll(affinityGroups, newAffinityGroups);
        }
        return this;
    }
    
    public ClusterBuilder affinityGroups(AffinityGroupBuilder... newAffinityGroups) {
        if (newAffinityGroups != null) {
            if (affinityGroups == null) {
                affinityGroups = new ArrayList<>(newAffinityGroups.length);
            }
            for (AffinityGroupBuilder builder : newAffinityGroups) {
                affinityGroups.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder ballooningEnabled(boolean newBallooningEnabled) {
        ballooningEnabled = Boolean.valueOf(newBallooningEnabled);
        return this;
    }
    
    public ClusterBuilder ballooningEnabled(Boolean newBallooningEnabled) {
        ballooningEnabled = newBallooningEnabled;
        return this;
    }
    
    
    public ClusterBuilder biosType(BiosType newBiosType) {
        biosType = newBiosType;
        return this;
    }
    
    
    public ClusterBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ClusterBuilder cpu(Cpu newCpu) {
        cpu = newCpu;
        return this;
    }
    
    public ClusterBuilder cpu(CpuBuilder newCpu) {
        if (newCpu == null) {
            cpu = null;
        }
        else {
            cpu = newCpu.build();
        }
        return this;
    }
    
    
    public ClusterBuilder cpuProfiles(List<CpuProfile> newCpuProfiles) {
        if (newCpuProfiles != null) {
            if (cpuProfiles == null) {
                cpuProfiles = new ArrayList<>(newCpuProfiles);
            }
            else {
                cpuProfiles.addAll(newCpuProfiles);
            }
        }
        return this;
    }
    
    public ClusterBuilder cpuProfiles(CpuProfile... newCpuProfiles) {
        if (newCpuProfiles != null) {
            if (cpuProfiles == null) {
                cpuProfiles = new ArrayList<>(newCpuProfiles.length);
            }
            Collections.addAll(cpuProfiles, newCpuProfiles);
        }
        return this;
    }
    
    public ClusterBuilder cpuProfiles(CpuProfileBuilder... newCpuProfiles) {
        if (newCpuProfiles != null) {
            if (cpuProfiles == null) {
                cpuProfiles = new ArrayList<>(newCpuProfiles.length);
            }
            for (CpuProfileBuilder builder : newCpuProfiles) {
                cpuProfiles.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder customSchedulingPolicyProperties(List<Property> newCustomSchedulingPolicyProperties) {
        if (newCustomSchedulingPolicyProperties != null) {
            if (customSchedulingPolicyProperties == null) {
                customSchedulingPolicyProperties = new ArrayList<>(newCustomSchedulingPolicyProperties);
            }
            else {
                customSchedulingPolicyProperties.addAll(newCustomSchedulingPolicyProperties);
            }
        }
        return this;
    }
    
    public ClusterBuilder customSchedulingPolicyProperties(Property... newCustomSchedulingPolicyProperties) {
        if (newCustomSchedulingPolicyProperties != null) {
            if (customSchedulingPolicyProperties == null) {
                customSchedulingPolicyProperties = new ArrayList<>(newCustomSchedulingPolicyProperties.length);
            }
            Collections.addAll(customSchedulingPolicyProperties, newCustomSchedulingPolicyProperties);
        }
        return this;
    }
    
    public ClusterBuilder customSchedulingPolicyProperties(PropertyBuilder... newCustomSchedulingPolicyProperties) {
        if (newCustomSchedulingPolicyProperties != null) {
            if (customSchedulingPolicyProperties == null) {
                customSchedulingPolicyProperties = new ArrayList<>(newCustomSchedulingPolicyProperties.length);
            }
            for (PropertyBuilder builder : newCustomSchedulingPolicyProperties) {
                customSchedulingPolicyProperties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public ClusterBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public ClusterBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ClusterBuilder display(Display newDisplay) {
        display = newDisplay;
        return this;
    }
    
    public ClusterBuilder display(DisplayBuilder newDisplay) {
        if (newDisplay == null) {
            display = null;
        }
        else {
            display = newDisplay.build();
        }
        return this;
    }
    
    
    public ClusterBuilder enabledFeatures(List<ClusterFeature> newEnabledFeatures) {
        if (newEnabledFeatures != null) {
            if (enabledFeatures == null) {
                enabledFeatures = new ArrayList<>(newEnabledFeatures);
            }
            else {
                enabledFeatures.addAll(newEnabledFeatures);
            }
        }
        return this;
    }
    
    public ClusterBuilder enabledFeatures(ClusterFeature... newEnabledFeatures) {
        if (newEnabledFeatures != null) {
            if (enabledFeatures == null) {
                enabledFeatures = new ArrayList<>(newEnabledFeatures.length);
            }
            Collections.addAll(enabledFeatures, newEnabledFeatures);
        }
        return this;
    }
    
    public ClusterBuilder enabledFeatures(ClusterFeatureBuilder... newEnabledFeatures) {
        if (newEnabledFeatures != null) {
            if (enabledFeatures == null) {
                enabledFeatures = new ArrayList<>(newEnabledFeatures.length);
            }
            for (ClusterFeatureBuilder builder : newEnabledFeatures) {
                enabledFeatures.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder errorHandling(ErrorHandling newErrorHandling) {
        errorHandling = newErrorHandling;
        return this;
    }
    
    public ClusterBuilder errorHandling(ErrorHandlingBuilder newErrorHandling) {
        if (newErrorHandling == null) {
            errorHandling = null;
        }
        else {
            errorHandling = newErrorHandling.build();
        }
        return this;
    }
    
    
    public ClusterBuilder externalNetworkProviders(List<ExternalProvider> newExternalNetworkProviders) {
        if (newExternalNetworkProviders != null) {
            if (externalNetworkProviders == null) {
                externalNetworkProviders = new ArrayList<>(newExternalNetworkProviders);
            }
            else {
                externalNetworkProviders.addAll(newExternalNetworkProviders);
            }
        }
        return this;
    }
    
    public ClusterBuilder externalNetworkProviders(ExternalProvider... newExternalNetworkProviders) {
        if (newExternalNetworkProviders != null) {
            if (externalNetworkProviders == null) {
                externalNetworkProviders = new ArrayList<>(newExternalNetworkProviders.length);
            }
            Collections.addAll(externalNetworkProviders, newExternalNetworkProviders);
        }
        return this;
    }
    
    public ClusterBuilder externalNetworkProviders(ExternalProviderBuilder... newExternalNetworkProviders) {
        if (newExternalNetworkProviders != null) {
            if (externalNetworkProviders == null) {
                externalNetworkProviders = new ArrayList<>(newExternalNetworkProviders.length);
            }
            for (ExternalProviderBuilder builder : newExternalNetworkProviders) {
                externalNetworkProviders.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder fencingPolicy(FencingPolicy newFencingPolicy) {
        fencingPolicy = newFencingPolicy;
        return this;
    }
    
    public ClusterBuilder fencingPolicy(FencingPolicyBuilder newFencingPolicy) {
        if (newFencingPolicy == null) {
            fencingPolicy = null;
        }
        else {
            fencingPolicy = newFencingPolicy.build();
        }
        return this;
    }
    
    
    public ClusterBuilder fipsMode(FipsMode newFipsMode) {
        fipsMode = newFipsMode;
        return this;
    }
    
    
    public ClusterBuilder firewallType(FirewallType newFirewallType) {
        firewallType = newFirewallType;
        return this;
    }
    
    
    public ClusterBuilder glusterHooks(List<GlusterHook> newGlusterHooks) {
        if (newGlusterHooks != null) {
            if (glusterHooks == null) {
                glusterHooks = new ArrayList<>(newGlusterHooks);
            }
            else {
                glusterHooks.addAll(newGlusterHooks);
            }
        }
        return this;
    }
    
    public ClusterBuilder glusterHooks(GlusterHook... newGlusterHooks) {
        if (newGlusterHooks != null) {
            if (glusterHooks == null) {
                glusterHooks = new ArrayList<>(newGlusterHooks.length);
            }
            Collections.addAll(glusterHooks, newGlusterHooks);
        }
        return this;
    }
    
    public ClusterBuilder glusterHooks(GlusterHookBuilder... newGlusterHooks) {
        if (newGlusterHooks != null) {
            if (glusterHooks == null) {
                glusterHooks = new ArrayList<>(newGlusterHooks.length);
            }
            for (GlusterHookBuilder builder : newGlusterHooks) {
                glusterHooks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder glusterService(boolean newGlusterService) {
        glusterService = Boolean.valueOf(newGlusterService);
        return this;
    }
    
    public ClusterBuilder glusterService(Boolean newGlusterService) {
        glusterService = newGlusterService;
        return this;
    }
    
    
    public ClusterBuilder glusterTunedProfile(String newGlusterTunedProfile) {
        glusterTunedProfile = newGlusterTunedProfile;
        return this;
    }
    
    
    public ClusterBuilder glusterVolumes(List<GlusterVolume> newGlusterVolumes) {
        if (newGlusterVolumes != null) {
            if (glusterVolumes == null) {
                glusterVolumes = new ArrayList<>(newGlusterVolumes);
            }
            else {
                glusterVolumes.addAll(newGlusterVolumes);
            }
        }
        return this;
    }
    
    public ClusterBuilder glusterVolumes(GlusterVolume... newGlusterVolumes) {
        if (newGlusterVolumes != null) {
            if (glusterVolumes == null) {
                glusterVolumes = new ArrayList<>(newGlusterVolumes.length);
            }
            Collections.addAll(glusterVolumes, newGlusterVolumes);
        }
        return this;
    }
    
    public ClusterBuilder glusterVolumes(GlusterVolumeBuilder... newGlusterVolumes) {
        if (newGlusterVolumes != null) {
            if (glusterVolumes == null) {
                glusterVolumes = new ArrayList<>(newGlusterVolumes.length);
            }
            for (GlusterVolumeBuilder builder : newGlusterVolumes) {
                glusterVolumes.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder haReservation(boolean newHaReservation) {
        haReservation = Boolean.valueOf(newHaReservation);
        return this;
    }
    
    public ClusterBuilder haReservation(Boolean newHaReservation) {
        haReservation = newHaReservation;
        return this;
    }
    
    
    public ClusterBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ClusterBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ClusterBuilder ksm(Ksm newKsm) {
        ksm = newKsm;
        return this;
    }
    
    public ClusterBuilder ksm(KsmBuilder newKsm) {
        if (newKsm == null) {
            ksm = null;
        }
        else {
            ksm = newKsm.build();
        }
        return this;
    }
    
    
    public ClusterBuilder logMaxMemoryUsedThreshold(int newLogMaxMemoryUsedThreshold) {
        logMaxMemoryUsedThreshold = BigInteger.valueOf((long) newLogMaxMemoryUsedThreshold);
        return this;
    }
    
    public ClusterBuilder logMaxMemoryUsedThreshold(Integer newLogMaxMemoryUsedThreshold) {
        if (newLogMaxMemoryUsedThreshold == null) {
            logMaxMemoryUsedThreshold = null;
        }
        else {
            logMaxMemoryUsedThreshold = BigInteger.valueOf(newLogMaxMemoryUsedThreshold.longValue());
        }
        return this;
    }
    
    public ClusterBuilder logMaxMemoryUsedThreshold(long newLogMaxMemoryUsedThreshold) {
        logMaxMemoryUsedThreshold = BigInteger.valueOf(newLogMaxMemoryUsedThreshold);
        return this;
    }
    
    public ClusterBuilder logMaxMemoryUsedThreshold(Long newLogMaxMemoryUsedThreshold) {
        if (newLogMaxMemoryUsedThreshold == null) {
            logMaxMemoryUsedThreshold = null;
        }
        else {
            logMaxMemoryUsedThreshold = BigInteger.valueOf(newLogMaxMemoryUsedThreshold.longValue());
        }
        return this;
    }
    
    public ClusterBuilder logMaxMemoryUsedThreshold(BigInteger newLogMaxMemoryUsedThreshold) {
        logMaxMemoryUsedThreshold = newLogMaxMemoryUsedThreshold;
        return this;
    }
    
    
    public ClusterBuilder logMaxMemoryUsedThresholdType(LogMaxMemoryUsedThresholdType newLogMaxMemoryUsedThresholdType) {
        logMaxMemoryUsedThresholdType = newLogMaxMemoryUsedThresholdType;
        return this;
    }
    
    
    public ClusterBuilder macPool(MacPool newMacPool) {
        macPool = newMacPool;
        return this;
    }
    
    public ClusterBuilder macPool(MacPoolBuilder newMacPool) {
        if (newMacPool == null) {
            macPool = null;
        }
        else {
            macPool = newMacPool.build();
        }
        return this;
    }
    
    
    public ClusterBuilder maintenanceReasonRequired(boolean newMaintenanceReasonRequired) {
        maintenanceReasonRequired = Boolean.valueOf(newMaintenanceReasonRequired);
        return this;
    }
    
    public ClusterBuilder maintenanceReasonRequired(Boolean newMaintenanceReasonRequired) {
        maintenanceReasonRequired = newMaintenanceReasonRequired;
        return this;
    }
    
    
    public ClusterBuilder managementNetwork(Network newManagementNetwork) {
        managementNetwork = newManagementNetwork;
        return this;
    }
    
    public ClusterBuilder managementNetwork(NetworkBuilder newManagementNetwork) {
        if (newManagementNetwork == null) {
            managementNetwork = null;
        }
        else {
            managementNetwork = newManagementNetwork.build();
        }
        return this;
    }
    
    
    public ClusterBuilder memoryPolicy(MemoryPolicy newMemoryPolicy) {
        memoryPolicy = newMemoryPolicy;
        return this;
    }
    
    public ClusterBuilder memoryPolicy(MemoryPolicyBuilder newMemoryPolicy) {
        if (newMemoryPolicy == null) {
            memoryPolicy = null;
        }
        else {
            memoryPolicy = newMemoryPolicy.build();
        }
        return this;
    }
    
    
    public ClusterBuilder migration(MigrationOptions newMigration) {
        migration = newMigration;
        return this;
    }
    
    public ClusterBuilder migration(MigrationOptionsBuilder newMigration) {
        if (newMigration == null) {
            migration = null;
        }
        else {
            migration = newMigration.build();
        }
        return this;
    }
    
    
    public ClusterBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ClusterBuilder networkFilters(List<NetworkFilter> newNetworkFilters) {
        if (newNetworkFilters != null) {
            if (networkFilters == null) {
                networkFilters = new ArrayList<>(newNetworkFilters);
            }
            else {
                networkFilters.addAll(newNetworkFilters);
            }
        }
        return this;
    }
    
    public ClusterBuilder networkFilters(NetworkFilter... newNetworkFilters) {
        if (newNetworkFilters != null) {
            if (networkFilters == null) {
                networkFilters = new ArrayList<>(newNetworkFilters.length);
            }
            Collections.addAll(networkFilters, newNetworkFilters);
        }
        return this;
    }
    
    public ClusterBuilder networkFilters(NetworkFilterBuilder... newNetworkFilters) {
        if (newNetworkFilters != null) {
            if (networkFilters == null) {
                networkFilters = new ArrayList<>(newNetworkFilters.length);
            }
            for (NetworkFilterBuilder builder : newNetworkFilters) {
                networkFilters.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder networks(List<Network> newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks);
            }
            else {
                networks.addAll(newNetworks);
            }
        }
        return this;
    }
    
    public ClusterBuilder networks(Network... newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks.length);
            }
            Collections.addAll(networks, newNetworks);
        }
        return this;
    }
    
    public ClusterBuilder networks(NetworkBuilder... newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks.length);
            }
            for (NetworkBuilder builder : newNetworks) {
                networks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder optionalReason(boolean newOptionalReason) {
        optionalReason = Boolean.valueOf(newOptionalReason);
        return this;
    }
    
    public ClusterBuilder optionalReason(Boolean newOptionalReason) {
        optionalReason = newOptionalReason;
        return this;
    }
    
    
    public ClusterBuilder permissions(List<Permission> newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions);
            }
            else {
                permissions.addAll(newPermissions);
            }
        }
        return this;
    }
    
    public ClusterBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public ClusterBuilder permissions(PermissionBuilder... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            for (PermissionBuilder builder : newPermissions) {
                permissions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder requiredRngSources(List<RngSource> newRequiredRngSources) {
        if (newRequiredRngSources != null) {
            if (requiredRngSources == null) {
                requiredRngSources = new ArrayList<>(newRequiredRngSources);
            }
            else {
                requiredRngSources.addAll(newRequiredRngSources);
            }
        }
        return this;
    }
    
    public ClusterBuilder requiredRngSources(RngSource... newRequiredRngSources) {
        if (newRequiredRngSources != null) {
            if (requiredRngSources == null) {
                requiredRngSources = new ArrayList<>(newRequiredRngSources.length);
            }
            Collections.addAll(requiredRngSources, newRequiredRngSources);
        }
        return this;
    }
    
    
    public ClusterBuilder schedulingPolicy(SchedulingPolicy newSchedulingPolicy) {
        schedulingPolicy = newSchedulingPolicy;
        return this;
    }
    
    public ClusterBuilder schedulingPolicy(SchedulingPolicyBuilder newSchedulingPolicy) {
        if (newSchedulingPolicy == null) {
            schedulingPolicy = null;
        }
        else {
            schedulingPolicy = newSchedulingPolicy.build();
        }
        return this;
    }
    
    
    public ClusterBuilder serialNumber(SerialNumber newSerialNumber) {
        serialNumber = newSerialNumber;
        return this;
    }
    
    public ClusterBuilder serialNumber(SerialNumberBuilder newSerialNumber) {
        if (newSerialNumber == null) {
            serialNumber = null;
        }
        else {
            serialNumber = newSerialNumber.build();
        }
        return this;
    }
    
    
    public ClusterBuilder supportedVersions(List<Version> newSupportedVersions) {
        if (newSupportedVersions != null) {
            if (supportedVersions == null) {
                supportedVersions = new ArrayList<>(newSupportedVersions);
            }
            else {
                supportedVersions.addAll(newSupportedVersions);
            }
        }
        return this;
    }
    
    public ClusterBuilder supportedVersions(Version... newSupportedVersions) {
        if (newSupportedVersions != null) {
            if (supportedVersions == null) {
                supportedVersions = new ArrayList<>(newSupportedVersions.length);
            }
            Collections.addAll(supportedVersions, newSupportedVersions);
        }
        return this;
    }
    
    public ClusterBuilder supportedVersions(VersionBuilder... newSupportedVersions) {
        if (newSupportedVersions != null) {
            if (supportedVersions == null) {
                supportedVersions = new ArrayList<>(newSupportedVersions.length);
            }
            for (VersionBuilder builder : newSupportedVersions) {
                supportedVersions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterBuilder switchType(SwitchType newSwitchType) {
        switchType = newSwitchType;
        return this;
    }
    
    
    public ClusterBuilder threadsAsCores(boolean newThreadsAsCores) {
        threadsAsCores = Boolean.valueOf(newThreadsAsCores);
        return this;
    }
    
    public ClusterBuilder threadsAsCores(Boolean newThreadsAsCores) {
        threadsAsCores = newThreadsAsCores;
        return this;
    }
    
    
    public ClusterBuilder trustedService(boolean newTrustedService) {
        trustedService = Boolean.valueOf(newTrustedService);
        return this;
    }
    
    public ClusterBuilder trustedService(Boolean newTrustedService) {
        trustedService = newTrustedService;
        return this;
    }
    
    
    public ClusterBuilder tunnelMigration(boolean newTunnelMigration) {
        tunnelMigration = Boolean.valueOf(newTunnelMigration);
        return this;
    }
    
    public ClusterBuilder tunnelMigration(Boolean newTunnelMigration) {
        tunnelMigration = newTunnelMigration;
        return this;
    }
    
    
    public ClusterBuilder version(Version newVersion) {
        version = newVersion;
        return this;
    }
    
    public ClusterBuilder version(VersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public ClusterBuilder virtService(boolean newVirtService) {
        virtService = Boolean.valueOf(newVirtService);
        return this;
    }
    
    public ClusterBuilder virtService(Boolean newVirtService) {
        virtService = newVirtService;
        return this;
    }
    
    
    public ClusterBuilder vncEncryption(boolean newVncEncryption) {
        vncEncryption = Boolean.valueOf(newVncEncryption);
        return this;
    }
    
    public ClusterBuilder vncEncryption(Boolean newVncEncryption) {
        vncEncryption = newVncEncryption;
        return this;
    }
    
    
    public Cluster build() {
        ClusterContainer container = new ClusterContainer();
        container.affinityGroups(affinityGroups);
        container.ballooningEnabled(ballooningEnabled);
        container.biosType(biosType);
        container.comment(comment);
        container.cpu(cpu);
        container.cpuProfiles(cpuProfiles);
        container.customSchedulingPolicyProperties(customSchedulingPolicyProperties);
        container.dataCenter(dataCenter);
        container.description(description);
        container.display(display);
        container.enabledFeatures(enabledFeatures);
        container.errorHandling(errorHandling);
        container.externalNetworkProviders(externalNetworkProviders);
        container.fencingPolicy(fencingPolicy);
        container.fipsMode(fipsMode);
        container.firewallType(firewallType);
        container.glusterHooks(glusterHooks);
        container.glusterService(glusterService);
        container.glusterTunedProfile(glusterTunedProfile);
        container.glusterVolumes(glusterVolumes);
        container.haReservation(haReservation);
        container.href(href);
        container.id(id);
        container.ksm(ksm);
        container.logMaxMemoryUsedThreshold(logMaxMemoryUsedThreshold);
        container.logMaxMemoryUsedThresholdType(logMaxMemoryUsedThresholdType);
        container.macPool(macPool);
        container.maintenanceReasonRequired(maintenanceReasonRequired);
        container.managementNetwork(managementNetwork);
        container.memoryPolicy(memoryPolicy);
        container.migration(migration);
        container.name(name);
        container.networkFilters(networkFilters);
        container.networks(networks);
        container.optionalReason(optionalReason);
        container.permissions(permissions);
        container.requiredRngSources(requiredRngSources);
        container.schedulingPolicy(schedulingPolicy);
        container.serialNumber(serialNumber);
        container.supportedVersions(supportedVersions);
        container.switchType(switchType);
        container.threadsAsCores(threadsAsCores);
        container.trustedService(trustedService);
        container.tunnelMigration(tunnelMigration);
        container.version(version);
        container.virtService(virtService);
        container.vncEncryption(vncEncryption);
        return container;
    }
}
