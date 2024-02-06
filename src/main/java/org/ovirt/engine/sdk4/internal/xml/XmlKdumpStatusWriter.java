/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.KdumpStatus;

public class XmlKdumpStatusWriter {
    
    public static void writeOne(KdumpStatus object, XmlWriter writer) {
        writeOne(object, "kdump_status", writer);
    }
    
    public static void writeOne(KdumpStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<KdumpStatus> list, XmlWriter writer) {
        writeMany(list, "kdump_status", "kdump_statuss", writer);
    }
    
    public static void writeMany(Iterator<KdumpStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlKdumpStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

