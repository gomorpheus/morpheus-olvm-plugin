/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskStorageType;

public class XmlDiskStorageTypeWriter {
    
    public static void writeOne(DiskStorageType object, XmlWriter writer) {
        writeOne(object, "disk_storage_type", writer);
    }
    
    public static void writeOne(DiskStorageType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DiskStorageType> list, XmlWriter writer) {
        writeMany(list, "disk_storage_type", "disk_storage_types", writer);
    }
    
    public static void writeMany(Iterator<DiskStorageType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskStorageTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

