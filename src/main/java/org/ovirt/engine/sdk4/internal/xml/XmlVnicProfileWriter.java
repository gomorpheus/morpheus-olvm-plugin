/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VnicProfile;

public class XmlVnicProfileWriter {
    
    public static void writeOne(VnicProfile object, XmlWriter writer) {
        writeOne(object, "vnic_profile", writer);
    }
    
    public static void writeOne(VnicProfile object, String tag, XmlWriter writer) {
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
        if (object.customPropertiesPresent()) {
            XmlCustomPropertyWriter.writeMany(object.customProperties().iterator(), "custom_property", "custom_properties", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.failoverPresent()) {
            XmlVnicProfileWriter.writeOne(object.failover(), "failover", writer);
        }
        if (object.migratablePresent()) {
            writer.writeBoolean("migratable", object.migratable());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networkPresent()) {
            XmlNetworkWriter.writeOne(object.network(), "network", writer);
        }
        if (object.networkFilterPresent()) {
            XmlNetworkFilterWriter.writeOne(object.networkFilter(), "network_filter", writer);
        }
        if (object.passThroughPresent()) {
            XmlVnicPassThroughWriter.writeOne(object.passThrough(), "pass_through", writer);
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.portMirroringPresent()) {
            writer.writeBoolean("port_mirroring", object.portMirroring());
        }
        if (object.qosPresent()) {
            XmlQosWriter.writeOne(object.qos(), "qos", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VnicProfile> list, XmlWriter writer) {
        writeMany(list, "vnic_profile", "vnic_profiles", writer);
    }
    
    public static void writeMany(Iterator<VnicProfile> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVnicProfileWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

