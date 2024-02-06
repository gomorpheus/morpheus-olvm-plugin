/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.TransportType;

public class XmlTransportTypeWriter {
    
    public static void writeOne(TransportType object, XmlWriter writer) {
        writeOne(object, "transport_type", writer);
    }
    
    public static void writeOne(TransportType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<TransportType> list, XmlWriter writer) {
        writeMany(list, "transport_type", "transport_types", writer);
    }
    
    public static void writeMany(Iterator<TransportType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlTransportTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

