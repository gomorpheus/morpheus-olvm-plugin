/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Domain;

public class XmlDomainWriter {
    
    public static void writeOne(Domain object, XmlWriter writer) {
        writeOne(object, "domain", writer);
    }
    
    public static void writeOne(Domain object, String tag, XmlWriter writer) {
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
        if (object.groupsPresent()) {
            XmlGroupWriter.writeMany(object.groups().iterator(), "group", "groups", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        if (object.usersPresent()) {
            XmlUserWriter.writeMany(object.users().iterator(), "user", "users", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Domain> list, XmlWriter writer) {
        writeMany(list, "domain", "domains", writer);
    }
    
    public static void writeMany(Iterator<Domain> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDomainWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

