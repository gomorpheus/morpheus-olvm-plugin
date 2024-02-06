/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StorageConnectionExtension;

public class XmlStorageConnectionExtensionWriter {
    
    public static void writeOne(StorageConnectionExtension object, XmlWriter writer) {
        writeOne(object, "storage_connection_extension", writer);
    }
    
    public static void writeOne(StorageConnectionExtension object, String tag, XmlWriter writer) {
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
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.targetPresent()) {
            writer.writeElement("target", object.target());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<StorageConnectionExtension> list, XmlWriter writer) {
        writeMany(list, "storage_connection_extension", "storage_connection_extensions", writer);
    }
    
    public static void writeMany(Iterator<StorageConnectionExtension> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStorageConnectionExtensionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

