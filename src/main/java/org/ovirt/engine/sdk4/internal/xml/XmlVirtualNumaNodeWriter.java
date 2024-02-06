/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VirtualNumaNode;

public class XmlVirtualNumaNodeWriter {
    
    public static void writeOne(VirtualNumaNode object, XmlWriter writer) {
        writeOne(object, "vm_numa_node", writer);
    }
    
    public static void writeOne(VirtualNumaNode object, String tag, XmlWriter writer) {
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
        if (object.numaNodePinsPresent()) {
            XmlNumaNodePinWriter.writeMany(object.numaNodePins().iterator(), "numa_node_pin", "numa_node_pins", writer);
        }
        if (object.numaTuneModePresent()) {
            XmlNumaTuneModeWriter.writeOne(object.numaTuneMode(), "numa_tune_mode", writer);
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VirtualNumaNode> list, XmlWriter writer) {
        writeMany(list, "vm_numa_node", "vm_numa_nodes", writer);
    }
    
    public static void writeMany(Iterator<VirtualNumaNode> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVirtualNumaNodeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

