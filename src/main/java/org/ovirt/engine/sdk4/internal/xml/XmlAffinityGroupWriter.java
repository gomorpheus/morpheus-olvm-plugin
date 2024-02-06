/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.AffinityGroup;

public class XmlAffinityGroupWriter {
    
    public static void writeOne(AffinityGroup object, XmlWriter writer) {
        writeOne(object, "affinity_group", writer);
    }
    
    public static void writeOne(AffinityGroup object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.brokenPresent()) {
            writer.writeBoolean("broken", object.broken());
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.enforcingPresent()) {
            writer.writeBoolean("enforcing", object.enforcing());
        }
        if (object.hostLabelsPresent()) {
            XmlAffinityLabelWriter.writeMany(object.hostLabels().iterator(), "affinity_label", "host_labels", writer);
        }
        if (object.hostsPresent()) {
            XmlHostWriter.writeMany(object.hosts().iterator(), "host", "hosts", writer);
        }
        if (object.hostsRulePresent()) {
            XmlAffinityRuleWriter.writeOne(object.hostsRule(), "hosts_rule", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.positivePresent()) {
            writer.writeBoolean("positive", object.positive());
        }
        if (object.priorityPresent()) {
            writer.writeDecimal("priority", object.priority());
        }
        if (object.vmLabelsPresent()) {
            XmlAffinityLabelWriter.writeMany(object.vmLabels().iterator(), "affinity_label", "vm_labels", writer);
        }
        if (object.vmsPresent()) {
            XmlVmWriter.writeMany(object.vms().iterator(), "vm", "vms", writer);
        }
        if (object.vmsRulePresent()) {
            XmlAffinityRuleWriter.writeOne(object.vmsRule(), "vms_rule", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<AffinityGroup> list, XmlWriter writer) {
        writeMany(list, "affinity_group", "affinity_groups", writer);
    }
    
    public static void writeMany(Iterator<AffinityGroup> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlAffinityGroupWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

