/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Statistic;

public class XmlStatisticWriter {
    
    public static void writeOne(Statistic object, XmlWriter writer) {
        writeOne(object, "statistic", writer);
    }
    
    public static void writeOne(Statistic object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.brickPresent()) {
            XmlGlusterBrickWriter.writeOne(object.brick(), "brick", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.diskPresent()) {
            XmlDiskWriter.writeOne(object.disk(), "disk", writer);
        }
        if (object.glusterVolumePresent()) {
            XmlGlusterVolumeWriter.writeOne(object.glusterVolume(), "gluster_volume", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.hostNicPresent()) {
            XmlHostNicWriter.writeOne(object.hostNic(), "host_nic", writer);
        }
        if (object.hostNumaNodePresent()) {
            XmlNumaNodeWriter.writeOne(object.hostNumaNode(), "host_numa_node", writer);
        }
        if (object.kindPresent()) {
            XmlStatisticKindWriter.writeOne(object.kind(), "kind", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.nicPresent()) {
            XmlNicWriter.writeOne(object.nic(), "nic", writer);
        }
        if (object.stepPresent()) {
            XmlStepWriter.writeOne(object.step(), "step", writer);
        }
        if (object.typePresent()) {
            XmlValueTypeWriter.writeOne(object.type(), "type", writer);
        }
        if (object.unitPresent()) {
            XmlStatisticUnitWriter.writeOne(object.unit(), "unit", writer);
        }
        if (object.valuesPresent()) {
            XmlValueWriter.writeMany(object.values().iterator(), "value", "values", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Statistic> list, XmlWriter writer) {
        writeMany(list, "statistic", "statistics", writer);
    }
    
    public static void writeMany(Iterator<Statistic> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStatisticWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

