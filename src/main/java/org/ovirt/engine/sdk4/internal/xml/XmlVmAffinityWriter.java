/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmAffinity;

public class XmlVmAffinityWriter {
    
    public static void writeOne(VmAffinity object, XmlWriter writer) {
        writeOne(object, "vm_affinity", writer);
    }
    
    public static void writeOne(VmAffinity object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<VmAffinity> list, XmlWriter writer) {
        writeMany(list, "vm_affinity", "vm_affinities", writer);
    }
    
    public static void writeMany(Iterator<VmAffinity> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmAffinityWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

