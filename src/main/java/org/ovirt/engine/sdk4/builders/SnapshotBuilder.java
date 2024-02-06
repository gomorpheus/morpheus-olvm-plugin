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
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.SnapshotContainer;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.Application;
import org.ovirt.engine.sdk4.types.AutoPinningPolicy;
import org.ovirt.engine.sdk4.types.Bios;
import org.ovirt.engine.sdk4.types.Cdrom;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Console;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.CustomProperty;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.Display;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;
import org.ovirt.engine.sdk4.types.Floppy;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.GuestOperatingSystem;
import org.ovirt.engine.sdk4.types.HighAvailability;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostDevice;
import org.ovirt.engine.sdk4.types.Icon;
import org.ovirt.engine.sdk4.types.Initialization;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Io;
import org.ovirt.engine.sdk4.types.KatelloErratum;
import org.ovirt.engine.sdk4.types.MemoryPolicy;
import org.ovirt.engine.sdk4.types.MigrationOptions;
import org.ovirt.engine.sdk4.types.Nic;
import org.ovirt.engine.sdk4.types.NumaNode;
import org.ovirt.engine.sdk4.types.NumaTuneMode;
import org.ovirt.engine.sdk4.types.OperatingSystem;
import org.ovirt.engine.sdk4.types.Payload;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.ReportedDevice;
import org.ovirt.engine.sdk4.types.RngDevice;
import org.ovirt.engine.sdk4.types.SerialNumber;
import org.ovirt.engine.sdk4.types.Session;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.SnapshotStatus;
import org.ovirt.engine.sdk4.types.SnapshotType;
import org.ovirt.engine.sdk4.types.Sso;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageDomainLease;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.TimeZone;
import org.ovirt.engine.sdk4.types.Usb;
import org.ovirt.engine.sdk4.types.Version;
import org.ovirt.engine.sdk4.types.VirtioScsi;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VmPlacementPolicy;
import org.ovirt.engine.sdk4.types.VmPool;
import org.ovirt.engine.sdk4.types.VmStatus;
import org.ovirt.engine.sdk4.types.VmStorageErrorResumeBehaviour;
import org.ovirt.engine.sdk4.types.VmType;
import org.ovirt.engine.sdk4.types.Watchdog;

public class SnapshotBuilder {
    private List<AffinityLabel> affinityLabels;
    private List<Application> applications;
    private AutoPinningPolicy autoPinningPolicy;
    private Bios bios;
    private List<Cdrom> cdroms;
    private Cluster cluster;
    private String comment;
    private Console console;
    private Cpu cpu;
    private CpuProfile cpuProfile;
    private BigInteger cpuShares;
    private Date creationTime;
    private Version customCompatibilityVersion;
    private String customCpuModel;
    private String customEmulatedMachine;
    private List<CustomProperty> customProperties;
    private Date date;
    private Boolean deleteProtected;
    private String description;
    private List<DiskAttachment> diskAttachments;
    private List<Disk> disks;
    private Display display;
    private Domain domain;
    private ExternalHostProvider externalHostProvider;
    private List<Floppy> floppies;
    private String fqdn;
    private List<GraphicsConsole> graphicsConsoles;
    private GuestOperatingSystem guestOperatingSystem;
    private TimeZone guestTimeZone;
    private Boolean hasIllegalImages;
    private HighAvailability highAvailability;
    private Host host;
    private List<HostDevice> hostDevices;
    private String href;
    private String id;
    private Initialization initialization;
    private InstanceType instanceType;
    private Io io;
    private List<KatelloErratum> katelloErrata;
    private Icon largeIcon;
    private StorageDomainLease lease;
    private BigInteger memory;
    private MemoryPolicy memoryPolicy;
    private MigrationOptions migration;
    private BigInteger migrationDowntime;
    private Boolean multiQueuesEnabled;
    private String name;
    private Boolean nextRunConfigurationExists;
    private List<Nic> nics;
    private List<NumaNode> numaNodes;
    private NumaTuneMode numaTuneMode;
    private String origin;
    private Template originalTemplate;
    private OperatingSystem os;
    private List<Payload> payloads;
    private List<Permission> permissions;
    private Boolean persistMemorystate;
    private VmPlacementPolicy placementPolicy;
    private Quota quota;
    private List<ReportedDevice> reportedDevices;
    private RngDevice rngDevice;
    private Boolean runOnce;
    private SerialNumber serialNumber;
    private List<Session> sessions;
    private Icon smallIcon;
    private SnapshotStatus snapshotStatus;
    private SnapshotType snapshotType;
    private List<Snapshot> snapshots;
    private Boolean soundcardEnabled;
    private Sso sso;
    private Boolean startPaused;
    private Date startTime;
    private Boolean stateless;
    private List<Statistic> statistics;
    private VmStatus status;
    private String statusDetail;
    private String stopReason;
    private Date stopTime;
    private StorageDomain storageDomain;
    private VmStorageErrorResumeBehaviour storageErrorResumeBehaviour;
    private List<Tag> tags;
    private Template template;
    private TimeZone timeZone;
    private Boolean tpmEnabled;
    private Boolean tunnelMigration;
    private VmType type;
    private Usb usb;
    private Boolean useLatestTemplateVersion;
    private VirtioScsi virtioScsi;
    private BigInteger virtioScsiMultiQueues;
    private Boolean virtioScsiMultiQueuesEnabled;
    private Vm vm;
    private VmPool vmPool;
    private List<Watchdog> watchdogs;
    
    public SnapshotBuilder affinityLabels(List<AffinityLabel> newAffinityLabels) {
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
    
    public SnapshotBuilder affinityLabels(AffinityLabel... newAffinityLabels) {
        if (newAffinityLabels != null) {
            if (affinityLabels == null) {
                affinityLabels = new ArrayList<>(newAffinityLabels.length);
            }
            Collections.addAll(affinityLabels, newAffinityLabels);
        }
        return this;
    }
    
    public SnapshotBuilder affinityLabels(AffinityLabelBuilder... newAffinityLabels) {
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
    
    
    public SnapshotBuilder applications(List<Application> newApplications) {
        if (newApplications != null) {
            if (applications == null) {
                applications = new ArrayList<>(newApplications);
            }
            else {
                applications.addAll(newApplications);
            }
        }
        return this;
    }
    
    public SnapshotBuilder applications(Application... newApplications) {
        if (newApplications != null) {
            if (applications == null) {
                applications = new ArrayList<>(newApplications.length);
            }
            Collections.addAll(applications, newApplications);
        }
        return this;
    }
    
    public SnapshotBuilder applications(ApplicationBuilder... newApplications) {
        if (newApplications != null) {
            if (applications == null) {
                applications = new ArrayList<>(newApplications.length);
            }
            for (ApplicationBuilder builder : newApplications) {
                applications.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder autoPinningPolicy(AutoPinningPolicy newAutoPinningPolicy) {
        autoPinningPolicy = newAutoPinningPolicy;
        return this;
    }
    
    
    public SnapshotBuilder bios(Bios newBios) {
        bios = newBios;
        return this;
    }
    
    public SnapshotBuilder bios(BiosBuilder newBios) {
        if (newBios == null) {
            bios = null;
        }
        else {
            bios = newBios.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder cdroms(List<Cdrom> newCdroms) {
        if (newCdroms != null) {
            if (cdroms == null) {
                cdroms = new ArrayList<>(newCdroms);
            }
            else {
                cdroms.addAll(newCdroms);
            }
        }
        return this;
    }
    
    public SnapshotBuilder cdroms(Cdrom... newCdroms) {
        if (newCdroms != null) {
            if (cdroms == null) {
                cdroms = new ArrayList<>(newCdroms.length);
            }
            Collections.addAll(cdroms, newCdroms);
        }
        return this;
    }
    
    public SnapshotBuilder cdroms(CdromBuilder... newCdroms) {
        if (newCdroms != null) {
            if (cdroms == null) {
                cdroms = new ArrayList<>(newCdroms.length);
            }
            for (CdromBuilder builder : newCdroms) {
                cdroms.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public SnapshotBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public SnapshotBuilder console(Console newConsole) {
        console = newConsole;
        return this;
    }
    
    public SnapshotBuilder console(ConsoleBuilder newConsole) {
        if (newConsole == null) {
            console = null;
        }
        else {
            console = newConsole.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder cpu(Cpu newCpu) {
        cpu = newCpu;
        return this;
    }
    
    public SnapshotBuilder cpu(CpuBuilder newCpu) {
        if (newCpu == null) {
            cpu = null;
        }
        else {
            cpu = newCpu.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder cpuProfile(CpuProfile newCpuProfile) {
        cpuProfile = newCpuProfile;
        return this;
    }
    
    public SnapshotBuilder cpuProfile(CpuProfileBuilder newCpuProfile) {
        if (newCpuProfile == null) {
            cpuProfile = null;
        }
        else {
            cpuProfile = newCpuProfile.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder cpuShares(int newCpuShares) {
        cpuShares = BigInteger.valueOf((long) newCpuShares);
        return this;
    }
    
    public SnapshotBuilder cpuShares(Integer newCpuShares) {
        if (newCpuShares == null) {
            cpuShares = null;
        }
        else {
            cpuShares = BigInteger.valueOf(newCpuShares.longValue());
        }
        return this;
    }
    
    public SnapshotBuilder cpuShares(long newCpuShares) {
        cpuShares = BigInteger.valueOf(newCpuShares);
        return this;
    }
    
    public SnapshotBuilder cpuShares(Long newCpuShares) {
        if (newCpuShares == null) {
            cpuShares = null;
        }
        else {
            cpuShares = BigInteger.valueOf(newCpuShares.longValue());
        }
        return this;
    }
    
    public SnapshotBuilder cpuShares(BigInteger newCpuShares) {
        cpuShares = newCpuShares;
        return this;
    }
    
    
    public SnapshotBuilder creationTime(Date newCreationTime) {
        if (newCreationTime == null) {
            creationTime = null;
        }
        else {
            creationTime = new Date(newCreationTime.getTime());
        }
        return this;
    }
    
    
    public SnapshotBuilder customCompatibilityVersion(Version newCustomCompatibilityVersion) {
        customCompatibilityVersion = newCustomCompatibilityVersion;
        return this;
    }
    
    public SnapshotBuilder customCompatibilityVersion(VersionBuilder newCustomCompatibilityVersion) {
        if (newCustomCompatibilityVersion == null) {
            customCompatibilityVersion = null;
        }
        else {
            customCompatibilityVersion = newCustomCompatibilityVersion.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder customCpuModel(String newCustomCpuModel) {
        customCpuModel = newCustomCpuModel;
        return this;
    }
    
    
    public SnapshotBuilder customEmulatedMachine(String newCustomEmulatedMachine) {
        customEmulatedMachine = newCustomEmulatedMachine;
        return this;
    }
    
    
    public SnapshotBuilder customProperties(List<CustomProperty> newCustomProperties) {
        if (newCustomProperties != null) {
            if (customProperties == null) {
                customProperties = new ArrayList<>(newCustomProperties);
            }
            else {
                customProperties.addAll(newCustomProperties);
            }
        }
        return this;
    }
    
    public SnapshotBuilder customProperties(CustomProperty... newCustomProperties) {
        if (newCustomProperties != null) {
            if (customProperties == null) {
                customProperties = new ArrayList<>(newCustomProperties.length);
            }
            Collections.addAll(customProperties, newCustomProperties);
        }
        return this;
    }
    
    public SnapshotBuilder customProperties(CustomPropertyBuilder... newCustomProperties) {
        if (newCustomProperties != null) {
            if (customProperties == null) {
                customProperties = new ArrayList<>(newCustomProperties.length);
            }
            for (CustomPropertyBuilder builder : newCustomProperties) {
                customProperties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder date(Date newDate) {
        if (newDate == null) {
            date = null;
        }
        else {
            date = new Date(newDate.getTime());
        }
        return this;
    }
    
    
    public SnapshotBuilder deleteProtected(boolean newDeleteProtected) {
        deleteProtected = Boolean.valueOf(newDeleteProtected);
        return this;
    }
    
    public SnapshotBuilder deleteProtected(Boolean newDeleteProtected) {
        deleteProtected = newDeleteProtected;
        return this;
    }
    
    
    public SnapshotBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public SnapshotBuilder diskAttachments(List<DiskAttachment> newDiskAttachments) {
        if (newDiskAttachments != null) {
            if (diskAttachments == null) {
                diskAttachments = new ArrayList<>(newDiskAttachments);
            }
            else {
                diskAttachments.addAll(newDiskAttachments);
            }
        }
        return this;
    }
    
    public SnapshotBuilder diskAttachments(DiskAttachment... newDiskAttachments) {
        if (newDiskAttachments != null) {
            if (diskAttachments == null) {
                diskAttachments = new ArrayList<>(newDiskAttachments.length);
            }
            Collections.addAll(diskAttachments, newDiskAttachments);
        }
        return this;
    }
    
    public SnapshotBuilder diskAttachments(DiskAttachmentBuilder... newDiskAttachments) {
        if (newDiskAttachments != null) {
            if (diskAttachments == null) {
                diskAttachments = new ArrayList<>(newDiskAttachments.length);
            }
            for (DiskAttachmentBuilder builder : newDiskAttachments) {
                diskAttachments.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder disks(List<Disk> newDisks) {
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
    
    public SnapshotBuilder disks(Disk... newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks.length);
            }
            Collections.addAll(disks, newDisks);
        }
        return this;
    }
    
    public SnapshotBuilder disks(DiskBuilder... newDisks) {
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
    
    
    public SnapshotBuilder display(Display newDisplay) {
        display = newDisplay;
        return this;
    }
    
    public SnapshotBuilder display(DisplayBuilder newDisplay) {
        if (newDisplay == null) {
            display = null;
        }
        else {
            display = newDisplay.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder domain(Domain newDomain) {
        domain = newDomain;
        return this;
    }
    
    public SnapshotBuilder domain(DomainBuilder newDomain) {
        if (newDomain == null) {
            domain = null;
        }
        else {
            domain = newDomain.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
        return this;
    }
    
    public SnapshotBuilder externalHostProvider(ExternalHostProviderBuilder newExternalHostProvider) {
        if (newExternalHostProvider == null) {
            externalHostProvider = null;
        }
        else {
            externalHostProvider = newExternalHostProvider.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder floppies(List<Floppy> newFloppies) {
        if (newFloppies != null) {
            if (floppies == null) {
                floppies = new ArrayList<>(newFloppies);
            }
            else {
                floppies.addAll(newFloppies);
            }
        }
        return this;
    }
    
    public SnapshotBuilder floppies(Floppy... newFloppies) {
        if (newFloppies != null) {
            if (floppies == null) {
                floppies = new ArrayList<>(newFloppies.length);
            }
            Collections.addAll(floppies, newFloppies);
        }
        return this;
    }
    
    public SnapshotBuilder floppies(FloppyBuilder... newFloppies) {
        if (newFloppies != null) {
            if (floppies == null) {
                floppies = new ArrayList<>(newFloppies.length);
            }
            for (FloppyBuilder builder : newFloppies) {
                floppies.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder fqdn(String newFqdn) {
        fqdn = newFqdn;
        return this;
    }
    
    
    public SnapshotBuilder graphicsConsoles(List<GraphicsConsole> newGraphicsConsoles) {
        if (newGraphicsConsoles != null) {
            if (graphicsConsoles == null) {
                graphicsConsoles = new ArrayList<>(newGraphicsConsoles);
            }
            else {
                graphicsConsoles.addAll(newGraphicsConsoles);
            }
        }
        return this;
    }
    
    public SnapshotBuilder graphicsConsoles(GraphicsConsole... newGraphicsConsoles) {
        if (newGraphicsConsoles != null) {
            if (graphicsConsoles == null) {
                graphicsConsoles = new ArrayList<>(newGraphicsConsoles.length);
            }
            Collections.addAll(graphicsConsoles, newGraphicsConsoles);
        }
        return this;
    }
    
    public SnapshotBuilder graphicsConsoles(GraphicsConsoleBuilder... newGraphicsConsoles) {
        if (newGraphicsConsoles != null) {
            if (graphicsConsoles == null) {
                graphicsConsoles = new ArrayList<>(newGraphicsConsoles.length);
            }
            for (GraphicsConsoleBuilder builder : newGraphicsConsoles) {
                graphicsConsoles.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder guestOperatingSystem(GuestOperatingSystem newGuestOperatingSystem) {
        guestOperatingSystem = newGuestOperatingSystem;
        return this;
    }
    
    public SnapshotBuilder guestOperatingSystem(GuestOperatingSystemBuilder newGuestOperatingSystem) {
        if (newGuestOperatingSystem == null) {
            guestOperatingSystem = null;
        }
        else {
            guestOperatingSystem = newGuestOperatingSystem.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder guestTimeZone(TimeZone newGuestTimeZone) {
        guestTimeZone = newGuestTimeZone;
        return this;
    }
    
    public SnapshotBuilder guestTimeZone(TimeZoneBuilder newGuestTimeZone) {
        if (newGuestTimeZone == null) {
            guestTimeZone = null;
        }
        else {
            guestTimeZone = newGuestTimeZone.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder hasIllegalImages(boolean newHasIllegalImages) {
        hasIllegalImages = Boolean.valueOf(newHasIllegalImages);
        return this;
    }
    
    public SnapshotBuilder hasIllegalImages(Boolean newHasIllegalImages) {
        hasIllegalImages = newHasIllegalImages;
        return this;
    }
    
    
    public SnapshotBuilder highAvailability(HighAvailability newHighAvailability) {
        highAvailability = newHighAvailability;
        return this;
    }
    
    public SnapshotBuilder highAvailability(HighAvailabilityBuilder newHighAvailability) {
        if (newHighAvailability == null) {
            highAvailability = null;
        }
        else {
            highAvailability = newHighAvailability.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public SnapshotBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder hostDevices(List<HostDevice> newHostDevices) {
        if (newHostDevices != null) {
            if (hostDevices == null) {
                hostDevices = new ArrayList<>(newHostDevices);
            }
            else {
                hostDevices.addAll(newHostDevices);
            }
        }
        return this;
    }
    
    public SnapshotBuilder hostDevices(HostDevice... newHostDevices) {
        if (newHostDevices != null) {
            if (hostDevices == null) {
                hostDevices = new ArrayList<>(newHostDevices.length);
            }
            Collections.addAll(hostDevices, newHostDevices);
        }
        return this;
    }
    
    public SnapshotBuilder hostDevices(HostDeviceBuilder... newHostDevices) {
        if (newHostDevices != null) {
            if (hostDevices == null) {
                hostDevices = new ArrayList<>(newHostDevices.length);
            }
            for (HostDeviceBuilder builder : newHostDevices) {
                hostDevices.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public SnapshotBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public SnapshotBuilder initialization(Initialization newInitialization) {
        initialization = newInitialization;
        return this;
    }
    
    public SnapshotBuilder initialization(InitializationBuilder newInitialization) {
        if (newInitialization == null) {
            initialization = null;
        }
        else {
            initialization = newInitialization.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public SnapshotBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder io(Io newIo) {
        io = newIo;
        return this;
    }
    
    public SnapshotBuilder io(IoBuilder newIo) {
        if (newIo == null) {
            io = null;
        }
        else {
            io = newIo.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder katelloErrata(List<KatelloErratum> newKatelloErrata) {
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
    
    public SnapshotBuilder katelloErrata(KatelloErratum... newKatelloErrata) {
        if (newKatelloErrata != null) {
            if (katelloErrata == null) {
                katelloErrata = new ArrayList<>(newKatelloErrata.length);
            }
            Collections.addAll(katelloErrata, newKatelloErrata);
        }
        return this;
    }
    
    public SnapshotBuilder katelloErrata(KatelloErratumBuilder... newKatelloErrata) {
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
    
    
    public SnapshotBuilder largeIcon(Icon newLargeIcon) {
        largeIcon = newLargeIcon;
        return this;
    }
    
    public SnapshotBuilder largeIcon(IconBuilder newLargeIcon) {
        if (newLargeIcon == null) {
            largeIcon = null;
        }
        else {
            largeIcon = newLargeIcon.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder lease(StorageDomainLease newLease) {
        lease = newLease;
        return this;
    }
    
    public SnapshotBuilder lease(StorageDomainLeaseBuilder newLease) {
        if (newLease == null) {
            lease = null;
        }
        else {
            lease = newLease.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder memory(int newMemory) {
        memory = BigInteger.valueOf((long) newMemory);
        return this;
    }
    
    public SnapshotBuilder memory(Integer newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public SnapshotBuilder memory(long newMemory) {
        memory = BigInteger.valueOf(newMemory);
        return this;
    }
    
    public SnapshotBuilder memory(Long newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public SnapshotBuilder memory(BigInteger newMemory) {
        memory = newMemory;
        return this;
    }
    
    
    public SnapshotBuilder memoryPolicy(MemoryPolicy newMemoryPolicy) {
        memoryPolicy = newMemoryPolicy;
        return this;
    }
    
    public SnapshotBuilder memoryPolicy(MemoryPolicyBuilder newMemoryPolicy) {
        if (newMemoryPolicy == null) {
            memoryPolicy = null;
        }
        else {
            memoryPolicy = newMemoryPolicy.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder migration(MigrationOptions newMigration) {
        migration = newMigration;
        return this;
    }
    
    public SnapshotBuilder migration(MigrationOptionsBuilder newMigration) {
        if (newMigration == null) {
            migration = null;
        }
        else {
            migration = newMigration.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder migrationDowntime(int newMigrationDowntime) {
        migrationDowntime = BigInteger.valueOf((long) newMigrationDowntime);
        return this;
    }
    
    public SnapshotBuilder migrationDowntime(Integer newMigrationDowntime) {
        if (newMigrationDowntime == null) {
            migrationDowntime = null;
        }
        else {
            migrationDowntime = BigInteger.valueOf(newMigrationDowntime.longValue());
        }
        return this;
    }
    
    public SnapshotBuilder migrationDowntime(long newMigrationDowntime) {
        migrationDowntime = BigInteger.valueOf(newMigrationDowntime);
        return this;
    }
    
    public SnapshotBuilder migrationDowntime(Long newMigrationDowntime) {
        if (newMigrationDowntime == null) {
            migrationDowntime = null;
        }
        else {
            migrationDowntime = BigInteger.valueOf(newMigrationDowntime.longValue());
        }
        return this;
    }
    
    public SnapshotBuilder migrationDowntime(BigInteger newMigrationDowntime) {
        migrationDowntime = newMigrationDowntime;
        return this;
    }
    
    
    public SnapshotBuilder multiQueuesEnabled(boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = Boolean.valueOf(newMultiQueuesEnabled);
        return this;
    }
    
    public SnapshotBuilder multiQueuesEnabled(Boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = newMultiQueuesEnabled;
        return this;
    }
    
    
    public SnapshotBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public SnapshotBuilder nextRunConfigurationExists(boolean newNextRunConfigurationExists) {
        nextRunConfigurationExists = Boolean.valueOf(newNextRunConfigurationExists);
        return this;
    }
    
    public SnapshotBuilder nextRunConfigurationExists(Boolean newNextRunConfigurationExists) {
        nextRunConfigurationExists = newNextRunConfigurationExists;
        return this;
    }
    
    
    public SnapshotBuilder nics(List<Nic> newNics) {
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
    
    public SnapshotBuilder nics(Nic... newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics.length);
            }
            Collections.addAll(nics, newNics);
        }
        return this;
    }
    
    public SnapshotBuilder nics(NicBuilder... newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics.length);
            }
            for (NicBuilder builder : newNics) {
                nics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder numaNodes(List<NumaNode> newNumaNodes) {
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
    
    public SnapshotBuilder numaNodes(NumaNode... newNumaNodes) {
        if (newNumaNodes != null) {
            if (numaNodes == null) {
                numaNodes = new ArrayList<>(newNumaNodes.length);
            }
            Collections.addAll(numaNodes, newNumaNodes);
        }
        return this;
    }
    
    public SnapshotBuilder numaNodes(NumaNodeBuilder... newNumaNodes) {
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
    
    
    public SnapshotBuilder numaTuneMode(NumaTuneMode newNumaTuneMode) {
        numaTuneMode = newNumaTuneMode;
        return this;
    }
    
    
    public SnapshotBuilder origin(String newOrigin) {
        origin = newOrigin;
        return this;
    }
    
    
    public SnapshotBuilder originalTemplate(Template newOriginalTemplate) {
        originalTemplate = newOriginalTemplate;
        return this;
    }
    
    public SnapshotBuilder originalTemplate(TemplateBuilder newOriginalTemplate) {
        if (newOriginalTemplate == null) {
            originalTemplate = null;
        }
        else {
            originalTemplate = newOriginalTemplate.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder os(OperatingSystem newOs) {
        os = newOs;
        return this;
    }
    
    public SnapshotBuilder os(OperatingSystemBuilder newOs) {
        if (newOs == null) {
            os = null;
        }
        else {
            os = newOs.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder payloads(List<Payload> newPayloads) {
        if (newPayloads != null) {
            if (payloads == null) {
                payloads = new ArrayList<>(newPayloads);
            }
            else {
                payloads.addAll(newPayloads);
            }
        }
        return this;
    }
    
    public SnapshotBuilder payloads(Payload... newPayloads) {
        if (newPayloads != null) {
            if (payloads == null) {
                payloads = new ArrayList<>(newPayloads.length);
            }
            Collections.addAll(payloads, newPayloads);
        }
        return this;
    }
    
    public SnapshotBuilder payloads(PayloadBuilder... newPayloads) {
        if (newPayloads != null) {
            if (payloads == null) {
                payloads = new ArrayList<>(newPayloads.length);
            }
            for (PayloadBuilder builder : newPayloads) {
                payloads.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder permissions(List<Permission> newPermissions) {
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
    
    public SnapshotBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public SnapshotBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public SnapshotBuilder persistMemorystate(boolean newPersistMemorystate) {
        persistMemorystate = Boolean.valueOf(newPersistMemorystate);
        return this;
    }
    
    public SnapshotBuilder persistMemorystate(Boolean newPersistMemorystate) {
        persistMemorystate = newPersistMemorystate;
        return this;
    }
    
    
    public SnapshotBuilder placementPolicy(VmPlacementPolicy newPlacementPolicy) {
        placementPolicy = newPlacementPolicy;
        return this;
    }
    
    public SnapshotBuilder placementPolicy(VmPlacementPolicyBuilder newPlacementPolicy) {
        if (newPlacementPolicy == null) {
            placementPolicy = null;
        }
        else {
            placementPolicy = newPlacementPolicy.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public SnapshotBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder reportedDevices(List<ReportedDevice> newReportedDevices) {
        if (newReportedDevices != null) {
            if (reportedDevices == null) {
                reportedDevices = new ArrayList<>(newReportedDevices);
            }
            else {
                reportedDevices.addAll(newReportedDevices);
            }
        }
        return this;
    }
    
    public SnapshotBuilder reportedDevices(ReportedDevice... newReportedDevices) {
        if (newReportedDevices != null) {
            if (reportedDevices == null) {
                reportedDevices = new ArrayList<>(newReportedDevices.length);
            }
            Collections.addAll(reportedDevices, newReportedDevices);
        }
        return this;
    }
    
    public SnapshotBuilder reportedDevices(ReportedDeviceBuilder... newReportedDevices) {
        if (newReportedDevices != null) {
            if (reportedDevices == null) {
                reportedDevices = new ArrayList<>(newReportedDevices.length);
            }
            for (ReportedDeviceBuilder builder : newReportedDevices) {
                reportedDevices.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder rngDevice(RngDevice newRngDevice) {
        rngDevice = newRngDevice;
        return this;
    }
    
    public SnapshotBuilder rngDevice(RngDeviceBuilder newRngDevice) {
        if (newRngDevice == null) {
            rngDevice = null;
        }
        else {
            rngDevice = newRngDevice.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder runOnce(boolean newRunOnce) {
        runOnce = Boolean.valueOf(newRunOnce);
        return this;
    }
    
    public SnapshotBuilder runOnce(Boolean newRunOnce) {
        runOnce = newRunOnce;
        return this;
    }
    
    
    public SnapshotBuilder serialNumber(SerialNumber newSerialNumber) {
        serialNumber = newSerialNumber;
        return this;
    }
    
    public SnapshotBuilder serialNumber(SerialNumberBuilder newSerialNumber) {
        if (newSerialNumber == null) {
            serialNumber = null;
        }
        else {
            serialNumber = newSerialNumber.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder sessions(List<Session> newSessions) {
        if (newSessions != null) {
            if (sessions == null) {
                sessions = new ArrayList<>(newSessions);
            }
            else {
                sessions.addAll(newSessions);
            }
        }
        return this;
    }
    
    public SnapshotBuilder sessions(Session... newSessions) {
        if (newSessions != null) {
            if (sessions == null) {
                sessions = new ArrayList<>(newSessions.length);
            }
            Collections.addAll(sessions, newSessions);
        }
        return this;
    }
    
    public SnapshotBuilder sessions(SessionBuilder... newSessions) {
        if (newSessions != null) {
            if (sessions == null) {
                sessions = new ArrayList<>(newSessions.length);
            }
            for (SessionBuilder builder : newSessions) {
                sessions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder smallIcon(Icon newSmallIcon) {
        smallIcon = newSmallIcon;
        return this;
    }
    
    public SnapshotBuilder smallIcon(IconBuilder newSmallIcon) {
        if (newSmallIcon == null) {
            smallIcon = null;
        }
        else {
            smallIcon = newSmallIcon.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder snapshotStatus(SnapshotStatus newSnapshotStatus) {
        snapshotStatus = newSnapshotStatus;
        return this;
    }
    
    
    public SnapshotBuilder snapshotType(SnapshotType newSnapshotType) {
        snapshotType = newSnapshotType;
        return this;
    }
    
    
    public SnapshotBuilder snapshots(List<Snapshot> newSnapshots) {
        if (newSnapshots != null) {
            if (snapshots == null) {
                snapshots = new ArrayList<>(newSnapshots);
            }
            else {
                snapshots.addAll(newSnapshots);
            }
        }
        return this;
    }
    
    public SnapshotBuilder snapshots(Snapshot... newSnapshots) {
        if (newSnapshots != null) {
            if (snapshots == null) {
                snapshots = new ArrayList<>(newSnapshots.length);
            }
            Collections.addAll(snapshots, newSnapshots);
        }
        return this;
    }
    
    public SnapshotBuilder snapshots(SnapshotBuilder... newSnapshots) {
        if (newSnapshots != null) {
            if (snapshots == null) {
                snapshots = new ArrayList<>(newSnapshots.length);
            }
            for (SnapshotBuilder builder : newSnapshots) {
                snapshots.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SnapshotBuilder soundcardEnabled(boolean newSoundcardEnabled) {
        soundcardEnabled = Boolean.valueOf(newSoundcardEnabled);
        return this;
    }
    
    public SnapshotBuilder soundcardEnabled(Boolean newSoundcardEnabled) {
        soundcardEnabled = newSoundcardEnabled;
        return this;
    }
    
    
    public SnapshotBuilder sso(Sso newSso) {
        sso = newSso;
        return this;
    }
    
    public SnapshotBuilder sso(SsoBuilder newSso) {
        if (newSso == null) {
            sso = null;
        }
        else {
            sso = newSso.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder startPaused(boolean newStartPaused) {
        startPaused = Boolean.valueOf(newStartPaused);
        return this;
    }
    
    public SnapshotBuilder startPaused(Boolean newStartPaused) {
        startPaused = newStartPaused;
        return this;
    }
    
    
    public SnapshotBuilder startTime(Date newStartTime) {
        if (newStartTime == null) {
            startTime = null;
        }
        else {
            startTime = new Date(newStartTime.getTime());
        }
        return this;
    }
    
    
    public SnapshotBuilder stateless(boolean newStateless) {
        stateless = Boolean.valueOf(newStateless);
        return this;
    }
    
    public SnapshotBuilder stateless(Boolean newStateless) {
        stateless = newStateless;
        return this;
    }
    
    
    public SnapshotBuilder statistics(List<Statistic> newStatistics) {
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
    
    public SnapshotBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public SnapshotBuilder statistics(StatisticBuilder... newStatistics) {
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
    
    
    public SnapshotBuilder status(VmStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public SnapshotBuilder statusDetail(String newStatusDetail) {
        statusDetail = newStatusDetail;
        return this;
    }
    
    
    public SnapshotBuilder stopReason(String newStopReason) {
        stopReason = newStopReason;
        return this;
    }
    
    
    public SnapshotBuilder stopTime(Date newStopTime) {
        if (newStopTime == null) {
            stopTime = null;
        }
        else {
            stopTime = new Date(newStopTime.getTime());
        }
        return this;
    }
    
    
    public SnapshotBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public SnapshotBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder storageErrorResumeBehaviour(VmStorageErrorResumeBehaviour newStorageErrorResumeBehaviour) {
        storageErrorResumeBehaviour = newStorageErrorResumeBehaviour;
        return this;
    }
    
    
    public SnapshotBuilder tags(List<Tag> newTags) {
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
    
    public SnapshotBuilder tags(Tag... newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags.length);
            }
            Collections.addAll(tags, newTags);
        }
        return this;
    }
    
    public SnapshotBuilder tags(TagBuilder... newTags) {
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
    
    
    public SnapshotBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public SnapshotBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder timeZone(TimeZone newTimeZone) {
        timeZone = newTimeZone;
        return this;
    }
    
    public SnapshotBuilder timeZone(TimeZoneBuilder newTimeZone) {
        if (newTimeZone == null) {
            timeZone = null;
        }
        else {
            timeZone = newTimeZone.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder tpmEnabled(boolean newTpmEnabled) {
        tpmEnabled = Boolean.valueOf(newTpmEnabled);
        return this;
    }
    
    public SnapshotBuilder tpmEnabled(Boolean newTpmEnabled) {
        tpmEnabled = newTpmEnabled;
        return this;
    }
    
    
    public SnapshotBuilder tunnelMigration(boolean newTunnelMigration) {
        tunnelMigration = Boolean.valueOf(newTunnelMigration);
        return this;
    }
    
    public SnapshotBuilder tunnelMigration(Boolean newTunnelMigration) {
        tunnelMigration = newTunnelMigration;
        return this;
    }
    
    
    public SnapshotBuilder type(VmType newType) {
        type = newType;
        return this;
    }
    
    
    public SnapshotBuilder usb(Usb newUsb) {
        usb = newUsb;
        return this;
    }
    
    public SnapshotBuilder usb(UsbBuilder newUsb) {
        if (newUsb == null) {
            usb = null;
        }
        else {
            usb = newUsb.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder useLatestTemplateVersion(boolean newUseLatestTemplateVersion) {
        useLatestTemplateVersion = Boolean.valueOf(newUseLatestTemplateVersion);
        return this;
    }
    
    public SnapshotBuilder useLatestTemplateVersion(Boolean newUseLatestTemplateVersion) {
        useLatestTemplateVersion = newUseLatestTemplateVersion;
        return this;
    }
    
    
    public SnapshotBuilder virtioScsi(VirtioScsi newVirtioScsi) {
        virtioScsi = newVirtioScsi;
        return this;
    }
    
    public SnapshotBuilder virtioScsi(VirtioScsiBuilder newVirtioScsi) {
        if (newVirtioScsi == null) {
            virtioScsi = null;
        }
        else {
            virtioScsi = newVirtioScsi.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder virtioScsiMultiQueues(int newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = BigInteger.valueOf((long) newVirtioScsiMultiQueues);
        return this;
    }
    
    public SnapshotBuilder virtioScsiMultiQueues(Integer newVirtioScsiMultiQueues) {
        if (newVirtioScsiMultiQueues == null) {
            virtioScsiMultiQueues = null;
        }
        else {
            virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues.longValue());
        }
        return this;
    }
    
    public SnapshotBuilder virtioScsiMultiQueues(long newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues);
        return this;
    }
    
    public SnapshotBuilder virtioScsiMultiQueues(Long newVirtioScsiMultiQueues) {
        if (newVirtioScsiMultiQueues == null) {
            virtioScsiMultiQueues = null;
        }
        else {
            virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues.longValue());
        }
        return this;
    }
    
    public SnapshotBuilder virtioScsiMultiQueues(BigInteger newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = newVirtioScsiMultiQueues;
        return this;
    }
    
    
    public SnapshotBuilder virtioScsiMultiQueuesEnabled(boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = Boolean.valueOf(newVirtioScsiMultiQueuesEnabled);
        return this;
    }
    
    public SnapshotBuilder virtioScsiMultiQueuesEnabled(Boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = newVirtioScsiMultiQueuesEnabled;
        return this;
    }
    
    
    public SnapshotBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public SnapshotBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder vmPool(VmPool newVmPool) {
        vmPool = newVmPool;
        return this;
    }
    
    public SnapshotBuilder vmPool(VmPoolBuilder newVmPool) {
        if (newVmPool == null) {
            vmPool = null;
        }
        else {
            vmPool = newVmPool.build();
        }
        return this;
    }
    
    
    public SnapshotBuilder watchdogs(List<Watchdog> newWatchdogs) {
        if (newWatchdogs != null) {
            if (watchdogs == null) {
                watchdogs = new ArrayList<>(newWatchdogs);
            }
            else {
                watchdogs.addAll(newWatchdogs);
            }
        }
        return this;
    }
    
    public SnapshotBuilder watchdogs(Watchdog... newWatchdogs) {
        if (newWatchdogs != null) {
            if (watchdogs == null) {
                watchdogs = new ArrayList<>(newWatchdogs.length);
            }
            Collections.addAll(watchdogs, newWatchdogs);
        }
        return this;
    }
    
    public SnapshotBuilder watchdogs(WatchdogBuilder... newWatchdogs) {
        if (newWatchdogs != null) {
            if (watchdogs == null) {
                watchdogs = new ArrayList<>(newWatchdogs.length);
            }
            for (WatchdogBuilder builder : newWatchdogs) {
                watchdogs.add(builder.build());
            }
        }
        return this;
    }
    
    
    public Snapshot build() {
        SnapshotContainer container = new SnapshotContainer();
        container.affinityLabels(affinityLabels);
        container.applications(applications);
        container.autoPinningPolicy(autoPinningPolicy);
        container.bios(bios);
        container.cdroms(cdroms);
        container.cluster(cluster);
        container.comment(comment);
        container.console(console);
        container.cpu(cpu);
        container.cpuProfile(cpuProfile);
        container.cpuShares(cpuShares);
        container.creationTime(creationTime);
        container.customCompatibilityVersion(customCompatibilityVersion);
        container.customCpuModel(customCpuModel);
        container.customEmulatedMachine(customEmulatedMachine);
        container.customProperties(customProperties);
        container.date(date);
        container.deleteProtected(deleteProtected);
        container.description(description);
        container.diskAttachments(diskAttachments);
        container.disks(disks);
        container.display(display);
        container.domain(domain);
        container.externalHostProvider(externalHostProvider);
        container.floppies(floppies);
        container.fqdn(fqdn);
        container.graphicsConsoles(graphicsConsoles);
        container.guestOperatingSystem(guestOperatingSystem);
        container.guestTimeZone(guestTimeZone);
        container.hasIllegalImages(hasIllegalImages);
        container.highAvailability(highAvailability);
        container.host(host);
        container.hostDevices(hostDevices);
        container.href(href);
        container.id(id);
        container.initialization(initialization);
        container.instanceType(instanceType);
        container.io(io);
        container.katelloErrata(katelloErrata);
        container.largeIcon(largeIcon);
        container.lease(lease);
        container.memory(memory);
        container.memoryPolicy(memoryPolicy);
        container.migration(migration);
        container.migrationDowntime(migrationDowntime);
        container.multiQueuesEnabled(multiQueuesEnabled);
        container.name(name);
        container.nextRunConfigurationExists(nextRunConfigurationExists);
        container.nics(nics);
        container.numaNodes(numaNodes);
        container.numaTuneMode(numaTuneMode);
        container.origin(origin);
        container.originalTemplate(originalTemplate);
        container.os(os);
        container.payloads(payloads);
        container.permissions(permissions);
        container.persistMemorystate(persistMemorystate);
        container.placementPolicy(placementPolicy);
        container.quota(quota);
        container.reportedDevices(reportedDevices);
        container.rngDevice(rngDevice);
        container.runOnce(runOnce);
        container.serialNumber(serialNumber);
        container.sessions(sessions);
        container.smallIcon(smallIcon);
        container.snapshotStatus(snapshotStatus);
        container.snapshotType(snapshotType);
        container.snapshots(snapshots);
        container.soundcardEnabled(soundcardEnabled);
        container.sso(sso);
        container.startPaused(startPaused);
        container.startTime(startTime);
        container.stateless(stateless);
        container.statistics(statistics);
        container.status(status);
        container.statusDetail(statusDetail);
        container.stopReason(stopReason);
        container.stopTime(stopTime);
        container.storageDomain(storageDomain);
        container.storageErrorResumeBehaviour(storageErrorResumeBehaviour);
        container.tags(tags);
        container.template(template);
        container.timeZone(timeZone);
        container.tpmEnabled(tpmEnabled);
        container.tunnelMigration(tunnelMigration);
        container.type(type);
        container.usb(usb);
        container.useLatestTemplateVersion(useLatestTemplateVersion);
        container.virtioScsi(virtioScsi);
        container.virtioScsiMultiQueues(virtioScsiMultiQueues);
        container.virtioScsiMultiQueuesEnabled(virtioScsiMultiQueuesEnabled);
        container.vm(vm);
        container.vmPool(vmPool);
        container.watchdogs(watchdogs);
        return container;
    }
}
