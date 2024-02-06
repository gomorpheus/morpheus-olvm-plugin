/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OperatingSystemInfo;

public class XmlOperatingSystemInfoWriter {
    
    public static void writeOne(OperatingSystemInfo object, XmlWriter writer) {
        writeOne(object, "operating_system", writer);
    }
    
    public static void writeOne(OperatingSystemInfo object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.architecturePresent()) {
            XmlArchitectureWriter.writeOne(object.architecture(), "architecture", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.largeIconPresent()) {
            XmlIconWriter.writeOne(object.largeIcon(), "large_icon", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.smallIconPresent()) {
            XmlIconWriter.writeOne(object.smallIcon(), "small_icon", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OperatingSystemInfo> list, XmlWriter writer) {
        writeMany(list, "operating_system", "operation_systems", writer);
    }
    
    public static void writeMany(Iterator<OperatingSystemInfo> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOperatingSystemInfoWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

