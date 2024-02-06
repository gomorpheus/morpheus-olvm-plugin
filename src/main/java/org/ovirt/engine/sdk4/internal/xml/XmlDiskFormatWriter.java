/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskFormat;

public class XmlDiskFormatWriter {
    
    public static void writeOne(DiskFormat object, XmlWriter writer) {
        writeOne(object, "disk_format", writer);
    }
    
    public static void writeOne(DiskFormat object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DiskFormat> list, XmlWriter writer) {
        writeMany(list, "disk_format", "disk_formats", writer);
    }
    
    public static void writeMany(Iterator<DiskFormat> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskFormatWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

