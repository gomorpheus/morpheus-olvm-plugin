/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StorageFormat;

public class XmlStorageFormatWriter {
    
    public static void writeOne(StorageFormat object, XmlWriter writer) {
        writeOne(object, "storage_format", writer);
    }
    
    public static void writeOne(StorageFormat object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<StorageFormat> list, XmlWriter writer) {
        writeMany(list, "storage_format", "storage_formats", writer);
    }
    
    public static void writeMany(Iterator<StorageFormat> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStorageFormatWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

