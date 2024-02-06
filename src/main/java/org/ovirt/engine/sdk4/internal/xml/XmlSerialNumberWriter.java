/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SerialNumber;

public class XmlSerialNumberWriter {
    
    public static void writeOne(SerialNumber object, XmlWriter writer) {
        writeOne(object, "serial_number", writer);
    }
    
    public static void writeOne(SerialNumber object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.policyPresent()) {
            XmlSerialNumberPolicyWriter.writeOne(object.policy(), "policy", writer);
        }
        if (object.valuePresent()) {
            writer.writeElement("value", object.value());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<SerialNumber> list, XmlWriter writer) {
        writeMany(list, "serial_number", "serial_numbers", writer);
    }
    
    public static void writeMany(Iterator<SerialNumber> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSerialNumberWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

