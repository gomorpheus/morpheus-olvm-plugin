/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Role;

public class XmlRoleWriter {
    
    public static void writeOne(Role object, XmlWriter writer) {
        writeOne(object, "role", writer);
    }
    
    public static void writeOne(Role object, String tag, XmlWriter writer) {
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
        if (object.mutablePresent()) {
            writer.writeBoolean("mutable", object.mutable());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.permitsPresent()) {
            XmlPermitWriter.writeMany(object.permits().iterator(), "permit", "permits", writer);
        }
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Role> list, XmlWriter writer) {
        writeMany(list, "role", "roles", writer);
    }
    
    public static void writeMany(Iterator<Role> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRoleWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

