/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ImageFileType;

public class XmlImageFileTypeWriter {
    
    public static void writeOne(ImageFileType object, XmlWriter writer) {
        writeOne(object, "image_file_type", writer);
    }
    
    public static void writeOne(ImageFileType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ImageFileType> list, XmlWriter writer) {
        writeMany(list, "image_file_type", "image_file_types", writer);
    }
    
    public static void writeMany(Iterator<ImageFileType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlImageFileTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

