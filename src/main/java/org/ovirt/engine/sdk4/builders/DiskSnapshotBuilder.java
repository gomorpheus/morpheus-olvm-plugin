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
import org.ovirt.engine.sdk4.internal.containers.DiskSnapshotContainer;
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
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.OpenStackVolumeType;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.QcowVersion;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.ScsiGenericIO;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class DiskSnapshotBuilder {
    private Boolean active;
    private BigInteger actualSize;
    private String alias;
    private DiskBackup backup;
    private DiskBackupMode backupMode;
    private Boolean bootable;
    private String comment;
    private DiskContentType contentType;
    private String description;
    private Disk disk;
    private DiskProfile diskProfile;
    private List<DiskSnapshot> diskSnapshots;
    private String externalDisk;
    private DiskFormat format;
    private String href;
    private String id;
    private String imageId;
    private BigInteger initialSize;
    private InstanceType instanceType;
    private DiskInterface interface_;
    private String logicalName;
    private HostStorage lunStorage;
    private String name;
    private OpenStackVolumeType openstackVolumeType;
    private DiskSnapshot parent;
    private List<Permission> permissions;
    private Boolean propagateErrors;
    private BigInteger provisionedSize;
    private QcowVersion qcowVersion;
    private Quota quota;
    private Boolean readOnly;
    private ScsiGenericIO sgio;
    private Boolean shareable;
    private Snapshot snapshot;
    private Boolean sparse;
    private List<Statistic> statistics;
    private DiskStatus status;
    private StorageDomain storageDomain;
    private List<StorageDomain> storageDomains;
    private DiskStorageType storageType;
    private Template template;
    private BigInteger totalSize;
    private Boolean usesScsiReservation;
    private Vm vm;
    private List<Vm> vms;
    private Boolean wipeAfterDelete;
    
    public DiskSnapshotBuilder active(boolean newActive) {
        active = Boolean.valueOf(newActive);
        return this;
    }
    
    public DiskSnapshotBuilder active(Boolean newActive) {
        active = newActive;
        return this;
    }
    
    
    public DiskSnapshotBuilder actualSize(int newActualSize) {
        actualSize = BigInteger.valueOf((long) newActualSize);
        return this;
    }
    
    public DiskSnapshotBuilder actualSize(Integer newActualSize) {
        if (newActualSize == null) {
            actualSize = null;
        }
        else {
            actualSize = BigInteger.valueOf(newActualSize.longValue());
        }
        return this;
    }
    
    public DiskSnapshotBuilder actualSize(long newActualSize) {
        actualSize = BigInteger.valueOf(newActualSize);
        return this;
    }
    
    public DiskSnapshotBuilder actualSize(Long newActualSize) {
        if (newActualSize == null) {
            actualSize = null;
        }
        else {
            actualSize = BigInteger.valueOf(newActualSize.longValue());
        }
        return this;
    }
    
    public DiskSnapshotBuilder actualSize(BigInteger newActualSize) {
        actualSize = newActualSize;
        return this;
    }
    
    
    public DiskSnapshotBuilder alias(String newAlias) {
        alias = newAlias;
        return this;
    }
    
    
    public DiskSnapshotBuilder backup(DiskBackup newBackup) {
        backup = newBackup;
        return this;
    }
    
    
    public DiskSnapshotBuilder backupMode(DiskBackupMode newBackupMode) {
        backupMode = newBackupMode;
        return this;
    }
    
    
    public DiskSnapshotBuilder bootable(boolean newBootable) {
        bootable = Boolean.valueOf(newBootable);
        return this;
    }
    
    public DiskSnapshotBuilder bootable(Boolean newBootable) {
        bootable = newBootable;
        return this;
    }
    
    
    public DiskSnapshotBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public DiskSnapshotBuilder contentType(DiskContentType newContentType) {
        contentType = newContentType;
        return this;
    }
    
    
    public DiskSnapshotBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public DiskSnapshotBuilder disk(Disk newDisk) {
        disk = newDisk;
        return this;
    }
    
    public DiskSnapshotBuilder disk(DiskBuilder newDisk) {
        if (newDisk == null) {
            disk = null;
        }
        else {
            disk = newDisk.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder diskProfile(DiskProfile newDiskProfile) {
        diskProfile = newDiskProfile;
        return this;
    }
    
    public DiskSnapshotBuilder diskProfile(DiskProfileBuilder newDiskProfile) {
        if (newDiskProfile == null) {
            diskProfile = null;
        }
        else {
            diskProfile = newDiskProfile.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder diskSnapshots(List<DiskSnapshot> newDiskSnapshots) {
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
    
    public DiskSnapshotBuilder diskSnapshots(DiskSnapshot... newDiskSnapshots) {
        if (newDiskSnapshots != null) {
            if (diskSnapshots == null) {
                diskSnapshots = new ArrayList<>(newDiskSnapshots.length);
            }
            Collections.addAll(diskSnapshots, newDiskSnapshots);
        }
        return this;
    }
    
    public DiskSnapshotBuilder diskSnapshots(DiskSnapshotBuilder... newDiskSnapshots) {
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
    
    
    public DiskSnapshotBuilder externalDisk(String newExternalDisk) {
        externalDisk = newExternalDisk;
        return this;
    }
    
    
    public DiskSnapshotBuilder format(DiskFormat newFormat) {
        format = newFormat;
        return this;
    }
    
    
    public DiskSnapshotBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public DiskSnapshotBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public DiskSnapshotBuilder imageId(String newImageId) {
        imageId = newImageId;
        return this;
    }
    
    
    public DiskSnapshotBuilder initialSize(int newInitialSize) {
        initialSize = BigInteger.valueOf((long) newInitialSize);
        return this;
    }
    
    public DiskSnapshotBuilder initialSize(Integer newInitialSize) {
        if (newInitialSize == null) {
            initialSize = null;
        }
        else {
            initialSize = BigInteger.valueOf(newInitialSize.longValue());
        }
        return this;
    }
    
    public DiskSnapshotBuilder initialSize(long newInitialSize) {
        initialSize = BigInteger.valueOf(newInitialSize);
        return this;
    }
    
    public DiskSnapshotBuilder initialSize(Long newInitialSize) {
        if (newInitialSize == null) {
            initialSize = null;
        }
        else {
            initialSize = BigInteger.valueOf(newInitialSize.longValue());
        }
        return this;
    }
    
    public DiskSnapshotBuilder initialSize(BigInteger newInitialSize) {
        initialSize = newInitialSize;
        return this;
    }
    
    
    public DiskSnapshotBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public DiskSnapshotBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder interface_(DiskInterface newInterface) {
        interface_ = newInterface;
        return this;
    }
    
    
    public DiskSnapshotBuilder logicalName(String newLogicalName) {
        logicalName = newLogicalName;
        return this;
    }
    
    
    public DiskSnapshotBuilder lunStorage(HostStorage newLunStorage) {
        lunStorage = newLunStorage;
        return this;
    }
    
    public DiskSnapshotBuilder lunStorage(HostStorageBuilder newLunStorage) {
        if (newLunStorage == null) {
            lunStorage = null;
        }
        else {
            lunStorage = newLunStorage.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public DiskSnapshotBuilder openstackVolumeType(OpenStackVolumeType newOpenstackVolumeType) {
        openstackVolumeType = newOpenstackVolumeType;
        return this;
    }
    
    public DiskSnapshotBuilder openstackVolumeType(OpenStackVolumeTypeBuilder newOpenstackVolumeType) {
        if (newOpenstackVolumeType == null) {
            openstackVolumeType = null;
        }
        else {
            openstackVolumeType = newOpenstackVolumeType.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder parent(DiskSnapshot newParent) {
        parent = newParent;
        return this;
    }
    
    public DiskSnapshotBuilder parent(DiskSnapshotBuilder newParent) {
        if (newParent == null) {
            parent = null;
        }
        else {
            parent = newParent.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder permissions(List<Permission> newPermissions) {
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
    
    public DiskSnapshotBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public DiskSnapshotBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public DiskSnapshotBuilder propagateErrors(boolean newPropagateErrors) {
        propagateErrors = Boolean.valueOf(newPropagateErrors);
        return this;
    }
    
    public DiskSnapshotBuilder propagateErrors(Boolean newPropagateErrors) {
        propagateErrors = newPropagateErrors;
        return this;
    }
    
    
    public DiskSnapshotBuilder provisionedSize(int newProvisionedSize) {
        provisionedSize = BigInteger.valueOf((long) newProvisionedSize);
        return this;
    }
    
    public DiskSnapshotBuilder provisionedSize(Integer newProvisionedSize) {
        if (newProvisionedSize == null) {
            provisionedSize = null;
        }
        else {
            provisionedSize = BigInteger.valueOf(newProvisionedSize.longValue());
        }
        return this;
    }
    
    public DiskSnapshotBuilder provisionedSize(long newProvisionedSize) {
        provisionedSize = BigInteger.valueOf(newProvisionedSize);
        return this;
    }
    
    public DiskSnapshotBuilder provisionedSize(Long newProvisionedSize) {
        if (newProvisionedSize == null) {
            provisionedSize = null;
        }
        else {
            provisionedSize = BigInteger.valueOf(newProvisionedSize.longValue());
        }
        return this;
    }
    
    public DiskSnapshotBuilder provisionedSize(BigInteger newProvisionedSize) {
        provisionedSize = newProvisionedSize;
        return this;
    }
    
    
    public DiskSnapshotBuilder qcowVersion(QcowVersion newQcowVersion) {
        qcowVersion = newQcowVersion;
        return this;
    }
    
    
    public DiskSnapshotBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public DiskSnapshotBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder readOnly(boolean newReadOnly) {
        readOnly = Boolean.valueOf(newReadOnly);
        return this;
    }
    
    public DiskSnapshotBuilder readOnly(Boolean newReadOnly) {
        readOnly = newReadOnly;
        return this;
    }
    
    
    public DiskSnapshotBuilder sgio(ScsiGenericIO newSgio) {
        sgio = newSgio;
        return this;
    }
    
    
    public DiskSnapshotBuilder shareable(boolean newShareable) {
        shareable = Boolean.valueOf(newShareable);
        return this;
    }
    
    public DiskSnapshotBuilder shareable(Boolean newShareable) {
        shareable = newShareable;
        return this;
    }
    
    
    public DiskSnapshotBuilder snapshot(Snapshot newSnapshot) {
        snapshot = newSnapshot;
        return this;
    }
    
    public DiskSnapshotBuilder snapshot(SnapshotBuilder newSnapshot) {
        if (newSnapshot == null) {
            snapshot = null;
        }
        else {
            snapshot = newSnapshot.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder sparse(boolean newSparse) {
        sparse = Boolean.valueOf(newSparse);
        return this;
    }
    
    public DiskSnapshotBuilder sparse(Boolean newSparse) {
        sparse = newSparse;
        return this;
    }
    
    
    public DiskSnapshotBuilder statistics(List<Statistic> newStatistics) {
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
    
    public DiskSnapshotBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public DiskSnapshotBuilder statistics(StatisticBuilder... newStatistics) {
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
    
    
    public DiskSnapshotBuilder status(DiskStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public DiskSnapshotBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public DiskSnapshotBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder storageDomains(List<StorageDomain> newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains);
            }
            else {
                storageDomains.addAll(newStorageDomains);
            }
        }
        return this;
    }
    
    public DiskSnapshotBuilder storageDomains(StorageDomain... newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains.length);
            }
            Collections.addAll(storageDomains, newStorageDomains);
        }
        return this;
    }
    
    public DiskSnapshotBuilder storageDomains(StorageDomainBuilder... newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains.length);
            }
            for (StorageDomainBuilder builder : newStorageDomains) {
                storageDomains.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder storageType(DiskStorageType newStorageType) {
        storageType = newStorageType;
        return this;
    }
    
    
    public DiskSnapshotBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public DiskSnapshotBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder totalSize(int newTotalSize) {
        totalSize = BigInteger.valueOf((long) newTotalSize);
        return this;
    }
    
    public DiskSnapshotBuilder totalSize(Integer newTotalSize) {
        if (newTotalSize == null) {
            totalSize = null;
        }
        else {
            totalSize = BigInteger.valueOf(newTotalSize.longValue());
        }
        return this;
    }
    
    public DiskSnapshotBuilder totalSize(long newTotalSize) {
        totalSize = BigInteger.valueOf(newTotalSize);
        return this;
    }
    
    public DiskSnapshotBuilder totalSize(Long newTotalSize) {
        if (newTotalSize == null) {
            totalSize = null;
        }
        else {
            totalSize = BigInteger.valueOf(newTotalSize.longValue());
        }
        return this;
    }
    
    public DiskSnapshotBuilder totalSize(BigInteger newTotalSize) {
        totalSize = newTotalSize;
        return this;
    }
    
    
    public DiskSnapshotBuilder usesScsiReservation(boolean newUsesScsiReservation) {
        usesScsiReservation = Boolean.valueOf(newUsesScsiReservation);
        return this;
    }
    
    public DiskSnapshotBuilder usesScsiReservation(Boolean newUsesScsiReservation) {
        usesScsiReservation = newUsesScsiReservation;
        return this;
    }
    
    
    public DiskSnapshotBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public DiskSnapshotBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public DiskSnapshotBuilder vms(List<Vm> newVms) {
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
    
    public DiskSnapshotBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public DiskSnapshotBuilder vms(VmBuilder... newVms) {
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
    
    
    public DiskSnapshotBuilder wipeAfterDelete(boolean newWipeAfterDelete) {
        wipeAfterDelete = Boolean.valueOf(newWipeAfterDelete);
        return this;
    }
    
    public DiskSnapshotBuilder wipeAfterDelete(Boolean newWipeAfterDelete) {
        wipeAfterDelete = newWipeAfterDelete;
        return this;
    }
    
    
    public DiskSnapshot build() {
        DiskSnapshotContainer container = new DiskSnapshotContainer();
        container.active(active);
        container.actualSize(actualSize);
        container.alias(alias);
        container.backup(backup);
        container.backupMode(backupMode);
        container.bootable(bootable);
        container.comment(comment);
        container.contentType(contentType);
        container.description(description);
        container.disk(disk);
        container.diskProfile(diskProfile);
        container.diskSnapshots(diskSnapshots);
        container.externalDisk(externalDisk);
        container.format(format);
        container.href(href);
        container.id(id);
        container.imageId(imageId);
        container.initialSize(initialSize);
        container.instanceType(instanceType);
        container.interface_(interface_);
        container.logicalName(logicalName);
        container.lunStorage(lunStorage);
        container.name(name);
        container.openstackVolumeType(openstackVolumeType);
        container.parent(parent);
        container.permissions(permissions);
        container.propagateErrors(propagateErrors);
        container.provisionedSize(provisionedSize);
        container.qcowVersion(qcowVersion);
        container.quota(quota);
        container.readOnly(readOnly);
        container.sgio(sgio);
        container.shareable(shareable);
        container.snapshot(snapshot);
        container.sparse(sparse);
        container.statistics(statistics);
        container.status(status);
        container.storageDomain(storageDomain);
        container.storageDomains(storageDomains);
        container.storageType(storageType);
        container.template(template);
        container.totalSize(totalSize);
        container.usesScsiReservation(usesScsiReservation);
        container.vm(vm);
        container.vms(vms);
        container.wipeAfterDelete(wipeAfterDelete);
        return container;
    }
}
