/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.BootDevice;

public class XmlBootDeviceWriter {
    
    public static void writeOne(BootDevice object, XmlWriter writer) {
        writeOne(object, "boot_device", writer);
    }
    
    public static void writeOne(BootDevice object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<BootDevice> list, XmlWriter writer) {
        writeMany(list, "boot_device", "boot_devices", writer);
    }
    
    public static void writeMany(Iterator<BootDevice> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBootDeviceWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

