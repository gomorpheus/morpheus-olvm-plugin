/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskAttachment;

public class XmlDiskAttachmentWriter {
    
    public static void writeOne(DiskAttachment object, XmlWriter writer) {
        writeOne(object, "disk_attachment", writer);
    }
    
    public static void writeOne(DiskAttachment object, String tag, XmlWriter writer) {
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
        if (object.bootablePresent()) {
            writer.writeBoolean("bootable", object.bootable());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.diskPresent()) {
            XmlDiskWriter.writeOne(object.disk(), "disk", writer);
        }
        if (object.interface_Present()) {
            XmlDiskInterfaceWriter.writeOne(object.interface_(), "interface", writer);
        }
        if (object.logicalNamePresent()) {
            writer.writeElement("logical_name", object.logicalName());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.passDiscardPresent()) {
            writer.writeBoolean("pass_discard", object.passDiscard());
        }
        if (object.readOnlyPresent()) {
            writer.writeBoolean("read_only", object.readOnly());
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.usesScsiReservationPresent()) {
            writer.writeBoolean("uses_scsi_reservation", object.usesScsiReservation());
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<DiskAttachment> list, XmlWriter writer) {
        writeMany(list, "disk_attachment", "disk_attachments", writer);
    }
    
    public static void writeMany(Iterator<DiskAttachment> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskAttachmentWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

