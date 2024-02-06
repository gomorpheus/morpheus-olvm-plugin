/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.AffinityLabel;

public class XmlAffinityLabelWriter {
    
    public static void writeOne(AffinityLabel object, XmlWriter writer) {
        writeOne(object, "affinity_label", writer);
    }
    
    public static void writeOne(AffinityLabel object, String tag, XmlWriter writer) {
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
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.hasImplicitAffinityGroupPresent()) {
            writer.writeBoolean("has_implicit_affinity_group", object.hasImplicitAffinityGroup());
        }
        if (object.hostsPresent()) {
            XmlHostWriter.writeMany(object.hosts().iterator(), "host", "hosts", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.readOnlyPresent()) {
            writer.writeBoolean("read_only", object.readOnly());
        }
        if (object.vmsPresent()) {
            XmlVmWriter.writeMany(object.vms().iterator(), "vm", "vms", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<AffinityLabel> list, XmlWriter writer) {
        writeMany(list, "affinity_label", "affinity_labels", writer);
    }
    
    public static void writeMany(Iterator<AffinityLabel> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlAffinityLabelWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

