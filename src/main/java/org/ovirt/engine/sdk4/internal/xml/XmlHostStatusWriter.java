/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HostStatus;

public class XmlHostStatusWriter {
    
    public static void writeOne(HostStatus object, XmlWriter writer) {
        writeOne(object, "host_status", writer);
    }
    
    public static void writeOne(HostStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<HostStatus> list, XmlWriter writer) {
        writeMany(list, "host_status", "host_statuss", writer);
    }
    
    public static void writeMany(Iterator<HostStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

