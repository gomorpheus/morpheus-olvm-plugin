/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Usb;

public class XmlUsbWriter {
    
    public static void writeOne(Usb object, XmlWriter writer) {
        writeOne(object, "usb", writer);
    }
    
    public static void writeOne(Usb object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        if (object.typePresent()) {
            XmlUsbTypeWriter.writeOne(object.type(), "type", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Usb> list, XmlWriter writer) {
        writeMany(list, "usb", "usbs", writer);
    }
    
    public static void writeMany(Iterator<Usb> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlUsbWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

