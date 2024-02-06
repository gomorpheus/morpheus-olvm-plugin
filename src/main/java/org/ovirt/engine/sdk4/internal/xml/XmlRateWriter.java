/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Rate;

public class XmlRateWriter {
    
    public static void writeOne(Rate object, XmlWriter writer) {
        writeOne(object, "rate", writer);
    }
    
    public static void writeOne(Rate object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.bytesPresent()) {
            writer.writeInteger("bytes", object.bytes());
        }
        if (object.periodPresent()) {
            writer.writeInteger("period", object.period());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Rate> list, XmlWriter writer) {
        writeMany(list, "rate", "rates", writer);
    }
    
    public static void writeMany(Iterator<Rate> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRateWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

