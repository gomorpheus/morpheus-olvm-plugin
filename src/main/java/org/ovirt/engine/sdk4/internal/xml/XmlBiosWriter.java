/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Bios;

public class XmlBiosWriter {
    
    public static void writeOne(Bios object, XmlWriter writer) {
        writeOne(object, "bios", writer);
    }
    
    public static void writeOne(Bios object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.bootMenuPresent()) {
            XmlBootMenuWriter.writeOne(object.bootMenu(), "boot_menu", writer);
        }
        if (object.typePresent()) {
            XmlBiosTypeWriter.writeOne(object.type(), "type", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Bios> list, XmlWriter writer) {
        writeMany(list, "bios", "bioss", writer);
    }
    
    public static void writeMany(Iterator<Bios> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBiosWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

