/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Session;

public class XmlSessionWriter {
    
    public static void writeOne(Session object, XmlWriter writer) {
        writeOne(object, "session", writer);
    }
    
    public static void writeOne(Session object, String tag, XmlWriter writer) {
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
        if (object.consoleUserPresent()) {
            writer.writeBoolean("console_user", object.consoleUser());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.ipPresent()) {
            XmlIpWriter.writeOne(object.ip(), "ip", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.protocolPresent()) {
            writer.writeElement("protocol", object.protocol());
        }
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Session> list, XmlWriter writer) {
        writeMany(list, "session", "sessions", writer);
    }
    
    public static void writeMany(Iterator<Session> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSessionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

