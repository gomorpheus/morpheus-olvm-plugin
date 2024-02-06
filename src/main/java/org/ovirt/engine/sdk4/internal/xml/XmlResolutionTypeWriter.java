/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ResolutionType;

public class XmlResolutionTypeWriter {
    
    public static void writeOne(ResolutionType object, XmlWriter writer) {
        writeOne(object, "resolution_type", writer);
    }
    
    public static void writeOne(ResolutionType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ResolutionType> list, XmlWriter writer) {
        writeMany(list, "resolution_type", "resolution_types", writer);
    }
    
    public static void writeMany(Iterator<ResolutionType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlResolutionTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

