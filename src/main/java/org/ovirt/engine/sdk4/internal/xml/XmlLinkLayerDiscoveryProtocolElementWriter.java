/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.LinkLayerDiscoveryProtocolElement;

public class XmlLinkLayerDiscoveryProtocolElementWriter {
    
    public static void writeOne(LinkLayerDiscoveryProtocolElement object, XmlWriter writer) {
        writeOne(object, "link_layer_discovery_protocol_element", writer);
    }
    
    public static void writeOne(LinkLayerDiscoveryProtocolElement object, String tag, XmlWriter writer) {
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
        if (object.ouiPresent()) {
            writer.writeInteger("oui", object.oui());
        }
        if (object.propertiesPresent()) {
            XmlPropertyWriter.writeMany(object.properties().iterator(), "property", "properties", writer);
        }
        if (object.subtypePresent()) {
            writer.writeInteger("subtype", object.subtype());
        }
        if (object.typePresent()) {
            writer.writeInteger("type", object.type());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<LinkLayerDiscoveryProtocolElement> list, XmlWriter writer) {
        writeMany(list, "link_layer_discovery_protocol_element", "link_layer_discovery_protocol_elements", writer);
    }
    
    public static void writeMany(Iterator<LinkLayerDiscoveryProtocolElement> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlLinkLayerDiscoveryProtocolElementWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

