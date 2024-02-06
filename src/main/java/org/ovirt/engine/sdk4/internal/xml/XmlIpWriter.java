/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Ip;

public class XmlIpWriter {
    
    public static void writeOne(Ip object, XmlWriter writer) {
        writeOne(object, "ip", writer);
    }
    
    public static void writeOne(Ip object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        if (object.gatewayPresent()) {
            writer.writeElement("gateway", object.gateway());
        }
        if (object.netmaskPresent()) {
            writer.writeElement("netmask", object.netmask());
        }
        if (object.versionPresent()) {
            XmlIpVersionWriter.writeOne(object.version(), "version", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Ip> list, XmlWriter writer) {
        writeMany(list, "ip", "ips", writer);
    }
    
    public static void writeMany(Iterator<Ip> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlIpWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

