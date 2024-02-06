/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.EventSubscription;

public class XmlEventSubscriptionWriter {
    
    public static void writeOne(EventSubscription object, XmlWriter writer) {
        writeOne(object, "event_subscription", writer);
    }
    
    public static void writeOne(EventSubscription object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.eventPresent()) {
            XmlNotifiableEventWriter.writeOne(object.event(), "event", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.notificationMethodPresent()) {
            XmlNotificationMethodWriter.writeOne(object.notificationMethod(), "notification_method", writer);
        }
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<EventSubscription> list, XmlWriter writer) {
        writeMany(list, "event_subscription", "event_subscriptions", writer);
    }
    
    public static void writeMany(Iterator<EventSubscription> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlEventSubscriptionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

