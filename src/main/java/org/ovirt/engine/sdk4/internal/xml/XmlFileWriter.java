/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.File;

public class XmlFileWriter {
    
    public static void writeOne(File object, XmlWriter writer) {
        writeOne(object, "file", writer);
    }
    
    public static void writeOne(File object, String tag, XmlWriter writer) {
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
        if (object.contentPresent()) {
            writer.writeElement("content", object.content());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.typePresent()) {
            writer.writeElement("type", object.type());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<File> list, XmlWriter writer) {
        writeMany(list, "file", "files", writer);
    }
    
    public static void writeMany(Iterator<File> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlFileWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

