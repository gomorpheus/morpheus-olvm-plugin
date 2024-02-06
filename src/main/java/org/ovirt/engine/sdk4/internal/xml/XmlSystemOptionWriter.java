/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SystemOption;

public class XmlSystemOptionWriter {
    
    public static void writeOne(SystemOption object, XmlWriter writer) {
        writeOne(object, "system_option", writer);
    }
    
    public static void writeOne(SystemOption object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.valuesPresent()) {
            XmlSystemOptionValueWriter.writeMany(object.values().iterator(), "system_option_value", "values", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<SystemOption> list, XmlWriter writer) {
        writeMany(list, "system_option", "system_options", writer);
    }
    
    public static void writeMany(Iterator<SystemOption> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSystemOptionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

