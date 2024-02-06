/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Tag;

public class XmlTagWriter {
    
    public static void writeOne(Tag object, XmlWriter writer) {
        writeOne(object, "tag", writer);
    }
    
    public static void writeOne(Tag object, String tag, XmlWriter writer) {
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
        if (object.groupPresent()) {
            XmlGroupWriter.writeOne(object.group(), "group", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.parentPresent()) {
            XmlTagWriter.writeOne(object.parent(), "parent", writer);
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Tag> list, XmlWriter writer) {
        writeMany(list, "tag", "tags", writer);
    }
    
    public static void writeMany(Iterator<Tag> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlTagWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

