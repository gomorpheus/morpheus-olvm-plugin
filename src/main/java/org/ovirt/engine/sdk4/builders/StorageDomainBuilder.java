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
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.StorageDomainContainer;
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

public class StorageDomainBuilder {
    private BigInteger available;
    private Boolean backup;
    private BigInteger blockSize;
    private String comment;
    private BigInteger committed;
    private BigInteger criticalSpaceActionBlocker;
    private DataCenter dataCenter;
    private List<DataCenter> dataCenters;
    private String description;
    private Boolean discardAfterDelete;
    private List<DiskProfile> diskProfiles;
    private List<DiskSnapshot> diskSnapshots;
    private List<Disk> disks;
    private ExternalStatus externalStatus;
    private List<File> files;
    private Host host;
    private String href;
    private String id;
    private List<Image> images;
    private Boolean import_;
    private Boolean master;
    private String name;
    private List<Permission> permissions;
    private StorageDomainStatus status;
    private HostStorage storage;
    private List<StorageConnection> storageConnections;
    private StorageFormat storageFormat;
    private Boolean supportsDiscard;
    private Boolean supportsDiscardZeroesData;
    private List<Template> templates;
    private StorageDomainType type;
    private BigInteger used;
    private List<Vm> vms;
    private BigInteger warningLowSpaceIndicator;
    private Boolean wipeAfterDelete;
    
    public StorageDomainBuilder available(int newAvailable) {
        available = BigInteger.valueOf((long) newAvailable);
        return this;
    }
    
    public StorageDomainBuilder available(Integer newAvailable) {
        if (newAvailable == null) {
            available = null;
        }
        else {
            available = BigInteger.valueOf(newAvailable.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder available(long newAvailable) {
        available = BigInteger.valueOf(newAvailable);
        return this;
    }
    
    public StorageDomainBuilder available(Long newAvailable) {
        if (newAvailable == null) {
            available = null;
        }
        else {
            available = BigInteger.valueOf(newAvailable.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder available(BigInteger newAvailable) {
        available = newAvailable;
        return this;
    }
    
    
    public StorageDomainBuilder backup(boolean newBackup) {
        backup = Boolean.valueOf(newBackup);
        return this;
    }
    
    public StorageDomainBuilder backup(Boolean newBackup) {
        backup = newBackup;
        return this;
    }
    
    
    public StorageDomainBuilder blockSize(int newBlockSize) {
        blockSize = BigInteger.valueOf((long) newBlockSize);
        return this;
    }
    
    public StorageDomainBuilder blockSize(Integer newBlockSize) {
        if (newBlockSize == null) {
            blockSize = null;
        }
        else {
            blockSize = BigInteger.valueOf(newBlockSize.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder blockSize(long newBlockSize) {
        blockSize = BigInteger.valueOf(newBlockSize);
        return this;
    }
    
    public StorageDomainBuilder blockSize(Long newBlockSize) {
        if (newBlockSize == null) {
            blockSize = null;
        }
        else {
            blockSize = BigInteger.valueOf(newBlockSize.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder blockSize(BigInteger newBlockSize) {
        blockSize = newBlockSize;
        return this;
    }
    
    
    public StorageDomainBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public StorageDomainBuilder committed(int newCommitted) {
        committed = BigInteger.valueOf((long) newCommitted);
        return this;
    }
    
    public StorageDomainBuilder committed(Integer newCommitted) {
        if (newCommitted == null) {
            committed = null;
        }
        else {
            committed = BigInteger.valueOf(newCommitted.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder committed(long newCommitted) {
        committed = BigInteger.valueOf(newCommitted);
        return this;
    }
    
    public StorageDomainBuilder committed(Long newCommitted) {
        if (newCommitted == null) {
            committed = null;
        }
        else {
            committed = BigInteger.valueOf(newCommitted.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder committed(BigInteger newCommitted) {
        committed = newCommitted;
        return this;
    }
    
    
    public StorageDomainBuilder criticalSpaceActionBlocker(int newCriticalSpaceActionBlocker) {
        criticalSpaceActionBlocker = BigInteger.valueOf((long) newCriticalSpaceActionBlocker);
        return this;
    }
    
    public StorageDomainBuilder criticalSpaceActionBlocker(Integer newCriticalSpaceActionBlocker) {
        if (newCriticalSpaceActionBlocker == null) {
            criticalSpaceActionBlocker = null;
        }
        else {
            criticalSpaceActionBlocker = BigInteger.valueOf(newCriticalSpaceActionBlocker.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder criticalSpaceActionBlocker(long newCriticalSpaceActionBlocker) {
        criticalSpaceActionBlocker = BigInteger.valueOf(newCriticalSpaceActionBlocker);
        return this;
    }
    
    public StorageDomainBuilder criticalSpaceActionBlocker(Long newCriticalSpaceActionBlocker) {
        if (newCriticalSpaceActionBlocker == null) {
            criticalSpaceActionBlocker = null;
        }
        else {
            criticalSpaceActionBlocker = BigInteger.valueOf(newCriticalSpaceActionBlocker.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder criticalSpaceActionBlocker(BigInteger newCriticalSpaceActionBlocker) {
        criticalSpaceActionBlocker = newCriticalSpaceActionBlocker;
        return this;
    }
    
    
    public StorageDomainBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public StorageDomainBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public StorageDomainBuilder dataCenters(List<DataCenter> newDataCenters) {
        if (newDataCenters != null) {
            if (dataCenters == null) {
                dataCenters = new ArrayList<>(newDataCenters);
            }
            else {
                dataCenters.addAll(newDataCenters);
            }
        }
        return this;
    }
    
    public StorageDomainBuilder dataCenters(DataCenter... newDataCenters) {
        if (newDataCenters != null) {
            if (dataCenters == null) {
                dataCenters = new ArrayList<>(newDataCenters.length);
            }
            Collections.addAll(dataCenters, newDataCenters);
        }
        return this;
    }
    
    public StorageDomainBuilder dataCenters(DataCenterBuilder... newDataCenters) {
        if (newDataCenters != null) {
            if (dataCenters == null) {
                dataCenters = new ArrayList<>(newDataCenters.length);
            }
            for (DataCenterBuilder builder : newDataCenters) {
                dataCenters.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StorageDomainBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public StorageDomainBuilder discardAfterDelete(boolean newDiscardAfterDelete) {
        discardAfterDelete = Boolean.valueOf(newDiscardAfterDelete);
        return this;
    }
    
    public StorageDomainBuilder discardAfterDelete(Boolean newDiscardAfterDelete) {
        discardAfterDelete = newDiscardAfterDelete;
        return this;
    }
    
    
    public StorageDomainBuilder diskProfiles(List<DiskProfile> newDiskProfiles) {
        if (newDiskProfiles != null) {
            if (diskProfiles == null) {
                diskProfiles = new ArrayList<>(newDiskProfiles);
            }
            else {
                diskProfiles.addAll(newDiskProfiles);
            }
        }
        return this;
    }
    
    public StorageDomainBuilder diskProfiles(DiskProfile... newDiskProfiles) {
        if (newDiskProfiles != null) {
            if (diskProfiles == null) {
                diskProfiles = new ArrayList<>(newDiskProfiles.length);
            }
            Collections.addAll(diskProfiles, newDiskProfiles);
        }
        return this;
    }
    
    public StorageDomainBuilder diskProfiles(DiskProfileBuilder... newDiskProfiles) {
        if (newDiskProfiles != null) {
            if (diskProfiles == null) {
                diskProfiles = new ArrayList<>(newDiskProfiles.length);
            }
            for (DiskProfileBuilder builder : newDiskProfiles) {
                diskProfiles.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StorageDomainBuilder diskSnapshots(List<DiskSnapshot> newDiskSnapshots) {
        if (newDiskSnapshots != null) {
            if (diskSnapshots == null) {
                diskSnapshots = new ArrayList<>(newDiskSnapshots);
            }
            else {
                diskSnapshots.addAll(newDiskSnapshots);
            }
        }
        return this;
    }
    
    public StorageDomainBuilder diskSnapshots(DiskSnapshot... newDiskSnapshots) {
        if (newDiskSnapshots != null) {
            if (diskSnapshots == null) {
                diskSnapshots = new ArrayList<>(newDiskSnapshots.length);
            }
            Collections.addAll(diskSnapshots, newDiskSnapshots);
        }
        return this;
    }
    
    public StorageDomainBuilder diskSnapshots(DiskSnapshotBuilder... newDiskSnapshots) {
        if (newDiskSnapshots != null) {
            if (diskSnapshots == null) {
                diskSnapshots = new ArrayList<>(newDiskSnapshots.length);
            }
            for (DiskSnapshotBuilder builder : newDiskSnapshots) {
                diskSnapshots.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StorageDomainBuilder disks(List<Disk> newDisks) {
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
    
    public StorageDomainBuilder disks(Disk... newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks.length);
            }
            Collections.addAll(disks, newDisks);
        }
        return this;
    }
    
    public StorageDomainBuilder disks(DiskBuilder... newDisks) {
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
    
    
    public StorageDomainBuilder externalStatus(ExternalStatus newExternalStatus) {
        externalStatus = newExternalStatus;
        return this;
    }
    
    
    public StorageDomainBuilder files(List<File> newFiles) {
        if (newFiles != null) {
            if (files == null) {
                files = new ArrayList<>(newFiles);
            }
            else {
                files.addAll(newFiles);
            }
        }
        return this;
    }
    
    public StorageDomainBuilder files(File... newFiles) {
        if (newFiles != null) {
            if (files == null) {
                files = new ArrayList<>(newFiles.length);
            }
            Collections.addAll(files, newFiles);
        }
        return this;
    }
    
    public StorageDomainBuilder files(FileBuilder... newFiles) {
        if (newFiles != null) {
            if (files == null) {
                files = new ArrayList<>(newFiles.length);
            }
            for (FileBuilder builder : newFiles) {
                files.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StorageDomainBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public StorageDomainBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public StorageDomainBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public StorageDomainBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public StorageDomainBuilder images(List<Image> newImages) {
        if (newImages != null) {
            if (images == null) {
                images = new ArrayList<>(newImages);
            }
            else {
                images.addAll(newImages);
            }
        }
        return this;
    }
    
    public StorageDomainBuilder images(Image... newImages) {
        if (newImages != null) {
            if (images == null) {
                images = new ArrayList<>(newImages.length);
            }
            Collections.addAll(images, newImages);
        }
        return this;
    }
    
    public StorageDomainBuilder images(ImageBuilder... newImages) {
        if (newImages != null) {
            if (images == null) {
                images = new ArrayList<>(newImages.length);
            }
            for (ImageBuilder builder : newImages) {
                images.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StorageDomainBuilder import_(boolean newImport) {
        import_ = Boolean.valueOf(newImport);
        return this;
    }
    
    public StorageDomainBuilder import_(Boolean newImport) {
        import_ = newImport;
        return this;
    }
    
    
    public StorageDomainBuilder master(boolean newMaster) {
        master = Boolean.valueOf(newMaster);
        return this;
    }
    
    public StorageDomainBuilder master(Boolean newMaster) {
        master = newMaster;
        return this;
    }
    
    
    public StorageDomainBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public StorageDomainBuilder permissions(List<Permission> newPermissions) {
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
    
    public StorageDomainBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public StorageDomainBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public StorageDomainBuilder status(StorageDomainStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public StorageDomainBuilder storage(HostStorage newStorage) {
        storage = newStorage;
        return this;
    }
    
    public StorageDomainBuilder storage(HostStorageBuilder newStorage) {
        if (newStorage == null) {
            storage = null;
        }
        else {
            storage = newStorage.build();
        }
        return this;
    }
    
    
    public StorageDomainBuilder storageConnections(List<StorageConnection> newStorageConnections) {
        if (newStorageConnections != null) {
            if (storageConnections == null) {
                storageConnections = new ArrayList<>(newStorageConnections);
            }
            else {
                storageConnections.addAll(newStorageConnections);
            }
        }
        return this;
    }
    
    public StorageDomainBuilder storageConnections(StorageConnection... newStorageConnections) {
        if (newStorageConnections != null) {
            if (storageConnections == null) {
                storageConnections = new ArrayList<>(newStorageConnections.length);
            }
            Collections.addAll(storageConnections, newStorageConnections);
        }
        return this;
    }
    
    public StorageDomainBuilder storageConnections(StorageConnectionBuilder... newStorageConnections) {
        if (newStorageConnections != null) {
            if (storageConnections == null) {
                storageConnections = new ArrayList<>(newStorageConnections.length);
            }
            for (StorageConnectionBuilder builder : newStorageConnections) {
                storageConnections.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StorageDomainBuilder storageFormat(StorageFormat newStorageFormat) {
        storageFormat = newStorageFormat;
        return this;
    }
    
    
    public StorageDomainBuilder supportsDiscard(boolean newSupportsDiscard) {
        supportsDiscard = Boolean.valueOf(newSupportsDiscard);
        return this;
    }
    
    public StorageDomainBuilder supportsDiscard(Boolean newSupportsDiscard) {
        supportsDiscard = newSupportsDiscard;
        return this;
    }
    
    
    public StorageDomainBuilder supportsDiscardZeroesData(boolean newSupportsDiscardZeroesData) {
        supportsDiscardZeroesData = Boolean.valueOf(newSupportsDiscardZeroesData);
        return this;
    }
    
    public StorageDomainBuilder supportsDiscardZeroesData(Boolean newSupportsDiscardZeroesData) {
        supportsDiscardZeroesData = newSupportsDiscardZeroesData;
        return this;
    }
    
    
    public StorageDomainBuilder templates(List<Template> newTemplates) {
        if (newTemplates != null) {
            if (templates == null) {
                templates = new ArrayList<>(newTemplates);
            }
            else {
                templates.addAll(newTemplates);
            }
        }
        return this;
    }
    
    public StorageDomainBuilder templates(Template... newTemplates) {
        if (newTemplates != null) {
            if (templates == null) {
                templates = new ArrayList<>(newTemplates.length);
            }
            Collections.addAll(templates, newTemplates);
        }
        return this;
    }
    
    public StorageDomainBuilder templates(TemplateBuilder... newTemplates) {
        if (newTemplates != null) {
            if (templates == null) {
                templates = new ArrayList<>(newTemplates.length);
            }
            for (TemplateBuilder builder : newTemplates) {
                templates.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StorageDomainBuilder type(StorageDomainType newType) {
        type = newType;
        return this;
    }
    
    
    public StorageDomainBuilder used(int newUsed) {
        used = BigInteger.valueOf((long) newUsed);
        return this;
    }
    
    public StorageDomainBuilder used(Integer newUsed) {
        if (newUsed == null) {
            used = null;
        }
        else {
            used = BigInteger.valueOf(newUsed.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder used(long newUsed) {
        used = BigInteger.valueOf(newUsed);
        return this;
    }
    
    public StorageDomainBuilder used(Long newUsed) {
        if (newUsed == null) {
            used = null;
        }
        else {
            used = BigInteger.valueOf(newUsed.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder used(BigInteger newUsed) {
        used = newUsed;
        return this;
    }
    
    
    public StorageDomainBuilder vms(List<Vm> newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms);
            }
            else {
                vms.addAll(newVms);
            }
        }
        return this;
    }
    
    public StorageDomainBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public StorageDomainBuilder vms(VmBuilder... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            for (VmBuilder builder : newVms) {
                vms.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StorageDomainBuilder warningLowSpaceIndicator(int newWarningLowSpaceIndicator) {
        warningLowSpaceIndicator = BigInteger.valueOf((long) newWarningLowSpaceIndicator);
        return this;
    }
    
    public StorageDomainBuilder warningLowSpaceIndicator(Integer newWarningLowSpaceIndicator) {
        if (newWarningLowSpaceIndicator == null) {
            warningLowSpaceIndicator = null;
        }
        else {
            warningLowSpaceIndicator = BigInteger.valueOf(newWarningLowSpaceIndicator.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder warningLowSpaceIndicator(long newWarningLowSpaceIndicator) {
        warningLowSpaceIndicator = BigInteger.valueOf(newWarningLowSpaceIndicator);
        return this;
    }
    
    public StorageDomainBuilder warningLowSpaceIndicator(Long newWarningLowSpaceIndicator) {
        if (newWarningLowSpaceIndicator == null) {
            warningLowSpaceIndicator = null;
        }
        else {
            warningLowSpaceIndicator = BigInteger.valueOf(newWarningLowSpaceIndicator.longValue());
        }
        return this;
    }
    
    public StorageDomainBuilder warningLowSpaceIndicator(BigInteger newWarningLowSpaceIndicator) {
        warningLowSpaceIndicator = newWarningLowSpaceIndicator;
        return this;
    }
    
    
    public StorageDomainBuilder wipeAfterDelete(boolean newWipeAfterDelete) {
        wipeAfterDelete = Boolean.valueOf(newWipeAfterDelete);
        return this;
    }
    
    public StorageDomainBuilder wipeAfterDelete(Boolean newWipeAfterDelete) {
        wipeAfterDelete = newWipeAfterDelete;
        return this;
    }
    
    
    public StorageDomain build() {
        StorageDomainContainer container = new StorageDomainContainer();
        container.available(available);
        container.backup(backup);
        container.blockSize(blockSize);
        container.comment(comment);
        container.committed(committed);
        container.criticalSpaceActionBlocker(criticalSpaceActionBlocker);
        container.dataCenter(dataCenter);
        container.dataCenters(dataCenters);
        container.description(description);
        container.discardAfterDelete(discardAfterDelete);
        container.diskProfiles(diskProfiles);
        container.diskSnapshots(diskSnapshots);
        container.disks(disks);
        container.externalStatus(externalStatus);
        container.files(files);
        container.host(host);
        container.href(href);
        container.id(id);
        container.images(images);
        container.import_(import_);
        container.master(master);
        container.name(name);
        container.permissions(permissions);
        container.status(status);
        container.storage(storage);
        container.storageConnections(storageConnections);
        container.storageFormat(storageFormat);
        container.supportsDiscard(supportsDiscard);
        container.supportsDiscardZeroesData(supportsDiscardZeroesData);
        container.templates(templates);
        container.type(type);
        container.used(used);
        container.vms(vms);
        container.warningLowSpaceIndicator(warningLowSpaceIndicator);
        container.wipeAfterDelete(wipeAfterDelete);
        return container;
    }
}
