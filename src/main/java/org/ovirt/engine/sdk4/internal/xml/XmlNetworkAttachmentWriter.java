/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NetworkAttachment;

public class XmlNetworkAttachmentWriter {
    
    public static void writeOne(NetworkAttachment object, XmlWriter writer) {
        writeOne(object, "network_attachment", writer);
    }
    
    public static void writeOne(NetworkAttachment object, String tag, XmlWriter writer) {
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
        if (object.dnsResolverConfigurationPresent()) {
            XmlDnsResolverConfigurationWriter.writeOne(object.dnsResolverConfiguration(), "dns_resolver_configuration", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.hostNicPresent()) {
            XmlHostNicWriter.writeOne(object.hostNic(), "host_nic", writer);
        }
        if (object.inSyncPresent()) {
            writer.writeBoolean("in_sync", object.inSync());
        }
        if (object.ipAddressAssignmentsPresent()) {
            XmlIpAddressAssignmentWriter.writeMany(object.ipAddressAssignments().iterator(), "ip_address_assignment", "ip_address_assignments", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networkPresent()) {
            XmlNetworkWriter.writeOne(object.network(), "network", writer);
        }
        if (object.propertiesPresent()) {
            XmlPropertyWriter.writeMany(object.properties().iterator(), "property", "properties", writer);
        }
        if (object.qosPresent()) {
            XmlQosWriter.writeOne(object.qos(), "qos", writer);
        }
        if (object.reportedConfigurationsPresent()) {
            XmlReportedConfigurationWriter.writeMany(object.reportedConfigurations().iterator(), "reported_configuration", "reported_configurations", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<NetworkAttachment> list, XmlWriter writer) {
        writeMany(list, "network_attachment", "network_attachments", writer);
    }
    
    public static void writeMany(Iterator<NetworkAttachment> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNetworkAttachmentWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

