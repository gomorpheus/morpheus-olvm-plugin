/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Icon;

public class XmlIconWriter {
    
    public static void writeOne(Icon object, XmlWriter writer) {
        writeOne(object, "icon", writer);
    }
    
    public static void writeOne(Icon object, String tag, XmlWriter writer) {
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
        if (object.dataPresent()) {
            writer.writeElement("data", object.data());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.mediaTypePresent()) {
            writer.writeElement("media_type", object.mediaType());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Icon> list, XmlWriter writer) {
        writeMany(list, "icon", "icons", writer);
    }
    
    public static void writeMany(Iterator<Icon> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlIconWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

