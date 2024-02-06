/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalNetworkProviderConfiguration;

public class XmlExternalNetworkProviderConfigurationWriter {
    
    public static void writeOne(ExternalNetworkProviderConfiguration object, XmlWriter writer) {
        writeOne(object, "external_network_provider_configuration", writer);
    }
    
    public static void writeOne(ExternalNetworkProviderConfiguration object, String tag, XmlWriter writer) {
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
        if (object.externalNetworkProviderPresent()) {
            XmlExternalProviderWriter.writeOne(object.externalNetworkProvider(), "external_network_provider", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ExternalNetworkProviderConfiguration> list, XmlWriter writer) {
        writeMany(list, "external_network_provider_configuration", "external_network_provider_configurations", writer);
    }
    
    public static void writeMany(Iterator<ExternalNetworkProviderConfiguration> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalNetworkProviderConfigurationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

