/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MessageBrokerType;

public class XmlMessageBrokerTypeWriter {
    
    public static void writeOne(MessageBrokerType object, XmlWriter writer) {
        writeOne(object, "message_broker_type", writer);
    }
    
    public static void writeOne(MessageBrokerType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<MessageBrokerType> list, XmlWriter writer) {
        writeMany(list, "message_broker_type", "message_broker_types", writer);
    }
    
    public static void writeMany(Iterator<MessageBrokerType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMessageBrokerTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

