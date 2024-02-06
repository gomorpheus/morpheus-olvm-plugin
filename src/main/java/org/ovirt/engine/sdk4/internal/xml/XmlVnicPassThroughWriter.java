/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VnicPassThrough;

public class XmlVnicPassThroughWriter {
    
    public static void writeOne(VnicPassThrough object, XmlWriter writer) {
        writeOne(object, "vnic_pass_through", writer);
    }
    
    public static void writeOne(VnicPassThrough object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.modePresent()) {
            XmlVnicPassThroughModeWriter.writeOne(object.mode(), "mode", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VnicPassThrough> list, XmlWriter writer) {
        writeMany(list, "vnic_pass_through", "vnic_pass_throughs", writer);
    }
    
    public static void writeMany(Iterator<VnicPassThrough> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVnicPassThroughWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

