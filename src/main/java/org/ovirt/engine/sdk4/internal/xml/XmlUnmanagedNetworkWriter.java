/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.UnmanagedNetwork;

public class XmlUnmanagedNetworkWriter {
    
    public static void writeOne(UnmanagedNetwork object, XmlWriter writer) {
        writeOne(object, "unmanaged_network", writer);
    }
    
    public static void writeOne(UnmanagedNetwork object, String tag, XmlWriter writer) {
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
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.hostNicPresent()) {
            XmlHostNicWriter.writeOne(object.hostNic(), "host_nic", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<UnmanagedNetwork> list, XmlWriter writer) {
        writeMany(list, "unmanaged_network", "unmanaged_networks", writer);
    }
    
    public static void writeMany(Iterator<UnmanagedNetwork> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlUnmanagedNetworkWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

