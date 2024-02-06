/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NetworkUsage;

public class XmlNetworkUsageWriter {
    
    public static void writeOne(NetworkUsage object, XmlWriter writer) {
        writeOne(object, "network_usage", writer);
    }
    
    public static void writeOne(NetworkUsage object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<NetworkUsage> list, XmlWriter writer) {
        writeMany(list, "network_usage", "network_usages", writer);
    }
    
    public static void writeMany(Iterator<NetworkUsage> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNetworkUsageWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

