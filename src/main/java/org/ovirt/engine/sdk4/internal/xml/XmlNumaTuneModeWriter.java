/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NumaTuneMode;

public class XmlNumaTuneModeWriter {
    
    public static void writeOne(NumaTuneMode object, XmlWriter writer) {
        writeOne(object, "numa_tune_mode", writer);
    }
    
    public static void writeOne(NumaTuneMode object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<NumaTuneMode> list, XmlWriter writer) {
        writeMany(list, "numa_tune_mode", "numa_tune_modes", writer);
    }
    
    public static void writeMany(Iterator<NumaTuneMode> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNumaTuneModeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

