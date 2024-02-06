/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NicConfiguration;

public class XmlNicConfigurationWriter {
    
    public static void writeOne(NicConfiguration object, XmlWriter writer) {
        writeOne(object, "nic_configuration", writer);
    }
    
    public static void writeOne(NicConfiguration object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.bootProtocolPresent()) {
            XmlBootProtocolWriter.writeOne(object.bootProtocol(), "boot_protocol", writer);
        }
        if (object.ipPresent()) {
            XmlIpWriter.writeOne(object.ip(), "ip", writer);
        }
        if (object.ipv6Present()) {
            XmlIpWriter.writeOne(object.ipv6(), "ipv6", writer);
        }
        if (object.ipv6BootProtocolPresent()) {
            XmlBootProtocolWriter.writeOne(object.ipv6BootProtocol(), "ipv6_boot_protocol", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.onBootPresent()) {
            writer.writeBoolean("on_boot", object.onBoot());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<NicConfiguration> list, XmlWriter writer) {
        writeMany(list, "nic_configuration", "nic_configurations", writer);
    }
    
    public static void writeMany(Iterator<NicConfiguration> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNicConfigurationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

