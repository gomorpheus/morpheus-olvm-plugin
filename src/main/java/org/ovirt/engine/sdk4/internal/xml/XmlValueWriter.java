/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Value;

public class XmlValueWriter {
    
    public static void writeOne(Value object, XmlWriter writer) {
        writeOne(object, "value", writer);
    }
    
    public static void writeOne(Value object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.datumPresent()) {
            writer.writeDecimal("datum", object.datum());
        }
        if (object.detailPresent()) {
            writer.writeElement("detail", object.detail());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Value> list, XmlWriter writer) {
        writeMany(list, "value", "values", writer);
    }
    
    public static void writeMany(Iterator<Value> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlValueWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

