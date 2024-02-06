/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Identified;

public class XmlIdentifiedWriter {
    
    public static void writeOne(Identified object, XmlWriter writer) {
        writeOne(object, "identified", writer);
    }
    
    public static void writeOne(Identified object, String tag, XmlWriter writer) {
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
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Identified> list, XmlWriter writer) {
        writeMany(list, "identified", "identifieds", writer);
    }
    
    public static void writeMany(Iterator<Identified> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlIdentifiedWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

