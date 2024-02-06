/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskContentType;

public class XmlDiskContentTypeWriter {
    
    public static void writeOne(DiskContentType object, XmlWriter writer) {
        writeOne(object, "disk_content_type", writer);
    }
    
    public static void writeOne(DiskContentType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DiskContentType> list, XmlWriter writer) {
        writeMany(list, "disk_content_type", "disk_content_types", writer);
    }
    
    public static void writeMany(Iterator<DiskContentType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskContentTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

