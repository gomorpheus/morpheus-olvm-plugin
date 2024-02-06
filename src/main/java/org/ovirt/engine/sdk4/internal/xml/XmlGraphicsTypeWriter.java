/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GraphicsType;

public class XmlGraphicsTypeWriter {
    
    public static void writeOne(GraphicsType object, XmlWriter writer) {
        writeOne(object, "graphics_type", writer);
    }
    
    public static void writeOne(GraphicsType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<GraphicsType> list, XmlWriter writer) {
        writeMany(list, "graphics_type", "graphics_types", writer);
    }
    
    public static void writeMany(Iterator<GraphicsType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGraphicsTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

