/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * Represents a virtual disk device.
 */
public interface Disk extends Device {
    boolean active();
    
    boolean activePresent();
    
    BigInteger actualSize();
    Byte actualSizeAsByte();
    Short actualSizeAsShort();
    Integer actualSizeAsInteger();
    Long actualSizeAsLong();
    
    boolean actualSizePresent();
    
    String alias();
    
    boolean aliasPresent();
    
    DiskBackup backup();
    
    boolean backupPresent();
    
    DiskBackupMode backupMode();
    
    boolean backupModePresent();
    
    boolean bootable();
    
    boolean bootablePresent();
    
    DiskContentType contentType();
    
    boolean contentTypePresent();
    
    String externalDisk();
    
    boolean externalDiskPresent();
    
    DiskFormat format();
    
    boolean formatPresent();
    
    String imageId();
    
    boolean imageIdPresent();
    
    BigInteger initialSize();
    Byte initialSizeAsByte();
    Short initialSizeAsShort();
    Integer initialSizeAsInteger();
    Long initialSizeAsLong();
    
    boolean initialSizePresent();
    
    DiskInterface interface_();
    
    boolean interface_Present();
    
    String logicalName();
    
    boolean logicalNamePresent();
    
    HostStorage lunStorage();
    
    boolean lunStoragePresent();
    
    boolean propagateErrors();
    
    boolean propagateErrorsPresent();
    
    BigInteger provisionedSize();
    Byte provisionedSizeAsByte();
    Short provisionedSizeAsShort();
    Integer provisionedSizeAsInteger();
    Long provisionedSizeAsLong();
    
    boolean provisionedSizePresent();
    
    QcowVersion qcowVersion();
    
    boolean qcowVersionPresent();
    
    boolean readOnly();
    
    boolean readOnlyPresent();
    
    ScsiGenericIO sgio();
    
    boolean sgioPresent();
    
    boolean shareable();
    
    boolean shareablePresent();
    
    boolean sparse();
    
    boolean sparsePresent();
    
    DiskStatus status();
    
    boolean statusPresent();
    
    DiskStorageType storageType();
    
    boolean storageTypePresent();
    
    BigInteger totalSize();
    Byte totalSizeAsByte();
    Short totalSizeAsShort();
    Integer totalSizeAsInteger();
    Long totalSizeAsLong();
    
    boolean totalSizePresent();
    
    boolean usesScsiReservation();
    
    boolean usesScsiReservationPresent();
    
    boolean wipeAfterDelete();
    
    boolean wipeAfterDeletePresent();
    
    DiskProfile diskProfile();
    
    boolean diskProfilePresent();
    
    List<DiskSnapshot> diskSnapshots();
    
    boolean diskSnapshotsPresent();
    
    OpenStackVolumeType openstackVolumeType();
    
    boolean openstackVolumeTypePresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    Quota quota();
    
    boolean quotaPresent();
    
    Snapshot snapshot();
    
    boolean snapshotPresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
    List<StorageDomain> storageDomains();
    
    boolean storageDomainsPresent();
    
}
