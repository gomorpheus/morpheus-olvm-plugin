/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.FirewallType;

public class XmlFirewallTypeWriter {
    
    public static void writeOne(FirewallType object, XmlWriter writer) {
        writeOne(object, "firewall_type", writer);
    }
    
    public static void writeOne(FirewallType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<FirewallType> list, XmlWriter writer) {
        writeMany(list, "firewall_type", "firewall_types", writer);
    }
    
    public static void writeMany(Iterator<FirewallType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlFirewallTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

