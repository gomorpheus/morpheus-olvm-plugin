/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalDiscoveredHost;

public class XmlExternalDiscoveredHostWriter {
    
    public static void writeOne(ExternalDiscoveredHost object, XmlWriter writer) {
        writeOne(object, "external_discovered_host", writer);
    }
    
    public static void writeOne(ExternalDiscoveredHost object, String tag, XmlWriter writer) {
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
        if (object.externalHostProviderPresent()) {
            XmlExternalHostProviderWriter.writeOne(object.externalHostProvider(), "external_host_provider", writer);
        }
        if (object.ipPresent()) {
            writer.writeElement("ip", object.ip());
        }
        if (object.lastReportPresent()) {
            writer.writeElement("last_report", object.lastReport());
        }
        if (object.macPresent()) {
            writer.writeElement("mac", object.mac());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.subnetNamePresent()) {
            writer.writeElement("subnet_name", object.subnetName());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ExternalDiscoveredHost> list, XmlWriter writer) {
        writeMany(list, "external_discovered_host", "external_discovered_hosts", writer);
    }
    
    public static void writeMany(Iterator<ExternalDiscoveredHost> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalDiscoveredHostWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

