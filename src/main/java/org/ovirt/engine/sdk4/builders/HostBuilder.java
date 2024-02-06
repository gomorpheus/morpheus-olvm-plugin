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
import org.ovirt.engine.sdk4.internal.containers.HostContainer;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.Agent;
import org.ovirt.engine.sdk4.types.AutoNumaStatus;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.Display;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;
import org.ovirt.engine.sdk4.types.ExternalNetworkProviderConfiguration;
import org.ovirt.engine.sdk4.types.ExternalStatus;
import org.ovirt.engine.sdk4.types.HardwareInformation;
import org.ovirt.engine.sdk4.types.Hook;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostDevice;
import org.ovirt.engine.sdk4.types.HostDevicePassthrough;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.HostProtocol;
import org.ovirt.engine.sdk4.types.HostStatus;
import org.ovirt.engine.sdk4.types.HostStorage;
import org.ovirt.engine.sdk4.types.HostType;
import org.ovirt.engine.sdk4.types.HostedEngine;
import org.ovirt.engine.sdk4.types.IscsiDetails;
import org.ovirt.engine.sdk4.types.KatelloErratum;
import org.ovirt.engine.sdk4.types.KdumpStatus;
import org.ovirt.engine.sdk4.types.Ksm;
import org.ovirt.engine.sdk4.types.NetworkAttachment;
import org.ovirt.engine.sdk4.types.NumaNode;
import org.ovirt.engine.sdk4.types.OperatingSystem;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.PowerManagement;
import org.ovirt.engine.sdk4.types.SeLinux;
import org.ovirt.engine.sdk4.types.Spm;
import org.ovirt.engine.sdk4.types.Ssh;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.StorageConnectionExtension;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.TransparentHugePages;
import org.ovirt.engine.sdk4.types.UnmanagedNetwork;
import org.ovirt.engine.sdk4.types.Version;
import org.ovirt.engine.sdk4.types.VgpuPlacement;
import org.ovirt.engine.sdk4.types.VmSummary;

public class HostBuilder {
    private String address;
    private List<AffinityLabel> affinityLabels;
    private List<Agent> agents;
    private AutoNumaStatus autoNumaStatus;
    private Certificate certificate;
    private Cluster cluster;
    private String comment;
    private Cpu cpu;
    private String description;
    private HostDevicePassthrough devicePassthrough;
    private List<HostDevice> devices;
    private Display display;
    private ExternalHostProvider externalHostProvider;
    private List<ExternalNetworkProviderConfiguration> externalNetworkProviderConfigurations;
    private ExternalStatus externalStatus;
    private HardwareInformation hardwareInformation;
    private List<Hook> hooks;
    private HostedEngine hostedEngine;
    private String href;
    private String id;
    private IscsiDetails iscsi;
    private List<KatelloErratum> katelloErrata;
    private KdumpStatus kdumpStatus;
    private Ksm ksm;
    private Version libvirtVersion;
    private BigInteger maxSchedulingMemory;
    private BigInteger memory;
    private String name;
    private List<NetworkAttachment> networkAttachments;
    private Boolean networkOperationInProgress;
    private List<HostNic> nics;
    private List<NumaNode> numaNodes;
    private Boolean numaSupported;
    private OperatingSystem os;
    private Boolean overrideIptables;
    private Boolean ovnConfigured;
    private List<Permission> permissions;
    private BigInteger port;
    private PowerManagement powerManagement;
    private HostProtocol protocol;
    private Boolean reinstallationRequired;
    private String rootPassword;
    private SeLinux seLinux;
    private Spm spm;
    private Ssh ssh;
    private List<Statistic> statistics;
    private HostStatus status;
    private String statusDetail;
    private List<StorageConnectionExtension> storageConnectionExtensions;
    private List<HostStorage> storages;
    private VmSummary summary;
    private List<Tag> tags;
    private TransparentHugePages transparentHugePages;
    private HostType type;
    private List<UnmanagedNetwork> unmanagedNetworks;
    private Boolean updateAvailable;
    private Version version;
    private VgpuPlacement vgpuPlacement;
    
    public HostBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public HostBuilder affinityLabels(List<AffinityLabel> newAffinityLabels) {
        if (newAffinityLabels != null) {
            if (affinityLabels == null) {
                affinityLabels = new ArrayList<>(newAffinityLabels);
            }
            else {
                affinityLabels.addAll(newAffinityLabels);
            }
        }
        return this;
    }
    
    public HostBuilder affinityLabels(AffinityLabel... newAffinityLabels) {
        if (newAffinityLabels != null) {
            if (affinityLabels == null) {
                affinityLabels = new ArrayList<>(newAffinityLabels.length);
            }
            Collections.addAll(affinityLabels, newAffinityLabels);
        }
        return this;
    }
    
    public HostBuilder affinityLabels(AffinityLabelBuilder... newAffinityLabels) {
        if (newAffinityLabels != null) {
            if (affinityLabels == null) {
                affinityLabels = new ArrayList<>(newAffinityLabels.length);
            }
            for (AffinityLabelBuilder builder : newAffinityLabels) {
                affinityLabels.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder agents(List<Agent> newAgents) {
        if (newAgents != null) {
            if (agents == null) {
                agents = new ArrayList<>(newAgents);
            }
            else {
                agents.addAll(newAgents);
            }
        }
        return this;
    }
    
    public HostBuilder agents(Agent... newAgents) {
        if (newAgents != null) {
            if (agents == null) {
                agents = new ArrayList<>(newAgents.length);
            }
            Collections.addAll(agents, newAgents);
        }
        return this;
    }
    
    public HostBuilder agents(AgentBuilder... newAgents) {
        if (newAgents != null) {
            if (agents == null) {
                agents = new ArrayList<>(newAgents.length);
            }
            for (AgentBuilder builder : newAgents) {
                agents.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder autoNumaStatus(AutoNumaStatus newAutoNumaStatus) {
        autoNumaStatus = newAutoNumaStatus;
        return this;
    }
    
    
    public HostBuilder certificate(Certificate newCertificate) {
        certificate = newCertificate;
        return this;
    }
    
    public HostBuilder certificate(CertificateBuilder newCertificate) {
        if (newCertificate == null) {
            certificate = null;
        }
        else {
            certificate = newCertificate.build();
        }
        return this;
    }
    
    
    public HostBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public HostBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public HostBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public HostBuilder cpu(Cpu newCpu) {
        cpu = newCpu;
        return this;
    }
    
    public HostBuilder cpu(CpuBuilder newCpu) {
        if (newCpu == null) {
            cpu = null;
        }
        else {
            cpu = newCpu.build();
        }
        return this;
    }
    
    
    public HostBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public HostBuilder devicePassthrough(HostDevicePassthrough newDevicePassthrough) {
        devicePassthrough = newDevicePassthrough;
        return this;
    }
    
    public HostBuilder devicePassthrough(HostDevicePassthroughBuilder newDevicePassthrough) {
        if (newDevicePassthrough == null) {
            devicePassthrough = null;
        }
        else {
            devicePassthrough = newDevicePassthrough.build();
        }
        return this;
    }
    
    
    public HostBuilder devices(List<HostDevice> newDevices) {
        if (newDevices != null) {
            if (devices == null) {
                devices = new ArrayList<>(newDevices);
            }
            else {
                devices.addAll(newDevices);
            }
        }
        return this;
    }
    
    public HostBuilder devices(HostDevice... newDevices) {
        if (newDevices != null) {
            if (devices == null) {
                devices = new ArrayList<>(newDevices.length);
            }
            Collections.addAll(devices, newDevices);
        }
        return this;
    }
    
    public HostBuilder devices(HostDeviceBuilder... newDevices) {
        if (newDevices != null) {
            if (devices == null) {
                devices = new ArrayList<>(newDevices.length);
            }
            for (HostDeviceBuilder builder : newDevices) {
                devices.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder display(Display newDisplay) {
        display = newDisplay;
        return this;
    }
    
    public HostBuilder display(DisplayBuilder newDisplay) {
        if (newDisplay == null) {
            display = null;
        }
        else {
            display = newDisplay.build();
        }
        return this;
    }
    
    
    public HostBuilder externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
        return this;
    }
    
    public HostBuilder externalHostProvider(ExternalHostProviderBuilder newExternalHostProvider) {
        if (newExternalHostProvider == null) {
            externalHostProvider = null;
        }
        else {
            externalHostProvider = newExternalHostProvider.build();
        }
        return this;
    }
    
    
    public HostBuilder externalNetworkProviderConfigurations(List<ExternalNetworkProviderConfiguration> newExternalNetworkProviderConfigurations) {
        if (newExternalNetworkProviderConfigurations != null) {
            if (externalNetworkProviderConfigurations == null) {
                externalNetworkProviderConfigurations = new ArrayList<>(newExternalNetworkProviderConfigurations);
            }
            else {
                externalNetworkProviderConfigurations.addAll(newExternalNetworkProviderConfigurations);
            }
        }
        return this;
    }
    
    public HostBuilder externalNetworkProviderConfigurations(ExternalNetworkProviderConfiguration... newExternalNetworkProviderConfigurations) {
        if (newExternalNetworkProviderConfigurations != null) {
            if (externalNetworkProviderConfigurations == null) {
                externalNetworkProviderConfigurations = new ArrayList<>(newExternalNetworkProviderConfigurations.length);
            }
            Collections.addAll(externalNetworkProviderConfigurations, newExternalNetworkProviderConfigurations);
        }
        return this;
    }
    
    public HostBuilder externalNetworkProviderConfigurations(ExternalNetworkProviderConfigurationBuilder... newExternalNetworkProviderConfigurations) {
        if (newExternalNetworkProviderConfigurations != null) {
            if (externalNetworkProviderConfigurations == null) {
                externalNetworkProviderConfigurations = new ArrayList<>(newExternalNetworkProviderConfigurations.length);
            }
            for (ExternalNetworkProviderConfigurationBuilder builder : newExternalNetworkProviderConfigurations) {
                externalNetworkProviderConfigurations.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder externalStatus(ExternalStatus newExternalStatus) {
        externalStatus = newExternalStatus;
        return this;
    }
    
    
    public HostBuilder hardwareInformation(HardwareInformation newHardwareInformation) {
        hardwareInformation = newHardwareInformation;
        return this;
    }
    
    public HostBuilder hardwareInformation(HardwareInformationBuilder newHardwareInformation) {
        if (newHardwareInformation == null) {
            hardwareInformation = null;
        }
        else {
            hardwareInformation = newHardwareInformation.build();
        }
        return this;
    }
    
    
    public HostBuilder hooks(List<Hook> newHooks) {
        if (newHooks != null) {
            if (hooks == null) {
                hooks = new ArrayList<>(newHooks);
            }
            else {
                hooks.addAll(newHooks);
            }
        }
        return this;
    }
    
    public HostBuilder hooks(Hook... newHooks) {
        if (newHooks != null) {
            if (hooks == null) {
                hooks = new ArrayList<>(newHooks.length);
            }
            Collections.addAll(hooks, newHooks);
        }
        return this;
    }
    
    public HostBuilder hooks(HookBuilder... newHooks) {
        if (newHooks != null) {
            if (hooks == null) {
                hooks = new ArrayList<>(newHooks.length);
            }
            for (HookBuilder builder : newHooks) {
                hooks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder hostedEngine(HostedEngine newHostedEngine) {
        hostedEngine = newHostedEngine;
        return this;
    }
    
    public HostBuilder hostedEngine(HostedEngineBuilder newHostedEngine) {
        if (newHostedEngine == null) {
            hostedEngine = null;
        }
        else {
            hostedEngine = newHostedEngine.build();
        }
        return this;
    }
    
    
    public HostBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public HostBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public HostBuilder iscsi(IscsiDetails newIscsi) {
        iscsi = newIscsi;
        return this;
    }
    
    public HostBuilder iscsi(IscsiDetailsBuilder newIscsi) {
        if (newIscsi == null) {
            iscsi = null;
        }
        else {
            iscsi = newIscsi.build();
        }
        return this;
    }
    
    
    public HostBuilder katelloErrata(List<KatelloErratum> newKatelloErrata) {
        if (newKatelloErrata != null) {
            if (katelloErrata == null) {
                katelloErrata = new ArrayList<>(newKatelloErrata);
            }
            else {
                katelloErrata.addAll(newKatelloErrata);
            }
        }
        return this;
    }
    
    public HostBuilder katelloErrata(KatelloErratum... newKatelloErrata) {
        if (newKatelloErrata != null) {
            if (katelloErrata == null) {
                katelloErrata = new ArrayList<>(newKatelloErrata.length);
            }
            Collections.addAll(katelloErrata, newKatelloErrata);
        }
        return this;
    }
    
    public HostBuilder katelloErrata(KatelloErratumBuilder... newKatelloErrata) {
        if (newKatelloErrata != null) {
            if (katelloErrata == null) {
                katelloErrata = new ArrayList<>(newKatelloErrata.length);
            }
            for (KatelloErratumBuilder builder : newKatelloErrata) {
                katelloErrata.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder kdumpStatus(KdumpStatus newKdumpStatus) {
        kdumpStatus = newKdumpStatus;
        return this;
    }
    
    
    public HostBuilder ksm(Ksm newKsm) {
        ksm = newKsm;
        return this;
    }
    
    public HostBuilder ksm(KsmBuilder newKsm) {
        if (newKsm == null) {
            ksm = null;
        }
        else {
            ksm = newKsm.build();
        }
        return this;
    }
    
    
    public HostBuilder libvirtVersion(Version newLibvirtVersion) {
        libvirtVersion = newLibvirtVersion;
        return this;
    }
    
    public HostBuilder libvirtVersion(VersionBuilder newLibvirtVersion) {
        if (newLibvirtVersion == null) {
            libvirtVersion = null;
        }
        else {
            libvirtVersion = newLibvirtVersion.build();
        }
        return this;
    }
    
    
    public HostBuilder maxSchedulingMemory(int newMaxSchedulingMemory) {
        maxSchedulingMemory = BigInteger.valueOf((long) newMaxSchedulingMemory);
        return this;
    }
    
    public HostBuilder maxSchedulingMemory(Integer newMaxSchedulingMemory) {
        if (newMaxSchedulingMemory == null) {
            maxSchedulingMemory = null;
        }
        else {
            maxSchedulingMemory = BigInteger.valueOf(newMaxSchedulingMemory.longValue());
        }
        return this;
    }
    
    public HostBuilder maxSchedulingMemory(long newMaxSchedulingMemory) {
        maxSchedulingMemory = BigInteger.valueOf(newMaxSchedulingMemory);
        return this;
    }
    
    public HostBuilder maxSchedulingMemory(Long newMaxSchedulingMemory) {
        if (newMaxSchedulingMemory == null) {
            maxSchedulingMemory = null;
        }
        else {
            maxSchedulingMemory = BigInteger.valueOf(newMaxSchedulingMemory.longValue());
        }
        return this;
    }
    
    public HostBuilder maxSchedulingMemory(BigInteger newMaxSchedulingMemory) {
        maxSchedulingMemory = newMaxSchedulingMemory;
        return this;
    }
    
    
    public HostBuilder memory(int newMemory) {
        memory = BigInteger.valueOf((long) newMemory);
        return this;
    }
    
    public HostBuilder memory(Integer newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public HostBuilder memory(long newMemory) {
        memory = BigInteger.valueOf(newMemory);
        return this;
    }
    
    public HostBuilder memory(Long newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public HostBuilder memory(BigInteger newMemory) {
        memory = newMemory;
        return this;
    }
    
    
    public HostBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public HostBuilder networkAttachments(List<NetworkAttachment> newNetworkAttachments) {
        if (newNetworkAttachments != null) {
            if (networkAttachments == null) {
                networkAttachments = new ArrayList<>(newNetworkAttachments);
            }
            else {
                networkAttachments.addAll(newNetworkAttachments);
            }
        }
        return this;
    }
    
    public HostBuilder networkAttachments(NetworkAttachment... newNetworkAttachments) {
        if (newNetworkAttachments != null) {
            if (networkAttachments == null) {
                networkAttachments = new ArrayList<>(newNetworkAttachments.length);
            }
            Collections.addAll(networkAttachments, newNetworkAttachments);
        }
        return this;
    }
    
    public HostBuilder networkAttachments(NetworkAttachmentBuilder... newNetworkAttachments) {
        if (newNetworkAttachments != null) {
            if (networkAttachments == null) {
                networkAttachments = new ArrayList<>(newNetworkAttachments.length);
            }
            for (NetworkAttachmentBuilder builder : newNetworkAttachments) {
                networkAttachments.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder networkOperationInProgress(boolean newNetworkOperationInProgress) {
        networkOperationInProgress = Boolean.valueOf(newNetworkOperationInProgress);
        return this;
    }
    
    public HostBuilder networkOperationInProgress(Boolean newNetworkOperationInProgress) {
        networkOperationInProgress = newNetworkOperationInProgress;
        return this;
    }
    
    
    public HostBuilder nics(List<HostNic> newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics);
            }
            else {
                nics.addAll(newNics);
            }
        }
        return this;
    }
    
    public HostBuilder nics(HostNic... newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics.length);
            }
            Collections.addAll(nics, newNics);
        }
        return this;
    }
    
    public HostBuilder nics(HostNicBuilder... newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics.length);
            }
            for (HostNicBuilder builder : newNics) {
                nics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder numaNodes(List<NumaNode> newNumaNodes) {
        if (newNumaNodes != null) {
            if (numaNodes == null) {
                numaNodes = new ArrayList<>(newNumaNodes);
            }
            else {
                numaNodes.addAll(newNumaNodes);
            }
        }
        return this;
    }
    
    public HostBuilder numaNodes(NumaNode... newNumaNodes) {
        if (newNumaNodes != null) {
            if (numaNodes == null) {
                numaNodes = new ArrayList<>(newNumaNodes.length);
            }
            Collections.addAll(numaNodes, newNumaNodes);
        }
        return this;
    }
    
    public HostBuilder numaNodes(NumaNodeBuilder... newNumaNodes) {
        if (newNumaNodes != null) {
            if (numaNodes == null) {
                numaNodes = new ArrayList<>(newNumaNodes.length);
            }
            for (NumaNodeBuilder builder : newNumaNodes) {
                numaNodes.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder numaSupported(boolean newNumaSupported) {
        numaSupported = Boolean.valueOf(newNumaSupported);
        return this;
    }
    
    public HostBuilder numaSupported(Boolean newNumaSupported) {
        numaSupported = newNumaSupported;
        return this;
    }
    
    
    public HostBuilder os(OperatingSystem newOs) {
        os = newOs;
        return this;
    }
    
    public HostBuilder os(OperatingSystemBuilder newOs) {
        if (newOs == null) {
            os = null;
        }
        else {
            os = newOs.build();
        }
        return this;
    }
    
    
    public HostBuilder overrideIptables(boolean newOverrideIptables) {
        overrideIptables = Boolean.valueOf(newOverrideIptables);
        return this;
    }
    
    public HostBuilder overrideIptables(Boolean newOverrideIptables) {
        overrideIptables = newOverrideIptables;
        return this;
    }
    
    
    public HostBuilder ovnConfigured(boolean newOvnConfigured) {
        ovnConfigured = Boolean.valueOf(newOvnConfigured);
        return this;
    }
    
    public HostBuilder ovnConfigured(Boolean newOvnConfigured) {
        ovnConfigured = newOvnConfigured;
        return this;
    }
    
    
    public HostBuilder permissions(List<Permission> newPermissions) {
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
    
    public HostBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public HostBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public HostBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public HostBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public HostBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public HostBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public HostBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public HostBuilder powerManagement(PowerManagement newPowerManagement) {
        powerManagement = newPowerManagement;
        return this;
    }
    
    public HostBuilder powerManagement(PowerManagementBuilder newPowerManagement) {
        if (newPowerManagement == null) {
            powerManagement = null;
        }
        else {
            powerManagement = newPowerManagement.build();
        }
        return this;
    }
    
    
    public HostBuilder protocol(HostProtocol newProtocol) {
        protocol = newProtocol;
        return this;
    }
    
    
    public HostBuilder reinstallationRequired(boolean newReinstallationRequired) {
        reinstallationRequired = Boolean.valueOf(newReinstallationRequired);
        return this;
    }
    
    public HostBuilder reinstallationRequired(Boolean newReinstallationRequired) {
        reinstallationRequired = newReinstallationRequired;
        return this;
    }
    
    
    public HostBuilder rootPassword(String newRootPassword) {
        rootPassword = newRootPassword;
        return this;
    }
    
    
    public HostBuilder seLinux(SeLinux newSeLinux) {
        seLinux = newSeLinux;
        return this;
    }
    
    public HostBuilder seLinux(SeLinuxBuilder newSeLinux) {
        if (newSeLinux == null) {
            seLinux = null;
        }
        else {
            seLinux = newSeLinux.build();
        }
        return this;
    }
    
    
    public HostBuilder spm(Spm newSpm) {
        spm = newSpm;
        return this;
    }
    
    public HostBuilder spm(SpmBuilder newSpm) {
        if (newSpm == null) {
            spm = null;
        }
        else {
            spm = newSpm.build();
        }
        return this;
    }
    
    
    public HostBuilder ssh(Ssh newSsh) {
        ssh = newSsh;
        return this;
    }
    
    public HostBuilder ssh(SshBuilder newSsh) {
        if (newSsh == null) {
            ssh = null;
        }
        else {
            ssh = newSsh.build();
        }
        return this;
    }
    
    
    public HostBuilder statistics(List<Statistic> newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics);
            }
            else {
                statistics.addAll(newStatistics);
            }
        }
        return this;
    }
    
    public HostBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public HostBuilder statistics(StatisticBuilder... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            for (StatisticBuilder builder : newStatistics) {
                statistics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder status(HostStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public HostBuilder statusDetail(String newStatusDetail) {
        statusDetail = newStatusDetail;
        return this;
    }
    
    
    public HostBuilder storageConnectionExtensions(List<StorageConnectionExtension> newStorageConnectionExtensions) {
        if (newStorageConnectionExtensions != null) {
            if (storageConnectionExtensions == null) {
                storageConnectionExtensions = new ArrayList<>(newStorageConnectionExtensions);
            }
            else {
                storageConnectionExtensions.addAll(newStorageConnectionExtensions);
            }
        }
        return this;
    }
    
    public HostBuilder storageConnectionExtensions(StorageConnectionExtension... newStorageConnectionExtensions) {
        if (newStorageConnectionExtensions != null) {
            if (storageConnectionExtensions == null) {
                storageConnectionExtensions = new ArrayList<>(newStorageConnectionExtensions.length);
            }
            Collections.addAll(storageConnectionExtensions, newStorageConnectionExtensions);
        }
        return this;
    }
    
    public HostBuilder storageConnectionExtensions(StorageConnectionExtensionBuilder... newStorageConnectionExtensions) {
        if (newStorageConnectionExtensions != null) {
            if (storageConnectionExtensions == null) {
                storageConnectionExtensions = new ArrayList<>(newStorageConnectionExtensions.length);
            }
            for (StorageConnectionExtensionBuilder builder : newStorageConnectionExtensions) {
                storageConnectionExtensions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder storages(List<HostStorage> newStorages) {
        if (newStorages != null) {
            if (storages == null) {
                storages = new ArrayList<>(newStorages);
            }
            else {
                storages.addAll(newStorages);
            }
        }
        return this;
    }
    
    public HostBuilder storages(HostStorage... newStorages) {
        if (newStorages != null) {
            if (storages == null) {
                storages = new ArrayList<>(newStorages.length);
            }
            Collections.addAll(storages, newStorages);
        }
        return this;
    }
    
    public HostBuilder storages(HostStorageBuilder... newStorages) {
        if (newStorages != null) {
            if (storages == null) {
                storages = new ArrayList<>(newStorages.length);
            }
            for (HostStorageBuilder builder : newStorages) {
                storages.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder summary(VmSummary newSummary) {
        summary = newSummary;
        return this;
    }
    
    public HostBuilder summary(VmSummaryBuilder newSummary) {
        if (newSummary == null) {
            summary = null;
        }
        else {
            summary = newSummary.build();
        }
        return this;
    }
    
    
    public HostBuilder tags(List<Tag> newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags);
            }
            else {
                tags.addAll(newTags);
            }
        }
        return this;
    }
    
    public HostBuilder tags(Tag... newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags.length);
            }
            Collections.addAll(tags, newTags);
        }
        return this;
    }
    
    public HostBuilder tags(TagBuilder... newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags.length);
            }
            for (TagBuilder builder : newTags) {
                tags.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder transparentHugePages(TransparentHugePages newTransparentHugePages) {
        transparentHugePages = newTransparentHugePages;
        return this;
    }
    
    public HostBuilder transparentHugePages(TransparentHugePagesBuilder newTransparentHugePages) {
        if (newTransparentHugePages == null) {
            transparentHugePages = null;
        }
        else {
            transparentHugePages = newTransparentHugePages.build();
        }
        return this;
    }
    
    
    public HostBuilder type(HostType newType) {
        type = newType;
        return this;
    }
    
    
    public HostBuilder unmanagedNetworks(List<UnmanagedNetwork> newUnmanagedNetworks) {
        if (newUnmanagedNetworks != null) {
            if (unmanagedNetworks == null) {
                unmanagedNetworks = new ArrayList<>(newUnmanagedNetworks);
            }
            else {
                unmanagedNetworks.addAll(newUnmanagedNetworks);
            }
        }
        return this;
    }
    
    public HostBuilder unmanagedNetworks(UnmanagedNetwork... newUnmanagedNetworks) {
        if (newUnmanagedNetworks != null) {
            if (unmanagedNetworks == null) {
                unmanagedNetworks = new ArrayList<>(newUnmanagedNetworks.length);
            }
            Collections.addAll(unmanagedNetworks, newUnmanagedNetworks);
        }
        return this;
    }
    
    public HostBuilder unmanagedNetworks(UnmanagedNetworkBuilder... newUnmanagedNetworks) {
        if (newUnmanagedNetworks != null) {
            if (unmanagedNetworks == null) {
                unmanagedNetworks = new ArrayList<>(newUnmanagedNetworks.length);
            }
            for (UnmanagedNetworkBuilder builder : newUnmanagedNetworks) {
                unmanagedNetworks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostBuilder updateAvailable(boolean newUpdateAvailable) {
        updateAvailable = Boolean.valueOf(newUpdateAvailable);
        return this;
    }
    
    public HostBuilder updateAvailable(Boolean newUpdateAvailable) {
        updateAvailable = newUpdateAvailable;
        return this;
    }
    
    
    public HostBuilder version(Version newVersion) {
        version = newVersion;
        return this;
    }
    
    public HostBuilder version(VersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public HostBuilder vgpuPlacement(VgpuPlacement newVgpuPlacement) {
        vgpuPlacement = newVgpuPlacement;
        return this;
    }
    
    
    public Host build() {
        HostContainer container = new HostContainer();
        container.address(address);
        container.affinityLabels(affinityLabels);
        container.agents(agents);
        container.autoNumaStatus(autoNumaStatus);
        container.certificate(certificate);
        container.cluster(cluster);
        container.comment(comment);
        container.cpu(cpu);
        container.description(description);
        container.devicePassthrough(devicePassthrough);
        container.devices(devices);
        container.display(display);
        container.externalHostProvider(externalHostProvider);
        container.externalNetworkProviderConfigurations(externalNetworkProviderConfigurations);
        container.externalStatus(externalStatus);
        container.hardwareInformation(hardwareInformation);
        container.hooks(hooks);
        container.hostedEngine(hostedEngine);
        container.href(href);
        container.id(id);
        container.iscsi(iscsi);
        container.katelloErrata(katelloErrata);
        container.kdumpStatus(kdumpStatus);
        container.ksm(ksm);
        container.libvirtVersion(libvirtVersion);
        container.maxSchedulingMemory(maxSchedulingMemory);
        container.memory(memory);
        container.name(name);
        container.networkAttachments(networkAttachments);
        container.networkOperationInProgress(networkOperationInProgress);
        container.nics(nics);
        container.numaNodes(numaNodes);
        container.numaSupported(numaSupported);
        container.os(os);
        container.overrideIptables(overrideIptables);
        container.ovnConfigured(ovnConfigured);
        container.permissions(permissions);
        container.port(port);
        container.powerManagement(powerManagement);
        container.protocol(protocol);
        container.reinstallationRequired(reinstallationRequired);
        container.rootPassword(rootPassword);
        container.seLinux(seLinux);
        container.spm(spm);
        container.ssh(ssh);
        container.statistics(statistics);
        container.status(status);
        container.statusDetail(statusDetail);
        container.storageConnectionExtensions(storageConnectionExtensions);
        container.storages(storages);
        container.summary(summary);
        container.tags(tags);
        container.transparentHugePages(transparentHugePages);
        container.type(type);
        container.unmanagedNetworks(unmanagedNetworks);
        container.updateAvailable(updateAvailable);
        container.version(version);
        container.vgpuPlacement(vgpuPlacement);
        return container;
    }
}
