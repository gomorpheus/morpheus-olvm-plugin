/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskProfile;
import org.ovirt.engine.sdk4.types.DiskSnapshot;
import org.ovirt.engine.sdk4.types.ExternalStatus;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostStorage;
import org.ovirt.engine.sdk4.types.Image;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.StorageConnection;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageDomainStatus;
import org.ovirt.engine.sdk4.types.StorageDomainType;
import org.ovirt.engine.sdk4.types.StorageFormat;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class StorageDomainContainer extends IdentifiedContainer implements StorageDomain {
    private BigInteger available;
    private Boolean backup;
    private BigInteger blockSize;
    private BigInteger committed;
    private BigInteger criticalSpaceActionBlocker;
    private Boolean discardAfterDelete;
    private ExternalStatus externalStatus;
    private Boolean import_;
    private Boolean master;
    private StorageDomainStatus status;
    private HostStorage storage;
    private StorageFormat storageFormat;
    private Boolean supportsDiscard;
    private Boolean supportsDiscardZeroesData;
    private StorageDomainType type;
    private BigInteger used;
    private BigInteger warningLowSpaceIndicator;
    private Boolean wipeAfterDelete;
    private DataCenter dataCenter;
    private List<DataCenter> dataCenters;
    private List<DiskProfile> diskProfiles;
    private List<DiskSnapshot> diskSnapshots;
    private List<Disk> disks;
    private List<File> files;
    private Host host;
    private List<Image> images;
    private List<Permission> permissions;
    private List<StorageConnection> storageConnections;
    private List<Template> templates;
    private List<Vm> vms;
    
    public BigInteger available() {
        return available;
    }
    
    public Byte availableAsByte() {
        return asByte("StorageDomain", "available", available);
    }
    
    public Short availableAsShort() {
        return asShort("StorageDomain", "available", available);
    }
    
    public Integer availableAsInteger() {
        return asInteger("StorageDomain", "available", available);
    }
    
    public Long availableAsLong() {
        return asLong("StorageDomain", "available", available);
    }
    
    public void available(BigInteger newAvailable) {
        available = newAvailable;
    }
    
    public boolean availablePresent() {
        return available != null;
    }
    
    public boolean backup() {
        return backup;
    }
    
    public void backup(boolean newBackup) {
        backup = Boolean.valueOf(newBackup);
    }
    
    public void backup(Boolean newBackup) {
        backup = newBackup;
    }
    
    public boolean backupPresent() {
        return backup != null;
    }
    
    public BigInteger blockSize() {
        return blockSize;
    }
    
    public Byte blockSizeAsByte() {
        return asByte("StorageDomain", "blockSize", blockSize);
    }
    
    public Short blockSizeAsShort() {
        return asShort("StorageDomain", "blockSize", blockSize);
    }
    
    public Integer blockSizeAsInteger() {
        return asInteger("StorageDomain", "blockSize", blockSize);
    }
    
    public Long blockSizeAsLong() {
        return asLong("StorageDomain", "blockSize", blockSize);
    }
    
    public void blockSize(BigInteger newBlockSize) {
        blockSize = newBlockSize;
    }
    
    public boolean blockSizePresent() {
        return blockSize != null;
    }
    
    public BigInteger committed() {
        return committed;
    }
    
    public Byte committedAsByte() {
        return asByte("StorageDomain", "committed", committed);
    }
    
    public Short committedAsShort() {
        return asShort("StorageDomain", "committed", committed);
    }
    
    public Integer committedAsInteger() {
        return asInteger("StorageDomain", "committed", committed);
    }
    
    public Long committedAsLong() {
        return asLong("StorageDomain", "committed", committed);
    }
    
    public void committed(BigInteger newCommitted) {
        committed = newCommitted;
    }
    
    public boolean committedPresent() {
        return committed != null;
    }
    
    public BigInteger criticalSpaceActionBlocker() {
        return criticalSpaceActionBlocker;
    }
    
    public Byte criticalSpaceActionBlockerAsByte() {
        return asByte("StorageDomain", "criticalSpaceActionBlocker", criticalSpaceActionBlocker);
    }
    
    public Short criticalSpaceActionBlockerAsShort() {
        return asShort("StorageDomain", "criticalSpaceActionBlocker", criticalSpaceActionBlocker);
    }
    
    public Integer criticalSpaceActionBlockerAsInteger() {
        return asInteger("StorageDomain", "criticalSpaceActionBlocker", criticalSpaceActionBlocker);
    }
    
    public Long criticalSpaceActionBlockerAsLong() {
        return asLong("StorageDomain", "criticalSpaceActionBlocker", criticalSpaceActionBlocker);
    }
    
    public void criticalSpaceActionBlocker(BigInteger newCriticalSpaceActionBlocker) {
        criticalSpaceActionBlocker = newCriticalSpaceActionBlocker;
    }
    
    public boolean criticalSpaceActionBlockerPresent() {
        return criticalSpaceActionBlocker != null;
    }
    
    public boolean discardAfterDelete() {
        return discardAfterDelete;
    }
    
    public void discardAfterDelete(boolean newDiscardAfterDelete) {
        discardAfterDelete = Boolean.valueOf(newDiscardAfterDelete);
    }
    
    public void discardAfterDelete(Boolean newDiscardAfterDelete) {
        discardAfterDelete = newDiscardAfterDelete;
    }
    
    public boolean discardAfterDeletePresent() {
        return discardAfterDelete != null;
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
    
    public boolean import_() {
        return import_;
    }
    
    public void import_(boolean newImport) {
        import_ = Boolean.valueOf(newImport);
    }
    
    public void import_(Boolean newImport) {
        import_ = newImport;
    }
    
    public boolean import_Present() {
        return import_ != null;
    }
    
    public boolean master() {
        return master;
    }
    
    public void master(boolean newMaster) {
        master = Boolean.valueOf(newMaster);
    }
    
    public void master(Boolean newMaster) {
        master = newMaster;
    }
    
    public boolean masterPresent() {
        return master != null;
    }
    
    public StorageDomainStatus status() {
        return status;
    }
    
    public void status(StorageDomainStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public HostStorage storage() {
        return storage;
    }
    
    public void storage(HostStorage newStorage) {
        storage = newStorage;
    }
    
    public boolean storagePresent() {
        return storage != null;
    }
    
    public StorageFormat storageFormat() {
        return storageFormat;
    }
    
    public void storageFormat(StorageFormat newStorageFormat) {
        storageFormat = newStorageFormat;
    }
    
    public boolean storageFormatPresent() {
        return storageFormat != null;
    }
    
    public boolean supportsDiscard() {
        return supportsDiscard;
    }
    
    public void supportsDiscard(boolean newSupportsDiscard) {
        supportsDiscard = Boolean.valueOf(newSupportsDiscard);
    }
    
    public void supportsDiscard(Boolean newSupportsDiscard) {
        supportsDiscard = newSupportsDiscard;
    }
    
    public boolean supportsDiscardPresent() {
        return supportsDiscard != null;
    }
    
    public boolean supportsDiscardZeroesData() {
        return supportsDiscardZeroesData;
    }
    
    public void supportsDiscardZeroesData(boolean newSupportsDiscardZeroesData) {
        supportsDiscardZeroesData = Boolean.valueOf(newSupportsDiscardZeroesData);
    }
    
    public void supportsDiscardZeroesData(Boolean newSupportsDiscardZeroesData) {
        supportsDiscardZeroesData = newSupportsDiscardZeroesData;
    }
    
    public boolean supportsDiscardZeroesDataPresent() {
        return supportsDiscardZeroesData != null;
    }
    
    public StorageDomainType type() {
        return type;
    }
    
    public void type(StorageDomainType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public BigInteger used() {
        return used;
    }
    
    public Byte usedAsByte() {
        return asByte("StorageDomain", "used", used);
    }
    
    public Short usedAsShort() {
        return asShort("StorageDomain", "used", used);
    }
    
    public Integer usedAsInteger() {
        return asInteger("StorageDomain", "used", used);
    }
    
    public Long usedAsLong() {
        return asLong("StorageDomain", "used", used);
    }
    
    public void used(BigInteger newUsed) {
        used = newUsed;
    }
    
    public boolean usedPresent() {
        return used != null;
    }
    
    public BigInteger warningLowSpaceIndicator() {
        return warningLowSpaceIndicator;
    }
    
    public Byte warningLowSpaceIndicatorAsByte() {
        return asByte("StorageDomain", "warningLowSpaceIndicator", warningLowSpaceIndicator);
    }
    
    public Short warningLowSpaceIndicatorAsShort() {
        return asShort("StorageDomain", "warningLowSpaceIndicator", warningLowSpaceIndicator);
    }
    
    public Integer warningLowSpaceIndicatorAsInteger() {
        return asInteger("StorageDomain", "warningLowSpaceIndicator", warningLowSpaceIndicator);
    }
    
    public Long warningLowSpaceIndicatorAsLong() {
        return asLong("StorageDomain", "warningLowSpaceIndicator", warningLowSpaceIndicator);
    }
    
    public void warningLowSpaceIndicator(BigInteger newWarningLowSpaceIndicator) {
        warningLowSpaceIndicator = newWarningLowSpaceIndicator;
    }
    
    public boolean warningLowSpaceIndicatorPresent() {
        return warningLowSpaceIndicator != null;
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
    
    public DataCenter dataCenter() {
        return dataCenter;
    }
    
    public void dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
    }
    
    public boolean dataCenterPresent() {
        return dataCenter != null;
    }
    
    public List<DataCenter> dataCenters() {
        return makeUnmodifiableList(dataCenters);
    }
    
    public void dataCenters(List<DataCenter> newDataCenters) {
        dataCenters = makeArrayList(newDataCenters);
    }
    
    public boolean dataCentersPresent() {
        return dataCenters != null && !dataCenters.isEmpty();
    }
    
    public List<DiskProfile> diskProfiles() {
        return makeUnmodifiableList(diskProfiles);
    }
    
    public void diskProfiles(List<DiskProfile> newDiskProfiles) {
        diskProfiles = makeArrayList(newDiskProfiles);
    }
    
    public boolean diskProfilesPresent() {
        return diskProfiles != null && !diskProfiles.isEmpty();
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
    
    public List<Disk> disks() {
        return makeUnmodifiableList(disks);
    }
    
    public void disks(List<Disk> newDisks) {
        disks = makeArrayList(newDisks);
    }
    
    public boolean disksPresent() {
        return disks != null && !disks.isEmpty();
    }
    
    public List<File> files() {
        return makeUnmodifiableList(files);
    }
    
    public void files(List<File> newFiles) {
        files = makeArrayList(newFiles);
    }
    
    public boolean filesPresent() {
        return files != null && !files.isEmpty();
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public List<Image> images() {
        return makeUnmodifiableList(images);
    }
    
    public void images(List<Image> newImages) {
        images = makeArrayList(newImages);
    }
    
    public boolean imagesPresent() {
        return images != null && !images.isEmpty();
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
    
    public List<StorageConnection> storageConnections() {
        return makeUnmodifiableList(storageConnections);
    }
    
    public void storageConnections(List<StorageConnection> newStorageConnections) {
        storageConnections = makeArrayList(newStorageConnections);
    }
    
    public boolean storageConnectionsPresent() {
        return storageConnections != null && !storageConnections.isEmpty();
    }
    
    public List<Template> templates() {
        return makeUnmodifiableList(templates);
    }
    
    public void templates(List<Template> newTemplates) {
        templates = makeArrayList(newTemplates);
    }
    
    public boolean templatesPresent() {
        return templates != null && !templates.isEmpty();
    }
    
    public List<Vm> vms() {
        return makeUnmodifiableList(vms);
    }
    
    public void vms(List<Vm> newVms) {
        vms = makeArrayList(newVms);
    }
    
    public boolean vmsPresent() {
        return vms != null && !vms.isEmpty();
    }
    
}
