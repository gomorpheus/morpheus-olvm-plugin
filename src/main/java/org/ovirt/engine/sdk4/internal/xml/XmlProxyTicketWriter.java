/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ProxyTicket;

public class XmlProxyTicketWriter {
    
    public static void writeOne(ProxyTicket object, XmlWriter writer) {
        writeOne(object, "proxy_ticket", writer);
    }
    
    public static void writeOne(ProxyTicket object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.valuePresent()) {
            writer.writeElement("value", object.value());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ProxyTicket> list, XmlWriter writer) {
        writeMany(list, "proxy_ticket", "proxy_tickets", writer);
    }
    
    public static void writeMany(Iterator<ProxyTicket> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlProxyTicketWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

