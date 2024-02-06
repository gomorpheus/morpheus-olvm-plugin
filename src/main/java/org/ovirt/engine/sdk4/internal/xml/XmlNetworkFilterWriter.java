/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NetworkFilter;

public class XmlNetworkFilterWriter {
    
    public static void writeOne(NetworkFilter object, XmlWriter writer) {
        writeOne(object, "network_filter", writer);
    }
    
    public static void writeOne(NetworkFilter object, String tag, XmlWriter writer) {
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
        if (object.versionPresent()) {
            XmlVersionWriter.writeOne(object.version(), "version", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<NetworkFilter> list, XmlWriter writer) {
        writeMany(list, "network_filter", "network_filters", writer);
    }
    
    public static void writeMany(Iterator<NetworkFilter> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNetworkFilterWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

