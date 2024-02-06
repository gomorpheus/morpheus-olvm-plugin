/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmDeviceType;

public class XmlVmDeviceTypeWriter {
    
    public static void writeOne(VmDeviceType object, XmlWriter writer) {
        writeOne(object, "vm_device_type", writer);
    }
    
    public static void writeOne(VmDeviceType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<VmDeviceType> list, XmlWriter writer) {
        writeMany(list, "vm_device_type", "vm_device_types", writer);
    }
    
    public static void writeMany(Iterator<VmDeviceType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmDeviceTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

