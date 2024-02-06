/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NotifiableEvent;

public class XmlNotifiableEventWriter {
    
    public static void writeOne(NotifiableEvent object, XmlWriter writer) {
        writeOne(object, "notifiable_event", writer);
    }
    
    public static void writeOne(NotifiableEvent object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<NotifiableEvent> list, XmlWriter writer) {
        writeMany(list, "notifiable_event", "notifiable_events", writer);
    }
    
    public static void writeMany(Iterator<NotifiableEvent> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNotifiableEventWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

