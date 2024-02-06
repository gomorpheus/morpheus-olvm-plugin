/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterServerHook;

public class XmlGlusterServerHookWriter {
    
    public static void writeOne(GlusterServerHook object, XmlWriter writer) {
        writeOne(object, "server_hook", writer);
    }
    
    public static void writeOne(GlusterServerHook object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.checksumPresent()) {
            writer.writeElement("checksum", object.checksum());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.contentTypePresent()) {
            XmlHookContentTypeWriter.writeOne(object.contentType(), "content_type", writer);
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
        if (object.statusPresent()) {
            XmlGlusterHookStatusWriter.writeOne(object.status(), "status", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GlusterServerHook> list, XmlWriter writer) {
        writeMany(list, "server_hook", "server_hooks", writer);
    }
    
    public static void writeMany(Iterator<GlusterServerHook> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterServerHookWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

