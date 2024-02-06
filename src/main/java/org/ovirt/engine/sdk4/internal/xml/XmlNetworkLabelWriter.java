/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NetworkLabel;

public class XmlNetworkLabelWriter {
    
    public static void writeOne(NetworkLabel object, XmlWriter writer) {
        writeOne(object, "network_label", writer);
    }
    
    public static void writeOne(NetworkLabel object, String tag, XmlWriter writer) {
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
        if (object.hostNicPresent()) {
            XmlHostNicWriter.writeOne(object.hostNic(), "host_nic", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networkPresent()) {
            XmlNetworkWriter.writeOne(object.network(), "network", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<NetworkLabel> list, XmlWriter writer) {
        writeMany(list, "network_label", "network_labels", writer);
    }
    
    public static void writeMany(Iterator<NetworkLabel> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNetworkLabelWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

