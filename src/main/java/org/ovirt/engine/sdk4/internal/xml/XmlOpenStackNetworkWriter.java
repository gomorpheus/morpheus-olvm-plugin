/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenStackNetwork;

public class XmlOpenStackNetworkWriter {
    
    public static void writeOne(OpenStackNetwork object, XmlWriter writer) {
        writeOne(object, "openstack_network", writer);
    }
    
    public static void writeOne(OpenStackNetwork object, String tag, XmlWriter writer) {
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
        if (object.openstackNetworkProviderPresent()) {
            XmlOpenStackNetworkProviderWriter.writeOne(object.openstackNetworkProvider(), "openstack_network_provider", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OpenStackNetwork> list, XmlWriter writer) {
        writeMany(list, "openstack_network", "openstack_networks", writer);
    }
    
    public static void writeMany(Iterator<OpenStackNetwork> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenStackNetworkWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

