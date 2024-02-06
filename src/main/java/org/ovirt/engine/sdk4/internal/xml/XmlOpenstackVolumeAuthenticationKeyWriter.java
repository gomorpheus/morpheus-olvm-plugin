/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenstackVolumeAuthenticationKey;

public class XmlOpenstackVolumeAuthenticationKeyWriter {
    
    public static void writeOne(OpenstackVolumeAuthenticationKey object, XmlWriter writer) {
        writeOne(object, "openstack_volume_authentication_key", writer);
    }
    
    public static void writeOne(OpenstackVolumeAuthenticationKey object, String tag, XmlWriter writer) {
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
        if (object.creationDatePresent()) {
            writer.writeDate("creation_date", object.creationDate());
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
        if (object.usageTypePresent()) {
            XmlOpenstackVolumeAuthenticationKeyUsageTypeWriter.writeOne(object.usageType(), "usage_type", writer);
        }
        if (object.uuidPresent()) {
            writer.writeElement("uuid", object.uuid());
        }
        if (object.valuePresent()) {
            writer.writeElement("value", object.value());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OpenstackVolumeAuthenticationKey> list, XmlWriter writer) {
        writeMany(list, "openstack_volume_authentication_key", "openstack_volume_authentication_keys", writer);
    }
    
    public static void writeMany(Iterator<OpenstackVolumeAuthenticationKey> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenstackVolumeAuthenticationKeyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

