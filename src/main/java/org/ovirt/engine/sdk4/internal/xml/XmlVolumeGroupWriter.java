/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VolumeGroup;

public class XmlVolumeGroupWriter {
    
    public static void writeOne(VolumeGroup object, XmlWriter writer) {
        writeOne(object, "volume_group", writer);
    }
    
    public static void writeOne(VolumeGroup object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.logicalUnitsPresent()) {
            XmlLogicalUnitWriter.writeMany(object.logicalUnits().iterator(), "logical_unit", "logical_units", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VolumeGroup> list, XmlWriter writer) {
        writeMany(list, "volume_group", "volume_groups", writer);
    }
    
    public static void writeMany(Iterator<VolumeGroup> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVolumeGroupWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

