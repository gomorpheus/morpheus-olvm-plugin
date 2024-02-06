/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.FenceType;

public class XmlFenceTypeWriter {
    
    public static void writeOne(FenceType object, XmlWriter writer) {
        writeOne(object, "fence_type", writer);
    }
    
    public static void writeOne(FenceType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<FenceType> list, XmlWriter writer) {
        writeMany(list, "fence_type", "fence_types", writer);
    }
    
    public static void writeMany(Iterator<FenceType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlFenceTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

