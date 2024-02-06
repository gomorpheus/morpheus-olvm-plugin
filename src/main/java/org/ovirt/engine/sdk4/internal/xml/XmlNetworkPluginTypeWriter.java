/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NetworkPluginType;

public class XmlNetworkPluginTypeWriter {
    
    public static void writeOne(NetworkPluginType object, XmlWriter writer) {
        writeOne(object, "network_plugin_type", writer);
    }
    
    public static void writeOne(NetworkPluginType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<NetworkPluginType> list, XmlWriter writer) {
        writeMany(list, "network_plugin_type", "network_plugin_types", writer);
    }
    
    public static void writeMany(Iterator<NetworkPluginType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNetworkPluginTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

