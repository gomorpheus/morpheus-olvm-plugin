/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmPoolType;

public class XmlVmPoolTypeWriter {
    
    public static void writeOne(VmPoolType object, XmlWriter writer) {
        writeOne(object, "vm_pool_type", writer);
    }
    
    public static void writeOne(VmPoolType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<VmPoolType> list, XmlWriter writer) {
        writeMany(list, "vm_pool_type", "vm_pool_types", writer);
    }
    
    public static void writeMany(Iterator<VmPoolType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmPoolTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

