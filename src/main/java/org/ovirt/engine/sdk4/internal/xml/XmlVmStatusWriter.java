/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmStatus;

public class XmlVmStatusWriter {
    
    public static void writeOne(VmStatus object, XmlWriter writer) {
        writeOne(object, "vm_status", writer);
    }
    
    public static void writeOne(VmStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<VmStatus> list, XmlWriter writer) {
        writeMany(list, "vm_status", "vm_statuss", writer);
    }
    
    public static void writeMany(Iterator<VmStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

