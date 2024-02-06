/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Backup;

public class XmlBackupWriter {
    
    public static void writeOne(Backup object, XmlWriter writer) {
        writeOne(object, "backup", writer);
    }
    
    public static void writeOne(Backup object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.creationDatePresent()) {
            writer.writeDate("creation_date", object.creationDate());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.disksPresent()) {
            XmlDiskWriter.writeMany(object.disks().iterator(), "disk", "disks", writer);
        }
        if (object.fromCheckpointIdPresent()) {
            writer.writeElement("from_checkpoint_id", object.fromCheckpointId());
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.modificationDatePresent()) {
            writer.writeDate("modification_date", object.modificationDate());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.phasePresent()) {
            XmlBackupPhaseWriter.writeOne(object.phase(), "phase", writer);
        }
        if (object.toCheckpointIdPresent()) {
            writer.writeElement("to_checkpoint_id", object.toCheckpointId());
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Backup> list, XmlWriter writer) {
        writeMany(list, "backup", "backups", writer);
    }
    
    public static void writeMany(Iterator<Backup> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBackupWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

