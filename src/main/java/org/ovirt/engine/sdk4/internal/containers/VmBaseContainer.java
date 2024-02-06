/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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

public class VmBaseContainer extends IdentifiedContainer implements VmBase {
    private AutoPinningPolicy autoPinningPolicy;
    private Bios bios;
    private Console console;
    private Cpu cpu;
    private BigInteger cpuShares;
    private Date creationTime;
    private Version customCompatibilityVersion;
    private String customCpuModel;
    private String customEmulatedMachine;
    private List<CustomProperty> customProperties;
    private Boolean deleteProtected;
    private Display display;
    private Domain domain;
    private HighAvailability highAvailability;
    private Initialization initialization;
    private Io io;
    private Icon largeIcon;
    private StorageDomainLease lease;
    private BigInteger memory;
    private MemoryPolicy memoryPolicy;
    private MigrationOptions migration;
    private BigInteger migrationDowntime;
    private Boolean multiQueuesEnabled;
    private String origin;
    private OperatingSystem os;
    private VmPlacementPolicy placementPolicy;
    private RngDevice rngDevice;
    private SerialNumber serialNumber;
    private Icon smallIcon;
    private Boolean soundcardEnabled;
    private Sso sso;
    private Boolean startPaused;
    private Boolean stateless;
    private VmStorageErrorResumeBehaviour storageErrorResumeBehaviour;
    private TimeZone timeZone;
    private Boolean tpmEnabled;
    private Boolean tunnelMigration;
    private VmType type;
    private Usb usb;
    private VirtioScsi virtioScsi;
    private BigInteger virtioScsiMultiQueues;
    private Boolean virtioScsiMultiQueuesEnabled;
    private Cluster cluster;
    private CpuProfile cpuProfile;
    private Quota quota;
    private StorageDomain storageDomain;
    
    public AutoPinningPolicy autoPinningPolicy() {
        return autoPinningPolicy;
    }
    
    public void autoPinningPolicy(AutoPinningPolicy newAutoPinningPolicy) {
        autoPinningPolicy = newAutoPinningPolicy;
    }
    
    public boolean autoPinningPolicyPresent() {
        return autoPinningPolicy != null;
    }
    
    public Bios bios() {
        return bios;
    }
    
    public void bios(Bios newBios) {
        bios = newBios;
    }
    
    public boolean biosPresent() {
        return bios != null;
    }
    
    public Console console() {
        return console;
    }
    
    public void console(Console newConsole) {
        console = newConsole;
    }
    
    public boolean consolePresent() {
        return console != null;
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
    
    public BigInteger cpuShares() {
        return cpuShares;
    }
    
    public Byte cpuSharesAsByte() {
        return asByte("VmBase", "cpuShares", cpuShares);
    }
    
    public Short cpuSharesAsShort() {
        return asShort("VmBase", "cpuShares", cpuShares);
    }
    
    public Integer cpuSharesAsInteger() {
        return asInteger("VmBase", "cpuShares", cpuShares);
    }
    
    public Long cpuSharesAsLong() {
        return asLong("VmBase", "cpuShares", cpuShares);
    }
    
    public void cpuShares(BigInteger newCpuShares) {
        cpuShares = newCpuShares;
    }
    
    public boolean cpuSharesPresent() {
        return cpuShares != null;
    }
    
    public Date creationTime() {
        if (creationTime == null) {
            return null;
        }
        else {
            return new Date(creationTime.getTime());
        }
    }
    
    public void creationTime(Date newCreationTime) {
        if (newCreationTime == null) {
            creationTime = null;
        }
        else {
            creationTime = new Date(newCreationTime.getTime());
        }
    }
    
    public boolean creationTimePresent() {
        return creationTime != null;
    }
    
    public Version customCompatibilityVersion() {
        return customCompatibilityVersion;
    }
    
    public void customCompatibilityVersion(Version newCustomCompatibilityVersion) {
        customCompatibilityVersion = newCustomCompatibilityVersion;
    }
    
    public boolean customCompatibilityVersionPresent() {
        return customCompatibilityVersion != null;
    }
    
    public String customCpuModel() {
        return customCpuModel;
    }
    
    public void customCpuModel(String newCustomCpuModel) {
        customCpuModel = newCustomCpuModel;
    }
    
    public boolean customCpuModelPresent() {
        return customCpuModel != null;
    }
    
    public String customEmulatedMachine() {
        return customEmulatedMachine;
    }
    
    public void customEmulatedMachine(String newCustomEmulatedMachine) {
        customEmulatedMachine = newCustomEmulatedMachine;
    }
    
    public boolean customEmulatedMachinePresent() {
        return customEmulatedMachine != null;
    }
    
    public List<CustomProperty> customProperties() {
        return makeUnmodifiableList(customProperties);
    }
    
    public void customProperties(List<CustomProperty> newCustomProperties) {
        customProperties = makeArrayList(newCustomProperties);
    }
    
    public boolean customPropertiesPresent() {
        return customProperties != null && !customProperties.isEmpty();
    }
    
    public boolean deleteProtected() {
        return deleteProtected;
    }
    
    public void deleteProtected(boolean newDeleteProtected) {
        deleteProtected = Boolean.valueOf(newDeleteProtected);
    }
    
    public void deleteProtected(Boolean newDeleteProtected) {
        deleteProtected = newDeleteProtected;
    }
    
    public boolean deleteProtectedPresent() {
        return deleteProtected != null;
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
    
    public Domain domain() {
        return domain;
    }
    
    public void domain(Domain newDomain) {
        domain = newDomain;
    }
    
    public boolean domainPresent() {
        return domain != null;
    }
    
    public HighAvailability highAvailability() {
        return highAvailability;
    }
    
    public void highAvailability(HighAvailability newHighAvailability) {
        highAvailability = newHighAvailability;
    }
    
    public boolean highAvailabilityPresent() {
        return highAvailability != null;
    }
    
    public Initialization initialization() {
        return initialization;
    }
    
    public void initialization(Initialization newInitialization) {
        initialization = newInitialization;
    }
    
    public boolean initializationPresent() {
        return initialization != null;
    }
    
    public Io io() {
        return io;
    }
    
    public void io(Io newIo) {
        io = newIo;
    }
    
    public boolean ioPresent() {
        return io != null;
    }
    
    public Icon largeIcon() {
        return largeIcon;
    }
    
    public void largeIcon(Icon newLargeIcon) {
        largeIcon = newLargeIcon;
    }
    
    public boolean largeIconPresent() {
        return largeIcon != null;
    }
    
    public StorageDomainLease lease() {
        return lease;
    }
    
    public void lease(StorageDomainLease newLease) {
        lease = newLease;
    }
    
    public boolean leasePresent() {
        return lease != null;
    }
    
    public BigInteger memory() {
        return memory;
    }
    
    public Byte memoryAsByte() {
        return asByte("VmBase", "memory", memory);
    }
    
    public Short memoryAsShort() {
        return asShort("VmBase", "memory", memory);
    }
    
    public Integer memoryAsInteger() {
        return asInteger("VmBase", "memory", memory);
    }
    
    public Long memoryAsLong() {
        return asLong("VmBase", "memory", memory);
    }
    
    public void memory(BigInteger newMemory) {
        memory = newMemory;
    }
    
    public boolean memoryPresent() {
        return memory != null;
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
    
    public BigInteger migrationDowntime() {
        return migrationDowntime;
    }
    
    public Byte migrationDowntimeAsByte() {
        return asByte("VmBase", "migrationDowntime", migrationDowntime);
    }
    
    public Short migrationDowntimeAsShort() {
        return asShort("VmBase", "migrationDowntime", migrationDowntime);
    }
    
    public Integer migrationDowntimeAsInteger() {
        return asInteger("VmBase", "migrationDowntime", migrationDowntime);
    }
    
    public Long migrationDowntimeAsLong() {
        return asLong("VmBase", "migrationDowntime", migrationDowntime);
    }
    
    public void migrationDowntime(BigInteger newMigrationDowntime) {
        migrationDowntime = newMigrationDowntime;
    }
    
    public boolean migrationDowntimePresent() {
        return migrationDowntime != null;
    }
    
    public boolean multiQueuesEnabled() {
        return multiQueuesEnabled;
    }
    
    public void multiQueuesEnabled(boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = Boolean.valueOf(newMultiQueuesEnabled);
    }
    
    public void multiQueuesEnabled(Boolean newMultiQueuesEnabled) {
        multiQueuesEnabled = newMultiQueuesEnabled;
    }
    
    public boolean multiQueuesEnabledPresent() {
        return multiQueuesEnabled != null;
    }
    
    public String origin() {
        return origin;
    }
    
    public void origin(String newOrigin) {
        origin = newOrigin;
    }
    
    public boolean originPresent() {
        return origin != null;
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
    
    public VmPlacementPolicy placementPolicy() {
        return placementPolicy;
    }
    
    public void placementPolicy(VmPlacementPolicy newPlacementPolicy) {
        placementPolicy = newPlacementPolicy;
    }
    
    public boolean placementPolicyPresent() {
        return placementPolicy != null;
    }
    
    public RngDevice rngDevice() {
        return rngDevice;
    }
    
    public void rngDevice(RngDevice newRngDevice) {
        rngDevice = newRngDevice;
    }
    
    public boolean rngDevicePresent() {
        return rngDevice != null;
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
    
    public Icon smallIcon() {
        return smallIcon;
    }
    
    public void smallIcon(Icon newSmallIcon) {
        smallIcon = newSmallIcon;
    }
    
    public boolean smallIconPresent() {
        return smallIcon != null;
    }
    
    public boolean soundcardEnabled() {
        return soundcardEnabled;
    }
    
    public void soundcardEnabled(boolean newSoundcardEnabled) {
        soundcardEnabled = Boolean.valueOf(newSoundcardEnabled);
    }
    
    public void soundcardEnabled(Boolean newSoundcardEnabled) {
        soundcardEnabled = newSoundcardEnabled;
    }
    
    public boolean soundcardEnabledPresent() {
        return soundcardEnabled != null;
    }
    
    public Sso sso() {
        return sso;
    }
    
    public void sso(Sso newSso) {
        sso = newSso;
    }
    
    public boolean ssoPresent() {
        return sso != null;
    }
    
    public boolean startPaused() {
        return startPaused;
    }
    
    public void startPaused(boolean newStartPaused) {
        startPaused = Boolean.valueOf(newStartPaused);
    }
    
    public void startPaused(Boolean newStartPaused) {
        startPaused = newStartPaused;
    }
    
    public boolean startPausedPresent() {
        return startPaused != null;
    }
    
    public boolean stateless() {
        return stateless;
    }
    
    public void stateless(boolean newStateless) {
        stateless = Boolean.valueOf(newStateless);
    }
    
    public void stateless(Boolean newStateless) {
        stateless = newStateless;
    }
    
    public boolean statelessPresent() {
        return stateless != null;
    }
    
    public VmStorageErrorResumeBehaviour storageErrorResumeBehaviour() {
        return storageErrorResumeBehaviour;
    }
    
    public void storageErrorResumeBehaviour(VmStorageErrorResumeBehaviour newStorageErrorResumeBehaviour) {
        storageErrorResumeBehaviour = newStorageErrorResumeBehaviour;
    }
    
    public boolean storageErrorResumeBehaviourPresent() {
        return storageErrorResumeBehaviour != null;
    }
    
    public TimeZone timeZone() {
        return timeZone;
    }
    
    public void timeZone(TimeZone newTimeZone) {
        timeZone = newTimeZone;
    }
    
    public boolean timeZonePresent() {
        return timeZone != null;
    }
    
    public boolean tpmEnabled() {
        return tpmEnabled;
    }
    
    public void tpmEnabled(boolean newTpmEnabled) {
        tpmEnabled = Boolean.valueOf(newTpmEnabled);
    }
    
    public void tpmEnabled(Boolean newTpmEnabled) {
        tpmEnabled = newTpmEnabled;
    }
    
    public boolean tpmEnabledPresent() {
        return tpmEnabled != null;
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
    
    public VmType type() {
        return type;
    }
    
    public void type(VmType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public Usb usb() {
        return usb;
    }
    
    public void usb(Usb newUsb) {
        usb = newUsb;
    }
    
    public boolean usbPresent() {
        return usb != null;
    }
    
    public VirtioScsi virtioScsi() {
        return virtioScsi;
    }
    
    public void virtioScsi(VirtioScsi newVirtioScsi) {
        virtioScsi = newVirtioScsi;
    }
    
    public boolean virtioScsiPresent() {
        return virtioScsi != null;
    }
    
    public BigInteger virtioScsiMultiQueues() {
        return virtioScsiMultiQueues;
    }
    
    public Byte virtioScsiMultiQueuesAsByte() {
        return asByte("VmBase", "virtioScsiMultiQueues", virtioScsiMultiQueues);
    }
    
    public Short virtioScsiMultiQueuesAsShort() {
        return asShort("VmBase", "virtioScsiMultiQueues", virtioScsiMultiQueues);
    }
    
    public Integer virtioScsiMultiQueuesAsInteger() {
        return asInteger("VmBase", "virtioScsiMultiQueues", virtioScsiMultiQueues);
    }
    
    public Long virtioScsiMultiQueuesAsLong() {
        return asLong("VmBase", "virtioScsiMultiQueues", virtioScsiMultiQueues);
    }
    
    public void virtioScsiMultiQueues(BigInteger newVirtioScsiMultiQueues) {
        virtioScsiMultiQueues = newVirtioScsiMultiQueues;
    }
    
    public boolean virtioScsiMultiQueuesPresent() {
        return virtioScsiMultiQueues != null;
    }
    
    public boolean virtioScsiMultiQueuesEnabled() {
        return virtioScsiMultiQueuesEnabled;
    }
    
    public void virtioScsiMultiQueuesEnabled(boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = Boolean.valueOf(newVirtioScsiMultiQueuesEnabled);
    }
    
    public void virtioScsiMultiQueuesEnabled(Boolean newVirtioScsiMultiQueuesEnabled) {
        virtioScsiMultiQueuesEnabled = newVirtioScsiMultiQueuesEnabled;
    }
    
    public boolean virtioScsiMultiQueuesEnabledPresent() {
        return virtioScsiMultiQueuesEnabled != null;
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
    
    public CpuProfile cpuProfile() {
        return cpuProfile;
    }
    
    public void cpuProfile(CpuProfile newCpuProfile) {
        cpuProfile = newCpuProfile;
    }
    
    public boolean cpuProfilePresent() {
        return cpuProfile != null;
    }
    
    public Quota quota() {
        return quota;
    }
    
    public void quota(Quota newQuota) {
        quota = newQuota;
    }
    
    public boolean quotaPresent() {
        return quota != null;
    }
    
    public StorageDomain storageDomain() {
        return storageDomain;
    }
    
    public void storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
    }
    
    public boolean storageDomainPresent() {
        return storageDomain != null;
    }
    
}
