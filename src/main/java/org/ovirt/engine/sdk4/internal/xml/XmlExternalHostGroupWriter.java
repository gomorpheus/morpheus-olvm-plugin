/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalHostGroup;

public class XmlExternalHostGroupWriter {
    
    public static void writeOne(ExternalHostGroup object, XmlWriter writer) {
        writeOne(object, "external_host_group", writer);
    }
    
    public static void writeOne(ExternalHostGroup object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.architectureNamePresent()) {
            writer.writeElement("architecture_name", object.architectureName());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.domainNamePresent()) {
            writer.writeElement("domain_name", object.domainName());
        }
        if (object.externalHostProviderPresent()) {
            XmlExternalHostProviderWriter.writeOne(object.externalHostProvider(), "external_host_provider", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.operatingSystemNamePresent()) {
            writer.writeElement("operating_system_name", object.operatingSystemName());
        }
        if (object.subnetNamePresent()) {
            writer.writeElement("subnet_name", object.subnetName());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ExternalHostGroup> list, XmlWriter writer) {
        writeMany(list, "external_host_group", "external_host_groups", writer);
    }
    
    public static void writeMany(Iterator<ExternalHostGroup> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalHostGroupWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

