/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Method;

public class XmlMethodWriter {
    
    public static void writeOne(Method object, XmlWriter writer) {
        writeOne(object, "method", writer);
    }
    
    public static void writeOne(Method object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id().value());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Method> list, XmlWriter writer) {
        writeMany(list, "method", "methods", writer);
    }
    
    public static void writeMany(Iterator<Method> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMethodWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

