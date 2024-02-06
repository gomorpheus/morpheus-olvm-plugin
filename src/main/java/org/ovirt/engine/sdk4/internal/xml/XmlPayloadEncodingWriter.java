/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.PayloadEncoding;

public class XmlPayloadEncodingWriter {
    
    public static void writeOne(PayloadEncoding object, XmlWriter writer) {
        writeOne(object, "payload_encoding", writer);
    }
    
    public static void writeOne(PayloadEncoding object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<PayloadEncoding> list, XmlWriter writer) {
        writeMany(list, "payload_encoding", "payload_encodings", writer);
    }
    
    public static void writeMany(Iterator<PayloadEncoding> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPayloadEncodingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

