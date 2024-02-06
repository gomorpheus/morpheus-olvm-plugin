/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Core;

public class XmlCoreWriter {
    
    public static void writeOne(Core object, XmlWriter writer) {
        writeOne(object, "core", writer);
    }
    
    public static void writeOne(Core object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.indexPresent()) {
            writer.writeInteger("index", object.index());
        }
        if (object.socketPresent()) {
            writer.writeInteger("socket", object.socket());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Core> list, XmlWriter writer) {
        writeMany(list, "core", "cores", writer);
    }
    
    public static void writeMany(Iterator<Core> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCoreWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

