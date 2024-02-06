/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterMemoryPool;

public class XmlGlusterMemoryPoolWriter {
    
    public static void writeOne(GlusterMemoryPool object, XmlWriter writer) {
        writeOne(object, "memory_pool", writer);
    }
    
    public static void writeOne(GlusterMemoryPool object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.allocCountPresent()) {
            writer.writeInteger("alloc_count", object.allocCount());
        }
        if (object.coldCountPresent()) {
            writer.writeInteger("cold_count", object.coldCount());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.hotCountPresent()) {
            writer.writeInteger("hot_count", object.hotCount());
        }
        if (object.maxAllocPresent()) {
            writer.writeInteger("max_alloc", object.maxAlloc());
        }
        if (object.maxStdallocPresent()) {
            writer.writeInteger("max_stdalloc", object.maxStdalloc());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.paddedSizePresent()) {
            writer.writeInteger("padded_size", object.paddedSize());
        }
        if (object.poolMissesPresent()) {
            writer.writeInteger("pool_misses", object.poolMisses());
        }
        if (object.typePresent()) {
            writer.writeElement("type", object.type());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GlusterMemoryPool> list, XmlWriter writer) {
        writeMany(list, "memory_pool", "memory_pools", writer);
    }
    
    public static void writeMany(Iterator<GlusterMemoryPool> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterMemoryPoolWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

