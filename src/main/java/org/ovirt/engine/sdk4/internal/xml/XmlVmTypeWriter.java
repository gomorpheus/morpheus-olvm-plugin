/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmType;

public class XmlVmTypeWriter {
    
    public static void writeOne(VmType object, XmlWriter writer) {
        writeOne(object, "vm_type", writer);
    }
    
    public static void writeOne(VmType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<VmType> list, XmlWriter writer) {
        writeMany(list, "vm_type", "vm_types", writer);
    }
    
    public static void writeMany(Iterator<VmType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

