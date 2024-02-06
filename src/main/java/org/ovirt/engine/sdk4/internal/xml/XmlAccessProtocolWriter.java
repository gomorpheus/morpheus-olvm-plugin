/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.AccessProtocol;

public class XmlAccessProtocolWriter {
    
    public static void writeOne(AccessProtocol object, XmlWriter writer) {
        writeOne(object, "access_protocol", writer);
    }
    
    public static void writeOne(AccessProtocol object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<AccessProtocol> list, XmlWriter writer) {
        writeMany(list, "access_protocol", "access_protocols", writer);
    }
    
    public static void writeMany(Iterator<AccessProtocol> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlAccessProtocolWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

