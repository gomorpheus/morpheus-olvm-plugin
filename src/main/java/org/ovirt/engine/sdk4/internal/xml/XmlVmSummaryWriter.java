/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmSummary;

public class XmlVmSummaryWriter {
    
    public static void writeOne(VmSummary object, XmlWriter writer) {
        writeOne(object, "vm_summary", writer);
    }
    
    public static void writeOne(VmSummary object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.activePresent()) {
            writer.writeInteger("active", object.active());
        }
        if (object.migratingPresent()) {
            writer.writeInteger("migrating", object.migrating());
        }
        if (object.totalPresent()) {
            writer.writeInteger("total", object.total());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VmSummary> list, XmlWriter writer) {
        writeMany(list, "vm_summary", "vm_summaries", writer);
    }
    
    public static void writeMany(Iterator<VmSummary> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmSummaryWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

