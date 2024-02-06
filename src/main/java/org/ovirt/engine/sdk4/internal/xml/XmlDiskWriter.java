/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Disk;

public class XmlDiskWriter {
    
    public static void writeOne(Disk object, XmlWriter writer) {
        writeOne(object, "disk", writer);
    }
    
    public static void writeOne(Disk object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.activePresent()) {
            writer.writeBoolean("active", object.active());
        }
        if (object.actualSizePresent()) {
            writer.writeInteger("actual_size", object.actualSize());
        }
        if (object.aliasPresent()) {
            writer.writeElement("alias", object.alias());
        }
        if (object.backupPresent()) {
            XmlDiskBackupWriter.writeOne(object.backup(), "backup", writer);
        }
        if (object.backupModePresent()) {
            XmlDiskBackupModeWriter.writeOne(object.backupMode(), "backup_mode", writer);
        }
        if (object.bootablePresent()) {
            writer.writeBoolean("bootable", object.bootable());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.contentTypePresent()) {
            XmlDiskContentTypeWriter.writeOne(object.contentType(), "content_type", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.diskProfilePresent()) {
            XmlDiskProfileWriter.writeOne(object.diskProfile(), "disk_profile", writer);
        }
        if (object.diskSnapshotsPresent()) {
            XmlDiskSnapshotWriter.writeMany(object.diskSnapshots().iterator(), "disk_snapshot", "disk_snapshots", writer);
        }
        if (object.externalDiskPresent()) {
            writer.writeElement("external_disk", object.externalDisk());
        }
        if (object.formatPresent()) {
            XmlDiskFormatWriter.writeOne(object.format(), "format", writer);
        }
        if (object.imageIdPresent()) {
            writer.writeElement("image_id", object.imageId());
        }
        if (object.initialSizePresent()) {
            writer.writeInteger("initial_size", object.initialSize());
        }
        if (object.instanceTypePresent()) {
            XmlInstanceTypeWriter.writeOne(object.instanceType(), "instance_type", writer);
        }
        if (object.interface_Present()) {
            XmlDiskInterfaceWriter.writeOne(object.interface_(), "interface", writer);
        }
        if (object.logicalNamePresent()) {
            writer.writeElement("logical_name", object.logicalName());
        }
        if (object.lunStoragePresent()) {
            XmlHostStorageWriter.writeOne(object.lunStorage(), "lun_storage", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.openstackVolumeTypePresent()) {
            XmlOpenStackVolumeTypeWriter.writeOne(object.openstackVolumeType(), "openstack_volume_type", writer);
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.propagateErrorsPresent()) {
            writer.writeBoolean("propagate_errors", object.propagateErrors());
        }
        if (object.provisionedSizePresent()) {
            writer.writeInteger("provisioned_size", object.provisionedSize());
        }
        if (object.qcowVersionPresent()) {
            XmlQcowVersionWriter.writeOne(object.qcowVersion(), "qcow_version", writer);
        }
        if (object.quotaPresent()) {
            XmlQuotaWriter.writeOne(object.quota(), "quota", writer);
        }
        if (object.readOnlyPresent()) {
            writer.writeBoolean("read_only", object.readOnly());
        }
        if (object.sgioPresent()) {
            XmlScsiGenericIOWriter.writeOne(object.sgio(), "sgio", writer);
        }
        if (object.shareablePresent()) {
            writer.writeBoolean("shareable", object.shareable());
        }
        if (object.snapshotPresent()) {
            XmlSnapshotWriter.writeOne(object.snapshot(), "snapshot", writer);
        }
        if (object.sparsePresent()) {
            writer.writeBoolean("sparse", object.sparse());
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        if (object.statusPresent()) {
            XmlDiskStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.storageDomainsPresent()) {
            XmlStorageDomainWriter.writeMany(object.storageDomains().iterator(), "storage_domain", "storage_domains", writer);
        }
        if (object.storageTypePresent()) {
            XmlDiskStorageTypeWriter.writeOne(object.storageType(), "storage_type", writer);
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.totalSizePresent()) {
            writer.writeInteger("total_size", object.totalSize());
        }
        if (object.usesScsiReservationPresent()) {
            writer.writeBoolean("uses_scsi_reservation", object.usesScsiReservation());
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        if (object.vmsPresent()) {
            XmlVmWriter.writeMany(object.vms().iterator(), "vm", "vms", writer);
        }
        if (object.wipeAfterDeletePresent()) {
            writer.writeBoolean("wipe_after_delete", object.wipeAfterDelete());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Disk> list, XmlWriter writer) {
        writeMany(list, "disk", "disks", writer);
    }
    
    public static void writeMany(Iterator<Disk> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

