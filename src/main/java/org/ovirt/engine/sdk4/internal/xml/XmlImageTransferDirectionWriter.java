/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ImageTransferDirection;

public class XmlImageTransferDirectionWriter {
    
    public static void writeOne(ImageTransferDirection object, XmlWriter writer) {
        writeOne(object, "image_transfer_direction", writer);
    }
    
    public static void writeOne(ImageTransferDirection object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ImageTransferDirection> list, XmlWriter writer) {
        writeMany(list, "image_transfer_direction", "image_transfer_directions", writer);
    }
    
    public static void writeMany(Iterator<ImageTransferDirection> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlImageTransferDirectionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

