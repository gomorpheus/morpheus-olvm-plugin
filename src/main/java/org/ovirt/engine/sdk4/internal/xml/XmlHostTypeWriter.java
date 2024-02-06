/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HostType;

public class XmlHostTypeWriter {
    
    public static void writeOne(HostType object, XmlWriter writer) {
        writeOne(object, "host_type", writer);
    }
    
    public static void writeOne(HostType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<HostType> list, XmlWriter writer) {
        writeMany(list, "host_type", "host_types", writer);
    }
    
    public static void writeMany(Iterator<HostType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

