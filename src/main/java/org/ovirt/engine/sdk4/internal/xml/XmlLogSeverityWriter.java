/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.LogSeverity;

public class XmlLogSeverityWriter {
    
    public static void writeOne(LogSeverity object, XmlWriter writer) {
        writeOne(object, "log_severity", writer);
    }
    
    public static void writeOne(LogSeverity object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<LogSeverity> list, XmlWriter writer) {
        writeMany(list, "log_severity", "log_severities", writer);
    }
    
    public static void writeMany(Iterator<LogSeverity> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlLogSeverityWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

