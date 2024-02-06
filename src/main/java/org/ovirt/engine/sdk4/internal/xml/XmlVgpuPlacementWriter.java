/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VgpuPlacement;

public class XmlVgpuPlacementWriter {
    
    public static void writeOne(VgpuPlacement object, XmlWriter writer) {
        writeOne(object, "vgpu_placement", writer);
    }
    
    public static void writeOne(VgpuPlacement object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<VgpuPlacement> list, XmlWriter writer) {
        writeMany(list, "vgpu_placement", "vgpu_placements", writer);
    }
    
    public static void writeMany(Iterator<VgpuPlacement> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVgpuPlacementWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

