/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskStatus;

public class XmlDiskStatusWriter {
    
    public static void writeOne(DiskStatus object, XmlWriter writer) {
        writeOne(object, "disk_status", writer);
    }
    
    public static void writeOne(DiskStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DiskStatus> list, XmlWriter writer) {
        writeMany(list, "disk_status", "disk_statuss", writer);
    }
    
    public static void writeMany(Iterator<DiskStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

