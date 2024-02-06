/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalVmProviderType;

public class XmlExternalVmProviderTypeWriter {
    
    public static void writeOne(ExternalVmProviderType object, XmlWriter writer) {
        writeOne(object, "external_vm_provider_type", writer);
    }
    
    public static void writeOne(ExternalVmProviderType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ExternalVmProviderType> list, XmlWriter writer) {
        writeMany(list, "external_vm_provider_type", "external_vm_provider_types", writer);
    }
    
    public static void writeMany(Iterator<ExternalVmProviderType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalVmProviderTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

