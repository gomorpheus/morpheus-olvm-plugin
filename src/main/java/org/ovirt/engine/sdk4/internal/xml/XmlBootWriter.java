/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Boot;

public class XmlBootWriter {
    
    public static void writeOne(Boot object, XmlWriter writer) {
        writeOne(object, "boot", writer);
    }
    
    public static void writeOne(Boot object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.devicesPresent()) {
            XmlBootDeviceWriter.writeMany(object.devices().iterator(), "device", "devices", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Boot> list, XmlWriter writer) {
        writeMany(list, "boot", "boots", writer);
    }
    
    public static void writeMany(Iterator<Boot> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBootWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

