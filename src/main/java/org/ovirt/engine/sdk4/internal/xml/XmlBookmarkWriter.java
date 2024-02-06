/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Bookmark;

public class XmlBookmarkWriter {
    
    public static void writeOne(Bookmark object, XmlWriter writer) {
        writeOne(object, "bookmark", writer);
    }
    
    public static void writeOne(Bookmark object, String tag, XmlWriter writer) {
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
        if (object.valuePresent()) {
            writer.writeElement("value", object.value());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Bookmark> list, XmlWriter writer) {
        writeMany(list, "bookmark", "bookmarks", writer);
    }
    
    public static void writeMany(Iterator<Bookmark> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBookmarkWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

