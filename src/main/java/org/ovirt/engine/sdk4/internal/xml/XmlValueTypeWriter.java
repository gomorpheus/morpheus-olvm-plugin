/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ValueType;

public class XmlValueTypeWriter {
    
    public static void writeOne(ValueType object, XmlWriter writer) {
        writeOne(object, "value_type", writer);
    }
    
    public static void writeOne(ValueType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ValueType> list, XmlWriter writer) {
        writeMany(list, "value_type", "value_types", writer);
    }
    
    public static void writeMany(Iterator<ValueType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlValueTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

