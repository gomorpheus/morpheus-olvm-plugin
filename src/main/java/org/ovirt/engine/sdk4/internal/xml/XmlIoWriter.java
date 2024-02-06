/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Io;

public class XmlIoWriter {
    
    public static void writeOne(Io object, XmlWriter writer) {
        writeOne(object, "io", writer);
    }
    
    public static void writeOne(Io object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.threadsPresent()) {
            writer.writeInteger("threads", object.threads());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Io> list, XmlWriter writer) {
        writeMany(list, "io", "ios", writer);
    }
    
    public static void writeMany(Iterator<Io> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlIoWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

