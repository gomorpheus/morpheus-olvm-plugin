/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CpuType;

public class XmlCpuTypeWriter {
    
    public static void writeOne(CpuType object, XmlWriter writer) {
        writeOne(object, "cpu_type", writer);
    }
    
    public static void writeOne(CpuType object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.architecturePresent()) {
            XmlArchitectureWriter.writeOne(object.architecture(), "architecture", writer);
        }
        if (object.levelPresent()) {
            writer.writeInteger("level", object.level());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<CpuType> list, XmlWriter writer) {
        writeMany(list, "cpu_type", "cpu_types", writer);
    }
    
    public static void writeMany(Iterator<CpuType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCpuTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

