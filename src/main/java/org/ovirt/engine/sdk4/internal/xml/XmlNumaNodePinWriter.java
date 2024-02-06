/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NumaNodePin;

public class XmlNumaNodePinWriter {
    
    public static void writeOne(NumaNodePin object, XmlWriter writer) {
        writeOne(object, "numa_node_pin", writer);
    }
    
    public static void writeOne(NumaNodePin object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hostNumaNodePresent()) {
            XmlNumaNodeWriter.writeOne(object.hostNumaNode(), "host_numa_node", writer);
        }
        if (object.indexPresent()) {
            writer.writeInteger("index", object.index());
        }
        if (object.pinnedPresent()) {
            writer.writeBoolean("pinned", object.pinned());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<NumaNodePin> list, XmlWriter writer) {
        writeMany(list, "numa_node_pin", "numa_node_pins", writer);
    }
    
    public static void writeMany(Iterator<NumaNodePin> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNumaNodePinWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

