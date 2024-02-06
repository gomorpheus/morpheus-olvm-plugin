/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalHost;

public class XmlExternalHostWriter {
    
    public static void writeOne(ExternalHost object, XmlWriter writer) {
        writeOne(object, "external_host", writer);
    }
    
    public static void writeOne(ExternalHost object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
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
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ExternalHost> list, XmlWriter writer) {
        writeMany(list, "external_host", "external_hosts", writer);
    }
    
    public static void writeMany(Iterator<ExternalHost> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalHostWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

