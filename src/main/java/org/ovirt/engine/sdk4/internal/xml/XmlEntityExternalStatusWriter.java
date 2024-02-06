/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.EntityExternalStatus;

public class XmlEntityExternalStatusWriter {
    
    public static void writeOne(EntityExternalStatus object, XmlWriter writer) {
        writeOne(object, "entity_external_status", writer);
    }
    
    public static void writeOne(EntityExternalStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<EntityExternalStatus> list, XmlWriter writer) {
        writeMany(list, "entity_external_status", "entity_external_statuss", writer);
    }
    
    public static void writeMany(Iterator<EntityExternalStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlEntityExternalStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

