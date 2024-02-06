/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.TimeZone;

public class XmlTimeZoneWriter {
    
    public static void writeOne(TimeZone object, XmlWriter writer) {
        writeOne(object, "time_zone", writer);
    }
    
    public static void writeOne(TimeZone object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.utcOffsetPresent()) {
            writer.writeElement("utc_offset", object.utcOffset());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<TimeZone> list, XmlWriter writer) {
        writeMany(list, "time_zone", "time_zones", writer);
    }
    
    public static void writeMany(Iterator<TimeZone> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlTimeZoneWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

