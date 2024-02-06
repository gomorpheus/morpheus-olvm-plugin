/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProviderType;

public class XmlOpenStackNetworkProviderTypeWriter {
    
    public static void writeOne(OpenStackNetworkProviderType object, XmlWriter writer) {
        writeOne(object, "open_stack_network_provider_type", writer);
    }
    
    public static void writeOne(OpenStackNetworkProviderType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<OpenStackNetworkProviderType> list, XmlWriter writer) {
        writeMany(list, "open_stack_network_provider_type", "open_stack_network_provider_types", writer);
    }
    
    public static void writeMany(Iterator<OpenStackNetworkProviderType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenStackNetworkProviderTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

