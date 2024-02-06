/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Version;

public class XmlVersionWriter {
    
    public static void writeOne(Version object, XmlWriter writer) {
        writeOne(object, "version", writer);
    }
    
    public static void writeOne(Version object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.buildPresent()) {
            writer.writeInteger("build", object.build());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.fullVersionPresent()) {
            writer.writeElement("full_version", object.fullVersion());
        }
        if (object.majorPresent()) {
            writer.writeInteger("major", object.major());
        }
        if (object.minorPresent()) {
            writer.writeInteger("minor", object.minor());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.revisionPresent()) {
            writer.writeInteger("revision", object.revision());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Version> list, XmlWriter writer) {
        writeMany(list, "version", "versions", writer);
    }
    
    public static void writeMany(Iterator<Version> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVersionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

