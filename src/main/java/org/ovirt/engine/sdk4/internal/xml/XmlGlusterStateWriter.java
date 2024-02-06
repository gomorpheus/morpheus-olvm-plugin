/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterState;

public class XmlGlusterStateWriter {
    
    public static void writeOne(GlusterState object, XmlWriter writer) {
        writeOne(object, "gluster_state", writer);
    }
    
    public static void writeOne(GlusterState object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<GlusterState> list, XmlWriter writer) {
        writeMany(list, "gluster_state", "gluster_states", writer);
    }
    
    public static void writeMany(Iterator<GlusterState> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterStateWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

