/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalSystemType;

public class XmlExternalSystemTypeWriter {
    
    public static void writeOne(ExternalSystemType object, XmlWriter writer) {
        writeOne(object, "external_system_type", writer);
    }
    
    public static void writeOne(ExternalSystemType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ExternalSystemType> list, XmlWriter writer) {
        writeMany(list, "external_system_type", "external_system_types", writer);
    }
    
    public static void writeMany(Iterator<ExternalSystemType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalSystemTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

