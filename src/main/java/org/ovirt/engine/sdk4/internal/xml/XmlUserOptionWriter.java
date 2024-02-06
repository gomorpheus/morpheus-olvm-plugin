/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.UserOption;

public class XmlUserOptionWriter {
    
    public static void writeOne(UserOption object, XmlWriter writer) {
        writeOne(object, "user_option", writer);
    }
    
    public static void writeOne(UserOption object, String tag, XmlWriter writer) {
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
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<UserOption> list, XmlWriter writer) {
        writeMany(list, "user_option", "user_options", writer);
    }
    
    public static void writeMany(Iterator<UserOption> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlUserOptionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

