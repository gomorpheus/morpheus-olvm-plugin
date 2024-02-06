/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NumaNode;

public class XmlNumaNodeWriter {
    
    public static void writeOne(NumaNode object, XmlWriter writer) {
        writeOne(object, "host_numa_node", writer);
    }
    
    public static void writeOne(NumaNode object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.cpuPresent()) {
            XmlCpuWriter.writeOne(object.cpu(), "cpu", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.indexPresent()) {
            writer.writeInteger("index", object.index());
        }
        if (object.memoryPresent()) {
            writer.writeInteger("memory", object.memory());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.nodeDistancePresent()) {
            writer.writeElement("node_distance", object.nodeDistance());
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<NumaNode> list, XmlWriter writer) {
        writeMany(list, "host_numa_node", "host_numa_nodes", writer);
    }
    
    public static void writeMany(Iterator<NumaNode> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNumaNodeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

