/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenStackVolumeType;

public class XmlOpenStackVolumeTypeWriter {
    
    public static void writeOne(OpenStackVolumeType object, XmlWriter writer) {
        writeOne(object, "open_stack_volume_type", writer);
    }
    
    public static void writeOne(OpenStackVolumeType object, String tag, XmlWriter writer) {
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
        if (object.openstackVolumeProviderPresent()) {
            XmlOpenStackVolumeProviderWriter.writeOne(object.openstackVolumeProvider(), "openstack_volume_provider", writer);
        }
        if (object.propertiesPresent()) {
            XmlPropertyWriter.writeMany(object.properties().iterator(), "property", "properties", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OpenStackVolumeType> list, XmlWriter writer) {
        writeMany(list, "open_stack_volume_type", "open_stack_volume_types", writer);
    }
    
    public static void writeMany(Iterator<OpenStackVolumeType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenStackVolumeTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

