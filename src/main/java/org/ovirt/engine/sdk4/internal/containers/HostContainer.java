/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
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

public class HostContainer extends IdentifiedContainer implements Host {
    private String address;
    private AutoNumaStatus autoNumaStatus;
    private Certificate certificate;
    private Cpu cpu;
    private HostDevicePassthrough devicePassthrough;
    private Display display;
    private ExternalStatus externalStatus;
    private HardwareInformation hardwareInformation;
    private HostedEngine hostedEngine;
    private IscsiDetails iscsi;
    private KdumpStatus kdumpStatus;
    private Ksm ksm;
    private Version libvirtVersion;
    private BigInteger maxSchedulingMemory;
    private BigInteger memory;
    private Boolean networkOperationInProgress;
    private Boolean numaSupported;
    private OperatingSystem os;
    private Boolean overrideIptables;
    private Boolean ovnConfigured;
    private BigInteger port;
    private PowerManagement powerManagement;
    private HostProtocol protocol;
    private Boolean reinstallationRequired;
    private String rootPassword;
    private SeLinux seLinux;
    private Spm spm;
    private Ssh ssh;
    private HostStatus status;
    private String statusDetail;
    private VmSummary summary;
    private TransparentHugePages transparentHugePages;
    private HostType type;
    private Boolean updateAvailable;
    private Version version;
    private VgpuPlacement vgpuPlacement;
    private List<AffinityLabel> affinityLabels;
    private List<Agent> agents;
    private Cluster cluster;
    private List<HostDevice> devices;
    private ExternalHostProvider externalHostProvider;
    private List<ExternalNetworkProviderConfiguration> externalNetworkProviderConfigurations;
    private List<Hook> hooks;
    private List<KatelloErratum> katelloErrata;
    private List<NetworkAttachment> networkAttachments;
    private List<HostNic> nics;
    private List<NumaNode> numaNodes;
    private List<Permission> permissions;
    private List<Statistic> statistics;
    private List<StorageConnectionExtension> storageConnectionExtensions;
    private List<HostStorage> storages;
    private List<Tag> tags;
    private List<UnmanagedNetwork> unmanagedNetworks;
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public AutoNumaStatus autoNumaStatus() {
        return autoNumaStatus;
    }
    
    public void autoNumaStatus(AutoNumaStatus newAutoNumaStatus) {
        autoNumaStatus = newAutoNumaStatus;
    }
    
    public boolean autoNumaStatusPresent() {
        return autoNumaStatus != null;
    }
    
    public Certificate certificate() {
        return certificate;
    }
    
    public void certificate(Certificate newCertificate) {
        certificate = newCertificate;
    }
    
    public boolean certificatePresent() {
        return certificate != null;
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
    
    public HostDevicePassthrough devicePassthrough() {
        return devicePassthrough;
    }
    
    public void devicePassthrough(HostDevicePassthrough newDevicePassthrough) {
        devicePassthrough = newDevicePassthrough;
    }
    
    public boolean devicePassthroughPresent() {
        return devicePassthrough != null;
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
    
    public ExternalStatus externalStatus() {
        return externalStatus;
    }
    
    public void externalStatus(ExternalStatus newExternalStatus) {
        externalStatus = newExternalStatus;
    }
    
    public boolean externalStatusPresent() {
        return externalStatus != null;
    }
    
    public HardwareInformation hardwareInformation() {
        return hardwareInformation;
    }
    
    public void hardwareInformation(HardwareInformation newHardwareInformation) {
        hardwareInformation = newHardwareInformation;
    }
    
    public boolean hardwareInformationPresent() {
        return hardwareInformation != null;
    }
    
    public HostedEngine hostedEngine() {
        return hostedEngine;
    }
    
    public void hostedEngine(HostedEngine newHostedEngine) {
        hostedEngine = newHostedEngine;
    }
    
    public boolean hostedEnginePresent() {
        return hostedEngine != null;
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
    
    public KdumpStatus kdumpStatus() {
        return kdumpStatus;
    }
    
    public void kdumpStatus(KdumpStatus newKdumpStatus) {
        kdumpStatus = newKdumpStatus;
    }
    
    public boolean kdumpStatusPresent() {
        return kdumpStatus != null;
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
    
    public Version libvirtVersion() {
        return libvirtVersion;
    }
    
    public void libvirtVersion(Version newLibvirtVersion) {
        libvirtVersion = newLibvirtVersion;
    }
    
    public boolean libvirtVersionPresent() {
        return libvirtVersion != null;
    }
    
    public BigInteger maxSchedulingMemory() {
        return maxSchedulingMemory;
    }
    
    public Byte maxSchedulingMemoryAsByte() {
        return asByte("Host", "maxSchedulingMemory", maxSchedulingMemory);
    }
    
    public Short maxSchedulingMemoryAsShort() {
        return asShort("Host", "maxSchedulingMemory", maxSchedulingMemory);
    }
    
    public Integer maxSchedulingMemoryAsInteger() {
        return asInteger("Host", "maxSchedulingMemory", maxSchedulingMemory);
    }
    
    public Long maxSchedulingMemoryAsLong() {
        return asLong("Host", "maxSchedulingMemory", maxSchedulingMemory);
    }
    
    public void maxSchedulingMemory(BigInteger newMaxSchedulingMemory) {
        maxSchedulingMemory = newMaxSchedulingMemory;
    }
    
    public boolean maxSchedulingMemoryPresent() {
        return maxSchedulingMemory != null;
    }
    
    public BigInteger memory() {
        return memory;
    }
    
    public Byte memoryAsByte() {
        return asByte("Host", "memory", memory);
    }
    
    public Short memoryAsShort() {
        return asShort("Host", "memory", memory);
    }
    
    public Integer memoryAsInteger() {
        return asInteger("Host", "memory", memory);
    }
    
    public Long memoryAsLong() {
        return asLong("Host", "memory", memory);
    }
    
    public void memory(BigInteger newMemory) {
        memory = newMemory;
    }
    
    public boolean memoryPresent() {
        return memory != null;
    }
    
    public boolean networkOperationInProgress() {
        return networkOperationInProgress;
    }
    
    public void networkOperationInProgress(boolean newNetworkOperationInProgress) {
        networkOperationInProgress = Boolean.valueOf(newNetworkOperationInProgress);
    }
    
    public void networkOperationInProgress(Boolean newNetworkOperationInProgress) {
        networkOperationInProgress = newNetworkOperationInProgress;
    }
    
    public boolean networkOperationInProgressPresent() {
        return networkOperationInProgress != null;
    }
    
    public boolean numaSupported() {
        return numaSupported;
    }
    
    public void numaSupported(boolean newNumaSupported) {
        numaSupported = Boolean.valueOf(newNumaSupported);
    }
    
    public void numaSupported(Boolean newNumaSupported) {
        numaSupported = newNumaSupported;
    }
    
    public boolean numaSupportedPresent() {
        return numaSupported != null;
    }
    
    public OperatingSystem os() {
        return os;
    }
    
    public void os(OperatingSystem newOs) {
        os = newOs;
    }
    
    public boolean osPresent() {
        return os != null;
    }
    
    public boolean overrideIptables() {
        return overrideIptables;
    }
    
    public void overrideIptables(boolean newOverrideIptables) {
        overrideIptables = Boolean.valueOf(newOverrideIptables);
    }
    
    public void overrideIptables(Boolean newOverrideIptables) {
        overrideIptables = newOverrideIptables;
    }
    
    public boolean overrideIptablesPresent() {
        return overrideIptables != null;
    }
    
    public boolean ovnConfigured() {
        return ovnConfigured;
    }
    
    public void ovnConfigured(boolean newOvnConfigured) {
        ovnConfigured = Boolean.valueOf(newOvnConfigured);
    }
    
    public void ovnConfigured(Boolean newOvnConfigured) {
        ovnConfigured = newOvnConfigured;
    }
    
    public boolean ovnConfiguredPresent() {
        return ovnConfigured != null;
    }
    
    public BigInteger port() {
        return port;
    }
    
    public Byte portAsByte() {
        return asByte("Host", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("Host", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("Host", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("Host", "port", port);
    }
    
    public void port(BigInteger newPort) {
        port = newPort;
    }
    
    public boolean portPresent() {
        return port != null;
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
    
    public HostProtocol protocol() {
        return protocol;
    }
    
    public void protocol(HostProtocol newProtocol) {
        protocol = newProtocol;
    }
    
    public boolean protocolPresent() {
        return protocol != null;
    }
    
    public boolean reinstallationRequired() {
        return reinstallationRequired;
    }
    
    public void reinstallationRequired(boolean newReinstallationRequired) {
        reinstallationRequired = Boolean.valueOf(newReinstallationRequired);
    }
    
    public void reinstallationRequired(Boolean newReinstallationRequired) {
        reinstallationRequired = newReinstallationRequired;
    }
    
    public boolean reinstallationRequiredPresent() {
        return reinstallationRequired != null;
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
    
    public SeLinux seLinux() {
        return seLinux;
    }
    
    public void seLinux(SeLinux newSeLinux) {
        seLinux = newSeLinux;
    }
    
    public boolean seLinuxPresent() {
        return seLinux != null;
    }
    
    public Spm spm() {
        return spm;
    }
    
    public void spm(Spm newSpm) {
        spm = newSpm;
    }
    
    public boolean spmPresent() {
        return spm != null;
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
    
    public HostStatus status() {
        return status;
    }
    
    public void status(HostStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public String statusDetail() {
        return statusDetail;
    }
    
    public void statusDetail(String newStatusDetail) {
        statusDetail = newStatusDetail;
    }
    
    public boolean statusDetailPresent() {
        return statusDetail != null;
    }
    
    public VmSummary summary() {
        return summary;
    }
    
    public void summary(VmSummary newSummary) {
        summary = newSummary;
    }
    
    public boolean summaryPresent() {
        return summary != null;
    }
    
    public TransparentHugePages transparentHugePages() {
        return transparentHugePages;
    }
    
    public void transparentHugePages(TransparentHugePages newTransparentHugePages) {
        transparentHugePages = newTransparentHugePages;
    }
    
    public boolean transparentHugePagesPresent() {
        return transparentHugePages != null;
    }
    
    public HostType type() {
        return type;
    }
    
    public void type(HostType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public boolean updateAvailable() {
        return updateAvailable;
    }
    
    public void updateAvailable(boolean newUpdateAvailable) {
        updateAvailable = Boolean.valueOf(newUpdateAvailable);
    }
    
    public void updateAvailable(Boolean newUpdateAvailable) {
        updateAvailable = newUpdateAvailable;
    }
    
    public boolean updateAvailablePresent() {
        return updateAvailable != null;
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
    
    public VgpuPlacement vgpuPlacement() {
        return vgpuPlacement;
    }
    
    public void vgpuPlacement(VgpuPlacement newVgpuPlacement) {
        vgpuPlacement = newVgpuPlacement;
    }
    
    public boolean vgpuPlacementPresent() {
        return vgpuPlacement != null;
    }
    
    public List<AffinityLabel> affinityLabels() {
        return makeUnmodifiableList(affinityLabels);
    }
    
    public void affinityLabels(List<AffinityLabel> newAffinityLabels) {
        affinityLabels = makeArrayList(newAffinityLabels);
    }
    
    public boolean affinityLabelsPresent() {
        return affinityLabels != null && !affinityLabels.isEmpty();
    }
    
    public List<Agent> agents() {
        return makeUnmodifiableList(agents);
    }
    
    public void agents(List<Agent> newAgents) {
        agents = makeArrayList(newAgents);
    }
    
    public boolean agentsPresent() {
        return agents != null && !agents.isEmpty();
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
    
    public List<HostDevice> devices() {
        return makeUnmodifiableList(devices);
    }
    
    public void devices(List<HostDevice> newDevices) {
        devices = makeArrayList(newDevices);
    }
    
    public boolean devicesPresent() {
        return devices != null && !devices.isEmpty();
    }
    
    public ExternalHostProvider externalHostProvider() {
        return externalHostProvider;
    }
    
    public void externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
    }
    
    public boolean externalHostProviderPresent() {
        return externalHostProvider != null;
    }
    
    public List<ExternalNetworkProviderConfiguration> externalNetworkProviderConfigurations() {
        return makeUnmodifiableList(externalNetworkProviderConfigurations);
    }
    
    public void externalNetworkProviderConfigurations(List<ExternalNetworkProviderConfiguration> newExternalNetworkProviderConfigurations) {
        externalNetworkProviderConfigurations = makeArrayList(newExternalNetworkProviderConfigurations);
    }
    
    public boolean externalNetworkProviderConfigurationsPresent() {
        return externalNetworkProviderConfigurations != null && !externalNetworkProviderConfigurations.isEmpty();
    }
    
    public List<Hook> hooks() {
        return makeUnmodifiableList(hooks);
    }
    
    public void hooks(List<Hook> newHooks) {
        hooks = makeArrayList(newHooks);
    }
    
    public boolean hooksPresent() {
        return hooks != null && !hooks.isEmpty();
    }
    
    public List<KatelloErratum> katelloErrata() {
        return makeUnmodifiableList(katelloErrata);
    }
    
    public void katelloErrata(List<KatelloErratum> newKatelloErrata) {
        katelloErrata = makeArrayList(newKatelloErrata);
    }
    
    public boolean katelloErrataPresent() {
        return katelloErrata != null && !katelloErrata.isEmpty();
    }
    
    public List<NetworkAttachment> networkAttachments() {
        return makeUnmodifiableList(networkAttachments);
    }
    
    public void networkAttachments(List<NetworkAttachment> newNetworkAttachments) {
        networkAttachments = makeArrayList(newNetworkAttachments);
    }
    
    public boolean networkAttachmentsPresent() {
        return networkAttachments != null && !networkAttachments.isEmpty();
    }
    
    public List<HostNic> nics() {
        return makeUnmodifiableList(nics);
    }
    
    public void nics(List<HostNic> newNics) {
        nics = makeArrayList(newNics);
    }
    
    public boolean nicsPresent() {
        return nics != null && !nics.isEmpty();
    }
    
    public List<NumaNode> numaNodes() {
        return makeUnmodifiableList(numaNodes);
    }
    
    public void numaNodes(List<NumaNode> newNumaNodes) {
        numaNodes = makeArrayList(newNumaNodes);
    }
    
    public boolean numaNodesPresent() {
        return numaNodes != null && !numaNodes.isEmpty();
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
    
    public List<Statistic> statistics() {
        return makeUnmodifiableList(statistics);
    }
    
    public void statistics(List<Statistic> newStatistics) {
        statistics = makeArrayList(newStatistics);
    }
    
    public boolean statisticsPresent() {
        return statistics != null && !statistics.isEmpty();
    }
    
    public List<StorageConnectionExtension> storageConnectionExtensions() {
        return makeUnmodifiableList(storageConnectionExtensions);
    }
    
    public void storageConnectionExtensions(List<StorageConnectionExtension> newStorageConnectionExtensions) {
        storageConnectionExtensions = makeArrayList(newStorageConnectionExtensions);
    }
    
    public boolean storageConnectionExtensionsPresent() {
        return storageConnectionExtensions != null && !storageConnectionExtensions.isEmpty();
    }
    
    public List<HostStorage> storages() {
        return makeUnmodifiableList(storages);
    }
    
    public void storages(List<HostStorage> newStorages) {
        storages = makeArrayList(newStorages);
    }
    
    public boolean storagesPresent() {
        return storages != null && !storages.isEmpty();
    }
    
    public List<Tag> tags() {
        return makeUnmodifiableList(tags);
    }
    
    public void tags(List<Tag> newTags) {
        tags = makeArrayList(newTags);
    }
    
    public boolean tagsPresent() {
        return tags != null && !tags.isEmpty();
    }
    
    public List<UnmanagedNetwork> unmanagedNetworks() {
        return makeUnmodifiableList(unmanagedNetworks);
    }
    
    public void unmanagedNetworks(List<UnmanagedNetwork> newUnmanagedNetworks) {
        unmanagedNetworks = makeArrayList(newUnmanagedNetworks);
    }
    
    public boolean unmanagedNetworksPresent() {
        return unmanagedNetworks != null && !unmanagedNetworks.isEmpty();
    }
    
}
