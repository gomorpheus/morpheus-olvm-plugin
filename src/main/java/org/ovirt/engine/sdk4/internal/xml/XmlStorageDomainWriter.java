/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class XmlStorageDomainWriter {
    
    public static void writeOne(StorageDomain object, XmlWriter writer) {
        writeOne(object, "storage_domain", writer);
    }
    
    public static void writeOne(StorageDomain object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.availablePresent()) {
            writer.writeInteger("available", object.available());
        }
        if (object.backupPresent()) {
            writer.writeBoolean("backup", object.backup());
        }
        if (object.blockSizePresent()) {
            writer.writeInteger("block_size", object.blockSize());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.committedPresent()) {
            writer.writeInteger("committed", object.committed());
        }
        if (object.criticalSpaceActionBlockerPresent()) {
            writer.writeInteger("critical_space_action_blocker", object.criticalSpaceActionBlocker());
        }
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
        }
        if (object.dataCentersPresent()) {
            XmlDataCenterWriter.writeMany(object.dataCenters().iterator(), "data_center", "data_centers", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.discardAfterDeletePresent()) {
            writer.writeBoolean("discard_after_delete", object.discardAfterDelete());
        }
        if (object.diskProfilesPresent()) {
            XmlDiskProfileWriter.writeMany(object.diskProfiles().iterator(), "disk_profile", "disk_profiles", writer);
        }
        if (object.diskSnapshotsPresent()) {
            XmlDiskSnapshotWriter.writeMany(object.diskSnapshots().iterator(), "disk_snapshot", "disk_snapshots", writer);
        }
        if (object.disksPresent()) {
            XmlDiskWriter.writeMany(object.disks().iterator(), "disk", "disks", writer);
        }
        if (object.externalStatusPresent()) {
            XmlExternalStatusWriter.writeOne(object.externalStatus(), "external_status", writer);
        }
        if (object.filesPresent()) {
            XmlFileWriter.writeMany(object.files().iterator(), "file", "files", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.imagesPresent()) {
            XmlImageWriter.writeMany(object.images().iterator(), "image", "images", writer);
        }
        if (object.import_Present()) {
            writer.writeBoolean("import", object.import_());
        }
        if (object.masterPresent()) {
            writer.writeBoolean("master", object.master());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.statusPresent()) {
            XmlStorageDomainStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.storagePresent()) {
            XmlHostStorageWriter.writeOne(object.storage(), "storage", writer);
        }
        if (object.storageConnectionsPresent()) {
            XmlStorageConnectionWriter.writeMany(object.storageConnections().iterator(), "storage_connection", "storage_connections", writer);
        }
        if (object.storageFormatPresent()) {
            XmlStorageFormatWriter.writeOne(object.storageFormat(), "storage_format", writer);
        }
        if (object.supportsDiscardPresent()) {
            writer.writeBoolean("supports_discard", object.supportsDiscard());
        }
        if (object.supportsDiscardZeroesDataPresent()) {
            writer.writeBoolean("supports_discard_zeroes_data", object.supportsDiscardZeroesData());
        }
        if (object.templatesPresent()) {
            XmlTemplateWriter.writeMany(object.templates().iterator(), "template", "templates", writer);
        }
        if (object.typePresent()) {
            XmlStorageDomainTypeWriter.writeOne(object.type(), "type", writer);
        }
        if (object.usedPresent()) {
            writer.writeInteger("used", object.used());
        }
        if (object.vmsPresent()) {
            XmlVmWriter.writeMany(object.vms().iterator(), "vm", "vms", writer);
        }
        if (object.warningLowSpaceIndicatorPresent()) {
            writer.writeInteger("warning_low_space_indicator", object.warningLowSpaceIndicator());
        }
        if (object.wipeAfterDeletePresent()) {
            writer.writeBoolean("wipe_after_delete", object.wipeAfterDelete());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<StorageDomain> list, XmlWriter writer) {
        writeMany(list, "storage_domain", "storage_domains", writer);
    }
    
    public static void writeMany(Iterator<StorageDomain> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStorageDomainWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

