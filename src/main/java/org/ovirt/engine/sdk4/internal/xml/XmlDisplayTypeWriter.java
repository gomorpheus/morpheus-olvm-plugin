/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DisplayType;

public class XmlDisplayTypeWriter {
    
    public static void writeOne(DisplayType object, XmlWriter writer) {
        writeOne(object, "display_type", writer);
    }
    
    public static void writeOne(DisplayType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DisplayType> list, XmlWriter writer) {
        writeMany(list, "display_type", "display_types", writer);
    }
    
    public static void writeMany(Iterator<DisplayType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDisplayTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

