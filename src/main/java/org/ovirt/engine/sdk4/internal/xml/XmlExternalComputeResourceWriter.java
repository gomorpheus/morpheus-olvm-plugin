/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalComputeResource;

public class XmlExternalComputeResourceWriter {
    
    public static void writeOne(ExternalComputeResource object, XmlWriter writer) {
        writeOne(object, "external_compute_resource", writer);
    }
    
    public static void writeOne(ExternalComputeResource object, String tag, XmlWriter writer) {
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
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.providerPresent()) {
            writer.writeElement("provider", object.provider());
        }
        if (object.urlPresent()) {
            writer.writeElement("url", object.url());
        }
        if (object.userPresent()) {
            writer.writeElement("user", object.user());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ExternalComputeResource> list, XmlWriter writer) {
        writeMany(list, "external_compute_resource", "external_compute_resources", writer);
    }
    
    public static void writeMany(Iterator<ExternalComputeResource> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalComputeResourceWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

