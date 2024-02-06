/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HighAvailability;

public class XmlHighAvailabilityWriter {
    
    public static void writeOne(HighAvailability object, XmlWriter writer) {
        writeOne(object, "high_availability", writer);
    }
    
    public static void writeOne(HighAvailability object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        if (object.priorityPresent()) {
            writer.writeInteger("priority", object.priority());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<HighAvailability> list, XmlWriter writer) {
        writeMany(list, "high_availability", "high_availabilities", writer);
    }
    
    public static void writeMany(Iterator<HighAvailability> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHighAvailabilityWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

