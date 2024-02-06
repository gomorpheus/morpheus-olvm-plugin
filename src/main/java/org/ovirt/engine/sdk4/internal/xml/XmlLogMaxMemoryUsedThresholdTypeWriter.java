/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.LogMaxMemoryUsedThresholdType;

public class XmlLogMaxMemoryUsedThresholdTypeWriter {
    
    public static void writeOne(LogMaxMemoryUsedThresholdType object, XmlWriter writer) {
        writeOne(object, "log_max_memory_used_threshold_type", writer);
    }
    
    public static void writeOne(LogMaxMemoryUsedThresholdType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<LogMaxMemoryUsedThresholdType> list, XmlWriter writer) {
        writeMany(list, "log_max_memory_used_threshold_type", "log_max_memory_used_threshold_types", writer);
    }
    
    public static void writeMany(Iterator<LogMaxMemoryUsedThresholdType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlLogMaxMemoryUsedThresholdTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

