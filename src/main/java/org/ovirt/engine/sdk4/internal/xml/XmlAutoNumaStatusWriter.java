/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.AutoNumaStatus;

public class XmlAutoNumaStatusWriter {
    
    public static void writeOne(AutoNumaStatus object, XmlWriter writer) {
        writeOne(object, "auto_numa_status", writer);
    }
    
    public static void writeOne(AutoNumaStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<AutoNumaStatus> list, XmlWriter writer) {
        writeMany(list, "auto_numa_status", "auto_numa_statuss", writer);
    }
    
    public static void writeMany(Iterator<AutoNumaStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlAutoNumaStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

