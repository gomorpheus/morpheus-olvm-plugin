/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Range;

public class XmlRangeWriter {
    
    public static void writeOne(Range object, XmlWriter writer) {
        writeOne(object, "range", writer);
    }
    
    public static void writeOne(Range object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.fromPresent()) {
            writer.writeElement("from", object.from());
        }
        if (object.toPresent()) {
            writer.writeElement("to", object.to());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Range> list, XmlWriter writer) {
        writeMany(list, "range", "ranges", writer);
    }
    
    public static void writeMany(Iterator<Range> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRangeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

