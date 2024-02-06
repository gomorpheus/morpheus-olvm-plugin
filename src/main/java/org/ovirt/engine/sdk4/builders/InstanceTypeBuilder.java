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
import org.ovirt.engine.sdk4.internal.containers.InstanceTypeContainer;
import org.ovirt.engine.sdk4.types.AutoPinningPolicy;
import org.ovirt.engine.sdk4.types.Bios;
import org.ovirt.engine.sdk4.types.Cdrom;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Console;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.CustomProperty;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.Display;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.HighAvailability;
import org.ovirt.engine.sdk4.types.Icon;
import org.ovirt.engine.sdk4.types.Initialization;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Io;
import org.ovirt.engine.sdk4.types.MemoryPolicy;
import org.ovirt.engine.sdk4.types.MigrationOptions;
import org.ovirt.engine.sdk4.types.Nic;
import org.ovirt.engine.sdk4.types.OperatingSystem;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.RngDevice;
import org.ovirt.engine.sdk4.types.SerialNumber;
import org.ovirt.engine.sdk4.types.Sso;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageDomainLease;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.TemplateStatus;
import org.ovirt.engine.sdk4.types.TemplateVersion;
import org.ovirt.engine.sdk4.types.TimeZone;
import org.ovirt.engine.sdk4.types.Usb;
import org.ovirt.engine.sdk4.types.Version;
import org.ovirt.engine.sdk4.types.VirtioScsi;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VmPlacementPolicy;
import org.ovirt.engine.sdk4.types.VmStorageErrorResumeBehaviour;
import org.ovirt.engine.sdk4.types.VmType;
import org.ovirt.engine.sdk4.types.Watchdog;

public class InstanceTypeBuilder {
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
    private Boolean deleteProtected;
    private String description;
    private List<DiskAttachment> diskAttachments;
    private Display display;
    private Domain domain;
    private List<GraphicsConsole> graphicsConsoles;
    private HighAvailability highAvailability;
    private String href;
    private String id;
    private Initialization initialization;
    private Io io;
    private Icon largeIcon;
    private StorageDomainLease lease;
    private BigInteger memory;
    private MemoryPolicy memoryPolicy;
    private MigrationOptions migration;
    private BigInteger migrationDowntime;
    private Boolean multiQueuesEnabled;
    private String name;
    private List<Nic> nics;
    private String origin;
    private OperatingSystem os;
    private List<Permission> permissions;
    private VmPlacementPolicy placementPolicy;
    private Quota quota;
    private RngDevice rngDevice;
    private SerialNumber serialNumber;
    private Icon smallIcon;
    private Boolean soundcardEnabled;
    private Sso sso;
    private Boolean startPaused;
    private Boolean stateless;
    private TemplateStatus status;
    private StorageDomain storageDomain;
    private VmStorageErrorResumeBehaviour storageErrorResumeBehaviour;
    private List<Tag> tags;
    private TimeZone timeZone;
    private Boolean tpmEnabled;
    private Boolean tunnelMigration;
    private VmType type;
    private Usb usb;
    private TemplateVersion version;
    private VirtioScsi virtioScsi;
    private BigInteger virtioScsiMultiQueues;
    private Boolean virtioScsiMultiQueuesEnabled;
    private Vm vm;
    private List<Watchdog> watchdogs;
    
    public InstanceTypeBuilder autoPinningPolicy(AutoPinningPolicy newAutoPinningPolicy) {
        autoPinningPolicy = newAutoPinningPolicy;
        return this;
    }
    
    
    public InstanceTypeBuilder bios(Bios newBios) {
        bios = newBios;
        return this;
    }
    
    public InstanceTypeBuilder bios(BiosBuilder newBios) {
        if (newBios == null) {
            bios = null;
        }
        else {
            bios = newBios.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder cdroms(List<Cdrom> newCdroms) {
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
    
    public InstanceTypeBuilder cdroms(Cdrom... newCdroms) {
        if (newCdroms != null) {
            if (cdroms == null) {
                cdroms = new ArrayList<>(newCdroms.length);
            }
            Collections.addAll(cdroms, newCdroms);
        }
        return this;
    }
    
    public InstanceTypeBuilder cdroms(CdromBuilder... newCdroms) {
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
    
    
    public InstanceTypeBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public InstanceTypeBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public InstanceTypeBuilder console(Console newConsole) {
        console = newConsole;
        return this;
    }
    
    public InstanceTypeBuilder console(ConsoleBuilder newConsole) {
        if (newConsole == null) {
            console = null;
        }
        else {
            console = newConsole.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder cpu(Cpu newCpu) {
        cpu = newCpu;
        return this;
    }
    
    public InstanceTypeBuilder cpu(CpuBuilder newCpu) {
        if (newCpu == null) {
            cpu = null;
        }
        else {
            cpu = newCpu.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder cpuProfile(CpuProfile newCpuProfile) {
        cpuProfile = newCpuProfile;
        return this;
    }
    
    public InstanceTypeBuilder cpuProfile(CpuProfileBuilder newCpuProfile) {
        if (newCpuProfile == null) {
            cpuProfile = null;
        }
        else {
            cpuProfile = newCpuProfile.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder cpuShares(int newCpuShares) {
        cpuShares = BigInteger.valueOf((long) newCpuShares);
        return this;
    }
    
    public InstanceTypeBuilder cpuShares(Integer newCpuShares) {
        if (newCpuShares == null) {
            cpuShares = null;
        }
        else {
            cpuShares = BigInteger.valueOf(newCpuShares.longValue());
        }
        return this;
    }
    
    public InstanceTypeBuilder cpuShares(long newCpuShares) {
        cpuShares = BigInteger.valueOf(newCpuShares);
        return this;
    }
    
    public InstanceTypeBuilder cpuShares(Long newCpuShares) {
        if (newCpuShares == null) {
            cpuShares = null;
        }
        else {
            cpuShares = BigInteger.valueOf(newCpuShares.longValue());
        }
        return this;
    }
    
    public InstanceTypeBuilder cpuShares(BigInteger newCpuShares) {
        cpuShares = newCpuShares;
        return this;
    }
    
    
    public InstanceTypeBuilder creationTime(Date newCreationTime) {
        if (newCreationTime == null) {
            creationTime = null;
        }
        else {
            creationTime = new Date(newCreationTime.getTime());
        }
        return this;
    }
    
    
    public InstanceTypeBuilder customCompatibilityVersion(Version newCustomCompatibilityVersion) {
        customCompatibilityVersion = newCustomCompatibilityVersion;
        return this;
    }
    
    public InstanceTypeBuilder customCompatibilityVersion(VersionBuilder newCustomCompatibilityVersion) {
        if (newCustomCompatibilityVersion == null) {
            customCompatibilityVersion = null;
        }
        else {
            customCompatibilityVersion = newCustomCompatibilityVersion.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder customCpuModel(String newCustomCpuModel) {
        customCpuModel = newCustomCpuModel;
        return this;
    }
    
    
    public InstanceTypeBuilder customEmulatedMachine(String newCustomEmulatedMachine) {
        customEmulatedMachine = newCustomEmulatedMachine;
        return this;
    }
    
    
    public InstanceTypeBuilder customProperties(List<CustomProperty> newCustomProperties) {
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
    
    public InstanceTypeBuilder customProperties(CustomProperty... newCustomProperties) {
        if (newCustomProperties != null) {
            if (customProperties == null) {
                customProperties = new ArrayList<>(newCustomProperties.length);
            }
            Collections.addAll(customProperties, newCustomProperties);
        }
        return this;
    }
    
    public InstanceTypeBuilder customProperties(CustomPropertyBuilder... newCustomProperties) {
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
    
    
    public InstanceTypeBuilder deleteProtected(boolean newDeleteProtected) {
        deleteProtected = Boolean.valueOf(newDeleteProtected);
        return this;
    }
    
    public InstanceTypeBuilder deleteProtected(Boolean newDeleteProtected) {
        deleteProtected = newDeleteProtected;
        return this;
    }
    
    
    public InstanceTypeBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public InstanceTypeBuilder diskAttachments(List<DiskAttachment> newDiskAttachments) {
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
    
    public InstanceTypeBuilder diskAttachments(DiskAttachment... newDiskAttachments) {
        if (newDiskAttachments != null) {
            if (diskAttachments == null) {
                diskAttachments = new ArrayList<>(newDiskAttachments.length);
            }
            Collections.addAll(diskAttachments, newDiskAttachments);
        }
        return this;
    }
    
    public InstanceTypeBuilder diskAttachments(DiskAttachmentBuilder... newDiskAttachments) {
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
    
    
    public InstanceTypeBuilder display(Display newDisplay) {
        display = newDisplay;
        return this;
    }
    
    public InstanceTypeBuilder display(DisplayBuilder newDisplay) {
        if (newDisplay == null) {
            display = null;
        }
        else {
            display = newDisplay.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder domain(Domain newDomain) {
        domain = newDomain;
        return this;
    }
    
    public InstanceTypeBuilder domain(DomainBuilder newDomain) {
        if (newDomain == null) {
            domain = null;
        }
        else {
            domain = newDomain.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder graphicsConsoles(List<GraphicsConsole> newGraphicsConsoles) {
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
    
    public InstanceTypeBuilder graphicsConsoles(GraphicsConsole... newGraphicsConsoles) {
        if (newGraphicsConsoles != null) {
            if (graphicsConsoles == null) {
                graphicsConsoles = new ArrayList<>(newGraphicsConsoles.length);
            }
            Collections.addAll(graphicsConsoles, newGraphicsConsoles);
        }
        return this;
    }
    
    public InstanceTypeBuilder graphicsConsoles(GraphicsConsoleBuilder... newGraphicsConsoles) {
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
    
    
    public InstanceTypeBuilder highAvailability(HighAvailability newHighAvailability) {
        highAvailability = newHighAvailability;
        return this;
    }
    
    public InstanceTypeBuilder highAvailability(HighAvailabilityBuilder newHighAvailability) {
        if (newHighAvailability == null) {
            highAvailability = null;
        }
        else {
            highAvailability = newHighAvailability.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public InstanceTypeBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public InstanceTypeBuilder initialization(Initialization newInitialization) {
        initialization = newInitialization;
        return this;
    }
    
    public InstanceTypeBuilder initialization(InitializationBuilder newInitialization) {
        if (newInitialization == null) {
            initialization = null;
        }
        else {
            initialization = newInitialization.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder io(Io newIo) {
        io = newIo;
        return this;
    }
    
    public InstanceTypeBuilder io(IoBuilder newIo) {
        if (newIo == null) {
            io = null;
        }
        else {
            io = newIo.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder largeIcon(Icon newLargeIcon) {
        largeIcon = newLargeIcon;
        return this;
    }
    
    public InstanceTypeBuilder largeIcon(IconBuilder newLargeIcon) {
        if (newLargeIcon == null) {
            largeIcon = null;
        }
        else {
            largeIcon = newLargeIcon.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder lease(StorageDomainLease newLease) {
        lease = newLease;
        return this;
    }
    
    public InstanceTypeBuilder lease(StorageDomainLeaseBuilder newLease) {
        if (newLease == null) {
            lease = null;
        }
        else {
            lease = newLease.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder memory(int newMemory) {
        memory = BigInteger.valueOf((long) newMemory);
        return this;
    }
    
    public InstanceTypeBuilder memory(Integer newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public InstanceTypeBuilder memory(long newMemory) {
        memory = BigInteger.valueOf(newMemory);
        return this;
    }
    
    public InstanceTypeBuilder memory(Long newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public InstanceTypeBuilder memory(BigInteger newMemory) {
        memory = newMemory;
        return this;
    }
    
    
    public InstanceTypeBuilder memoryPolicy(MemoryPolicy newMemoryPolicy) {
        memoryPolicy = newMemoryPolicy;
        return this;
    }
    
    public InstanceTypeBuilder memoryPolicy(MemoryPolicyBuilder newMemoryPolicy) {
        if (newMemoryPolicy == null) {
            memoryPolicy = null;
        }
        else {
            memoryPolicy = newMemoryPolicy.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder migration(MigrationOptions newMigration) {
        migration = newMigration;
        return this;
    }
    
    public InstanceTypeBuilder migration(MigrationOptionsBuilder newMigration) {
        if (newMigration == null) {
            migration = null;
        }
        else {
            migration = newMigration.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder migrationDowntime(int newMigrationDowntime) {
        migrationDowntime = BigInteger.valueOf((long) newMigrationDowntime);
        return this;
    }
    
    public InstanceTypeBuilder migrationDowntime(Integer newMigrationDowntime) {
        if (newMigrationDowntime == null) {
            migrationDowntime = null;
        }
        else {
            migrationDowntime = BigInteger.valueOf(newMigrationDowntime.longValue());
        }
        return this;
    }
    
    public InstanceTypeBuilder migrationDowntime(long newMigrationDowntime) {
        migrationDowntime = BigInteger.valueOf(newMigrationDowntime);
        return this;
    }
    
    public InstanceTypeBuilder migrationDowntime(Long newMigrationDowntime) {
        if (newMigrationDowntime == null) {
            migrationDowntime = null;
        }
        else {
            migrationDowntime = BigInteger.valueOf(newMigrationDowntime.longValue());
        }
        return this;
    }
    
    public InstanceTypeBuilder migrationDowntime(BigInteger newMigrationDowntime) {
        migrationDowntime = newMigrationDowntime;
        return this;
    }
    
    
    public InstanceTypeBuilder multiQueuesEnabled(boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = Boolean.valueOf(newMultiQueuesEnabled);
        return this;
    }
    
    public InstanceTypeBuilder multiQueuesEnabled(Boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = newMultiQueuesEnabled;
        return this;
    }
    
    
    public InstanceTypeBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public InstanceTypeBuilder nics(List<Nic> newNics) {
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
    
    public InstanceTypeBuilder nics(Nic... newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics.length);
            }
            Collections.addAll(nics, newNics);
        }
        return this;
    }
    
    public InstanceTypeBuilder nics(NicBuilder... newNics) {
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
    
    
    public InstanceTypeBuilder origin(String newOrigin) {
        origin = newOrigin;
        return this;
    }
    
    
    public InstanceTypeBuilder os(OperatingSystem newOs) {
        os = newOs;
        return this;
    }
    
    public InstanceTypeBuilder os(OperatingSystemBuilder newOs) {
        if (newOs == null) {
            os = null;
        }
        else {
            os = newOs.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder permissions(List<Permission> newPermissions) {
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
    
    public InstanceTypeBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public InstanceTypeBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public InstanceTypeBuilder placementPolicy(VmPlacementPolicy newPlacementPolicy) {
        placementPolicy = newPlacementPolicy;
        return this;
    }
    
    public InstanceTypeBuilder placementPolicy(VmPlacementPolicyBuilder newPlacementPolicy) {
        if (newPlacementPolicy == null) {
            placementPolicy = null;
        }
        else {
            placementPolicy = newPlacementPolicy.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public InstanceTypeBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder rngDevice(RngDevice newRngDevice) {
        rngDevice = newRngDevice;
        return this;
    }
    
    public InstanceTypeBuilder rngDevice(RngDeviceBuilder newRngDevice) {
        if (newRngDevice == null) {
            rngDevice = null;
        }
        else {
            rngDevice = newRngDevice.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder serialNumber(SerialNumber newSerialNumber) {
        serialNumber = newSerialNumber;
        return this;
    }
    
    public InstanceTypeBuilder serialNumber(SerialNumberBuilder newSerialNumber) {
        if (newSerialNumber == null) {
            serialNumber = null;
        }
        else {
            serialNumber = newSerialNumber.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder smallIcon(Icon newSmallIcon) {
        smallIcon = newSmallIcon;
        return this;
    }
    
    public InstanceTypeBuilder smallIcon(IconBuilder newSmallIcon) {
        if (newSmallIcon == null) {
            smallIcon = null;
        }
        else {
            smallIcon = newSmallIcon.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder soundcardEnabled(boolean newSoundcardEnabled) {
        soundcardEnabled = Boolean.valueOf(newSoundcardEnabled);
        return this;
    }
    
    public InstanceTypeBuilder soundcardEnabled(Boolean newSoundcardEnabled) {
        soundcardEnabled = newSoundcardEnabled;
        return this;
    }
    
    
    public InstanceTypeBuilder sso(Sso newSso) {
        sso = newSso;
        return this;
    }
    
    public InstanceTypeBuilder sso(SsoBuilder newSso) {
        if (newSso == null) {
            sso = null;
        }
        else {
            sso = newSso.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder startPaused(boolean newStartPaused) {
        startPaused = Boolean.valueOf(newStartPaused);
        return this;
    }
    
    public InstanceTypeBuilder startPaused(Boolean newStartPaused) {
        startPaused = newStartPaused;
        return this;
    }
    
    
    public InstanceTypeBuilder stateless(boolean newStateless) {
        stateless = Boolean.valueOf(newStateless);
        return this;
    }
    
    public InstanceTypeBuilder stateless(Boolean newStateless) {
        stateless = newStateless;
        return this;
    }
    
    
    public InstanceTypeBuilder status(TemplateStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public InstanceTypeBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public InstanceTypeBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder storageErrorResumeBehaviour(VmStorageErrorResumeBehaviour newStorageErrorResumeBehaviour) {
        storageErrorResumeBehaviour = newStorageErrorResumeBehaviour;
        return this;
    }
    
    
    public InstanceTypeBuilder tags(List<Tag> newTags) {
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
    
    public InstanceTypeBuilder tags(Tag... newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags.length);
            }
            Collections.addAll(tags, newTags);
        }
        return this;
    }
    
    public InstanceTypeBuilder tags(TagBuilder... newTags) {
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
    
    
    public InstanceTypeBuilder timeZone(TimeZone newTimeZone) {
        timeZone = newTimeZone;
        return this;
    }
    
    public InstanceTypeBuilder timeZone(TimeZoneBuilder newTimeZone) {
        if (newTimeZone == null) {
            timeZone = null;
        }
        else {
            timeZone = newTimeZone.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder tpmEnabled(boolean newTpmEnabled) {
        tpmEnabled = Boolean.valueOf(newTpmEnabled);
        return this;
    }
    
    public InstanceTypeBuilder tpmEnabled(Boolean newTpmEnabled) {
        tpmEnabled = newTpmEnabled;
        return this;
    }
    
    
    public InstanceTypeBuilder tunnelMigration(boolean newTunnelMigration) {
        tunnelMigration = Boolean.valueOf(newTunnelMigration);
        return this;
    }
    
    public InstanceTypeBuilder tunnelMigration(Boolean newTunnelMigration) {
        tunnelMigration = newTunnelMigration;
        return this;
    }
    
    
    public InstanceTypeBuilder type(VmType newType) {
        type = newType;
        return this;
    }
    
    
    public InstanceTypeBuilder usb(Usb newUsb) {
        usb = newUsb;
        return this;
    }
    
    public InstanceTypeBuilder usb(UsbBuilder newUsb) {
        if (newUsb == null) {
            usb = null;
        }
        else {
            usb = newUsb.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder version(TemplateVersion newVersion) {
        version = newVersion;
        return this;
    }
    
    public InstanceTypeBuilder version(TemplateVersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder virtioScsi(VirtioScsi newVirtioScsi) {
        virtioScsi = newVirtioScsi;
        return this;
    }
    
    public InstanceTypeBuilder virtioScsi(VirtioScsiBuilder newVirtioScsi) {
        if (newVirtioScsi == null) {
            virtioScsi = null;
        }
        else {
            virtioScsi = newVirtioScsi.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder virtioScsiMultiQueues(int newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = BigInteger.valueOf((long) newVirtioScsiMultiQueues);
        return this;
    }
    
    public InstanceTypeBuilder virtioScsiMultiQueues(Integer newVirtioScsiMultiQueues) {
        if (newVirtioScsiMultiQueues == null) {
            virtioScsiMultiQueues = null;
        }
        else {
            virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues.longValue());
        }
        return this;
    }
    
    public InstanceTypeBuilder virtioScsiMultiQueues(long newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues);
        return this;
    }
    
    public InstanceTypeBuilder virtioScsiMultiQueues(Long newVirtioScsiMultiQueues) {
        if (newVirtioScsiMultiQueues == null) {
            virtioScsiMultiQueues = null;
        }
        else {
            virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues.longValue());
        }
        return this;
    }
    
    public InstanceTypeBuilder virtioScsiMultiQueues(BigInteger newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = newVirtioScsiMultiQueues;
        return this;
    }
    
    
    public InstanceTypeBuilder virtioScsiMultiQueuesEnabled(boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = Boolean.valueOf(newVirtioScsiMultiQueuesEnabled);
        return this;
    }
    
    public InstanceTypeBuilder virtioScsiMultiQueuesEnabled(Boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = newVirtioScsiMultiQueuesEnabled;
        return this;
    }
    
    
    public InstanceTypeBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public InstanceTypeBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public InstanceTypeBuilder watchdogs(List<Watchdog> newWatchdogs) {
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
    
    public InstanceTypeBuilder watchdogs(Watchdog... newWatchdogs) {
        if (newWatchdogs != null) {
            if (watchdogs == null) {
                watchdogs = new ArrayList<>(newWatchdogs.length);
            }
            Collections.addAll(watchdogs, newWatchdogs);
        }
        return this;
    }
    
    public InstanceTypeBuilder watchdogs(WatchdogBuilder... newWatchdogs) {
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
    
    
    public InstanceType build() {
        InstanceTypeContainer container = new InstanceTypeContainer();
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
        container.deleteProtected(deleteProtected);
        container.description(description);
        container.diskAttachments(diskAttachments);
        container.display(display);
        container.domain(domain);
        container.graphicsConsoles(graphicsConsoles);
        container.highAvailability(highAvailability);
        container.href(href);
        container.id(id);
        container.initialization(initialization);
        container.io(io);
        container.largeIcon(largeIcon);
        container.lease(lease);
        container.memory(memory);
        container.memoryPolicy(memoryPolicy);
        container.migration(migration);
        container.migrationDowntime(migrationDowntime);
        container.multiQueuesEnabled(multiQueuesEnabled);
        container.name(name);
        container.nics(nics);
        container.origin(origin);
        container.os(os);
        container.permissions(permissions);
        container.placementPolicy(placementPolicy);
        container.quota(quota);
        container.rngDevice(rngDevice);
        container.serialNumber(serialNumber);
        container.smallIcon(smallIcon);
        container.soundcardEnabled(soundcardEnabled);
        container.sso(sso);
        container.startPaused(startPaused);
        container.stateless(stateless);
        container.status(status);
        container.storageDomain(storageDomain);
        container.storageErrorResumeBehaviour(storageErrorResumeBehaviour);
        container.tags(tags);
        container.timeZone(timeZone);
        container.tpmEnabled(tpmEnabled);
        container.tunnelMigration(tunnelMigration);
        container.type(type);
        container.usb(usb);
        container.version(version);
        container.virtioScsi(virtioScsi);
        container.virtioScsiMultiQueues(virtioScsiMultiQueues);
        container.virtioScsiMultiQueuesEnabled(virtioScsiMultiQueuesEnabled);
        container.vm(vm);
        container.watchdogs(watchdogs);
        return container;
    }
}
