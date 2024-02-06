/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterHookStatus;

public class XmlGlusterHookStatusWriter {
    
    public static void writeOne(GlusterHookStatus object, XmlWriter writer) {
        writeOne(object, "gluster_hook_status", writer);
    }
    
    public static void writeOne(GlusterHookStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<GlusterHookStatus> list, XmlWriter writer) {
        writeMany(list, "gluster_hook_status", "gluster_hook_statuss", writer);
    }
    
    public static void writeMany(Iterator<GlusterHookStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterHookStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

