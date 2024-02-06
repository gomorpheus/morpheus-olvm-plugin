/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NotificationMethod;

public class XmlNotificationMethodWriter {
    
    public static void writeOne(NotificationMethod object, XmlWriter writer) {
        writeOne(object, "notification_method", writer);
    }
    
    public static void writeOne(NotificationMethod object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<NotificationMethod> list, XmlWriter writer) {
        writeMany(list, "notification_method", "notification_methods", writer);
    }
    
    public static void writeMany(Iterator<NotificationMethod> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNotificationMethodWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

