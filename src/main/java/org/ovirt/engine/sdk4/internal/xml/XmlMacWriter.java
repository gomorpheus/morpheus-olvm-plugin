/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Mac;

public class XmlMacWriter {
    
    public static void writeOne(Mac object, XmlWriter writer) {
        writeOne(object, "mac", writer);
    }
    
    public static void writeOne(Mac object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Mac> list, XmlWriter writer) {
        writeMany(list, "mac", "macs", writer);
    }
    
    public static void writeMany(Iterator<Mac> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMacWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

