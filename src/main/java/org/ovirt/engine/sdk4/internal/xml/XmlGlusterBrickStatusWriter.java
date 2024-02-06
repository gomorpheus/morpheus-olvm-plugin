/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterBrickStatus;

public class XmlGlusterBrickStatusWriter {
    
    public static void writeOne(GlusterBrickStatus object, XmlWriter writer) {
        writeOne(object, "gluster_brick_status", writer);
    }
    
    public static void writeOne(GlusterBrickStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<GlusterBrickStatus> list, XmlWriter writer) {
        writeMany(list, "gluster_brick_status", "gluster_brick_statuss", writer);
    }
    
    public static void writeMany(Iterator<GlusterBrickStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterBrickStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

