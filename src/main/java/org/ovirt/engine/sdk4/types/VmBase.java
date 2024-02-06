/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Represents basic virtual machine configuration.
 * This is used by virtual machines, templates and instance types.
 */
public interface VmBase extends Identified {
    AutoPinningPolicy autoPinningPolicy();
    
    boolean autoPinningPolicyPresent();
    
    Bios bios();
    
    boolean biosPresent();
    
    Console console();
    
    boolean consolePresent();
    
    Cpu cpu();
    
    boolean cpuPresent();
    
    BigInteger cpuShares();
    Byte cpuSharesAsByte();
    Short cpuSharesAsShort();
    Integer cpuSharesAsInteger();
    Long cpuSharesAsLong();
    
    boolean cpuSharesPresent();
    
    Date creationTime();
    
    boolean creationTimePresent();
    
    Version customCompatibilityVersion();
    
    boolean customCompatibilityVersionPresent();
    
    String customCpuModel();
    
    boolean customCpuModelPresent();
    
    String customEmulatedMachine();
    
    boolean customEmulatedMachinePresent();
    
    List<CustomProperty> customProperties();
    
    boolean customPropertiesPresent();
    
    boolean deleteProtected();
    
    boolean deleteProtectedPresent();
    
    Display display();
    
    boolean displayPresent();
    
    Domain domain();
    
    boolean domainPresent();
    
    HighAvailability highAvailability();
    
    boolean highAvailabilityPresent();
    
    Initialization initialization();
    
    boolean initializationPresent();
    
    Io io();
    
    boolean ioPresent();
    
    Icon largeIcon();
    
    boolean largeIconPresent();
    
    StorageDomainLease lease();
    
    boolean leasePresent();
    
    BigInteger memory();
    Byte memoryAsByte();
    Short memoryAsShort();
    Integer memoryAsInteger();
    Long memoryAsLong();
    
    boolean memoryPresent();
    
    MemoryPolicy memoryPolicy();
    
    boolean memoryPolicyPresent();
    
    MigrationOptions migration();
    
    boolean migrationPresent();
    
    BigInteger migrationDowntime();
    Byte migrationDowntimeAsByte();
    Short migrationDowntimeAsShort();
    Integer migrationDowntimeAsInteger();
    Long migrationDowntimeAsLong();
    
    boolean migrationDowntimePresent();
    
    boolean multiQueuesEnabled();
    
    boolean multiQueuesEnabledPresent();
    
    String origin();
    
    boolean originPresent();
    
    OperatingSystem os();
    
    boolean osPresent();
    
    VmPlacementPolicy placementPolicy();
    
    boolean placementPolicyPresent();
    
    RngDevice rngDevice();
    
    boolean rngDevicePresent();
    
    SerialNumber serialNumber();
    
    boolean serialNumberPresent();
    
    Icon smallIcon();
    
    boolean smallIconPresent();
    
    boolean soundcardEnabled();
    
    boolean soundcardEnabledPresent();
    
    Sso sso();
    
    boolean ssoPresent();
    
    boolean startPaused();
    
    boolean startPausedPresent();
    
    boolean stateless();
    
    boolean statelessPresent();
    
    VmStorageErrorResumeBehaviour storageErrorResumeBehaviour();
    
    boolean storageErrorResumeBehaviourPresent();
    
    TimeZone timeZone();
    
    boolean timeZonePresent();
    
    boolean tpmEnabled();
    
    boolean tpmEnabledPresent();
    
    boolean tunnelMigration();
    
    boolean tunnelMigrationPresent();
    
    VmType type();
    
    boolean typePresent();
    
    Usb usb();
    
    boolean usbPresent();
    
    VirtioScsi virtioScsi();
    
    boolean virtioScsiPresent();
    
    BigInteger virtioScsiMultiQueues();
    Byte virtioScsiMultiQueuesAsByte();
    Short virtioScsiMultiQueuesAsShort();
    Integer virtioScsiMultiQueuesAsInteger();
    Long virtioScsiMultiQueuesAsLong();
    
    boolean virtioScsiMultiQueuesPresent();
    
    boolean virtioScsiMultiQueuesEnabled();
    
    boolean virtioScsiMultiQueuesEnabledPresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    CpuProfile cpuProfile();
    
    boolean cpuProfilePresent();
    
    Quota quota();
    
    boolean quotaPresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
}
