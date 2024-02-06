/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NetworkStatus;

public class XmlNetworkStatusWriter {
    
    public static void writeOne(NetworkStatus object, XmlWriter writer) {
        writeOne(object, "network_status", writer);
    }
    
    public static void writeOne(NetworkStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<NetworkStatus> list, XmlWriter writer) {
        writeMany(list, "network_status", "network_statuss", writer);
    }
    
    public static void writeMany(Iterator<NetworkStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNetworkStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

