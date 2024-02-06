/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Property;

public class XmlPropertyWriter {
    
    public static void writeOne(Property object, XmlWriter writer) {
        writeOne(object, "property", writer);
    }
    
    public static void writeOne(Property object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.valuePresent()) {
            writer.writeElement("value", object.value());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Property> list, XmlWriter writer) {
        writeMany(list, "property", "properties", writer);
    }
    
    public static void writeMany(Iterator<Property> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPropertyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

