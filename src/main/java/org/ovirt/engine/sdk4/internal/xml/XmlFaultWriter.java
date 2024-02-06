/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Fault;

public class XmlFaultWriter {
    
    public static void writeOne(Fault object, XmlWriter writer) {
        writeOne(object, "fault", writer);
    }
    
    public static void writeOne(Fault object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.detailPresent()) {
            writer.writeElement("detail", object.detail());
        }
        if (object.reasonPresent()) {
            writer.writeElement("reason", object.reason());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Fault> list, XmlWriter writer) {
        writeMany(list, "fault", "faults", writer);
    }
    
    public static void writeMany(Iterator<Fault> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlFaultWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

