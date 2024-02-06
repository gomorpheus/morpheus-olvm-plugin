/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SystemOptionValue;

public class XmlSystemOptionValueWriter {
    
    public static void writeOne(SystemOptionValue object, XmlWriter writer) {
        writeOne(object, "system_option_value", writer);
    }
    
    public static void writeOne(SystemOptionValue object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.valuePresent()) {
            writer.writeElement("value", object.value());
        }
        if (object.versionPresent()) {
            writer.writeElement("version", object.version());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<SystemOptionValue> list, XmlWriter writer) {
        writeMany(list, "system_option_value", "system_option_values", writer);
    }
    
    public static void writeMany(Iterator<SystemOptionValue> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSystemOptionValueWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

