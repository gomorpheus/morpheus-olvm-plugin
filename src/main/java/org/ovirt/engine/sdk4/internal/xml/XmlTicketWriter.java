/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Ticket;

public class XmlTicketWriter {
    
    public static void writeOne(Ticket object, XmlWriter writer) {
        writeOne(object, "ticket", writer);
    }
    
    public static void writeOne(Ticket object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.expiryPresent()) {
            writer.writeInteger("expiry", object.expiry());
        }
        if (object.valuePresent()) {
            writer.writeElement("value", object.value());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Ticket> list, XmlWriter writer) {
        writeMany(list, "ticket", "tickets", writer);
    }
    
    public static void writeMany(Iterator<Ticket> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlTicketWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

