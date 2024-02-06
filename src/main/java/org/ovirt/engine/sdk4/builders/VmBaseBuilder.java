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
import org.ovirt.engine.sdk4.internal.containers.VmBaseContainer;
import org.ovirt.engine.sdk4.types.AutoPinningPolicy;
import org.ovirt.engine.sdk4.types.Bios;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Console;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.CustomProperty;
import org.ovirt.engine.sdk4.types.Display;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.HighAvailability;
import org.ovirt.engine.sdk4.types.Icon;
import org.ovirt.engine.sdk4.types.Initialization;
import org.ovirt.engine.sdk4.types.Io;
import org.ovirt.engine.sdk4.types.MemoryPolicy;
import org.ovirt.engine.sdk4.types.MigrationOptions;
import org.ovirt.engine.sdk4.types.OperatingSystem;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.RngDevice;
import org.ovirt.engine.sdk4.types.SerialNumber;
import org.ovirt.engine.sdk4.types.Sso;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageDomainLease;
import org.ovirt.engine.sdk4.types.TimeZone;
import org.ovirt.engine.sdk4.types.Usb;
import org.ovirt.engine.sdk4.types.Version;
import org.ovirt.engine.sdk4.types.VirtioScsi;
import org.ovirt.engine.sdk4.types.VmBase;
import org.ovirt.engine.sdk4.types.VmPlacementPolicy;
import org.ovirt.engine.sdk4.types.VmStorageErrorResumeBehaviour;
import org.ovirt.engine.sdk4.types.VmType;

public class VmBaseBuilder {
    private AutoPinningPolicy autoPinningPolicy;
    private Bios bios;
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
    private Display display;
    private Domain domain;
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
    private String origin;
    private OperatingSystem os;
    private VmPlacementPolicy placementPolicy;
    private Quota quota;
    private RngDevice rngDevice;
    private SerialNumber serialNumber;
    private Icon smallIcon;
    private Boolean soundcardEnabled;
    private Sso sso;
    private Boolean startPaused;
    private Boolean stateless;
    private StorageDomain storageDomain;
    private VmStorageErrorResumeBehaviour storageErrorResumeBehaviour;
    private TimeZone timeZone;
    private Boolean tpmEnabled;
    private Boolean tunnelMigration;
    private VmType type;
    private Usb usb;
    private VirtioScsi virtioScsi;
    private BigInteger virtioScsiMultiQueues;
    private Boolean virtioScsiMultiQueuesEnabled;
    
    public VmBaseBuilder autoPinningPolicy(AutoPinningPolicy newAutoPinningPolicy) {
        autoPinningPolicy = newAutoPinningPolicy;
        return this;
    }
    
    
    public VmBaseBuilder bios(Bios newBios) {
        bios = newBios;
        return this;
    }
    
    public VmBaseBuilder bios(BiosBuilder newBios) {
        if (newBios == null) {
            bios = null;
        }
        else {
            bios = newBios.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public VmBaseBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public VmBaseBuilder console(Console newConsole) {
        console = newConsole;
        return this;
    }
    
    public VmBaseBuilder console(ConsoleBuilder newConsole) {
        if (newConsole == null) {
            console = null;
        }
        else {
            console = newConsole.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder cpu(Cpu newCpu) {
        cpu = newCpu;
        return this;
    }
    
    public VmBaseBuilder cpu(CpuBuilder newCpu) {
        if (newCpu == null) {
            cpu = null;
        }
        else {
            cpu = newCpu.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder cpuProfile(CpuProfile newCpuProfile) {
        cpuProfile = newCpuProfile;
        return this;
    }
    
    public VmBaseBuilder cpuProfile(CpuProfileBuilder newCpuProfile) {
        if (newCpuProfile == null) {
            cpuProfile = null;
        }
        else {
            cpuProfile = newCpuProfile.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder cpuShares(int newCpuShares) {
        cpuShares = BigInteger.valueOf((long) newCpuShares);
        return this;
    }
    
    public VmBaseBuilder cpuShares(Integer newCpuShares) {
        if (newCpuShares == null) {
            cpuShares = null;
        }
        else {
            cpuShares = BigInteger.valueOf(newCpuShares.longValue());
        }
        return this;
    }
    
    public VmBaseBuilder cpuShares(long newCpuShares) {
        cpuShares = BigInteger.valueOf(newCpuShares);
        return this;
    }
    
    public VmBaseBuilder cpuShares(Long newCpuShares) {
        if (newCpuShares == null) {
            cpuShares = null;
        }
        else {
            cpuShares = BigInteger.valueOf(newCpuShares.longValue());
        }
        return this;
    }
    
    public VmBaseBuilder cpuShares(BigInteger newCpuShares) {
        cpuShares = newCpuShares;
        return this;
    }
    
    
    public VmBaseBuilder creationTime(Date newCreationTime) {
        if (newCreationTime == null) {
            creationTime = null;
        }
        else {
            creationTime = new Date(newCreationTime.getTime());
        }
        return this;
    }
    
    
    public VmBaseBuilder customCompatibilityVersion(Version newCustomCompatibilityVersion) {
        customCompatibilityVersion = newCustomCompatibilityVersion;
        return this;
    }
    
    public VmBaseBuilder customCompatibilityVersion(VersionBuilder newCustomCompatibilityVersion) {
        if (newCustomCompatibilityVersion == null) {
            customCompatibilityVersion = null;
        }
        else {
            customCompatibilityVersion = newCustomCompatibilityVersion.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder customCpuModel(String newCustomCpuModel) {
        customCpuModel = newCustomCpuModel;
        return this;
    }
    
    
    public VmBaseBuilder customEmulatedMachine(String newCustomEmulatedMachine) {
        customEmulatedMachine = newCustomEmulatedMachine;
        return this;
    }
    
    
    public VmBaseBuilder customProperties(List<CustomProperty> newCustomProperties) {
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
    
    public VmBaseBuilder customProperties(CustomProperty... newCustomProperties) {
        if (newCustomProperties != null) {
            if (customProperties == null) {
                customProperties = new ArrayList<>(newCustomProperties.length);
            }
            Collections.addAll(customProperties, newCustomProperties);
        }
        return this;
    }
    
    public VmBaseBuilder customProperties(CustomPropertyBuilder... newCustomProperties) {
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
    
    
    public VmBaseBuilder deleteProtected(boolean newDeleteProtected) {
        deleteProtected = Boolean.valueOf(newDeleteProtected);
        return this;
    }
    
    public VmBaseBuilder deleteProtected(Boolean newDeleteProtected) {
        deleteProtected = newDeleteProtected;
        return this;
    }
    
    
    public VmBaseBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public VmBaseBuilder display(Display newDisplay) {
        display = newDisplay;
        return this;
    }
    
    public VmBaseBuilder display(DisplayBuilder newDisplay) {
        if (newDisplay == null) {
            display = null;
        }
        else {
            display = newDisplay.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder domain(Domain newDomain) {
        domain = newDomain;
        return this;
    }
    
    public VmBaseBuilder domain(DomainBuilder newDomain) {
        if (newDomain == null) {
            domain = null;
        }
        else {
            domain = newDomain.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder highAvailability(HighAvailability newHighAvailability) {
        highAvailability = newHighAvailability;
        return this;
    }
    
    public VmBaseBuilder highAvailability(HighAvailabilityBuilder newHighAvailability) {
        if (newHighAvailability == null) {
            highAvailability = null;
        }
        else {
            highAvailability = newHighAvailability.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public VmBaseBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public VmBaseBuilder initialization(Initialization newInitialization) {
        initialization = newInitialization;
        return this;
    }
    
    public VmBaseBuilder initialization(InitializationBuilder newInitialization) {
        if (newInitialization == null) {
            initialization = null;
        }
        else {
            initialization = newInitialization.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder io(Io newIo) {
        io = newIo;
        return this;
    }
    
    public VmBaseBuilder io(IoBuilder newIo) {
        if (newIo == null) {
            io = null;
        }
        else {
            io = newIo.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder largeIcon(Icon newLargeIcon) {
        largeIcon = newLargeIcon;
        return this;
    }
    
    public VmBaseBuilder largeIcon(IconBuilder newLargeIcon) {
        if (newLargeIcon == null) {
            largeIcon = null;
        }
        else {
            largeIcon = newLargeIcon.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder lease(StorageDomainLease newLease) {
        lease = newLease;
        return this;
    }
    
    public VmBaseBuilder lease(StorageDomainLeaseBuilder newLease) {
        if (newLease == null) {
            lease = null;
        }
        else {
            lease = newLease.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder memory(int newMemory) {
        memory = BigInteger.valueOf((long) newMemory);
        return this;
    }
    
    public VmBaseBuilder memory(Integer newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public VmBaseBuilder memory(long newMemory) {
        memory = BigInteger.valueOf(newMemory);
        return this;
    }
    
    public VmBaseBuilder memory(Long newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public VmBaseBuilder memory(BigInteger newMemory) {
        memory = newMemory;
        return this;
    }
    
    
    public VmBaseBuilder memoryPolicy(MemoryPolicy newMemoryPolicy) {
        memoryPolicy = newMemoryPolicy;
        return this;
    }
    
    public VmBaseBuilder memoryPolicy(MemoryPolicyBuilder newMemoryPolicy) {
        if (newMemoryPolicy == null) {
            memoryPolicy = null;
        }
        else {
            memoryPolicy = newMemoryPolicy.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder migration(MigrationOptions newMigration) {
        migration = newMigration;
        return this;
    }
    
    public VmBaseBuilder migration(MigrationOptionsBuilder newMigration) {
        if (newMigration == null) {
            migration = null;
        }
        else {
            migration = newMigration.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder migrationDowntime(int newMigrationDowntime) {
        migrationDowntime = BigInteger.valueOf((long) newMigrationDowntime);
        return this;
    }
    
    public VmBaseBuilder migrationDowntime(Integer newMigrationDowntime) {
        if (newMigrationDowntime == null) {
            migrationDowntime = null;
        }
        else {
            migrationDowntime = BigInteger.valueOf(newMigrationDowntime.longValue());
        }
        return this;
    }
    
    public VmBaseBuilder migrationDowntime(long newMigrationDowntime) {
        migrationDowntime = BigInteger.valueOf(newMigrationDowntime);
        return this;
    }
    
    public VmBaseBuilder migrationDowntime(Long newMigrationDowntime) {
        if (newMigrationDowntime == null) {
            migrationDowntime = null;
        }
        else {
            migrationDowntime = BigInteger.valueOf(newMigrationDowntime.longValue());
        }
        return this;
    }
    
    public VmBaseBuilder migrationDowntime(BigInteger newMigrationDowntime) {
        migrationDowntime = newMigrationDowntime;
        return this;
    }
    
    
    public VmBaseBuilder multiQueuesEnabled(boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = Boolean.valueOf(newMultiQueuesEnabled);
        return this;
    }
    
    public VmBaseBuilder multiQueuesEnabled(Boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = newMultiQueuesEnabled;
        return this;
    }
    
    
    public VmBaseBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public VmBaseBuilder origin(String newOrigin) {
        origin = newOrigin;
        return this;
    }
    
    
    public VmBaseBuilder os(OperatingSystem newOs) {
        os = newOs;
        return this;
    }
    
    public VmBaseBuilder os(OperatingSystemBuilder newOs) {
        if (newOs == null) {
            os = null;
        }
        else {
            os = newOs.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder placementPolicy(VmPlacementPolicy newPlacementPolicy) {
        placementPolicy = newPlacementPolicy;
        return this;
    }
    
    public VmBaseBuilder placementPolicy(VmPlacementPolicyBuilder newPlacementPolicy) {
        if (newPlacementPolicy == null) {
            placementPolicy = null;
        }
        else {
            placementPolicy = newPlacementPolicy.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public VmBaseBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder rngDevice(RngDevice newRngDevice) {
        rngDevice = newRngDevice;
        return this;
    }
    
    public VmBaseBuilder rngDevice(RngDeviceBuilder newRngDevice) {
        if (newRngDevice == null) {
            rngDevice = null;
        }
        else {
            rngDevice = newRngDevice.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder serialNumber(SerialNumber newSerialNumber) {
        serialNumber = newSerialNumber;
        return this;
    }
    
    public VmBaseBuilder serialNumber(SerialNumberBuilder newSerialNumber) {
        if (newSerialNumber == null) {
            serialNumber = null;
        }
        else {
            serialNumber = newSerialNumber.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder smallIcon(Icon newSmallIcon) {
        smallIcon = newSmallIcon;
        return this;
    }
    
    public VmBaseBuilder smallIcon(IconBuilder newSmallIcon) {
        if (newSmallIcon == null) {
            smallIcon = null;
        }
        else {
            smallIcon = newSmallIcon.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder soundcardEnabled(boolean newSoundcardEnabled) {
        soundcardEnabled = Boolean.valueOf(newSoundcardEnabled);
        return this;
    }
    
    public VmBaseBuilder soundcardEnabled(Boolean newSoundcardEnabled) {
        soundcardEnabled = newSoundcardEnabled;
        return this;
    }
    
    
    public VmBaseBuilder sso(Sso newSso) {
        sso = newSso;
        return this;
    }
    
    public VmBaseBuilder sso(SsoBuilder newSso) {
        if (newSso == null) {
            sso = null;
        }
        else {
            sso = newSso.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder startPaused(boolean newStartPaused) {
        startPaused = Boolean.valueOf(newStartPaused);
        return this;
    }
    
    public VmBaseBuilder startPaused(Boolean newStartPaused) {
        startPaused = newStartPaused;
        return this;
    }
    
    
    public VmBaseBuilder stateless(boolean newStateless) {
        stateless = Boolean.valueOf(newStateless);
        return this;
    }
    
    public VmBaseBuilder stateless(Boolean newStateless) {
        stateless = newStateless;
        return this;
    }
    
    
    public VmBaseBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public VmBaseBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder storageErrorResumeBehaviour(VmStorageErrorResumeBehaviour newStorageErrorResumeBehaviour) {
        storageErrorResumeBehaviour = newStorageErrorResumeBehaviour;
        return this;
    }
    
    
    public VmBaseBuilder timeZone(TimeZone newTimeZone) {
        timeZone = newTimeZone;
        return this;
    }
    
    public VmBaseBuilder timeZone(TimeZoneBuilder newTimeZone) {
        if (newTimeZone == null) {
            timeZone = null;
        }
        else {
            timeZone = newTimeZone.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder tpmEnabled(boolean newTpmEnabled) {
        tpmEnabled = Boolean.valueOf(newTpmEnabled);
        return this;
    }
    
    public VmBaseBuilder tpmEnabled(Boolean newTpmEnabled) {
        tpmEnabled = newTpmEnabled;
        return this;
    }
    
    
    public VmBaseBuilder tunnelMigration(boolean newTunnelMigration) {
        tunnelMigration = Boolean.valueOf(newTunnelMigration);
        return this;
    }
    
    public VmBaseBuilder tunnelMigration(Boolean newTunnelMigration) {
        tunnelMigration = newTunnelMigration;
        return this;
    }
    
    
    public VmBaseBuilder type(VmType newType) {
        type = newType;
        return this;
    }
    
    
    public VmBaseBuilder usb(Usb newUsb) {
        usb = newUsb;
        return this;
    }
    
    public VmBaseBuilder usb(UsbBuilder newUsb) {
        if (newUsb == null) {
            usb = null;
        }
        else {
            usb = newUsb.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder virtioScsi(VirtioScsi newVirtioScsi) {
        virtioScsi = newVirtioScsi;
        return this;
    }
    
    public VmBaseBuilder virtioScsi(VirtioScsiBuilder newVirtioScsi) {
        if (newVirtioScsi == null) {
            virtioScsi = null;
        }
        else {
            virtioScsi = newVirtioScsi.build();
        }
        return this;
    }
    
    
    public VmBaseBuilder virtioScsiMultiQueues(int newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = BigInteger.valueOf((long) newVirtioScsiMultiQueues);
        return this;
    }
    
    public VmBaseBuilder virtioScsiMultiQueues(Integer newVirtioScsiMultiQueues) {
        if (newVirtioScsiMultiQueues == null) {
            virtioScsiMultiQueues = null;
        }
        else {
            virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues.longValue());
        }
        return this;
    }
    
    public VmBaseBuilder virtioScsiMultiQueues(long newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues);
        return this;
    }
    
    public VmBaseBuilder virtioScsiMultiQueues(Long newVirtioScsiMultiQueues) {
        if (newVirtioScsiMultiQueues == null) {
            virtioScsiMultiQueues = null;
        }
        else {
            virtioScsiMultiQueues = BigInteger.valueOf(newVirtioScsiMultiQueues.longValue());
        }
        return this;
    }
    
    public VmBaseBuilder virtioScsiMultiQueues(BigInteger newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = newVirtioScsiMultiQueues;
        return this;
    }
    
    
    public VmBaseBuilder virtioScsiMultiQueuesEnabled(boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = Boolean.valueOf(newVirtioScsiMultiQueuesEnabled);
        return this;
    }
    
    public VmBaseBuilder virtioScsiMultiQueuesEnabled(Boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = newVirtioScsiMultiQueuesEnabled;
        return this;
    }
    
    
    public VmBase build() {
        VmBaseContainer container = new VmBaseContainer();
        container.autoPinningPolicy(autoPinningPolicy);
        container.bios(bios);
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
        container.display(display);
        container.domain(domain);
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
        container.origin(origin);
        container.os(os);
        container.placementPolicy(placementPolicy);
        container.quota(quota);
        container.rngDevice(rngDevice);
        container.serialNumber(serialNumber);
        container.smallIcon(smallIcon);
        container.soundcardEnabled(soundcardEnabled);
        container.sso(sso);
        container.startPaused(startPaused);
        container.stateless(stateless);
        container.storageDomain(storageDomain);
        container.storageErrorResumeBehaviour(storageErrorResumeBehaviour);
        container.timeZone(timeZone);
        container.tpmEnabled(tpmEnabled);
        container.tunnelMigration(tunnelMigration);
        container.type(type);
        container.usb(usb);
        container.virtioScsi(virtioScsi);
        container.virtioScsiMultiQueues(virtioScsiMultiQueues);
        container.virtioScsiMultiQueuesEnabled(virtioScsiMultiQueuesEnabled);
        return container;
    }
}
