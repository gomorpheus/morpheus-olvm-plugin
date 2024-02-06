/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Ksm;

public class XmlKsmWriter {
    
    public static void writeOne(Ksm object, XmlWriter writer) {
        writeOne(object, "ksm", writer);
    }
    
    public static void writeOne(Ksm object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        if (object.mergeAcrossNodesPresent()) {
            writer.writeBoolean("merge_across_nodes", object.mergeAcrossNodes());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Ksm> list, XmlWriter writer) {
        writeMany(list, "ksm", "ksms", writer);
    }
    
    public static void writeMany(Iterator<Ksm> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlKsmWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

