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
import org.ovirt.engine.sdk4.internal.containers.DiskContainer;
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

public class DiskBuilder {
    private Boolean active;
    private BigInteger actualSize;
    private String alias;
    private DiskBackup backup;
    private DiskBackupMode backupMode;
    private Boolean bootable;
    private String comment;
    private DiskContentType contentType;
    private String description;
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
    
    public DiskBuilder active(boolean newActive) {
        active = Boolean.valueOf(newActive);
        return this;
    }
    
    public DiskBuilder active(Boolean newActive) {
        active = newActive;
        return this;
    }
    
    
    public DiskBuilder actualSize(int newActualSize) {
        actualSize = BigInteger.valueOf((long) newActualSize);
        return this;
    }
    
    public DiskBuilder actualSize(Integer newActualSize) {
        if (newActualSize == null) {
            actualSize = null;
        }
        else {
            actualSize = BigInteger.valueOf(newActualSize.longValue());
        }
        return this;
    }
    
    public DiskBuilder actualSize(long newActualSize) {
        actualSize = BigInteger.valueOf(newActualSize);
        return this;
    }
    
    public DiskBuilder actualSize(Long newActualSize) {
        if (newActualSize == null) {
            actualSize = null;
        }
        else {
            actualSize = BigInteger.valueOf(newActualSize.longValue());
        }
        return this;
    }
    
    public DiskBuilder actualSize(BigInteger newActualSize) {
        actualSize = newActualSize;
        return this;
    }
    
    
    public DiskBuilder alias(String newAlias) {
        alias = newAlias;
        return this;
    }
    
    
    public DiskBuilder backup(DiskBackup newBackup) {
        backup = newBackup;
        return this;
    }
    
    
    public DiskBuilder backupMode(DiskBackupMode newBackupMode) {
        backupMode = newBackupMode;
        return this;
    }
    
    
    public DiskBuilder bootable(boolean newBootable) {
        bootable = Boolean.valueOf(newBootable);
        return this;
    }
    
    public DiskBuilder bootable(Boolean newBootable) {
        bootable = newBootable;
        return this;
    }
    
    
    public DiskBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public DiskBuilder contentType(DiskContentType newContentType) {
        contentType = newContentType;
        return this;
    }
    
    
    public DiskBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public DiskBuilder diskProfile(DiskProfile newDiskProfile) {
        diskProfile = newDiskProfile;
        return this;
    }
    
    public DiskBuilder diskProfile(DiskProfileBuilder newDiskProfile) {
        if (newDiskProfile == null) {
            diskProfile = null;
        }
        else {
            diskProfile = newDiskProfile.build();
        }
        return this;
    }
    
    
    public DiskBuilder diskSnapshots(List<DiskSnapshot> newDiskSnapshots) {
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
    
    public DiskBuilder diskSnapshots(DiskSnapshot... newDiskSnapshots) {
        if (newDiskSnapshots != null) {
            if (diskSnapshots == null) {
                diskSnapshots = new ArrayList<>(newDiskSnapshots.length);
            }
            Collections.addAll(diskSnapshots, newDiskSnapshots);
        }
        return this;
    }
    
    public DiskBuilder diskSnapshots(DiskSnapshotBuilder... newDiskSnapshots) {
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
    
    
    public DiskBuilder externalDisk(String newExternalDisk) {
        externalDisk = newExternalDisk;
        return this;
    }
    
    
    public DiskBuilder format(DiskFormat newFormat) {
        format = newFormat;
        return this;
    }
    
    
    public DiskBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public DiskBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public DiskBuilder imageId(String newImageId) {
        imageId = newImageId;
        return this;
    }
    
    
    public DiskBuilder initialSize(int newInitialSize) {
        initialSize = BigInteger.valueOf((long) newInitialSize);
        return this;
    }
    
    public DiskBuilder initialSize(Integer newInitialSize) {
        if (newInitialSize == null) {
            initialSize = null;
        }
        else {
            initialSize = BigInteger.valueOf(newInitialSize.longValue());
        }
        return this;
    }
    
    public DiskBuilder initialSize(long newInitialSize) {
        initialSize = BigInteger.valueOf(newInitialSize);
        return this;
    }
    
    public DiskBuilder initialSize(Long newInitialSize) {
        if (newInitialSize == null) {
            initialSize = null;
        }
        else {
            initialSize = BigInteger.valueOf(newInitialSize.longValue());
        }
        return this;
    }
    
    public DiskBuilder initialSize(BigInteger newInitialSize) {
        initialSize = newInitialSize;
        return this;
    }
    
    
    public DiskBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public DiskBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public DiskBuilder interface_(DiskInterface newInterface) {
        interface_ = newInterface;
        return this;
    }
    
    
    public DiskBuilder logicalName(String newLogicalName) {
        logicalName = newLogicalName;
        return this;
    }
    
    
    public DiskBuilder lunStorage(HostStorage newLunStorage) {
        lunStorage = newLunStorage;
        return this;
    }
    
    public DiskBuilder lunStorage(HostStorageBuilder newLunStorage) {
        if (newLunStorage == null) {
            lunStorage = null;
        }
        else {
            lunStorage = newLunStorage.build();
        }
        return this;
    }
    
    
    public DiskBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public DiskBuilder openstackVolumeType(OpenStackVolumeType newOpenstackVolumeType) {
        openstackVolumeType = newOpenstackVolumeType;
        return this;
    }
    
    public DiskBuilder openstackVolumeType(OpenStackVolumeTypeBuilder newOpenstackVolumeType) {
        if (newOpenstackVolumeType == null) {
            openstackVolumeType = null;
        }
        else {
            openstackVolumeType = newOpenstackVolumeType.build();
        }
        return this;
    }
    
    
    public DiskBuilder permissions(List<Permission> newPermissions) {
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
    
    public DiskBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public DiskBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public DiskBuilder propagateErrors(boolean newPropagateErrors) {
        propagateErrors = Boolean.valueOf(newPropagateErrors);
        return this;
    }
    
    public DiskBuilder propagateErrors(Boolean newPropagateErrors) {
        propagateErrors = newPropagateErrors;
        return this;
    }
    
    
    public DiskBuilder provisionedSize(int newProvisionedSize) {
        provisionedSize = BigInteger.valueOf((long) newProvisionedSize);
        return this;
    }
    
    public DiskBuilder provisionedSize(Integer newProvisionedSize) {
        if (newProvisionedSize == null) {
            provisionedSize = null;
        }
        else {
            provisionedSize = BigInteger.valueOf(newProvisionedSize.longValue());
        }
        return this;
    }
    
    public DiskBuilder provisionedSize(long newProvisionedSize) {
        provisionedSize = BigInteger.valueOf(newProvisionedSize);
        return this;
    }
    
    public DiskBuilder provisionedSize(Long newProvisionedSize) {
        if (newProvisionedSize == null) {
            provisionedSize = null;
        }
        else {
            provisionedSize = BigInteger.valueOf(newProvisionedSize.longValue());
        }
        return this;
    }
    
    public DiskBuilder provisionedSize(BigInteger newProvisionedSize) {
        provisionedSize = newProvisionedSize;
        return this;
    }
    
    
    public DiskBuilder qcowVersion(QcowVersion newQcowVersion) {
        qcowVersion = newQcowVersion;
        return this;
    }
    
    
    public DiskBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public DiskBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public DiskBuilder readOnly(boolean newReadOnly) {
        readOnly = Boolean.valueOf(newReadOnly);
        return this;
    }
    
    public DiskBuilder readOnly(Boolean newReadOnly) {
        readOnly = newReadOnly;
        return this;
    }
    
    
    public DiskBuilder sgio(ScsiGenericIO newSgio) {
        sgio = newSgio;
        return this;
    }
    
    
    public DiskBuilder shareable(boolean newShareable) {
        shareable = Boolean.valueOf(newShareable);
        return this;
    }
    
    public DiskBuilder shareable(Boolean newShareable) {
        shareable = newShareable;
        return this;
    }
    
    
    public DiskBuilder snapshot(Snapshot newSnapshot) {
        snapshot = newSnapshot;
        return this;
    }
    
    public DiskBuilder snapshot(SnapshotBuilder newSnapshot) {
        if (newSnapshot == null) {
            snapshot = null;
        }
        else {
            snapshot = newSnapshot.build();
        }
        return this;
    }
    
    
    public DiskBuilder sparse(boolean newSparse) {
        sparse = Boolean.valueOf(newSparse);
        return this;
    }
    
    public DiskBuilder sparse(Boolean newSparse) {
        sparse = newSparse;
        return this;
    }
    
    
    public DiskBuilder statistics(List<Statistic> newStatistics) {
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
    
    public DiskBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public DiskBuilder statistics(StatisticBuilder... newStatistics) {
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
    
    
    public DiskBuilder status(DiskStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public DiskBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public DiskBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public DiskBuilder storageDomains(List<StorageDomain> newStorageDomains) {
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
    
    public DiskBuilder storageDomains(StorageDomain... newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains.length);
            }
            Collections.addAll(storageDomains, newStorageDomains);
        }
        return this;
    }
    
    public DiskBuilder storageDomains(StorageDomainBuilder... newStorageDomains) {
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
    
    
    public DiskBuilder storageType(DiskStorageType newStorageType) {
        storageType = newStorageType;
        return this;
    }
    
    
    public DiskBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public DiskBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public DiskBuilder totalSize(int newTotalSize) {
        totalSize = BigInteger.valueOf((long) newTotalSize);
        return this;
    }
    
    public DiskBuilder totalSize(Integer newTotalSize) {
        if (newTotalSize == null) {
            totalSize = null;
        }
        else {
            totalSize = BigInteger.valueOf(newTotalSize.longValue());
        }
        return this;
    }
    
    public DiskBuilder totalSize(long newTotalSize) {
        totalSize = BigInteger.valueOf(newTotalSize);
        return this;
    }
    
    public DiskBuilder totalSize(Long newTotalSize) {
        if (newTotalSize == null) {
            totalSize = null;
        }
        else {
            totalSize = BigInteger.valueOf(newTotalSize.longValue());
        }
        return this;
    }
    
    public DiskBuilder totalSize(BigInteger newTotalSize) {
        totalSize = newTotalSize;
        return this;
    }
    
    
    public DiskBuilder usesScsiReservation(boolean newUsesScsiReservation) {
        usesScsiReservation = Boolean.valueOf(newUsesScsiReservation);
        return this;
    }
    
    public DiskBuilder usesScsiReservation(Boolean newUsesScsiReservation) {
        usesScsiReservation = newUsesScsiReservation;
        return this;
    }
    
    
    public DiskBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public DiskBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public DiskBuilder vms(List<Vm> newVms) {
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
    
    public DiskBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public DiskBuilder vms(VmBuilder... newVms) {
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
    
    
    public DiskBuilder wipeAfterDelete(boolean newWipeAfterDelete) {
        wipeAfterDelete = Boolean.valueOf(newWipeAfterDelete);
        return this;
    }
    
    public DiskBuilder wipeAfterDelete(Boolean newWipeAfterDelete) {
        wipeAfterDelete = newWipeAfterDelete;
        return this;
    }
    
    
    public Disk build() {
        DiskContainer container = new DiskContainer();
        container.active(active);
        container.actualSize(actualSize);
        container.alias(alias);
        container.backup(backup);
        container.backupMode(backupMode);
        container.bootable(bootable);
        container.comment(comment);
        container.contentType(contentType);
        container.description(description);
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
