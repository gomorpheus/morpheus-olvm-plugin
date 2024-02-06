/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskType;

public class XmlDiskTypeWriter {
    
    public static void writeOne(DiskType object, XmlWriter writer) {
        writeOne(object, "disk_type", writer);
    }
    
    public static void writeOne(DiskType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DiskType> list, XmlWriter writer) {
        writeMany(list, "disk_type", "disk_types", writer);
    }
    
    public static void writeMany(Iterator<DiskType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

