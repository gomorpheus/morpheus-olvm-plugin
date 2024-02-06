/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterBrickMemoryInfo;

public class XmlGlusterBrickMemoryInfoWriter {
    
    public static void writeOne(GlusterBrickMemoryInfo object, XmlWriter writer) {
        writeOne(object, "brick_memoryinfo", writer);
    }
    
    public static void writeOne(GlusterBrickMemoryInfo object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.memoryPoolsPresent()) {
            XmlGlusterMemoryPoolWriter.writeMany(object.memoryPools().iterator(), "memory_pool", "memory_pools", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GlusterBrickMemoryInfo> list, XmlWriter writer) {
        writeMany(list, "brick_memoryinfo", "gluster_brick_memory_infos", writer);
    }
    
    public static void writeMany(Iterator<GlusterBrickMemoryInfo> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterBrickMemoryInfoWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

