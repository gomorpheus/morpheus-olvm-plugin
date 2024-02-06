/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.AuthorizedKey;

public class XmlAuthorizedKeyWriter {
    
    public static void writeOne(AuthorizedKey object, XmlWriter writer) {
        writeOne(object, "authorized_key", writer);
    }
    
    public static void writeOne(AuthorizedKey object, String tag, XmlWriter writer) {
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
        if (object.keyPresent()) {
            writer.writeElement("key", object.key());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<AuthorizedKey> list, XmlWriter writer) {
        writeMany(list, "authorized_key", "authorized_keys", writer);
    }
    
    public static void writeMany(Iterator<AuthorizedKey> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlAuthorizedKeyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

