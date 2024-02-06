/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.IscsiBond;

public class XmlIscsiBondWriter {
    
    public static void writeOne(IscsiBond object, XmlWriter writer) {
        writeOne(object, "iscsi_bond", writer);
    }
    
    public static void writeOne(IscsiBond object, String tag, XmlWriter writer) {
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
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networksPresent()) {
            XmlNetworkWriter.writeMany(object.networks().iterator(), "network", "networks", writer);
        }
        if (object.storageConnectionsPresent()) {
            XmlStorageConnectionWriter.writeMany(object.storageConnections().iterator(), "storage_connection", "storage_connections", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<IscsiBond> list, XmlWriter writer) {
        writeMany(list, "iscsi_bond", "iscsi_bonds", writer);
    }
    
    public static void writeMany(Iterator<IscsiBond> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlIscsiBondWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

