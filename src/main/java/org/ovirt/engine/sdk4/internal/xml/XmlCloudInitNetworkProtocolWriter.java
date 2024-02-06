/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CloudInitNetworkProtocol;

public class XmlCloudInitNetworkProtocolWriter {
    
    public static void writeOne(CloudInitNetworkProtocol object, XmlWriter writer) {
        writeOne(object, "cloud_init_network_protocol", writer);
    }
    
    public static void writeOne(CloudInitNetworkProtocol object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<CloudInitNetworkProtocol> list, XmlWriter writer) {
        writeMany(list, "cloud_init_network_protocol", "cloud_init_network_protocols", writer);
    }
    
    public static void writeMany(Iterator<CloudInitNetworkProtocol> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCloudInitNetworkProtocolWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

