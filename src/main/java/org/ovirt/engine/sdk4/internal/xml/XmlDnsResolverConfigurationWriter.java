/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DnsResolverConfiguration;

public class XmlDnsResolverConfigurationWriter {
    
    public static void writeOne(DnsResolverConfiguration object, XmlWriter writer) {
        writeOne(object, "dns_resolver_configuration", writer);
    }
    
    public static void writeOne(DnsResolverConfiguration object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.nameServersPresent()) {
            writer.writeElements("name_servers", object.nameServers());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<DnsResolverConfiguration> list, XmlWriter writer) {
        writeMany(list, "dns_resolver_configuration", "dns_resolver_configurations", writer);
    }
    
    public static void writeMany(Iterator<DnsResolverConfiguration> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDnsResolverConfigurationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

