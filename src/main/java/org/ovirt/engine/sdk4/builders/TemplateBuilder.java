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
import org.ovirt.engine.sdk4.internal.containers.TemplateContainer;
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
import org.ovirt.engine.sdk4.types.Template;
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

public class TemplateBuilder {
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
    
    public TemplateBuilder autoPinningPolicy(AutoPinningPolicy newAutoPinningPolicy) {
        autoPinningPolicy = newAutoPinningPolicy;
        return this;
    }
    
    
    public TemplateBuilder bios(Bios newBios) {
        bios = newBios;
        return this;
    }
    
    public TemplateBuilder bios(BiosBuilder newBios) {
        if (newBios == null) {
            bios = null;
        }
        else {
            bios = newBios.build();
        }
        return this;
    }
    
    
    public TemplateBuilder cdroms(List<Cdrom> newCdroms) {
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
    
    public TemplateBuilder cdroms(Cdrom... newCdroms) {
        if (newCdroms != null) {
            if (cdroms == null) {
                cdroms = new ArrayList<>(newCdroms.length);
            }
            Collections.addAll(cdroms, newCdroms);
        }
        return this;
    }
    
    public TemplateBuilder cdroms(CdromBuilder... newCdroms) {
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
    
    
    public TemplateBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public TemplateBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public TemplateBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public TemplateBuilder console(Console newConsole) {
        console = newConsole;
        return this;
    }
    
    public TemplateBuilder console(ConsoleBuilder newConsole) {
        if (newConsole == null) {
            console = null;
        }
        else {
            console = newConsole.build();
        }
        return this;
    }
    
    
    public TemplateBuilder cpu(Cpu newCpu) {
        cpu = newCpu;
        return this;
    }
    
    public TemplateBuilder cpu(CpuBuilder newCpu) {
        if (newCpu == null) {
            cpu = null;
        }
        else {
            cpu = newCpu.build();
        }
        return this;
    }
    
    
    public TemplateBuilder cpuProfile(CpuProfile newCpuProfile) {
        cpuProfile = newCpuProfile;
        return this;
    }
    
    public TemplateBuilder cpuProfile(CpuProfileBuilder newCpuProfile) {
        if (newCpuProfile == null) {
            cpuProfile = null;
        }
        else {
            cpuProfile = newCpuProfile.build();
        }
        return this;
    }
    
    
    public TemplateBuilder cpuShares(int newCpuShares) {
        cpuShares = BigInteger.valueOf((long) newCpuShares);
        return this;
    }
    
    public TemplateBuilder cpuShares(Integer newCpuShares) {
        if (newCpuShares == null) {
            cpuShares = null;
        }
        else {
            cpuShares = BigInteger.valueOf(newCpuShares.longValue());
        }
        return this;
    }
    
    public TemplateBuilder cpuShares(long newCpuShares) {
        cpuShares = BigInteger.valueOf(newCpuShares);
        return this;
    }
    
    public TemplateBuilder cpuShares(Long newCpuShares) {
        if (newCpuShares == null) {
            cpuShares = null;
        }
        else {
            cpuShares = BigInteger.valueOf(newCpuShares.longValue());
        }
        return this;
    }
    
    public TemplateBuilder cpuShares(BigInteger newCpuShares) {
        cpuShares = newCpuShares;
        return this;
    }
    
    
    public TemplateBuilder creationTime(Date newCreationTime) {
        if (newCreationTime == null) {
            creationTime = null;
        }
        else {
            creationTime = new Date(newCreationTime.getTime());
        }
        return this;
    }
    
    
    public TemplateBuilder customCompatibilityVersion(Version newCustomCompatibilityVersion) {
        customCompatibilityVersion = newCustomCompatibilityVersion;
        return this;
    }
    
    public TemplateBuilder customCompatibilityVersion(VersionBuilder newCustomCompatibilityVersion) {
        if (newCustomCompatibilityVersion == null) {
            customCompatibilityVersion = null;
        }
        else {
            customCompatibilityVersion = newCustomCompatibilityVersion.build();
        }
        return this;
    }
    
    
    public TemplateBuilder customCpuModel(String newCustomCpuModel) {
        customCpuModel = newCustomCpuModel;
        return this;
    }
    
    
    public TemplateBuilder customEmulatedMachine(String newCustomEmulatedMachine) {
        customEmulatedMachine = newCustomEmulatedMachine;
        return this;
    }
    
    
    public TemplateBuilder customProperties(List<CustomProperty> newCustomProperties) {
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
    
    public TemplateBuilder customProperties(CustomProperty... newCustomProperties) {
        if (newCustomProperties != null) {
            if (customProperties == null) {
                customProperties = new ArrayList<>(newCustomProperties.length);
            }
            Collections.addAll(customProperties, newCustomProperties);
        }
        return this;
    }
    
    public TemplateBuilder customProperties(CustomPropertyBuilder... newCustomProperties) {
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
    
    
    public TemplateBuilder deleteProtected(boolean newDeleteProtected) {
        deleteProtected = Boolean.valueOf(newDeleteProtected);
        return this;
    }
    
    public TemplateBuilder deleteProtected(Boolean newDeleteProtected) {
        deleteProtected = newDeleteProtected;
        return this;
    }
    
    
    public TemplateBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public TemplateBuilder diskAttachments(List<DiskAttachment> newDiskAttachments) {
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
    
    public TemplateBuilder diskAttachments(DiskAttachment... newDiskAttachments) {
        if (newDiskAttachments != null) {
            if (diskAttachments == null) {
                diskAttachments = new ArrayList<>(newDiskAttachments.length);
            }
            Collections.addAll(diskAttachments, newDiskAttachments);
        }
        return this;
    }
    
    public TemplateBuilder diskAttachments(DiskAttachmentBuilder... newDiskAttachments) {
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
    
    
    public TemplateBuilder display(Display newDisplay) {
        display = newDisplay;
        return this;
    }
    
    public TemplateBuilder display(DisplayBuilder newDisplay) {
        if (newDisplay == null) {
            display = null;
        }
        else {
            display = newDisplay.build();
        }
        return this;
    }
    
    
    public TemplateBuilder domain(Domain newDomain) {
        domain = newDomain;
        return this;
    }
    
    public TemplateBuilder domain(DomainBuilder newDomain) {
        if (newDomain == null) {
            domain = null;
        }
        else {
            domain = newDomain.build();
        }
        return this;
    }
    
    
    public TemplateBuilder graphicsConsoles(List<GraphicsConsole> newGraphicsConsoles) {
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
    
    public TemplateBuilder graphicsConsoles(GraphicsConsole... newGraphicsConsoles) {
        if (newGraphicsConsoles != null) {
            if (graphicsConsoles == null) {
                graphicsConsoles = new ArrayList<>(newGraphicsConsoles.length);
            }
            Collections.addAll(graphicsConsoles, newGraphicsConsoles);
        }
        return this;
    }
    
    public TemplateBuilder graphicsConsoles(GraphicsConsoleBuilder... newGraphicsConsoles) {
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
    
    
    public TemplateBuilder highAvailability(HighAvailability newHighAvailability) {
        highAvailability = newHighAvailability;
        return this;
    }
    
    public TemplateBuilder highAvailability(HighAvailabilityBuilder newHighAvailability) {
        if (newHighAvailability == null) {
            highAvailability = null;
        }
        else {
            highAvailability = newHighAvailability.build();
        }
        return this;
    }
    
    
    public TemplateBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public TemplateBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public TemplateBuilder initialization(Initialization newInitialization) {
        initialization = newInitialization;
        return this;
    }
    
    public TemplateBuilder initialization(InitializationBuilder newInitialization) {
        if (newInitialization == null) {
            initialization = null;
        }
        else {
            initialization = newInitialization.build();
        }
        return this;
    }
    
    
    public TemplateBuilder io(Io newIo) {
        io = newIo;
        return this;
    }
    
    public TemplateBuilder io(IoBuilder newIo) {
        if (newIo == null) {
            io = null;
        }
        else {
            io = newIo.build();
        }
        return this;
    }
    
    
    public TemplateBuilder largeIcon(Icon newLargeIcon) {
        largeIcon = newLargeIcon;
        return this;
    }
    
    public TemplateBuilder largeIcon(IconBuilder newLargeIcon) {
        if (newLargeIcon == null) {
            largeIcon = null;
        }
        else {
            largeIcon = newLargeIcon.build();
        }
        return this;
    }
    
    
    public TemplateBuilder lease(StorageDomainLease newLease) {
        lease = newLease;
        return this;
    }
    
    public TemplateBuilder lease(StorageDomainLeaseBuilder newLease) {
        if (newLease == null) {
            lease = null;
        }
        else {
            lease = newLease.build();
        }
        return this;
    }
    
    
    public TemplateBuilder memory(int newMemory) {
        memory = BigInteger.valueOf((long) newMemory);
        return this;
    }
    
    public TemplateBuilder memory(Integer newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public TemplateBuilder memory(long newMemory) {
        memory = BigInteger.valueOf(newMemory);
        return this;
    }
    
    public TemplateBuilder memory(Long newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public TemplateBuilder memory(BigInteger newMemory) {
        memory = newMemory;
        return this;
    }
    
    
    public TemplateBuilder memoryPolicy(MemoryPolicy newMemoryPolicy) {
        memoryPolicy = newMemoryPolicy;
        return this;
    }
    
    public TemplateBuilder memoryPolicy(MemoryPolicyBuilder newMemoryPolicy) {
        if (newMemoryPolicy == null) {
            memoryPolicy = null;
        }
        else {
            memoryPolicy = newMemoryPolicy.build();
        }
        return this;
    }
    
    
    public TemplateBuilder migration(MigrationOptions newMigration) {
        migration = newMigration;
        return this;
    }
    
    public TemplateBuilder migration(MigrationOptionsBuilder newMigration) {
        if (newMigration == null) {
            migration = null;
        }
        else {
            migration = newMigration.build();
        }
        return this;
    }
    
    
    public TemplateBuilder migrationDowntime(int newMigrationDowntime) {
        migrationDowntime = BigInteger.valueOf((long) newMigrationDowntime);
        return this;
    }
    
    public TemplateBuilder migrationDowntime(Integer newMigrationDowntime) {
        if (newMigrationDowntime == null) {
            migrationDowntime = null;
        }
        else {
            migrationDowntime = BigInteger.valueOf(newMigrationDowntime.longValue());
        }
        return this;
    }
    
    public TemplateBuilder migrationDowntime(long newMigrationDowntime) {
        migrationDowntime = BigInteger.valueOf(newMigrationDowntime);
        return this;
    }
    
    public TemplateBuilder migrationDowntime(Long newMigrationDowntime) {
        if (newMigrationDowntime == null) {
            migrationDowntime = null;
        }
        else {
            migrationDowntime = BigInteger.valueOf(newMigrationDowntime.longValue());
        }
        return this;
    }
    
    public TemplateBuilder migrationDowntime(BigInteger newMigrationDowntime) {
        migrationDowntime = newMigrationDowntime;
        return this;
    }
    
    
    public TemplateBuilder multiQueuesEnabled(boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = Boolean.valueOf(newMultiQueuesEnabled);
        return this;
    }
    
    public TemplateBuilder multiQueuesEnabled(Boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = newMultiQueuesEnabled;
        return this;
    }
    
    
    public TemplateBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public TemplateBuilder nics(List<Nic> newNics) {
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
    
    public TemplateBuilder nics(Nic... newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics.length);
            }
            Collections.addAll(nics, newNics);
        }
        return this;
    }
    
    public TemplateBuilder nics(NicBuilder... newNics) {
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
    
    
    public TemplateBuilder origin(String newOrigin) {
        origin = newOrigin;
        return this;
    }
    
    
    public TemplateBuilder os(OperatingSystem newOs) {
        os = newOs;
        return this;
    }
    
    public TemplateBuilder os(OperatingSystemBuilder newOs) {
        if (newOs == null) {
            os = null;
        }
        else {
            os = newOs.build();
        }
        return this;
    }
    
    
    public TemplateBuilder permissions(List<Permission> newPermissions) {
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
    
    public TemplateBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public TemplateBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public TemplateBuilder placementPolicy(VmPlacementPolicy newPlacementPolicy) {
        placementPolicy = newPlacementPolicy;
        return this;
    }
    
    public TemplateBuilder placementPolicy(VmPlacementPolicyBuilder newPlacementPolicy) {
        if (newPlacementPolicy == null) {
            placementPolicy = null;
        }
        else {
            placementPolicy = newPlacementPolicy.build();
        }
        return this;
    }
    
    
    public TemplateBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public TemplateBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public TemplateBuilder rngDevice(RngDevice newRngDevice) {
        rngDevice = newRngDevice;
        return this;
    }
    
    public TemplateBuilder rngDevice(RngDeviceBuilder newRngDevice) {
        if (newRngDevice == null) {
            rngDevice = null;
        }
        else {
            rngDevice = newRngDevice.build();
        }
        return this;
    }
    
    
    public TemplateBuilder serialNumber(SerialNumber newSerialNumber) {
        serialNumber = newSerialNumber;
        return this;
    }
    
    public TemplateBuilder serialNumber(SerialNumberBuilder newSerialNumber) {
        if (newSerialNumber == null) {
            serialNumber = null;
        }
        else {
            serialNumber = newSerialNumber.build();
        }
        return this;
    }
    
    
    public TemplateBuilder smallIcon(Icon newSmallIcon) {
        smallIcon = newSmallIcon;
        return this;
    }
    
    public TemplateBuilder smallIcon(IconBuilder newSmallIcon) {
        if (newSmallIcon == null) {
            smallIcon = null;
        }
        else {
            smallIcon = newSmallIcon.build();
        }
        return this;
    }
    
    
    public TemplateBuilder soundcardEnabled(boolean newSoundcardEnabled) {
        soundcardEnabled = Boolean.valueOf(newSoundcardEnabled);
        return this;
    }
    
    public TemplateBuilder soundcardEnabled(Boolean newSoundcardEnabled) {
        soundcardEnabled = newSoundcardEnabled;
        return this;
    }
    
    
    public TemplateBuilder sso(Sso newSso) {
        sso = newSso;
        return this;
    }
    
    public TemplateBuilder sso(SsoBuilder newSso) {
        if (newSso == null) {
            sso = null;
        }
        else {
            sso = newSso.build();
        }
        return this;
    }
    
    
    public TemplateBuilder startPaused(boolean newStartPaused) {
        startPaused = Boolean.valueOf(newStartPaused);
        return this;
    }
    
    public TemplateBuilder startPaused(Boolean newStartPaused) {
        startPaused = newStartPaused;
        return this;
    }
    
    
    public TemplateBuilder stateless(boolean newStateless) {
        stateless = Boolean.valueOf(newStateless);
        return this;
    }
    
    public TemplateBuilder stateless(Boolean newStateless) {
        stateless = newStateless;
        return this;
    }
    
    
    public TemplateBuilder status(TemplateStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public TemplateBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public TemplateBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public TemplateBuilder storageErrorResumeBehaviour(VmStorageErrorResumeBehaviour newStorageErrorResumeBehaviour) {
        storageErrorResumeBehaviour = newStorageErrorResumeBehaviour;
        return this;
    }
    
    
    public TemplateBuilder tags(List<Tag> newTags) {
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
    
    public TemplateBuilder tags(Tag... newTags) {
        if (newTags != null) {
            if (tags == null) {
                tags = new ArrayList<>(newTags.length);
            }
            Collections.addAll(tags, newTags);
        }
        return this;
    }
    
    public TemplateBuilder tags(TagBuilder... newTags) {
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
    
    
    public TemplateBuilder timeZone(TimeZone newTimeZone) {
        timeZone = newTimeZone;
        return this;
    }
    
    public TemplateBuilder timeZone(TimeZoneBuilder newTimeZone) {
        if (newTimeZone == null) {
            timeZone = null;
        }
        else {
            timeZone = newTimeZone.build();
        }
        return this;
    }
    
    
    public TemplateBuilder tpmEnabled(boolean newTpmEnabled) {
        tpmEnabled = Boolean.valueOf(newTpmEnabled);
        return this;
    }
    
    public TemplateBuilder tpmEnabled(Boolean newTpmEnabled) {
        tpmEnabled = newTpmEnabled;
        return this;
    }
    
    
    public TemplateBuilder tunnelMigration(boolean newTunnelMigration) {
        tunnelMigration = Boolean.valueOf(newTunnelMigration);
        return this;
    }
    
    public TemplateBuilder tunnelMigration(Boolean newTunnelMigration) {
        tunnelMigration = newTunnelMigration;
        return this;
    }
    
    
    public TemplateBuilder type(VmType newType) {
        type = newType;
        return this;
    }
    
    
    public TemplateBuilder usb(Usb newUsb) {
        usb = newUsb;
        return this;
    }
    
    public TemplateBuilder usb(UsbBuilder newUsb) {
        if (newUsb == null) {
            usb = null;
        }
        else {
            usb = newUsb.build();
        }
        return this;
    }
    
    
    public TemplateBuilder version(TemplateVersion newVersion) {
        version = newVersion;
        return this;
    }
    
    public TemplateBuilder version(TemplateVersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public TemplateBuilder virtioScsi(VirtioScsi newVirtioScsi) {
        virtioScsi = newVirtioScsi;
        return this;
    }
    
    public TemplateBuilder virtioScsi(VirtioScsiBuilder newVirtioScsi) {
        if (newVirtioScsi == null) {
            virtioScsi = null;
        }
        else {
            virtioScsi = newVirtioScsi.build();
        }
        return this;
    }
    
    
    public TemplateBuilder virtioScsiMultiQueues(int newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = BigInteger.valueOf((long) newVirtioScsiMultiQueues);
        return this;
    }
    
    public TemplateBuilder virtioScsiMultiQueues(Integer newVirtioScsiMultiQueues) {
        if (newVirtioScsiMultiQueues == null) {
            virtioScsiMultiQueues = null;
        }
        else {
            virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues.longValue());
        }
        return this;
    }
    
    public TemplateBuilder virtioScsiMultiQueues(long newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues);
        return this;
    }
    
    public TemplateBuilder virtioScsiMultiQueues(Long newVirtioScsiMultiQueues) {
        if (newVirtioScsiMultiQueues == null) {
            virtioScsiMultiQueues = null;
        }
        else {
            virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues.longValue());
        }
        return this;
    }
    
    public TemplateBuilder virtioScsiMultiQueues(BigInteger newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = newVirtioScsiMultiQueues;
        return this;
    }
    
    
    public TemplateBuilder virtioScsiMultiQueuesEnabled(boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = Boolean.valueOf(newVirtioScsiMultiQueuesEnabled);
        return this;
    }
    
    public TemplateBuilder virtioScsiMultiQueuesEnabled(Boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = newVirtioScsiMultiQueuesEnabled;
        return this;
    }
    
    
    public TemplateBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public TemplateBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public TemplateBuilder watchdogs(List<Watchdog> newWatchdogs) {
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
    
    public TemplateBuilder watchdogs(Watchdog... newWatchdogs) {
        if (newWatchdogs != null) {
            if (watchdogs == null) {
                watchdogs = new ArrayList<>(newWatchdogs.length);
            }
            Collections.addAll(watchdogs, newWatchdogs);
        }
        return this;
    }
    
    public TemplateBuilder watchdogs(WatchdogBuilder... newWatchdogs) {
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
    
    
    public Template build() {
        TemplateContainer container = new TemplateContainer();
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
