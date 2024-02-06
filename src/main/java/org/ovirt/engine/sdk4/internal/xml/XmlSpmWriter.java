/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Spm;

public class XmlSpmWriter {
    
    public static void writeOne(Spm object, XmlWriter writer) {
        writeOne(object, "spm", writer);
    }
    
    public static void writeOne(Spm object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.priorityPresent()) {
            writer.writeInteger("priority", object.priority());
        }
        if (object.statusPresent()) {
            XmlSpmStatusWriter.writeOne(object.status(), "status", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Spm> list, XmlWriter writer) {
        writeMany(list, "spm", "spms", writer);
    }
    
    public static void writeMany(Iterator<Spm> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSpmWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

