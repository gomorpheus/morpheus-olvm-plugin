/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenStackSubnet;

public class XmlOpenStackSubnetWriter {
    
    public static void writeOne(OpenStackSubnet object, XmlWriter writer) {
        writeOne(object, "openstack_subnet", writer);
    }
    
    public static void writeOne(OpenStackSubnet object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.cidrPresent()) {
            writer.writeElement("cidr", object.cidr());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.dnsServersPresent()) {
            writer.writeElements("dns_servers", object.dnsServers());
        }
        if (object.gatewayPresent()) {
            writer.writeElement("gateway", object.gateway());
        }
        if (object.ipVersionPresent()) {
            writer.writeElement("ip_version", object.ipVersion());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.openstackNetworkPresent()) {
            XmlOpenStackNetworkWriter.writeOne(object.openstackNetwork(), "openstack_network", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OpenStackSubnet> list, XmlWriter writer) {
        writeMany(list, "openstack_subnet", "openstack_subnets", writer);
    }
    
    public static void writeMany(Iterator<OpenStackSubnet> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenStackSubnetWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

