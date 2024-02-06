/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.QosType;

public class XmlQosTypeWriter {
    
    public static void writeOne(QosType object, XmlWriter writer) {
        writeOne(object, "qos_type", writer);
    }
    
    public static void writeOne(QosType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<QosType> list, XmlWriter writer) {
        writeMany(list, "qos_type", "qos_types", writer);
    }
    
    public static void writeMany(Iterator<QosType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlQosTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

