/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskInterface;

public class XmlDiskInterfaceWriter {
    
    public static void writeOne(DiskInterface object, XmlWriter writer) {
        writeOne(object, "disk_interface", writer);
    }
    
    public static void writeOne(DiskInterface object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DiskInterface> list, XmlWriter writer) {
        writeMany(list, "disk_interface", "disk_interfaces", writer);
    }
    
    public static void writeMany(Iterator<DiskInterface> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskInterfaceWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

