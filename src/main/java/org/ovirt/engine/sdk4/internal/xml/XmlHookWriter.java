/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Hook;

public class XmlHookWriter {
    
    public static void writeOne(Hook object, XmlWriter writer) {
        writeOne(object, "hook", writer);
    }
    
    public static void writeOne(Hook object, String tag, XmlWriter writer) {
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
        if (object.eventNamePresent()) {
            writer.writeElement("event_name", object.eventName());
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.md5Present()) {
            writer.writeElement("md5", object.md5());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Hook> list, XmlWriter writer) {
        writeMany(list, "hook", "hooks", writer);
    }
    
    public static void writeMany(Iterator<Hook> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHookWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

