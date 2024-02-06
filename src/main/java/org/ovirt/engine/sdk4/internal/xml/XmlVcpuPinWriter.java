/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VcpuPin;

public class XmlVcpuPinWriter {
    
    public static void writeOne(VcpuPin object, XmlWriter writer) {
        writeOne(object, "vcpu_pin", writer);
    }
    
    public static void writeOne(VcpuPin object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.cpuSetPresent()) {
            writer.writeElement("cpu_set", object.cpuSet());
        }
        if (object.vcpuPresent()) {
            writer.writeInteger("vcpu", object.vcpu());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VcpuPin> list, XmlWriter writer) {
        writeMany(list, "vcpu_pin", "vcpu_pins", writer);
    }
    
    public static void writeMany(Iterator<VcpuPin> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVcpuPinWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

