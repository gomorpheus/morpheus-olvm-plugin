/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SerialNumberPolicy;

public class XmlSerialNumberPolicyWriter {
    
    public static void writeOne(SerialNumberPolicy object, XmlWriter writer) {
        writeOne(object, "serial_number_policy", writer);
    }
    
    public static void writeOne(SerialNumberPolicy object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<SerialNumberPolicy> list, XmlWriter writer) {
        writeMany(list, "serial_number_policy", "serial_number_policies", writer);
    }
    
    public static void writeMany(Iterator<SerialNumberPolicy> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSerialNumberPolicyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

