/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Configuration;

public class XmlConfigurationWriter {
    
    public static void writeOne(Configuration object, XmlWriter writer) {
        writeOne(object, "configuration", writer);
    }
    
    public static void writeOne(Configuration object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.dataPresent()) {
            writer.writeElement("data", object.data());
        }
        if (object.typePresent()) {
            XmlConfigurationTypeWriter.writeOne(object.type(), "type", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Configuration> list, XmlWriter writer) {
        writeMany(list, "configuration", "configurations", writer);
    }
    
    public static void writeMany(Iterator<Configuration> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlConfigurationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

