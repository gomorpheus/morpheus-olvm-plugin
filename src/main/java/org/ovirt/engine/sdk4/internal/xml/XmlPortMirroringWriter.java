/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.PortMirroring;

public class XmlPortMirroringWriter {
    
    public static void writeOne(PortMirroring object, XmlWriter writer) {
        writeOne(object, "port_mirroring", writer);
    }
    
    public static void writeOne(PortMirroring object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<PortMirroring> list, XmlWriter writer) {
        writeMany(list, "port_mirroring", "port_mirrorings", writer);
    }
    
    public static void writeMany(Iterator<PortMirroring> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPortMirroringWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

