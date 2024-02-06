/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.BiosType;

public class XmlBiosTypeWriter {
    
    public static void writeOne(BiosType object, XmlWriter writer) {
        writeOne(object, "bios_type", writer);
    }
    
    public static void writeOne(BiosType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<BiosType> list, XmlWriter writer) {
        writeMany(list, "bios_type", "bios_types", writer);
    }
    
    public static void writeMany(Iterator<BiosType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBiosTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

