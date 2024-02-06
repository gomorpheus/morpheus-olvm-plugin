/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Vlan;

public class XmlVlanWriter {
    
    public static void writeOne(Vlan object, XmlWriter writer) {
        writeOne(object, "vlan", writer);
    }
    
    public static void writeOne(Vlan object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id().toString());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Vlan> list, XmlWriter writer) {
        writeMany(list, "vlan", "vlans", writer);
    }
    
    public static void writeMany(Iterator<Vlan> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVlanWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

