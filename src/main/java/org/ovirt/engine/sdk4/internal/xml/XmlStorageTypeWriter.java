/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StorageType;

public class XmlStorageTypeWriter {
    
    public static void writeOne(StorageType object, XmlWriter writer) {
        writeOne(object, "storage_type", writer);
    }
    
    public static void writeOne(StorageType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<StorageType> list, XmlWriter writer) {
        writeMany(list, "storage_type", "storage_types", writer);
    }
    
    public static void writeMany(Iterator<StorageType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStorageTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

