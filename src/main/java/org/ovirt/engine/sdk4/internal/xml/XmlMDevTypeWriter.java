/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MDevType;

public class XmlMDevTypeWriter {
    
    public static void writeOne(MDevType object, XmlWriter writer) {
        writeOne(object, "m_dev_type", writer);
    }
    
    public static void writeOne(MDevType object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.availableInstancesPresent()) {
            writer.writeInteger("available_instances", object.availableInstances());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.humanReadableNamePresent()) {
            writer.writeElement("human_readable_name", object.humanReadableName());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<MDevType> list, XmlWriter writer) {
        writeMany(list, "m_dev_type", "m_dev_types", writer);
    }
    
    public static void writeMany(Iterator<MDevType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMDevTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

