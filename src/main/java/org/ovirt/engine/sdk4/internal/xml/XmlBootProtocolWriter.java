/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.BootProtocol;

public class XmlBootProtocolWriter {
    
    public static void writeOne(BootProtocol object, XmlWriter writer) {
        writeOne(object, "boot_protocol", writer);
    }
    
    public static void writeOne(BootProtocol object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<BootProtocol> list, XmlWriter writer) {
        writeMany(list, "boot_protocol", "boot_protocols", writer);
    }
    
    public static void writeMany(Iterator<BootProtocol> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBootProtocolWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

