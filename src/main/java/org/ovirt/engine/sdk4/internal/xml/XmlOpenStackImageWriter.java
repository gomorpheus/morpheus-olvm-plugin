/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenStackImage;

public class XmlOpenStackImageWriter {
    
    public static void writeOne(OpenStackImage object, XmlWriter writer) {
        writeOne(object, "openstack_image", writer);
    }
    
    public static void writeOne(OpenStackImage object, String tag, XmlWriter writer) {
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
        if (object.openstackImageProviderPresent()) {
            XmlOpenStackImageProviderWriter.writeOne(object.openstackImageProvider(), "openstack_image_provider", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OpenStackImage> list, XmlWriter writer) {
        writeMany(list, "openstack_image", "openstack_images", writer);
    }
    
    public static void writeMany(Iterator<OpenStackImage> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenStackImageWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

