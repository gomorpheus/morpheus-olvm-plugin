/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.UsbType;

public class XmlUsbTypeWriter {
    
    public static void writeOne(UsbType object, XmlWriter writer) {
        writeOne(object, "usb_type", writer);
    }
    
    public static void writeOne(UsbType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<UsbType> list, XmlWriter writer) {
        writeMany(list, "usb_type", "usb_types", writer);
    }
    
    public static void writeMany(Iterator<UsbType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlUsbTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

