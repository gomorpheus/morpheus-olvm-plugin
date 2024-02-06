/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ConfigurationType;

public class XmlConfigurationTypeWriter {
    
    public static void writeOne(ConfigurationType object, XmlWriter writer) {
        writeOne(object, "configuration_type", writer);
    }
    
    public static void writeOne(ConfigurationType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ConfigurationType> list, XmlWriter writer) {
        writeMany(list, "configuration_type", "configuration_types", writer);
    }
    
    public static void writeMany(Iterator<ConfigurationType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlConfigurationTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

