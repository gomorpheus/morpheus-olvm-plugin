/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Permit;

public class XmlPermitWriter {
    
    public static void writeOne(Permit object, XmlWriter writer) {
        writeOne(object, "permit", writer);
    }
    
    public static void writeOne(Permit object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.administrativePresent()) {
            writer.writeBoolean("administrative", object.administrative());
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
        if (object.rolePresent()) {
            XmlRoleWriter.writeOne(object.role(), "role", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Permit> list, XmlWriter writer) {
        writeMany(list, "permit", "permits", writer);
    }
    
    public static void writeMany(Iterator<Permit> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPermitWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

