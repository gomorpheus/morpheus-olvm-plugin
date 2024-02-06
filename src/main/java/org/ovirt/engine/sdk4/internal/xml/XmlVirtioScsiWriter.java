/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VirtioScsi;

public class XmlVirtioScsiWriter {
    
    public static void writeOne(VirtioScsi object, XmlWriter writer) {
        writeOne(object, "virtio_scsi", writer);
    }
    
    public static void writeOne(VirtioScsi object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VirtioScsi> list, XmlWriter writer) {
        writeMany(list, "virtio_scsi", "virtio_scsis", writer);
    }
    
    public static void writeMany(Iterator<VirtioScsi> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVirtioScsiWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

