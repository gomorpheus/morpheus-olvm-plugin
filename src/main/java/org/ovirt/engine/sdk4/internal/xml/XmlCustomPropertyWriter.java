/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CustomProperty;

public class XmlCustomPropertyWriter {
    
    public static void writeOne(CustomProperty object, XmlWriter writer) {
        writeOne(object, "custom_property", writer);
    }
    
    public static void writeOne(CustomProperty object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.regexpPresent()) {
            writer.writeElement("regexp", object.regexp());
        }
        if (object.valuePresent()) {
            writer.writeElement("value", object.value());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<CustomProperty> list, XmlWriter writer) {
        writeMany(list, "custom_property", "custom_properties", writer);
    }
    
    public static void writeMany(Iterator<CustomProperty> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCustomPropertyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

