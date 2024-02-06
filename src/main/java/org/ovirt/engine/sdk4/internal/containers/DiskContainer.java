/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskBackup;
import org.ovirt.engine.sdk4.types.DiskBackupMode;
import org.ovirt.engine.sdk4.types.DiskContentType;
import org.ovirt.engine.sdk4.types.DiskFormat;
import org.ovirt.engine.sdk4.types.DiskInterface;
import org.ovirt.engine.sdk4.types.DiskProfile;
import org.ovirt.engine.sdk4.types.DiskSnapshot;
import org.ovirt.engine.sdk4.types.DiskStatus;
import org.ovirt.engine.sdk4.types.DiskStorageType;
import org.ovirt.engine.sdk4.types.HostStorage;
import org.ovirt.engine.sdk4.types.OpenStackVolumeType;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.QcowVersion;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.ScsiGenericIO;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class DiskContainer extends DeviceContainer implements Disk {
    private Boolean active;
    private BigInteger actualSize;
    private String alias;
    private DiskBackup backup;
    private DiskBackupMode backupMode;
    private Boolean bootable;
    private DiskContentType contentType;
    private String externalDisk;
    private DiskFormat format;
    private String imageId;
    private BigInteger initialSize;
    private DiskInterface interface_;
    private String logicalName;
    private HostStorage lunStorage;
    private Boolean propagateErrors;
    private BigInteger provisionedSize;
    private QcowVersion qcowVersion;
    private Boolean readOnly;
    private ScsiGenericIO sgio;
    private Boolean shareable;
    private Boolean sparse;
    private DiskStatus status;
    private DiskStorageType storageType;
    private BigInteger totalSize;
    private Boolean usesScsiReservation;
    private Boolean wipeAfterDelete;
    private DiskProfile diskProfile;
    private List<DiskSnapshot> diskSnapshots;
    private OpenStackVolumeType openstackVolumeType;
    private List<Permission> permissions;
    private Quota quota;
    private Snapshot snapshot;
    private List<Statistic> statistics;
    private StorageDomain storageDomain;
    private List<StorageDomain> storageDomains;
    
    public boolean active() {
        return active;
    }
    
    public void active(boolean newActive) {
        active = Boolean.valueOf(newActive);
    }
    
    public void active(Boolean newActive) {
        active = newActive;
    }
    
    public boolean activePresent() {
        return active != null;
    }
    
    public BigInteger actualSize() {
        return actualSize;
    }
    
    public Byte actualSizeAsByte() {
        return asByte("Disk", "actualSize", actualSize);
    }
    
    public Short actualSizeAsShort() {
        return asShort("Disk", "actualSize", actualSize);
    }
    
    public Integer actualSizeAsInteger() {
        return asInteger("Disk", "actualSize", actualSize);
    }
    
    public Long actualSizeAsLong() {
        return asLong("Disk", "actualSize", actualSize);
    }
    
    public void actualSize(BigInteger newActualSize) {
        actualSize = newActualSize;
    }
    
    public boolean actualSizePresent() {
        return actualSize != null;
    }
    
    public String alias() {
        return alias;
    }
    
    public void alias(String newAlias) {
        alias = newAlias;
    }
    
    public boolean aliasPresent() {
        return alias != null;
    }
    
    public DiskBackup backup() {
        return backup;
    }
    
    public void backup(DiskBackup newBackup) {
        backup = newBackup;
    }
    
    public boolean backupPresent() {
        return backup != null;
    }
    
    public DiskBackupMode backupMode() {
        return backupMode;
    }
    
    public void backupMode(DiskBackupMode newBackupMode) {
        backupMode = newBackupMode;
    }
    
    public boolean backupModePresent() {
        return backupMode != null;
    }
    
    public boolean bootable() {
        return bootable;
    }
    
    public void bootable(boolean newBootable) {
        bootable = Boolean.valueOf(newBootable);
    }
    
    public void bootable(Boolean newBootable) {
        bootable = newBootable;
    }
    
    public boolean bootablePresent() {
        return bootable != null;
    }
    
    public DiskContentType contentType() {
        return contentType;
    }
    
    public void contentType(DiskContentType newContentType) {
        contentType = newContentType;
    }
    
    public boolean contentTypePresent() {
        return contentType != null;
    }
    
    public String externalDisk() {
        return externalDisk;
    }
    
    public void externalDisk(String newExternalDisk) {
        externalDisk = newExternalDisk;
    }
    
    public boolean externalDiskPresent() {
        return externalDisk != null;
    }
    
    public DiskFormat format() {
        return format;
    }
    
    public void format(DiskFormat newFormat) {
        format = newFormat;
    }
    
    public boolean formatPresent() {
        return format != null;
    }
    
    public String imageId() {
        return imageId;
    }
    
    public void imageId(String newImageId) {
        imageId = newImageId;
    }
    
    public boolean imageIdPresent() {
        return imageId != null;
    }
    
    public BigInteger initialSize() {
        return initialSize;
    }
    
    public Byte initialSizeAsByte() {
        return asByte("Disk", "initialSize", initialSize);
    }
    
    public Short initialSizeAsShort() {
        return asShort("Disk", "initialSize", initialSize);
    }
    
    public Integer initialSizeAsInteger() {
        return asInteger("Disk", "initialSize", initialSize);
    }
    
    public Long initialSizeAsLong() {
        return asLong("Disk", "initialSize", initialSize);
    }
    
    public void initialSize(BigInteger newInitialSize) {
        initialSize = newInitialSize;
    }
    
    public boolean initialSizePresent() {
        return initialSize != null;
    }
    
    public DiskInterface interface_() {
        return interface_;
    }
    
    public void interface_(DiskInterface newInterface) {
        interface_ = newInterface;
    }
    
    public boolean interface_Present() {
        return interface_ != null;
    }
    
    public String logicalName() {
        return logicalName;
    }
    
    public void logicalName(String newLogicalName) {
        logicalName = newLogicalName;
    }
    
    public boolean logicalNamePresent() {
        return logicalName != null;
    }
    
    public HostStorage lunStorage() {
        return lunStorage;
    }
    
    public void lunStorage(HostStorage newLunStorage) {
        lunStorage = newLunStorage;
    }
    
    public boolean lunStoragePresent() {
        return lunStorage != null;
    }
    
    public boolean propagateErrors() {
        return propagateErrors;
    }
    
    public void propagateErrors(boolean newPropagateErrors) {
        propagateErrors = Boolean.valueOf(newPropagateErrors);
    }
    
    public void propagateErrors(Boolean newPropagateErrors) {
        propagateErrors = newPropagateErrors;
    }
    
    public boolean propagateErrorsPresent() {
        return propagateErrors != null;
    }
    
    public BigInteger provisionedSize() {
        return provisionedSize;
    }
    
    public Byte provisionedSizeAsByte() {
        return asByte("Disk", "provisionedSize", provisionedSize);
    }
    
    public Short provisionedSizeAsShort() {
        return asShort("Disk", "provisionedSize", provisionedSize);
    }
    
    public Integer provisionedSizeAsInteger() {
        return asInteger("Disk", "provisionedSize", provisionedSize);
    }
    
    public Long provisionedSizeAsLong() {
        return asLong("Disk", "provisionedSize", provisionedSize);
    }
    
    public void provisionedSize(BigInteger newProvisionedSize) {
        provisionedSize = newProvisionedSize;
    }
    
    public boolean provisionedSizePresent() {
        return provisionedSize != null;
    }
    
    public QcowVersion qcowVersion() {
        return qcowVersion;
    }
    
    public void qcowVersion(QcowVersion newQcowVersion) {
        qcowVersion = newQcowVersion;
    }
    
    public boolean qcowVersionPresent() {
        return qcowVersion != null;
    }
    
    public boolean readOnly() {
        return readOnly;
    }
    
    public void readOnly(boolean newReadOnly) {
        readOnly = Boolean.valueOf(newReadOnly);
    }
    
    public void readOnly(Boolean newReadOnly) {
        readOnly = newReadOnly;
    }
    
    public boolean readOnlyPresent() {
        return readOnly != null;
    }
    
    public ScsiGenericIO sgio() {
        return sgio;
    }
    
    public void sgio(ScsiGenericIO newSgio) {
        sgio = newSgio;
    }
    
    public boolean sgioPresent() {
        return sgio != null;
    }
    
    public boolean shareable() {
        return shareable;
    }
    
    public void shareable(boolean newShareable) {
        shareable = Boolean.valueOf(newShareable);
    }
    
    public void shareable(Boolean newShareable) {
        shareable = newShareable;
    }
    
    public boolean shareablePresent() {
        return shareable != null;
    }
    
    public boolean sparse() {
        return sparse;
    }
    
    public void sparse(boolean newSparse) {
        sparse = Boolean.valueOf(newSparse);
    }
    
    public void sparse(Boolean newSparse) {
        sparse = newSparse;
    }
    
    public boolean sparsePresent() {
        return sparse != null;
    }
    
    public DiskStatus status() {
        return status;
    }
    
    public void status(DiskStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public DiskStorageType storageType() {
        return storageType;
    }
    
    public void storageType(DiskStorageType newStorageType) {
        storageType = newStorageType;
    }
    
    public boolean storageTypePresent() {
        return storageType != null;
    }
    
    public BigInteger totalSize() {
        return totalSize;
    }
    
    public Byte totalSizeAsByte() {
        return asByte("Disk", "totalSize", totalSize);
    }
    
    public Short totalSizeAsShort() {
        return asShort("Disk", "totalSize", totalSize);
    }
    
    public Integer totalSizeAsInteger() {
        return asInteger("Disk", "totalSize", totalSize);
    }
    
    public Long totalSizeAsLong() {
        return asLong("Disk", "totalSize", totalSize);
    }
    
    public void totalSize(BigInteger newTotalSize) {
        totalSize = newTotalSize;
    }
    
    public boolean totalSizePresent() {
        return totalSize != null;
    }
    
    public boolean usesScsiReservation() {
        return usesScsiReservation;
    }
    
    public void usesScsiReservation(boolean newUsesScsiReservation) {
        usesScsiReservation = Boolean.valueOf(newUsesScsiReservation);
    }
    
    public void usesScsiReservation(Boolean newUsesScsiReservation) {
        usesScsiReservation = newUsesScsiReservation;
    }
    
    public boolean usesScsiReservationPresent() {
        return usesScsiReservation != null;
    }
    
    public boolean wipeAfterDelete() {
        return wipeAfterDelete;
    }
    
    public void wipeAfterDelete(boolean newWipeAfterDelete) {
        wipeAfterDelete = Boolean.valueOf(newWipeAfterDelete);
    }
    
    public void wipeAfterDelete(Boolean newWipeAfterDelete) {
        wipeAfterDelete = newWipeAfterDelete;
    }
    
    public boolean wipeAfterDeletePresent() {
        return wipeAfterDelete != null;
    }
    
    public DiskProfile diskProfile() {
        return diskProfile;
    }
    
    public void diskProfile(DiskProfile newDiskProfile) {
        diskProfile = newDiskProfile;
    }
    
    public boolean diskProfilePresent() {
        return diskProfile != null;
    }
    
    public List<DiskSnapshot> diskSnapshots() {
        return makeUnmodifiableList(diskSnapshots);
    }
    
    public void diskSnapshots(List<DiskSnapshot> newDiskSnapshots) {
        diskSnapshots = makeArrayList(newDiskSnapshots);
    }
    
    public boolean diskSnapshotsPresent() {
        return diskSnapshots != null && !diskSnapshots.isEmpty();
    }
    
    public OpenStackVolumeType openstackVolumeType() {
        return openstackVolumeType;
    }
    
    public void openstackVolumeType(OpenStackVolumeType newOpenstackVolumeType) {
        openstackVolumeType = newOpenstackVolumeType;
    }
    
    public boolean openstackVolumeTypePresent() {
        return openstackVolumeType != null;
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
    
    public Quota quota() {
        return quota;
    }
    
    public void quota(Quota newQuota) {
        quota = newQuota;
    }
    
    public boolean quotaPresent() {
        return quota != null;
    }
    
    public Snapshot snapshot() {
        return snapshot;
    }
    
    public void snapshot(Snapshot newSnapshot) {
        snapshot = newSnapshot;
    }
    
    public boolean snapshotPresent() {
        return snapshot != null;
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
    
    public StorageDomain storageDomain() {
        return storageDomain;
    }
    
    public void storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
    }
    
    public boolean storageDomainPresent() {
        return storageDomain != null;
    }
    
    public List<StorageDomain> storageDomains() {
        return makeUnmodifiableList(storageDomains);
    }
    
    public void storageDomains(List<StorageDomain> newStorageDomains) {
        storageDomains = makeArrayList(newStorageDomains);
    }
    
    public boolean storageDomainsPresent() {
        return storageDomains != null && !storageDomains.isEmpty();
    }
    
}
