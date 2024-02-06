/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ReportedDevice;

public class XmlReportedDeviceWriter {
    
    public static void writeOne(ReportedDevice object, XmlWriter writer) {
        writeOne(object, "reported_device", writer);
    }
    
    public static void writeOne(ReportedDevice object, String tag, XmlWriter writer) {
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
        if (object.ipsPresent()) {
            XmlIpWriter.writeMany(object.ips().iterator(), "ip", "ips", writer);
        }
        if (object.macPresent()) {
            XmlMacWriter.writeOne(object.mac(), "mac", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.typePresent()) {
            XmlReportedDeviceTypeWriter.writeOne(object.type(), "type", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ReportedDevice> list, XmlWriter writer) {
        writeMany(list, "reported_device", "reported_devices", writer);
    }
    
    public static void writeMany(Iterator<ReportedDevice> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlReportedDeviceWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

