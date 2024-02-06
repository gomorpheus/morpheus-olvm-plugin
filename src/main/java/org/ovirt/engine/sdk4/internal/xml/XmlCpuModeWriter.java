/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CpuMode;

public class XmlCpuModeWriter {
    
    public static void writeOne(CpuMode object, XmlWriter writer) {
        writeOne(object, "cpu_mode", writer);
    }
    
    public static void writeOne(CpuMode object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<CpuMode> list, XmlWriter writer) {
        writeMany(list, "cpu_mode", "cpu_modes", writer);
    }
    
    public static void writeMany(Iterator<CpuMode> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCpuModeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

