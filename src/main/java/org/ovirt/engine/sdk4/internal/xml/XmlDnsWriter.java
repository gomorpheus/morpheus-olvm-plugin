/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Dns;

public class XmlDnsWriter {
    
    public static void writeOne(Dns object, XmlWriter writer) {
        writeOne(object, "dns", writer);
    }
    
    public static void writeOne(Dns object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.searchDomainsPresent()) {
            XmlHostWriter.writeMany(object.searchDomains().iterator(), "host", "search_domains", writer);
        }
        if (object.serversPresent()) {
            XmlHostWriter.writeMany(object.servers().iterator(), "host", "servers", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Dns> list, XmlWriter writer) {
        writeMany(list, "dns", "dnss", writer);
    }
    
    public static void writeMany(Iterator<Dns> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDnsWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

