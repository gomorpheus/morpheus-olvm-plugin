/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Checkpoint;

public class XmlCheckpointWriter {
    
    public static void writeOne(Checkpoint object, XmlWriter writer) {
        writeOne(object, "checkpoint", writer);
    }
    
    public static void writeOne(Checkpoint object, String tag, XmlWriter writer) {
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
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.parentIdPresent()) {
            writer.writeElement("parent_id", object.parentId());
        }
        if (object.statePresent()) {
            XmlCheckpointStateWriter.writeOne(object.state(), "state", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Checkpoint> list, XmlWriter writer) {
        writeMany(list, "checkpoint", "checkpoints", writer);
    }
    
    public static void writeMany(Iterator<Checkpoint> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCheckpointWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

