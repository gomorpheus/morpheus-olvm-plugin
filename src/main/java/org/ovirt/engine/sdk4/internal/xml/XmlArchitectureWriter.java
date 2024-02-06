/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Architecture;

public class XmlArchitectureWriter {
    
    public static void writeOne(Architecture object, XmlWriter writer) {
        writeOne(object, "architecture", writer);
    }
    
    public static void writeOne(Architecture object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<Architecture> list, XmlWriter writer) {
        writeMany(list, "architecture", "architectures", writer);
    }
    
    public static void writeMany(Iterator<Architecture> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlArchitectureWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

