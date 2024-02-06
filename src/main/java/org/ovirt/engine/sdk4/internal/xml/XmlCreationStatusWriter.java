/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CreationStatus;

public class XmlCreationStatusWriter {
    
    public static void writeOne(CreationStatus object, XmlWriter writer) {
        writeOne(object, "creation_status", writer);
    }
    
    public static void writeOne(CreationStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<CreationStatus> list, XmlWriter writer) {
        writeMany(list, "creation_status", "creation_statuss", writer);
    }
    
    public static void writeMany(Iterator<CreationStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCreationStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

