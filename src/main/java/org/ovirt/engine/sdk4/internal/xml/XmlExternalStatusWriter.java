/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalStatus;

public class XmlExternalStatusWriter {
    
    public static void writeOne(ExternalStatus object, XmlWriter writer) {
        writeOne(object, "external_status", writer);
    }
    
    public static void writeOne(ExternalStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ExternalStatus> list, XmlWriter writer) {
        writeMany(list, "external_status", "external_statuss", writer);
    }
    
    public static void writeMany(Iterator<ExternalStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

