/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * Type representing a host.
 */
public interface Host extends Identified {
    String address();
    
    boolean addressPresent();
    
    AutoNumaStatus autoNumaStatus();
    
    boolean autoNumaStatusPresent();
    
    Certificate certificate();
    
    boolean certificatePresent();
    
    Cpu cpu();
    
    boolean cpuPresent();
    
    HostDevicePassthrough devicePassthrough();
    
    boolean devicePassthroughPresent();
    
    Display display();
    
    boolean displayPresent();
    
    ExternalStatus externalStatus();
    
    boolean externalStatusPresent();
    
    HardwareInformation hardwareInformation();
    
    boolean hardwareInformationPresent();
    
    HostedEngine hostedEngine();
    
    boolean hostedEnginePresent();
    
    IscsiDetails iscsi();
    
    boolean iscsiPresent();
    
    KdumpStatus kdumpStatus();
    
    boolean kdumpStatusPresent();
    
    Ksm ksm();
    
    boolean ksmPresent();
    
    Version libvirtVersion();
    
    boolean libvirtVersionPresent();
    
    BigInteger maxSchedulingMemory();
    Byte maxSchedulingMemoryAsByte();
    Short maxSchedulingMemoryAsShort();
    Integer maxSchedulingMemoryAsInteger();
    Long maxSchedulingMemoryAsLong();
    
    boolean maxSchedulingMemoryPresent();
    
    BigInteger memory();
    Byte memoryAsByte();
    Short memoryAsShort();
    Integer memoryAsInteger();
    Long memoryAsLong();
    
    boolean memoryPresent();
    
    boolean networkOperationInProgress();
    
    boolean networkOperationInProgressPresent();
    
    boolean numaSupported();
    
    boolean numaSupportedPresent();
    
    OperatingSystem os();
    
    boolean osPresent();
    
    boolean overrideIptables();
    
    boolean overrideIptablesPresent();
    
    boolean ovnConfigured();
    
    boolean ovnConfiguredPresent();
    
    BigInteger port();
    Byte portAsByte();
    Short portAsShort();
    Integer portAsInteger();
    Long portAsLong();
    
    boolean portPresent();
    
    PowerManagement powerManagement();
    
    boolean powerManagementPresent();
    
    HostProtocol protocol();
    
    boolean protocolPresent();
    
    boolean reinstallationRequired();
    
    boolean reinstallationRequiredPresent();
    
    String rootPassword();
    
    boolean rootPasswordPresent();
    
    SeLinux seLinux();
    
    boolean seLinuxPresent();
    
    Spm spm();
    
    boolean spmPresent();
    
    Ssh ssh();
    
    boolean sshPresent();
    
    HostStatus status();
    
    boolean statusPresent();
    
    String statusDetail();
    
    boolean statusDetailPresent();
    
    VmSummary summary();
    
    boolean summaryPresent();
    
    TransparentHugePages transparentHugePages();
    
    boolean transparentHugePagesPresent();
    
    HostType type();
    
    boolean typePresent();
    
    boolean updateAvailable();
    
    boolean updateAvailablePresent();
    
    Version version();
    
    boolean versionPresent();
    
    VgpuPlacement vgpuPlacement();
    
    boolean vgpuPlacementPresent();
    
    List<AffinityLabel> affinityLabels();
    
    boolean affinityLabelsPresent();
    
    List<Agent> agents();
    
    boolean agentsPresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    List<HostDevice> devices();
    
    boolean devicesPresent();
    
    ExternalHostProvider externalHostProvider();
    
    boolean externalHostProviderPresent();
    
    List<ExternalNetworkProviderConfiguration> externalNetworkProviderConfigurations();
    
    boolean externalNetworkProviderConfigurationsPresent();
    
    List<Hook> hooks();
    
    boolean hooksPresent();
    
    List<KatelloErratum> katelloErrata();
    
    boolean katelloErrataPresent();
    
    List<NetworkAttachment> networkAttachments();
    
    boolean networkAttachmentsPresent();
    
    List<HostNic> nics();
    
    boolean nicsPresent();
    
    List<NumaNode> numaNodes();
    
    boolean numaNodesPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
    List<StorageConnectionExtension> storageConnectionExtensions();
    
    boolean storageConnectionExtensionsPresent();
    
    List<HostStorage> storages();
    
    boolean storagesPresent();
    
    List<Tag> tags();
    
    boolean tagsPresent();
    
    List<UnmanagedNetwork> unmanagedNetworks();
    
    boolean unmanagedNetworksPresent();
    
}
