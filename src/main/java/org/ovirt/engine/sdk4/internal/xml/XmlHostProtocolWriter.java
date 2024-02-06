/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HostProtocol;

public class XmlHostProtocolWriter {
    
    public static void writeOne(HostProtocol object, XmlWriter writer) {
        writeOne(object, "host_protocol", writer);
    }
    
    public static void writeOne(HostProtocol object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<HostProtocol> list, XmlWriter writer) {
        writeMany(list, "host_protocol", "host_protocols", writer);
    }
    
    public static void writeMany(Iterator<HostProtocol> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostProtocolWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

